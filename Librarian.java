package com.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
//@DiscriminatorValue("Librarian")
public class Librarian extends User implements Serializable {

	private String department;
//enable user
//disable user
	@OneToMany
	@JoinTable(name = "ADDED_Clients", joinColumns = @JoinColumn(name = "LIB_ID"), inverseJoinColumns = @JoinColumn(name = "NEWCLIENT_ID"))
	private Collection<Customer> cust = new ArrayList<Customer>();
	@OneToMany
	@JoinTable(name = "ADDED_BOOKS", joinColumns = @JoinColumn(name = "LIB_ID"), inverseJoinColumns = @JoinColumn(name = "ADDED_BOOK_ID"))
	private Collection<Books> book = new ArrayList<Books>();
	@OneToMany
	@JoinTable(name = "ADDED_Publishers", joinColumns = @JoinColumn(name = "LIB_ID"), inverseJoinColumns = @JoinColumn(name = "NEWPUBLISHER_ID"))
	private Collection<Publisher> publihser = new ArrayList<Publisher>();
	public Librarian() {

	}

	public Collection<Publisher> getPublihser() {
		return publihser;
	}

	public void setPublihser(Collection<Publisher> publihser) {
		this.publihser = publihser;
	}

	public Collection<Books> getBook() {
		return book;
	}

	public void setBook(Collection<Books> book) {
		this.book = book;
	}

	public Collection<Customer> getCust() {
		return cust;
	}

	public void setCust(Collection<Customer> cust) {
		this.cust = cust;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
