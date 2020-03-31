package Prototipo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controller.Controller;
import Controller.Command.Eventos;
import Negocio.SA.Casa.TCasa;
import Negocio.SA.Habitacion.TComponentesEnHabitacion;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;

import javax.swing.JToggleButton;
import javax.swing.JSlider;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.DataBufferDouble;
import java.util.Hashtable;

import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import java.awt.Window.Type;

public class SHMenuImp extends SHMenu {

	private JPanel contentPane;
	private boolean actv;
	private ModificarUsuarioImp modificar;
	private AniadirUsuarioImp aniadiru;
	private AniadirDispositivoImp addDisp;
	private BorrarDispositivoImp borrarDisp;
	private TemperaturaExteriorImp tempExt;
	private TemperaturaInteriorImp tempInt;
	private int x;
	private int y;
	private String msg;
	private JLabel lblIluminacion2;
	private JLabel lblTemperatura2;
	private JLabel lblHumedad2;
	private int IDCasa = 1;// CUANDO SE CARGUE LA CASA ESTO DEBERIA ACTUALIZARSE
	private boolean ChromeCastActivo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SHMenu frame = new SHMenuImp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SHMenuImp() {
		super();
		setTitle("SMART HOME");
		this.contentPane = new JPanel();
		this.setFocusable(true);
		actv = false;
		x = 610;
		y = 531;
		this.tempExt = new TemperaturaExteriorImp();
		// msg = this.tempExt.getWeather();
		msg = "Temperatura: 14.91   Humedad: 54%   Presion: 1016hPa        [Madrid   13:54   24/3/2020]";
		this.modificar = new ModificarUsuarioImp();
		this.addDisp = new AniadirDispositivoImp();
		this.borrarDisp = new BorrarDispositivoImp();
		this.aniadiru = new AniadirUsuarioImp();
		this.tempInt = (TemperaturaInteriorImp) TemperaturaInterior.getInstance();
		tempInt.setMenu(this);
		ChromeCastActivo=false;
		initGUI();
	}

	public void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(318, 29, 489, 453);
		tabbedPane.setBackground(Color.WHITE);
		panel.add(tabbedPane);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
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
		tabbedPane_6.addTab("", null, panel_1, null);
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

		/*JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/c-.png")));
		label_3.setBounds(155, 261, 30, 25);
		panel_1.add(label_3);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/c-.png")));
		button.setBounds(195, 263, 25, 25);
		panel_1.add(button);

		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/c--.png")));
		button_1.setBounds(225, 263, 25, 25);
		panel_1.add(button_1);*/

		JButton button_2 = new JButton("Change volume");
		button_2.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/play.png")));
		button_2.setBounds(180, 263, 150, 25);
		panel_1.add(button_2);
		
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(ChromeCastActivo) {
				
					RequestContext rContext = new RequestContext(Eventos.MODIFICA_VOLUMEN_CHROMCAST, Integer.parseInt((String) spinner.getValue()));
					Controller.getInstance().handleRequest(rContext);
				}
				else JOptionPane.showMessageDialog(null, "ChromeCast no est� activo", "Error", JOptionPane.ERROR_MESSAGE);
				
			}
		});

		/*JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/--D.png")));
		button_3.setBounds(285, 263, 25, 25);
		panel_1.add(button_3);

		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/-D.png")));
		button_4.setBounds(316, 263, 25, 25);
		panel_1.add(button_4);

		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/lupa.png")));
		button_5.setBounds(360, 263, 25, 25);
		panel_1.add(button_5);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(22, 321, 420, 2);
		panel_1.add(separator_1);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Netflix 30x30.png.png")));
		label_4.setBounds(78, 258, 30, 30);
		panel_1.add(label_4);*/

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
					
					toggleButton_1.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Switch ON.png")));
					
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
		
		
		lblTemperatura2 = new JLabel("25ºC");
		lblTemperatura2.setBounds(270, 290, 123, 33);
		lblTemperatura2.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblTemperatura2);
		inicializarTemp();
		
		lblIluminacion2 = new JLabel("Medio");
		lblIluminacion2.setBounds(270, 100, 123, 33);
		lblIluminacion2.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblIluminacion2);
		inicializarIlum();
		
		
		lblHumedad2 = new JLabel("55%");
		lblHumedad2.setBounds(270, 390, 123, 33);
		lblHumedad2.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblHumedad2);
		inicializarHum();

		JLabel lblIlumniacin = new JLabel("Iluminacion");
		lblIlumniacin.setBounds(24, 85, 104, 33);
		lblIlumniacin.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblIlumniacin);

		JSlider sliderluz = new JSlider();
		sliderluz.setBounds(24, 129, 269, 40);
		sliderluz.setBackground(SystemColor.activeCaption);
		sliderluz.setMajorTickSpacing(50);
		sliderluz.setMinorTickSpacing(10);
		sliderluz.setPaintTicks(true);
		sliderluz.setPaintLabels(true);
		Hashtable<Integer, JLabel> position = new Hashtable();
		position.put(0, new JLabel("Minimo"));
		position.put(50, new JLabel("Medio"));
		position.put(100, new JLabel("Maximo"));
		sliderluz.setLabelTable(position);
		panel.add(sliderluz);
		sliderluz.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Double iluminacion = (double) sliderluz.getValue();
				modificarLabelIluminacion(iluminacion); 
			}
		});

		JLabel lbColor = new JLabel("Color");
		lbColor.setBounds(24, 190, 104, 33);
		lbColor.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lbColor);

		JSlider slidercolor = new JSlider();
		slidercolor.setBounds(24, 253, 273, 26);
		slidercolor.setBackground(SystemColor.activeCaption);
		panel.add(slidercolor);

		JLabel lblTemperatura = new JLabel("Temperatura");
		lblTemperatura.setBounds(24, 290, 123, 33);
		lblTemperatura.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblTemperatura);

		JSlider slidergrados = new JSlider();
		slidergrados.setBounds(24, 332, 273, 40);
		slidergrados.setBackground(SystemColor.activeCaption);
		slidergrados.setMinimum(12);
		slidergrados.setMaximum(32);
		slidergrados.setPaintLabels(true);
		slidergrados.setMajorTickSpacing(5);
		slidergrados.setMinorTickSpacing(5);
		slidergrados.setPaintTicks(true);
		Hashtable<Integer, JLabel> position1 = new Hashtable();
		position1.put(12, new JLabel("12ºC"));
		position1.put(17, new JLabel("17ºC"));
		position1.put(22, new JLabel("22ºC"));
		position1.put(27, new JLabel("27ºC"));
		position1.put(32, new JLabel("32ºC"));
		slidergrados.setLabelTable(position1);
		slidergrados.setValue(22);
		panel.add(slidergrados);
		slidergrados.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Double temperatura = (double) slidergrados.getValue();
				modificarLabelTemperatura(temperatura); 
			}
		});

		JLabel lblHumedad = new JLabel("Humedad");
		lblHumedad.setBounds(26, 390, 123, 33);
		lblHumedad.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblHumedad);

		JSlider sliderhumedad = new JSlider();
		sliderhumedad.setBounds(24, 423, 269, 40);
		sliderhumedad.setBackground(SystemColor.activeCaption);
		sliderhumedad.setMinimum(40);
		sliderhumedad.setMaximum(70);
		sliderhumedad.setPaintLabels(true);
		sliderhumedad.setMajorTickSpacing(15);
		sliderhumedad.setMinorTickSpacing(15);
		sliderhumedad.setPaintTicks(true);
		Hashtable<Integer, JLabel> position2 = new Hashtable();
		position2.put(40, new JLabel("40%"));
		position2.put(55, new JLabel("55%"));
		position2.put(70, new JLabel("70%"));
		sliderhumedad.setLabelTable(position2);
		sliderhumedad.setValue(55);
		panel.add(sliderhumedad);
		sliderhumedad.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Double humedad = (double) sliderhumedad.getValue();
				modificarLabelHumedad(humedad); 
			}
		});
		
		JLabel label = new JLabel("");
		label.setBounds(24, 228, 298, 14);
		label.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/colores.png")));
		panel.add(label);

		JToggleButton toggleButton = new JToggleButton("");
		toggleButton.setBounds(112, 91, 53, 20);

		toggleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!actv) {
					toggleButton.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Switch ON.png")));
					actv = true;

				} else {
					toggleButton.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Siwtch OFF.png")));
					actv = false;
				}
			}
		});
		toggleButton.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/Siwtch OFF.png")));
		panel.add(toggleButton);

		JButton weatherBtn = new JButton();
		weatherBtn.setBounds(240, 35, 24, 21);
		weatherBtn.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/temp.png")));
		weatherBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tempExt.setVisible(true);
				tempExt.mostrarTemperatura();
			}

		});
		panel.add(weatherBtn);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(180, 35, 55, 21);
		panel.add(menuBar);

		JMenu mnAjustes = new JMenu("Ajustes");
		menuBar.add(mnAjustes);

		JMenuItem mntmAadirUsuario = new JMenuItem("A�adir Usuario");
		mnAjustes.add(mntmAadirUsuario);

		mntmAadirUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				aniadiru.setVisible(true);
			}
		});

		JMenuItem mntmModificarUsuario = new JMenuItem("Modificar Usuario");
		mntmModificarUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				modificar.setVisible(true);
			}
		});
		mnAjustes.add(mntmModificarUsuario);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/user.png")));
		label_1.setBounds(32, 11, 60, 70);
		panel.add(label_1);
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
			
			JOptionPane.showMessageDialog(null, "Algo sali� mal al encender el ChromeCast","Error", JOptionPane.ERROR_MESSAGE);
		}
		else if(r.getVista() == Eventos.MODIFICA_VOLUMEN_CHROMCAST_OK) {
			
			JOptionPane.showMessageDialog(null, "Se ha cambiado el volument correctamente a "+r.getData());
		}
		else if(r.getVista() == Eventos.MODIFICA_VOLUMEN_CHROMCAST_KO) {
			
			JOptionPane.showMessageDialog(null, "El volumen no ha sido modificado","Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		Font font = new Font("Arial", Font.PLAIN, 13);
		g2.setFont(font);
		g2.setColor(Color.BLACK);

		g2.drawString(msg, x, y);
		try {
			Thread.sleep(10);
		} catch (Exception ex) {
		}
		;

		x -= 1;

		if (x == -7 * msg.length()) {
			x = 640;
		}
		repaint();
	}

	public void modificarLabelIluminacion(Double ilum) {
		if (ilum == 0)
			lblIluminacion2.setText("Apagada");
		else if (ilum == 50)
			lblIluminacion2.setText("Medio");
		else if (ilum == 100)
			lblIluminacion2.setText("Maximo");
		else
		lblIluminacion2.setText(ilum.toString() + "%");
	}
	
	public void modificarLabelTemperatura(Double temp) {
		if (temp == 12)
			lblTemperatura2.setText("Minimo");
		else if (temp == 32)
			lblTemperatura2.setText("Maximo");
		else
		lblTemperatura2.setText(temp.toString() + "ºC");
	}
	
	public void modificarLabelHumedad(Double hum) {
		if (hum == 40)
			lblHumedad2.setText("Minimo");
		else if (hum == 70)
			lblHumedad2.setText("Maximo");
		else
		lblHumedad2.setText(hum.toString() + "%");
	}

	public void inicializarIlum() {
		TCasa casa = new TCasa(IDCasa);
		RequestContext rContext = new RequestContext(Eventos.MOSTRAR_ILUMINACION, casa);
		Controller.getInstance().handleRequest(rContext);
	}
	
	public void inicializarTemp() {
		TCasa casa = new TCasa(IDCasa);
		RequestContext rContext = new RequestContext(Eventos.MOSTRAR_TEMPERATURA, casa);
		Controller.getInstance().handleRequest(rContext);
	}
	
	public void inicializarHum() {
		TCasa casa = new TCasa(IDCasa);
		RequestContext rContext = new RequestContext(Eventos.MOSTRAR_HUMEDAD, casa);
		Controller.getInstance().handleRequest(rContext);
	}
}
