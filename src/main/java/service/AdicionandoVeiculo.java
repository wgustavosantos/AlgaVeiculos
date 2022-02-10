package service;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import dominio.Proprietario;
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
		
		StringBuilder especificacoes = new StringBuilder();
		especificacoes.append("Carro em excelente estado.\n");
		especificacoes.append("Completo, menos ar.\n");
		especificacoes.append("Primeiro dono, com manual de instrução ");
		especificacoes.append("e todas as revisões feitas.\n");
		especificacoes.append("IPVA pago, aceita financiamento.");
		
		veiculo.setEspecificacoes(especificacoes.toString());
		
		Proprietario proprietario = new Proprietario("Gustavo Santos", "91 9 93720104", null);
		
		
		veiculo.setProprietario(proprietario);
		
		em.persist(proprietario);
		em.persist(veiculo);
		
		
		
		em.getTransaction().commit();
		
		em.detach(veiculo);
		
		Veiculo veiculo2 = em.find(Veiculo.class, veiculo.getCodigo());
		
		System.out.println("Veículo: " + veiculo2.getModelo());
		System.out.println("-------");
		System.out.println(veiculo2.getEspecificacoes());
		System.out.println("Nome do proprietário: " + veiculo2.getProprietario().getNome());
		System.out.println("Telefone do proprietário: " + veiculo2.getProprietario().getTelefone());
		
		em.close();
		JpaUtil.close();
	}

}
