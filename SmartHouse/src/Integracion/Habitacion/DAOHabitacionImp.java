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
import Negocio.SA.Usuario.TUsuario;

public class DAOHabitacionImp implements DAOHabitacion {

	@Override
	public THabitacion mostrarHabitacion(int id) {
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		THabitacion habitacion = null;
		if (t != null) {
			try {
				Connection c = (Connection) t.getResource();
				PreparedStatement query = c.prepareStatement("select IDcasa, tipo, nombre from habitacion where id = ?");
				query.setInt(1, id);
				ResultSet r = query.executeQuery();
				if (r.next()) {
					habitacion = new THabitacion();
					habitacion.setID(id);
					habitacion.setIDCasa(r.getInt(1));
					habitacion.setTipo(r.getString(2));
					habitacion.setNombre(r.getString(3));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return habitacion;
	}

	
	@Override
	public THabitacion modificarHabitacion(THabitacion room) {
		THabitacion habitacion = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaction = tm.getTransaction();
		if(transaction != null) {
			Connection cn = (Connection) transaction.getResource();
	
			try {
				PreparedStatement query = cn.prepareStatement("UPDATE habitacion SET nombre=?, IDCasa = ?, tipo = ? WHERE ID = ?");
				query.setNString(1, room.getNombre());
				query.setInt(2, room.getIDCasa());
				query.setString(3, room.getTipo());
				query.setInt(4, room.getID());
				query.executeUpdate();
				habitacion = room;
			}
			catch (Exception e) {
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
				ps = con.prepareStatement("SELECT IDHabitacion, IDComponente, nombre, dato, tipo, ip  FROM componentesEnHabitacion join componentes on idComponente=id  WHERE IDHabitacion = ? ");

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
					habitacion = new THabitacion(r.getInt("id"), r.getInt("idCasa"), r.getString("tipo"), r.getString("nombre"));
				}
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
		}
		return habitacion.getTipo();
	}

	@Override
	public ArrayList<THabitacion> ListarHabitaciones() {
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaction = tm.getTransaction();
		ArrayList<THabitacion> arrayHabitaciones = new ArrayList<THabitacion>();

		if(transaction != null) {
			Connection cn = (Connection) transaction.getResource();
	
			try {
				PreparedStatement ps = cn.prepareStatement("select * from habitacion");
				ResultSet rs = ps.executeQuery();
				THabitacion habitacion = null;
			
				while (rs.next()) {
					habitacion = new THabitacion();
					habitacion.setID(rs.getInt("ID"));
					habitacion.setIDCasa(rs.getInt("IDCasa"));
					habitacion.setTipo(rs.getString("tipo"));
					habitacion.setNombre(rs.getString("nombre"));
					arrayHabitaciones.add(habitacion);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrayHabitaciones;
	}


	@Override
	public ArrayList<THabitacion> ListarHabitacionesPorTipo(String tipo) {
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaction = tm.getTransaction();
		ArrayList<THabitacion> arrayHabitaciones = new ArrayList<THabitacion>();

		if(transaction != null) {
			Connection cn = (Connection) transaction.getResource();
	
			try {
				PreparedStatement ps = cn.prepareStatement("select * from habitacion where tipo = '"+tipo+"'" );
				ResultSet rs = ps.executeQuery();
				THabitacion habitacion = null;
			
				while (rs.next()) {
					habitacion = new THabitacion();
					habitacion.setID(rs.getInt("ID"));
					habitacion.setIDCasa(rs.getInt("IDCasa"));
					habitacion.setTipo(rs.getString("tipo"));
					habitacion.setNombre(rs.getString("nombre"));
					arrayHabitaciones.add(habitacion);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrayHabitaciones;
	}


	@Override
	public int darDeAlta(THabitacion thab) {

		int id = -1;
		Transaction t = TransactionManager.getInstance().getTransaction();
		Connection con = null;
		if (t != null) {
			con = (Connection) t.getResource();
			PreparedStatement ps;
			try {
			ps = con.prepareStatement(
					"INSERT INTO habitacion(tipo,IDCasa,nombre) VALUES(?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, thab.getTipo());
			ps.setInt(2, thab.getIDCasa());
			ps.setString(3, thab.getNombre());
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			}catch(Exception e) {
				return -1;
			}
		}
		return id;
	}


	@Override
	public int eliminarhab(int id) {
		Transaction transaction = TransactionManager.getInstance().getTransaction();
		int id2 = -1;
		if(transaction != null) {
			Connection cn = (Connection) transaction.getResource();
	
			try {
				PreparedStatement query = cn.prepareStatement("DELETE FROM habitacion WHERE ID="+id);
				query.executeUpdate();
				id2 = id;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return id2;
	}

}
