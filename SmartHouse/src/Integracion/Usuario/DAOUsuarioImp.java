package Integracion.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Integracion.Transacciones.Transaction;
import Integracion.Transacciones.TransactionManager;
import Negocio.SA.Usuario.TUsuario;

public class DAOUsuarioImp implements DAOUsuario {

	@Override
	public int darDeAlta(TUsuario user) throws SQLException {
		int id = -1;
		Transaction t = TransactionManager.getInstance().getTransaction();
		Connection con = null;
		if (t != null) {
			con = (Connection) t.getResource();
			PreparedStatement ps;
			ps = con.prepareStatement(
					"INSERT INTO usuario(nombre,apellidos,correo,contrasena,tipo,"
							+ "IDCasa,edad) VALUES(?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, user.getNombre());
			ps.setString(2, user.getApellidos());
			ps.setString(3, user.getCorreo());
			ps.setString(4, user.getContrasena());
			ps.setString(5, user.getTipo());
			ps.setInt(6, user.getIDCasa());
			ps.setInt(7, user.getEdad());
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}

		}
		return id;
	}


	public TUsuario buscarUsuario(TUsuario user) {
		TUsuario usuario = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaction = tm.getTransaction();
		
		if(transaction != null) {
			Connection cn = (Connection) transaction.getResource();
	
			try {
				
				PreparedStatement query = cn.prepareStatement("SELECT * FROM usuario WHERE nombre = ? and contrasena = ?");
				query.setNString(1, user.getNombre());
				query.setString(2, user.getContrasena());
				ResultSet resultSet = query.executeQuery();
	
					if (resultSet.next()) {
						usuario = new TUsuario();
						usuario.setID(resultSet.getInt("ID"));
						usuario.setNombre(resultSet.getString("nombre"));
						usuario.setIDCasa(resultSet.getInt("IDCasa"));
						usuario.setCorreo(resultSet.getString("correo"));
						usuario.setTipo(resultSet.getString("tipo"));
						usuario.setContrasena(resultSet.getString("contrasena"));
						usuario.setEdad(resultSet.getInt("edad"));
						usuario.setApellidos(resultSet.getString("apellidos"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return usuario;
		
	}

}
