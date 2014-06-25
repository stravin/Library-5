package ru.grey.domain.dao;

import ru.grey.domain.model.BaseEntity;

import java.util.Set;

/**
 * Created by stravin on 17.06.2014.
 */
public interface BaseDAO<T extends BaseEntity> {
    void add(T item);
    void save(T item);
    void update(T item);
    void updateAll(T ... items);
    void saveOrUpdate(T item);
    T get(long id);
    Set<T> getAll();
}
