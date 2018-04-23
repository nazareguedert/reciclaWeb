package br.sc.senac.dw.rex.db.model;

import java.util.Date;

import br.sc.senac.dw.rex.db.model.entity.Logradouro;

public class LogradouroDAO extends GenericDAO<LogradouroDB, Logradouro>{
	
	public LogradouroDAO() {
		super(BaseDAO.BANCO[1], "tb_logradouro", "nome", "tipo_logradouro", new LogradouroDB(), new Logradouro());
	}
	
	@Override
	public LogradouroDB toDB(Logradouro i) {

		LogradouroDB o = new LogradouroDB();

		o.setId(i.getId());
		o.setNome(i.getNome());
		o.setTipo_logradouro(i.getTipoLogradouro().getId());
		o.setData_inclusao(i.getDataInclusao());
		o.setData_remocao(i.getDataRemocao());

		return o;
	}

	@Override
	public Logradouro fromDB(LogradouroDB i) {

		Logradouro o = new Logradouro();

		o.setId(i.getId());
		o.setNome(i.getNome());
		o.setTipoLogradouro(new TipoLogradouroDAO().getPorId(i.getTipo_logradouro()));
		o.setDataInclusao(i.getData_inclusao());
		o.setDataRemocao(i.getData_remocao());

		return o;
	}

}

class LogradouroDB {

	private Long id;
	private String nome;
	private Long tipo_logradouro;
	private Date data_inclusao;
	private Date data_remocao;

	public LogradouroDB() {
		super();
	}

	public LogradouroDB(Long id, String nome, Long tipo_logradouro, Date data_inclusao, Date data_remocao) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo_logradouro = tipo_logradouro;
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

	public Long getTipo_logradouro() {
		return tipo_logradouro;
	}

	public void setTipo_logradouro(Long tipo_logradouro) {
		this.tipo_logradouro = tipo_logradouro;
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
		result = prime * result + ((tipo_logradouro == null) ? 0 : tipo_logradouro.hashCode());
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
		LogradouroDB other = (LogradouroDB) obj;
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
		if (tipo_logradouro == null) {
			if (other.tipo_logradouro != null)
				return false;
		} else if (!tipo_logradouro.equals(other.tipo_logradouro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LogradouroDB [id=" + id + ", nome=" + nome + ", tipo_logradouro=" + tipo_logradouro + ", data_inclusao="
				+ data_inclusao + ", data_remocao=" + data_remocao + "]";
	}

}