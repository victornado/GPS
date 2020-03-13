package Controller.Command;

import Controller.Command.Usuario.LoginUsuario;

public class CommandFactoryImp extends CommandFactory{

	@Override
	public Command getCommand(int commandName) {
		
		switch(commandName) {
		
		case Eventos.LOGIN_USUARIO: return new LoginUsuario();
		default: return null;
		
		}
	}

}
