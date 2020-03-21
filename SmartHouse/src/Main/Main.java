package Main;

import java.awt.EventQueue;

import Prototipo.LoginImp;

public class Main {
	
	public static final String applicationName = "SmartHouse";
	public static String database = "RX4xmQHBsM";
	public static String user = "RX4xmQHBsM";
	public static String password = "BHgDaFHEJc";


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