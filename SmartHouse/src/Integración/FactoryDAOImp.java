package Integración;

import Integración.Casa.DAOCasa;
import Integración.Casa.DAOCasaImp;
import Integración.Habitacion.DAOHabitacion;
import Integración.Habitacion.DAOHabitacionImp;
import Integración.Usuario.DAOUsuario;
import Integración.Usuario.DAOUsuarioImp;

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