package ru.grey.domain.dao.impl;

import org.springframework.stereotype.Repository;
import ru.grey.domain.dao.BookDAO;
import ru.grey.domain.model.Book;

/**
 * Created by stravin on 18.06.2014.
 */
@Repository
public class BookDAOImpl extends BaseDAOImpl<Book> implements BookDAO {

    public BookDAOImpl() {
        super(Book.class);
    }
}
