package Controllers;

import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

import DAO.DAOMedicament;
import entities.Commande;
import entities.Medicament;
import entities.Stock;

public class MyDefaultTableStock extends DefaultTableModel{
	
	List<Stock> stocks ;

	public HashSet<Stock> modified ;
	private String[] columnNames = {"Nom", "Date de péremption", "Quantité"};	


	public MyDefaultTableStock(List<Stock> stocks) {
		super();
		this.stocks = stocks;
		modified = new HashSet<Stock>();
	}

	@Override
	public int getRowCount() {
		if (stocks == null) 
			return 0;
		return stocks.size();
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

	public HashSet<Stock> getModified() {
		return modified;
	}



	@Override
	public boolean isCellEditable(int row, int column) {
		return (column > 2 );
	}

	@Override
	public Object getValueAt(int row, int column) {
		
		Stock s = stocks.get(row);
		Object value = null;
		
		switch (column) {
			case 0:
				value = s.getMedicament().getNom(); 
				
				break;
			case 1:
				value = s.getId().getDatePeremption();
				break;
			case 2:
				value = s.getQuantite();
				break;
			default:
				break;
		}
		return value;
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		Stock s = stocks.get(row);
		switch (column) {
			case 2:
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


		}
		return type;
	}
	


}