package Controller.Command;

import Controller.Command.Casa.ModificarHumedadCasa;
import Controller.Command.Casa.ModificarIluminacionCasa;
import Controller.Command.Casa.ModificarTemperaturaCasa;
import Controller.Command.Casa.MostrarDatosHumedad;
import Controller.Command.Casa.MostrarDatosIluminacion;
import Controller.Command.Casa.MostrarDatosTemperatura;
import Controller.Command.ChromeCast.ActivarChromeCast;
import Controller.Command.ChromeCast.SubirVolumen;
import Controller.Command.Habitacion.ModificarIluminacionHabitacion;
import Controller.Command.Habitacion.MostrarHabitacion;
import Controller.Command.Habitacion.MostrarIluminacionHabitacion;
import Controller.Command.Usuario.AniadirUsuario;
import Controller.Command.Usuario.LoginUsuario;

public class CommandFactoryImp extends CommandFactory{

	@Override
	public Command getCommand(int commandName) {
		
		switch(commandName) {
		
		case Eventos.LOGIN_USUARIO: return new LoginUsuario();
		case Eventos.MOSTRAR_ILUMINACION_HABITACION: return new MostrarIluminacionHabitacion();
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
		default: return null;
		
		}
	}

}
