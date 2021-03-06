package br.sc.senac.dw.rex.db.model;

import java.util.Date;

import br.sc.senac.dw.rex.db.model.entity.NivelAcesso;

public class NivelAcessoDAO extends GenericDAO<NivelAcessoDB, NivelAcesso> {

	public NivelAcessoDAO() {
		super(BaseDAO.BANCO[0], "tb_nivel_acesso", "nome", new NivelAcessoDB(), new NivelAcesso());
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public NivelAcessoDB toDB(NivelAcesso i) {
		NivelAcessoDB o = new NivelAcessoDB();

		o.setId(i.getId());
		o.setNome(i.getNome());
		o.setNivel(i.getNivel());
		o.setData_inclusao(i.getDataInclusao());
		o.setData_remocao(i.getDataRemocao());

		return o;
	}
	
	@Override
	public NivelAcesso fromDB(NivelAcessoDB i) {
		NivelAcesso o = new NivelAcesso();

		o.setId(i.getId());
		o.setNome(i.getNome());
		o.setNivel(i.getNivel());
		o.setDataInclusao(i.getData_inclusao());
		o.setDataRemocao(i.getData_remocao());

		return o;
	}

}

class NivelAcessoDB {

	private Long id;
	private String nome;
	private Integer nivel;
	private Date data_inclusao;
	private Date data_remocao;

	public NivelAcessoDB() {
		super();
	}

	public NivelAcessoDB(Long id, String nome, Integer nivel, Date data_inclusao, Date data_remocao) {
		super();
		this.id = id;
		this.nome = nome;
		this.nivel = nivel;
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

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
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
		result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
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
		NivelAcessoDB other = (NivelAcessoDB) obj;
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
		if (nivel == null) {
			if (other.nivel != null)
				return false;
		} else if (!nivel.equals(other.nivel))
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
		return "NivelAcessoDB [id=" + id + ", nome=" + nome + ", nivel=" + nivel + ", data_inclusao=" + data_inclusao
				+ ", data_remocao=" + data_remocao + "]";
	}

}