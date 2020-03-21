package Integracion.Transacciones;

import Main.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class TransactionSmartHouse implements Transaction {
	private Connection _con;

	@SuppressWarnings("deprecation")
	@Override
	public void init() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName(DRIVER).newInstance();
			
			_con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + Main.database, Main.user, Main.password);
			_con.setAutoCommit(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cannot connect to " + Main.database + " database.", "Connection failed",
					JOptionPane.ERROR_MESSAGE);	
		}
	}

	@Override
	public void commit() {
		try {
			_con.commit();
			_con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Cannot connect to " + Main.database + " database.", "Connection failed",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void rollback() {
		try {
			_con.rollback();
			_con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Cannot connect to " + Main.database + " database.", "Connection failed",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public Object getResource() {
		return _con;
	}

}