package dominio;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proprietario")
public class Proprietario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 60, nullable = false)
	private String nome;

	@Column(length = 20, nullable = false)
	private String telefone;

	@Column(length = 255)
	private String email;
	
//	@OneToMany(mappedBy = "proprietario")
//	private Set<Veiculo> veiculos;

	public Proprietario() {
	}

	public Proprietario(String nome, String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

//	public Set<Veiculo> getVeiculos() {
//		return veiculos;
//	}
//
//	public void setVeiculos(Set<Veiculo> veiculos) {
//		this.veiculos = veiculos;
//	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
