package br.sc.senac.dw.rex.db.model.entity;

import java.util.Date;

public class Usuario {

	private Long id;
	private String usuario;
	private String senha;
	private Pessoa pessoa;
	private NivelAcesso nivelAcesso;
	private Date dataInclusao;
	private Date dataRemocao;
//	private Perfil perfil;

	public Usuario() {
		super();
	}

	public Usuario(String usuario, String senha, Pessoa pessoa, NivelAcesso nivelAcesso) {
		super();
		this.usuario = usuario;
		this.senha = senha;
		this.pessoa = pessoa;
		this.nivelAcesso = nivelAcesso;
	}

	public Usuario(Long id, String usuario, String senha, Pessoa pessoa, NivelAcesso nivelAcesso) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.pessoa = pessoa;
		this.nivelAcesso = nivelAcesso;
	}

	public Usuario(Long id, String usuario, String senha, Pessoa pessoa, NivelAcesso nivelAcesso, Date dataInclusao,
			Date dataRemocao) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.pessoa = pessoa;
		this.nivelAcesso = nivelAcesso;
		this.dataInclusao = dataInclusao;
		this.dataRemocao = dataRemocao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public NivelAcesso getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(NivelAcesso nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataRemocao() {
		return dataRemocao;
	}

	public void setDataRemocao(Date dataRemocao) {
		this.dataRemocao = dataRemocao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataInclusao == null) ? 0 : dataInclusao.hashCode());
		result = prime * result + ((dataRemocao == null) ? 0 : dataRemocao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nivelAcesso == null) ? 0 : nivelAcesso.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Usuario other = (Usuario) obj;
		if (dataInclusao == null) {
			if (other.dataInclusao != null)
				return false;
		} else if (!dataInclusao.equals(other.dataInclusao))
			return false;
		if (dataRemocao == null) {
			if (other.dataRemocao != null)
				return false;
		} else if (!dataRemocao.equals(other.dataRemocao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nivelAcesso == null) {
			if (other.nivelAcesso != null)
				return false;
		} else if (!nivelAcesso.equals(other.nivelAcesso))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
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
		return "Usuario [id=" + id + ", usuario=" + usuario + ", senha=" + senha + ", pessoa=" + pessoa
				+ ", nivelAcesso=" + nivelAcesso + ", dataInclusao=" + dataInclusao + ", dataRemocao=" + dataRemocao
				+ "]";
	}

}
