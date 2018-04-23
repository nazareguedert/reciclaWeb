package br.sc.senac.dw.rex.db.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.sc.senac.dw.rex.db.model.entity.Estado;

public class EstadoDAO extends GenericDAO<EstadoDB, Estado> {

	public EstadoDAO() {
		super(BaseDAO.BANCO[1], "tb_estado", "nome", "pais", new EstadoDB(), new Estado());
	}

	@Override
	public EstadoDB toDB(Estado i) {

		EstadoDB o = new EstadoDB();

		o.setId(i.getId());
		o.setNome(i.getNome());
		o.setUf(i.getUf());
		o.setRegiao(i.getRegiao());
		o.setPais(i.getPais().getId());
		o.setData_inclusao(i.getDataInclusao());
		o.setData_remocao(i.getDataRemocao());

		return o;
	}

	@Override
	public Estado fromDB(EstadoDB i) {

		Estado o = new Estado();

		o.setId(i.getId());
		o.setNome(i.getNome());
		o.setUf(i.getUf());
		o.setRegiao(i.getRegiao());
		o.setPais(new PaisDAO().getPorId(i.getPais()));
		o.setDataInclusao(i.getData_inclusao());
		o.setDataRemocao(i.getData_remocao());

		return o;
	}

	public Boolean registroExistente(String estado) {
		
		String sql = "SELECT EXISTS(SELECT 1 FROM db_localidade.tb_estado WHERE db_localidade.tb_estado.nome LIKE ? ) as count";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setObject(1, "%" + estado + "%");
			
			if (stmt.execute()) {
				ResultSet rs = stmt.getResultSet();
				while (rs.next()) {
					return rs.getInt("count") > 0;
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
		}
		
		return false;
	}
	
//public Boolean existente(String... key) {
//		
////		String sql2 = "SELECT EXISTS(SELECT 1 FROM db_localidade.tb_estado WHERE db_localidade.tb_estado.nome LIKE ? ) as count";
//		
//		String sql = "SELECT " + "EXISTS(" + "SELECT 1 FROM " + this.banco + "." + this.tabela + " WHERE " + this.banco + "." + this.tabela + ".nome "
//				+ "LIKE ? ) as count";
//		
////		String sqlAnterior = "SELECT " + "IF((" + "SELECT " + "MIN(" + this.banco + "." + this.tabela + ".id" + ") " + "FROM "
////				+ this.banco + "." + this.tabela + " WHERE " + " LOWER(" + this.banco + "." + this.tabela + "."
////				+ this.key + ") = ?) " + "IS NOT NULL , TRUE , FALSE)";
//		
//
//		try (PreparedStatement stmt = con.prepareStatement(sql)) {
//
//			stmt.setObject(1, "%" + key[0] + "%");
//
//			if (stmt.execute()) {
//				System.out.println(sql);
//				ResultSet rs = stmt.getResultSet();
//
//				while (rs.next()) {
//					return rs.getInt("count") > 0;
//				}
//			}
//		} catch (Exception ex) {
//			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
//		} 
//		
//		return false;
//	}
}

class EstadoDB {

	private Long id;
	private String nome;
	private String uf;
	private String regiao;
	private Long pais;
	private Date data_inclusao;
	private Date data_remocao;

	public EstadoDB() {
		super();
	}

	public EstadoDB(Long id, String nome, String uf, String regiao, Long pais, Date data_inclusao, Date data_remocao) {
		super();
		this.id = id;
		this.nome = nome;
		this.uf = uf;
		this.regiao = regiao;
		this.pais = pais;
		this.data_inclusao = data_inclusao;
		this.data_remocao = data_remocao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public Long getPais() {
		return pais;
	}

	public void setPais(Long pais) {
		this.pais = pais;
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
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((regiao == null) ? 0 : regiao.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
		EstadoDB other = (EstadoDB) obj;
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (regiao == null) {
			if (other.regiao != null)
				return false;
		} else if (!regiao.equals(other.regiao))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EstadoDB [id=" + id + ", nome=" + nome + ", uf=" + uf + ", regiao=" + regiao + ", pais=" + pais
				+ ", data_inclusao=" + data_inclusao + ", data_remocao=" + data_remocao + "]";
	}

}
