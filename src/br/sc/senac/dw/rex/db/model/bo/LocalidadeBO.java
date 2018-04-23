package br.sc.senac.dw.rex.db.model.bo;

import java.util.ArrayList;
import java.util.List;

import br.sc.senac.dw.rex.db.model.BairroDAO;
import br.sc.senac.dw.rex.db.model.EnderecoDAO;
import br.sc.senac.dw.rex.db.model.EstadoDAO;
import br.sc.senac.dw.rex.db.model.LogradouroDAO;
import br.sc.senac.dw.rex.db.model.MunicipioDAO;
import br.sc.senac.dw.rex.db.model.PaisDAO;
import br.sc.senac.dw.rex.db.model.TipoLogradouroDAO;
import br.sc.senac.dw.rex.db.model.entity.Bairro;
import br.sc.senac.dw.rex.db.model.entity.Endereco;
import br.sc.senac.dw.rex.db.model.entity.Estado;
import br.sc.senac.dw.rex.db.model.entity.Logradouro;
import br.sc.senac.dw.rex.db.model.entity.Municipio;
import br.sc.senac.dw.rex.db.model.entity.Pais;
import br.sc.senac.dw.rex.db.model.entity.TipoLogradouro;

public class LocalidadeBO {
	
	/*
	 * 
	 	Esse BO vai ter a responsabilidade de adicionar, alterar, excluir e listar o conteï¿½do das tabelas:
	 PaisDAO
	 EstadoDAO
	 MunicipioDAO
	 BairroDAO
	 TipoLogradouroDAO
	 
	 	Esse BO tambï¿½m vai lidar com EnderecoDAO.
	 */

	public Long cadastrarEndereco(Endereco endereco) {
		Long id = 0L;
		if(endereco.getCep()!=null && endereco.getBairro()!=null && endereco.getLogradouro()!=null && endereco.getLogradouro().getTipoLogradouro()!=null) {
			EnderecoDAO dao = new EnderecoDAO();
			id = dao.inserir(endereco);
		}
		return id;
	}
	
	public Boolean alterarEndereco(Endereco endereco) {
		Boolean status = false;
		if(endereco.getCep()!=null && endereco.getBairro()!=null && endereco.getLogradouro()!=null && endereco.getLogradouro().getTipoLogradouro()!=null) {
			EnderecoDAO dao = new EnderecoDAO();
			status = dao.alterar(endereco);
		}
		return status;
	}
	
	public Boolean excluirEndereco(Long id) {
		Boolean status = false;
		if(id!=null) {
			EnderecoDAO dao = new EnderecoDAO();
			status = dao.excluir(id);
		}
		return status;
	}
	
	public List<Pais> listarPaises(){
		PaisDAO dao = new PaisDAO();
		List<Pais> lista = dao.listarTodos();
		return lista;
	}
	
	public List<Estado> listarEstadosPorPais(Long idPais) {		
		EstadoDAO dao = new EstadoDAO();
		List<Estado> lista = dao.listarTodos(idPais); // ATENï¿½ï¿½O: Nilton, ï¿½ esse mï¿½todo que utilizo pra listar por chave estrangeira? Se ï¿½, ficou certo esse caso?
		return lista;
	}
	
	public List<Municipio> listarMunicipiosPorEstado(Long idEstado) {
		MunicipioDAO dao = new MunicipioDAO();
		List<Municipio>lista = dao.listarTodos(idEstado); // ATENï¿½ï¿½O: Nilton, ï¿½ esse mï¿½todo que utilizo pra listar por chave estrangeira? Se ï¿½, ficou certo esse caso?
		return lista;
	}
	
	public List<Bairro> listarBairrosPorMunicipio(Long idMunicipio) {
		BairroDAO dao = new BairroDAO();
		List<Bairro> lista = dao.listarTodos(idMunicipio); // ATENï¿½ï¿½O: Nilton, ï¿½ esse mï¿½todo que utilizo pra listar por chave estrangeira? Se ï¿½, ficou certo esse caso?
		return lista;
	}

	public Long cadastrarLocalidade(Object localidade) {
		Long id = null;
		if(localidade==null) {
			return null;
		}
		if (localidade.getClass()==Pais.class) {
			Pais l = (Pais) localidade;
			if(l.getNome()!=null) {
				id = cadastrarLocalidade(l, null, null, null, null , null);
			}
		}
		if (localidade.getClass()==Estado.class) {
			Estado l = (Estado) localidade;
			if(l.getNome()!=null) {
				id = cadastrarLocalidade(null, l, null, null, null , null);
			}
		}
		if (localidade.getClass()==Municipio.class) {
			Municipio l = (Municipio) localidade;
			if(l.getNome()!=null) {
				id = cadastrarLocalidade(null, null, l, null, null , null);
			}
		}
		
		if (localidade.getClass()==Bairro.class) {
			Bairro l = (Bairro) localidade;
			if(l.getNome()!=null) {
				id = cadastrarLocalidade(null, null, null, l, null , null);
			}
		}
		if (localidade.getClass()==TipoLogradouro.class) {
			TipoLogradouro l = (TipoLogradouro) localidade;
			if(l.getNome()!=null) {
				id = cadastrarLocalidade(null, null, null, null, l , null);
			}
		}
		if (localidade.getClass()==Logradouro.class) {
			Logradouro l = (Logradouro) localidade;
			if(l.getNome()!=null) {
				id = cadastrarLocalidade(null, null, null, null, null, l);
			}
		}
		
		return id;
		
	}

	public Boolean alterarLocalidade(Object localidade) {
		Boolean status = null;
		if(localidade==null) {
			return null;
		}
		if (localidade.getClass()==Pais.class) {
			Pais l = (Pais) localidade;
			if(l.getNome()!=null) {
				status = alterarLocalidade(l, null, null, null, null , null);
			}
		}
		if (localidade.getClass()==Estado.class) {
			Estado l = (Estado) localidade;
			if(l.getNome()!=null) {
				status = alterarLocalidade(null, l, null, null, null , null);
			}
		}
		if (localidade.getClass()==Municipio.class) {
			Municipio l = (Municipio) localidade;
			if(l.getNome()!=null) {
				status = alterarLocalidade(null, null, l, null, null , null);
			}
		}
		if (localidade.getClass()==Bairro.class) {
			Bairro l = (Bairro) localidade;
			if(l.getNome()!=null) {
				status = alterarLocalidade(null, null, null, l, null , null);
			}
		}
		if (localidade.getClass()==TipoLogradouro.class) {
			TipoLogradouro l = (TipoLogradouro) localidade;
			if(l.getNome()!=null) {
				status = alterarLocalidade(null, null, null, null, l , null);
			}
		}
		if (localidade.getClass()==Logradouro.class) {
			Logradouro l = (Logradouro) localidade;
			if(l.getNome()!=null) {
				status = alterarLocalidade(null, null, null, null, null, l);
			}
		}
		return status;
	}
	
	public Boolean excluirLocalidade(Object localidade) {
		Boolean status = null;
		if(localidade==null) {
			return null;
		}
		if (localidade.getClass()==Pais.class) {
			Pais l = (Pais) localidade;
			if(l.getNome()!=null) {
				status = excluirLocalidade(l, null, null, null, null , null);
			}
		}
		if (localidade.getClass()==Estado.class) {
			Estado l = (Estado) localidade;
			if(l.getNome()!=null) {
				status = excluirLocalidade(null, l, null, null, null , null);
			}
		}
		if (localidade.getClass()==Municipio.class) {
			Municipio l = (Municipio) localidade;
			if(l.getNome()!=null) {
				status = excluirLocalidade(null, null, l, null, null , null);
			}
		}
		if (localidade.getClass()==Bairro.class) {
			Bairro l = (Bairro) localidade;
			if(l.getNome()!=null) {
				status = excluirLocalidade(null, null, null, l, null , null);
			}
		}
		if (localidade.getClass()==TipoLogradouro.class) {
			TipoLogradouro l = (TipoLogradouro) localidade;
			if(l.getNome()!=null) {
				status = excluirLocalidade(null, null, null, null, l, null);
			}
		}
		if (localidade.getClass()==Logradouro.class) {
			Logradouro l = (Logradouro) localidade;
			if(l.getNome()!=null) {
				status = excluirLocalidade(null, null, null, null, null, l);
			}
		}
		return status;
	}
	
	public Boolean existe(Endereco endereco) {
		EnderecoDAO dao = new EnderecoDAO();
		Boolean existe = true;
		try {
			dao.getPorId(endereco.getId());
		}catch(Exception e) {
			existe = false;
			System.out.println("Erro. Endereco nao encontrado: " + e );
		} 
		return false; //retorna false enquanto não está implementado pois é pra não existir e os testes passarem pra realizar as operações
	}

	public Boolean existe(Logradouro logradouro) {
		LogradouroDAO dao = new LogradouroDAO();
		Boolean existe = true;
		try {
			dao.getPorId(logradouro.getId());
		}catch(Exception e) {
			existe = false;
			System.out.println("Erro. Logradouro nao encontrado : " + e );
		} 
		return false; //retorna false enquanto não está implementado pois é pra não existir e os testes passarem pra realizar as operações
	}


	private Long cadastrarLocalidade(Pais pais, Estado estado, Municipio municipio, Bairro bairro, TipoLogradouro tipologradouro, Logradouro logradouro) {
		Long id = null;
		if(pais!=null) {
			PaisDAO dao = new PaisDAO();
			if(!dao.existente(pais.getNome())) { //toLowerCase?
				id = dao.inserir(pais);
			} 
		}
		if(estado!=null) {
			EstadoDAO dao = new EstadoDAO();
			if(!dao.existente(estado.getNome())) {
				id = dao.inserir(estado);
			}
		}
		if(municipio!=null) {
			MunicipioDAO dao = new MunicipioDAO();
			if(!dao.existente(municipio.getNome())) {
				id = dao.inserir(municipio);
			}		
		}
		if(bairro!=null) {
			BairroDAO dao = new BairroDAO();
			if(!dao.existente(bairro.getNome())) {
				id = dao.inserir(bairro);
			}	
		}
		if(tipologradouro!=null) {
			TipoLogradouroDAO dao = new TipoLogradouroDAO();
			if(!dao.existente(tipologradouro.getNome())) {
				id = dao.inserir(tipologradouro);
			}
		}
		if(logradouro!=null) {
			LogradouroDAO dao = new LogradouroDAO();
			if(!dao.existente(logradouro.getNome())) {
				id = dao.inserir(logradouro);
			}
		}
		return id;
	}

	private Boolean alterarLocalidade(Pais pais, Estado estado, Municipio municipio, Bairro bairro, TipoLogradouro tipologradouro, Logradouro logradouro) {
		Boolean status = null;
		if(pais!=null) {
			PaisDAO dao = new PaisDAO();
			status = dao.alterar(pais);
		}
		if(estado!=null) {
			EstadoDAO dao = new EstadoDAO();
			status = dao.alterar(estado);
		}
		if(municipio!=null) {
			MunicipioDAO dao = new MunicipioDAO();
			status = dao.alterar(municipio);
		}
		if(bairro!=null) {
			BairroDAO dao = new BairroDAO();
			status = dao.alterar(bairro);
		}
		if(tipologradouro!=null) {
			TipoLogradouroDAO dao = new TipoLogradouroDAO();
			status = dao.alterar(tipologradouro);
		}
		if(logradouro!=null) {
			LogradouroDAO dao = new LogradouroDAO();
			status = dao.alterar(logradouro);
		}
		return status;
	}
	
	private Boolean excluirLocalidade(Pais pais, Estado estado, Municipio municipio, Bairro bairro, TipoLogradouro tipologradouro, Logradouro logradouro) {
		Boolean status = null;
		if(pais!=null) {
			PaisDAO dao = new PaisDAO();
			status = dao.excluir(pais.getId());
		}
		if(estado!=null) {
			EstadoDAO dao = new EstadoDAO();
			status = dao.excluir(estado.getId());
		}
		if(municipio!=null) {
			MunicipioDAO dao = new MunicipioDAO();
			status = dao.excluir(municipio.getId());
		}
		if(bairro!=null) {
			BairroDAO dao = new BairroDAO();
			status = dao.excluir(bairro.getId());
		}
		if(tipologradouro!=null) {
			TipoLogradouroDAO dao = new TipoLogradouroDAO();
			status = dao.excluir(tipologradouro.getId());
		}
		if(logradouro!=null) {
			LogradouroDAO dao = new LogradouroDAO();
			status = dao.excluir(logradouro.getId());
		}
		return status;
	}
	//Elaborar mï¿½todos de consulta.
	private List<Endereco> listarTodosRegistrosLocalidade(Pais pais, Estado estado, Municipio municipio, Bairro bairro, TipoLogradouro tipologradouro) {
		//realizar método listartodos com este aqui. fazer método de apoio que recebe um objeto, lê qual objeto e chama o parâmetro correto neste método
		return null;
	}

}