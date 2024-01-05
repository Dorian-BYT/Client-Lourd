package DAO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.Stock;

public class DAOStocks extends DAOGeneric<Stock>{
	public DAOStocks(Session session) {
		super(session, Stock.class);
	}
}

