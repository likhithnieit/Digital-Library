package com.likhith.Library.service.impl;

import com.likhith.Library.Repository.BookRepository;
import com.likhith.Library.domain.Book;
import com.likhith.Library.domain.Review;
import com.likhith.Library.service.BookService;
import com.likhith.Library.service.Resources.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {
    Map<String,Book> bookMap = new HashMap<>();

    @Autowired
    BookRepository bookRepository;
    @Override
    public void addBook(Book book){
        book.setRating(0.0);
        bookRepository.save(book); //insert into book where id = book.id;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book updateBook(Integer id, Book book) {
        Book book1 = bookRepository.findById(id).orElse(null);
        if (book1 != null) {
            book1 = book1.builder().id(book1.getId()).rating(book1.getRating()).title(book.getTitle())
                    .author(book.getAuthor()).cost(book.getCost()).year(book.getYear())
                    .genre(book.getGenre()).build();
            bookRepository.save(book1);
        }
        return book1;
    }

    @Override
    public void addReview(String bookId, Review review) {
//        Book book = bookMap.getOrDefault(bookId,null);
//        if(book != null){
//            if(book.getReviewList() == null){
//                List<Review> r = new ArrayList<>();
//                r.add(review);
//                book.setReviewList(r);
//            }else{
//                book.getReviewList().add(review);
//            }
//        }
//        bookMap.put(bookId,book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
    @Override
    public List<Review> getReviews(String id){
//        Book book = bookMap.getOrDefault(id,null);
//        if (book != null){
//            return book.getReviewList();
//        }
        return null;
    }

}
