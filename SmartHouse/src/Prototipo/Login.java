package Prototipo;

import javax.swing.JFrame;

public abstract class Login extends JFrame implements GUI {
	
	private static LoginImp instance;

	public static Login getInstance() {
		if(instance == null) instance = new LoginImp();
		return instance;
	}
	

}
