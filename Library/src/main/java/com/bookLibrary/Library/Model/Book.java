package com.bookLibrary.Library.Model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private long bookId;

	@Column(name = "book_Name")
	private String name;

	@Column(name = "avail_status")
	private boolean avalability;

	@Column(name = "book_author")
	private String author;

	public Book() {
		super();
	}

	public Book(long bookId, String name, boolean avalability, String author) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.avalability = avalability;
		this.author = author;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAvalability() {
		return avalability;
	}

	public void setAvalability(boolean avalability) {
		this.avalability = avalability;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", avalability=" + avalability + ", author=" + author
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, avalability, bookId, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && avalability == other.avalability && bookId == other.bookId
				&& Objects.equals(name, other.name);
	}

}