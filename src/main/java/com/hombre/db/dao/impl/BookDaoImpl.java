package com.hombre.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hombre.db.dao.BookDao;
import com.hombre.db.model.Book;

@Repository
public class BookDaoImpl extends BaseDaoImpl<Book, Long> implements BookDao{
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Book> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from books").list();
    }

    @Override
    public Book getByID(final Integer id) {
        return (Book)sessionFactory.getCurrentSession().get(Book.class, id);
    }
}
