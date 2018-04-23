package br.sc.senac.dw.rex.filtro;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.metamodel.ListAttribute;

import br.sc.senac.dw.rex.db.model.BairroDAO;
import br.sc.senac.dw.rex.db.model.DoacaoDAO;
import br.sc.senac.dw.rex.db.model.EnderecoDAO;
import br.sc.senac.dw.rex.db.model.LogradouroDAO;
import br.sc.senac.dw.rex.db.model.MaterialDAO;
import br.sc.senac.dw.rex.db.model.NivelAcessoDAO;
import br.sc.senac.dw.rex.db.model.StatusDoacaoDAO;
import br.sc.senac.dw.rex.db.model.TipoLogradouroDAO;
import br.sc.senac.dw.rex.db.model.TipoPessoaDAO;
import br.sc.senac.dw.rex.db.model.UsuarioDAO;
import br.sc.senac.dw.rex.db.model.bo.AcessoBO;
import br.sc.senac.dw.rex.db.model.bo.AnuncioBO;
import br.sc.senac.dw.rex.db.model.bo.LocalidadeBO;
import br.sc.senac.dw.rex.db.model.bo.Validador;
import br.sc.senac.dw.rex.db.model.entity.Doacao;
import br.sc.senac.dw.rex.db.model.entity.Endereco;
import br.sc.senac.dw.rex.db.model.entity.Logradouro;
import br.sc.senac.dw.rex.db.model.entity.Material;
import br.sc.senac.dw.rex.db.model.entity.MaterialDoacao;
import br.sc.senac.dw.rex.db.model.entity.Pessoa;
import br.sc.senac.dw.rex.db.model.entity.StatusDoacao;
import br.sc.senac.dw.rex.db.model.entity.Usuario;

public class Testador {

	public static void main(String[] args) {
		AcessoBO acessoBO = new AcessoBO();
		AnuncioBO anuncioBO = new AnuncioBO(); 
		TipoPessoaDAO tipopessoaDAO = new TipoPessoaDAO();
		NivelAcessoDAO nivelacessoDAO = new NivelAcessoDAO();
		LocalidadeBO localidadeBO = new LocalidadeBO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		DoacaoDAO doacaoDAO = new DoacaoDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		StatusDoacaoDAO statusDAO = new StatusDoacaoDAO();
		MaterialDAO materialDAO = new MaterialDAO();
		LogradouroDAO logradouroDAO = new LogradouroDAO();
		BairroDAO bairroDAO = new BairroDAO();
		TipoLogradouroDAO tipologradouroDAO = new TipoLogradouroDAO();
		Validador validador = new Validador();


		
		Logradouro logradouro = new Logradouro(2L, tipologradouroDAO.getPorId(1L), "Rua dasxuuuu Camelias");
		Endereco endereco = new Endereco(2L, "88020998", 0f , 0f , bairroDAO.getPorId(1L), logradouro, 2550, "Casa doseeeeee fundos");
		Doacao doacao = new Doacao(2L, "Boas coisas DEUDHUEAFHUAEF reciclaveis", "Material ja separado, so coletar", usuarioDAO.getPorId(1L), usuarioDAO.getPorId(2L), endereco, statusDAO.getPorId(2L), materialDAO.getPorId(2L), 20);
//		anuncioBO.salvarDoacao(doacao);

		FiltroAnuncio filtroAnuncio = new FiltroAnuncio();
		System.out.println(filtroAnuncio.temCampoPreenchido());
		System.out.println("Resultado validador: " + validador.isConsistente(doacao));
		
		

		
//		Logradouro logradouro = new Logradouro(1L, tipologradouroDAO.getPorId(2L),"Rua Show de Bola");
//		Endereco endereco = new Endereco(1L, "88090443", 0f, 0f, bairroDAO.getPorId(1L), logradouro, 2133, "Casa alagada");
//		Pessoa pessoa = new Pessoa(1L, tipopessoaDAO.getPorId(1L),"78752164195", "Rogerio", "Rogerinho", "rogerinhazzo123@gmail.com", endereco, "1239999");
//		Usuario usuario = new Usuario(1L, "rogerinhomilgrauxXXx", "1234", pessoa, nivelacessoDAO.getPorId(1L));
		
//		FiltroUsuario filtroUsuario = new FiltroUsuario();
//		System.out.println(filtroUsuario.temCampoPreenchido());
//		System.out.println("Resultado validador: " + validador.isConsistente(usuario));
		
		
		List<Logradouro> logradouros = logradouroDAO.listarTodos();
		for (Logradouro l : logradouros) {
			System.out.println(l.toString() + "/n");
		}
		
		List<Endereco> enderecos = enderecoDAO.listarTodos();
		for (Endereco e : enderecos) {
			System.out.println(e.toString() + "/n");
		}
		
		List<AnuncioVO> listaDoacao = doacaoDAO.listarPorFiltro(filtroAnuncio);
		for (AnuncioVO anuncioVO : listaDoacao) {
			System.out.println(anuncioVO.toString() + "/n");
		}
			
//		List<UsuarioVO> listaUsuario = usuarioDAO.listarPorFiltro(filtroUsuario);
//		for (UsuarioVO usuarioVO : listaUsuario) {
//			System.out.println(usuarioVO.toString());
//		}

	}
}
