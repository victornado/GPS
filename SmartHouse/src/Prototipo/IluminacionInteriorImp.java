package Prototipo;

import javax.swing.JOptionPane;

import Controller.Command.Eventos;

public class IluminacionInteriorImp  extends IluminacionInterior {

	private SHMenuImp menu;
	

	public void Update(ResponseContext r) {
		if(r.getVista() == Eventos.MOSTRAR_ILUMINACION_OK) {
			menu.modificarLabelIluminacion((Double)r.getData());
		}
		else if(r.getVista() == Eventos.MOSTRAR_ILUMINACION_KO)
			JOptionPane.showMessageDialog(null, "No esposible mostrar la iluminacion", "Incorrecto", JOptionPane.ERROR_MESSAGE);
		
		
	}
	
	
	public void setMenu(SHMenuImp menu) {
		this.menu = menu;
	}
}
