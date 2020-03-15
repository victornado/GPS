package Integracion.Habitacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Integracion.Transacciones.TransactionManager;
import Integracion.Transacciones.TransactionSmartHouse;
import Negocio.SA.Habitacion.THabitacion;

public class DAOHabitacionImp implements DAOHabitacion {

	@Override
	public THabitacion mostrarHabitacion(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public THabitacion mostrarIluminacionHabitacion(THabitacion t) {
		
		THabitacion nuevo = null;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().getTransaction();
		if(trans != null)
		{
			try
			{
				Connection c = (Connection) trans.getResource();
				PreparedStatement query = c.prepareStatement("Select Iluminacion from Habitacion where IDCasa = ? AND ID = ?");
				query.setInt(1,t.getIDCasa());
				query.setInt(2,t.getID());
				ResultSet resultado = query.executeQuery();
				if(resultado.next())
				{
					nuevo = new THabitacion(t.getID(),t.getIDCasa(),t.getTipo(),t.getTemperatura(), resultado.getInt("Iluminacion"));
				}
			}
			catch(Exception e)
			{
				e.getMessage();
				e.printStackTrace();
			}
		}
		return nuevo;
	}
	
}
