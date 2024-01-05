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
import entities.Commande;
import entities.Medicament;
import entities.Stock;
import util.HibernateSessionFactory;
import views.FenetreAccueil;
import views.FenetreCommande;
import views.FenetreMedicament;

public class controllerCommande {
	FenetreCommande fenetre;
	DAOMedicament daoM = new DAOMedicament(HibernateSessionFactory.getSessionFactory().openSession());
	DAOCommande daoC = new DAOCommande(HibernateSessionFactory.getSessionFactory().openSession());
	DAOStocks daoS = new DAOStocks(HibernateSessionFactory.getSessionFactory().openSession());
	List<Medicament> medicaments;
	List<Stock> stocks;
	MyDefaultTableModelCommande mDTMCommande;
	
	private String quantitePrecendente;
	
	private String prixPrecedent;
	
	public controllerCommande(FenetreCommande fenetre, DAOMedicament daoM) {
		super();
		this.fenetre = fenetre;
		this.daoM = daoM;
		FenetreAccueil fA = new FenetreAccueil();

		
		fenetre.getTextPrix().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updatePrice();
				
			}
		});
		
		fenetre.getBtnAccueil().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fenetre.dispose();
				new controllerAcceuil(fA).init();

				
			}
		});
		
		fenetre.getTextQuantite().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateQuantite();
				
			}
		});
		
		fenetre.getBtnValider().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				doValidate();
			}
		});
		
	}
	
	public void init() {
		fenetre.setLocationRelativeTo(null);
		
		stocks = daoM.selectMedicament();
		mDTMCommande = new MyDefaultTableModelCommande(stocks);
		fenetre.getTableauCommander().setModel(mDTMCommande);
		fenetre.setVisible(true);	
	}
	
	
	private void updatePrice() {
		
        int testPrix = 5;
		double quantite;
		String price = fenetre.getTextPrix().getText();
		if (price.isEmpty()) {
			return;
		}
		if (price != prixPrecedent) {
			prixPrecedent = price;
			
			quantite = Double.parseDouble(price) / testPrix;
	    	fenetre.getTextQuantite().setText(String.format("%.0f", Math.floor(quantite)));
		}
	}
	
	private void updateQuantite() {
		
		int testPrix = 5;
		double prix;
        String quantity = fenetre.getTextQuantite().getText();
        
        if (quantity.isEmpty()) {
			return ;
		}
		if (quantity != quantitePrecendente) {
			quantitePrecendente = quantity;
			
			prix = Integer.parseInt(quantity) * testPrix;
			fenetre.getTextPrix().setText(String.format("%.2f", prix));
			mDTMCommande.fireTableDataChanged();
		}
        
        /*int index = fenetre.getTableauCommander().getSelectedRow();
        
        if (index != -1) {
			Medicament m = medicaments.get(index);
			double prixMedicament = daoM.prixMedicament(m);
			if (quantity.isEmpty()) {
				return ;
			}
			if (quantity != quantitePrecendente) {
				quantitePrecendente = quantity;
				
				prix = Integer.parseInt(quantity) * testPrix;
				fenetre.getTextPrix().setText(String.format("%.2f", prix));
				mDTMCommande.fireTableDataChanged();
			}
		}*/
	}

	
	/**private void doValidate() {
	    SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    Transaction tx = null;

	    try {
	        tx = session.beginTransaction();

	        HashSet<Stock> modified = new HashSet<Stock>();
	        int selectedRow = fenetre.getTableauCommander().getSelectedRow();
	        if (selectedRow == -1) {
	            JOptionPane.showMessageDialog(fenetre, "Sélectionnez une ligne pour ajouter une quantité.");
	            return;
	        }

	        Stock stock = stocks.get(selectedRow);

	        Date today = new Date();
	        
	        String text = fenetre.getTextQuantite().getText();
	        int quantite = Integer.parseInt(text);


	        Commande commande = new Commande();    
	        commande.setDatePanier(today);
	        commande.setIdUtilisateur(ControllerConnexion.theUser.getIdUtilisateur());
	        commande.setQuantite(quantite);

	        // Récupérer l'ID du médicament à partir du stock sélectionné
	        int medicamentId = stock.getId().getIdMedicament();
	        
	        DAOMedicament daoM = new DAOMedicament(session);
	        Medicament medicament = daoM.find(medicamentId); 

	        commande.getMedicaments().add(medicament);
	        medicament.getCommandes().add(commande);

	        DAOCommande daoC = new DAOCommande(session);
	        daoC.save(commande);
	        
	        daoM.update(medicament);

	        tx.commit();
	    } catch (HibernateException e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	}*/
	
	private void doValidate() {
	    SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    Transaction tx = null;

	    try {
	        tx = session.beginTransaction();

	        HashSet<Stock> modified = new HashSet<Stock>();
	        int selectedRow = fenetre.getTableauCommander().getSelectedRow();
	        if (selectedRow == -1) {
	            JOptionPane.showMessageDialog(fenetre, "Sélectionnez une ligne pour ajouter une quantité.");
	            return;
	        }

	        Stock stock = stocks.get(selectedRow);

	        Date today = new Date();
	        
	        String text = fenetre.getTextQuantite().getText();
	        int quantite = Integer.parseInt(text);


	        Commande commande = new Commande();    
	        commande.setDatePanier(today);
	        commande.setIdUtilisateur(ControllerConnexion.theUser.getIdUtilisateur());
	        commande.setQuantite(quantite);

	        // Récupérer l'ID du médicament à partir du stock sélectionné
	        int medicamentId = stock.getId().getIdMedicament();
	        
	        DAOMedicament daoM = new DAOMedicament(session);
	        Medicament medicament = daoM.find(medicamentId); 

	        commande.getMedicaments().add(medicament);
	        medicament.getCommandes().add(commande);

	        DAOCommande daoC = new DAOCommande(session);
	        daoC.save(commande);
	        
	        daoM.update(medicament);
	        
	        stocks.remove(selectedRow); // remove the selected row from the stocks list
		    mDTMCommande.fireTableDataChanged();
	        
	        tx.commit();
	    } catch (HibernateException e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	}

}
