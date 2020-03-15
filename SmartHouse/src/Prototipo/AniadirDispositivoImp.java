package Prototipo;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JList;
import java.awt.List;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AniadirDispositivoImp extends AniadirDispositivo{

	private JPanel contentPane;
	private JTextArea texto;
	private JTextField txtTipoDeDispositivo;
	private JTextField txtDireccinIp;
	private JTextField txtUsuario;
	private JTextField txtContrasea;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AniadirDispositivo frame = new AniadirDispositivo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public AniadirDispositivoImp() {
		setTitle("A\u00F1adir Dispositivo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		List list = new List();
		list.setMultipleSelections(false);
		list.setBounds(10, 31, 181, 210);
		list.add("L�mpara");
		list.add("Smart TV");
		list.add("Aspiradora");
		panel.add(list);
		
		txtTipoDeDispositivo = new JTextField();
		txtTipoDeDispositivo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTipoDeDispositivo.setFont(new Font("Arial", Font.BOLD, 12));
		txtTipoDeDispositivo.setText("Tipo de dispositivo");
		txtTipoDeDispositivo.setBounds(10, 11, 181, 20);
		panel.add(txtTipoDeDispositivo);
		txtTipoDeDispositivo.setColumns(10);
		
		Label label = new Label("CONEXI\u00D3N");
		label.setFont(new Font("Arial", Font.BOLD, 13));
		label.setBounds(219, 62, 167, 22);
		panel.add(label);
		
		txtDireccinIp = new JTextField();
		txtDireccinIp.setForeground(Color.DARK_GRAY);
		txtDireccinIp.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtDireccinIp.setText("Direccion IP");
		txtDireccinIp.setBounds(219, 104, 154, 20);
		txtDireccinIp.setForeground(Color.DARK_GRAY);
		txtDireccinIp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtDireccinIp.getText().equals("Direccion IP")) {
					txtDireccinIp.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtDireccinIp.getText().equals("")) {
					txtDireccinIp.setText("Direccion IP");
				}
			}
		});
		panel.add(txtDireccinIp);
		txtDireccinIp.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setForeground(Color.DARK_GRAY);
		txtUsuario.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtUsuario.setText("Usuario");
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(219, 135, 154, 20);
		txtUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtUsuario.getText().equals("Usuario")) {
					txtUsuario.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsuario.getText().equals("")) {
					txtUsuario.setText("Usuario");
				}
			}
		});
		panel.add(txtUsuario);
		
		txtContrasea = new JTextField();
		txtContrasea.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtContrasea.setForeground(Color.DARK_GRAY);
		txtContrasea.setText("Contrase�a");
		txtContrasea.setColumns(10);
		txtContrasea.setBounds(219, 167, 154, 20);
		txtContrasea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtContrasea.getText().equals("Contrase�a")) {
					txtContrasea.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtContrasea.getText().equals("")) {
					txtContrasea.setText("Contrase�a");
				}
			}
		});
		panel.add(txtContrasea);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//cerrar ventana
			}
		});
		btnGuardar.setBounds(313, 217, 89, 23);
		panel.add(btnGuardar);
		this.texto = new JTextArea(20, 50);
		this.texto.setEditable(false);
	}

	@Override
	public void Update(ResponseContext r) {
		// TODO Auto-generated method stub
		
	}
}

