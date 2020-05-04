package Prototipo;

import javax.swing.JFrame;

public abstract class ModificarHabitacion extends JFrame implements GUI{
	
	private static ModificarHabitacionImp instance;

	public static ModificarHabitacion getInstance() {
		if(instance == null) instance = new ModificarHabitacionImp();
		return instance;
	}

}
