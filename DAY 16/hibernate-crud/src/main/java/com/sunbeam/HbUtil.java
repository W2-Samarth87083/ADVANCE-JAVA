
package com.sunbeam;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HbUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	public static SessionFactory buildSessionFactory() {
		// create empty configuration object
		Configuration conf = new Configuration();
		// load configuration from hibernate.cfg.xml
		conf.configure();
		// create session factory
		return conf.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
