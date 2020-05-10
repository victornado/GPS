package Integracion.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

import Negocio.SA.Usuario.TUsuario;

public interface DAOUsuario {

	public abstract int darDeAlta(TUsuario user) throws SQLException;
	public abstract TUsuario buscarUsuario(TUsuario user);
	public abstract TUsuario modificarUsuario(TUsuario user);
	public abstract int eliminarUsuario(int user);
	public abstract ArrayList<TUsuario> ListarUsuarios();
}
