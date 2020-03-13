package Integracion;

import Integracion.Casa.DAOCasa;
import Integracion.Casa.DAOCasaImp;
import Integracion.Habitacion.DAOHabitacion;
import Integracion.Habitacion.DAOHabitacionImp;
import Integracion.Usuario.DAOUsuario;
import Integracion.Usuario.DAOUsuarioImp;

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