package entities;

import java.io.Serializable;
import javax.persistence.*;

import org.mindrot.jbcrypt.BCrypt;

import java.util.List;


/**
 * The persistent class for the Utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUtilisateur;

	private String adresse;

	private int idRole;

	private String nom;

	private String prenom;

	private String telephone;
	
	private String password;
	
	private String login;


	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="utilisateur")
	private List<Commande> commandes;

	@ManyToOne
	@JoinColumn(name="idRole", insertable = false, updatable = false)
	private Role role;
	
	public Utilisateur() {
	}

	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Commande addCommande(Commande commande) {
		getCommandes().add(commande);
		commande.setUtilisateur(this);

		return commande;
	}

	public Commande removeCommande(Commande commande) {
		getCommandes().remove(commande);
		commande.setUtilisateur(null);

		return commande;
	}
	
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public Utilisateur(int idUtilisateur, String adresse, int idRole, String nom, String prenom, String telephone, String password,
			List<Commande> commandes) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.adresse = adresse;
		this.idRole = idRole;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.password = password;
		this.commandes = commandes;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", adresse=" + adresse + ", idRole=" + idRole + ", nom="
				+ nom + ", prenom=" + prenom + ", telephone=" + telephone + ", commandes=" + commandes + ", login=" + login + "]";
	}
	
	

}