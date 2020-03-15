package Prototipo.Factory;

import Prototipo.GUI;
import Prototipo.ResponseContext;

public abstract class Dispatcher {
	
	private static DispatcherImp instance;

	public static Dispatcher getInstance() {
		if(instance == null) instance = new DispatcherImp();
		return instance;
	}
	
	public abstract void actualizaVistas(ResponseContext r);

}
