package br.sc.senac.dw.rex.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.sc.senac.dw.rex.db.model.DoacaoDAO;
import br.sc.senac.dw.rex.db.model.MaterialDAO;
import br.sc.senac.dw.rex.db.model.StatusDoacaoDAO;
import br.sc.senac.dw.rex.db.model.TipoLogradouroDAO;
import br.sc.senac.dw.rex.db.model.bo.AnuncioBO;
import br.sc.senac.dw.rex.db.model.bo.LocalidadeBO;
import br.sc.senac.dw.rex.db.model.entity.Bairro;
import br.sc.senac.dw.rex.db.model.entity.Doacao;
import br.sc.senac.dw.rex.db.model.entity.Endereco;
import br.sc.senac.dw.rex.db.model.entity.Estado;
import br.sc.senac.dw.rex.db.model.entity.Logradouro;
import br.sc.senac.dw.rex.db.model.entity.Material;
import br.sc.senac.dw.rex.db.model.entity.Municipio;
import br.sc.senac.dw.rex.db.model.entity.Pais;
import br.sc.senac.dw.rex.db.model.entity.StatusDoacao;
import br.sc.senac.dw.rex.db.model.entity.TipoLogradouro;
import br.sc.senac.dw.rex.db.model.entity.Usuario;

@Named
@SessionScoped
public class CadastroDoacaoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5315187528724402043L;

	private final CadastroAcessoController cadastroAcessoController;

	private CadastroDoacaoMensagem mensagem;

	private LocalidadeBO localidadeBO;
	private AnuncioBO anuncioBO;
	private Doacao doacao;

	private List<Pais> paises;
	private List<Estado> estados;
	private List<Municipio> municipios;
	private List<Bairro> bairros;

	private StatusDoacaoDAO statusDoacaoDAO;
	private DoacaoDAO doacaoDAO;
	private TipoLogradouroDAO tipoLogradouroDAO;
	private List<TipoLogradouro> tiposLogradouro;

	private MaterialDAO tipoMaterialDAO;
	private List<Material> tiposMateriais;

	@Inject
	public CadastroDoacaoController(CadastroAcessoController cadastroAcessoController) {
		super();

		this.cadastroAcessoController = cadastroAcessoController;

		construir();

	}

	public void recarregar() {

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void construir() {

		this.mensagem = new CadastroDoacaoMensagem();

		this.localidadeBO = new LocalidadeBO();

		this.statusDoacaoDAO = new StatusDoacaoDAO();
		this.doacaoDAO = new DoacaoDAO();
		this.doacao = new Doacao("", "", new Usuario(), new Usuario(), new Endereco(), statusDoacaoDAO.get("Aberto"),
				new Material(), 0);
		this.doacao.getEndereco().setBairro(new Bairro());
		this.doacao.getEndereco().getBairro().setMunicipio(new Municipio());
		this.doacao.getEndereco().getBairro().getMunicipio().setEstado(new Estado());
		this.doacao.getEndereco().getBairro().getMunicipio().getEstado().setPais(new Pais());

		this.paises = localidadeBO.listarPaises();

		this.doacao.getEndereco().setLogradouro(new Logradouro());
		this.doacao.getEndereco().getLogradouro().setTipoLogradouro(new TipoLogradouro());

		this.tipoLogradouroDAO = new TipoLogradouroDAO();
		this.tiposLogradouro = tipoLogradouroDAO.listarTodos();

		this.tipoMaterialDAO = new MaterialDAO();
		this.tiposMateriais = tipoMaterialDAO.listarTodos();

		this.anuncioBO = new AnuncioBO();

		this.doacao.setMaterial(new Material());

	}

	public CadastroAcessoController getCadastroAcessoController() {
		return cadastroAcessoController;
	}

	public CadastroDoacaoMensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(CadastroDoacaoMensagem mensagem) {
		this.mensagem = mensagem;
	}

	public Doacao getDoacao() {
		return doacao;
	}

	public void setDoacao(Doacao doacao) {
		this.doacao = doacao;

		this.estados = localidadeBO.listarEstadosPorPais(
				this.doacao.getEndereco().getBairro().getMunicipio().getEstado().getPais().getId());
		this.municipios = localidadeBO
				.listarMunicipiosPorEstado(this.doacao.getEndereco().getBairro().getMunicipio().getEstado().getId());
		this.bairros = localidadeBO
				.listarBairrosPorMunicipio(this.doacao.getEndereco().getBairro().getMunicipio().getId());
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	public List<TipoLogradouro> getTiposLogradouro() {
		return tiposLogradouro;
	}

	public void setTiposLogradouro(List<TipoLogradouro> tiposLogradouro) {
		this.tiposLogradouro = tiposLogradouro;
	}

	public List<Material> getTiposMateriais() {
		return tiposMateriais;
	}

	public void setTiposMateriais(List<Material> tiposMateriais) {
		this.tiposMateriais = tiposMateriais;
	}

	public void defineEstados() {
		// ValueChangeEvent evt
		// Pais selecionado = (Pais)evt.getNewValue();

		Pais selecionado = this.doacao.getEndereco().getBairro().getMunicipio().getEstado().getPais();

		if (selecionado != null && selecionado.getId() != null) {

			constroiEstado(selecionado);
			this.setEstados(localidadeBO.listarEstadosPorPais(selecionado.getId()));

		} else {
			constroiEstado();
			this.doacao.getEndereco().getBairro().getMunicipio().getEstado().setPais(new Pais());

		}

	}

	public void constroiEstado(Pais pais) {
		constroiEstado();
		this.doacao.getEndereco().getBairro().getMunicipio().getEstado().setPais(pais);
	}

	public void constroiEstado() {
		constroiMunicipio();
		this.doacao.getEndereco().getBairro().getMunicipio().setEstado(new Estado());
		this.estados = new ArrayList<>();
	}

	public void defineMunicipios() {

		Estado selecionado = this.doacao.getEndereco().getBairro().getMunicipio().getEstado();

		if (selecionado != null && selecionado.getId() != null) {

			constroiMunicipio(selecionado);
			this.municipios = localidadeBO.listarMunicipiosPorEstado(selecionado.getId());

		} else {
			constroiMunicipio();
			this.doacao.getEndereco().getBairro().getMunicipio().setEstado(new Estado());
		}

	}

	public void constroiMunicipio(Estado estado) {
		constroiMunicipio();
		this.doacao.getEndereco().getBairro().getMunicipio().setEstado(estado);
	}

	public void constroiMunicipio() {
		constroiBairro();
		this.doacao.getEndereco().getBairro().setMunicipio(new Municipio());
		this.municipios = new ArrayList<>();
	}

	public void defineBairros() {

		Municipio selecionado = this.doacao.getEndereco().getBairro().getMunicipio();

		if (selecionado != null && selecionado.getId() != null) {

			constroiBairro(selecionado);
			this.bairros = localidadeBO.listarBairrosPorMunicipio(selecionado.getId());

		} else {
			constroiBairro();
			this.doacao.getEndereco().getBairro().setMunicipio(new Municipio());
		}

	}

	public void constroiBairro(Municipio municipio) {
		constroiBairro();
		this.doacao.getEndereco().getBairro().setMunicipio(municipio);
	}

	public void constroiBairro() {
		this.doacao.getEndereco().setBairro(new Bairro());
		this.bairros = new ArrayList<>();

	}

	// public void incluirMaterial() {
	//
	// MaterialDoacao materialDoacao = new MaterialDoacao();
	// materialDoacao.setDoacao(this.doacao.getId());
	//
	// Material material = new
	// MaterialDAO().getPorId(materialIncluir.getMaterial().getId());
	// materialDoacao.setMaterial(new
	// MaterialDAO().getPorId(materialIncluir.getMaterial().getId()));
	// materialDoacao.setMaterial(materialIncluir.getMaterial());
	//
	// materialDoacao.setQuantia(materialIncluir.getQuantia());
	//
	// this.doacao.getMateriais().add(materialDoacao);
	//
	// this.materialIncluir.setQuantia(null);
	//
	// }

	// public void excluirMaterial(int index) {
	//
	// this.doacao.getMateriais().remove(index);
	// }

	public void salvarDoacao() {

		boolean campoPreencher = this.mensagem.produzMensagem(this.doacao);

			if (!campoPreencher) {
	
				this.mensagem.setSaida("");
	
				this.doacao.setDoador(cadastroAcessoController.getUsuario());
	
				this.anuncioBO.salvarDoacao(this.doacao);
				
				this.construir();
				this.recarregar();
	
			}
	}
	
	public void excluir() {
		this.doacaoDAO.excluir(this.doacao.getId());
		this.construir();
	}

}
