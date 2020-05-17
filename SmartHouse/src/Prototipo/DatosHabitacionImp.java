package Prototipo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Controller.Command.Eventos;
import Negocio.SA.Habitacion.TComponentesEnHabitacion;
import Negocio.SA.Habitacion.THabitacion;

public class DatosHabitacionImp extends DatosHabitacion {

	
	private AniadirDispositivoImp addDisp;
	private BorrarDispositivoImp borrarDisp;
	private boolean ChromeCastActivo;
	private boolean actv;
	public JPanel panel_1;
	public List<TComponentesEnHabitacion> lista;
	public List<GUI> listaClases;
	public int IdHab;
	


	
	public DatosHabitacionImp() {
		
		super();
		this.addDisp = new AniadirDispositivoImp();
		this.borrarDisp = new BorrarDispositivoImp();
		ChromeCastActivo=false;
		actv = false;
		panel_1 = new JPanel();
		//panel_1.setLayout(new);
		initGUI();
	}
	
	public void initGUI(){
	
		
		JButton button_6 = new JButton("");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarDisp.setVisible(true);
			}
		});
		
		button_6.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/papelera.png")));
		button_6.setBounds(50, 20, 20, 20);
		panel_1.add(button_6);

		JButton button_7 = new JButton("");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_7.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/lupa.png")));
		button_7.setBounds(335, 336, 40, 40);
		panel_1.add(button_7);

		JButton button_8 = new JButton("");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDisp.setVisible(true);
			}
		});
		button_8.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/+.png")));
		button_8.setBounds(223, 336, 43, 40);
		panel_1.add(button_8);

		
	}
	
	
	public void inicializarHabitaciones(int id) {
		
		IdHab= id;
	
		Controller.getInstance().handleRequest(new RequestContext(Eventos.MOSTRAR_DATOS_HABITACION, IdHab));
	}
	
	@Override
	public void Update(ResponseContext r) {
		
		if(r.getVista() == Eventos.ACTIVAR_CHROMCAST_OK) {
			
			int clase = 100000;
			
			for(int i= 0; i< lista.size(); ++i) {
				List <Integer> l = new ArrayList();
				l.add(lista.get(i).getIDComponente());
				l.add(lista.get(i).getIDhabitacion());
				List <Integer> dos = (List<Integer>) r.getData();
				if(l.get(0) == dos.get(0) &&  l.get(1) == dos.get(1) ) {
					clase = i;
					break;
				}
			}
			
			if(clase!= 100000) {
				listaClases.get(clase).Update(new ResponseContext(Eventos.ACTIVAR_CHROMCAST_OK, r.getData()));
			}
			//JOptionPane.showMessageDialog(null, "ChromeCast funcionando");
			//ChromeCastActivo=true;
		}	
		else if(r.getVista() == Eventos.ACTIVAR_CHROMCAST_KO) {
			
			JOptionPane.showMessageDialog(null, "Algo salio mal al encender el ChromeCast","Error", JOptionPane.ERROR_MESSAGE);
		}
		else if(r.getVista() == Eventos.MOSTRAR_DATOS_HABITACION_OK) {
			
			THabitacion habitacion = (THabitacion) r.getData();
			JPanel panelInterno = new JPanel();
			panelInterno.setPreferredSize(new Dimension(300,500));
			
			JScrollPane scroll = new JScrollPane();
			scroll.setPreferredSize(new Dimension(500,500));
            
			
			lista = habitacion.getComponentes();
			listaClases = new ArrayList<GUI>();
			
			for(int i=0; i<lista.size(); i++) {
				
				if(lista.get(i).getTipo().equals("bombilla")||lista.get(i).getTipo().equals("iluminacion")) {
					Lampara l = new Lampara(lista.get(i).getNombre(),lista.get(i).getIDComponente(),lista.get(i).getIDhabitacion());
					panelInterno.add(l.panel);
					listaClases.add(l);
				}
				else if(lista.get(i).getTipo().equals("ChromeCast")) {
					ChromeCast c = new ChromeCast(lista.get(i).getNombre(),lista.get(i).getIDComponente(), lista.get(i).getIDhabitacion());
					panelInterno.add(c.panel);
					listaClases.add(c);
				}
				else if(lista.get(i).getTipo().equals("temperatura")||lista.get(i).getTipo().equals("enchufe")) {
					Radiador c = new Radiador(lista.get(i).getNombre(),lista.get(i).getIDComponente(), lista.get(i).getIDhabitacion());
					panelInterno.add(c.panel);
					listaClases.add(c);
				}
				else if(lista.get(i).getTipo().equals("Humedad")) {
					Humidificador c = new Humidificador(lista.get(i).getNombre(),lista.get(i).getIDComponente(), lista.get(i).getIDhabitacion());
					panelInterno.add(c.panel);
					listaClases.add(c);
				}
			}
			
			if(lista.size() == 0) {
				
				JPanel j = new JPanel();
				JLabel lblNewLabel = new JLabel("No existen componentes en la habitacion");
				lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
				lblNewLabel.setBounds(50, 110, 220, 140);
				j.add(lblNewLabel);
				scroll.setViewportView(j);
				panel_1.add(scroll);
			}
			else {
				scroll.setViewportView(panelInterno);
				panel_1.add(scroll);
			}
			
			
		}
		else if(r.getVista() == Eventos.MOSTRAR_DATOS_HABITACION_KO) {
			
			panel_1.setLayout(null);

			JLabel lblNewLabel = new JLabel("No existen habitaciones");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
			lblNewLabel.setBounds(300, 300, 400, 140);
			panel_1.add(lblNewLabel);
		}
		
	}

}
