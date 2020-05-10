package Prototipo;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import Controller.Command.Eventos;
import Negocio.SA.Usuario.TUsuario;

public class ListarUsuarioImp extends ListarUsuario{
	JTable table = null;
	JFrame frame = null;
	DefaultTableModel model = null;	
	
	public ListarUsuarioImp() {
		super();
		this.setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}
	
	public void initGUI() {
		frame = new JFrame("SMART HOUSE - USUARIOS");
		ImageIcon icon = new ImageIcon(SHMenuImp.class.getResource("/img/user.png"));
		Image image = icon.getImage();
		frame.setSize(600,900);
		frame.setIconImage(image);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(SystemColor.LIGHT_GRAY);
		String[] names = {"Id", "Id Casa", "correo", "tipo", "contraseña", "edad", "nombre", "apellidos"};
		table = new JTable();
		model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JScrollPane tableContainer = new JScrollPane(table);
		model.setColumnIdentifiers(names);
		JPanel buttons_actions = new JPanel();
		buttons_actions.setLayout(new BoxLayout(buttons_actions, BoxLayout.X_AXIS));
		
		//boton modificar
		JButton modify_button = new JButton();
		modify_button.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/editUser.png")));
		modify_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!table.getSelectionModel().isSelectionEmpty()) {
					JPanel panel = new JPanel();

					JTextField IDCasa = new JTextField();
					JTextField correo = new JTextField();
					JTextField tipo = new JTextField();
					JTextField contrasena = new JTextField();
					JTextField edad = new JTextField();
					JTextField nombre = new JTextField();
					JTextField apellidos = new JTextField();
					
					panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

					panel.add(new JLabel("Antiguo valor: " + table.getValueAt(table.getSelectedRow(), 1), 0));
					panel.add(new JLabel("ID de la casa: "));
					IDCasa.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 1)));
					panel.add(IDCasa);

					panel.add(new JLabel("Antiguo valor: " + table.getValueAt(table.getSelectedRow(), 2), 0));
					panel.add(new JLabel("Correo del usuario: "));
					correo.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 2)));
					panel.add(correo);

					panel.add(new JLabel("Antiguo valor: " + table.getValueAt(table.getSelectedRow(), 3), 0));
					panel.add(new JLabel("Tipo de usuario: "));
					tipo.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 3)));
					panel.add(tipo);
					
					panel.add(new JLabel("Antiguo valor: " + table.getValueAt(table.getSelectedRow(), 4), 0));
					panel.add(new JLabel("Contraseña de usuario: "));
					contrasena.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 4)));
					panel.add(contrasena);
					
					panel.add(new JLabel("Antiguo valor: " + table.getValueAt(table.getSelectedRow(), 5), 0));
					panel.add(new JLabel("Edad de usuario: "));
					edad.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 5)));
					panel.add(edad);
					
					panel.add(new JLabel("Antiguo valor: " + table.getValueAt(table.getSelectedRow(), 6), 0));
					panel.add(new JLabel("Nombre de usuario: "));
					nombre.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 6)));
					panel.add(nombre);
					
					panel.add(new JLabel("Antiguo valor: " + table.getValueAt(table.getSelectedRow(), 7), 0));
					panel.add(new JLabel("Apellidos de usuario: "));
					apellidos.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 7)));
					panel.add(apellidos);
					
					
					int id = (int) table.getValueAt(table.getSelectedRow(), 0);
					int result = JOptionPane.showConfirmDialog(null, panel, "Modificar Producto",
							JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.OK_OPTION) {
						String contr = contrasena.getText();
						
						if (contr.equals(""))
							JOptionPane.showMessageDialog(null, "La contraseña no puede estar en blanco",
									"Completar todos los campos", JOptionPane.WARNING_MESSAGE);
						else {
							TUsuario usuario = null;
							try {
								usuario = new TUsuario(nombre.getText(), contr, tipo.getText(), apellidos.getText(), Integer.parseInt(edad.getText()),correo.getText(), Integer.parseInt(IDCasa.getText()), id);
							} catch (NumberFormatException ex) {
								JOptionPane.showConfirmDialog(null, "Wrong Format");
								return;
							}
							RequestContext rContext = new RequestContext(Eventos.Modificar_USUARIO, usuario);
							Controller.getInstance().handleRequest(rContext);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debes seleccionar un elemento de la tabla",
							"Selecciona un elemento", JOptionPane.WARNING_MESSAGE);
				}
			}

		});
		
		//boton eliminar
		JButton delete_button = new JButton();
		delete_button.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/papelera.png")));
		delete_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!table.getSelectionModel().isSelectionEmpty()) {
					Object n = table.getValueAt(table.getSelectedRow(), 0);
					String id = n.toString();
					
					int result2 = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar " + id + "?",
							"Confirmación para borrar", JOptionPane.WARNING_MESSAGE);
					if (result2 == JOptionPane.OK_OPTION) {
						
						RequestContext rContext = new RequestContext(Eventos.Eliminar_USUARIO, Integer.parseInt(id));
						Controller.getInstance().handleRequest(rContext);
					}
			} else {
				JOptionPane.showMessageDialog(null, "Debes seleccionar un elemento de la tabla",
						"Selecciona un elemento", JOptionPane.WARNING_MESSAGE);
			}

			}
		});
		buttons_actions.add(delete_button);
		buttons_actions.add(modify_button);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(model);	
		panel.add(tableContainer);
		panel.add(buttons_actions);
        frame.getContentPane().add(panel);
		frame.setSize(450, 300);
	}
	@Override
	public void Update(ResponseContext r) {
		model.setRowCount(0);
		ArrayList<TUsuario> array = (ArrayList<TUsuario>) r.getData();
		for(TUsuario tu: array){
			model.addRow(new Object[]{tu.getID(),tu.getIDCasa(), tu.getCorreo(), tu.getTipo(),tu.getContrasena(),tu.getEdad(),tu.getNombre(),tu.getApellidos()});
		}
		frame.setVisible(true);
	}

}
