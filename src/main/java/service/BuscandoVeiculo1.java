package service;

import javax.persistence.EntityManager;

import dominio.Veiculo;
import util.JpaUtil;

/* Utilizando um find */
public class BuscandoVeiculo1 {
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEm();
		
		Veiculo veiculo = em.find(Veiculo.class, 2L);
		System.out.println(veiculo.getCodigo() + " - " 
				+ veiculo.getFabricante() + " " 
				+ veiculo.getModelo() + ", ano " 
				+ veiculo.getAnoFabricacao() + "/" 
				+ veiculo.getAnoModelo() + " por " 
				+ "R$" + veiculo.getValor()
				+ " Proprietario: " + veiculo.getProprietario().getNome()
				+ " Telefone: " + veiculo.getProprietario().getTelefone());
		em.close();
		JpaUtil.close();
	}
	

}
