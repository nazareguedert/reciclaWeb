package br.sc.senac.dw.rex.filtro;

import java.lang.reflect.Field;

public class FiltroAnuncio {

	private String idDoacao;
	private String titulo; 
	private String descricao; //Pode ser que esse campo fique apenas no VO
	private String idDoador;
	private String idColetor;
	private String idStatus;
	private String idMaterial; //codDoacao e codMaterial sao da tabela tb_material_doacao
	private String material;
	private String quantia;
	private String unidadeMedida;
	private String bairro;
	private String CEP;
	private String logradouro;
	private String numero;
	private String tipoLogradouro;
	private String complemento;
	
	public FiltroAnuncio() {
		super();
	}

	public boolean temCampoPreenchido() {
		boolean temCampoPreenchido = false;
		Field[] campos = this.getClass().getDeclaredFields();
		
		for (int i = 0; i < campos.length; i++) {
			campos[i].setAccessible(true);
			try {
				String valor = (String)campos[i].get(this);	
				if(valor!=null&&!valor.trim().isEmpty()) {
					temCampoPreenchido = true;
					return temCampoPreenchido;
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return temCampoPreenchido;
	}

	public String getIdDoacao() {
		return idDoacao;
	}

	public void setIdDoacao(String idDoacao) {
		this.idDoacao = idDoacao;
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

	public String getIdDoador() {
		return idDoador;
	}

	public void setIdDoador(String idDoador) {
		this.idDoador = idDoador;
	}

	public String getIdColetor() {
		return idColetor;
	}

	public void setIdColetor(String idColetor) {
		this.idColetor = idColetor;
	}

	public String getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
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

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
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
		result = prime * result + ((CEP == null) ? 0 : CEP.hashCode());
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idColetor == null) ? 0 : idColetor.hashCode());
		result = prime * result + ((idDoacao == null) ? 0 : idDoacao.hashCode());
		result = prime * result + ((idDoador == null) ? 0 : idDoador.hashCode());
		result = prime * result + ((idMaterial == null) ? 0 : idMaterial.hashCode());
		result = prime * result + ((idStatus == null) ? 0 : idStatus.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((quantia == null) ? 0 : quantia.hashCode());
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
		FiltroAnuncio other = (FiltroAnuncio) obj;
		if (CEP == null) {
			if (other.CEP != null)
				return false;
		} else if (!CEP.equals(other.CEP))
			return false;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
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
		if (idColetor == null) {
			if (other.idColetor != null)
				return false;
		} else if (!idColetor.equals(other.idColetor))
			return false;
		if (idDoacao == null) {
			if (other.idDoacao != null)
				return false;
		} else if (!idDoacao.equals(other.idDoacao))
			return false;
		if (idDoador == null) {
			if (other.idDoador != null)
				return false;
		} else if (!idDoador.equals(other.idDoador))
			return false;
		if (idMaterial == null) {
			if (other.idMaterial != null)
				return false;
		} else if (!idMaterial.equals(other.idMaterial))
			return false;
		if (idStatus == null) {
			if (other.idStatus != null)
				return false;
		} else if (!idStatus.equals(other.idStatus))
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
		return "FiltroAnuncio [idDoacao=" + idDoacao + ", titulo=" + titulo + ", descricao=" + descricao + ", idDoador="
				+ idDoador + ", idColetor=" + idColetor + ", idStatus=" + idStatus + ", idMaterial=" + idMaterial
				+ ", material=" + material + ", quantia=" + quantia + ", unidadeMedida=" + unidadeMedida + ", bairro="
				+ bairro + ", CEP=" + CEP + ", logradouro=" + logradouro + ", numero=" + numero + ", tipoLogradouro="
				+ tipoLogradouro + ", complemento=" + complemento + "]";
	}
}
	