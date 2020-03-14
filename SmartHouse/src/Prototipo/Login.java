package Prototipo;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Controller.Command.Eventos;
import Negocio.SA.Usuario.TUsuario;

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

public class Login extends JFrame implements Observer {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	//private SHMenu menu;

	/**
	 * Launch the application.
	 */
	public Login() {
		super();
		this.contentPane = new JPanel();
		this.textField_1 = new JPasswordField();
		this.textField = new JTextField();
		//this.menu = new SHMenu();
		this.setFocusable(true);
		initGUI();
	}
	
	public void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
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
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setBounds(70, 185, 84, 14);
		panel.add(lblContrasea);
		
		JButton btnLogIn = new JButton("Login");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(datoCorrecto(textField.getText()) && datoCorrecto(textField_1.getText())) {
				TUsuario tUsuario= new TUsuario(textField.getText(),textField_1.getText());
				RequestContext rContext = new RequestContext(Eventos.LOGIN_USUARIO, tUsuario);
				Controller.getInstance().handleRequest(rContext);
				}
				else JOptionPane.showMessageDialog(null, "Datos incorrectos", "Incorrecto", JOptionPane.ERROR_MESSAGE);
				
				
				
				
				/*JOptionPane.showMessageDialog(null, "Bienvenido " + textField.getText());
				//menu.clearData();
				//menu.setVisible(true);*/
			}
		});
		btnLogIn.setBounds(174, 217, 84, 23);
		panel.add(btnLogIn);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/img/logo.png")));
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
	public void update(ResponseContext r) {
		
		if(r.getVista() == Eventos.LOGIN_USUARIO_OK)
			JOptionPane.showMessageDialog(null, "Login correcto", "Correcto", JOptionPane.INFORMATION_MESSAGE);
		
		else if(r.getVista() == Eventos.LOGIN_USUARIO_KO)
			JOptionPane.showMessageDialog(null, "Se ha producido un error", "Incorrecto", JOptionPane.ERROR_MESSAGE);
		
		
	}
	
	
}
