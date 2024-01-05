package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

	private static SessionFactory sessionFactory;
	static {
		// SessionFactory in Hibernate 5.x
		Configuration config = new Configuration();
		config.configure();
		// local SessionFactory bean created
		sessionFactory = config.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
