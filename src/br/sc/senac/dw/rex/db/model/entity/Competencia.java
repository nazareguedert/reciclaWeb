package br.sc.senac.dw.rex.db.model.entity;

import java.util.Date;

public class Competencia {

	private Long id;
	private Usuario usuario;
	private Material material;
	private Date dataInclusao;
	private Date dataRemocao;

	public Competencia() {
		super();
	}

	public Competencia(Usuario usuario, Material material) {
		super();
		this.usuario = usuario;
		this.material = material;
	}

	public Competencia(Long id, Usuario usuario, Material material, Date dataInclusao, Date dataRemocao) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.material = material;
		this.dataInclusao = dataInclusao;
		this.dataRemocao = dataRemocao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
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
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Competencia other = (Competencia) obj;
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
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Competencia [id=" + id + ", usuario=" + usuario + ", material=" + material + ", dataInclusao="
				+ dataInclusao + ", dataRemocao=" + dataRemocao + "]";
	}

}
