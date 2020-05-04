package Prototipo;

import javax.swing.JFrame;

public abstract class BuscarHabitacion extends JFrame implements GUI{
	
	private static BuscarHabitacionImp instance;

	public static BuscarHabitacion getInstance() {
		if(instance == null) instance = new BuscarHabitacionImp();
		return instance;
	}

}
