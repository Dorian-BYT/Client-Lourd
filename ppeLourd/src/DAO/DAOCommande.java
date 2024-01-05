package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.Commande;
import entities.Medicament;
import entities.Utilisateur;

public class DAOCommande extends DAOGeneric<Commande> {
	
	public DAOCommande(Session session) {
		super(session, Commande.class);
	}
	
	public List<Commande> findCommandesFromLoginStartingWith(String code) {
	    String HQL = "SELECT c FROM Commande c JOIN c.Utilisateur u WHERE u.login LIKE :code";
	    Query query = session.createQuery(HQL);
	    query.setString("code", code+'%');
	    List<Commande> commandes = query.getResultList();
	    return commandes;
	}

}
