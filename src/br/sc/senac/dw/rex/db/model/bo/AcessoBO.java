package br.sc.senac.dw.rex.db.model.bo;
//Long id = null;
//if(isConsistente(usuario)) {
//	id = usuarioDAO.inserir(usuario);
//}
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.sc.senac.dw.rex.db.model.LogradouroDAO;
import br.sc.senac.dw.rex.db.model.NivelAcessoDAO;
import br.sc.senac.dw.rex.db.model.PessoaDAO;
import br.sc.senac.dw.rex.db.model.TelefoneDAO;
import br.sc.senac.dw.rex.db.model.TipoLogradouroDAO;
import br.sc.senac.dw.rex.db.model.TipoPessoaDAO;
import br.sc.senac.dw.rex.db.model.UsuarioDAO;
import br.sc.senac.dw.rex.db.model.entity.Telefone;
import br.sc.senac.dw.rex.db.model.entity.Usuario;
import br.sc.senac.dw.rex.filtro.FiltroUsuario;
import br.sc.senac.dw.rex.filtro.UsuarioVO;

public class AcessoBO {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private LocalidadeBO localidadeBO = new LocalidadeBO();
	private PessoaDAO pessoaDAO = new PessoaDAO();
	private TransactionManager manager = new TransactionManager();
	private Validador validador = new Validador();
	
	//instanciar DAOs como atributo ou no in�cio de cada m�todo?
	//lembrando que esse BO vai lidar com diversos DAOs e nem todos v�o ser necess�rios a cada m�todo
	/*
	 Esse BO lida com:
	 UsuarioDAO
	 TipoPessoaDAO
	 NivelAcessoDAO
	 EnderecoDAO
	 CompetenciaDAO
	 PessoaDAO
	 TelefoneDAO
	 */
	//Todas as opera��es devem lidar com pessoa al�m de usuario
	
	//TODO testar tudo
	public Long salvarUsuario(Usuario usuario) {
		Long id = 0L;
		if(usuario.getId()==null) {
			id = cadastrarUsuario(usuario);
		}else {
			if(alterarUsuario(usuario)) {
				id = usuario.getId();
			}
		}
		return id;
	}
	
	public Long cadastrarUsuario(Usuario usuario) {
		Long id = 0L;
		Long idEndereco = 0L;
		Long idLogradouro = 0L;
		Long idPessoa = 0L;
		//TODO transaction
		if(validador.isConsistente(usuario)) {
			try {
				if (!localidadeBO.existe(usuario.getPessoa().getEndereco().getLogradouro())) {
					idLogradouro = localidadeBO.cadastrarLocalidade(usuario.getPessoa().getEndereco().getLogradouro());
					usuario.getPessoa().getEndereco().getLogradouro().setId(idLogradouro);			
				}
				if(!localidadeBO.existe(usuario.getPessoa().getEndereco())) {
					idEndereco = localidadeBO.cadastrarEndereco(usuario.getPessoa().getEndereco());
					usuario.getPessoa().getEndereco().setId(idEndereco);
				}
				if(idEndereco!=0L) {
					idPessoa = pessoaDAO.inserir(usuario.getPessoa());
					usuario.getPessoa().setId(idPessoa);
				}
				if(idPessoa!=0L) {
					id = usuarioDAO.inserir(usuario);
				}
			}catch(Exception e) {
				id = 0L;
			}finally {
				
			}
		}
		//colocar decis�es do objeto transaction para fazer commit ou rollback dependendo do resultado, dando finish ao final
		return id;
	}
	//inclui mudanca de nivel de acesso, adicoes/remocoes de competencias?
	public Boolean alterarUsuario(Usuario usuario) {
		Boolean status = null;
		//TODO transaction
		//condicional abaixo eh experimental. Testar e aplicar em outros metodos se funcionar
		if(validador.isConsistente(usuario)) {
			try {
				if(localidadeBO.existe(usuario.getPessoa().getEndereco().getLogradouro())) {
					status = localidadeBO.alterarLocalidade(usuario.getPessoa().getEndereco().getLogradouro());
				}
				if(localidadeBO.existe(usuario.getPessoa().getEndereco())&&status==true) {
					status = localidadeBO.alterarEndereco(usuario.getPessoa().getEndereco());
				}
				if(status==true) {
					status = pessoaDAO.alterar(usuario.getPessoa());
				}
				if(status==true) {
					status = usuarioDAO.alterar(usuario);
				}
			}catch(Exception e) {
				status = false;
				//rollback
			}finally {
				//finish
			}
		}
		return status;
	}
	
	public Boolean excluirUsuario(Long id) {
		Boolean status = null;
		Usuario usuario = null;
		try{
			usuario = usuarioDAO.getPorId(id);	
		}catch(Exception e) {
			System.out.println("Erro ao excluir pessoa: " + e.getMessage());
			return false;
		}
		try {
			pessoaDAO.excluir(usuario.getPessoa().getId());
			status = usuarioDAO.excluir(id);
		}catch(Exception e) {
			return false;
		}
		return status;
	}
	
	public Boolean iniciarSessao() {
		//exige conhecimento sobre manuseio de sess�es
		return null;
	}
	
	public Boolean encerrarSessao() {
		//exige conhecimento sobre manuseio de sess�es
		return null;
	}
	
	public Boolean solicitarNovaSenha() {
		//exige servi�o de envio de e-mails autom�ticos (implementa��o futura)
		return null;
	}
	
	public ArrayList<UsuarioVO> listarUsuariosPorFiltro(FiltroUsuario filtro) {
		//poss�vel buscar um �nico usu�rio por ID, usu�rios com trecho de nome, entre outros filtros (dispensa outros m�todos de listagem/busca) EDIT: acho que ID necessita seu pr�prio m�todo, assim como listarTodos
		return usuarioDAO.listarPorFiltro(filtro);
	}
	
	

}
