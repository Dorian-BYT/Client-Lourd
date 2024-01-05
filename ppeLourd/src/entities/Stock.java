package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Stocks database table.
 * 
 */
@Entity
@Table(name="Stocks")
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StockPK id = new StockPK();

	@ManyToOne
	@JoinColumn(name="idMedicament", insertable = false, updatable = false)
	private Medicament medicament;
	
	private int quantite;

	public Stock() {
	}

	public StockPK getId() {
		return this.id;
	}

	public void setId(StockPK id) {
		this.id = id;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public Medicament getMedicament() {
		return this.medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

}