package Integracion.Casa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Integracion.Transacciones.Transaction;
import Integracion.Transacciones.TransactionManager;
import Negocio.SA.Casa.TCasa;

public class DAOCasaImp implements DAOCasa {

	
	
	public Double mostrarIluminacion(TCasa casa) {
		Double iluminacion = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaction = tm.getTransaction();
		
		if(transaction != null) {
			Connection cn = (Connection) transaction.getResource();
	
			try {
				
				PreparedStatement query = cn.prepareStatement("SELECT `iluminacion` FROM casa WHERE ID = ?");
				query.setInt(1, casa.getID());
				ResultSet resultSet = query.executeQuery();
	
					if (resultSet.next()) {
						iluminacion = resultSet.getDouble("iluminacion");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return iluminacion;
		
	}
	
	
	public Double mostrarTemperatura(TCasa casa) {
		boolean noEncontrado = true;
		int idComponente = 0;
		Double temperatura = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaction = tm.getTransaction();
		String tipo = null;
		
		if(transaction != null) {
			Connection cn = (Connection) transaction.getResource();
	
			try {
				
				PreparedStatement query = cn.prepareStatement("SELECT idComponente, dato FROM `componentesGeneral` WHERE idHabitacion = ?");
				query.setInt(1, casa.getID());
				ResultSet resultSet = query.executeQuery();
				while(resultSet.next() && noEncontrado) {
					idComponente = resultSet.getInt("idComponente");
					PreparedStatement query2 = cn.prepareStatement("SELECT tipo FROM `componentes` WHERE ID = ?");
					query2.setInt(1, idComponente);
					ResultSet resultSet2 = query2.executeQuery();
					if(resultSet2.next()) {
						tipo = resultSet2.getString(1);
						if(tipo.equals("temperatura")) {
							temperatura = resultSet.getDouble("dato");
							noEncontrado = false;
						}
					}
					
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		return temperatura;
		
	}
	
	public Double mostrarHumedad(TCasa casa) {
		Double humedad = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaction = tm.getTransaction();
		
		if(transaction != null) {
			Connection cn = (Connection) transaction.getResource();
	
			try {
				
				PreparedStatement query = cn.prepareStatement("SELECT `humedad` FROM casa WHERE ID = ?");
				query.setInt(1, casa.getID());
				ResultSet resultSet = query.executeQuery();
	
					if (resultSet.next()) {
						humedad = resultSet.getDouble("humedad");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return humedad;
		
	}

}
