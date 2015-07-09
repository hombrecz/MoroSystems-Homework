package com.hombre.db.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, ID extends Serializable> {

    void save(T entity);
    void update(T entity);
    void remove(T entity);
    void refresh(T entity);
    T merge(T entity);

    List<T> getAll();

    T getByID(ID id);

}