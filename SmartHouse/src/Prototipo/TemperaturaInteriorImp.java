package Prototipo;

import javax.swing.JOptionPane;

import Controller.Command.Eventos;

public class TemperaturaInteriorImp extends TemperaturaInterior {

	private SHMenuImp menu;
	

	public void Update(ResponseContext r) {
		if(r.getVista() == Eventos.MOSTRAR_TEMPERATURA_OK) {
			menu.modificarLabelTemperatura((Double)r.getData());
		}
		else if(r.getVista() == Eventos.MOSTRAR_TEMPERATURA_KO)
			JOptionPane.showMessageDialog(null, "No esposible mostrar la temperatura", "Incorrecto", JOptionPane.ERROR_MESSAGE);
		
		
	}
	
	
	public void setMenu(SHMenuImp menu) {
		this.menu = menu;
	}
}
