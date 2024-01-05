package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import DAO.DAOMedicament;
import entities.Medicament;
import views.FenetreAccueil;
import views.FenetreMedicament;

public class controllerMedicament {
	FenetreMedicament fenetre;
	DAOMedicament daoM;
	List<Medicament> medicaments;
	MyDefaultTableModel mDTM;
	FenetreAccueil fA = new FenetreAccueil();
	
	
	public controllerMedicament(FenetreMedicament fenetre, DAOMedicament daoM) {
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

		medicaments = daoM.findAll();
		mDTM = new MyDefaultTableModel(medicaments);
		fenetre.getTable().setModel(mDTM);
		
		fenetre.setVisible(true);
	}
	
	private void doUpdate() {
		for (Medicament m : mDTM.getModified()) {
			daoM.update(m);
		}
	}
	
	private void doSearch() {
		
    	String code = fenetre.getTxtSearch().getText();
     
        medicaments = daoM.findFromMedicamentStartingWith(code);
        mDTM = new MyDefaultTableModel(medicaments);
        fenetre.getTable().setModel(mDTM);
         
	}
	
	private void doDelete() {
		int index = fenetre.getTable().getSelectedRow();
		if(index != -1) {
			Medicament m = medicaments.get(index);
				daoM.delete(m);
				medicaments.remove(index);
				mDTM.fireTableDataChanged();
		}
	}
	
	private void doCancel() {
		medicaments = daoM.findAll();
    	mDTM = new MyDefaultTableModel(medicaments);
    	fenetre.getTable().setModel(mDTM);
	}
}
