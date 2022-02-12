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

		Veiculo veiculo2 = new Veiculo();

		veiculo2.setFabricante("Fiesta");
		veiculo2.setModelo("Ford");
		veiculo2.setAnoFabricacao(2020);
		veiculo2.setAnoModelo(2020);
		veiculo2.setValor(new BigDecimal(90500));
		veiculo2.setTipoCombustivel(TipoCombustivel.ALCOOL);
		veiculo2.setDataCadastro(LocalDate.now());

		Proprietario proprietario = new Proprietario("Gustavo Santos", "91 9 93720104", null);

		em.persist(proprietario);
		veiculo.setProprietario(proprietario);
		veiculo2.setProprietario(proprietario);

		em.persist(veiculo);
		em.persist(veiculo2);

		em.getTransaction().commit();

		em.detach(veiculo);

		buscarVeiculoPorId(em, 3L);
		buscarVeiculoPorId(em, veiculo.getCodigo());
		buscarVeiculoPorId(em, veiculo2.getCodigo());
		

		em.close();
		JpaUtil.close();
	}
	
	public static void buscarVeiculoPorId(EntityManager em, Long id) {
		Veiculo veiculo = em.find(Veiculo.class, id);
		System.out.println(veiculo.getCodigo() + " - " 
				+ veiculo.getFabricante() + " " 
				+ veiculo.getModelo() + ", ano " 
				+ veiculo.getAnoFabricacao() + "/" 
				+ veiculo.getAnoModelo() + " por " 
				+ "R$" + veiculo.getValor()
				+ " Proprietario: " + veiculo.getProprietario().getNome()
				+ " Telefone: " + veiculo.getProprietario().getTelefone());
	}

}
