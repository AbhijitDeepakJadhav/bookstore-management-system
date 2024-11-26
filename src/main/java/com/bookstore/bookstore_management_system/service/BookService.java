package com.bookstore.bookstore_management_system.service;

import com.bookstore.bookstore_management_system.rest.model.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {
    UUID createBook(Book book);
    Book getBookById(UUID id);
    List<Book> getAllBooks();
    Book updateBook(UUID id, Book book);
}
