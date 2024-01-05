package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.springframework.security.access.prepost.PreAuthorize;

import DAO.DAOCommande;
import DAO.DAOMedicament;
import DAO.DAOStocks;
import DAO.DAOUtilisateur;
import entities.Utilisateur;
import util.HibernateSessionFactory;
import views.FenetreAccueil;
import views.FenetreCommande;
import views.FenetreExpiration;
import views.FenetreHistoCommande;
import views.FenetreLogin;
import views.FenetreMedicament;
import views.FenetreProfil;
import views.FenetreStock;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class controllerAcceuil {
	
	FenetreAccueil fenetre;
	DAOMedicament daoMedicament = new DAOMedicament(HibernateSessionFactory.getSessionFactory().openSession());
	DAOCommande daoCommande = new DAOCommande(HibernateSessionFactory.getSessionFactory().openSession());
	DAOUtilisateur daoUtilisateur = new DAOUtilisateur(HibernateSessionFactory.getSessionFactory().openSession());
	DAOStocks daoStock = new DAOStocks(HibernateSessionFactory.getSessionFactory().openSession());
	
	Utilisateur user;
	
	FenetreMedicament fM = new FenetreMedicament();
	FenetreCommande fC = new FenetreCommande();
	FenetreExpiration fE = new FenetreExpiration();
	FenetreStock fS = new FenetreStock();
	FenetreProfil fp = new FenetreProfil();
	FenetreLogin fl = new FenetreLogin();	



	
	public controllerAcceuil(FenetreAccueil fenetre) {
		super();
		this.fenetre = fenetre;

		fenetre.getBtnMedicaments().addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    		fenetre.dispose();
		            new controllerMedicament(fM, daoMedicament).init();
		    }
		});
		
		fenetre.getBtnStocks().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fenetre.dispose();
				new ControllerStock(fS,daoStock).init();

				
			}
		});
		
		if (ControllerConnexion.theUser.getIdRole() == 2) {
	        fenetre.getBtnCommander().setEnabled(false);
	    }else {
	    	
		fenetre.getBtnCommander().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fenetre.dispose();
				DAOCommande daco = new DAOCommande(HibernateSessionFactory.getSessionFactory().openSession());
				FenetreHistoCommande fh = new FenetreHistoCommande();
				new controllerHistoCommande(fh, daco).init();
			}
		});}
		
		if (ControllerConnexion.theUser.getIdRole() == 2) {
	        fenetre.getBtnExpirations().setEnabled(false);
	    }else {
		fenetre.getBtnExpirations().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fenetre.dispose();
				new ControllerExpiration(fE,daoMedicament).init();

				
			}
		});}
		
		
		fenetre.getBtnProfil().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fenetre.dispose();
				new controllerProfil(fp).init();

				
			}
		});
		
		fenetre.getBtnDeconnexion().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fenetre.dispose();
				new ControllerConnexion(fl , daoUtilisateur).init();
			}
		});
	}
	
	public void init() {		
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
	}
		
}
