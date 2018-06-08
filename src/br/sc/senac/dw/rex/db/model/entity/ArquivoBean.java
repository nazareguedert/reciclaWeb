package br.sc.senac.dw.rex.db.model.entity;

import java.io.IOException;
import java.util.Scanner;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.mail.MessagingException;
import javax.mail.Part;

@ManagedBean
public class ArquivoBean {

	private Part arquivo;
	private String fileContent;
	private static final int MAX_SIZE = 2 * 1024 * 1024;


	public void importa() throws MessagingException {
		try {
			String conteudo = new Scanner(arquivo.getInputStream()).useDelimiter("\\A").next();
		} catch (IOException e) {
			// trata o erro
		}
	}

	public void upload(FacesContext context, UIComponent component, Object value) {

		Part arquivo = (Part) value;

		try {
			if (arquivo.getSize() > MAX_SIZE) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Arquivo muito grande",
						"O arquivo deve ter o tamanho máximo de 2mb.");
				throw new ValidatorException(msg);
			}
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if (!"text/plain".equals(arquivo.getContentType())) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Tipo de arquivo inválido",
						"O arquivo deve ser do tipo texto.");
				throw new ValidatorException(msg);
			}
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArquivoBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArquivoBean(Part arquivo, String fileContent) {
		super();
		this.arquivo = arquivo;
		this.fileContent = fileContent;
	}

	public Part getArquivo() {
		return arquivo;
	}

	public void setArquivo(Part arquivo) {
		this.arquivo = arquivo;
	}

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	@Override
	public String toString() {
		return "ArquivoBean [arquivo=" + arquivo + ", fileContent=" + fileContent + "]";
	}

}
