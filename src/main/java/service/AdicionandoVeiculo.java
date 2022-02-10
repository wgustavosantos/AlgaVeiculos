package service;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import dominio.TipoCombustivel;
import dominio.Veiculo;
import util.JpaUtil;

public class AdicionandoVeiculo {
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEm();
		em.getTransaction().begin();
		
		Veiculo veiculo = new Veiculo();
		
		veiculo.setFabricante("Honda");
		veiculo.setModelo("Civic");
		veiculo.setAnoFabricacao(2020);
		veiculo.setAnoModelo(2020);
		veiculo.setValor(new BigDecimal(90500));
		veiculo.setTipoCombustivel(TipoCombustivel.ALCOOL);
		veiculo.setDataCadastro(LocalDate.now());
		em.persist(veiculo);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.close();
	}

}
