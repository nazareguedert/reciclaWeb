package br.sc.senac.dw.rex.db.model;

import java.util.Date;

import br.sc.senac.dw.rex.db.model.entity.Pessoa;

public class PessoaDAO extends GenericDAO<PessoaDB, Pessoa> {

	public PessoaDAO() {
		super(BaseDAO.BANCO[0], "tb_pessoa", "doc", "tipo_pessoa", "endereco", new PessoaDB(), new Pessoa());
		// TODO Auto-generated constructor stub
	}

	@Override
	public PessoaDB toDB(Pessoa i) {
		PessoaDB o = new PessoaDB();

		o.setId(i.getId());
		o.setTipo_pessoa(i.getTipoPessoa().getId());
		o.setDoc(i.getDoc());
		o.setNome(i.getNome());
		o.setNome_auxiliar(i.getNomeAuxiliar());
		o.setEmail(i.getEmail());
		
		if(i.getEndereco() != null) {
			o.setEndereco(i.getEndereco().getId());
		}
		
		o.setTelefone(i.getTelefone());
		o.setData_inclusao(i.getDataInclusao());
		o.setData_remocao(i.getDataRemocao());

		return o;
	}

	@Override
	public Pessoa fromDB(PessoaDB i) {
		Pessoa o = new Pessoa();

		o.setId(i.getId());
		o.setTipoPessoa(new TipoPessoaDAO().getPorId(i.getTipo_pessoa()));
		o.setDoc(i.getDoc());
		o.setNome(i.getNome());
		o.setNomeAuxiliar(i.getNome_auxiliar());
		o.setEmail(i.getEmail());
		o.setEndereco(new EnderecoDAO().getPorId(i.getEndereco()));
		o.setTelefone(i.getTelefone());
		o.setDataInclusao(i.getData_inclusao());
		o.setDataRemocao(i.getData_remocao());

		return o;
	}
}

class PessoaDB {

	private Long id;
	private Long tipo_pessoa;
	private String doc;
	private String nome;
	private String nome_auxiliar;
	private String email;
	private Long endereco;
	private String telefone;
	private Date data_inclusao;
	private Date data_remocao;

	public PessoaDB() {
		super();
	}

	public PessoaDB(Long id, Long tipo_pessoa, String doc, String nome, String nome_auxiliar, String email,
			Long endereco, String telefone, Date data_inclusao, Date data_remocao) {
		super();
		this.id = id;
		this.tipo_pessoa = tipo_pessoa;
		this.doc = doc;
		this.nome = nome;
		this.nome_auxiliar = nome_auxiliar;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
		this.data_inclusao = data_inclusao;
		this.data_remocao = data_remocao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTipo_pessoa() {
		return tipo_pessoa;
	}

	public void setTipo_pessoa(Long tipo_pessoa) {
		this.tipo_pessoa = tipo_pessoa;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome_auxiliar() {
		return nome_auxiliar;
	}

	public void setNome_auxiliar(String nome_auxiliar) {
		this.nome_auxiliar = nome_auxiliar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getEndereco() {
		return endereco;
	}

	public void setEndereco(Long endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
		result = prime * result + ((doc == null) ? 0 : doc.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nome_auxiliar == null) ? 0 : nome_auxiliar.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((tipo_pessoa == null) ? 0 : tipo_pessoa.hashCode());
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
		PessoaDB other = (PessoaDB) obj;
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
		if (doc == null) {
			if (other.doc != null)
				return false;
		} else if (!doc.equals(other.doc))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
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
		if (nome_auxiliar == null) {
			if (other.nome_auxiliar != null)
				return false;
		} else if (!nome_auxiliar.equals(other.nome_auxiliar))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (tipo_pessoa == null) {
			if (other.tipo_pessoa != null)
				return false;
		} else if (!tipo_pessoa.equals(other.tipo_pessoa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PessoaDB [id=" + id + ", tipo_pessoa=" + tipo_pessoa + ", doc=" + doc + ", nome=" + nome
				+ ", nome_auxiliar=" + nome_auxiliar + ", email=" + email + ", endereco=" + endereco + ", telefone="
				+ telefone + ", data_inclusao=" + data_inclusao + ", data_remocao=" + data_remocao + "]";
	}

}