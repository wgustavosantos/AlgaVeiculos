package service;

import javax.persistence.EntityManager;

import dominio.Veiculo;
import dominio.VeiculoPK;
import util.JpaUtil;

/* Utilizando um find */
public class BuscandoVeiculo1 {
	public static void main(String[] args) {

		EntityManager em = JpaUtil.getEm();
		
		VeiculoPK id = new VeiculoPK("ABC-123", "Bragança");

		Veiculo veiculo = em.find(Veiculo.class, id );
		
		System.out.println("Placa: " + veiculo.getCodigo().getPlaca());
		System.out.println("Cidade: " + veiculo.getCodigo().getCidade());
		System.out.println("Fabricante: " + veiculo.getFabricante());
		System.out.println("Modelo: " + veiculo.getModelo());
		em.close();
		JpaUtil.close();
	}

}
