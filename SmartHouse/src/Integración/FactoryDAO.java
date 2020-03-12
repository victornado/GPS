package Integración;

import Integración.Casa.DAOCasa;
import Integración.Habitacion.DAOHabitacion;
import Integración.Usuario.DAOUsuario;

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