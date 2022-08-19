package com.nagarro.clientapp.service;
import java.sql.Date;


public class Book {

	private Long id;
	private int bookcode;
	private String bookname;
	private String author;
	private Date dateadded;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book() {
		super();
	}
	
	

	public Book(Long id, int bookcode, String bookname, String author, Date dateadded) {
		super();
		this.id = id;
		this.bookcode = bookcode;
		this.bookname = bookname;
		this.author = author;
		this.dateadded = dateadded;
	}

	public Book(int bookcode, String bookname, String author, Date dateadded) {
		super();
		this.bookcode = bookcode;
		this.bookname = bookname;
		this.author = author;
		this.dateadded = dateadded;
	}



	public int getBookcode() {
		return bookcode;
	}



	public void setBookcode(int bookcode) {
		this.bookcode = bookcode;
	}



	public String getBookname() {
		return bookname;
	}



	public void setBookname(String bookname) {
		this.bookname = bookname;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public Date getDateadded() {
		return dateadded;
	}

	public String getDateaddedString() {
		return dateadded.toString();
	}


	public void setDateadded(Date dateadded) {
		this.dateadded = dateadded;
	}



	@Override
	public String toString() {
		return "books [bookcode=" + bookcode + ", bookname=" + bookname + ", author=" + author + ", dateadded="
				+ dateadded + "]";
	}
	
}



