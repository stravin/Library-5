package ru.grey.domain.service;

import ru.grey.domain.model.Author;

import java.util.List;

/**
 * Created by stravin on 18.06.2014.
 */

public interface AuthorService {

    Author findById(long id);
    List<Author> findAll();
    void addAuthor(Author author);
    void updateAuthor(Author author);
}
