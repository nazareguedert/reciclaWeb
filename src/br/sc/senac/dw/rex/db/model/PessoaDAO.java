package br.sc.senac.dw.rex.db.model;

import java.util.Date;

import br.sc.senac.dw.rex.db.model.entity.Pessoa;

public class PessoaDAO extends GenericDAO<PessoaDB, Pessoa> {

	public PessoaDAO() {
		super(BaseDAO.BANCO[0], "tb_pessoa", "doc", "tipo_pessoa", "endereco", new PessoaDB(), new Pessoa());
		// TODO Auto-generated constructor stub
	}

	@Override
	public PessoaDB toDB(Pessoa pessoa) {
		PessoaDB pessoaDb = new PessoaDB();

		pessoaDb.setId(pessoa.getId());
		pessoaDb.setTipo_pessoa(pessoa.getTipoPessoa().getId());
		pessoaDb.setDoc(pessoa.getDoc());
		pessoaDb.setNome(pessoa.getNome());
		pessoaDb.setNome_auxiliar(pessoa.getNomeAuxiliar());
		pessoaDb.setEmail(pessoa.getEmail());

		if(pessoa.getEndereco() != null) {
			pessoaDb.setEndereco(pessoa.getEndereco().getId());
		}

		pessoaDb.setTelefone(pessoa.getTelefone());
		pessoaDb.setData_inclusao(pessoa.getDataInclusao());
		pessoaDb.setData_remocao(pessoa.getDataRemocao());
		pessoaDb.setImagem(pessoa.getImagem());

		return pessoaDb;
	}

	@Override
	public Pessoa fromDB(PessoaDB pessoaDb) {
		Pessoa pessoa = new Pessoa();

		pessoa.setId(pessoaDb.getId());
		pessoa.setTipoPessoa(new TipoPessoaDAO().getPorId(pessoaDb.getTipo_pessoa()));
		pessoa.setDoc(pessoaDb.getDoc());
		pessoa.setNome(pessoaDb.getNome());
		pessoa.setNomeAuxiliar(pessoaDb.getNome_auxiliar());
		pessoa.setEmail(pessoaDb.getEmail());
		pessoa.setEndereco(new EnderecoDAO().getPorId(pessoaDb.getEndereco()));
		pessoa.setTelefone(pessoaDb.getTelefone());
		pessoa.setDataInclusao(pessoaDb.getData_inclusao());
		pessoa.setDataRemocao(pessoaDb.getData_remocao());
		pessoa.setImagem(pessoaDb.getImagem());

		return pessoa;
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
	private byte[] imagem;

	public PessoaDB() {
		super();
	}

	public PessoaDB(Long id, Long tipo_pessoa, String doc, String nome, String nome_auxiliar, String email,
			Long endereco, String telefone, Date data_inclusao, Date data_remocao, byte[] imagem) {
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
		this.imagem = imagem;
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
		result = prime * result + ((imagem == null) ? 0 : imagem.hashCode());
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
		if (imagem == null) {
			if (other.imagem != null)
				return false;
		} else if (!imagem.equals(other.imagem))
			return false;
		return true;
	}

	public byte[] getImagem() {
		return imagem;
	}
	
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	@Override
	public String toString() {
		return "PessoaDB [id=" + id + ", tipo_pessoa=" + tipo_pessoa + ", doc=" + doc + ", nome=" + nome
				+ ", nome_auxiliar=" + nome_auxiliar + ", email=" + email + ", endereco=" + endereco + ", telefone="
				+ telefone + ", data_inclusao=" + data_inclusao + ", data_remocao=" + data_remocao + "]";
	}


}