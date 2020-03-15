package Prototipo;

import javax.swing.JFrame;

public abstract class BorrarDispositivo extends JFrame implements GUI {
	

	private static BorrarDispositivoImp instance;

	public static BorrarDispositivo getInstance() {
		if(instance == null) instance = new BorrarDispositivoImp();
		return instance;
	}


}
