//package br.sc.senac.dw.rex.uploadimage;
//import java.io.File;
//import java.io.FileOutputStream;
//
//import javax.faces.context.ExternalContext;
//import javax.faces.context.FacesContext;
//import javax.faces.view.ViewScoped;
//import javax.inject.Named;
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletResponse;
//
//import org.primefaces.event.FileUploadEvent;
//
////package br.sc.senac.dw.rex.controller;
////
////import java.io.File;
////import java.io.IOException;
////
////import javax.mail.Part;
////
////import br.sc.senac.dw.rex.db.model.entity.UploadImagem;
////
//
//@Named
//@ViewScoped
//public class UploadImagemController {
//	
//	
//	public void fileUploadAction(FileUploadEvent event) {
//        try {
//            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
//
//            FacesContext aFacesContext = FacesContext.getCurrentInstance();
//            ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();
//           
//            String realPath = context.getRealPath("/");
// 
// // Aqui cria o diretorio caso não exista
//            File file = new File(realPath + "/fotos/");
//            file.mkdirs();
//            
//            byte[] arquivo = event.getFile().getContents();
//            String caminho = realPath + "/fotos/" + event.getFile().getFileName();    
//      
// // esse trecho grava o arquivo no diretório
//            FileOutputStream fos = new FileOutputStream(caminho);
//            fos.write(arquivo);
//            fos.close();
//            
//
//        } catch (Exception ex) {
//            System.out.println("Erro no upload de imagem" + ex);
//        }
//    }
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
////
////	private static final UploadImagemController INSTANCE = new UploadImagemController();
////
//////	private public UploadImagemController();
////
////	public void write(Part part) throws IOException {
////		String fileName = extractFileName(part);
////		String filePath = "";
////
////		File fileSaveDir = new File(filePath);
////		if (!fileSaveDir.exists()) {
////			fileSaveDir.mkdir();
//////		}
////
////		part.write(filePath + File.separator + fileName);
////	}
////
////	public String extractFileName(Part part) {
////		String contentDisp = part.getHeader("content-disposition");
////		String[] items = contentDisp.split(";");
////		for (String s : items) {
////			if (s.trim().startsWith("filename")) {
////				return s.substring(s.indexOf("=") + 2, s.length() - 1);
////			}
////		}
////		return "";
////	}
////
////	public static UploadImagem getInstance() {
////		return INSTANCE;
////	}
////
//}
