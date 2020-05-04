package Prototipo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class BuscarHabitacionImp extends BuscarHabitacion{

	private JPanel contentPane;
	private JLabel titulo; 
	private JTextField txtNombre;
	private JTextField txtTipo;
	private JLabel combolblMsj;
	private JComboBox<String> combo1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarHabitacionImp frame = new BuscarHabitacionImp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BuscarHabitacionImp() {
		super();
		this.setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}
	
	

	/**
	 * Create the frame.
	 */
	public void initGUI() {
		
		setBounds(100, 100, 497, 480);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 489, 453);
		tabbedPane.setBackground(Color.WHITE);
		panel.add(tabbedPane);
	

		
		JTabbedPane tabbedPane_0 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_0.setBackground(Color.WHITE);
		tabbedPane.addTab("Buscar habitación", null, tabbedPane_0, null);

		JPanel busqueda = new JPanel();
		tabbedPane_0.addTab("Introduce el nombre de la habitación:", null, busqueda, null);
		busqueda.setLayout(null);	
		
		JSeparator separator_b = new JSeparator();
		separator_b.setBounds(22, 33, 420, 2);
		busqueda.add(separator_b);
		
		//titulo
		
		JLabel lblNewLabel_b = new JLabel("HABITACIONES");
		lblNewLabel_b.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_b.setBounds(22, 11, 149, 14);
		busqueda.add(lblNewLabel_b);
		//Icono de buscar
		
		JLabel label_b1 = new JLabel("");
		label_b1.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/lupa.png")));
		label_b1.setBounds(395, 4, 30, 25);
		busqueda.add(label_b1);
		
		//panel de busqueda
		JPanel JPanelBusqueda = new JPanel();
		JPanelBusqueda.setBounds(10, 30, 420, 320);
		JPanelBusqueda.setBackground(Color.WHITE);
		busqueda.add(JPanelBusqueda);
		
		//JTextField con boton de busqueda
		
		JTextField textfieldBusqueda = new JTextField();
		textfieldBusqueda.setToolTipText("");
		textfieldBusqueda.setText("Introduce el nombre de la habitacion");
		textfieldBusqueda.setForeground(Color.DARK_GRAY);
		textfieldBusqueda.setFont(new Font("Tahoma", Font.ITALIC, 11));
		textfieldBusqueda.setColumns(30);
		textfieldBusqueda.setBounds(0, 20, 10, 20);
		textfieldBusqueda.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (textfieldBusqueda.getText().equals("Introduce el nombre de la habitacion")) {
					textfieldBusqueda.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textfieldBusqueda.getText().equals("")) {
					textfieldBusqueda.setText("Introduce el nombre de la habitacion");
				}
			}
		});
		JPanelBusqueda.add(textfieldBusqueda);
		
		JButton buttonBusqueda = new JButton("Buscar");
		buttonBusqueda.setBounds(120, 20, 20, 20);		
		JPanelBusqueda.add(buttonBusqueda);
		buttonBusqueda.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = textfieldBusqueda.getText();
				
				
			} });
		
		//
		
		
		
		 }
		

	@Override
	public void Update(ResponseContext r) {
		// TODO Auto-generated method stub
		
	}
}


	/*
		
		

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BuscarHabitacionImp.class.getResource("/img/Settings.png")));
		label.setBounds(28, 23, 66, 62);
		panel.add(label);
		
		titulo = new JLabel("Buscar Datos Habitación");
		titulo.setBounds(160, -10, 200, 100);
		panel.add(titulo);
		
		combolblMsj=new JLabel();
		combolblMsj.setText("Seleccione Habitacion: ");
		//combolblMsj.setBounds(29, 100, 180, 20);
		
		combo1 = new JComboBox<String>();
		combo1.setBounds(170, 90, 148, 20);
		String arrayHabitaciones[]=new String[]{"Habitacion 1","Habitacion 2","Habitacion 3","Garaje","Comedor","Cuarto de Estar","Cocina","Baño"};
		combo1.setModel(new DefaultComboBoxModel<>(arrayHabitaciones));
		panel.add(combo1);
		panel.add(combolblMsj);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtNombre.setText("Nuevo nombre para la Habitación");
		txtNombre.setToolTipText("");
		txtNombre.setBounds(160, 140, 180, 20);
		txtNombre.setForeground(Color.DARK_GRAY);
		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtNombre.getText().equals("Nuevo nombre para la Habitación")) {
					txtNombre.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtNombre.getText().equals("")) {
					txtNombre.setText("Nuevo nombre para la Habitación");
				}
			}
		});
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(335, 228, 89, 23);
		panel.add(btnGuardar);
		
			
		txtTipo = new JTextField();
		txtTipo.setToolTipText("");
		txtTipo.setText("Nuevo tipo para la habitación");
		txtTipo.setForeground(Color.DARK_GRAY);
		txtTipo.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtTipo.setColumns(10);
		txtTipo.setBounds(160, 190, 180, 20);
		txtTipo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtTipo.getText().equals("Nuevo tipo para la habitación")) {
					txtTipo.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTipo.getText().equals("")) {
					txtTipo.setText("Nuevo tipo para la habitación");
				}
			}
		});
		panel.add(txtTipo);
	}
	
	public void actionPerformed(ActionEvent e) {
		  if (e.getSource()==combo1) {
			  txtNombre.setText(combo1.getSelectedIndex()+" - "+combo1.getSelectedItem());
		  }
		 }
		

	@Override
	public void Update(ResponseContext r) {
		// TODO Auto-generated method stub
		
	}
}
*/