package br.sc.senac.dw.rex.filtro;

import java.util.ArrayList;

public class AnuncioVO {
	
	private String idDoacoao;
	private String titulo;
	private String descricao;
	private String doador;
	private String coletor;
	private String status;
	private String idMaterial;
	private String material;
	private String quantia;
	private String unidadeMedida;
	private String bairro;
	private String cep;
	private String logradouro;
	private String numero;
	private String tipoLogradouro;
	private String complemento;
	
	public AnuncioVO() {
		super();
	}

	public AnuncioVO(String idDoacoao, String titulo, String descricao, String doador, String coletor, String status,
			String idMaterial, String material, String quantia, String unidadeMedida, String bairro, String cep,
			String logradouro, String numero, String tipoLogradouro, String complemento) {
		super();
		this.idDoacoao = idDoacoao;
		this.titulo = titulo;
		this.descricao = descricao;
		this.doador = doador;
		this.coletor = coletor;
		this.status = status;
		this.idMaterial = idMaterial;
		this.material = material;
		this.quantia = quantia;
		this.unidadeMedida = unidadeMedida;
		this.bairro = bairro;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.tipoLogradouro = tipoLogradouro;
		this.complemento = complemento;
	}

	public String getIdDoacoao() {
		return idDoacoao;
	}

	public void setIdDoacoao(String idDoacoao) {
		this.idDoacoao = idDoacoao;
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

	public String getDoador() {
		return doador;
	}

	public void setDoador(String doador) {
		this.doador = doador;
	}

	public String getColetor() {
		return coletor;
	}

	public void setColetor(String coletor) {
		this.coletor = coletor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(String idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getQuantia() {
		return quantia;
	}

	public void setQuantia(String quantia) {
		this.quantia = quantia;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((coletor == null) ? 0 : coletor.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((doador == null) ? 0 : doador.hashCode());
		result = prime * result + ((idDoacoao == null) ? 0 : idDoacoao.hashCode());
		result = prime * result + ((idMaterial == null) ? 0 : idMaterial.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((quantia == null) ? 0 : quantia.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipoLogradouro == null) ? 0 : tipoLogradouro.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((unidadeMedida == null) ? 0 : unidadeMedida.hashCode());
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
		AnuncioVO other = (AnuncioVO) obj;
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
		if (coletor == null) {
			if (other.coletor != null)
				return false;
		} else if (!coletor.equals(other.coletor))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
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
		if (idDoacoao == null) {
			if (other.idDoacoao != null)
				return false;
		} else if (!idDoacoao.equals(other.idDoacoao))
			return false;
		if (idMaterial == null) {
			if (other.idMaterial != null)
				return false;
		} else if (!idMaterial.equals(other.idMaterial))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (quantia == null) {
			if (other.quantia != null)
				return false;
		} else if (!quantia.equals(other.quantia))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tipoLogradouro == null) {
			if (other.tipoLogradouro != null)
				return false;
		} else if (!tipoLogradouro.equals(other.tipoLogradouro))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (unidadeMedida == null) {
			if (other.unidadeMedida != null)
				return false;
		} else if (!unidadeMedida.equals(other.unidadeMedida))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AnuncioVO [idDoacoao=" + idDoacoao + ", titulo=" + titulo + ", descricao=" + descricao + ", doador="
				+ doador + ", coletor=" + coletor + ", status=" + status + ", idMaterial=" + idMaterial + ", material="
				+ material + ", quantia=" + quantia + ", unidadeMedida=" + unidadeMedida + ", bairro=" + bairro
				+ ", cep=" + cep + ", logradouro=" + logradouro + ", numero=" + numero + ", tipoLogradouro="
				+ tipoLogradouro + ", complemento=" + complemento + "]";
	}
}
