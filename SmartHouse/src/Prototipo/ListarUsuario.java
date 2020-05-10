package Prototipo;

import javax.swing.JFrame;

public abstract class ListarUsuario extends JFrame implements GUI{
	
	private static ListarUsuarioImp instance;

	public static ListarUsuarioImp getInstance() {
		if(instance == null) instance = new ListarUsuarioImp();
		return instance;
	}
}
