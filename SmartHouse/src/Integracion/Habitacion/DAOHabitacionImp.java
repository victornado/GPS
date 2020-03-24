package Integracion.Habitacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Integracion.Transacciones.Transaction;
import Integracion.Transacciones.TransactionManager;
import Integracion.Transacciones.TransactionSmartHouse;
import Negocio.SA.Habitacion.TComponentesEnHabitacion;
import Negocio.SA.Habitacion.THabitacion;

public class DAOHabitacionImp implements DAOHabitacion {

	@Override
	public THabitacion mostrarHabitacion(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public THabitacion mostrarIluminacionHabitacion(THabitacion t, TComponentesEnHabitacion componente) {

		THabitacion nuevo = null;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().getTransaction();
		if (trans != null) {
			try {
				Connection c = (Connection) trans.getResource();
				PreparedStatement query = c.prepareStatement("Select dato from componentesEnHabitacio where IDCasa = ? AND idComponente = ? AND ID = ?");
				query.setInt(1, t.getIDCasa());
				//query.Int(2,componente.getID());
				query.setInt(3, t.getID());
				ResultSet resultado = query.executeQuery();
				if (resultado.next()) {
					nuevo = new THabitacion(t.getID(), t.getIDCasa(), t.getTipo());
				}
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
		}
		return nuevo;
	}
	/*
	 public abstract boolean modificarIluminacionHabitacion(THabitacion habitacion, TComponenteEnHabitacion componente)
	 {
		boolean ok = false;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().getTransaction();
		
		if(trans != null && componente.getID() != null)
		{
		try{
			Connection c = (Connection) trans.getResource();
			PreparedStatement query = c.prepareStatement("Update componentesEnHabitacion set dato where dato = ? AND idHabitacion = ? AND idComponente = ?");
			query.setInt(1,componente.getDato();
			query.setInt(2,habitacion.getID();
			query.setInt(3,componente.getID();
			query.executeUpdate();
			ok = true;
		}
		catch(Exception e)
		{
			ok = false;
		}
		
		}
		return ok;
	 }
	
	 */


	@Override
	public List<TComponentesEnHabitacion> getComponents(Integer idHabitacion) {
		
		List <TComponentesEnHabitacion> lista=null;
		Transaction t = TransactionManager.getInstance().getTransaction();
		Connection con = null;
		if (t != null) {
			con = (Connection) t.getResource();
			PreparedStatement ps;
			try {
				ps = con.prepareStatement("SELECT * FROM ComponentesEnHabitacion WHERE IDHabitacion = ? ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				
				ps.setInt(1, idHabitacion);
				ResultSet resultSet = ps.executeQuery();
				lista=new ArrayList<TComponentesEnHabitacion>();
				while (resultSet.next()) {
					TComponentesEnHabitacion c = null;
					//meter todos los atributos de la query a c
					lista.add(c);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lista;
	}

}
