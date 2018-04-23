package br.sc.senac.dw.rex.db.model.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.sc.senac.dw.rex.db.model.entity.Usuario;
import br.sc.senac.dw.rex.db.model.DoacaoDAO;
import br.sc.senac.dw.rex.db.model.EnderecoDAO;
import br.sc.senac.dw.rex.db.model.LogradouroDAO;
import br.sc.senac.dw.rex.db.model.MaterialDAO;
import br.sc.senac.dw.rex.db.model.StatusDoacaoDAO;
import br.sc.senac.dw.rex.db.model.UsuarioDAO;
import br.sc.senac.dw.rex.db.model.entity.Doacao;
import br.sc.senac.dw.rex.db.model.entity.Material;
import br.sc.senac.dw.rex.db.model.entity.MaterialDoacao;
import br.sc.senac.dw.rex.db.model.entity.StatusDoacao;
import br.sc.senac.dw.rex.filtro.AnuncioVO;
import br.sc.senac.dw.rex.filtro.FiltroAnuncio;

public class AnuncioBO {
	
	//instanciar DAOs como atributo ou no in�cio de cada m�todo?
	//lembrando que esse BO vai lidar com diversos DAOs e nem todos v�o ser necess�rios a cada m�todo
	/*
	 Esse BO lida com:
	 DoacaoDAO
	 EnderecoDAO
	 StatusDoacaoDAO
	 UnidadeMedidaDAO
	 UsuarioDAO
	 MaterialDoacaoDAO
	 */
	
	private DoacaoDAO doacaoDAO = new DoacaoDAO();
	private MaterialDAO materialDAO = new MaterialDAO();
	private LocalidadeBO localidadeBO = new LocalidadeBO();
	private Validador validador = new Validador();
	
	//TODO testar excluir e reservas
	public Long salvarDoacao(Doacao doacao) {
		Long id = 0L;
		if(doacao.getId()==null) {
			id = cadastrarDoacao(doacao);
		}else {
			if(alterarDoacao(doacao)) {
				id = doacao.getId();
			}
		}
		return id;
	}
	
	public Long cadastrarDoacao(Doacao doacao) {
		Long id = 0L;
		Long idEndereco = 0L;
		Long idLogradouro = 0L;
		//TODO transaction
		if(validador.isConsistente(doacao)) {
			try {
				if (!localidadeBO.existe(doacao.getEndereco().getLogradouro())) {
					idLogradouro = localidadeBO.cadastrarLocalidade(doacao.getEndereco().getLogradouro());
					doacao.getEndereco().getLogradouro().setId(idLogradouro);
				}
				if (!localidadeBO.existe(doacao.getEndereco())) {
					idEndereco = localidadeBO.cadastrarEndereco(doacao.getEndereco());
					doacao.getEndereco().setId(idEndereco);
				}
				id = doacaoDAO.inserir(doacao);
			}
			catch(Exception e) {
				id = 0L;
			}
		}
		return id;
	}
	
	public Boolean alterarDoacao(Doacao doacao) {
		//TODO transaction
		if(validador.isConsistente(doacao)) {
			try {
				if (!localidadeBO.existe(doacao.getEndereco().getLogradouro())) {
					localidadeBO.alterarLocalidade(doacao.getEndereco().getLogradouro());
				}
				if (!localidadeBO.existe(doacao.getEndereco())) {
					localidadeBO.alterarEndereco(doacao.getEndereco());
				}
				if(validador.isConsistente(doacao)) {
					doacaoDAO.alterar(doacao);
				}
			}catch(Exception e) {
				return false;
			}
		}else {
			return false;
		}
		return true;
	}
	//TODO parei aqui, lidando com reserva/cancelamento de reserva/encerramento de doacoa
	public Boolean encerrarDoacao(Long id) {
		Doacao doacao = null;
		try {
			doacao = doacaoDAO.getPorId(id);
			doacao.setStatusDoacao(new StatusDoacaoDAO().getPorId(3L));
			doacaoDAO.excluir(id); // excluir (ou seja, gerar data_coleta) ou apenas mudar StatusDoacao?
		}catch(Exception e){
			return false;
		}	
		return true;
	}
	
	public Boolean realizarReservaDoacao(Long idDoacao, Long idColetor) {
		Doacao doacao = null;
		try{
			doacao = doacaoDAO.getPorId(idDoacao);
			doacao.setColetor(new UsuarioDAO().getPorId(idColetor));
			doacao.setStatusDoacao(new StatusDoacaoDAO().getPorId(2L));
		}catch(Exception e) {
			return false;
		}
		try{
			alterarDoacao(doacao);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public Boolean cancelarReservaDoacao(Long id) {
		Doacao doacao = null;
		try{
			doacao = doacaoDAO.getPorId(id);
			doacao.setColetor(null);
			doacao.setStatusDoacao(new StatusDoacaoDAO().getPorId(1L));
		}catch(Exception e) {
			return false;
		}
		try {
			alterarDoacao(doacao);
		}catch(Exception e) {
			return false;
		}	
		return true;
	}

	public List<AnuncioVO> listarDoacoesPorFiltro(FiltroAnuncio filtro) {
		// Chamadas de listarporfiltro ainda feitas por DoacaoDAO!
		return null;
	}
	
	
}
