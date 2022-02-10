package service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dominio.TipoCombustivel;
import dominio.Veiculo;
import util.JpaUtil;

public class AdicionandoVeiculoImage {
	public static void main(String[] args) throws IOException {

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

		Path path = FileSystems.getDefault().getPath("arquivos-extras/ix35.jpg");

		byte[] foto = Files.readAllBytes(path);

		veiculo.setFoto(foto);

		em.persist(veiculo);

		em.getTransaction().commit();

		em.detach(veiculo);

		Veiculo veiculo2 = em.find(Veiculo.class, veiculo.getCodigo());

		System.out.println("Veículo: " + veiculo2.getModelo());
		System.out.println("-------");
		System.out.println(veiculo2.getEspecificacoes());

		if (veiculo2.getFoto() != null) {
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(veiculo2.getFoto()));
			JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
		} else {
			System.out.println("Veículo não possui foto.");
		}

		em.close();
		JpaUtil.close();
	}

}
