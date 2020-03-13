package Integracion.Usuario;

import Negocio.Transfer.TUsuario;

public interface DAOUsuario {

	public abstract int darDeAlta(TUsuario user);
	public abstract int logearUsuario(TUsuario user);
}
