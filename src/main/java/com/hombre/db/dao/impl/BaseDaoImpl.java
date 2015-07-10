package com.hombre.db.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hombre.db.dao.BaseDao;
import com.hombre.db.dao.CustomHibernateDaoSupport;

public class BaseDaoImpl<T, ID extends Serializable> extends CustomHibernateDaoSupport implements BaseDao<T, ID> {

    protected Class<T> persistentClass;

    public BaseDaoImpl() {}

    protected BaseDaoImpl(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public void update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public void save(T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public void remove(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public void refresh(T entity) {
        sessionFactory.getCurrentSession().refresh(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from "+persistentClass.getName()).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public T getByID(final Integer id) {
        return (T)sessionFactory.getCurrentSession().get(persistentClass.getName(), id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T merge(T entity) {
        return (T)sessionFactory.getCurrentSession().merge(entity);
    }

    protected Class<T> getPersistentClass() {
        return persistentClass;
    }
}
