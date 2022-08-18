package com.citiustech.problem4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		
		//Max
		Query q1 = session.createQuery("SELECT MAX(revenueDollers) FROM Movie");
		System.out.println("\nMAX revenue --> " + q1.list() + "\n");
		

		// Min
		Query q2 = session.createQuery("SELECT MIN(revenueDollers) FROM Movie");
		System.out.println("\nMIN revenue --> " + q2.list() + "\n");

		// Sum
		Query q3 = session.createQuery("SELECT SUM(revenueDollers) FROM Movie");
		System.out.println("\nSUM revenue --> " + q3.list() + "\n");

		// AVG
		Query q4 = session.createQuery("SELECT AVG(revenueDollers) FROM Movie");
		System.out.println("\nAVG revenue In Dollars --> " + q4.list() + "\n");

		// COUNT
		String language = "Telugu";
		Query q5 = session.createQuery("SELECT COUNT(*) FROM Movie where language=:lan");
		q5.setParameter("lan", language);
		System.out.println("\ncount -->  " + q5.list() + "\n");

		// Group By
		Query q6 = session.createQuery("SELECT COUNT(*) FROM Movie m GROUP BY m.language");
		System.out.println(q6.list() + "\n");
	}
}
