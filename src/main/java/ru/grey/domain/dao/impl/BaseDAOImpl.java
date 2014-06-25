package ru.grey.domain.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.grey.domain.dao.BaseDAO;
import ru.grey.domain.model.BaseEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by stravin on 17.06.2014.
 */
@Repository
public abstract class BaseDAOImpl<T extends BaseEntity> implements BaseDAO<T> {

    private Class<T> type;

    public BaseDAOImpl(Class<T> type) {
        this.type = type;
    }

    protected BaseDAOImpl() {
    }

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public void add(T item) {
        getSession().save(item);
    }

    @Override
    public void save(T item) {
        getSession().save(item);
    }

    @Override
    public void update(T item) {
        getSession().merge(item);
    }

    @Override
    public void saveOrUpdate(T item) {
        getSession().saveOrUpdate(item);
    }

    public void updateAll(T ... items){
        for (T t : items){
            getSession().saveOrUpdate(t);
        }
    }

    @Override
    public T get(long id) {
        return (T) getSession().get(type, id);
    }

    @Override
    public Set<T> getAll() {
        return new HashSet<T>(getSession().createQuery("from " + this.type.getSimpleName()).list());
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
