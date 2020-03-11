package java.integracion.DAO;

import java.integracion.Casa.DAOCasa;
import java.integracion.Casa.DAOCasaImpl;
import java.integracion.Habitacion.DAOHabitacion;
import java.integracion.Habitacion.DAOHabitacionImpl;
import java.integracion.Usuario.DAOUsuario;
import java.integracion.Usuario.DAOUsuarioImpl;


public class DAOAbstractFactoryImpl extends DAOAbstractFactory {

	public DAOUsuario createDAOUsuario() {
		return new DAOUsuarioImpl();
	}

	public DAOHabitacion createDAOHabitacion() {
		return new DAOHabitacionImpl();
	}

	public DAOCasa createDAOCasa() {
		return new DAOCasaImpl();
	}
}