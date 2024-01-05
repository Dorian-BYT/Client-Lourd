package entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the Medicaments database table.
 * 
 */
@Entity
@Table(name="Medicaments")
@NamedQuery(name="Medicament.findAll", query="SELECT m FROM Medicament m")
public class Medicament implements Serializable {
	private static final long serialVersionUID = 1L;

	
	


	public Medicament(int idMedicament, String forme, String nom, String posologie, List<Commande> commandes,
			List<Stock> stocks) {
		super();
		this.idMedicament = idMedicament;
		this.forme = forme;
		this.nom = nom;
		this.posologie = posologie;
		this.commandes = commandes;
		this.stocks = stocks;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMedicament;

	private String forme;

	private String nom;

	private String posologie;

	//bi-directional many-to-many association to Commande
	
	@ManyToMany (mappedBy = "medicaments")

	private List<Commande> commandes = new ArrayList<>();
    //private Set<Commande> commandes = new HashSet<Commande>();

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="medicament")
	private List<Stock> stocks;
	
	public Medicament() {
	}

	public int getIdMedicament() {
		return this.idMedicament;
	}

	public void setIdMedicament(int idMedicament) {
		this.idMedicament = idMedicament;
	}

	public String getForme() {
		return this.forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPosologie() {
		return this.posologie;
	}

	public void setPosologie(String posologie) {
		this.posologie = posologie;
	}

	
	public List<Commande> getCommandes() {
		return this.commandes;
	}
	
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setMedicament(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setMedicament(null);

		return stock;
	}


	@Override
	public String toString() {
		return "Medicament [idMedicament=" + idMedicament + ", forme=" + forme
				+ ", nom=" + nom + ", posologie=" + posologie + ", stocks=" + stocks +"]";
	}
	

}
