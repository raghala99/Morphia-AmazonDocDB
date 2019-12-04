package com.test.models;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("book")
public class Book {
	@Id
	private String isbn;
	private String title;
	private String author;
	private double cost;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String isbn, String title, String author, double cost) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.cost = cost;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
