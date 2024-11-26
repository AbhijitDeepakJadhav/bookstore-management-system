package com.bookstore.bookstore_management_system.rest.controller;

import com.bookstore.bookstore_management_system.rest.model.Book;
import com.bookstore.bookstore_management_system.rest.model.BookResponse;
import com.bookstore.bookstore_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "bms/v1")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/createBook")
    public UUID createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("/getBook/{id}")
    public Book getBookById(@PathVariable UUID id) {
        return bookService.getBookById(id);
    }

    @GetMapping("getListOfBooks")
    public List<BookResponse> getListOfBooks(@RequestBody List<UUID> bookIds) {
        return null;
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping("/updateBook")
    public BookResponse updateBook(@RequestBody Book book) {
        return null;
    }

    @DeleteMapping("/deleteBook/{id}")
    public BookResponse deleteBook(@PathVariable Integer id) {
        return null;
    }
}
