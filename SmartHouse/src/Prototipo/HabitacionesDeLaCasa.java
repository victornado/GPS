package Prototipo;

import javax.swing.JPanel;

public abstract class HabitacionesDeLaCasa extends JPanel implements GUI{

	private static HabitacionesDeLaCasaImp instance;

	public static HabitacionesDeLaCasa getInstance() {
		if(instance == null) instance = new HabitacionesDeLaCasaImp();
		return instance;
	}


}
