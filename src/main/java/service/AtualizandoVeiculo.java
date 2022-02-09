package service;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import dominio.Veiculo;
import util.JpaUtil;

public class AtualizandoVeiculo {
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEm();
		em.getTransaction().begin();
		
		Veiculo veiculo = em.find(Veiculo.class, 1L);
		
		System.out.println("Valor atual: " + veiculo.getValor());
		
		
		veiculo.setValor(veiculo.getValor().add(BigDecimal.valueOf(500)));
		
		System.out.println("Novo valor: " + veiculo.getValor());
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.close();
	}

}
