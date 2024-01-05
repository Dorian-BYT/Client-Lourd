package Controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.DAOMedicament;
import entities.Commande;
import entities.Medicament;
import entities.Stock;
import util.HibernateSessionFactory;

public class MyDefaultTableModel extends DefaultTableModel{
	
	DAOMedicament daoM = new DAOMedicament(HibernateSessionFactory.getSessionFactory().openSession());

	
	List<Medicament> medicaments ;
	List<Stock> stocks;

	public HashSet<Medicament> modified ;
	private String[] columnNames = {"Nom", "Forme", "Posologie" , "Stocks"};	


	public MyDefaultTableModel(List<Medicament> medicaments) {
		super();
		this.medicaments = medicaments;
		modified = new HashSet<Medicament>();
	}

	@Override
	public int getRowCount() {
		if (medicaments == null) 
			return 0;
		return medicaments.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public void removeRow(int row) {
		this.removeRow(row);
	}

	public HashSet<Medicament> getModified() {
		return modified;
	}



	@Override
	public boolean isCellEditable(int row, int column) {
	    return (column != 0 && column != 4);
	}


	@Override
	public Object getValueAt(int row, int column) {
		
		Medicament m = medicaments.get(row);
		Object value = null;
		//int totalStock = daoM.SumStockMedicament();		
		switch (column) {
			case 0:
				value = m.getNom();
				break;
			case 1:
				value = m.getForme();
				break;	
			case 2:
				value = m.getPosologie();
				break;
			case 3:
				value = daoM.sumQuantité(m.getIdMedicament());
				break;	
			default:
				break;
		}
		return value;
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		Medicament m = medicaments.get(row);
		
		
		switch (column) {
			case 0:
				m.setNom((String) aValue);
				break;
			case 1:
				m.setForme((String) aValue);
				break;	
			case 2:
				m.setPosologie((String) aValue);
				break;	
			default:
			case 3:
				m.setStocks((List<Stock>) aValue);
				break;	
		}
		modified.add(m);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?> type = null;
		switch (columnIndex) {
			case 0:
			case 1:
				type = String.class;
				break;
			case 2:
				type = String.class;
				break;
			case 3:
				type = Integer.class;
				break;
			default:
				break;
		}
		return type;
	}

}