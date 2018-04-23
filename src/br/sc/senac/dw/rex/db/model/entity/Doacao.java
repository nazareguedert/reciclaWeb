package br.sc.senac.dw.rex.db.model.entity;

import java.util.Date;

public class Doacao {

	private Long id;
	private String titulo;
	private String descricao;
	private Usuario doador;
	private Usuario coletor;
	private Endereco endereco;
	private StatusDoacao statusDoacao;
	private Material material;
	private Integer quantia;
	private Date dataAbertura;
	private Date dataColeta;

	public Doacao() {
		super();
	}

	public Doacao(String titulo, String descricao, Usuario doador, Usuario coletor, Endereco endereco,
			StatusDoacao statusDoacao, Material material, Integer quantia) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.doador = doador;
		this.coletor = coletor;
		this.endereco = endereco;
		this.statusDoacao = statusDoacao;
		this.material = material;
		this.quantia = quantia;
	}

	public Doacao(Long id, String titulo, String descricao, Usuario doador, Usuario coletor, Endereco endereco,
			StatusDoacao statusDoacao, Material material, Integer quantia) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.doador = doador;
		this.coletor = coletor;
		this.endereco = endereco;
		this.statusDoacao = statusDoacao;
		this.material = material;
		this.quantia = quantia;
	}

	public Doacao(Long id, String titulo, String descricao, Usuario doador, Usuario coletor, Endereco endereco,
			StatusDoacao statusDoacao, Material material, Integer quantia, Date dataAbertura, Date dataColeta) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.doador = doador;
		this.coletor = coletor;
		this.endereco = endereco;
		this.statusDoacao = statusDoacao;
		this.material = material;
		this.quantia = quantia;
		this.dataAbertura = dataAbertura;
		this.dataColeta = dataColeta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getDoador() {
		return doador;
	}

	public void setDoador(Usuario doador) {
		this.doador = doador;
	}

	public Usuario getColetor() {
		return coletor;
	}

	public void setColetor(Usuario coletor) {
		this.coletor = coletor;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public StatusDoacao getStatusDoacao() {
		return statusDoacao;
	}

	public void setStatusDoacao(StatusDoacao statusDoacao) {
		this.statusDoacao = statusDoacao;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Integer getQuantia() {
		return quantia;
	}

	public void setQuantia(Integer quantia) {
		this.quantia = quantia;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataColeta() {
		return dataColeta;
	}

	public void setDataColeta(Date dataColeta) {
		this.dataColeta = dataColeta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coletor == null) ? 0 : coletor.hashCode());
		result = prime * result + ((dataAbertura == null) ? 0 : dataAbertura.hashCode());
		result = prime * result + ((dataColeta == null) ? 0 : dataColeta.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((doador == null) ? 0 : doador.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		result = prime * result + ((quantia == null) ? 0 : quantia.hashCode());
		result = prime * result + ((statusDoacao == null) ? 0 : statusDoacao.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Doacao other = (Doacao) obj;
		if (coletor == null) {
			if (other.coletor != null)
				return false;
		} else if (!coletor.equals(other.coletor))
			return false;
		if (dataAbertura == null) {
			if (other.dataAbertura != null)
				return false;
		} else if (!dataAbertura.equals(other.dataAbertura))
			return false;
		if (dataColeta == null) {
			if (other.dataColeta != null)
				return false;
		} else if (!dataColeta.equals(other.dataColeta))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (doador == null) {
			if (other.doador != null)
				return false;
		} else if (!doador.equals(other.doador))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (quantia == null) {
			if (other.quantia != null)
				return false;
		} else if (!quantia.equals(other.quantia))
			return false;
		if (statusDoacao == null) {
			if (other.statusDoacao != null)
				return false;
		} else if (!statusDoacao.equals(other.statusDoacao))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Doacao [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", doador=" + doador
				+ ", coletor=" + coletor + ", endereco=" + endereco + ", statusDoacao=" + statusDoacao + ", material="
				+ material + ", quantia=" + quantia + ", dataAbertura=" + dataAbertura + ", dataColeta=" + dataColeta
				+ "]";
	}

}
