package com.likhith.Library.controller;

import com.likhith.Library.domain.Book;
import com.likhith.Library.domain.Review;
import com.likhith.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    BookService bookService;
    @GetMapping("/book")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") String id){
        return new ResponseEntity<>(bookService.getBook(id),HttpStatus.OK);
    }

    @PostMapping("/{bookId}/review")
    public ResponseEntity addReview(@PathVariable("bookId") String bookId, Review review){
        bookService.addReview(bookId,review);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
