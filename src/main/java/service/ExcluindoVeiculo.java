package service;

import javax.persistence.EntityManager;

import dominio.Veiculo;
import util.JpaUtil;

public class ExcluindoVeiculo {

	public static void main(String[] args) {

		EntityManager em = JpaUtil.getEm();
		em.getTransaction().begin();

		Veiculo veiculo = em.find(Veiculo.class, 1L);
		
		em.remove(veiculo);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.close();

	}

}
