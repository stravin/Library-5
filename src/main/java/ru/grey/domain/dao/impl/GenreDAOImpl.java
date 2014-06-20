package ru.grey.domain.dao.impl;

import org.springframework.stereotype.Repository;
import ru.grey.domain.dao.GenreDAO;
import ru.grey.domain.model.Genre;

/**
 * Created by stravin on 18.06.2014.
 */
@Repository
public class GenreDAOImpl extends BaseDAOImpl<Genre> implements GenreDAO {

    public GenreDAOImpl() {
        super(Genre.class);
    }
}
