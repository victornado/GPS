package Prototipo;

import javax.swing.JFrame;

public abstract class AniadirDispositivo extends JFrame implements GUI{
	
	private static AniadirDispositivoImp instance;

	public static AniadirDispositivo getInstance() {
		if(instance == null) instance = new AniadirDispositivoImp();
		return instance;
	}

}
