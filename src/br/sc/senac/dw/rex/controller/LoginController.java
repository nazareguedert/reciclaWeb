package br.sc.senac.dw.rex.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.sc.senac.dw.rex.db.model.entity.Usuario;


@Named
@ViewScoped
public class LoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7007863199696262021L;

	private final CadastroAcessoController cadastroAcessoController;
	
	private String apelido;
	private String senha;
	
	private String msgApelido="";
	private String msgSenha="";

	@Inject
	public LoginController(CadastroAcessoController cadastroAcessoController) {
		super();
		this.cadastroAcessoController = cadastroAcessoController;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMsgApelido() {
		return msgApelido;
	}

	public void setMsgApelido(String msgApelido) {
		this.msgApelido = msgApelido;
	}

	public String getMsgSenha() {
		return msgSenha;
	}

	public void setMsgSenha(String msgSenha) {
		this.msgSenha = msgSenha;
	}
	
	public void login() {

		Usuario u = this.cadastroAcessoController.getUsuarioDAO().get(this.apelido);
		
		if (u != null) {
			
			this.msgApelido="";
			
			if(u.getSenha().equals(this.senha)) {
				System.out.println(u);
				u.setSenha("");
				this.cadastroAcessoController.setUsuario(u);
				this.cadastroAcessoController.setLogado(true);
				
				this.cadastroAcessoController.recarregar();
			} else {
				
				this.msgApelido = "";
				this.msgSenha = "Incorreta, favor verificar";
			}


		} else {
			
			this.msgApelido = "Usuário não cadastrado";
			this.msgSenha = "";
			this.cadastroAcessoController.construir();


		}

	}
	
	

}
