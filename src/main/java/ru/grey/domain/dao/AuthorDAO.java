package ru.grey.domain.dao;

import ru.grey.domain.model.Author;

/**
 * Created by stravin on 17.06.2014.
 */
public interface AuthorDAO extends BaseDAO<Author> {

    Author getByFio(String value);
}
