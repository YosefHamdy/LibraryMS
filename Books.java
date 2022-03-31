package com.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@NamedQuery(name = "BookInfoFetch", 
		query = "select e from Books e " 
			+ "where e.bookId = :bookId OR :bookId IS -1 "
			

)
public class Books implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	private String bookName;
	private String bookDetails;
	private String publisherName;
	@ManyToMany
	private Collection<Publisher> publiherList = new ArrayList<Publisher>();


	
	//@JoinTable(name = "BooksToCustomer", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = { @JoinColumn(name = "name") })
	@ManyToOne
	@JoinColumn(name = "Customerid", referencedColumnName = " id") 
	private Customer cust;

//add
//update
//	@ManyToOne
//	@JoinColumn(name = "id")
//	private Customer customer;
//	

	public String getPublisherName() {
		return publisherName;
	}

	public Collection<Publisher> getPubliherList() {
		return publiherList;
	}

	public void setPubliherList(Collection<Publisher> publiherList) {
		this.publiherList = publiherList;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(String bookDetails) {
		this.bookDetails = bookDetails;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookName=" + bookName + ", bookDetails=" + bookDetails
				+ ", publisherName=" + publisherName + ", cust=" + cust + "]";
	}
	

}
