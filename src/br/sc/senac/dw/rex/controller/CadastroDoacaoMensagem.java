package br.sc.senac.dw.rex.controller;

import br.sc.senac.dw.rex.db.model.entity.Doacao;

public class CadastroDoacaoMensagem {

	private String saida="";

	public CadastroDoacaoMensagem() {
		super();
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}

	public boolean produzMensagem(Doacao doacao) {

		boolean retorno = false;

		boolean inicio = true;

		if (doacao.getEndereco().getBairro().getMunicipio().getEstado().getPais().getNome() == null) {

			retorno = true;

			if (inicio) {
				inicio = false;

				this.saida = "Favor preencher: \n";
			}

			this.saida += " - O País";

		}

		if (doacao.getEndereco().getBairro().getMunicipio().getEstado().getNome() == null) {
			retorno = true;

			if (inicio) {
				inicio = false;

				this.saida = "Favor preencher: \n";
			}

			this.saida += " - O Estado";
		}

		if (doacao.getEndereco().getBairro().getMunicipio().getNome() == null) {
			retorno = true;

			if (inicio) {
				inicio = false;

				this.saida = "Favor preencher: \n";
			}

			this.saida += " - O Município";
		}

		if (doacao.getEndereco().getBairro().getNome() == null) {
			retorno = true;

			if (inicio) {
				inicio = false;

				this.saida = "Favor preencher: \n";
			}

			this.saida += " - O Bairro";
		}

		if (doacao.getEndereco().getCep() == null || doacao.getEndereco().getCep().length() < 9) {
			retorno = true;

			if (inicio) {
				inicio = false;

				this.saida = "Favor preencher: \n";
			}

			this.saida += " - O CEP";
		}

		if (doacao.getEndereco().getLogradouro().getTipoLogradouro() == null
				|| doacao.getEndereco().getLogradouro().getTipoLogradouro().getNome() == null) {
			retorno = true;

			if (inicio) {
				inicio = false;

				this.saida = "Favor preencher: \n";
			}

			this.saida += " - O Tipo do Logradouro";
		}

		if (doacao.getEndereco().getLogradouro().getNome() == null
				|| doacao.getEndereco().getLogradouro().getNome().length() < 2) {
			retorno = true;

			if (inicio) {
				inicio = false;

				this.saida = "Favor preencher: \n";
			}

			this.saida += " - O Logradouro";
		}

		if (doacao.getEndereco().getComplemento() == null || doacao.getEndereco().getComplemento().length() < 2) {
			retorno = true;

			if (inicio) {
				inicio = false;

				this.saida = "Favor preencher: \n";
			}

			this.saida += " - O Complemento";
		}

		if (doacao.getEndereco().getNumero() == null || doacao.getEndereco().getNumero().toString().length() < 1) {
			retorno = true;

			if (inicio) {
				inicio = false;

				this.saida = "Favor preencher: \n";
			}

			this.saida += " - O Número";
		}

		if (doacao.getTitulo() == null || doacao.getTitulo().length() < 1) {
			retorno = true;

			if (inicio) {
				inicio = false;

				this.saida = "Favor preencher: \n";
			}

			this.saida += " - O Título";
		}

		if (doacao.getDescricao() == null || doacao.getDescricao().length() < 1) {
			retorno = true;

			if (inicio) {
				inicio = false;

				this.saida = "Favor preencher: \n";
			}

			this.saida += " - A Descrição";
		}

		if (doacao.getMaterial() == null || doacao.getMaterial().getNome() == null
				|| doacao.getMaterial().getNome().length() < 1) {
			retorno = true;

			if (inicio) {
				inicio = false;

				this.saida = "Favor preencher: \n";
			}

			this.saida += " - O Tipo do Material";
		}

		if (doacao.getQuantia() == null || doacao.getQuantia() <= 0 || doacao.getMaterial().getNome().length() < 1) {
			retorno = true;

			if (inicio) {
				inicio = false;

				this.saida = "Favor preencher: \n";
			}

			this.saida += " - A Quantidade";
		}

		return retorno;

	}

	@Override
	public String toString() {
		return saida;
	}
	
	

}
