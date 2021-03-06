package br.sc.senac.dw.rex.db.model;

import java.util.Date;

import br.sc.senac.dw.rex.db.model.entity.Municipio;

public class MunicipioDAO extends GenericDAO<MunicipioDB, Municipio> {

	public MunicipioDAO() {
		super(BaseDAO.BANCO[1], "tb_municipio", "nome", "estado", new MunicipioDB(), new Municipio());
	}

	@Override
	public MunicipioDB toDB(Municipio i) {

		MunicipioDB o = new MunicipioDB();

		o.setId(i.getId());
		o.setNome(i.getNome());
		o.setEstado(i.getEstado().getId());
		o.setData_inclusao(i.getDataInclusao());
		o.setData_remocao(i.getDataRemocao());

		return o;
	}

	@Override
	public Municipio fromDB(MunicipioDB i) {

		Municipio o = new Municipio();

		o.setId(i.getId());
		o.setNome(i.getNome());
		o.setEstado(new EstadoDAO().getPorId(i.getEstado()));
		o.setDataInclusao(i.getData_inclusao());
		o.setDataRemocao(i.getData_remocao());

		return o;
	}

}

class MunicipioDB {

	private Long id;
	private String nome;
	private Long estado;
	private Date data_inclusao;
	private Date data_remocao;

	public MunicipioDB() {
		super();
	}

	public MunicipioDB(Long id, String nome, Long estado, Date data_inclusao, Date data_remocao) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
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

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
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
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		MunicipioDB other = (MunicipioDB) obj;
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
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
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
		return true;
	}

	@Override
	public String toString() {
		return "MunicipioDB [id=" + id + ", nome=" + nome + ", estado=" + estado + ", data_inclusao=" + data_inclusao
				+ ", data_remocao=" + data_remocao + "]";
	}

}