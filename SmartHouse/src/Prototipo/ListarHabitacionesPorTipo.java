package Prototipo;

import javax.swing.JFrame;

public abstract class ListarHabitacionesPorTipo extends JFrame implements GUI{


	private static ListarHabitacionesImp instance;

	public static ListarHabitacionesImp getInstance() {
		if(instance == null) instance = new ListarHabitacionesImp();
		return instance;
	}
}
