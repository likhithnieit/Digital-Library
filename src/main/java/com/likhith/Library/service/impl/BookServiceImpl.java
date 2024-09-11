package com.likhith.Library.service.impl;

import com.likhith.Library.domain.Book;
import com.likhith.Library.domain.Review;
import com.likhith.Library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookServiceImpl implements BookService {
    List<Book> bookList = new ArrayList<>();
    @Override
    public void addBook(Book book){
        Integer id = new Random().nextInt(1000,9999);
        book.setId(String.valueOf(id));
        bookList.add(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookList;
    }

    @Override
    public Book getBook(String id) {
        int index = -1;
        for(int i = 0;i < bookList.size(); i++){
            if(bookList.get(i).getId().equals(id)) index = i;
        }
        if (index != -1) return bookList.get(index);

        return null;
    }

    @Override
    public Book updateBook(String id, Book book) {
        int index = -1;
        for(int i = 0;i < bookList.size(); i++){
            if (bookList.get(i).getId().equals(id)) index = i;
        }
        if(index != -1) bookList.set(index,book);

        return bookList.get(index);
    }

    @Override
    public void addReview(String bookId, Review review) {
        int index = -1;
        for(int i = 0;i < bookList.size(); i++){
            if (bookList.get(i).getId().equals(bookId)) index = i;
        }
        if (index != -1){
            if(bookList.get(index).getReviewList() == null){
                List<Review> r = new ArrayList<>();
                r.add(review);
                bookList.get(index).setReviewList(r);
            }else {
                bookList.get(index).getReviewList().add(review);
            }
        }
    }

    @Override
    public void deleteBook(String id) {
        int index = -1;
        for(int i = 0;i < bookList.size(); i++){
            if (bookList.get(i).getId().equals(id)) index = i;
        }
        if(index != -1) bookList.remove(index);
    }
    @Override
    public List<Review> getReviews(String id){
        int index = -1;
        for(int i = 0;i < bookList.size(); i++){
            if (bookList.get(i).getId().equals(id)) index = i;
        }
        return bookList.get(index).getReviewList();
    }
}
