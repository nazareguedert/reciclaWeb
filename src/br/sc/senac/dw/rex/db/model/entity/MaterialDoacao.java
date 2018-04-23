package br.sc.senac.dw.rex.db.model.entity;

import java.util.Date;

public class MaterialDoacao {

	private Long id;
	private Long idDoacao;
	private Material material;
	private Integer quantia;
	private Date dataInclusao;
	private Date dataRemocao;

	public MaterialDoacao() {
		super();
	}

	public MaterialDoacao(Long idDoacao, Material material, Integer quantia) {
		super();
		this.idDoacao = idDoacao;
		this.material = material;
		this.quantia = quantia;
	}

	public MaterialDoacao(Long id, Long idDoacao, Material material, Integer quantia, Date dataInclusao,
			Date dataRemocao) {
		super();
		this.id = id;
		this.idDoacao = idDoacao;
		this.material = material;
		this.quantia = quantia;
		this.dataInclusao = dataInclusao;
		this.dataRemocao = dataRemocao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDoacao() {
		return idDoacao;
	}

	public void setDoacao(Long idDoacao) {
		this.idDoacao = idDoacao;
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
		result = prime * result + ((idDoacao == null) ? 0 : idDoacao.hashCode());
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		result = prime * result + ((quantia == null) ? 0 : quantia.hashCode());
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
		MaterialDoacao other = (MaterialDoacao) obj;
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
		if (idDoacao == null) {
			if (other.idDoacao != null)
				return false;
		} else if (!idDoacao.equals(other.idDoacao))
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
		return true;
	}

	@Override
	public String toString() {
		return "MaterialDoacao [id=" + id + ", idDoacao=" + idDoacao + ", material=" + material + ", quantia=" + quantia
				+ ", dataInclusao=" + dataInclusao + ", dataRemocao=" + dataRemocao + "]";
	}

}
