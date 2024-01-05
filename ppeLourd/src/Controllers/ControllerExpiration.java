package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DAO.DAOMedicament;
import DAO.DAOStocks;
import entities.Medicament;
import entities.Stock;
import views.FenetreAccueil;
import views.FenetreCommande;
import views.FenetreExpiration;

public class ControllerExpiration {
	FenetreCommande fenetreCommande = new FenetreCommande();
	FenetreExpiration fenetre;
	DAOStocks daoS;
	DAOMedicament daoM;
	List<Medicament> medicaments;
	List<Stock> stocks;
    static List<Stock> commandeStocks = new ArrayList<>();
	MyDefaultTableExpiration mDTM;
	FenetreAccueil fA = new FenetreAccueil();

	
	
	public ControllerExpiration(FenetreExpiration fenetre, DAOMedicament daoM) {
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
		
		
		
		fenetre.getBtnUpdate().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				doCommande();
				
			}
		});
		
		fenetre.getBtnCommander().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fenetre.dispose();
				new controllerCommande(fenetreCommande, daoM).init();
				
			}
		});
	}
	
	
	
	
	public void init() {
		fenetre.setLocationRelativeTo(null);
		
		stocks = daoM.ExpiringMedicament();
		mDTM = new MyDefaultTableExpiration(stocks);
		fenetre.getTable().setModel(mDTM);
		
		fenetre.setVisible(true);
	}
	
	public List<Stock> doCommande() {
		FenetreCommande fenetreCommande = new FenetreCommande();
		fenetre.getTable().setModel(mDTM);
		int selectedRow = fenetre.getTable().getSelectedRow();
	    
	    Stock stock = stocks.get(selectedRow);
	    commandeStocks.add(stock);
	    stocks.remove(selectedRow); // remove the selected row from the stocks list
	    mDTM.fireTableDataChanged();
	    System.out.println(commandeStocks);
	    return commandeStocks;
	}
	
	private void doSearch() {
		
    	String code = fenetre.getTxtSearch().getText();
     
    	//stocks = daoM.findFromCountryStartingWith(code);
        mDTM = new MyDefaultTableExpiration(stocks);
        fenetre.getTable().setModel(mDTM);
         
	}
	
	private void doDelete() {
		int index = fenetre.getTable().getSelectedRow();
		if(index != -1) {
			Stock s = stocks.get(index);
			daoS.delete(s);
				stocks.remove(index);
				mDTM.fireTableDataChanged();
		}
	}
	
	private void doCancel() {
		stocks = daoS.findAll();
    	mDTM = new MyDefaultTableExpiration(stocks);
    	fenetre.getTable().setModel(mDTM);
	}
	
	public static List<Stock> getCommandeStocks() {
	       return commandeStocks;
	}
}