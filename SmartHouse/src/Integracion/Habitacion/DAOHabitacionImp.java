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
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		THabitacion habitacion = null;
		if (t != null) {
			try {
				Connection c = (Connection) t.getResource();
				PreparedStatement query = c.prepareStatement("select IDcasa, tipo from habitacion where id = ?");
				query.setInt(1, id);
				ResultSet r = query.executeQuery();
				if (r.next()) {
					habitacion = new THabitacion();
					habitacion.setID(id);
					habitacion.setIDCasa(r.getInt(1));
					habitacion.setTipo(r.getString(2));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return habitacion;
	}

	@Override
	public TComponentesEnHabitacion mostrarIluminacionHabitacion(TComponentesEnHabitacion componente) {

		TComponentesEnHabitacion nuevo = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction trans = tm.getTransaction();
		if (trans != null) {
			try {
				Connection c = (Connection) trans.getResource();
				PreparedStatement query = c.prepareStatement(
						"Select dato from componentesEnHabitacion where idHabitacion = ? AND idComponente = ? AND ID = ?");
				query.setInt(1, componente.getIDhabitacion());
				query.setInt(2, componente.getIDComponente());
				query.setInt(3, componente.getIDComponente());
				ResultSet r = query.executeQuery();
				if (r.next()) {
					nuevo = new TComponentesEnHabitacion(r.getInt("idComponente"), r.getInt("idHabitacion"),
							r.getString("nombre"), r.getInt("dato"));
				}
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
		}
		return nuevo;
	}

	public int modificarIluminacionHabitacion(TComponentesEnHabitacion componente) {
		int nuevo = -1;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().getTransaction();

		if (trans != null && componente.getIDComponente() != -1)// si null
		{
			try {
				Connection c = (Connection) trans.getResource();
				PreparedStatement query = c.prepareStatement(
						"UPDATE componentesEnHabitacion SET dato= ? WHERE idHabitacion = ? AND idComponente = ?");
				// PreparedStatement query = c.prepareStatement("SELECT
				// idComponente,idHabitacion FROM componentesEnHabitacion WHERE idHabitacion = ?
				// AND idComponente = ?");

				query.setInt(1, componente.getDato());
				query.setInt(2, componente.getIDhabitacion());
				query.setInt(3, componente.getIDComponente());

				query.executeUpdate();
				nuevo = componente.getDato();

			} catch (Exception e) {
				nuevo = -1;
			}

		}
		return nuevo;
	}

	@Override
	public List<TComponentesEnHabitacion> getComponents(Integer idHabitacion) {

		List<TComponentesEnHabitacion> lista = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		Connection con = null;
		if (t != null) {
			con = (Connection) t.getResource();
			PreparedStatement ps;
			try {
				ps = con.prepareStatement("SELECT IDHabitacion, IDComponente, nombre, dato, tipo, ip,  FROM componentesEnHabitacion join componentes on idComponente=id  WHERE IDHabitacion = ? ");

				ps.setInt(1, idHabitacion);
				ResultSet resultSet = ps.executeQuery();
				lista = new ArrayList<TComponentesEnHabitacion>();
				while (resultSet.next()) {
					TComponentesEnHabitacion c = new TComponentesEnHabitacion();
					// meter todos los atributos de la query a c
					c.setIDhabitacion(resultSet.getInt(1));
					c.setIDComponente(resultSet.getInt(2));
					c.setNombre(resultSet.getString(3));
					c.setDato(resultSet.getInt(4));
					c.setTipo(resultSet.getString(5));
					c.setIp(resultSet.getString(6));
					lista.add(c);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public String mostrarTipoHabitacion(int id) {

		THabitacion habitacion = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction trans = tm.getTransaction();
		if (trans != null) {
			try {
				Connection c = (Connection) trans.getResource();
				PreparedStatement query = c.prepareStatement("Select * from habitacion where id = ?");
				query.setInt(1, id);
				ResultSet r = query.executeQuery();
				if (r.next()) {
					habitacion = new THabitacion(r.getInt("id"), r.getInt("idCasa"), r.getString("tipo"));
				}
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
		}
		return habitacion.getTipo();
	}

}
