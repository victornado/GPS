package Prototipo.Factory;

import Controller.Command.Eventos;
import Controller.Command.Usuario.LoginUsuario;
import Prototipo.LoginImp;
import Prototipo.GUI;
import Prototipo.Login;
import Prototipo.ResponseContext;

public class DispatcherImp extends Dispatcher {

	@Override
	public void actualizaVistas(ResponseContext r) {
		if(r.getVista() >= 100 && r.getVista() < 200) 
			Login.getInstance().Update(r);

	}

}
