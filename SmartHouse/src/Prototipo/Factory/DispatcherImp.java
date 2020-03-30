package Prototipo.Factory;

import Controller.Command.Eventos;
import Controller.Command.Usuario.LoginUsuario;
import Prototipo.LoginImp;
import Prototipo.GUI;
import Prototipo.Login;
import Prototipo.ResponseContext;
import Prototipo.SHMenu;
import Prototipo.TemperaturaInterior;

public class DispatcherImp extends Dispatcher {

	@Override
	public void actualizaVistas(ResponseContext r) {
		if(r.getVista() >= 100 && r.getVista() < 200) 
			Login.getInstance().Update(r);
		else if(r.getVista()>= 200 && r.getVista()<300)
			SHMenu.getInstance().Update(r);
		else if(r.getVista() >= 300 && r.getVista() < 400) 
			TemperaturaInterior.getInstance().Update(r);
		else if(r.getVista() >= 600 && r.getVista() < 800) 
			SHMenu.getInstance().Update(r);

	}

}
