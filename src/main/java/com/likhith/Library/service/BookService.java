package com.likhith.Library.service;

import com.likhith.Library.domain.Book;
import com.likhith.Library.domain.Review;

import java.util.List;

public interface BookService {
    public void addBook(Book book);

    public List<Book> getAllBooks();

    public Book getBook(String id);
    public void  deleteBook(String id);
    public Book updateBook(String id, Book book);

    public void addReview(String id, Review review);

    public List<Review> getReviews(String id);
}
