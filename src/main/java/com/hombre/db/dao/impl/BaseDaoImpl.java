package com.hombre.db.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.hombre.db.dao.BaseDao;
import com.hombre.db.dao.CustomHibernateDaoSupport;

public class BaseDaoImpl<T, ID extends Serializable> extends CustomHibernateDaoSupport implements BaseDao<T, ID> {

    protected Class<T> persistentClass;

    public BaseDaoImpl() {}


    protected BaseDaoImpl(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Override
    public void update(T entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public void save(T entity) {
        getHibernateTemplate().save(entity);
    }

    @Override
    public void remove(T entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public void refresh(T entity) {
        getHibernateTemplate().refresh(entity);
    }

    @Override
    public List<T> getAll() {
        return getHibernateTemplate().execute(new HibernateCallback<List<T>>() {

            @Override
            @SuppressWarnings("unchecked")
            public List<T> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery("FROM " + persistentClass.getName());
                return query.list();
            }
        });
    }

    @Override
    public T getByID(final ID id) {
        return getHibernateTemplate().execute(new HibernateCallback<T>() {

            @Override
            @SuppressWarnings("unchecked")
            public T doInHibernate(Session session) throws HibernateException {
                return (T)session.get(persistentClass, id);
            }
        });
    }

    @Override
    public T merge(T entity) {
        return getHibernateTemplate().merge(entity);
    }

    protected Class<T> getPersistentClass() {
        return persistentClass;
    }
}
