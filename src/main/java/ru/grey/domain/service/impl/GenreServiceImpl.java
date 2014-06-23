package ru.grey.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.grey.domain.dao.GenreDAO;
import ru.grey.domain.model.Genre;
import ru.grey.domain.service.GenreService;

import java.util.List;

/**
 * Created by stravin on 18.06.2014.
 */
@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreDAO genreDAO;

    @Override
    @Transactional
    public Genre findById(long id) {
        return genreDAO.get(id);
    }

    @Override
    @Transactional
    public List<Genre> findAll() {
        return genreDAO.getAll();
    }

    @Override
    @Transactional
    public void addGenre(Genre genre) {
        genreDAO.add(genre);
    }

    @Override
    @Transactional
    public void updateGenre(Genre genre) {
        genreDAO.update(genre);
    }
}
