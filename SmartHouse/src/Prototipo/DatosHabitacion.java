package Prototipo;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class DatosHabitacion extends JPanel implements GUI{
	private static DatosHabitacionImp instance;

	public static DatosHabitacion getInstance() {
		if(instance == null) instance = new DatosHabitacionImp();
		return instance;
	}


}
