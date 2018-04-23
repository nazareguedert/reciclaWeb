package br.sc.senac.dw.rex.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.sc.senac.dw.rex.db.model.entity.Doacao;

@Named
@SessionScoped
public class DetalhesColetaController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3476600629823015339L;

	private Doacao doacao;

	public DetalhesColetaController() {
		super();
	}

	public Doacao getDoacao() {
		return doacao;
	}

	public void setDoacao(Doacao doacao) {
		this.doacao = doacao;
	}
	
	

}
