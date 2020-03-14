package Integracion.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Integracion.Transacciones.Transaction;
import Integracion.Transacciones.TransactionManager;
import Negocio.SA.Usuario.TUsuario;

public class DAOUsuarioImp implements DAOUsuario {

	@Override
	public int darDeAlta(TUsuario user) {
		// TODO Auto-generated method stub
		return 0;
	}


	public TUsuario buscarUsuario(TUsuario user) {
		TUsuario usuario = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaction = tm.getTransaction();
		
		if(transaction != null) {
			Connection cn = (Connection) transaction.getResource();
			Statement st;
			try {
				st = cn.createStatement();
	
					ResultSet resultSet = st.executeQuery("SELECT * FROM Usuarios WHERE Nombre = " + user.getNombre() + " and Contraseña = " + user.getContrasena() );
	
					if (resultSet.next()) {
						usuario = new TUsuario();
						usuario.setID(resultSet.getInt("ID"));
						usuario.setNombre(resultSet.getString("nombre"));
						usuario.setIDCasa(resultSet.getInt("IDCasa"));
						usuario.setCorreo(resultSet.getString("correo"));
						usuario.setTipo(resultSet.getString("tipo"));
						usuario.setContrasena(resultSet.getString("contraseña"));
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
