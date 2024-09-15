package com.likhith.Library.service;

import com.likhith.Library.domain.Book;
import com.likhith.Library.domain.Review;
import com.likhith.Library.service.Resources.BookRequest;

import java.util.List;
import java.util.Map;

public interface BookService {
    public void addBook(Book book);

    public List<Book> getAllBooks();

    public Book getBook(Integer id);
    public void  deleteBook(Integer id);
    public Book updateBook(Integer id, Book book);

    public void addReview(String id, Review review);

    public List<Review> getReviews(String id);
}
