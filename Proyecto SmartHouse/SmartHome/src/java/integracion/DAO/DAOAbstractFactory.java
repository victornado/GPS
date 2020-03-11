
package java.integracion.DAO;

import java.integracion.Casa.DAOCasa;
import java.integracion.Habitacion.DAOHabitacion;
import java.integracion.Usuario.DAOUsuario;


public abstract class DAOAbstractFactory {

	private static DAOAbstractFactory instance;

	public static DAOAbstractFactory getInstance() {
		if(instance == null) instance = new DAOAbstractFactoryImpl();
		return instance;
	}
	public abstract DAOUsuario createDAOUsuario();
	public abstract DAOHabitacion createDAOHabitacion();
	public abstract DAOCasa createDAOCasa();
}