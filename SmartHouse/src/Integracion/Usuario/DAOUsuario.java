package Integracion.Usuario;

import Negocio.SA.Usuario.TUsuario;

public interface DAOUsuario {

	public abstract int darDeAlta(TUsuario user);
	public abstract TUsuario buscarUsuario(TUsuario user);
}
