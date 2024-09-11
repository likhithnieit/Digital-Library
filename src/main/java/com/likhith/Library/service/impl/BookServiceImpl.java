package com.likhith.Library.service.impl;

import com.likhith.Library.domain.Book;
import com.likhith.Library.domain.Review;
import com.likhith.Library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {
    Map<String,Book> bookMap = new HashMap<>();
    @Override
    public void addBook(Book book){
        book.setId(String.valueOf(new Random().nextInt(1000,9999)));
        bookMap.put(book.getId(),book);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookMap.values());
    }

    @Override
    public Book getBook(String id) {
        Book book = bookMap.getOrDefault(id,null);
        return book;
    }

    @Override
    public Book updateBook(String id, Book book) {
        if (bookMap.containsKey(id)) {
            bookMap.put(id, book);
        }
        return book;
    }

    @Override
    public void addReview(String bookId, Review review) {
        Book book = bookMap.getOrDefault(bookId,null);
        if(book != null){
            if(book.getReviewList() == null){
                List<Review> r = new ArrayList<>();
                r.add(review);
                book.setReviewList(r);
            }else{
                book.getReviewList().add(review);
            }
        }
        bookMap.put(bookId,book);
    }

    @Override
    public void deleteBook(String id) {
        bookMap.remove(id);
    }
    @Override
    public List<Review> getReviews(String id){
        Book book = bookMap.getOrDefault(id,null);
        if (book != null){
            return book.getReviewList();
        }
        return null;
    }
}
