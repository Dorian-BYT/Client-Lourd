package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.DAOUtilisateur;
import entities.Utilisateur;
import util.HibernateSessionFactory;
import views.FenetreAccueil;
import views.FenetreLogin;
import views.FenetreProfil;

public class controllerProfil {
	FenetreProfil fenetre ;
	FenetreAccueil fA = new FenetreAccueil();
	

	public controllerProfil(FenetreProfil fenetre) {
		super();
		this.fenetre = fenetre;
		
		fenetre.getBtnAcceuil().addActionListener(new ActionListener() {
			
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

		fenetre.getNom().setText(ControllerConnexion.theUser.getNom());
		fenetre.getPrenom().setText(ControllerConnexion.theUser.getPrenom());
		fenetre.getAdresse().setText(ControllerConnexion.theUser.getAdresse());
		fenetre.getTel().setText(ControllerConnexion.theUser.getTelephone());
		fenetre.getRole().setText(ControllerConnexion.theUser.getRole().getLibelle());
		
		fenetre.setVisible(true);
	}

}
