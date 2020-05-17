package Prototipo.Factory;

import Controller.Command.Eventos;
import Controller.Command.Usuario.LoginUsuario;
import Prototipo.LoginImp;
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
		else if(r.getVista()>= 200 && r.getVista()<206)
			HabitacionesDeLaCasa.getInstance().Update(r);
		else if(r.getVista() >= 300 && r.getVista() < 400) 
			TemperaturaInterior.getInstance().Update(r);
		else if(r.getVista() >= 600 && r.getVista() < 800) 
			HabitacionesDeLaCasa.getInstance().Update(r);
		else if(r.getVista()>= 206 && r.getVista()<209)
			HabitacionesDeLaCasa.getInstance().Update(r);
		else if(r.getVista() >= 112 && r.getVista() <= 114) 
			ListarUsuario.getInstance().Update(r);
		else if(r.getVista() >= 210 && r.getVista() <= 212) 
			ListarHabitaciones.getInstance().Update(r);
		else if(r.getVista() >= 103 && r.getVista() < 112)
			SHMenu.getInstance().Update(r);
		else if(r.getVista() >= 221 && r.getVista() < 224)
			HabitacionesDeLaCasa.getInstance().Update(r);
	}

}
