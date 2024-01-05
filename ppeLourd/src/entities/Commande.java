package entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the Commandes database table.
 * 
 */
@Entity

@Table(name="Commandes")
@NamedQuery(name="Commande.findAll", query="SELECT c FROM Commande c")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	
	public Commande(int idCommande, Date datePanier, int idUtilisateur, List<Medicament> medicaments) {
		super();
		this.idCommande = idCommande;
		this.datePanier = datePanier;
		this.idUtilisateur = idUtilisateur;
		this.medicaments = medicaments;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCommande;

	@Temporal(TemporalType.DATE)
	private Date datePanier;

	@Column(name="idUtilisateur")
	private int idUtilisateur;
	
	@Column(name="quantite")
	private int quantite;

	//bi-directional many-to-many association to Medicament
	@ManyToMany (cascade = {CascadeType.ALL})
	@JoinTable( name = "Detail_Cmd",
    			joinColumns = @JoinColumn(name="idCommande"),
    			inverseJoinColumns = @JoinColumn( name = "idMedicament"))
	private List<Medicament> medicaments = new ArrayList<>();
	
	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="idUtilisateur", insertable = false, updatable = false)
	private Utilisateur utilisateur;

	public Commande() {
	}

	public int getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public int getQuantite() {
		return this.quantite;
	}

	public Date getDatePanier() {
		return this.datePanier;
	}

	public void setDatePanier(Date datePanier) {
		this.datePanier = datePanier;
	}

	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
	
	public List<Medicament> getMedicaments() {
		return this.medicaments;
	}

	public void setMedicaments(List<Medicament> medicaments) {
		this.medicaments = medicaments;
	}
	
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", datePanier=" + datePanier + ", idUtilisateur=" + idUtilisateur
				+ ", medicaments=" + medicaments + "]";
	}

	
}