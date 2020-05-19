package Controller.Command;

import Controller.Command.Casa.ModificarHumedadCasa;
import Controller.Command.Casa.ModificarIluminacionCasa;
import Controller.Command.Casa.ModificarTemperaturaCasa;
import Controller.Command.Casa.MostrarDatosHumedad;
import Controller.Command.Casa.MostrarDatosIluminacion;
import Controller.Command.Casa.MostrarDatosTemperatura;
import Controller.Command.Casa.MostrarHabitaciones;
import Controller.Command.ChromeCast.ActivarChromeCast;
import Controller.Command.ChromeCast.SubirVolumen;
import Controller.Command.Habitacion.ListarHabitaciones;
import Controller.Command.Habitacion.ModificarIluminacionHabitacion;
import Controller.Command.Habitacion.ModificarTemperaturaObjeto;
import Controller.Command.Habitacion.MostrarHabitacion;
import Controller.Command.Habitacion.MostrarHumedadObjeto;
import Controller.Command.Habitacion.MostrarIluminacionObjeto;
import Controller.Command.Habitacion.MostrarTemperaturaObjeto;
import Controller.Command.Usuario.AniadirUsuario;
import Controller.Command.Usuario.EliminarUsuario;
import Controller.Command.Usuario.ListarUsuarios;
import Controller.Command.Usuario.LoginUsuario;
import Controller.Command.Usuario.ModificarUsuario;
import Controller.Command.Habitacion.ModificarHabitacion;
import Controller.Command.Habitacion.ModificarHumedadObjeto;

public class CommandFactoryImp extends CommandFactory{

	@Override
	public Command getCommand(int commandName) {
		
		switch(commandName) {
		
		case Eventos.LOGIN_USUARIO: return new LoginUsuario();
		case Eventos.MOSTRAR_ILUMINACION_HABITACION: return new MostrarIluminacionObjeto();
		case Eventos.Aniadir_USUARIO: return new AniadirUsuario();
		case Eventos.MOSTRAR_ILUMINACION : return new MostrarDatosIluminacion();
		case Eventos.MOSTRAR_TEMPERATURA : return new MostrarDatosTemperatura();
		case Eventos.MOSTRAR_HUMEDAD : return new MostrarDatosHumedad();
		case Eventos.MODIFICAR_ILUMINACION_HABITACION : return new ModificarIluminacionHabitacion();
		case Eventos.MODIFICAR_ILUMINACION : return new ModificarIluminacionCasa();
		case Eventos.MODIFICAR_TEMPERATURA : return new ModificarTemperaturaCasa();
		case Eventos.MODIFICAR_HUMEDAD : return new ModificarHumedadCasa();
		case Eventos.MODIFICA_VOLUMEN_CHROMCAST: return new SubirVolumen();
		case Eventos.ACTIVAR_CHROMCAST: return new ActivarChromeCast();
		case Eventos.MOSTRAR_DATOS_HABITACION: return new MostrarHabitacion();
		case Eventos.Eliminar_USUARIO: return new EliminarUsuario();
		case Eventos.Modificar_USUARIO: return new ModificarUsuario();
		case Eventos.Listar_USUARIO: return new ListarUsuarios();
		case Eventos.LISTAR_HABITACIONES: return new ListarHabitaciones();
		case Eventos.MOSTRAR_HABITACIONES: return new MostrarHabitaciones();
		case Eventos.MODIFICAR_HABITACION: return new ModificarHabitacion();
		case Eventos.MOSTRAR_HUMEDAD_OBJETO: return new MostrarHumedadObjeto();
		case Eventos.MOSTRAR_ILUMINACION_OBJETO: return new MostrarIluminacionObjeto();
		case Eventos.MOSTRAR_TEMPERATURA_OBJETO: return new MostrarTemperaturaObjeto();
		case Eventos.MODIFICAR_TEMPERATURA_OBJETO: return new ModificarTemperaturaObjeto();
		case Eventos.MODIFICAR_HUMEDAD_OBJETO: return new ModificarHumedadObjeto();


		default: return null;
		
		}
	}

}
