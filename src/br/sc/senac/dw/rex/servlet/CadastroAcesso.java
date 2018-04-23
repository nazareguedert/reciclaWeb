package br.sc.senac.dw.rex.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sc.senac.dw.rex.db.ConexaoDB;
import br.sc.senac.dw.rex.db.model.BairroDAO;
import br.sc.senac.dw.rex.db.model.DoacaoDAO;
import br.sc.senac.dw.rex.db.model.EnderecoDAO;
import br.sc.senac.dw.rex.db.model.EstadoDAO;
import br.sc.senac.dw.rex.db.model.LogradouroDAO;
import br.sc.senac.dw.rex.db.model.MaterialDAO;
import br.sc.senac.dw.rex.db.model.MunicipioDAO;
import br.sc.senac.dw.rex.db.model.NivelAcessoDAO;
import br.sc.senac.dw.rex.db.model.PaisDAO;
import br.sc.senac.dw.rex.db.model.PessoaDAO;
import br.sc.senac.dw.rex.db.model.StatusDoacaoDAO;
import br.sc.senac.dw.rex.db.model.TelefoneDAO;
import br.sc.senac.dw.rex.db.model.TipoLogradouroDAO;
import br.sc.senac.dw.rex.db.model.TipoPessoaDAO;
import br.sc.senac.dw.rex.db.model.UnidadeMedidaDAO;
import br.sc.senac.dw.rex.db.model.UsuarioDAO;
import br.sc.senac.dw.rex.db.model.bo.AcessoBO;
import br.sc.senac.dw.rex.db.model.bo.AnuncioBO;
import br.sc.senac.dw.rex.db.model.bo.LocalidadeBO;
import br.sc.senac.dw.rex.db.model.entity.Bairro;
import br.sc.senac.dw.rex.db.model.entity.Doacao;
import br.sc.senac.dw.rex.db.model.entity.Endereco;
import br.sc.senac.dw.rex.db.model.entity.Estado;
import br.sc.senac.dw.rex.db.model.entity.Logradouro;
import br.sc.senac.dw.rex.db.model.entity.Material;
import br.sc.senac.dw.rex.db.model.entity.Municipio;
import br.sc.senac.dw.rex.db.model.entity.NivelAcesso;
import br.sc.senac.dw.rex.db.model.entity.Pais;
import br.sc.senac.dw.rex.db.model.entity.Pessoa;
import br.sc.senac.dw.rex.db.model.entity.StatusDoacao;
import br.sc.senac.dw.rex.db.model.entity.TipoLogradouro;
import br.sc.senac.dw.rex.db.model.entity.TipoPessoa;
import br.sc.senac.dw.rex.db.model.entity.UnidadeMedida;
import br.sc.senac.dw.rex.db.model.entity.Usuario;

/**
 * Servlet implementation class CadastroAcesso
 */
@WebServlet("/CadastroAcesso")
public class CadastroAcesso extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//Endere�o
	PaisDAO paisDAO = new PaisDAO();
	EstadoDAO estadoDAO = new EstadoDAO();
	MunicipioDAO municipioDAO = new MunicipioDAO();
	BairroDAO bairroDAO = new BairroDAO();
	TipoLogradouroDAO tipoLogradouroDAO = new TipoLogradouroDAO();
	LogradouroDAO logradouroDAO = new LogradouroDAO();
	EnderecoDAO enderecoDAO = new EnderecoDAO();
	LocalidadeBO localidadeBO = new LocalidadeBO();
	
	//Pessoa
	TipoPessoaDAO tipoPessoaDAO = new TipoPessoaDAO();
	PessoaDAO pessoaDAO = new PessoaDAO();
	TelefoneDAO telefoneDAO = new TelefoneDAO();
	
	//Usuario
	NivelAcessoDAO nivelAcessoDAO = new NivelAcessoDAO();
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	AcessoBO acessoBO = new AcessoBO();
	
	//Doacao
	DoacaoDAO doacaoDAO = new DoacaoDAO();
	StatusDoacaoDAO statusdoacaoDAO = new StatusDoacaoDAO();
	MaterialDAO materialDAO = new MaterialDAO();
	UnidadeMedidaDAO unidademedidaDAO = new UnidadeMedidaDAO();
	AnuncioBO anuncioBO = new AnuncioBO();

	
	
	
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroAcesso() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		

		Boolean cx = ConexaoDB.conexaoHabil();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append(" - Conexão DB estabelecida: " + cx.toString());
		response.getWriter().append("<br/><br/><br/>");


		
//		Doacao doacao = doacaoDAO.getPorId(2L);
		
//		System.out.println(doacao.toString());
		
		

//		response.getWriter().append("Lista País: " + paisDAO.listarTodos());
//		response.getWriter().append("<br>");
//		response.getWriter().append("Lista Estado: " + estadoDAO.listarTodos());
//		response.getWriter().append("<br>");
//		response.getWriter().append("Lista Município: " + municipioDAO.listarTodos());
//		response.getWriter().append("<br>");
//		response.getWriter().append("Lista Bairro: " + bairroDAO.listarTodos());
//		response.getWriter().append("<br>");
//		response.getWriter().append("Lista Tipo Pessoa: " + tipoPessoaDAO.listarTodos());

		if(cx) {
			
			verificaBanco();

			response.getWriter().append("Lista País: " + paisDAO.listarTodos());
			response.getWriter().append("<br/><br/>");
			response.getWriter().append("Lista Estado: " + estadoDAO.listarTodos());
			response.getWriter().append("<br/><br/>");
			response.getWriter().append("Lista Município: " + municipioDAO.listarTodos());
			response.getWriter().append("<br/><br/>");
			response.getWriter().append("Lista Bairro: " + bairroDAO.listarTodos());
			response.getWriter().append("<br/><br/>");
			response.getWriter().append("Lista Tipo Logradouro: " + tipoLogradouroDAO.listarTodos());
			response.getWriter().append("<br/><br/>");
			response.getWriter().append("Lista Logradouro: " + logradouroDAO.listarTodos());
			response.getWriter().append("<br/><br/>");
			response.getWriter().append("Lista Endereco: " + enderecoDAO.listarTodos());
			response.getWriter().append("<br/><br/>");
			response.getWriter().append("Lista Tipo Pessoa: " + tipoPessoaDAO.listarTodos());
			response.getWriter().append("<br/><br/>");
			response.getWriter().append("Lista Pessoa: " + pessoaDAO.listarTodos());
			response.getWriter().append("<br/><br/>");
//			response.getWriter().append("Lista Telefone: " + telefoneDAO.listarTodos());
//			response.getWriter().append("<br/><br/>");
			response.getWriter().append("Lista Nivel Acesso: " + nivelAcessoDAO.listarTodos());
			response.getWriter().append("<br/><br/>");
			response.getWriter().append("Lista Usuario: " + usuarioDAO.listarTodos());
			response.getWriter().append("<br/><br/>");
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void verificaBanco() {

		if (paisDAO.listarTodos().size() <= 0) {
			paisDAO.inserir(new Pais("Brasil"));
			// paisDAO.inserir(new Pais("Estados Unidos"));
		}

		if (estadoDAO.listarTodos().size() <= 0) {
			estadoDAO.inserir(new Estado("Acre", "AC", "Norte", paisDAO.getPorId(1L))); // Rio Branco
			estadoDAO.inserir(new Estado("Alagoas", "AL", "Nordeste", paisDAO.getPorId(1L))); // Maceió
			estadoDAO.inserir(new Estado("Amapa", "AP", "Norte", paisDAO.getPorId(1L))); // Macapá
			estadoDAO.inserir(new Estado("Amazonas", "AM", "Norte", paisDAO.getPorId(1L))); // Manaus
			estadoDAO.inserir(new Estado("Bahia", "BA", "Nordeste", paisDAO.getPorId(1L))); // Salvador
			estadoDAO.inserir(new Estado("Ceara", "CE", "Nordeste", paisDAO.getPorId(1L))); // Fortaleza
			estadoDAO.inserir(new Estado("Distrito Federal", "DF", "Centro-Oeste", paisDAO.getPorId(1L))); // Brasília
			estadoDAO.inserir(new Estado("Espirito Santo", "ES", "Sudeste", paisDAO.getPorId(1L))); // Vitória
			estadoDAO.inserir(new Estado("Goias", "GO", "Centro-Oeste", paisDAO.getPorId(1L))); // Goiânia
			estadoDAO.inserir(new Estado("Maranhao", "MA", "Nordeste", paisDAO.getPorId(1L))); // São Luís
			estadoDAO.inserir(new Estado("Mato Grosso", "MT", "Centro-Oeste", paisDAO.getPorId(1L))); // Cuiabá
			estadoDAO.inserir(new Estado("Mato Grosso do Sul", "MS", "Centro-Oeste", paisDAO.getPorId(1L))); // Campo
																												// Grande
			estadoDAO.inserir(new Estado("Minas Gerais", "MG", "Sudeste", paisDAO.getPorId(1L))); // Belo Horizonte
			estadoDAO.inserir(new Estado("Para", "PA", "Norte", paisDAO.getPorId(1L))); // Belém
			estadoDAO.inserir(new Estado("Paraiba", "PB", "Nordeste", paisDAO.getPorId(1L))); // João Pessoa
			estadoDAO.inserir(new Estado("Parana", "PR", "Norte", paisDAO.getPorId(1L))); // Curitiba
			estadoDAO.inserir(new Estado("Pernambuco", "PE", "Nordeste", paisDAO.getPorId(1L))); // Recife
			estadoDAO.inserir(new Estado("Piaui", "PI", "Nordeste", paisDAO.getPorId(1L))); // Teresina
			estadoDAO.inserir(new Estado("Rio de Janeiro", "RJ", "Sudeste", paisDAO.getPorId(1L))); // Rio de Janeiro
			estadoDAO.inserir(new Estado("Rio Grande do Norte", "RN", "Nordeste", paisDAO.getPorId(1L))); // Natal
			estadoDAO.inserir(new Estado("Rio Grande do Sul", "RS", "Sul", paisDAO.getPorId(1L))); // Porto Alegre
			estadoDAO.inserir(new Estado("Rondonia", "RO", "Norte", paisDAO.getPorId(1L))); // Porto Velho
			estadoDAO.inserir(new Estado("Roraima", "RR", "Norte", paisDAO.getPorId(1L))); // Boa Vista
			estadoDAO.inserir(new Estado("Santa Catarina", "SC", "Sul", paisDAO.getPorId(1L))); // Florianópolis
			estadoDAO.inserir(new Estado("Sao Paulo", "SP", "Sudeste", paisDAO.getPorId(1L))); // São Paulo
			estadoDAO.inserir(new Estado("Sergipe", "SE", "Nordeste", paisDAO.getPorId(1L))); // Aracaju
			estadoDAO.inserir(new Estado("Tocantins", "TO", "Norte", paisDAO.getPorId(1L))); // Palmas
		}

		if (municipioDAO.listarTodos().size() <= 0) {
			municipioDAO.inserir(new Municipio("Florianopolis", estadoDAO.get("Santa Catarina")));
		}

		if (bairroDAO.listarTodos().size() <= 0) {
			bairroDAO.inserir(new Bairro("Centro", municipioDAO.get("Florianopolis")));
			bairroDAO.inserir(new Bairro("Ingleses", municipioDAO.get("Florianopolis")));
		}
		
		if (tipoLogradouroDAO.listarTodos().size() <= 0) {
			tipoLogradouroDAO.inserir(new TipoLogradouro("Rua"));
			tipoLogradouroDAO.inserir(new TipoLogradouro("Avenida"));
			tipoLogradouroDAO.inserir(new TipoLogradouro("Rodovia"));
		}
		
		if (logradouroDAO.listarTodos().size() <= 0) {
			logradouroDAO.inserir(new Logradouro(tipoLogradouroDAO.getPorId(1L), "Rua das Caxopas"));
			logradouroDAO.inserir(new Logradouro(tipoLogradouroDAO.getPorId(2L), "Rua das Rosas"));
			logradouroDAO.inserir(new Logradouro(tipoLogradouroDAO.getPorId(1L), "Rua das Lorotas"));

		}
		
		if (enderecoDAO.listarTodos().size() <= 0) {
			enderecoDAO.inserir(new Endereco("88020-080", 2F, 2F, bairroDAO.getPorId(1L), logradouroDAO.get("Rua das Caxopas"), 210,"Ap 101"));
			enderecoDAO.inserir(new Endereco("88090-380", 3F, 4F, bairroDAO.getPorId(1L), logradouroDAO.get("Rua das Rosas"), 155,"casa"));
			enderecoDAO.inserir(new Endereco("88322-150", 5F, 3F, bairroDAO.getPorId(1L), logradouroDAO.get("Rua das Lorotas"), 350,"Ap 304"));
		}
		
		if (tipoPessoaDAO.listarTodos().size() <= 0) {
			tipoPessoaDAO.inserir(new TipoPessoa("Fisica", "###.###.###-##"));
			tipoPessoaDAO.inserir(new TipoPessoa("Juridica", "##.###.###/####-##"));
		}
		
		if(pessoaDAO.listarTodos().size() <= 0) {
			pessoaDAO.inserir(new Pessoa(tipoPessoaDAO.get("Fisica"), "090.002.889-08", "Augusto", "Guto", "guto@bol.com", enderecoDAO.getPorId(1L), "(44) 8899-2322"));
			pessoaDAO.inserir(new Pessoa(tipoPessoaDAO.get("Fisica"), "453.612.543-55", "Nilton", "Ni", "nilton@bol.com", enderecoDAO.getPorId(2L), "(45) 8899-2322"));
			pessoaDAO.inserir(new Pessoa(tipoPessoaDAO.get("Fisica"), "348.865.940-99", "Nazare", "Na", "nazare@bol.com", enderecoDAO.getPorId(3L), "(46) 8899-2322"));
			pessoaDAO.inserir(new Pessoa(tipoPessoaDAO.get("Fisica"), "854.935.948-00", "Guilherme", "Gui", "guilherme@bol.com", enderecoDAO.getPorId(1L), "(47) 8899-2322"));
			pessoaDAO.inserir(new Pessoa(tipoPessoaDAO.get("Fisica"), "284.546.943-00", "Maria", "Ma", "maria@bol.com", enderecoDAO.getPorId(2L), "(48) 8899-2322"));
			pessoaDAO.inserir(new Pessoa(tipoPessoaDAO.get("Fisica"), "220.449.339-87", "Joao", "Jo", "joao@bol.com", enderecoDAO.getPorId(3L), "(49) 8899-2322"));
			pessoaDAO.inserir(new Pessoa(tipoPessoaDAO.get("Fisica"), "546.759.887-65", "Jony", "Jon", "jon@bol.com", enderecoDAO.getPorId(1L), "(50) 8899-2322"));
			pessoaDAO.inserir(new Pessoa(tipoPessoaDAO.get("Fisica"), "235.857.356-57", "Dino", "Dynamo", "dino@bol.com", enderecoDAO.getPorId(2L), "(51) 8899-2322"));
			pessoaDAO.inserir(new Pessoa(tipoPessoaDAO.get("Fisica"), "723.532.237-35", "Jordi", "Jor", "jordi@bol.com", enderecoDAO.getPorId(3L), "(52) 8899-2322"));
			pessoaDAO.inserir(new Pessoa(tipoPessoaDAO.get("Fisica"), "717.621.521-23", "Shenk", "Shac", "shac@bol.com", enderecoDAO.getPorId(1L), "(53) 8899-2322"));
			pessoaDAO.inserir(new Pessoa(tipoPessoaDAO.get("Fisica"), "712.566.788-56", "Shopson", "Shop", "shopson@bol.com", enderecoDAO.getPorId(2L), "(54) 8899-2322"));
			pessoaDAO.inserir(new Pessoa(tipoPessoaDAO.get("Fisica"), "124.677.688-64", "Ding", "Dong", "dingdong@bol.com", enderecoDAO.getPorId(3L), "(55) 8899-2322"));
		}
		
//		if (telefoneDAO.listarTodos().size() <= 0) {
//			telefoneDAO.inserir(new Telefone(pessoaDAO.getPorId(1L), "99884433"));
//			telefoneDAO.inserir(new Telefone(pessoaDAO.getPorId(2L), "84564386"));
//			telefoneDAO.inserir(new Telefone(pessoaDAO.getPorId(3L), "42945938"));
//			telefoneDAO.inserir(new Telefone(pessoaDAO.getPorId(4L), "43495329"));
//			telefoneDAO.inserir(new Telefone(pessoaDAO.getPorId(5L), "59420394"));
//			telefoneDAO.inserir(new Telefone(pessoaDAO.getPorId(6L), "94238495"));
//			telefoneDAO.inserir(new Telefone(pessoaDAO.getPorId(7L), "71224234"));
//			telefoneDAO.inserir(new Telefone(pessoaDAO.getPorId(8L), "82512424"));
//			telefoneDAO.inserir(new Telefone(pessoaDAO.getPorId(9L), "85122415"));
//			telefoneDAO.inserir(new Telefone(pessoaDAO.getPorId(10L), "81242646"));
//			telefoneDAO.inserir(new Telefone(pessoaDAO.getPorId(11L), "84124546"));
//			telefoneDAO.inserir(new Telefone(pessoaDAO.getPorId(12L), "83578643"));	
//		}
		
		if(nivelAcessoDAO.listarTodos().size() <= 0) {
			nivelAcessoDAO.inserir(new NivelAcesso("Doador", 1));
			nivelAcessoDAO.inserir(new NivelAcesso("Coletor", 2));
		}
		
		if(usuarioDAO.listarTodos().size() <= 0) {
			usuarioDAO.inserir(new Usuario("guto1810", "1234", pessoaDAO.getPorId(1L), nivelAcessoDAO.getPorId(1L)));
			usuarioDAO.inserir(new Usuario("nilton123", "1234", pessoaDAO.getPorId(2L), nivelAcessoDAO.getPorId(2L)));
			usuarioDAO.inserir(new Usuario("nazare321", "1234", pessoaDAO.getPorId(3L), nivelAcessoDAO.getPorId(1L)));
			usuarioDAO.inserir(new Usuario("guilherme123", "1234", pessoaDAO.getPorId(4L), nivelAcessoDAO.getPorId(2L)));
			usuarioDAO.inserir(new Usuario("maria33", "1234", pessoaDAO.getPorId(5L),nivelAcessoDAO.getPorId(1L)));
			usuarioDAO.inserir(new Usuario("joao25", "1234", pessoaDAO.getPorId(6L), nivelAcessoDAO.getPorId(1L)));
			usuarioDAO.inserir(new Usuario("jony55", "1234", pessoaDAO.getPorId(7L), nivelAcessoDAO.getPorId(2L)));
			usuarioDAO.inserir(new Usuario("dino44", "1234", pessoaDAO.getPorId(8L), nivelAcessoDAO.getPorId(2L)));
			usuarioDAO.inserir(new Usuario("jordi66", "1234", pessoaDAO.getPorId(9L), nivelAcessoDAO.getPorId(2L)));
			usuarioDAO.inserir(new Usuario("shenk123", "1234", pessoaDAO.getPorId(10L), nivelAcessoDAO.getPorId(1L)));
			usuarioDAO.inserir(new Usuario("shopz", "1234", pessoaDAO.getPorId(11L), nivelAcessoDAO.getPorId(2L)));
			usuarioDAO.inserir(new Usuario("dingdong123", "1234", pessoaDAO.getPorId(12L), nivelAcessoDAO.getPorId(1L)));
		}
		
		if(statusdoacaoDAO.listarTodos().size() <= 0) {
			statusdoacaoDAO.inserir(new StatusDoacao("Aberto"));
			statusdoacaoDAO.inserir(new StatusDoacao("Reservado"));
			statusdoacaoDAO.inserir(new StatusDoacao("Encerrado"));
		}
		
		if(unidademedidaDAO.listarTodos().size() <= 0) {
			unidademedidaDAO.inserir(new UnidadeMedida("kg"));
			unidademedidaDAO.inserir(new UnidadeMedida("litro"));
		}
		
		if(materialDAO.listarTodos().size() <= 0) {
			materialDAO.inserir(new Material("Diversos", unidademedidaDAO.getPorId(1L)));
			materialDAO.inserir(new Material("Aluminio", unidademedidaDAO.getPorId(1L)));
			materialDAO.inserir(new Material("Oleo", unidademedidaDAO.getPorId(2L)));
			materialDAO.inserir(new Material("Papel", unidademedidaDAO.getPorId(1L)));
		}
		
		if(doacaoDAO.listarTodos().size() <= 0) {
			doacaoDAO.inserir(new Doacao("Ofereco materiais" , "Materiais para coleta" , usuarioDAO.getPorId(1L), null, enderecoDAO.getPorId(1L), statusdoacaoDAO.getPorId(1L), materialDAO.getPorId(1L), 15)); //tabela doacao necessita dos campos titulo e descricao!
			doacaoDAO.inserir(new Doacao("Materiais aqui" , "Otimos materiais" , usuarioDAO.getPorId(3L), null, enderecoDAO.getPorId(2L), statusdoacaoDAO.getPorId(1L), materialDAO.getPorId(2L), 4));
			doacaoDAO.inserir(new Doacao("Disponibilizo materiais" , "Materiais disponiveis no Centro" , usuarioDAO.getPorId(5L), null, enderecoDAO.getPorId(3L), statusdoacaoDAO.getPorId(2L), materialDAO.getPorId(1L), 10));
			doacaoDAO.inserir(new Doacao("Doacaoo de materiais" , "Ja disponiveis para coleta" , usuarioDAO.getPorId(6L), null, enderecoDAO.getPorId(1L), statusdoacaoDAO.getPorId(2L), materialDAO.getPorId(1L), 8));
			doacaoDAO.inserir(new Doacao("Coleta de aluminio" , "Bons materiais" , usuarioDAO.getPorId(10L), null, enderecoDAO.getPorId(2L), statusdoacaoDAO.getPorId(3L), materialDAO.getPorId(2L), 25));
			doacaoDAO.inserir(new Doacao("Galoes de Oleo usado" , "Disponibilizo para coleta" , usuarioDAO.getPorId(12L), null, enderecoDAO.getPorId(3L), statusdoacaoDAO.getPorId(3L), materialDAO.getPorId(3L), 85));
		}
		
//		if(materialdoacaoDAO.listarTodos().size() <= 0) {
//			materialdoacaoDAO.inserir(new MaterialDoacao(1L, materialDAO.getPorId(1L), 15));
//			materialdoacaoDAO.inserir(new MaterialDoacao(1L, materialDAO.getPorId(2L), 4));
//			materialdoacaoDAO.inserir(new MaterialDoacao(2L, materialDAO.getPorId(1L), 10));
//			materialdoacaoDAO.inserir(new MaterialDoacao(3L, materialDAO.getPorId(1L), 8));
//			materialdoacaoDAO.inserir(new MaterialDoacao(4L, materialDAO.getPorId(2L), 20));
//			materialdoacaoDAO.inserir(new MaterialDoacao(5L, materialDAO.getPorId(1L), 80));
//			materialdoacaoDAO.inserir(new MaterialDoacao(6L, materialDAO.getPorId(2L), 25));
//			materialdoacaoDAO.inserir(new MaterialDoacao(6L, materialDAO.getPorId(1L), 85));
//		}
	}
}