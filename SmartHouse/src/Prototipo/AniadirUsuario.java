package Prototipo;

import javax.swing.JFrame;

public abstract class AniadirUsuario extends JFrame implements GUI{
	
	private static AniadirUsuarioImp instance;
	

	public static AniadirUsuario getInstance() {
		if(instance == null) instance = new AniadirUsuarioImp();
		return instance;
	}

}
