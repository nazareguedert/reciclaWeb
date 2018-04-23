package br.sc.senac.dw.rex.db.model.entity;

import java.util.Date;

public class Logradouro {

	private Long id;
	private String nome;
	private TipoLogradouro tipoLogradouro;
	private Date dataInclusao;
	private Date dataRemocao;

	public Logradouro() {
		super();
	}

	public Logradouro(TipoLogradouro tipoLogradouro, String nome) {
		super();
		this.tipoLogradouro = tipoLogradouro;
		this.nome = nome;
	}

	public Logradouro(Long id, TipoLogradouro tipoLogradouro, String nome) {
		super();
		this.id = id;
		this.tipoLogradouro = tipoLogradouro;
		this.nome = nome;
	}

	public Logradouro(Long id, String nome, TipoLogradouro tipoLogradouro, Date dataInclusao, Date dataRemocao) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipoLogradouro = tipoLogradouro;
		this.dataInclusao = dataInclusao;
		this.dataRemocao = dataRemocao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataRemocao() {
		return dataRemocao;
	}

	public void setDataRemocao(Date dataRemocao) {
		this.dataRemocao = dataRemocao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataInclusao == null) ? 0 : dataInclusao.hashCode());
		result = prime * result + ((dataRemocao == null) ? 0 : dataRemocao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipoLogradouro == null) ? 0 : tipoLogradouro.hashCode());
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
		Logradouro other = (Logradouro) obj;
		if (dataInclusao == null) {
			if (other.dataInclusao != null)
				return false;
		} else if (!dataInclusao.equals(other.dataInclusao))
			return false;
		if (dataRemocao == null) {
			if (other.dataRemocao != null)
				return false;
		} else if (!dataRemocao.equals(other.dataRemocao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipoLogradouro == null) {
			if (other.tipoLogradouro != null)
				return false;
		} else if (!tipoLogradouro.equals(other.tipoLogradouro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Logradouro [id=" + id + ", tipoLogradouro=" + tipoLogradouro + ", nome=" + nome + ", dataInclusao="
				+ dataInclusao + ", dataRemocao=" + dataRemocao + "]";
	}

}
