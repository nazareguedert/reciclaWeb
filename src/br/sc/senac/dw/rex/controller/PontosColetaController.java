package br.sc.senac.dw.rex.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.sc.senac.dw.rex.db.model.BairroDAO;
import br.sc.senac.dw.rex.db.model.DoacaoDAO;
import br.sc.senac.dw.rex.db.model.MaterialDAO;
import br.sc.senac.dw.rex.db.model.StatusDoacaoDAO;
import br.sc.senac.dw.rex.db.model.bo.AnuncioBO;
import br.sc.senac.dw.rex.db.model.entity.Bairro;
import br.sc.senac.dw.rex.db.model.entity.Doacao;
import br.sc.senac.dw.rex.db.model.entity.Material;
import br.sc.senac.dw.rex.filtro.AnuncioVO;
import br.sc.senac.dw.rex.filtro.FiltroAnuncio;

@Named
@ViewScoped
public class PontosColetaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5919332985553419796L;
	
	private final CadastroAcessoController cadastroAcessoController;

	private StatusDoacaoDAO statusDoacaoDAO;
	
	private List<AnuncioVO> anuncios;

	private List<Doacao> pontosColeta;
	private List<Doacao> pontosSelecionados;
	public List<Doacao> getPontosSelecionados() {
		return pontosSelecionados;
	}

	public void setPontosSelecionados(List<Doacao> pontosSelecionados) {
		this.pontosSelecionados = pontosSelecionados;
	}


	private AnuncioBO anuncioBO;
	private DoacaoDAO doacaoDAO;

	private AnuncioVO anuncioVO;

	private FiltroAnuncio filtro;

	private MaterialDAO tipoMaterialDAO;
	private List<Material> tiposMateriais;

	private BairroDAO bairroDAO;
	private List<Bairro> bairros;

	@Inject
	public PontosColetaController(CadastroAcessoController cadastroAcessoController) {
		
		this.cadastroAcessoController = cadastroAcessoController;
		
		this.statusDoacaoDAO = new StatusDoacaoDAO();
		
		this.anuncioBO = new AnuncioBO();
		// this.pontosdeColeta = anuncioBO.listarDoacoesPorFiltro(null);
		this.doacaoDAO = new DoacaoDAO();

		this.tipoMaterialDAO = new MaterialDAO();
		this.tiposMateriais = tipoMaterialDAO.listarTodos();

		this.bairroDAO = new BairroDAO();
		this.bairros = bairroDAO.listarTodos();

		this.pontosColeta = doacaoDAO.listarTodos(true);

		this.filtro = new FiltroAnuncio();

	}

	public void recarregar() {

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Doacao> getPontosColeta() {
		return pontosColeta;
	}

	public void setPontosColeta(List<Doacao> pontosdeColeta) {
		this.pontosColeta = pontosdeColeta;
	}

	public FiltroAnuncio getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroAnuncio filtro) {
		this.filtro = filtro;
	}

	public List<Material> getTiposMateriais() {
		return tiposMateriais;
	}

	public void setTiposMateriais(List<Material> tiposMateriais) {
		this.tiposMateriais = tiposMateriais;
	}

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	public void consultarPorFiltro() {

		System.out.println(this.filtro.getMaterial());

		this.anuncios = doacaoDAO.listarPorFiltro(this.filtro);

		System.out.println(anuncios);

		this.pontosColeta = new ArrayList<>();
		
		
		if(this.filtro.temCampoPreenchido()) {
			
			for (int i = 0; i < anuncios.size(); i++) {

				String id = (String) anuncios.get(i).getIdDoacoao();

				Long idDoacao = Long.parseLong(id);

				this.pontosColeta.add(doacaoDAO.getPorId(idDoacao));

			}
			
		} else {
			
			this.pontosColeta = doacaoDAO.listarTodos(true);
			this.recarregar();
			
		}


	}
	
	public boolean doador(Long idUsuario) {
		
		if(this.cadastroAcessoController.getUsuario().getId() == idUsuario) {
			return true;
			
		} else {
			return false;
			
		}
	}
	
	public boolean outroDoador(Long idUsuario) {
		
		if(this.cadastroAcessoController.getUsuario().getId() == idUsuario) {
			return false;
			
		} else {
			return true;
			
		}
	}
	
	public boolean podeColetar() {
		
		if(this.cadastroAcessoController.getUsuario().getNivelAcesso().getNome().equals("Doador")) {
			return false;
			
		} else {
			return true;
			
		}
		
	}
	

	public void finalizarDoacao(Long doacao) {
		
		Doacao d = this.doacaoDAO.getPorId(doacao);
		d.setColetor(this.cadastroAcessoController.getUsuario());
		d.setStatusDoacao(statusDoacaoDAO.get("Encerrado"));
		this.doacaoDAO.alterar(d);
		this.doacaoDAO.excluir(doacao);
	}

}
