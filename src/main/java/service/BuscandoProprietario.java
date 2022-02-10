package service;

import javax.persistence.EntityManager;

import dominio.Proprietario;
import util.JpaUtil;

public class BuscandoProprietario {
	
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEm();
		
		Proprietario p = em.find(Proprietario.class, 2L);
		
		System.out.println("--BUSCANDO PROPRIETARIO--");
		
		System.out.printf("Codigo - %d \nNome: %s\nTelefone: %s\nEmail: %s\n"
				, p.getCodigo(), p.getNome(), p.getTelefone(), p.getEmail());
		
		System.out.println(p.getVeiculo().getFabricante() + " " 
				+ p.getVeiculo().getModelo() + ", ano " 
				+ p.getVeiculo().getAnoFabricacao() + "/" 
				+ p.getVeiculo().getAnoModelo() + " por " 
				+ "R$" + p.getVeiculo().getValor());
	}

}
