package Integraci�n;

import Integraci�n.Casa.DAOCasa;
import Integraci�n.Casa.DAOCasaImp;
import Integraci�n.Habitacion.DAOHabitacion;
import Integraci�n.Habitacion.DAOHabitacionImp;
import Integraci�n.Usuario.DAOUsuario;
import Integraci�n.Usuario.DAOUsuarioImp;

public class FactoryDAOImp extends FactoryDAO {

	public DAOUsuario createDAOUsuario() {
		return new DAOUsuarioImp();
	}

	public DAOHabitacion createDAOHabitacion() {
		return new DAOHabitacionImp();
	}

	public DAOCasa createDAOCasa() {
		return new DAOCasaImp();
	}
}