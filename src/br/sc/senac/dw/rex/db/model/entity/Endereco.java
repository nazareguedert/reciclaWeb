package br.sc.senac.dw.rex.db.model.entity;

import java.util.Date;

public class Endereco {

	private Long id;
	private String cep;
	private Float latitude;
	private Float longitude;
	private Bairro bairro;
	private Logradouro logradouro;
	private Integer numero;
	private String complemento;
	private Date dataInclusao;
	private Date dataRemocao;

	public Endereco() {
		super();
	}

	public Endereco(String cep, Float latitude, Float longitude, Bairro bairro, Logradouro logradouro, Integer numero,
			String complemento) {
		super();
		this.cep = cep;
		this.latitude = latitude;
		this.longitude = longitude;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
	}

	public Endereco(Long id, String cep, Float latitude, Float longitude, Bairro bairro, Logradouro logradouro,
			Integer numero, String complemento) {
		super();
		this.id = id;
		this.cep = cep;
		this.latitude = latitude;
		this.longitude = longitude;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
	}

	public Endereco(Long id, String cep, Float latitude, Float longitude, Bairro bairro, Logradouro logradouro,
			Integer numero, String complemento, Date dataInclusao, Date dataRemocao) {
		super();
		this.id = id;
		this.cep = cep;
		this.latitude = latitude;
		this.longitude = longitude;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.dataInclusao = dataInclusao;
		this.dataRemocao = dataRemocao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
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
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((dataInclusao == null) ? 0 : dataInclusao.hashCode());
		result = prime * result + ((dataRemocao == null) ? 0 : dataRemocao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Endereco other = (Endereco) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
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
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", cep=" + cep + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", bairro=" + bairro + ", logradouro=" + logradouro + ", numero=" + numero + ", complemento="
				+ complemento + ", dataInclusao=" + dataInclusao + ", dataRemocao=" + dataRemocao + "]";
	}

	
}
