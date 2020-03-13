package Integracion;

import Integracion.Casa.DAOCasa;
import Integracion.Habitacion.DAOHabitacion;
import Integracion.Usuario.DAOUsuario;

public abstract class FactoryDAO {

	private static FactoryDAOImp instance;

	public static FactoryDAO getInstance() {
		if(instance == null) instance = new FactoryDAOImp();
		return instance;
	}
	public abstract DAOUsuario createDAOUsuario();
	public abstract DAOHabitacion createDAOHabitacion();
	public abstract DAOCasa createDAOCasa();
}