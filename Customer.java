package com.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
//@Table(name = "customer")

  @NamedQuery( name = "CustByid", query = "select e from Customer e " +
  "where e.id = :customerid OR :customerid IS -1 " )

//@DiscriminatorValue("Customer")
public class Customer extends User implements Serializable {

	private String unversityName;
//	//@Embedded
//	private Books borrwedBook;
	@OneToMany(mappedBy = "cust")
	private Collection<Books> book = new ArrayList<Books>();

	public Customer() {

	}

	public Collection<Books> getBook() {
		return book;
	}

	public void setBook(Collection<Books> book) {
		this.book = book;
	}

	public String getUnversityName() {
		return unversityName;
	}

	public void setUnversityName(String unversityName) {
		this.unversityName = unversityName;
	}

	public String toStringCust() {
		return "Customer [unversityName=" + unversityName + ", book=" + book + "]";
	}
	

}
