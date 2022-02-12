package dominio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tab_veiculo")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_veiculo")
	private Long codigo;

	@Column(length = 60, nullable = false)
	private String fabricante;

	@Column(length = 60, nullable = false)
	private String modelo;

	@Column(name = "ano_fabricacao", nullable = false)
	private Integer anoFabricacao;

	@Column(name = "ano_modelo")
	private Integer anoModelo;

	@Column(precision = 10, scale = 2, nullable = true)
	private BigDecimal valor;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_combustivel", nullable = false)
	private TipoCombustivel TipoCombustivel;

	@Column(name = "data_cadastro", nullable = false)
	private LocalDate dataCadastro;

	@Transient
	private String descricaoCompleta;

	@Lob
	private String especificacoes;

	@Lob
	private byte[] foto;

	@ManyToOne(optional = false) //notnull : default -> nullable = true
	@JoinColumn(name = "cod_proprietario")
	private Proprietario proprietario;
	
	@ManyToMany
	@JoinTable(name = "veiculo_acessorio",
				joinColumns = @JoinColumn(name = "veiculo_cod"),
				inverseJoinColumns = @JoinColumn(name = "acessorio_cod"))
	private Set<Acessorio> acessorios = new HashSet<>();

	public Veiculo() {

	}

	public Veiculo(String fabricante, String modelo, Integer anoFabricacao, Integer anoModelo, BigDecimal valor,
			TipoCombustivel tipoCombustivel, LocalDate dataCadastro, String descricaoCompleta) {
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.valor = valor;
		TipoCombustivel = tipoCombustivel;
		this.dataCadastro = dataCadastro;
		this.descricaoCompleta = descricaoCompleta;
	}

	public String getDescricaoCompleta() {
		return descricaoCompleta;
	}

	public void setDescricaoCompleta(String descricaoCompleta) {
		this.descricaoCompleta = descricaoCompleta;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoCombustivel getTipoCombustivel() {
		return TipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		TipoCombustivel = tipoCombustivel;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getEspecificacoes() {
		return especificacoes;
	}

	public void setEspecificacoes(String especificacoes) {
		this.especificacoes = especificacoes;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	

	public Set<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(Set<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}