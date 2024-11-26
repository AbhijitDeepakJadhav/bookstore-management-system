package com.bookstore.bookstore_management_system.rest.controller;

import com.bookstore.bookstore_management_system.rest.model.Book;
import com.bookstore.bookstore_management_system.rest.model.BookResponse;
import com.bookstore.bookstore_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class GraphQLBookContoller {

    @Autowired
    private BookService bookService;

    @MutationMapping("createBook")
    public String createBook(@Argument Book book) {
        return bookService.createBook(book).toString();
    }

    @QueryMapping("getBookById")
    public Book getBookById(@Argument String id) {
        return bookService.getBookById(UUID.fromString(id));
    }

//    @GetMapping("getListOfBooks")
//    public List<BookResponse> getListOfBooks(@RequestBody List<UUID> bookIds) {
//        return null;
//    }

    @QueryMapping("getAllBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @MutationMapping("updateBook")
    public Book updateBook(@Argument String id, @Argument Book book) {
        return bookService.updateBook(UUID.fromString(id), book);
    }

//    @DeleteMapping("/deleteBook/{id}")
//    public BookResponse deleteBook(@PathVariable Integer id) {
//        return null;
//    }
}
