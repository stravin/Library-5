package ru.grey.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.grey.domain.dao.AuthorDAO;
import ru.grey.domain.dao.BookDAO;
import ru.grey.domain.model.Author;
import ru.grey.domain.model.Book;
import ru.grey.domain.service.BookService;

import java.util.Set;

/**
 * Created by stravin on 18.06.2014.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    @Transactional
    public Book findById(long id) {
        return bookDAO.get(id);
    }

    @Override
    @Transactional
    public Set<Book> findAll() {
        return bookDAO.getAll();
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        bookDAO.add(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookDAO. update(book);
    }
}
