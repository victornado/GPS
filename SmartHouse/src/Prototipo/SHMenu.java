package Prototipo;

import javax.swing.JFrame;

public abstract class SHMenu extends JFrame implements GUI{
	
	private static SHMenuImp instance;

	public static SHMenu getInstance() {
		if(instance == null) instance = new SHMenuImp();
		return instance;
	}

}
