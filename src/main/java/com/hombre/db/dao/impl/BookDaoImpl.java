package com.hombre.db.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hombre.db.dao.BookDao;
import com.hombre.db.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Book book) {
		sessionFactory.getCurrentSession().save(book);
	}

	public void update(Book book) {
		sessionFactory.getCurrentSession().update(book);
	}

	public void delete(Book book) {
		sessionFactory.getCurrentSession().delete(book);
	}

	@SuppressWarnings("unchecked")
	public List<Book> listBookById(int id) {
		List<Book> books = (List<Book>) sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT * FROM books WHERE \"userid\" = " + id)
				.addEntity(Book.class).list();

		return books;
	}

	public Book getBookById(int id) {
		Book book = (Book) sessionFactory.getCurrentSession().get(Book.class,
				id);
		return book;
	}

}
