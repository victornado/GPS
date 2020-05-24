package Prototipo.Factory;

import Controller.Command.Eventos;
import Controller.Command.Usuario.LoginUsuario;
import Prototipo.LoginImp;
import Prototipo.AniadirUsuario;
import Prototipo.DatosHabitacion;
import Prototipo.GUI;
import Prototipo.HabitacionesDeLaCasa;
import Prototipo.HumedadInterior;
import Prototipo.IluminacionInterior;
import Prototipo.ListarHabitaciones;
import Prototipo.ListarUsuario;
import Prototipo.Login;
import Prototipo.ResponseContext;
import Prototipo.SHMenu;
import Prototipo.TemperaturaInterior;

public class DispatcherImp extends Dispatcher {

	@Override
	public void actualizaVistas(ResponseContext r) {
		if(r.getVista() >= 100 && r.getVista() < 103) 
			Login.getInstance().Update(r);
		else if(r.getVista() >=103 && r.getVista() <= 104)
			AniadirUsuario.getInstance().Update(r);
		else if(r.getVista() >= 300 && r.getVista() < 400) 
			TemperaturaInterior.getInstance().Update(r);
		else if(r.getVista() >= 600 && r.getVista() < 800) 
			HabitacionesDeLaCasa.getInstance().Update(r);
		else if(r.getVista() >= 112 && r.getVista() <= 114) 
			ListarUsuario.getInstance().Update(r);
		else if(r.getVista() >= 103 && r.getVista() < 112)
			SHMenu.getInstance().Update(r);
		else if(r.getVista() >= 200 && r.getVista() <= 241)
			HabitacionesDeLaCasa.getInstance().Update(r);
		else if(r.getVista() >=242 && r.getVista() <= 253)
			HabitacionesDeLaCasa.getInstance().Update(r);
	}
}
