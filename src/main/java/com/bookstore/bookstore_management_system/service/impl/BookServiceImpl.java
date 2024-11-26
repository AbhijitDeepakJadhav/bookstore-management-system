package com.bookstore.bookstore_management_system.service.impl;

import com.bookstore.bookstore_management_system.exception.BookNotFoundException;
import com.bookstore.bookstore_management_system.repository.BookRepository;
import com.bookstore.bookstore_management_system.rest.model.Book;
import com.bookstore.bookstore_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.jayway.jsonpath.JsonPath;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public UUID createBook(Book book) {
        Book result = bookRepository.save(book);
        return result.getId();
    }

    @Override
    public Book getBookById(UUID id) {
        Optional<Book> result = bookRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }
        else {
            throw new BookNotFoundException("Book not found for id " + id.toString());
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(UUID id, Book book) {
        Book bookToUpdate = bookRepository.findById(id).orElse(null);
        if (bookToUpdate==null) {
            throw new BookNotFoundException("Book not found for id: "+id.toString());
        }
        book.setId(id);
        return bookRepository.save(book);
    }

    public static void main(String[] args) {
        String json = "{ \"parties\": [ { \"id\": \"1\", \"role\": \"ttee1\", \"relatedParties\": [{ \"id\": \"55\", \"sig\": true }, { \"id\": \"56\", \"sig\": true }, { \"id\": \"57\", \"sig\": true }, { \"id\": \"58\", \"sig\": true }] }, { \"id\": \"2\", \"role\": \"ttee2\", \"relatedParties\": [{ \"id\": \"59\", \"sig\": false }, { \"id\": \"52\", \"sig\": true }, { \"id\": \"53\", \"sig\": true }] } ] }";

        // JSONPath expression to count related parties for ttee2 with sig == true
        int count = JsonPath.parse(json)
                .read("$.parties[?(@.role == 'ttee2')].relatedParties.length()");

        System.out.println("Number of related parties for ttee2 with sig == true: " + count);
    }

}
