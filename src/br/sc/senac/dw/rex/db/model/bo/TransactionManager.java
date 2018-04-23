package br.sc.senac.dw.rex.db.model.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.sc.senac.dw.rex.db.ConexaoDB;

public class TransactionManager {
	
	private Connection con;
	
	public TransactionManager() {
		super();
		banco();
		
	}
	
	private void banco() {
		if (con == null) {
			con = ConexaoDB.getConnection();
		}
	}
	
	protected void startTransaction() {
		try {
			con.setAutoCommit(false);
		} catch (SQLException ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);

		}
	}

	protected void backTransaction() {
		try {
			con.rollback();
		} catch (SQLException ex1) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
		}
	}

	protected void validateTransaction() {
		try {
			con.commit();
		} catch (SQLException ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);

		}
	}

	protected void finishTransaction() {
		try {
			con.setAutoCommit(true);
		} catch (SQLException ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);

		}
	}
}
