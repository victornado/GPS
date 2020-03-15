package Main;

import java.awt.EventQueue;

import Prototipo.LoginImp;

public class Main {
	
	public static final String applicationName = "SmartHouse";
	public static String database = "nombre de la base de datos";
	public static String user = "root";
	public static String password = "123";


	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginImp frame = new LoginImp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}