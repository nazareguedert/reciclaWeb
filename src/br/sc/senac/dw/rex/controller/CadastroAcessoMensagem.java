package br.sc.senac.dw.rex.controller;

import br.sc.senac.dw.rex.db.model.entity.Usuario;

public class CadastroAcessoMensagem {
	
	private String saida="";

	public CadastroAcessoMensagem() {
		super();
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}
	
	public boolean produzMensagem(Usuario usuario, String senhaConfirma) {

		boolean retorno = false;

		boolean inicio = true;

		if (usuario.getPessoa().getDoc() == null) {

			retorno = true;

			if (inicio) {
				inicio = false;

				this.saida = "Favor preencher: \n";
			}
			
			if(usuario.getPessoa().getTipoPessoa().getNome().equals("Fisica")) {
				this.saida += " - O CPF";
			} else {
				this.saida += " - O CNPJ";
			}
			
			
		} else {
			
			if(usuario.getPessoa().getTipoPessoa().getNome().equals("Fisica")) {
				if(usuario.getPessoa().getDoc().length() < 14) {
					retorno = true;
					
					if (inicio) {
						inicio = false;

						this.saida = "Favor completar: \n";
					}
					this.saida += " - O CPF";
				}
				
			} else {
				
				if(usuario.getPessoa().getTipoPessoa().getNome().equals("Juridica") && usuario.getPessoa().getDoc().length() < 18) {
					retorno = true;
					
					if (inicio) {
						inicio = false;

						this.saida = "Favor completar: \n";
					}
					this.saida += " - O CNPJ";
					
				}
				
			}
		}
		
		
		if (usuario.getPessoa().getNome() == null || usuario.getPessoa().getNome().length() < 2) {
			retorno = true;
			
			if (inicio) {
				inicio = false;

				this.saida = "Favor completar: \n";
			}
			this.saida += " - O Nome";
		}

		if (usuario.getPessoa().getNomeAuxiliar() == null || usuario.getPessoa().getNomeAuxiliar().length() < 2) {
			retorno = true;
			
			if (inicio) {
				inicio = false;

				this.saida = "Favor completar: \n";
			}
			this.saida += " - O Sobrenome";
		}
		
		if (usuario.getUsuario() == null || usuario.getUsuario().length() < 2) {
			retorno = true;
			
			if (inicio) {
				inicio = false;

				this.saida = "Favor completar: \n";
			}
			this.saida += " - O Apelido";
		}
		
		if (usuario.getSenha() == null || usuario.getSenha().length() < 2) {
			retorno = true;
			
			if (inicio) {
				inicio = false;

				this.saida = "Favor completar: \n";
			}
			this.saida += " - A senha";
		}

		if (senhaConfirma == null || senhaConfirma.length() < 2) {
			retorno = true;
			
			if (inicio) {
				inicio = false;

				this.saida = "Favor completar: \n";
			}
			this.saida += " - A confirmação da senha";
		}
			
		if(usuario.getSenha() != null && usuario.getSenha().length() >= 2 
				&& senhaConfirma != null && senhaConfirma.length() >= 2) {
		
			if(!usuario.getSenha().equals(senhaConfirma)) {
				retorno = true;
				
				if (inicio) {
					inicio = false;

					this.saida = "";
				}
				
				this.saida += "\n - CONFIRME A SENHA ";
			}
			
		}
			
		
		return retorno;

	}

	@Override
	public String toString() {
		return saida;
	}
	
	

}
