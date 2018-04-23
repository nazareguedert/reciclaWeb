package br.sc.senac.dw.rex.db.model;

import java.util.Date;

import br.sc.senac.dw.rex.db.model.entity.Material;

public class MaterialDAO extends GenericDAO<MaterialDB, Material> {

	public MaterialDAO() {
		super(BaseDAO.BANCO[0], "tb_material", "nome", new MaterialDB(), new Material());
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public MaterialDB toDB(Material i) {
		MaterialDB o = new MaterialDB();

		o.setId(i.getId());
		o.setNome(i.getNome());
		o.setUnidade_medida(i.getUnidadeMedida().getId());
		o.setData_inclusao(i.getDataInclusao());
		o.setData_remocao(i.getDataRemocao());

		return o;
	}
	
	@Override
	public Material fromDB(MaterialDB i) {
		Material o = new Material();

		o.setId(i.getId());
		o.setNome(i.getNome());
		o.setUnidadeMedida(new UnidadeMedidaDAO().getPorId(i.getUnidade_medida()));
		o.setDataInclusao(i.getData_inclusao());
		o.setDataRemocao(i.getData_remocao());

		return o;
	}

}

class MaterialDB {

	private Long id;
	private String nome;
	private Long unidade_medida;
	private Date data_inclusao;
	private Date data_remocao;

	public MaterialDB() {
		super();
	}

	public MaterialDB(Long id, String nome, Long unidade_medida, Date data_inclusao, Date data_remocao) {
		super();
		this.id = id;
		this.nome = nome;
		this.unidade_medida = unidade_medida;
		this.data_inclusao = data_inclusao;
		this.data_remocao = data_remocao;
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

	public Long getUnidade_medida() {
		return unidade_medida;
	}

	public void setUnidade_medida(Long unidade_medida) {
		this.unidade_medida = unidade_medida;
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
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((unidade_medida == null) ? 0 : unidade_medida.hashCode());
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
		MaterialDB other = (MaterialDB) obj;
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (unidade_medida == null) {
			if (other.unidade_medida != null)
				return false;
		} else if (!unidade_medida.equals(other.unidade_medida))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MaterialDB [id=" + id + ", nome=" + nome + ", unidade_medida=" + unidade_medida + ", data_inclusao="
				+ data_inclusao + ", data_remocao=" + data_remocao + "]";
	}

}
