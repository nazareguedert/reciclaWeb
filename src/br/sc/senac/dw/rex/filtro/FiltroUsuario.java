package br.sc.senac.dw.rex.filtro;

import java.lang.reflect.Field;

public class FiltroUsuario {

	private String nomeUsuario;
	private String email;
	private String idNivelAcesso;
	private String nome;
	private String apelido;
	private String telefone;
	private String idTipoPessoa;
	private String bairro;
	private String CEP;
	private String logradouro;
	private String numero;
	private String idTipoLogradouro;
	private String complemento;
	
	
	public FiltroUsuario() {
		super();
	}

	public boolean temCampoPreenchido() {
		boolean temCampoPreenchido = false;
		Field[] campos = this.getClass().getDeclaredFields();
		
		for (int i = 0; i < campos.length; i++) {
			campos[i].setAccessible(true);
			try {
				String valor = (String)campos[i].get(this);	
				if(valor!=null&&!valor.trim().isEmpty()) {
					temCampoPreenchido = true;
					return temCampoPreenchido;
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return temCampoPreenchido;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdNivelAcesso() {
		return idNivelAcesso;
	}

	public void setIdNivelAcesso(String idNivelAcesso) {
		this.idNivelAcesso = idNivelAcesso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getIdTipoPessoa() {
		return idTipoPessoa;
	}

	public void setIdTipoPessoa(String idTipoPessoa) {
		this.idTipoPessoa = idTipoPessoa;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String CEP) {
		this.CEP = CEP;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getIdTipoLogradouro() {
		return idTipoLogradouro;
	}

	public void setIdTipoLogradouro(String idTipoLogradouro) {
		this.idTipoLogradouro = idTipoLogradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	
	//gerar hash, toString e equals

	
}