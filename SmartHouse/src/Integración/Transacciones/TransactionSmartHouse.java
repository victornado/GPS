package Integraci�n.Transacciones;

import Main.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class TransactionSmartHouse implements Transaction {
	private Connection _con;

	@Override
	public void init() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			_con = DriverManager.getConnection("jdbc:mysql://localhost/" + Main.database, Main.user, Main.password);
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
	public void undo() {
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