package com.hombre.db.bo;

import com.hombre.db.model.Book;

public interface BookBo {
	void save(Book book);

	void update(Book book);

	void delete(Book book);

	Book getBookById(int id);

}
