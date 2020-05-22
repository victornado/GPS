package Prototipo;

import javax.swing.JFrame;

public abstract class ListarComponentesHabitacion extends JFrame implements GUI{
	private static ListarComponentesHabitacion instance;

	public static ListarComponentesHabitacion getInstance() {
		if(instance == null) instance = new ListarComponentesHabitacionImp();
		return instance;
	}
}
