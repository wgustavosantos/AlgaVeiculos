package service;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import dominio.Veiculo;
import dominio.VeiculoPK;
import util.JpaUtil;

public class AdicionandoVeiculo {
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEm();
		em.getTransaction().begin();
		
		Veiculo veiculo = new Veiculo();
		
		veiculo.setCodigo(new VeiculoPK("ABC-123", "Bragança"));
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
