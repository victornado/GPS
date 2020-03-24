package Prototipo;

import javax.swing.JFrame;

public abstract class TemperaturaExterior extends JFrame implements GUI{
	
	private static TemperaturaExterior instance;

	public static TemperaturaExterior getInstance() {
		if(instance == null) instance = new TemperaturaExteriorImp();
		return instance;
	} 

}