package com.hombre.db.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hombre.db.bo.BookBo;
import com.hombre.db.dao.BookDao;
import com.hombre.db.model.Book;

@Service
public class BookBoImpl implements BookBo {

	@Autowired
	private BookDao bookDao;

	@Transactional
	public void setUserDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Transactional
	public void save(Book book) {
		bookDao.save(book);
	}

	@Transactional
	public void update(Book book) {
		bookDao.update(book);
	}

	@Transactional
	public void delete(Book book) {
		bookDao.delete(book);
	}

	@Transactional
	public List<Book> listBookById(int id) {
		return bookDao.listBookById(id);
	}

	@Transactional
	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

}
