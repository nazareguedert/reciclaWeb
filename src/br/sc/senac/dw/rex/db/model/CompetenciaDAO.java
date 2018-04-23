package br.sc.senac.dw.rex.db.model;

import java.util.Date;

import br.sc.senac.dw.rex.db.model.entity.Competencia;

public class CompetenciaDAO extends GenericDAO<CompetenciaDB, Competencia> {

	public CompetenciaDAO() {
		super(BaseDAO.BANCO[0], "tb_competencia", "usuario", "material", new CompetenciaDB(), new Competencia());
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public CompetenciaDB toDB(Competencia i) {
		CompetenciaDB o = new CompetenciaDB();

		o.setId(i.getId());
		o.setUsuario(i.getUsuario().getId());
		o.setMaterial(i.getMaterial().getId());
		o.setData_inclusao(i.getDataInclusao());
		o.setData_remocao(i.getDataRemocao());

		return o;
	}
	
	@Override
	public Competencia fromDB(CompetenciaDB i) {
		Competencia o = new Competencia();

		o.setId(i.getId());
		o.setUsuario(new UsuarioDAO().getPorId(i.getUsuario()));
		o.setMaterial(new MaterialDAO().getPorId(i.getMaterial()));
		o.setDataInclusao(i.getData_inclusao());
		o.setDataRemocao(i.getData_remocao());

		return o;
	}
}

class CompetenciaDB {

	private Long id;
	private Long usuario;
	private Long material;
	private Date data_inclusao;
	private Date data_remocao;

	public CompetenciaDB() {
		super();
	}

	public CompetenciaDB(Long id, Long usuario, Long material, Date data_inclusao, Date data_remocao) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.material = material;
		this.data_inclusao = data_inclusao;
		this.data_remocao = data_remocao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	public Long getMaterial() {
		return material;
	}

	public void setMaterial(Long material) {
		this.material = material;
	}

	public Date getData_inclusao() {
		return data_inclusao;
	}

	public void setData_inclusao(Date data_inclusao) {
		this.data_inclusao = data_inclusao;
	}

	public Date getData_remocao() {
		return data_remocao;
	}

	public void setData_remocao(Date data_remocao) {
		this.data_remocao = data_remocao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_inclusao == null) ? 0 : data_inclusao.hashCode());
		result = prime * result + ((data_remocao == null) ? 0 : data_remocao.hashCode());
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
		CompetenciaDB other = (CompetenciaDB) obj;
		if (data_inclusao == null) {
			if (other.data_inclusao != null)
				return false;
		} else if (!data_inclusao.equals(other.data_inclusao))
			return false;
		if (data_remocao == null) {
			if (other.data_remocao != null)
				return false;
		} else if (!data_remocao.equals(other.data_remocao))
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
		return "CompetenciaDB [id=" + id + ", usuario=" + usuario + ", material=" + material + ", data_inclusao="
				+ data_inclusao + ", data_remocao=" + data_remocao + "]";
	}

}
