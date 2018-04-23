package br.sc.senac.dw.rex.db.model;

import java.util.Date;

import br.sc.senac.dw.rex.db.model.entity.Telefone;

public class TelefoneDAO extends GenericDAO<TelefoneDB, Telefone> {

	public TelefoneDAO() {
		super(BaseDAO.BANCO[0], "tb_telefone", "numero", "pessoa", new TelefoneDB(), new Telefone());
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public TelefoneDB toDB(Telefone i) {
		TelefoneDB o = new TelefoneDB();

		o.setId(i.getId());
		o.setPessoa(i.getPessoa().getId());
		o.setNumero(i.getNumero());
		o.setData_inclusao(i.getDataInclusao());
		o.setData_remocao(i.getDataRemocao());

		return o;
	}
	
	@Override
	public Telefone fromDB(TelefoneDB i) {
		Telefone o = new Telefone();

		o.setId(i.getId());
		o.setPessoa(new PessoaDAO().getPorId(i.getId()));
		o.setNumero(i.getNumero());
		o.setDataInclusao(i.getData_inclusao());
		o.setDataRemocao(i.getData_remocao());

		return o;
	}
}

class TelefoneDB {

	private Long id;
	private Long pessoa;
	private String numero;
	private Date data_inclusao;
	private Date data_remocao;

	public TelefoneDB() {
		super();
	}

	public TelefoneDB(Long id, Long pessoa, String numero, Date data_inclusao, Date data_remocao) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.numero = numero;
		this.data_inclusao = data_inclusao;
		this.data_remocao = data_remocao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPessoa() {
		return pessoa;
	}

	public void setPessoa(Long pessoa) {
		this.pessoa = pessoa;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
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
		TelefoneDB other = (TelefoneDB) obj;
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
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TelefoneDB [id=" + id + ", pessoa=" + pessoa + ", numero=" + numero + ", data_inclusao=" + data_inclusao
				+ ", data_remocao=" + data_remocao + "]";
	}

}
