package Prototipo.Factory;

import Prototipo.Observer;

public abstract class FactoryVistas {
	
	private static FactoryVistasImp instance;

	public static FactoryVistas getInstance() {
		if(instance == null) instance = new FactoryVistasImp();
		return instance;
	}
	
	public abstract Observer getVistas(int vistasName);

}
