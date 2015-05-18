package com.li.HibernateExample;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

	private static Session session;
	private static Transaction tx;
	
	public static void main(String[] args) {

		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		hbInsert();
		
		String hql = "FROM User";
		hbQuery(hql);
		
		// end the program
		HibernateUtil.getSessionFactory().close();
	}

	// insert records to db
	public static void hbInsert() {
		
		try {
			User user = new User();
			user.setUserId(10); 
			user.setUsername("Jack");
			user.setCreatedBy("System"); 
			user.setCreatedDate(new Date());
			 
			session.save(user); 
			tx.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			tx.rollback(); // rolling back to save the test data
		}
	}
	
	// display records from db
	public static void hbQuery(String hql) {

		try {
			Query query = session.createQuery(hql);
			List<User> results = query.list();

			for (User u : results) {
				System.out.println("List of Users: " + u.getUserId() + ","
						+ u.getUsername() + "," + u.getCreatedBy() + "," + u.getCreatedDate());
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			tx.rollback(); // rolling back to save the test data
		} finally {
			// closing hibernate resources
			session.close();
		}
	}
}
