package Prototipo;

import javax.swing.JFrame;

public abstract class ModificarUsuario extends JFrame implements GUI{
	
	private static ModificarUsuarioImp instance;

	public static ModificarUsuario getInstance() {
		if(instance == null) instance = new ModificarUsuarioImp();
		return instance;
	}

}
