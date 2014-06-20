package ru.grey.domain.service;

import ru.grey.domain.model.Genre;

/**
 * Created by stravin on 18.06.2014.
 */

public interface GenreService {

    Genre findById(Class<Genre> aClass, long id);
}
