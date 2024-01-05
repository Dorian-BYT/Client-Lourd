package DAO;

import org.hibernate.Session;

import entities.Role;

public class DAORoles extends DAOGeneric<Role>{
	
	public DAORoles(Session session) {
		super(session, Role.class);
	}
}
