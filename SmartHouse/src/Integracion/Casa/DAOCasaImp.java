package Integracion.Casa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Integracion.Transacciones.Transaction;
import Integracion.Transacciones.TransactionManager;
import Integracion.Transacciones.TransactionSmartHouse;
import Negocio.SA.Casa.TComponentesGenerales;


public class DAOCasaImp implements DAOCasa {

	
	

	public Double mostrarIluminacion(TComponentesGenerales casa) {
		boolean noEncontrado = true;
		int idComponente = 0;
		Double iluminacion = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaction = tm.getTransaction();
		String tipo = null;

		if (transaction != null) {
			Connection cn = (Connection) transaction.getResource();

			try {

				PreparedStatement query = cn.prepareStatement("SELECT idComponente, dato FROM `componentesGeneral` WHERE idHabitacion = ?");
				query.setInt(1, casa.getIDcasa());
				ResultSet resultSet = query.executeQuery();
				while (resultSet.next() && noEncontrado) {
					idComponente = resultSet.getInt("idComponente");
					PreparedStatement query2 = cn.prepareStatement("SELECT tipo FROM `componentes` WHERE ID = ?");
					query2.setInt(1, idComponente);
					ResultSet resultSet2 = query2.executeQuery();
					if (resultSet2.next()) {
						tipo = resultSet2.getString(1);
						if (tipo.equals("iluminacion")) {
							iluminacion = resultSet.getDouble("dato");
							noEncontrado = false;
						}
					}

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return iluminacion;

	}
	
	
	public Double mostrarTemperatura(TComponentesGenerales casa) {
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
				query.setInt(1, casa.getIDcasa());
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
	
	public Double mostrarHumedad(TComponentesGenerales casa) {
		boolean noEncontrado = true;
		int idComponente = 0;
		Double humedad = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaction = tm.getTransaction();
		String tipo = null;
		
		if(transaction != null) {
			Connection cn = (Connection) transaction.getResource();
	
			try {
				
				PreparedStatement query = cn.prepareStatement("SELECT idComponente, dato FROM `componentesGeneral` WHERE idHabitacion = ?");
				query.setInt(1, casa.getIDcasa());
				ResultSet resultSet = query.executeQuery();
				while(resultSet.next() && noEncontrado) {
					idComponente = resultSet.getInt("idComponente");
					PreparedStatement query2 = cn.prepareStatement("SELECT tipo FROM `componentes` WHERE ID = ?");
					query2.setInt(1, idComponente);
					ResultSet resultSet2 = query2.executeQuery();
					if(resultSet2.next()) {
						tipo = resultSet2.getString(1);
						if(tipo.equals("humedad")) {
							humedad = resultSet.getDouble("dato");
							noEncontrado = false;
						}
					}
					
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		return humedad;
		
	}
	
	 public int modificarIluminacion(TComponentesGenerales componente)
	 {
		int nuevo = -1;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().getTransaction();
		
		if(trans != null && componente.getIDComponente() != -1)// si null
		{
		try{
			Connection c = (Connection) trans.getResource();
			PreparedStatement query = c.prepareStatement("UPDATE componentesGenerales SET dato=? WHERE idCasa = ? AND idComponente = ?");
			//PreparedStatement query = c.prepareStatement("SELECT idComponente,idCasa FROM componentesGenerales  WHERE idCasa = ? AND idComponente = ?");

			query.setInt(1,componente.getDato());
			query.setInt(2,componente.getIDcasa());
			query.setInt(3,componente.getIDComponente());
			
			query.executeUpdate();
			nuevo = componente.getDato();
			
		}
		catch(Exception e)
		{
			nuevo = -1;
		}
		
		}
		return nuevo;
	 }

	 public int modificarHumedad(TComponentesGenerales componente)
	 {
		int nuevo = -1;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().getTransaction();
		
		if(trans != null && componente.getIDComponente() != -1)// si null
		{
		try{
			Connection c = (Connection) trans.getResource();
			PreparedStatement query = c.prepareStatement("UPDATE componentesGenerales SET dato=? WHERE idCasa = ? AND idComponente = ?");
			//PreparedStatement query = c.prepareStatement("SELECT idComponente,idCasa FROM componentesGenerales  WHERE idCasa = ? AND idComponente = ?");

			query.setInt(1,componente.getDato());
			query.setInt(2,componente.getIDcasa());
			query.setInt(3,componente.getIDComponente());
			
			query.executeUpdate();
			nuevo = componente.getDato();
			
		}
		catch(Exception e)
		{
			nuevo = -1;
		}
		
		}
		return nuevo;
	 }
	 
	 public int modificarTemperatura(TComponentesGenerales componente)
	 {
		int nuevo = -1;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().getTransaction();
		
		if(trans != null && componente.getIDComponente() != -1)// si null
		{
		try{
			Connection c = (Connection) trans.getResource();
			PreparedStatement query = c.prepareStatement("UPDATE componentesGenerales SET dato=? WHERE idCasa = ? AND idComponente = ?");
			//PreparedStatement query = c.prepareStatement("SELECT idComponente,idCasa FROM componentesGenerales  WHERE idCasa = ? AND idComponente = ?");

			query.setInt(1,componente.getDato());
			query.setInt(2,componente.getIDcasa());
			query.setInt(3,componente.getIDComponente());
			
			query.executeUpdate();
			nuevo = componente.getDato();
			
		}
		catch(Exception e)
		{
			nuevo = -1;
		}
		
		}
		return nuevo;
	 }


}
