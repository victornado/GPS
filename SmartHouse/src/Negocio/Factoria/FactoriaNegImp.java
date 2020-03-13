package Negocio.Factoria;

import Negocio.SA.Usuario.SAUsuario;
import Negocio.SA.Usuario.SAUsuarioImp;

public class FactoriaNegImp extends FactoriaNeg{
	
	public SAUsuario createDAOUsuario() {
		return new SAUsuarioImp();
	}

}
