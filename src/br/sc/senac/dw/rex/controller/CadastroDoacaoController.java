package br.sc.senac.dw.rex.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.sc.senac.dw.buscacep.CepWebService;
import br.sc.senac.dw.rex.db.model.BairroDAO;
import br.sc.senac.dw.rex.db.model.DoacaoDAO;
import br.sc.senac.dw.rex.db.model.MaterialDAO;
import br.sc.senac.dw.rex.db.model.MunicipioDAO;
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
import br.sc.senac.dw.rex.db.model.entity.TipoLogradouro;
import br.sc.senac.dw.rex.db.model.entity.Usuario;

@SuppressWarnings("cdi-ambiguous-dependency")
@Named
@SessionScoped
public class CadastroDoacaoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5315187528724402043L;

	private static final Long CODIGO_PAIS_BRASIL = 1L;

	private static final String BAIRRO_CENTRO = "Centro";

	private final CadastroAcessoController cadastroAcessoController;

	private CadastroDoacaoMensagem mensagem;

	private LocalidadeBO localidadeBO;
	private AnuncioBO anuncioBO;
	private Doacao doacao;

	private List<Pais> paises;
	private List<Estado> estados;
	private List<Municipio> municipios;
	private List<Bairro> bairros;

	private BairroDAO bairroDAO;
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

		this.bairroDAO = new BairroDAO();
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
		this.estados = localidadeBO.listarEstadosPorPais(CODIGO_PAIS_BRASIL);
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
	
	public void consultar() {
		
		CepWebService cws = new CepWebService(this.doacao.getEndereco().getCep());
		
		this.doacao.getEndereco().getLogradouro().getTipoLogradouro().setNome(cws.getTipoLogradouro());
		this.doacao.getEndereco().getLogradouro().setNome(cws.getLogradouro());
		
		String nomeBairro;
		if (cws.getBairro() != null && !cws.getBairro().equals("")) {
			nomeBairro = cws.getBairro();
			this.doacao.getEndereco().getBairro().setNome(cws.getBairro());
		} else {
			nomeBairro = BAIRRO_CENTRO;
			this.doacao.getEndereco().getBairro().setNome(BAIRRO_CENTRO);
		}
//		bairroDAO.inserir(this.doacao.getEndereco().getBairro());
		
		Estado estadoSelecionado = this.getEstadoPorUF(cws.getEstado());
		Municipio municipioSelecionado = null;
		
		if (estadoSelecionado != null) {
			this.municipios = localidadeBO.listarMunicipiosPorEstado(estadoSelecionado.getId());
			municipioSelecionado = this.getMunicipioPorNome(cws.getCidade());
		}
		
		if(municipioSelecionado == null) {
			municipioSelecionado = criarMunicipio(cws.getCidade(), estadoSelecionado);
			this.municipios = localidadeBO.listarMunicipiosPorEstado(estadoSelecionado.getId());
		}
		
		Bairro bairroSelecionado = this.getBairroPorNomeEMunicipio(nomeBairro, municipioSelecionado.getId());
		
		if(bairroSelecionado == null) {
			bairroSelecionado = criarBairro(nomeBairro, municipioSelecionado);
			this.bairros = localidadeBO.listarBairrosPorMunicipio(municipioSelecionado.getId());
		}
		//TODO fazer a mesma verificação para LOCALIDADE
		
		this.doacao.getEndereco().getBairro().setMunicipio(municipioSelecionado);
	}
	

	private Bairro getBairroPorNomeEMunicipio(String nomeBairro, Long idMunicipio) {
		this.bairros =  localidadeBO.listarBairrosPorMunicipio(idMunicipio);
		for(Bairro b: this.bairros) {
			//TODO verificar o cadastro dos NOMES (acentos, case sensitive, etc.)
			if(b.getNome().equals(nomeBairro)) {
				return b;
			}
		}
		return null;
	}

	private Municipio criarMunicipio(String nome, Estado estado) {
		MunicipioDAO dao = new MunicipioDAO();
		Municipio novoMunicipio = new Municipio(nome, estado, new Date(), null);
		Long idNovoMunicipio = dao.inserir(novoMunicipio);
		novoMunicipio.setId(idNovoMunicipio);
		
		return novoMunicipio;
	}
	
	private Bairro criarBairro(String nome, Municipio municipio) {
		BairroDAO dao = new BairroDAO();
		Bairro novoBairro = new Bairro(nome, municipio);
		Long idNovoBairro = dao.inserir(novoBairro);
		novoBairro.setId(idNovoBairro);
		
		return novoBairro;
	}
	
	private Estado getEstadoPorUF(String uf) {
		for(Estado e: this.estados) {
			if(e.getUf().equals(uf)) {
				return e;
			}
		}
		return null;
	}
	
	private Municipio getMunicipioPorNome(String nomeMunicipio) {
		for(Municipio m: this.municipios) {
			//TODO verificar o cadastro dos NOMES (acentos, case sensitive, etc.)
			if(m.getNome().equals(nomeMunicipio)) {
				return m;
			}
		}
		return null;
	}

}
