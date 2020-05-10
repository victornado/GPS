package Prototipo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	public static JTabbedPane tabbedPane;
	public JPanel panel_1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame f= new JFrame();
					DatosHabitacionImp frame = new DatosHabitacionImp();
					f.add(tabbedPane);
					f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public DatosHabitacionImp() {
		
		super();
		this.addDisp = new AniadirDispositivoImp();
		this.borrarDisp = new BorrarDispositivoImp();
		ChromeCastActivo=false;
		tabbedPane = null;
		actv = false;
		panel_1 = new JPanel();
		initGUI();
	}
	
	public void initGUI(){
	
	
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(318, 29, 489, 453);
		tabbedPane.setBackground(Color.WHITE);
		
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
	
	
	public void inicializarHabitaciones() {
	
		Controller.getInstance().handleRequest(new RequestContext(Eventos.MOSTRAR_DATOS_HABITACION, 1));
	}
	
	@Override
	public void Update(ResponseContext r) {
		
		if (r.getVista() == Eventos.MODIFICAR_ILUMINACION_HABITACION_KO)
			JOptionPane.showMessageDialog(null, "Fallo");
		else if (r.getVista() == Eventos.MODIFICAR_ILUMINACION_HABITACION_OK) {
			JOptionPane.showMessageDialog(null, "Temperatura cambiada");
		}
		else if(r.getVista() == Eventos.ACTIVAR_CHROMCAST_OK) {
			
			JOptionPane.showMessageDialog(null, "ChromeCast funcionando");
			ChromeCastActivo=true;
		}	
		else if(r.getVista() == Eventos.ACTIVAR_CHROMCAST_KO) {
			
			JOptionPane.showMessageDialog(null, "Algo salio mal al encender el ChromeCast","Error", JOptionPane.ERROR_MESSAGE);
		}
		else if(r.getVista() == Eventos.MODIFICA_VOLUMEN_CHROMCAST_OK) {
			
			JOptionPane.showMessageDialog(null, "Se ha cambiado el volument correctamente a "+r.getData());
		}
		else if(r.getVista() == Eventos.MODIFICA_VOLUMEN_CHROMCAST_KO) {
			
			JOptionPane.showMessageDialog(null, "El volumen no ha sido modificado","Error", JOptionPane.ERROR_MESSAGE);
		}
		else if(r.getVista() == Eventos.MOSTRAR_DATOS_HABITACION_OK) {
			
			JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane_1.setBorder(new EmptyBorder(0, 0, 0, 0));
			tabbedPane_1.setBackground(Color.WHITE);
			THabitacion habitacion = (THabitacion) r.getData();
			tabbedPane.addTab(habitacion.getTipo(), null, panel_1, null);
			List<TComponentesEnHabitacion> lista = habitacion.getComponentes();
			
			for(int i=0; i<lista.size(); i++) {
				
				if(lista.get(i).getNombre().equals("lampara1")) {
					panel_1.add(new Lampara(lista.get(i).getNombre()).panel);
				}
				else if(lista.get(i).getNombre().equals("ChormeCast")) {
					panel_1.add(new ChromeCast(lista.get(i).getNombre()).panel);
				}
			}
			
			if(lista.size() == 0) {
				JLabel lblNewLabel = new JLabel("No existen componentes en la habitacion");
				lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
				lblNewLabel.setBounds(50, 110, 220, 140);
				panel_1.add(lblNewLabel);
			}
			
		}
		else if(r.getVista() == Eventos.MOSTRAR_DATOS_HABITACION_KO) {
			
			tabbedPane.addTab("NINGUNA", null, panel_1, null);
			panel_1.setLayout(null);

			JLabel lblNewLabel = new JLabel("No existen habitaciones");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
			lblNewLabel.setBounds(150, 110, 220, 140);
			panel_1.add(lblNewLabel);
		}
		
	}

}
