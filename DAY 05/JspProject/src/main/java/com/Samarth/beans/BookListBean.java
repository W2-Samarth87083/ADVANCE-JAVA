package com.Samarth.beans;

import java.util.ArrayList;
import java.util.List;

import com.Samarth.dataaccess.BookDataAccess;
import com.Samarth.entities.Book;

public class BookListBean {
	private List<Book> books;

	public BookListBean() {
		books = new ArrayList<Book>();
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void fetchBooks() {
		try (BookDataAccess obj = new BookDataAccess()) {
			List<Book> list = obj.findAll();
			for (Book bk : list) {
				books.add(bk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}