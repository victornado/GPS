package Prototipo;

import javax.swing.JFrame;

public abstract class ListarObjetos extends JFrame implements GUI{
	
	private static ListarObjetosImp instance;

	public static ListarObjetosImp getInstance() {
		if(instance == null) instance = new ListarObjetosImp();
		return instance;
	}
}