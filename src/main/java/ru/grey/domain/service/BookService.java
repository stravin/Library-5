package ru.grey.domain.service;

import ru.grey.domain.model.Book;

import java.util.Set;

/**
 * Created by stravin on 18.06.2014.
 */

public interface BookService {

    Book findById(long id);
    Set<Book> findAll();
    void addBook(Book book);
    void updateBook(Book book);
}
