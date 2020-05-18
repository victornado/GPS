package Prototipo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controller.Controller;
import Controller.Command.Eventos;
import Negocio.SA.Casa.TComponentesGenerales;
import Negocio.SA.Habitacion.TComponentesEnHabitacion;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.DataBufferDouble;
import java.util.Calendar;
import java.util.Hashtable;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class SHMenuImp extends SHMenu {

	private JPanel contentPane;
	private boolean actv;
	private ListarUsuarioImp listar;
	private AniadirUsuarioImp aniadiru;
	private AniadirDispositivoImp addDisp;
	private BorrarDispositivoImp borrarDisp;
	private TemperaturaExteriorImp tempExt;
	private TemperaturaInteriorImp tempInt;
//	private ModificarHabitacionImp modHab;
//	private BuscarHabitacionImp buscarHab;
	private HabitacionesDeLaCasaImp datosHab;
	private ListarHabitacionesImp listHab;
	private int x;
	private int y;
	private int hora;
	private int minutos;
	private int dia;
	private int mes;
	private int anio;
	private String msg;
	private Calendar calendario;
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
		msg = "Temperatura: 14.91�C   Humedad: 54%   Presion: 1016hPa";
	//	this.modHab = new ModificarHabitacionImp();
		this.listar = new ListarUsuarioImp();
		this.addDisp = new AniadirDispositivoImp();
		this.borrarDisp = new BorrarDispositivoImp();
		this.aniadiru = new AniadirUsuarioImp();
//		this.buscarHab = new BuscarHabitacionImp();
		this.tempInt = (TemperaturaInteriorImp) TemperaturaInterior.getInstance();
		this.listHab = new ListarHabitacionesImp();
		tempInt.setMenu(this);
		ChromeCastActivo=false;
		initGUI();
	}
	
	

	public void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		
		lblTemperatura2 = new JLabel("25�C");
		lblTemperatura2.setBounds(270, 260, 123, 33);
		lblTemperatura2.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblTemperatura2);
		inicializarTemp();
		
		lblIluminacion2 = new JLabel("Medio");
		lblIluminacion2.setBounds(270, 100, 123, 33);
		lblIluminacion2.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblIluminacion2);
		inicializarIlum();
		
		
		lblHumedad2 = new JLabel("55%");
		lblHumedad2.setBounds(270, 360, 123, 33);
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
		
//		JButton botonluz = new JButton("Guardar");
//		botonluz.setBounds(240, 185, 80, 20);
//		panel.add(botonluz);
//		botonluz.addActionListener(new ActionListener() {
//		
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				TComponentesGenerales tIluminacion = new TComponentesGenerales(1, (double) sliderluz.getValue());
//				RequestContext rContext = new RequestContext(Eventos.MODIFICAR_ILUMINACION, tIluminacion);
//				Controller.getInstance().handleRequest(rContext);
//				
//			}
//		});

		JLabel lbColor = new JLabel("Color");
		lbColor.setBounds(24, 190, 104, 33);
		lbColor.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lbColor);

		JSlider slidercolor = new JSlider();
		slidercolor.setBounds(24, 223, 273, 26);
		slidercolor.setBackground(SystemColor.activeCaption);
		panel.add(slidercolor);

		JLabel lblTemperatura = new JLabel("Temperatura");
		lblTemperatura.setBounds(24, 260, 123, 33);
		lblTemperatura.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblTemperatura);

		JSlider slidergrados = new JSlider();
		slidergrados.setBounds(24, 302, 273, 40);
		slidergrados.setBackground(SystemColor.activeCaption);
		slidergrados.setMinimum(12);
		slidergrados.setMaximum(32);
		slidergrados.setPaintLabels(true);
		slidergrados.setMajorTickSpacing(5);
		slidergrados.setMinorTickSpacing(5);
		slidergrados.setPaintTicks(true);
		Hashtable<Integer, JLabel> position1 = new Hashtable();
		position1.put(12, new JLabel("12�C"));
		position1.put(17, new JLabel("17�C"));
		position1.put(22, new JLabel("22�C"));
		position1.put(27, new JLabel("27�C"));
		position1.put(32, new JLabel("32�C"));
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
		
//		JButton botontemp = new JButton("Guardar");
//		botontemp.setBounds(240, 360, 80, 20);
//		panel.add(botontemp);
//		botontemp.addActionListener(new ActionListener() {
//		
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				TComponentesGenerales tTemperatura = new TComponentesGenerales(1, (double) slidergrados.getValue());
//				RequestContext rContext = new RequestContext(Eventos.MODIFICAR_TEMPERATURA, tTemperatura);
//				Controller.getInstance().handleRequest(rContext);
//				
//			}
//		});

		JLabel lblHumedad = new JLabel("Humedad");
		lblHumedad.setBounds(26, 360, 123, 33);
		lblHumedad.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblHumedad);

		JSlider sliderhumedad = new JSlider();
		sliderhumedad.setBounds(24, 393, 269, 40);
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
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setBounds(240, 460, 80, 20);
		panel.add(botonGuardar);
		botonGuardar.addActionListener(new ActionListener() {
		

			@Override
			public void actionPerformed(ActionEvent e) {
				//TComponentesGenerales tModificar = new TComponentesGenerales(1, msg, (double) sliderluz.getValue(), (double) slidergrados.getValue(), (double) sliderhumedad.getValue());
				TComponentesGenerales tModificar1 = new TComponentesGenerales(1, 1, "Iluminacion",sliderluz.getValue());
				modificarIlum(tModificar1);
				
				TComponentesGenerales tModificar2 = new TComponentesGenerales(1, 1, "Temperatura",slidergrados.getValue());
				modificarTemp(tModificar2);
				
				TComponentesGenerales tModificar3 = new TComponentesGenerales(1, 1, "Humedad", sliderhumedad.getValue());
				modificarHum(tModificar3);			
				
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
		weatherBtn.setBounds(220, 35, 24, 21);
		weatherBtn.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/temp.png")));
		weatherBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tempExt.setVisible(true);
				tempExt.mostrarTemperatura();
			}

		});
		panel.add(weatherBtn);

//		JButton modifyHabitacionBtn = new JButton();
//		modifyHabitacionBtn.setBounds(250, 35, 24, 21);
//		modifyHabitacionBtn.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/cuna.png")));
//		modifyHabitacionBtn.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				modHab.setVisible(true);
//			}
//
//		});
//		panel.add(modifyHabitacionBtn);
//
//		JButton buscaryHabitacionBtn = new JButton();
//		buscaryHabitacionBtn.setBounds(280, 35, 24, 21);
//		buscaryHabitacionBtn.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/lupa.png")));
//		buscaryHabitacionBtn.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				buscarHab.setVisible(true);
//			}
//
//		});
//		panel.add(buscaryHabitacionBtn);
//		
				
		JButton habitacion = new JButton("Habitacion");
		habitacion.setBounds(145, 10, 74, 21);
		habitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//listHab.setVisible(true);
				listarHabitaciones();
			}

		});
		panel.add(habitacion);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(145, 35, 74, 21);
		panel.add(menuBar);

		JMenu mnAjustes = new JMenu("Ajustes");
		menuBar.add(mnAjustes);

		JMenuItem mntmAadirUsuario = new JMenuItem("Aniadir Usuario");
		mnAjustes.add(mntmAadirUsuario);

		mntmAadirUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				aniadiru.setVisible(true);
			}
		});

		JMenuItem mntmModificarUsuario = new JMenuItem("Listar Usuarios");
		mntmModificarUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listarUsua();
			}
		});
		mnAjustes.add(mntmModificarUsuario);
		
		JMenuItem mntmModificarHabitacion = new JMenuItem("Listar Habitaciones");
		mntmModificarHabitacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listarHabitaciones();
			}
		});
		mnAjustes.add(mntmModificarHabitacion);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/user.png")));
		label_1.setBounds(32, 11, 60, 70);
		panel.add(label_1);
		
		/*JTabbedPane tabbedPaneInicial = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneInicial.setBounds(330, 29, 500, 453);
		tabbedPaneInicial.setBackground(Color.WHITE);
		datosHab.inicializarHabitaciones(IDCasa);
		tabbedPaneInicial.add(datosHab.panel_1);
		tabbedPaneInicial.setVisible(true);*/
		
		this.datosHab = new HabitacionesDeLaCasaImp();
		datosHab.inicializarHabitaciones();
		
		panel.add(datosHab.tabbedPane);
		
		/*panel.add(tabbedPaneInicial);*/
		panel.setVisible(true);
	}

	@Override
	public void Update(ResponseContext r) {
		
		if (r.getVista() == Eventos.MODIFICAR_ILUMINACION_KO) {
			JOptionPane.showMessageDialog(null, "Fallo");
		}
		else if (r.getVista() == Eventos.MODIFICAR_ILUMINACION_OK) {
			JOptionPane.showMessageDialog(null, "Iluminacion de la casa cambiada");
		}
		else if (r.getVista() == Eventos.MODIFICAR_TEMPERATURA_KO) {
			JOptionPane.showMessageDialog(null, "Fallo");
		}
		else if (r.getVista() == Eventos.MODIFICAR_TEMPERATURA_OK) {
			JOptionPane.showMessageDialog(null, "Temperatura de la casa cambiada");
		}
		else if (r.getVista() == Eventos.MODIFICAR_HUMEDAD_KO) {
			JOptionPane.showMessageDialog(null, "Fallo");
		}
		else if (r.getVista() == Eventos.MODIFICAR_HUMEDAD_OK) {
			JOptionPane.showMessageDialog(null, "Humedad de la casa cambiada");
		}
		else if(r.getVista() == Eventos.Eliminar_USUARIO_KO) {
			JOptionPane.showMessageDialog(null, "El usuario no se pudo eliminar","Error", JOptionPane.ERROR_MESSAGE);
			listarUsua();
		}
		else if(r.getVista() == Eventos.Eliminar_USUARIO_OK) {
			JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
			listarUsua();
		}
		else if(r.getVista() == Eventos.Modificar_USUARIO_KO) {
			JOptionPane.showMessageDialog(null, "El usuario no se pudo modificar","Error", JOptionPane.ERROR_MESSAGE);
			listarUsua();
		}
		else if(r.getVista() == Eventos.Modificar_USUARIO_OK) {
			JOptionPane.showMessageDialog(null, "Se ha modificado correctamente");
			listarUsua();
		}
		else if(r.getVista() == Eventos.MODIFICAR_HABITACION_KO) {
			JOptionPane.showMessageDialog(null, "La habitacion no se pudo modificar","Error", JOptionPane.ERROR_MESSAGE);
			listarUsua();
		}
		else if(r.getVista() == Eventos.MODIFICAR_HABITACION_OK) {
			JOptionPane.showMessageDialog(null, "Se ha modificado correctamente");
			listarUsua();
		}

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		Font font = new Font("Arial", Font.PLAIN, 13);
		g2.setFont(font);
		g2.setColor(Color.BLACK);

		calendario = Calendar.getInstance();
	    hora =calendario.get(Calendar.HOUR_OF_DAY);
	    minutos = calendario.get(Calendar.MINUTE);
	    dia = calendario.get(Calendar.DAY_OF_MONTH);
	    mes = calendario.get(Calendar.MONTH)+1;
	    anio = calendario.get(Calendar.YEAR);
	    
	   String msgDraw = msg+"        [Madrid   "+hora+":"+minutos+"   "+dia+"/"+mes+"/"+anio+"]";
		g2.drawString(msgDraw, x, y);
		try {
			Thread.sleep(10);
		} catch (Exception ex) {
		}
		;

		x -= 1;

		if (x == -7 * msgDraw.length()) {
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
		TComponentesGenerales casa = new TComponentesGenerales(IDCasa);
		RequestContext rContext = new RequestContext(Eventos.MOSTRAR_ILUMINACION, casa);
		Controller.getInstance().handleRequest(rContext);
	}
	
	public void inicializarTemp() {
		TComponentesGenerales casa = new TComponentesGenerales(IDCasa);
		RequestContext rContext = new RequestContext(Eventos.MOSTRAR_TEMPERATURA, casa);
		Controller.getInstance().handleRequest(rContext);
	}
	
	public void inicializarHum() {
		TComponentesGenerales casa = new TComponentesGenerales(IDCasa);
		RequestContext rContext = new RequestContext(Eventos.MOSTRAR_HUMEDAD, casa);
		Controller.getInstance().handleRequest(rContext);
	}
	
	public void modificarIlum(TComponentesGenerales casa) {		
		RequestContext rContext = new RequestContext(Eventos.MODIFICAR_ILUMINACION, casa);
		Controller.getInstance().handleRequest(rContext);
	}
	
	public void modificarTemp(TComponentesGenerales casa) {		
		RequestContext rContext = new RequestContext(Eventos.MODIFICAR_TEMPERATURA, casa);
		Controller.getInstance().handleRequest(rContext);
	}
	
	public void listarUsua() {	
		RequestContext rContext = new RequestContext(Eventos.Listar_USUARIO, null);
		Controller.getInstance().handleRequest(rContext);
	}	
	
	public void modificarHum(TComponentesGenerales casa) {	
		RequestContext rContext = new RequestContext(Eventos.MODIFICAR_HUMEDAD, casa);
		Controller.getInstance().handleRequest(rContext);
	}	
//	
//	public void buscarHabitacion(String nameHabitacion) {	
//		//RequestContext rContext = new RequestContext(Eventos.BUSCAR_HABITACION, casa);
//		//Controller.getInstance().handleRequest(rContext);
//		
//	}	
//	
	public void listarHabitaciones() {	
		RequestContext rContext = new RequestContext(Eventos.LISTAR_HABITACIONES, null);
		Controller.getInstance().handleRequest(rContext);
	}	
	
	
}
