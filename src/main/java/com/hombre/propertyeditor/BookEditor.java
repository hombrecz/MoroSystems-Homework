package com.hombre.propertyeditor;

import java.beans.PropertyEditorSupport;

import com.hombre.db.bo.BookBo;
import com.hombre.db.model.Book;

public class BookEditor extends PropertyEditorSupport {

	private final BookBo bookBo;

	public BookEditor(BookBo bookBo) {
		this.bookBo = bookBo;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(bookBo.getBookById(Integer.parseInt(text)));
	}

	@Override
	public String getAsText() {
		Book b = (Book) getValue();
		if (b == null) {
			return null;
		} else {
			return b.getId().toString();
		}
	}
}
