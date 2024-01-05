package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import DAO.DAOMedicament;
import DAO.DAOStocks;
import entities.Medicament;
import entities.Stock;
import views.FenetreAccueil;
import views.FenetreExpiration;
import views.FenetreStock;

public class ControllerStock {
	FenetreStock fenetre;
	DAOStocks daoM;
	List<Medicament> medicaments;
	List<Stock> stocks;
	MyDefaultTableStock mDTM;
	FenetreAccueil fA = new FenetreAccueil();

	
	
	public ControllerStock(FenetreStock fenetre, DAOStocks daoM) {
		super();
		this.fenetre = fenetre;
		this.daoM = daoM;
		
		fenetre.getBtnSearch().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				doSearch();
				
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
		
		if (ControllerConnexion.theUser.getIdRole() != 1) {
	        fenetre.getBtnCancel().setEnabled(false);
	    }else {
		fenetre.getBtnCancel().addActionListener(new ActionListener() {
		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				doCancel();
				
			}
		});}
		
		if (ControllerConnexion.theUser.getIdRole() != 1) {
	        fenetre.getBtnDelete().setEnabled(false);
	    }else {
		fenetre.getBtnDelete().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				doDelete();
				
			}
		});}
		
		if (ControllerConnexion.theUser.getIdRole() != 1) {
	        fenetre.getBtnUpdate().setEnabled(false);
	    }else {
		fenetre.getBtnUpdate().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				doUpdate();
				
			}
		});}
	}
	
	
	
	
	public void init() {
		fenetre.setLocationRelativeTo(null);

		
		stocks = daoM.findAll();
		mDTM = new MyDefaultTableStock(stocks);
		fenetre.getTable().setModel(mDTM);
		
		fenetre.setVisible(true);
	}
	
	private void doUpdate() {
		for (Stock s : mDTM.getModified()) {
			daoM.update(s);
		}
	}
	
	private void doSearch() {
		
    	String code = fenetre.getTxtSearch().getText();
     
    	//stocks = daoM.findFromCountryStartingWith(code);
        mDTM = new MyDefaultTableStock(stocks);
        fenetre.getTable().setModel(mDTM);
         
	}
	
	private void doDelete() {
		int index = fenetre.getTable().getSelectedRow();
		if(index != -1) {
			Stock s = stocks.get(index);
				daoM.delete(s);
				stocks.remove(index);
				mDTM.fireTableDataChanged();
		}
	}
	
	private void doCancel() {
		stocks = daoM.findAll();
    	mDTM = new MyDefaultTableStock(stocks);
    	fenetre.getTable().setModel(mDTM);
	}
}