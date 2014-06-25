package ru.grey.domain.service;

import ru.grey.domain.model.Genre;

import java.util.Set;

/**
 * Created by stravin on 18.06.2014.
 */

public interface GenreService {

    Genre findById(long id);
    Set<Genre> findAll();
    void addGenre(Genre genre);
    void updateGenre(Genre genre);
}
