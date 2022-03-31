package com.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery( name = "PubByid", query = "select e from Publisher e " +
"where e.id = :publisherid OR :publisherid IS -1 " )
public class Publisher extends User implements Serializable {

	private String department;
	@ManyToMany
	private Collection<Books> book = new ArrayList<Books>();
	
	public Collection<Books> getBook() {
		return book;
	}

	public void setBook(Collection<Books> book) {
		this.book = book;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String toStringPub() {
		return "Publisher [department=" + department + ", book=" + book + "]";
	}

}
