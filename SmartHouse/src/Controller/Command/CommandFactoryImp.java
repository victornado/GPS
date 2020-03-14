package Controller.Command;

import Controller.Command.Habitacion.MostrarIluminacionHabitacion;
import Controller.Command.Usuario.LoginUsuario;

public class CommandFactoryImp extends CommandFactory{

	@Override
	public Command getCommand(int commandName) {
		
		switch(commandName) {
		
		case Eventos.LOGIN_USUARIO: return new LoginUsuario();
		case Eventos.MOSTRAR_ILUMINACION_HABITACION: return new MostrarIluminacionHabitacion();
		default: return null;
		
		}
	}

}
