package com.citiustech;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.citiustech.entity.Customer;
import com.citiustech.entity.Locker;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sf.openSession();

		session.beginTransaction();

		Customer c1 = new Customer();
		c1.setCutsomerName("Mustaq");
		c1.setDateOfBirth(LocalDate.of(1996, 06, 8));
		c1.setPhoneNo("123456");
		c1.setAddress("Bangalore");
		
		Locker l1 = new Locker();
		l1.setLockerTYpe("small");
		l1.setRent(1100);
		
		c1.setLocker(l1);
		
		session.save(c1);

		session.getTransaction().commit();

		session.close();
	}
}
