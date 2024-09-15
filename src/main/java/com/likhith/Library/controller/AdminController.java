package com.likhith.Library.controller;

import com.likhith.Library.domain.Book;
import com.likhith.Library.service.BookService;
import com.likhith.Library.service.Resources.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    BookService bookService;
    @PostMapping("/admin/book")
    public ResponseEntity<Book> createBook(@RequestBody BookRequest bookRequest){
        bookService.addBook(bookRequest.getBook());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/admin/book")
    public ResponseEntity<Book> updateBook(@RequestParam("bookId") Integer id,@RequestBody BookRequest bookRequest){
        return new ResponseEntity<>(bookService.updateBook(id, bookRequest.getBook()),HttpStatus.OK);
        //how are we able to call getBook method even though it is not static method
    }

    @DeleteMapping("/admin/book")
    public ResponseEntity deleteBook(@RequestParam Integer id){
        bookService.deleteBook(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
