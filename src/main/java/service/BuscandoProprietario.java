package service;

import javax.persistence.EntityManager;

import dominio.Proprietario;
import dominio.Veiculo;
import util.JpaUtil;

public class BuscandoProprietario {

	public static void main(String[] args) {

		EntityManager em = JpaUtil.getEm();

		Proprietario p = em.find(Proprietario.class, 1L);

		System.out.println("--BUSCANDO PROPRIETARIO--");

		System.out.printf("Codigo - %d \nNome: %s\nTelefone: %s\nEmail: %s\n", p.getCodigo(), p.getNome(),
				p.getTelefone(), p.getEmail());

		for (Veiculo veiculo : p.getVeiculos()) {
			System.out.println("Veículo: " + veiculo.getModelo());
		}
	}

}
