import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ModificarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNuevoUsername;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarUsuario frame = new ModificarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ModificarUsuario() {
		super();
		this.setFocusable(true);
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
		label.setIcon(new ImageIcon(ModificarUsuario.class.getResource("/img/user.png")));
		label.setBounds(28, 23, 66, 62);
		panel.add(label);
		
		txtNuevoUsername = new JTextField();
		txtNuevoUsername.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtNuevoUsername.setText("Nuevo Username");
		txtNuevoUsername.setToolTipText("");
		txtNuevoUsername.setBounds(141, 65, 138, 20);
		txtNuevoUsername.setForeground(Color.DARK_GRAY);
		txtNuevoUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtNuevoUsername.getText().equals("Nuevo Username")) {
					txtNuevoUsername.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtNuevoUsername.getText().equals("")) {
					txtNuevoUsername.setText("Nuevo Username");
				}
			}
		});
		panel.add(txtNuevoUsername);
		txtNuevoUsername.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(335, 228, 89, 23);
		panel.add(btnGuardar);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setText("Contraseña actual");
		textField.setForeground(Color.DARK_GRAY);
		textField.setFont(new Font("Tahoma", Font.ITALIC, 11));
		textField.setColumns(10);
		textField.setBounds(141, 96, 138, 20);
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (textField.getText().equals("Contraseña actual")) {
					textField.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField.getText().equals("")) {
					textField.setText("Contraseña actual");
				}
			}
		});
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setText("Nueva contraseña");
		textField_1.setForeground(Color.DARK_GRAY);
		textField_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		textField_1.setColumns(10);
		textField_1.setBounds(141, 131, 138, 20);
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (textField_1.getText().equals("Nueva contraseña")) {
					textField_1.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField_1.getText().equals("")) {
					textField_1.setText("Nueva contraseña");
				}
			}
		});
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("");
		textField_2.setText("Repetir contraseña");
		textField_2.setForeground(Color.DARK_GRAY);
		textField_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		textField_2.setColumns(10);
		textField_2.setBounds(141, 162, 138, 20);
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (textField_2.getText().equals("Repetir contraseña")) {
					textField_2.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField_2.getText().equals("")) {
					textField_2.setText("Repetir contraseña");
				}
			}
		});
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(141, 34, 0, 0);
		panel.add(textField_3);
		textField_3.setColumns(10);
	}
}
