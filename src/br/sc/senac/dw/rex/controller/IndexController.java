package br.sc.senac.dw.rex.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class IndexController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2706225487949539492L;

	private Boolean doIndex;

	private String centro;

	public IndexController() {
		this.centro = "landing_page.xhtml";
		
	}
	
	public void validar() {

		if (this.doIndex == true) {
			this.doIndex = false;

		} else {
			this.recarregar();
		}
	}

	public void recarregar() {

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public Boolean getDoIndex() {
		return doIndex;
	}

	public void setDoIndex(Boolean doIndex) {
		this.doIndex = doIndex;
	}

	public String getCentro() {
		return centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

	public void logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		this.centro = "landing_page.xhtml";
		recarregar();
	}

}