package Prototipo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import Controller.Controller;
import Controller.Command.Eventos;
import Negocio.SA.Habitacion.TComponentesEnHabitacion;

public class Radiador extends JPanel implements GUI{
	
	public JPanel panel;
	public String nombre;
	public int id;
	public int idHab;
	
	
	public Radiador(String Nombre, int id, int idHab) {
		super();
		panel = new JPanel();
		nombre = Nombre;
		this.id = id;
		
		initGUI();
	}
	
public void initGUI() {
		
		
		JLabel lblNewLabel_1 = new JLabel(nombre);
		lblNewLabel_1.setBounds(22, 57, 103, 14);
		panel.add(lblNewLabel_1);
		
		JSlider slider_4 = new JSlider(); 
		slider_4.setBounds(135, 55, 200, 26);
		panel.add(slider_4);
		slider_4.setMinimum(12);
		slider_4.setMaximum(32);
		slider_4.setPaintLabels(true);
		slider_4.setMajorTickSpacing(5);
		slider_4.setMinorTickSpacing(5);
		
		JButton toggleButton_1 = new JButton("Actualizar");
		toggleButton_1.setBounds(378, 57, 53, 20);
		panel.add(toggleButton_1);
		toggleButton_1.addActionListener(new ActionListener() {
		

			@Override
			public void actionPerformed(ActionEvent e) {
				// hardcodeado id del componente y de la habitacion TODO
				/*TComponentesEnHabitacion tRadiador = new TComponentesEnHabitacion(1, 1, lblNewLabel_1.getText(),slider_4.getValue());
				RequestContext rContext = new RequestContext(Eventos.MODIFICAR_ILUMINACION_HABITACION, tRadiador);
				Controller.getInstance().handleRequest(rContext);*/
				
			}
		});
		
		
		
	}
	
	
	@Override
	public void Update(ResponseContext r) {

		
	}
	

}
