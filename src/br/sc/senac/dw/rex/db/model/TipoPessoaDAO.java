package br.sc.senac.dw.rex.db.model;

import java.util.Date;

import br.sc.senac.dw.rex.db.model.entity.TipoPessoa;

public class TipoPessoaDAO extends GenericDAO<TipoPessoaDB, TipoPessoa> {

	public TipoPessoaDAO() {
		super(BaseDAO.BANCO[0], "tb_tipo_pessoa", "nome", new TipoPessoaDB(), new TipoPessoa());
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public TipoPessoaDB toDB(TipoPessoa i) {
		TipoPessoaDB o = new TipoPessoaDB();

		o.setId(i.getId());
		o.setNome(i.getNome());
		o.setMascara(i.getMascara());
		o.setData_inclusao(i.getDataInclusao());
		o.setData_remocao(i.getDataRemocao());

		return o;
	}
	
	@Override
	public TipoPessoa fromDB(TipoPessoaDB i) {
		TipoPessoa o = new TipoPessoa();

		o.setId(i.getId());
		o.setNome(i.getNome());
		o.setMascara(i.getMascara());
		o.setDataInclusao(i.getData_inclusao());
		o.setDataRemocao(i.getData_remocao());

		return o;
	}
}

class TipoPessoaDB {

	private Long id;
	private String nome;
	private String mascara;
	private Date data_inclusao;
	private Date data_remocao;

	public TipoPessoaDB() {
		super();
	}

	public TipoPessoaDB(Long id, String nome, String mascara, Date data_inclusao, Date data_remocao) {
		super();
		this.id = id;
		this.nome = nome;
		this.mascara = mascara;
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

	public String getMascara() {
		return mascara;
	}

	public void setMascara(String mascara) {
		this.mascara = mascara;
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
		result = prime * result + ((mascara == null) ? 0 : mascara.hashCode());
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
		TipoPessoaDB other = (TipoPessoaDB) obj;
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
		if (mascara == null) {
			if (other.mascara != null)
				return false;
		} else if (!mascara.equals(other.mascara))
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
		return "TipoPessoaDB [id=" + id + ", nome=" + nome + ", mascara=" + mascara + ", data_inclusao=" + data_inclusao
				+ ", data_remocao=" + data_remocao + "]";
	}

}