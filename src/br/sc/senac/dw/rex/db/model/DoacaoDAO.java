package br.sc.senac.dw.rex.db.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import br.sc.senac.dw.rex.db.model.entity.Doacao;
import br.sc.senac.dw.rex.db.model.entity.Usuario;
import br.sc.senac.dw.rex.filtro.AnuncioVO;
import br.sc.senac.dw.rex.filtro.FiltroAnuncio;

public class DoacaoDAO extends GenericDAO<DoacaoDB, Doacao> {

	// CRIAR FILTRO NESSE DAO PARA ENDERECO/LOCALIDADE/ETC

	public DoacaoDAO() {
		super(BaseDAO.BANCO[0], "tb_doacao", "status", "doador", "coletor", new DoacaoDB(), new Doacao());

		this.inicio = "data_abertura"; // SOBRESCREVENDO data_inclusao DO GenericDAO
		this.fim = "data_coleta"; // SOBRESCREVENDO data_remocao DO GenericDAO

	}

	@Override
	public DoacaoDB toDB(Doacao i) {
		DoacaoDB o = new DoacaoDB();

		o.setId(i.getId());
		o.setTitulo(i.getTitulo());
		o.setDescricao(i.getDescricao());
		o.setDoador(i.getDoador().getId());
		
		if(i.getColetor() != null) {
			o.setColetor(i.getColetor().getId());
		}		
		
		o.setEndereco(i.getEndereco().getId());
		o.setMaterial(i.getMaterial().getId());
		o.setQuantia(i.getQuantia());
		o.setStatus(i.getStatusDoacao().getId());
		o.setData_abertura(i.getDataAbertura());
		o.setData_coleta(i.getDataColeta());

		return o;
	}

	@Override
	public Doacao fromDB(DoacaoDB i) {
		Doacao o = new Doacao();

		o.setId(i.getId());
		o.setTitulo(i.getTitulo());
		o.setDescricao(i.getDescricao());
		o.setDoador(new UsuarioDAO().getPorId(i.getDoador()));
		o.setColetor(new UsuarioDAO().getPorId(i.getColetor()));
		o.setEndereco(new EnderecoDAO().getPorId(i.getEndereco()));
		o.setStatusDoacao(new StatusDoacaoDAO().getPorId(i.getStatus()));
		o.setMaterial(new MaterialDAO().getPorId(i.getMaterial()));
		o.setQuantia(i.getQuantia());
		o.setDataAbertura(i.getData_abertura());
		o.setDataColeta(i.getData_coleta());

		return o;
	}

	public ArrayList<AnuncioVO> listarPorFiltro(FiltroAnuncio filtro) {
		ArrayList<AnuncioVO> anuncios = new ArrayList<>();

		String sql = "SELECT d.id as idDoacao, d.titulo as Titulo, d.descricao as Descricao, d.doador as Doador, d.coletor as Coletor, sd.nome as Status, m.id as idMaterial, m.nome as Material, d.quantia as Quantia, um.nome as UnidadeMedida, b.nome as Bairro, e.cep as CEP, e.numero as Numero, e.complemento as Complemento, l.nome as Logradouro, tl.nome as TipoLogradouro, d.data_coleta as DataRemocao FROM db_rex.tb_doacao d\r\n" + 
				"	INNER JOIN db_rex.tb_status_doacao sd ON d.status = sd.id\r\n" + 
				"	INNER JOIN db_rex.tb_material m ON m.id = d.material\r\n" + 
				"	INNER JOIN db_rex.tb_unidade_medida um ON m.unidade_medida = um.id\r\n" + 
				"	INNER JOIN db_localidade.tb_endereco e ON e.id = d.endereco\r\n" + 
				"	INNER JOIN db_localidade.tb_logradouro l ON e.logradouro = l.id\r\n" + 
				"	INNER JOIN db_localidade.tb_tipo_logradouro tl ON l.tipo_logradouro = tl.id\r\n" + 
				"	INNER JOIN db_localidade.tb_bairro b ON e.bairro = b.id";
		//TODO prevenir injection
		if (filtro.temCampoPreenchido()) {
			sql = preencherFiltrosConsultaAnuncio(sql, filtro);
		} else {
			System.out.println("VEIO");
		}
		
		try {
			Statement instrucaoSQL = con.createStatement();
			ResultSet resultado = instrucaoSQL.executeQuery(sql);
			while (resultado.next()) {
				AnuncioVO a = criarAnuncioResultSet(resultado);
				if(resultado.getString("DataRemocao")==null) {
					anuncios.add(a);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return anuncios;
	}

	public String preencherFiltrosConsultaAnuncio(String sql, FiltroAnuncio filtro) {
		boolean primeiroCampo = true;

		sql += " WHERE ";

		if (filtro.getIdDoacao() != null && !filtro.getIdDoacao().trim().isEmpty()) {
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " d.id = " + filtro.getTitulo();
			primeiroCampo = false;
		}
		if (filtro.getTitulo() != null && !filtro.getTitulo().trim().isEmpty()) {
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " d.titulo LIKE '%" + filtro.getTitulo() + "%'";
			primeiroCampo = false;
		}

		if (filtro.getDescricao() != null && !filtro.getDescricao().trim().isEmpty()) {
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " d.descricao LIKE '%" + filtro.getDescricao() + "%'";
			primeiroCampo = false;
		}

		if (filtro.getIdDoador() != null && !filtro.getIdDoador().trim().isEmpty()) {
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " d.doador = " + filtro.getIdDoador();
			primeiroCampo = false;
		}

		if (filtro.getIdColetor() != null && !filtro.getIdColetor().trim().isEmpty()) {
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " d.coletor = " + filtro.getIdColetor();
			primeiroCampo = false;
		}

		if (filtro.getIdStatus() != null && !filtro.getIdStatus().trim().isEmpty()) {
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " d.status = " + filtro.getIdStatus();
			primeiroCampo = false;
		}

		if (filtro.getIdMaterial() != null && !filtro.getIdMaterial().trim().isEmpty()) {
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " d.material = " + filtro.getIdMaterial();
			primeiroCampo = false;
		}

		if (filtro.getMaterial() != null && !filtro.getMaterial().trim().isEmpty()) {
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " m.nome LIKE '%" + filtro.getMaterial() + "%'";
			primeiroCampo = false;
		}

		if (filtro.getQuantia() != null && !filtro.getQuantia().trim().isEmpty()) {
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " d.quantia = " + filtro.getQuantia();
			primeiroCampo = false;
		} 
		//TODO FAZER FILTRO POR QUANTIA MINIMA E MAXIMA!

		if (filtro.getUnidadeMedida() != null && !filtro.getUnidadeMedida().trim().isEmpty()) {
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " um.nome LIKE '%" + filtro.getUnidadeMedida() + "%'";
			primeiroCampo = false;
		}

		if (filtro.getBairro() != null && !filtro.getBairro().trim().isEmpty()) {
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " b.nome LIKE '%" + filtro.getBairro() + "%'";
			primeiroCampo = false;
		}

		if (filtro.getCEP() != null && !filtro.getCEP().trim().isEmpty()) {
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " e.cep LIKE %" + filtro.getCEP() + "%";
			primeiroCampo = false;
		}

		if (filtro.getLogradouro() != null && !filtro.getLogradouro().trim().isEmpty()) {
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " l.nome LIKE %" + filtro.getLogradouro() + "%";
			primeiroCampo = false;
		}

		if (filtro.getNumero() != null && filtro.getNumero().trim().isEmpty()) {
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " e.numero = " + filtro.getNumero();
			primeiroCampo = false;
		}

		if (filtro.getTipoLogradouro() != null && filtro.getTipoLogradouro().trim().isEmpty()) {
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " tl.nome = " + filtro.getTipoLogradouro();
			primeiroCampo = false;
		}

		if (filtro.getComplemento() != null && filtro.getComplemento().trim().isEmpty()) {
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " e.complemento LIKE %'" + filtro.getComplemento() + "'%";
			primeiroCampo = false;
		}
		System.out.println(sql);
		return sql;
	}

	private AnuncioVO criarAnuncioResultSet(ResultSet rs) {
		AnuncioVO anuncio = new AnuncioVO();
		try {
			anuncio.setIdDoacoao(rs.getString("idDoacao"));
			anuncio.setTitulo(rs.getString("Titulo"));
			anuncio.setDescricao(rs.getString("Descricao"));
			anuncio.setDoador(rs.getString("Doador"));
			anuncio.setColetor(rs.getString("Coletor"));
			anuncio.setStatus(rs.getString("Status"));
			anuncio.setIdMaterial(rs.getString("idMaterial"));
			anuncio.setMaterial(rs.getString("Material"));
			anuncio.setQuantia(rs.getString("Quantia"));
			anuncio.setUnidadeMedida(rs.getString("UnidadeMedida"));
			anuncio.setBairro(rs.getString("Bairro"));
			anuncio.setCep(rs.getString("CEP"));
			anuncio.setNumero(rs.getString("Numero"));
			anuncio.setComplemento(rs.getString("Complemento"));
			anuncio.setLogradouro(rs.getString("Logradouro"));
			anuncio.setTipoLogradouro(rs.getString("TipoLogradouro"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return anuncio;
	}
}

class DoacaoDB {

	private Long id;
	private String titulo;
	private String descricao;
	private Long doador;
	private Long coletor;
	private Long endereco;
	private Long status;
	private Long material;
	private Integer quantia;
	private Date data_abertura;
	private Date data_coleta;

	public DoacaoDB() {
		super();
	}

	public DoacaoDB(Long id, String titulo, String descricao, Long doador, Long coletor, Long endereco, Long status,
			Long material, Integer quantia, Date data_abertura, Date data_coleta) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.doador = doador;
		this.coletor = coletor;
		this.endereco = endereco;
		this.status = status;
		this.material = material;
		this.quantia = quantia;
		this.data_abertura = data_abertura;
		this.data_coleta = data_coleta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getDoador() {
		return doador;
	}

	public void setDoador(Long doador) {
		this.doador = doador;
	}

	public Long getColetor() {
		return coletor;
	}

	public void setColetor(Long coletor) {
		this.coletor = coletor;
	}

	public Long getEndereco() {
		return endereco;
	}

	public void setEndereco(Long endereco) {
		this.endereco = endereco;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getMaterial() {
		return material;
	}

	public void setMaterial(Long material) {
		this.material = material;
	}

	public Integer getQuantia() {
		return quantia;
	}

	public void setQuantia(Integer quantia) {
		this.quantia = quantia;
	}

	public Date getData_abertura() {
		return data_abertura;
	}

	public void setData_abertura(Date data_abertura) {
		this.data_abertura = data_abertura;
	}

	public Date getData_coleta() {
		return data_coleta;
	}

	public void setData_coleta(Date data_coleta) {
		this.data_coleta = data_coleta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coletor == null) ? 0 : coletor.hashCode());
		result = prime * result + ((data_abertura == null) ? 0 : data_abertura.hashCode());
		result = prime * result + ((data_coleta == null) ? 0 : data_coleta.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((doador == null) ? 0 : doador.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		result = prime * result + ((quantia == null) ? 0 : quantia.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoacaoDB other = (DoacaoDB) obj;
		if (coletor == null) {
			if (other.coletor != null)
				return false;
		} else if (!coletor.equals(other.coletor))
			return false;
		if (data_abertura == null) {
			if (other.data_abertura != null)
				return false;
		} else if (!data_abertura.equals(other.data_abertura))
			return false;
		if (data_coleta == null) {
			if (other.data_coleta != null)
				return false;
		} else if (!data_coleta.equals(other.data_coleta))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (doador == null) {
			if (other.doador != null)
				return false;
		} else if (!doador.equals(other.doador))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (quantia == null) {
			if (other.quantia != null)
				return false;
		} else if (!quantia.equals(other.quantia))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DoacaoDB [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", doador=" + doador
				+ ", coletor=" + coletor + ", endereco=" + endereco + ", status=" + status + ", material=" + material
				+ ", quantia=" + quantia + ", data_abertura=" + data_abertura + ", data_coleta=" + data_coleta + "]";
	}

}