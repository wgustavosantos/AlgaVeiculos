package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dominio.Veiculo;
import util.JpaUtil;

public class ListandoVeiculos {
	public static void main(String[] args) {

		EntityManager em = JpaUtil.getEm();

		String jpql = "SELECT v FROM Veiculo v";

		Query query = em.createQuery(jpql);

		List<Veiculo> veiculos = query.getResultList();

		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getCodigo() + " - " 
					+ veiculo.getFabricante() + " " 
					+ veiculo.getModelo() + ", ano " 
					+ veiculo.getAnoFabricacao() + "/" 
					+ veiculo.getAnoModelo() + " por " 
					+ "R$" + veiculo.getValor());
		}

		em.close();
		JpaUtil.close();
	}

}
