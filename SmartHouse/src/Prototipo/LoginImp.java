package Prototipo;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Controller.Command.Eventos;
import Negocio.SA.Usuario.TUsuario;
import Prototipo.MD5Cypher;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginImp extends Login implements GUI {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblUsuario;
	private JLabel lblContrasea;


	/**
	 * Launch the application.
	 */
	public LoginImp() {
		super();
		this.contentPane = new JPanel();
		this.textField_1 = new JPasswordField();
		this.textField = new JTextField();
		this.setFocusable(true);
		this.setVisible(true);
		initGUI();
	}
	
	public void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.text);
		textField.setBounds(164, 151, 102, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setColumns(10);
		textField_1.setBounds(164, 182, 102, 20);
		panel.add(textField_1);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(87, 154, 67, 14);
		panel.add(lblUsuario);
		
		lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setBounds(70, 185, 84, 14);
		panel.add(lblContrasea);
		
		JButton btnLogIn = new JButton("Login");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(datoCorrecto(textField.getText()) && datoCorrecto(textField_1.getText())) {
					TUsuario tUsuario= new TUsuario(textField.getText(), MD5Cypher.md5Java(textField_1.getText()));
					RequestContext rContext = new RequestContext(Eventos.LOGIN_USUARIO, tUsuario);
					Controller.getInstance().handleRequest(rContext);
				}
				else JOptionPane.showMessageDialog(null, "Datos incorrectos", "Incorrecto", JOptionPane.ERROR_MESSAGE);
				
			}
		});
		btnLogIn.setBounds(174, 217, 84, 23);
		panel.add(btnLogIn);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginImp.class.getResource("/img/logo.png")));
		label.setBounds(135, 11, 200, 129);
		panel.add(label);
		
		
	}
	
	public void clearData() {
		textField.setText("");
		textField_1.setText("");

		textField.setEditable(false);
		textField_1.setEditable(false);

	}
	
	boolean datoCorrecto(String dato) {
		
		if(dato.length() == 0 || dato.length() > 30)return false;
		else return true;
		
	}

	@Override
	public void Update(ResponseContext r) {
		
		if(r.getVista() == Eventos.LOGIN_USUARIO_OK) {
			//JOptionPane.showMessageDialog(null, "Bienvenido " + ((TUsuario) r.getData()).getNombre());
			JOptionPane.showMessageDialog(null, "Bienvenido ");
			this.setVisible(false);
			SHMenu.getInstance().setVisible(true);
		}
		else if(r.getVista() == Eventos.LOGIN_USUARIO_KO)
			JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Incorrecto", JOptionPane.ERROR_MESSAGE);
		
	}
}
