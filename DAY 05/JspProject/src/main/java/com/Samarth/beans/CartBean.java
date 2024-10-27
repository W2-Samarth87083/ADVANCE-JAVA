package com.Samarth.beans;

import java.util.ArrayList;
import java.util.List;

import com.Samarth.dataaccess.BookDataAccess;
import com.Samarth.entities.Book;

public class CartBean {
	private String[] bookId;
	private List<Book> bkList;

	public CartBean() {
		bkList = new ArrayList<Book>();
	}

	public String[] getBookId() {
		return bookId;
	}

	public List<Book> getBkList() {
		return bkList;
	}

	public void setBookId(String[] bookId) {
		this.bookId = bookId;
	}

	public void setBkList(List<Book> bkList) {
		this.bkList = bkList;
	}

	public boolean addToCart() {
		try (BookDataAccess obj = new BookDataAccess()) {
			for (String str : bookId) {
				int id = Integer.parseInt(str);
				Book bk = obj.findById(id);
				bkList.add(bk);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
