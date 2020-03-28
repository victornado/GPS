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
	public TComponentesEnHabitacion mostrarIluminacionHabitacion(TComponentesEnHabitacion componente) {

		TComponentesEnHabitacion nuevo = null;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().getTransaction();
		if (trans != null) {
			try {
				Connection c = (Connection) trans.getResource();
				PreparedStatement query = c.prepareStatement("Select dato from componentesEnHabitacio where idHabitacion = ? AND idComponente = ? AND ID = ?");
				query.setInt(1, componente.getIDhabitacion());
				query.setInt(2,componente.getIDComponente());
				query.setInt(3, componente.getIDComponente());
				ResultSet r = query.executeQuery();
				if (r.next()) {
					nuevo = new TComponentesEnHabitacion(r.getInt("idComponente"), r.getInt("idHabitacion"), r.getString("nombre"), r.getInt("dato"));
				}
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
		}
		return nuevo;
	}
	
	 public TComponentesEnHabitacion modificarIluminacionHabitacion(TComponentesEnHabitacion componente)
	 {
		TComponentesEnHabitacion nuevo = null;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().getTransaction();
		
		if(trans != null && componente.getIDComponente() != -1)// si null
		{
		try{
			Connection c = (Connection) trans.getResource();
			PreparedStatement query = c.prepareStatement("update componentesEnHabitacion set dato where dato = ? and idHabitacion = ? and idComponente = ?");
			//PreparedStatement query = c.prepareStatement("SELECT idComponente,idHabitacion FROM componentesEnHabitacion  WHERE idHabitacion = ? AND idComponente = ?");

			query.setInt(1,componente.getDato());
			query.setInt(2,componente.getIDhabitacion());
			query.setInt(3,componente.getIDComponente());
			
			query.executeUpdate();
			
		}
		catch(Exception e)
		{
			nuevo = null;
		}
		
		}
		return nuevo;
	 }
	
	 


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
