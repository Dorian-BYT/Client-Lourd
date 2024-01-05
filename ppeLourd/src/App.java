import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Controllers.ControllerConnexion;
import Controllers.ControllerExpiration;
import Controllers.controllerAcceuil;
import Controllers.controllerCommande;
import Controllers.controllerHistoCommande;
import Controllers.controllerMedicament;
import DAO.DAOCommande;
import DAO.DAOMedicament;
import DAO.DAORoles;
import DAO.DAOStocks;
import DAO.DAOUtilisateur;
import entities.Commande;
import entities.Medicament;
import entities.Role;
import entities.Stock;
import entities.Utilisateur;
import util.HibernateSessionFactory;
import util.TestConnection;
import views.FenetreAccueil;
import views.FenetreCommande;
import views.FenetreExpiration;
import views.FenetreHistoCommande;
import views.FenetreLogin;
import views.FenetreMedicament;

public class App {
	
	
	/*
	public static void TestDAOEntities() {
		//DAORoles daoc = new DAORoles(HibernateSessionFactory.getSessionFactory().openSession());
		//DAOMedicament daoMedicament = new DAOMedicament(HibernateSessionFactory.getSessionFactory().openSession());
		//DAOCommande daoCommande = new DAOCommande(HibernateSessionFactory.getSessionFactory().openSession());
		//DAOUtilisateur daoUtilisateur = new DAOUtilisateur(HibernateSessionFactory.getSessionFactory().openSession());
		/*
		
		//System.out.println(daoCommande.find(1).getDatePanier());
		
		List<Commande> commandes = daoCommande.findAll();
	    List<Utilisateur> utilisateurs = daoUtilisateur.findAll();

        for (Commande commande : commandes) {
        	//System.out.println(commande.getIdCommande());
            //System.out.println(commande.getMedicaments());
        }
        
		List<Medicament> medicaments = daoMedicament.findAll();
	       for (Medicament medicament : medicaments) {
	    	   //System.out.println(medicament.getIdMedicament());
	           //System.out.println(medicament.getStocks());
	        }
	       /*
	       for (Commande commande : commandes) {
	    	   //System.out.println(utilisateurs);
	    	   System.out.println(commande.getUtilisateur());
	       }*/
	       
	       /*
	       for (Utilisateur utilisateur : utilisateurs) {
	    	   System.out.println(utilisateur.getIdUtilisateur());
	           System.out.println(utilisateur.getIdRole());
	        }*/
		
		
		
		/*List<Role> roles = daoc.findAll();
        
        for (Role role : roles) {
            System.out.println(role.getLibelle());
        }
	}
	
	/*public static void TestRead() {
		SessionFactory sf = HibernateSessionFactory.getSessionFactory();
		Session session = sf.openSession();
		System.out.println(session);
	}*/
	
	public static void test() {
		DAOMedicament daoMedicament = new DAOMedicament(HibernateSessionFactory.getSessionFactory().openSession());
	    double test = daoMedicament.sumQuantité(4);
		System.out.println(test);
	}

	
	public static void main(String[] args) {
		//DAOMedicament daoMedicament = new DAOMedicament(HibernateSessionFactory.getSessionFactory().openSession());
		//FenetreMedicament f = new FenetreMedicament();
		//new controllerMedicament(f,daoMedicament).init();
		
		//DAOMedicament daoMedicament = new DAOMedicament(HibernateSessionFactory.getSessionFactory().openSession());
		//FenetreCommande f = new FenetreCommande();
		//new controllerCommande(f,daoMedicament).init();
		
		//FenetreAccueil f = new FenetreAccueil();
		//new controllerAcceuil(f).init();
		DAOUtilisateur daoUtilisateur = new DAOUtilisateur(HibernateSessionFactory.getSessionFactory().openSession());

		//test();
		
		FenetreLogin f = new FenetreLogin();
		new ControllerConnexion(f, daoUtilisateur).init();
		
		//DAOCommande daco = new DAOCommande(HibernateSessionFactory.getSessionFactory().openSession());
		//FenetreHistoCommande fh = new FenetreHistoCommande();
		//new controllerHistoCommande(fh, daco).init();
		
	}
}
