package com.bookstore.bookstore_management_system.rest.model;

import lombok.Data;

@Data
public class BookResponse {
    private Integer id;
    private String title;
    private String author;
    private Double price;
    private Integer quantity;
}
