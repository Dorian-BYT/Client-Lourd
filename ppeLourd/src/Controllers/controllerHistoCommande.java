package Controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import DAO.DAOCommande;
import DAO.DAOMedicament;
import DAO.DAOStocks;
import DAO.DAOUtilisateur;
import entities.Commande;
import entities.Medicament;
import entities.Stock;
import entities.Utilisateur;
import util.HibernateSessionFactory;
import views.FenetreAccueil;
import views.FenetreCommande;
import views.FenetreHistoCommande;
import views.FenetreMedicament;

public class controllerHistoCommande {
	FenetreHistoCommande fenetre;
	DAOMedicament daoM = new DAOMedicament(HibernateSessionFactory.getSessionFactory().openSession());
	DAOCommande daoC = new DAOCommande(HibernateSessionFactory.getSessionFactory().openSession());
	List<Medicament> medicaments;
	List<Commande> commandes;

	MyDefaultTableHistoCommande mDTMCommande;
	
		
	public controllerHistoCommande(FenetreHistoCommande fenetre, DAOCommande daoC) {
		super();
		this.fenetre = fenetre;
		this.daoC = daoC;
		FenetreAccueil fA = new FenetreAccueil();
		
		fenetre.getBtnAccueil().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fenetre.dispose();
				new controllerAcceuil(fA).init();
			}
		});

		
	}
	
	public void init() {
		fenetre.setLocationRelativeTo(null);
		
		commandes = daoC.findAll();
		mDTMCommande = new MyDefaultTableHistoCommande(commandes);
		fenetre.getTable().setModel(mDTMCommande);
		fenetre.setVisible(true);
	}
	
	
	private void doSearch() {
		
    	String code = fenetre.getTxtSearch().getText();
     
        commandes = daoC.findCommandesFromLoginStartingWith(code);
        mDTMCommande = new MyDefaultTableHistoCommande(commandes);
        fenetre.getTable().setModel(mDTMCommande);
         
	}
	

}
