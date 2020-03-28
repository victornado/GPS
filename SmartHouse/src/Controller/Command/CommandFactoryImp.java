package Controller.Command;

import Controller.Command.Casa.MostrarDatosTemperatura;
import Controller.Command.Habitacion.ModificarIluminacionHabitacion;
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
		case Eventos.MOSTRAR_TEMPERATURA : return new MostrarDatosTemperatura();
		case Eventos.MODIFICAR_ILUMINACION_HABITACION : return new ModificarIluminacionHabitacion();
		default: return null;
		
		}
	}

}
