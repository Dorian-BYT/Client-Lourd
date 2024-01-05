package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import DAO.DAORoles;
import DAO.DAOUtilisateur;
import entities.Medicament;
import entities.Stock;
import entities.Utilisateur;
import views.FenetreAccueil;
import views.FenetreLogin;
import views.FenetreProfil;

public class ControllerConnexion {
	FenetreLogin fenetre;
	static FenetreProfil fp = new FenetreProfil();
	FenetreAccueil fa = new FenetreAccueil();
	DAOUtilisateur DAOU;
	DAORoles DAOR;
	List<Utilisateur> utilisateurs;
    public static Utilisateur theUser;

	
	public ControllerConnexion(FenetreLogin fenetre, DAOUtilisateur dAOU) {
		super();
		this.fenetre = fenetre;
		DAOU = dAOU;
		
		
		fenetre.getBtnLogin().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (Connexion()) {
					fenetre.dispose();
					//fp.getPrenom().setText("Nathan");
					new controllerAcceuil(fa).init();
				}
				else {
					fenetre.getValidation().setText("Mot de passe ou login incorrect");
				}
			}
		});
		
		
		
	}
	
	
	public boolean Connexion() {
		String pass = fenetre.getPasswordField().getText();
		String login = fenetre.getUsernameField().getText();
		
		if (DAOU.checkLogin(login, pass)) {
			return true;
		}
		else {
			return false;
		}	
	}
    
    public static void logout() {
        theUser = null;
    }
	

	public void init() {
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
	}
	
	
	
	
	

}
