package Prototipo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
		initGUI();
	}
	
	public void initGUI(){
	
	
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(318, 29, 489, 453);
		tabbedPane.setBackground(Color.WHITE);
		
		
		
		Controller.getInstance().handleRequest(new RequestContext(Eventos.MOSTRAR_DATOS_HABITACION, 1));
		
		
		/*JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Habitacion 1", null, tabbedPane_1, null);

		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Habitacion 2", null, tabbedPane_2, null);

		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3.setBackground(Color.WHITE);
		tabbedPane.addTab("Habitacion 3", null, tabbedPane_3, null);

		JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_4.setBackground(Color.WHITE);
		tabbedPane.addTab("Garaje", null, tabbedPane_4, null);

		JTabbedPane tabbedPane_5 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_5.setBackground(Color.WHITE);
		tabbedPane.addTab("Comedor", null, tabbedPane_5, null);

		JTabbedPane tabbedPane_6 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_6.setBackground(Color.WHITE);
		tabbedPane.addTab("Cuarto de Estar", null, tabbedPane_6, null);
			
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane_6.addTab("C", null, panel_1, null);
		panel_1.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(22, 33, 420, 2);
		panel_1.add(separator);

		JLabel lblNewLabel = new JLabel("DISPOSITIVOS");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel.setBounds(22, 11, 149, 14);
		panel_1.add(lblNewLabel);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/estrella.png")));
		label_2.setBounds(395, 4, 30, 25);
		panel_1.add(label_2);

		JLabel lblNewLabel_1 = new JLabel("Lampara 1");
		lblNewLabel_1.setBounds(22, 57, 103, 14);
		panel_1.add(lblNewLabel_1);
		
		JSlider slider_4 = new JSlider(); // lampara 1
		slider_4.setBounds(135, 55, 200, 26);
		panel_1.add(slider_4);
		slider_4.setMinimum(12);
		slider_4.setMaximum(32);
		slider_4.setPaintLabels(true);
		slider_4.setMajorTickSpacing(5);
		slider_4.setMinorTickSpacing(5);

		JLabel lblLamparaTecho = new JLabel("Lampara techo");
		lblLamparaTecho.setBounds(22, 99, 103, 14);
		panel_1.add(lblLamparaTecho);

		JSlider slider_5 = new JSlider();
		slider_5.setBounds(135, 92, 200, 26);
		panel_1.add(slider_5);

		JLabel lblVentilador = new JLabel("Ventilador");
		lblVentilador.setBounds(22, 139, 103, 14);
		panel_1.add(lblVentilador);

		JSlider slider_6 = new JSlider();
		slider_6.setBounds(135, 133, 200, 26);
		panel_1.add(slider_6);

		JLabel lblEstufa = new JLabel("Estufa");
		lblEstufa.setBounds(22, 176, 103, 14);
		panel_1.add(lblEstufa);

		JSlider slider_7 = new JSlider();
		slider_7.setBounds(135, 173, 200, 26);
		panel_1.add(slider_7);

		JLabel lblPuerta = new JLabel("Puerta");
		lblPuerta.setBounds(22, 220, 103, 14);
		panel_1.add(lblPuerta);

		JRadioButton rdbtnBloquear = new JRadioButton("Bloquear");
		rdbtnBloquear.setBounds(165, 216, 109, 23);
		panel_1.add(rdbtnBloquear);

		JLabel lblSmartTv = new JLabel("Chrome cast");
		lblSmartTv.setBounds(22, 267, 75, 14);
		panel_1.add(lblSmartTv);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner.setBounds(120, 264, 50, 20);
		panel_1.add(spinner);


		JButton button_2 = new JButton("Change volume");
		button_2.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/play.png")));
		button_2.setBounds(180, 263, 150, 25);
		panel_1.add(button_2);
		
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(ChromeCastActivo) {
				
					RequestContext rContext = new RequestContext(Eventos.MODIFICA_VOLUMEN_CHROMCAST, Integer.parseInt(spinner.getValue().toString()));
					Controller.getInstance().handleRequest(rContext);
				}
				else JOptionPane.showMessageDialog(null, "ChromeCast no esta activo", "Error", JOptionPane.ERROR_MESSAGE);
				
			}
		});

		

		JButton toggleButton_1 = new JButton("Actualizar");
		toggleButton_1.setBounds(378, 57, 53, 20);
		panel_1.add(toggleButton_1);
		toggleButton_1.addActionListener(new ActionListener() {
		

			@Override
			public void actionPerformed(ActionEvent e) {
				// hardcodeado id del componente y de la habitacion TODO
				TComponentesEnHabitacion tLampara = new TComponentesEnHabitacion(1, 1, lblNewLabel_1.getText(),slider_4.getValue());
				RequestContext rContext = new RequestContext(Eventos.MODIFICAR_ILUMINACION_HABITACION, tLampara);
				Controller.getInstance().handleRequest(rContext);
				
			}
		});

		JToggleButton toggleButton_2 = new JToggleButton("");
		toggleButton_2.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Siwtch OFF.png")));
		toggleButton_2.setBounds(378, 95, 53, 20);
		panel_1.add(toggleButton_2);
		toggleButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (!actv) {
					toggleButton_2.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Switch ON.png")));
					actv = true;

				} else {
					toggleButton_2.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Siwtch OFF.png")));
					actv = false;
				}
			}
		});

		JToggleButton toggleButton_3 = new JToggleButton("");
		toggleButton_3.setBounds(378, 135, 53, 20);
		toggleButton_3.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Siwtch OFF.png")));
		panel_1.add(toggleButton_3);
		toggleButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (!actv) {
					toggleButton_3.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Switch ON.png")));
					actv = true;

				} else {
					toggleButton_3.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Siwtch OFF.png")));
					actv = false;
				}
			}
		});

		JToggleButton toggleButton_4 = new JToggleButton("");
		toggleButton_4.setBounds(378, 172, 53, 20);
		toggleButton_4.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Siwtch OFF.png")));
		panel_1.add(toggleButton_4);
		toggleButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (!actv) {
					toggleButton_4.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Switch ON.png")));
					actv = true;

				} else {
					toggleButton_4.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Siwtch OFF.png")));
					actv = false;
				}
			}
		});

		JToggleButton toggleButton_5 = new JToggleButton("");
		toggleButton_5.setBounds(378, 266, 53, 20);
		toggleButton_5.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Siwtch OFF.png")));
		panel_1.add(toggleButton_5);
		toggleButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(!ChromeCastActivo) {
					
					toggleButton_5.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Switch ON.png")));
					
					actv=true;
					RequestContext rContext = new RequestContext(Eventos.ACTIVAR_CHROMCAST, null);
					Controller.getInstance().handleRequest(rContext);
					//ChromeCastActivo=true;
				
				}
				else {
					toggleButton_1.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Siwtch OFF.png")));
					actv=false;
					ChromeCastActivo=false;
				}								
			}
		});

		JToggleButton toggleButton_6 = new JToggleButton("");
		toggleButton_6.setBounds(378, 216, 53, 20);
		toggleButton_6.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Siwtch OFF.png")));
		panel_1.add(toggleButton_6);
		toggleButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (!actv) {
					toggleButton_6.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Switch ON.png")));
					actv = true;

				} else {
					toggleButton_6.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Siwtch OFF.png")));
					actv = false;
				}
			}
		});

		JButton button_6 = new JButton("");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarDisp.setVisible(true);
			}
		});
		button_6.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/papelera.png")));
		button_6.setBounds(109, 336, 40, 40);
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

		JLabel lblHabFavorita = new JLabel("Hab. Favorita");
		lblHabFavorita.setFont(new Font("Arial", Font.PLAIN, 11));
		lblHabFavorita.setBounds(299, 13, 103, 14);
		panel_1.add(lblHabFavorita);

		JPanel panel6 = new JPanel();
		panel6.setBackground(SystemColor.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JTabbedPane tabbedPane_7 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_7.setBackground(Color.WHITE);
		tabbedPane.addTab("Cocina", null, tabbedPane_7, null);

		JTabbedPane tabbedPane_8 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_8.setBackground(Color.WHITE);
		tabbedPane.addTab("Banio", null, tabbedPane_8, null);
		
		//tabbedPane.setVisible(true);*/
	}
	
	@Override
	public void Update(ResponseContext r) {
		if(r.getVista() == Eventos.ACTIVAR_CHROMCAST_OK) {
			
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
			tabbedPane.addTab(habitacion.getTipo(), null, tabbedPane_1, null);
		}
		else if(r.getVista() == Eventos.MOSTRAR_DATOS_HABITACION_KO) {
			
			JLabel a = new JLabel("Ninguna habitación encontradda");
			tabbedPane.add(a);
		}
		
	}

}
