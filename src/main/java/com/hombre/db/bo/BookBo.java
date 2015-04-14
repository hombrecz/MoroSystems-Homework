package com.hombre.db.bo;

import java.util.List;

import com.hombre.db.model.Book;

public interface BookBo {
	void save(Book book);

	void update(Book book);

	void delete(Book book);

	List<Book> listBookById(int id);

	Book getBookById(int id);

}
