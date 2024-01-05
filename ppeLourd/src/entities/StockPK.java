package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Stocks database table.
 * 
 */
@Embeddable
public class StockPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idMedicament;

	@Temporal(TemporalType.DATE)
	private java.util.Date datePeremption;

	public StockPK() {
	}
	public int getIdMedicament() {
		return this.idMedicament;
	}
	public void setIdMedicament(int idMedicament) {
		this.idMedicament = idMedicament;
	}
	public java.util.Date getDatePeremption() {
		return this.datePeremption;
	}
	public void setDatePeremption(java.util.Date datePeremption) {
		this.datePeremption = datePeremption;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StockPK)) {
			return false;
		}
		StockPK castOther = (StockPK)other;
		return 
			(this.idMedicament == castOther.idMedicament)
			&& this.datePeremption.equals(castOther.datePeremption);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idMedicament;
		hash = hash * prime + this.datePeremption.hashCode();
		
		return hash;
	}
}