package Prototipo.Factory;

import Controller.Command.Eventos;
import Controller.Command.Usuario.LoginUsuario;
import Prototipo.Login;
import Prototipo.Observer;

public class FactoryVistasImp extends FactoryVistas {

	@Override
	public Observer getVistas(int vistasName) {
		if(vistasName >= 100 && vistasName < 200) 
			return new Login();
		
		return null;
	}

}
