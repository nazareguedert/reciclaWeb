package br.sc.senac.dw.rex.db.model.entity;

import java.util.Date;

public class TipoPessoa {

	private Long id;
	private String nome;
	private String mascara;
	private Date dataInclusao;
	private Date dataRemocao;

	public TipoPessoa() {
		super();
	}

	public TipoPessoa(String nome, String mascara) {
		super();
		this.nome = nome;
		this.mascara = mascara;
	}

	public TipoPessoa(Long id, String nome, String mascara, Date dataInclusao, Date dataRemocao) {
		super();
		this.id = id;
		this.nome = nome;
		this.mascara = mascara;
		this.dataInclusao = dataInclusao;
		this.dataRemocao = dataRemocao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMascara() {
		return mascara;
	}

	public void setMascara(String mascara) {
		this.mascara = mascara;
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
		result = prime * result + ((mascara == null) ? 0 : mascara.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		TipoPessoa other = (TipoPessoa) obj;
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
		if (mascara == null) {
			if (other.mascara != null)
				return false;
		} else if (!mascara.equals(other.mascara))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoPessoa [id=" + id + ", nome=" + nome + ", mascara=" + mascara + ", dataInclusao=" + dataInclusao
				+ ", dataRemocao=" + dataRemocao + "]";
	}

}
