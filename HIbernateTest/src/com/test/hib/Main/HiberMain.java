package com.test.hib.Main;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

// import com.fasterxml.classmate.AnnotationConfiguration;
import com.test.hib.LogDB;

public class HiberMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar c=Calendar.getInstance();		

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		LogDB logdb = new LogDB();
/*		
//		logdb.setId(1);
		logdb.setDate(c.getTime());
		logdb.setMsg("test from hibernate");
		logdb.setUsername("Hibernate");		
		session.save(logdb);
*/		
		String hql = "FROM LogDB";
		Query query = session.createQuery(hql);
		List<LogDB> l = query.list();
		System.out.println("Before out result");
		for (LogDB cnt : l)
		{
			System.out.println(cnt.getId() + " " + cnt.getMsg() + " " + cnt.getUsername() + " " + cnt.getDate());
		}
		
			
		
		session.getTransaction().commit();
		sessionFactory.close();
	}

}
