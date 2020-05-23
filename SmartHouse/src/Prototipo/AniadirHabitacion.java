package Prototipo;

import javax.swing.JFrame;

	public abstract class AniadirHabitacion extends JFrame implements GUI{
		
		private static AniadirHabitacionImp instance;
		

		public static AniadirHabitacion getInstance() {
			if(instance == null) instance = new AniadirHabitacionImp();
			return instance;
		}

}
