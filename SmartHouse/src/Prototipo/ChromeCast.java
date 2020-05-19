package Prototipo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;

import Controller.Controller;
import Controller.Command.Eventos;
import Negocio.SA.Habitacion.TComponentesEnHabitacion;

public class ChromeCast extends JPanel implements GUI {
	
public JPanel panel;
public String nombre;
public int id;
public int idHab;
private boolean ChromeCastActivo;
private boolean actv;
	
	public ChromeCast(String Nombre, int id, int hab) {
		super();
		panel = new JPanel();
		nombre = Nombre;
		actv = false;
		ChromeCastActivo=false;
		this.id = id;
		idHab = hab;
		initGUI();
	}
	
	
	public void initGUI() {
		
		JLabel lblSmartTv = new JLabel("Chrome cast");
		lblSmartTv.setBounds(22, 267, 75, 14);
		panel.add(lblSmartTv);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner.setBounds(120, 264, 50, 20);
		panel.add(spinner);


		JButton button_2 = new JButton("Change volume");
		button_2.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/volume.png")));
		button_2.setBounds(180, 263, 150, 25);
		panel.add(button_2);
		
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(ChromeCastActivo) {
				
					RequestContext rContext = new RequestContext(Eventos.MODIFICA_VOLUMEN_CHROMCAST, Integer.parseInt(spinner.getValue().toString()));
					Controller.getInstance().handleRequest(rContext);
					ChromeCastActivo=true;
				}
				else JOptionPane.showMessageDialog(null, "ChromeCast no esta activo", "Error", JOptionPane.ERROR_MESSAGE);
				
			}
		});
		
		JToggleButton toggleButton_5 = new JToggleButton("");
		toggleButton_5.setBounds(378, 266, 53, 20);
		toggleButton_5.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Siwtch OFF.png")));
		panel.add(toggleButton_5);
		toggleButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(!ChromeCastActivo) {
					
					toggleButton_5.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Switch ON.png")));
					
					actv=true;
					List pair = new ArrayList<Integer>();
					pair.add(id);
					pair.add(idHab);
					RequestContext rContext = new RequestContext(Eventos.ACTIVAR_CHROMCAST, pair);
					Controller.getInstance().handleRequest(rContext);
					//ChromeCastActivo=true;
				
				}
				else {
					toggleButton_5.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Siwtch OFF.png")));
					actv=false;
					ChromeCastActivo=false;
				}								
			}
		});

		
		
	}
	
	
	@Override
	public void Update(ResponseContext r) {
		if(r.getVista() == Eventos.ACTIVAR_CHROMCAST_OK) {
		
			JOptionPane.showMessageDialog(null, "ChromeCast funcionando");
			ChromeCastActivo=true;
		}	
	}

}
