package Main;

import java.awt.EventQueue;

import Controller.Command.Eventos;
import Prototipo.LoginImp;
import Prototipo.ResponseContext;
import Prototipo.Factory.Dispatcher;

public class Main {
	
	public static final String applicationName = "SmartHouse";
	public static String database = "RX4xmQHBsM";
	public static String user = "RX4xmQHBsM";
	public static String password = "BHgDaFHEJc";


	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dispatcher.getInstance().actualizaVistas( new ResponseContext(Eventos.LOGIN_USUARIO, null));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}