package DAO;

import javax.persistence.NoResultException;
import javax.transaction.Transaction;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

import Controllers.ControllerConnexion;

import org.hibernate.Session;

import entities.Utilisateur;
import util.HibernateSessionFactory;

public class DAOUtilisateur extends DAOGeneric<Utilisateur> {
			
		public DAOUtilisateur(Session session) {
			super(session, Utilisateur.class);
		}
		
		
		public List<Utilisateur> findFromLoginStartingWith(String code){
			String HQL = "FROM Utilisteur WHERE login LIKE :code";
			Query query = session.createQuery(HQL);
			query.setString("code", code+'%');
			List<Utilisateur> utilisateurs = query.getResultList();
			return utilisateurs;
		}
		
	    public Utilisateur checkUtilisateur(String login, String password) {
	    	
	    	try {
	            String hql = "FROM Utilisateur u WHERE u.login = :login";
	            Query query = session.createQuery(hql);
	            query.setString("login", login);
	            //@SuppressWarnings("deprecation")
				Utilisateur user = (Utilisateur) query.getSingleResult();

	            if (BCrypt.checkpw(password, user.getPassword())) {
	            	return user;
	            	
	            }else {
	            	return null;
	            }
	    	}catch(NoResultException re) {
	    		return null;
	    	}	    	
	    }

	    public boolean checkLogin(String login, String password) {
	    	
	    	try {
	            String hql = "FROM Utilisateur u WHERE u.login = :login";
	            Query query = session.createQuery(hql);
	            query.setString("login", login);
	            //@SuppressWarnings("deprecation")
				Utilisateur user = (Utilisateur) query.getSingleResult();

	            if (BCrypt.checkpw(password, user.getPassword())) {
	            	ControllerConnexion.theUser = checkUtilisateur(login, password);
	            	return true;
	            	
	            }else {
	            	return false;
	            }
	    	}catch(NoResultException re) {
	    		return false;	
	    	}	    	
	    }
	    

}
