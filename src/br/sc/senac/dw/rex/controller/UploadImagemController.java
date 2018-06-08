//package br.sc.senac.dw.rex.controller;
//
//import java.io.File;
//import java.io.IOException;
//
//import javax.mail.Part;
//
//import br.sc.senac.dw.rex.db.model.entity.UploadImagem;
//
//public class UploadImagemController {
//
//	private static final UploadImagemController INSTANCE = new UploadImagemController();
//
////	private public UploadImagemController();
//
//	public void write(Part part) throws IOException {
//		String fileName = extractFileName(part);
//		String filePath = "";
//
//		File fileSaveDir = new File(filePath);
//		if (!fileSaveDir.exists()) {
//			fileSaveDir.mkdir();
////		}
//
//		part.write(filePath + File.separator + fileName);
//	}
//
//	public String extractFileName(Part part) {
//		String contentDisp = part.getHeader("content-disposition");
//		String[] items = contentDisp.split(";");
//		for (String s : items) {
//			if (s.trim().startsWith("filename")) {
//				return s.substring(s.indexOf("=") + 2, s.length() - 1);
//			}
//		}
//		return "";
//	}
//
//	public static UploadImagem getInstance() {
//		return INSTANCE;
//	}
//
//}
