package com.likhith.Library.controller;

import com.likhith.Library.domain.Book;
import com.likhith.Library.domain.Review;
import com.likhith.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Book> getBook(@PathVariable("id") Integer id){
        Book t = bookService.getBook(id);
        if(t==null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(t,HttpStatus.OK);
    }

    @PostMapping("/{bookId}/review")
    public ResponseEntity addReview(@PathVariable("bookId") String bookId,@RequestBody Review review){
        bookService.addReview(bookId,review);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping("/{bookId}/review")
    public ResponseEntity<List<Review>> getReviews(@PathVariable("bookId") String bookId){
        return new ResponseEntity(bookService.getReviews(bookId),HttpStatus.OK);
    }

}
