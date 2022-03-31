package com.library;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

//It makes storing and sending objects easy. It has nothing to do with security.
public class App implements Serializable {

	public static void main(String[] args) {
		getBookDetailsById();
		getCustomerById();
		getPublisherById();
//		Books b = new Books();
//		b.setBookName("Bo");
//		
//		Customer cust = new Customer();
//		cust.setName("custobe");
//		cust.getBook().add(b);
//		
//		b.setCust(cust);

		/*
		 * List<Books> book = (List<Books>) query.list(); for (Books u : book) {
		 * System.out.println(u.getBookName()); }
		 */
	}

	public static void getBookDetailsById() {
		int bookId = 1;
		Session session = null;

		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query<Books> query = session.getNamedQuery("BookInfoFetch");
			query.setParameter("bookId", bookId);
			if (bookId != -1) {
				System.out.println("Book Details -----------------------------");
				Books book = query.uniqueResult();
				System.out.println(book);
				
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		session.close();
	}

	public static void getCustomerById() {
		int customerid = 2;
		Session session = null;

		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query<Customer> query = session.getNamedQuery("CustByid");
			query.setParameter("customerid", customerid);
			if (customerid != -1) {
				System.out.println("Customer Details-----------------");
				Customer cust = query.uniqueResult();
				System.out.println(cust.toStringCust());
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		session.close();
	}

	public static void getPublisherById() {
		int publisherid = 25;
		Session session = null;

		try {
			// Assign data to seprate MtoM table"books_publisher"
			Books nbook = new Books();
			nbook.setBookName("New book by pub1");
			nbook.setBookDetails("Book");
			Publisher pub = new Publisher();
			pub.setName("pub1");
			pub.setDepartment("Dp1");
			nbook.getPubliherList().add(pub);

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(pub);
			session.save(nbook);
			Query<Publisher> query = session.getNamedQuery("PubByid");
			query.setParameter("publisherid", publisherid);
			if (publisherid != -1) {
				System.out.println("Puplisher Details -----------------------");
				Publisher publisher = query.uniqueResult();
				System.out.println(publisher.toStringPub());
			}
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		session.close();
	}
}
