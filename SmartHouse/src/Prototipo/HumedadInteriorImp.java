package Prototipo;

import javax.swing.JOptionPane;

import Controller.Command.Eventos;

public class HumedadInteriorImp extends HumedadInterior {

	private SHMenuImp menu;
	

	public void Update(ResponseContext r) {
		if(r.getVista() == Eventos.MOSTRAR_HUMEDAD_OK) {
			menu.modificarLabelHumedad((Double)r.getData());
		}
		else if(r.getVista() == Eventos.MOSTRAR_HUMEDAD_KO)
			JOptionPane.showMessageDialog(null, "No esposible mostrar la humedad", "Incorrecto", JOptionPane.ERROR_MESSAGE);
		
		
	}
	
	
	public void setMenu(SHMenuImp menu) {
		this.menu = menu;
	}
}
