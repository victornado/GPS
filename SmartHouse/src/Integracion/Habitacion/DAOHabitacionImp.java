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
	public THabitacion mostrarIluminacionHabitacion(THabitacion t) {

		THabitacion nuevo = null;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().getTransaction();
		if (trans != null) {
			try {
				Connection c = (Connection) trans.getResource();
				PreparedStatement query = c
						.prepareStatement("Select Iluminacion from Habitacion where IDCasa = ? AND ID = ?");
				query.setInt(1, t.getIDCasa());
				query.setInt(2, t.getID());
				ResultSet resultado = query.executeQuery();
				if (resultado.next()) {
					nuevo = new THabitacion(t.getID(), t.getIDCasa(), t.getTipo(), t.getTemperatura(),
							resultado.getInt("Iluminacion"));
				}
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
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
