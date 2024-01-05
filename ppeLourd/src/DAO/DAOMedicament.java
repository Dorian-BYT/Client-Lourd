package DAO;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import Controllers.ControllerExpiration;
import entities.Medicament;
import entities.Stock;

public class DAOMedicament extends DAOGeneric<Medicament>{
	
	ControllerExpiration ctrl;
	
	public DAOMedicament(Session session) {
		super(session, Medicament.class);
	}
	
	public List<Medicament> findFromMedicamentStartingWith(String code){
		String HQL = "FROM Medicament WHERE nom LIKE :code";
		Query query = session.createQuery(HQL);
		query.setString("code", code+'%');
		List<Medicament> medicaments = query.getResultList();
		return medicaments;
	}
	
	public Double prixMedicament(Medicament m){
		String HQL = "SELECT prix FROM Medicaments WHERE m = :idMedicament";
		Query query = session.createQuery(HQL);
		query.setParameter("idMedicament", m);
		return (Double) query.uniqueResult();

	}
	
	public int sumQuantité(int id) {
		
		List<Medicament> medicaments = findAll();
		int sum = 0;
		for (Medicament medic : medicaments) {
			for (Stock stock : medic.getStocks()) {
				if (medic.getIdMedicament() == id) {
					sum += stock.getQuantite();	
				}
			}
		}
		return sum;
	}
	
	
	public List<Stock> ExpiringMedicament() {
		
		List<Medicament> medicaments = findAll();
		List<Stock> expiringStocks = new ArrayList<Stock>();
		long toDay = Instant.now().toEpochMilli();
		long trenteJour = System.currentTimeMillis()-30 * 24 * 60 * 60 * 1000;
		
		for (Medicament medic : medicaments) {
			for (Stock stock : medic.getStocks()) {
				long datePeremption =stock.getId().getDatePeremption().getTime();
				if (datePeremption >= toDay && datePeremption <= trenteJour) {
					expiringStocks.add(stock);
				}
			}
		}
		return expiringStocks;
	}
	
	public List<Stock> selectMedicament (){
		List<Stock> commandeStocks = ControllerExpiration.getCommandeStocks();
		return commandeStocks;
	}
}
