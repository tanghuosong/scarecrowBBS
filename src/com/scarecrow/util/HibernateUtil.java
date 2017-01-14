package com.scarecrow.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory   sessionFactory=null;
	
	private HibernateUtil(){
	
	}
	static{
		Configuration  configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	
	public static Session getSession(){
		if(sessionFactory==null){
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		}
		Session session = sessionFactory.openSession();
		return session;
	}
}
