package service;

import javax.persistence.EntityManager;

import dominio.Veiculo;
import util.JpaUtil;

/* Utilizando o getReference */
public class BuscandoVeiculo2 {
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEm();
		
		Veiculo veiculo = new Veiculo();
		
		veiculo = em.getReference(Veiculo.class, 2L);
		System.out.println("Objeto agora é managed");
		System.out.println("Veículo de código " + veiculo.getCodigo()
		+ " é um " + veiculo.getModelo());
		
		em.close();
		JpaUtil.close();
		
		
	}

}
