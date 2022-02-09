package service;

import javax.persistence.EntityManager;

import dominio.Veiculo;
import util.JpaUtil;

/* Utilizando um find */
public class BuscandoVeiculo1 {
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEm();
		
		Veiculo veiculo = em.find(Veiculo.class, 1L);
		System.out.println("Ve�culo de c�digo " + veiculo.getCodigo() 
		+ " � um " + veiculo.getModelo());
		em.close();
		JpaUtil.close();
	}
	

}
