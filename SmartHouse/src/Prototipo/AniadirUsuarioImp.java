package Prototipo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Controller.Command.Eventos;
import Negocio.SA.Usuario.TUsuario;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class AniadirUsuarioImp extends AniadirUsuario{

	private JPanel contentPane;
	private JTextField txtNuevoUsername;
	private JTextField txtApellidos;
	private JTextField txtcorreo;
	private JTextField txtedad;
	private JTextField txtidcasa;
	private JTextField textField;
	private JTextField textField_3;
	private JButton usuarios;
	private tiposUsuarios tip;
	private String[] tipos;
	private String resp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AniadirUsuarioImp frame = new AniadirUsuarioImp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AniadirUsuarioImp() {
		super();
		this.setFocusable(true);
		tip = new tiposUsuarios();
		tipos = tip.gettipos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}
	
	/**
	 * Create the frame.
	 */
	public void initGUI() {
		
		setBounds(100, 100, 450, 300);
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
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ModificarUsuarioImp.class.getResource("/img/user.png")));
		label.setBounds(28, 23, 66, 62);
		panel.add(label);
		
		txtNuevoUsername = new JTextField();
		txtNuevoUsername.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtNuevoUsername.setText("Username");
		txtNuevoUsername.setToolTipText("");
		txtNuevoUsername.setBounds(141, 65, 138, 20);
		txtNuevoUsername.setForeground(Color.DARK_GRAY);
		txtNuevoUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtNuevoUsername.getText().equals("Username")) {
					txtNuevoUsername.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtNuevoUsername.getText().equals("")) {
					txtNuevoUsername.setText("Username");
				}
			}
		});
		panel.add(txtNuevoUsername);
		txtNuevoUsername.setColumns(10);
		
		
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setText("contraseña");
		textField.setForeground(Color.DARK_GRAY);
		textField.setFont(new Font("Tahoma", Font.ITALIC, 11));
		textField.setColumns(10);
		textField.setBounds(141, 96, 138, 20);
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (textField.getText().equals("contraseña")) {
					textField.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField.getText().equals("")) {
					textField.setText("contraseña");
				}
			}
		});
		panel.add(textField);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtApellidos.setText("Apellidos");
		txtApellidos.setToolTipText("");
		txtApellidos.setBounds(141, 125, 138, 20);
		txtApellidos.setForeground(Color.DARK_GRAY);
		txtApellidos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtApellidos.getText().equals("Apellidos")) {
					txtApellidos.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtApellidos.getText().equals("")) {
					txtApellidos.setText("Apellidos");
				}
			}
		});
		panel.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		
		txtcorreo = new JTextField();
		txtcorreo.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtcorreo.setText("Correo");
		txtcorreo.setToolTipText("");
		txtcorreo.setBounds(141, 150, 138, 20);
		txtcorreo.setForeground(Color.DARK_GRAY);
		txtcorreo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtcorreo.getText().equals("Correo")) {
					txtcorreo.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtcorreo.getText().equals("")) {
					txtcorreo.setText("Correo");
				}
			}
		});
		panel.add(txtcorreo);
		txtcorreo.setColumns(10);
		
		txtedad = new JTextField();
		txtedad.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtedad.setText("Edad");
		txtedad.setToolTipText("");
		txtedad.setBounds(141, 175, 138, 20);
		txtedad.setForeground(Color.DARK_GRAY);
		txtedad.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtedad.getText().equals("Edad")) {
					txtedad.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtedad.getText().equals("")) {
					txtedad.setText("Edad");
				}
			}
		});
		panel.add(txtedad);
		txtedad.setColumns(10);
		
		txtidcasa = new JTextField();
		txtidcasa.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtidcasa.setText("IdCasa");
		txtidcasa.setToolTipText("");
		txtidcasa.setBounds(141, 200, 138, 20);
		txtidcasa.setForeground(Color.DARK_GRAY);
		txtidcasa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtidcasa.getText().equals("IdCasa")) {
					txtidcasa.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtidcasa.getText().equals("")) {
					txtidcasa.setText("IdCasa");
				}
			}
		});
		panel.add(txtidcasa);
		txtidcasa.setColumns(10);
		
		usuarios = new JButton("Tipo de usuario");
		usuarios.setBounds(141, 230, 140, 23);
		
		usuarios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					
					 resp = (String) JOptionPane.showInputDialog(contentPane, "Seleciona el tipo de usuario", "Selector", JOptionPane.DEFAULT_OPTION, null,tipos, tipos[0]);

				}
				});

		panel.add(usuarios);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(335, 228, 89, 23);
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
				String pass = textField.getText();
				String hash = MD5Cypher.md5Java(pass); 
				int edadparse = Integer.parseInt(txtedad.getText());
				int IdCasaparse = Integer.parseInt(txtidcasa.getText());
				TUsuario tusuario = new TUsuario(txtNuevoUsername.getText(),hash,resp,txtApellidos.getText(),edadparse,txtcorreo.getText(),IdCasaparse);
				RequestContext rContext = new RequestContext(Eventos.Aniadir_USUARIO, tusuario);
				Controller.getInstance().handleRequest(rContext);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Error en la sintaxis ");

				}
			}
		});
		panel.add(btnGuardar);
		
		textField_3 = new JTextField();
		textField_3.setBounds(141, 34, 0, 0);
		panel.add(textField_3);
		textField_3.setColumns(10);
	}

	@Override
	public void Update(ResponseContext r) {

			if (r.getVista()== Eventos.Aniadir_USUARIO_OK) {
				
				JOptionPane.showMessageDialog(null, "Usuario añadido");
			}
			else {
				JOptionPane.showMessageDialog(null, "Error al añadir usuario ");

			}
	}
}
