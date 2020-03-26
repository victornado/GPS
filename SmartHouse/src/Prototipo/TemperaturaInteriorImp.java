package Prototipo;

import javax.swing.JOptionPane;

import Controller.Command.Eventos;

public class TemperaturaInteriorImp extends TemperaturaInterior {

	@Override
	public void Update(ResponseContext r) {
		if(r.getVista() == Eventos.MOSTRAR_TEMPERATURA_OK) {
			//necesito que me pases la temperatura para la label y el id de casa para la bbdd
		}
		else if(r.getVista() == Eventos.MOSTRAR_TEMPERATURA_KO)
			JOptionPane.showMessageDialog(null, "No esposible mostrar la temperatura", "Incorrecto", JOptionPane.ERROR_MESSAGE);
		
		
	}

}
