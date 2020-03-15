package Integracion.Usuario;

import java.sql.SQLException;

import Negocio.SA.Usuario.TUsuario;

public interface DAOUsuario {

	public abstract int darDeAlta(TUsuario user) throws SQLException;
	public abstract TUsuario buscarUsuario(TUsuario user);
}
