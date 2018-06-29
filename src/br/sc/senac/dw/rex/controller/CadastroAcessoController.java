package br.sc.senac.dw.rex.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.primefaces.model.UploadedFile;

import br.sc.senac.dw.rex.componentes.Upload;
import br.sc.senac.dw.rex.db.model.NivelAcessoDAO;
import br.sc.senac.dw.rex.db.model.PessoaDAO;
import br.sc.senac.dw.rex.db.model.TipoPessoaDAO;
import br.sc.senac.dw.rex.db.model.UsuarioDAO;
import br.sc.senac.dw.rex.db.model.bo.AcessoBO;
import br.sc.senac.dw.rex.db.model.entity.NivelAcesso;
import br.sc.senac.dw.rex.db.model.entity.Pessoa;
import br.sc.senac.dw.rex.db.model.entity.TipoPessoa;
import br.sc.senac.dw.rex.db.model.entity.Usuario;

@Named
@SessionScoped
public class CadastroAcessoController implements Serializable {

	private static final long serialVersionUID = -3954387121126466912L;

	private CadastroAcessoMensagem mensagem;

	private UsuarioDAO usuarioDAO;
	private Usuario usuario;

	private String senhaConfirma;

	private PessoaDAO pessoaDAO;

	private AcessoBO acessoBO;

	private Boolean logado;

	private TipoPessoaDAO tipoPessoaDAO;
	private List<TipoPessoa> tiposPessoa;

	private NivelAcessoDAO nivelAcessoDAO;
	private List<NivelAcesso> niveisTiposUsuario;

	private Part uploadedPhoto;

	public CadastroAcessoController() {
		super();
		construir();
	}

	public CadastroAcessoMensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(CadastroAcessoMensagem mensagem) {
		this.mensagem = mensagem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getSenhaConfirma() {
		return senhaConfirma;
	}

	public void setSenhaConfirma(String senhaConfirma) {
		this.senhaConfirma = senhaConfirma;
	}

	public Boolean getLogado() {
		return logado;
	}

	public void setLogado(Boolean logado) {
		this.logado = logado;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public List<TipoPessoa> getTiposPessoa() {
		return tiposPessoa;
	}

	public void setTiposPessoa(List<TipoPessoa> tiposPessoa) {
		this.tiposPessoa = tiposPessoa;
	}

	public List<NivelAcesso> getNiveisTiposUsuario() {
		return niveisTiposUsuario;
	}

	public void setNiveisTiposUsuario(List<NivelAcesso> niveisTiposUsuario) {
		this.niveisTiposUsuario = niveisTiposUsuario;
	}

	public Part getUploadedPhoto() {
		return uploadedPhoto;
	}

	public void setUploadedPhoto(Part uploadedPhoto) {
		this.uploadedPhoto = uploadedPhoto;
	}

	public void construir() {

		this.mensagem = new CadastroAcessoMensagem();

		this.senhaConfirma = "";

		this.pessoaDAO = new PessoaDAO();
		this.tipoPessoaDAO = new TipoPessoaDAO();
		this.tiposPessoa = tipoPessoaDAO.listarTodos();

		this.nivelAcessoDAO = new NivelAcessoDAO();
		this.niveisTiposUsuario = nivelAcessoDAO.listarTodos();

		this.acessoBO = new AcessoBO();

		this.logado = false;

		this.usuarioDAO = new UsuarioDAO();
		this.usuario = new Usuario();
		this.usuario.setPessoa(new Pessoa());
		this.usuario.getPessoa().setTipoPessoa(tipoPessoaDAO.get("Fisica"));
		this.usuario.setNivelAcesso(nivelAcessoDAO.get("Doador"));

	}

	public void recarregar() {

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void defineDoc(ValueChangeEvent e) {
		this.usuario.getPessoa().setDoc("");
	}

	public void salvar() {

		boolean campoPreencher = this.mensagem.produzMensagem(this.usuario, this.senhaConfirma);

		if (!campoPreencher) {
		
			this.mensagem.setSaida("");

			if (this.usuario.getId() != null) {
				pessoaDAO.alterar(this.usuario.getPessoa());
				usuarioDAO.alterar(this.usuario);

			} else {

				this.getUsuario().getPessoa().setDataInclusao(new Date());
				Long idPessoa = pessoaDAO.inserir(this.usuario.getPessoa());

				this.usuario.getPessoa().setId(idPessoa);
				Long idUsuario = this.usuarioDAO.inserir(this.usuario);

				this.usuario.setId(idUsuario);
				this.logado = true;

			}

			this.usuario.setSenha("");
			this.senhaConfirma = "";
			this.recarregar();
		}

	}

	public boolean logadoEColetor() {

		if (this.logado && this.getUsuario().getNivelAcesso().getNome().equals("Coletor")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean logadoEDoador() {

		if (this.logado && this.getUsuario().getNivelAcesso().getNome().equals("Doador")) {
			return true;
		} else {
			return false;
		}
	}

	public void upload() {
		try {

//			byte[] bytes = null;
		

			if (uploadedPhoto != null) {
				InputStream partInputStream = uploadedPhoto.getInputStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] bytesImagem = new byte[4096];
				int amountRead;
				while ((amountRead = partInputStream.read(bytesImagem)) != -1) {
					outputStream.write(bytesImagem, 0, amountRead);
				}
				if (outputStream.size() > 0) {
//					bytes = outputStream.toByteArray();	
					usuario.getPessoa().setImagem(bytesImagem);
				}
			}
			//Já atualiza a foto da pessoa no BD -> TODO ver com o Nilton porque não salva
			pessoaDAO.alterar(this.usuario.getPessoa());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		try {
//            UploadController upload = UploadController.getInstance();
//            upload.write(uploadedPhoto);
//            usuario.getPessoa().setImagem(uploadedPhoto.getSubmittedFileName());            
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
		
	}

	// public void salvaImagemNaPasta(FileUploadEvent event) {
	// file = event.getFile();
	//
	// if (file != null) {
	//
	// File file1 = new File("D:\\usuario\\desktop\\upload", file.getFileName());
	// try {
	// FileOutputStream fos = new FileOutputStream(file1);
	// fos.write(event.getFile().getContents());
	// fos.close();
	//
	// FacesContext instance = FacesContext.getCurrentInstance();
	// instance.addMessage("mensagens", new FacesMessage(FacesMessage.SEVERITY_INFO,
	// file.getFileName() + " anexado com sucesso", null));
	// } catch (FileNotFoundException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	//
	// }
	// }

}
