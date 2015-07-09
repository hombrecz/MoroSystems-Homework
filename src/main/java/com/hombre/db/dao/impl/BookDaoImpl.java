package com.hombre.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.hombre.db.dao.BookDao;
import com.hombre.db.model.Book;

@Repository
public class BookDaoImpl extends BaseDaoImpl<Book, Long> implements BookDao{
}
