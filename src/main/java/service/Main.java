package service;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Veiculo;
import util.JpaUtil;

public class Main {
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEm();
		em.getTransaction().begin();
		
		Veiculo veiculo = new Veiculo();
		
		veiculo.setFabricante("Honda");
		veiculo.setModelo("Civic");
		veiculo.setAnoFabricacao(2020);
		veiculo.setAnoModelo(2020);
		veiculo.setValor(new BigDecimal(90500));
		
		em.persist(veiculo);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.close();
	}

}
