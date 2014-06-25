package ru.grey.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.grey.domain.dao.AuthorDAO;
import ru.grey.domain.model.Author;
import ru.grey.domain.service.AuthorService;

import java.util.Set;

/**
 * Created by stravin on 18.06.2014.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    @Transactional
    public Author findById(long id) {
        return authorDAO.get(id);
    }

    @Override
    @Transactional
    public Set<Author> findAll() {
        return authorDAO.getAll();
    }

    @Override
    @Transactional
    public void addAuthor(Author author) {
        authorDAO.add(author);
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        authorDAO.update(author);
    }
}
