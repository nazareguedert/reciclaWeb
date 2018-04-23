package br.sc.senac.dw.rex.db.model;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.cj.api.jdbc.Statement;

import br.sc.senac.dw.rex.db.model.entity.NivelAcesso;
import br.sc.senac.dw.rex.db.model.entity.Pessoa;
import br.sc.senac.dw.rex.db.model.entity.Usuario;
import br.sc.senac.dw.rex.filtro.FiltroUsuario;
import br.sc.senac.dw.rex.filtro.UsuarioVO;

public class UsuarioDAO extends GenericDAO<UsuarioDB, Usuario> {

	public UsuarioDAO() {
		super(BaseDAO.BANCO[0], "tb_usuario", "usuario", "nivel_acesso", new UsuarioDB(), new Usuario());
	}

	@Override
	public UsuarioDB toDB(Usuario i) {
		UsuarioDB o = new UsuarioDB();

		o.setId(i.getId());
		o.setUsuario(i.getUsuario());
		o.setSenha(i.getSenha());
		o.setPessoa(i.getPessoa().getId());
		o.setNivel_acesso(i.getNivelAcesso().getId());
		o.setData_inclusao(i.getDataInclusao());
		o.setData_remocao(i.getDataRemocao());

		return o;
	}

	@Override
	public Usuario fromDB(UsuarioDB i) {
		Usuario o = new Usuario();

		o.setId(i.getId());
		o.setUsuario(i.getUsuario());
		o.setSenha(i.getSenha());
		o.setPessoa(new PessoaDAO().getPorId(i.getPessoa()));
		o.setNivelAcesso(new NivelAcessoDAO().getPorId(i.getNivel_acesso()));
		o.setDataInclusao(i.getData_inclusao());
		o.setDataRemocao(i.getData_remocao());

		return o;
	}
	
	public ArrayList<UsuarioVO> listarPorFiltro(FiltroUsuario filtro) {
		ArrayList<UsuarioVO> usuarios = new ArrayList<>();

		String sql = "SELECT u.usuario as NomeUsuario ,p.email as Email, n.nome as NivelAcesso, p.nome as NomePessoa, p.nome_auxiliar as Apelido, "+/*tf.numero as Telefone*/"tp.nome as TipoPessoa,\r\n" + 
				"b.nome as Bairro, e.cep as CEP,l.nome as Logradouro, e.numero as Numero, tl.nome as TipoLogradouro, e.complemento as Complemento, u.data_remocao as DataRemocao FROM db_rex.tb_usuario u \r\n" + 
				"	INNER JOIN db_rex.tb_nivel_acesso n ON u.nivel_acesso = n.id \r\n" + 
				"	INNER JOIN db_rex.tb_pessoa p ON u.pessoa = p.id\r\n" + 
//				"	INNER JOIN db_rex.tb_telefone tf ON p.id = tf.pessoa\r\n" + 
				"	INNER JOIN db_rex.tb_tipo_pessoa tp ON p.tipo_pessoa = tp.id\r\n" + 
				"	INNER JOIN db_localidade.tb_endereco e ON e.id = p.endereco\r\n" + 
				"	INNER JOIN db_localidade.tb_logradouro l ON e.logradouro = l.id\r\n" + 
				"	INNER JOIN db_localidade.tb_tipo_logradouro tl ON l.tipo_logradouro = tl.id\r\n" + 
				"	INNER JOIN db_localidade.tb_bairro b ON e.bairro = b.id";

		if (filtro.temCampoPreenchido()) {
			sql = preencherFiltrosConsulta(sql, filtro);
		}

		try {
			java.sql.Statement instrucaoSQL = con.createStatement(); 
			ResultSet resultado = instrucaoSQL.executeQuery(sql);
			while (resultado.next()) {
				UsuarioVO u = criarUsuarioResultSet(resultado);
				if(resultado.getString("DataRemocao")==null) {
					usuarios.add(u);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	private String preencherFiltrosConsulta(String sql, FiltroUsuario filtro) {
		boolean primeiroCampo = true;

		sql += " WHERE ";
		
		if(filtro.getNomeUsuario() != null && !filtro.getNomeUsuario().trim().isEmpty()) {
			if(!primeiroCampo) {
				sql += " AND ";
			}
			sql += " u.usuario LIKE '%" + filtro.getNomeUsuario() + "%'";
			primeiroCampo = false;
		}

		if (filtro.getEmail() != null && !filtro.getEmail().trim().isEmpty()){
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " p.email LIKE '%" + filtro.getEmail() +"%'";
			primeiroCampo = false;
		}

		if (filtro.getIdNivelAcesso() != null && !filtro.getIdNivelAcesso().trim().isEmpty()){
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " n.id = " + filtro.getIdNivelAcesso(); 
			primeiroCampo = false;
		} 
		
		if (filtro.getNome() != null && !filtro.getNome().trim().isEmpty() ){
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " p.nome LIKE '%" + filtro.getNome() + "%'";
			primeiroCampo = false;
		}

		if (filtro.getApelido() != null && !filtro.getApelido().trim().isEmpty()) { 
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " p.nome_auxiliar LIKE '%" + filtro.getApelido() + "%'";
			primeiroCampo = false;
		}

//		if (filtro.getTelefone() != null && !filtro.getTelefone().trim().isEmpty()) {
//			if (!primeiroCampo) {
//				sql += " AND ";
//			}
//			sql += " tf.numero LIKE '%" + filtro.getTelefone() + "%'";
//			primeiroCampo = false;
//		}
		
		if(filtro.getIdTipoPessoa() != null && !filtro.getIdTipoPessoa().trim().isEmpty()) {
			if(!primeiroCampo) {
				sql += " AND ";
			}
			sql += " tp.id = " + filtro.getIdTipoPessoa();
			primeiroCampo = false;
		}

		if (filtro.getBairro() != null && !filtro.getBairro().trim().isEmpty()){
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " b.nome LIKE '%" + filtro.getBairro() + "%'";
			primeiroCampo = false;
		}

		if (filtro.getCEP() != null && !filtro.getCEP().trim().isEmpty()){
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " e.cep LIKE '%" + filtro.getCEP() + "%'"; 
			primeiroCampo = false;
		} 
		
		if (filtro.getLogradouro() != null && !filtro.getLogradouro().trim().isEmpty() ){
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " l.nome LIKE '%" + filtro.getLogradouro() + "%'";
			primeiroCampo = false;
		}

		if (filtro.getNumero() != null && !filtro.getNumero().trim().isEmpty()) { 
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " e.numero = " + filtro.getNumero();
			primeiroCampo = false;
		}

		if (filtro.getIdTipoLogradouro() != null && filtro.getIdTipoLogradouro().trim().isEmpty()) {
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " tl.nome = " + filtro.getIdTipoLogradouro(); 
			primeiroCampo = false;
		}
		
		if (filtro.getComplemento() != null && filtro.getComplemento().trim().isEmpty()) {
			if (!primeiroCampo) {
				sql += " AND ";
			}
			sql += " e.complemento LIKE '%" + filtro.getComplemento() + "%'"; 
			primeiroCampo = false;
		}
		System.out.println(sql);
		return sql;
	}
	
	private UsuarioVO criarUsuarioResultSet(ResultSet rs) {
		UsuarioVO usuario = new UsuarioVO();
		try {
			usuario.setNomeUsuario(rs.getString("NomeUsuario"));
			usuario.setEmail(rs.getString("Email"));
			usuario.setNivelAcesso(rs.getString("NivelAcesso"));
			usuario.setNome(rs.getString("NomePessoa"));
			usuario.setApelido(rs.getString("Apelido"));
//			usuario.setTelefone(rs.getString("Telefone"));
			usuario.setTipoPessoa(rs.getString("TipoPessoa"));
			usuario.setBairro(rs.getString("bairro"));
			usuario.setCEP(rs.getString("CEP"));
			usuario.setLogradouro(rs.getString("Logradouro"));
			usuario.setNumero(rs.getString("Numero"));
			usuario.setTipoLogradouro(rs.getString("TipoLogradouro"));
			usuario.setComplemento(rs.getString("complemento"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}
}

class UsuarioDB {

	private Long id;
	private String usuario;
	private String senha;
	private Long pessoa;
	private Long nivel_acesso;
	private Date data_inclusao;
	private Date data_remocao;

	public UsuarioDB() {
		super();
	}

	public UsuarioDB(Long id, String usuario, String senha, Long pessoa, Long nivel_acesso, Date data_inclusao,
			Date data_remocao) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.pessoa = pessoa;
		this.nivel_acesso = nivel_acesso;
		this.data_inclusao = data_inclusao;
		this.data_remocao = data_remocao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getPessoa() {
		return pessoa;
	}

	public void setPessoa(Long pessoa) {
		this.pessoa = pessoa;
	}

	public Long getNivel_acesso() {
		return nivel_acesso;
	}

	public void setNivel_acesso(Long nivel_acesso) {
		this.nivel_acesso = nivel_acesso;
	}

	public Date getData_inclusao() {
		return data_inclusao;
	}

	public void setData_inclusao(Date data_inclusao) {
		this.data_inclusao = data_inclusao;
	}

	public Date getData_remocao() {
		return data_remocao;
	}

	public void setData_remocao(Date data_remocao) {
		this.data_remocao = data_remocao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_inclusao == null) ? 0 : data_inclusao.hashCode());
		result = prime * result + ((data_remocao == null) ? 0 : data_remocao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nivel_acesso == null) ? 0 : nivel_acesso.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		UsuarioDB other = (UsuarioDB) obj;
		if (data_inclusao == null) {
			if (other.data_inclusao != null)
				return false;
		} else if (!data_inclusao.equals(other.data_inclusao))
			return false;
		if (data_remocao == null) {
			if (other.data_remocao != null)
				return false;
		} else if (!data_remocao.equals(other.data_remocao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nivel_acesso == null) {
			if (other.nivel_acesso != null)
				return false;
		} else if (!nivel_acesso.equals(other.nivel_acesso))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuarioDB [id=" + id + ", usuario=" + usuario + ", senha=" + senha + ", pessoa=" + pessoa
				+ ", nivel_acesso=" + nivel_acesso + ", data_inclusao=" + data_inclusao + ", data_remocao="
				+ data_remocao + "]";
	}

}
