package Controllers;

import java.awt.Button;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

import DAO.DAOMedicament;
import entities.Commande;
import entities.Medicament;
import entities.Stock;

public class MyDefaultTableHistoCommande extends DefaultTableModel{
	
	List<Commande> commandes ;

	public HashSet<Commande> modified ;
	private String[] columnNames = {"Login", "Quantité" , "Date de commande"};	


	public MyDefaultTableHistoCommande(List<Commande> commandes) {
		super();
		this.commandes = commandes;
		modified = new HashSet<Commande>();
	}

	@Override
	public int getRowCount() {
		if (commandes == null) 
			return 0;
		return commandes.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public void removeRow(int row) {
		this.removeRow(row);
	}

	public HashSet<Commande> getModified() {
		return modified;
	}



	@Override
	public boolean isCellEditable(int row, int column) {
		return (column > 3 );
	}

	@Override
	public Object getValueAt(int row, int column) {
		
		Commande s = commandes.get(row);
		Object value = null;
		
		switch (column) {
			case 0:
				value = s.getUtilisateur().getLogin();
				break;
			case 1:
				value = s.getQuantite();
				break;
			case 2:
				value = s.getDatePanier();
				break;
			default:
				break;
		}
		return value;
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		Commande s = commandes.get(row);
		switch (column) {
			case 1:
				s.setQuantite(((Integer) aValue));
				break;

		}
		modified.add(s);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?> type = null;
		switch (columnIndex) {
			case 0:
				type = Data.class;
				break;
			case 1:
			case 2:
				type = Integer.class;
				break;
			case 3:
				type = Date.class;
				break;
			
		}
		return type;
	}
	


}