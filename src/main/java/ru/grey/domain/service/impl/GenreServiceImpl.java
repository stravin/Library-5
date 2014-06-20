package ru.grey.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.grey.domain.dao.GenreDAO;
import ru.grey.domain.model.Genre;
import ru.grey.domain.service.GenreService;

/**
 * Created by stravin on 18.06.2014.
 */
@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreDAO genreDAO;

    @Override
    @Transactional
    public Genre findById(Class<Genre> aClass, long id){
        return genreDAO.get(id);
    }
}
