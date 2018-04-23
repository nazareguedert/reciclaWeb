package br.sc.senac.dw.rex.db.model;

import java.util.Date;

import br.sc.senac.dw.rex.db.model.entity.Bairro;

public class BairroDAO extends GenericDAO<BairroDB, Bairro> {

	public BairroDAO() {
		super(BaseDAO.BANCO[1], "tb_bairro", "nome", "municipio", new BairroDB(), new Bairro());
	}

	@Override
	public BairroDB toDB(Bairro i) {

		BairroDB o = new BairroDB();

		o.setId(i.getId());
		o.setNome(i.getNome());
		o.setMunicipio(i.getMunicipio().getId());
		o.setData_inclusao(i.getDataInclusao());
		o.setData_remocao(i.getDataRemocao());

		return o;
	}

	@Override
	public Bairro fromDB(BairroDB i) {

		Bairro o = new Bairro();

		o.setId(i.getId());
		o.setNome(i.getNome());
		o.setMunicipio(new MunicipioDAO().getPorId(i.getMunicipio()));
		o.setDataInclusao(i.getData_inclusao());
		o.setDataRemocao(i.getData_remocao());

		return o;
	}

}

class BairroDB {

	private Long id;
	private String nome;
	private Long municipio;
	private Date data_inclusao;
	private Date data_remocao;

	public BairroDB() {
		super();
	}

	public BairroDB(Long id, String nome, Long municipio, Date data_inclusao, Date data_remocao) {
		super();
		this.id = id;
		this.nome = nome;
		this.municipio = municipio;
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

	public Long getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Long municipio) {
		this.municipio = municipio;
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
		result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
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
		BairroDB other = (BairroDB) obj;
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
		if (municipio == null) {
			if (other.municipio != null)
				return false;
		} else if (!municipio.equals(other.municipio))
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
		return "BairroDB [id=" + id + ", nome=" + nome + ", municipio=" + municipio + ", data_inclusao=" + data_inclusao
				+ ", data_remocao=" + data_remocao + "]";
	}

}