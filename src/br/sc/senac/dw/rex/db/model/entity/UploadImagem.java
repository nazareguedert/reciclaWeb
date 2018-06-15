package br.sc.senac.dw.rex.db.model.entity;

import java.io.File;
import java.io.FileOutputStream;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.FileUploadEvent;

//public void upload() {
//	  try {
//	    File file = new File(diretorioRaiz(), uploadedFile.getFileName());
//	 
//	    OutputStream out = new FileOutputStream(file);
//	    out.write(uploadedFile.getContents());
//	    out.close();
//	 
//	    FacesContext.getCurrentInstance().addMessage(
//	               null, new FacesMessage("Upload completo", 
//	               "O arquivo " + uploadedFile.getFileName() + " foi salvo!"));
//	  } catch(IOException e) {
//	    FacesContext.getCurrentInstance().addMessage(
//	              null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
//	  }
//	 
//	}

public class UploadImagem {
	public void fileUploadAction(FileUploadEvent event) {

		try {
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

			FacesContext aFacesContext = FacesContext.getCurrentInstance();
			ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();

			String realPath = context.getRealPath("/");

			// Aqui cria o diretorio caso não exista
			File file = new File(realPath + "/fotos/");
			file.mkdirs();

			byte[] arquivo = event.getFile().getContents();
			String caminho = realPath + "/fotos/" + event.getFile().getFileName();

			// esse trecho grava o arquivo no diretório
			FileOutputStream fos = new FileOutputStream(caminho);
			fos.write(arquivo);
			fos.close();

		} catch (Exception ex) {
			System.out.println("Erro no upload de imagem" + ex);
		}

	}
}

// package br.sc.senac.dw.rex.db.model.entity;
//
// import java.io.IOException;
//
// import br.sc.senac.dw.rex.controller.UploadImagemController;
//
// public class UploadImagem {
//
// public void upload() {
// try {
// Usuario usuario = new Usuario();
// UploadImagem upload = UploadImagemController.getInstance();
// Object uploadedPhoto;
// upload.write(uploadedPhoto);
// usuario.setFoto(upload.extractFileName(uploadedPhoto));
//
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
//
// }
