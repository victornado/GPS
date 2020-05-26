package Prototipo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import Controller.Command.Eventos;
import Negocio.SA.Habitacion.THabitacion;
import Negocio.SA.Usuario.TUsuario;

public class ListarHabitacionesImp extends ListarHabitaciones {
	JTable table = null;
	JFrame frame = null;
	DefaultTableModel model = null;

	public ListarHabitacionesImp() {
		super();
		this.setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}

	public void initGUI() {
		frame = new JFrame("SMART HOUSE - HABITACIONES");
		// ImageIcon icon = new ImageIcon(SHMenuImp.class.getResource("/img/user.png"));
		// Image image = icon.getImage();
		frame.setSize(600, 900);
		// frame.setIconImage(image);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(SystemColor.LIGHT_GRAY);
		String[] names = { "Id", "Id Casa", "Tipo", "Nombre" };
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

		// boton modificar
		JButton modify_button = new JButton();
		modify_button.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/editUser.png")));
		modify_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!table.getSelectionModel().isSelectionEmpty()) {
					JPanel panel = new JPanel();

					JTextField IDCasa = new JTextField();
					JTextField nombre = new JTextField();
					JTextField tipo = new JTextField();

					panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

					panel.add(new JLabel("Antiguo valor: " + table.getValueAt(table.getSelectedRow(), 1), 0));
					panel.add(new JLabel("ID de la casa: "));
					IDCasa.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 1)));
					panel.add(IDCasa);

					panel.add(new JLabel("Antiguo valor: " + table.getValueAt(table.getSelectedRow(), 2), 0));
					panel.add(new JLabel("Tipo de la habitacion: "));
					nombre.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 2)));
					panel.add(nombre);

					panel.add(new JLabel("Antiguo valor: " + table.getValueAt(table.getSelectedRow(), 3), 0));
					panel.add(new JLabel("Nombre de habitacion: "));
					tipo.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 3)));
					panel.add(tipo);

					int id = (int) table.getValueAt(table.getSelectedRow(), 0);
					int result = JOptionPane.showConfirmDialog(null, panel, "Modificar Producto",
							JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.OK_OPTION) {
						
						
					
					if (nombre.equals("")) {
						JOptionPane.showMessageDialog(null, "El nombre no puede estar en blanco",
								"Completar todos los campos", JOptionPane.WARNING_MESSAGE);
					} else if (tipo.equals("")) {
						JOptionPane.showMessageDialog(null, "El tipo no puede estar en blanco",
								"Completar todos los campos", JOptionPane.WARNING_MESSAGE);
					} else {
						THabitacion habitacion = null;
						try {
							habitacion = new THabitacion(id, Integer.parseInt(IDCasa.getText()), nombre.getText(),
									tipo.getText());
						} catch (NumberFormatException ex) {
							JOptionPane.showConfirmDialog(null, "Wrong Format");
							return;
						}
						RequestContext rContext = new RequestContext(Eventos.MODIFICAR_HABITACION, habitacion);
						Controller.getInstance().handleRequest(rContext);
					}

				}
			} else {
				JOptionPane.showMessageDialog(null, "Debes seleccionar un elemento de la tabla",
						"Selecciona un elemento", JOptionPane.WARNING_MESSAGE);
			}
		}

	});

		// boton eliminar
		JButton delete_button = new JButton();
		delete_button.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/papelera.png")));
		delete_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!table.getSelectionModel().isSelectionEmpty()) {
					Object n = table.getValueAt(table.getSelectedRow(), 0);
					String id = n.toString();

					int result2 = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar " + id + "?",
							"Confirmacion para borrar", JOptionPane.WARNING_MESSAGE);
					if (result2 == JOptionPane.OK_OPTION) {

						RequestContext rContext = new RequestContext(Eventos.ELIMINAR_HABITACION, Integer.parseInt(id));
						Controller.getInstance().handleRequest(rContext);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debes seleccionar un elemento de la tabla",
							"Selecciona un elemento", JOptionPane.WARNING_MESSAGE);
				}

			}

		});
		// boton aniadir
		JButton add_button = new JButton();
		add_button.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/cama.png")));
		add_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AniadirHabitacionImp aniadirh = new AniadirHabitacionImp();
				aniadirh.setVisible(true);
			}

		});

		// boton buscar

		JButton buscaryHabitacionBtn = new JButton();
		// buscaryHabitacionBtn.setBounds(280, 35, 24, 21);
		buscaryHabitacionBtn.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/lupa.png")));
		buscaryHabitacionBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				if (!table.getSelectionModel().isSelectionEmpty()) {
					Object n = table.getValueAt(table.getSelectedRow(), 0);
					String idHab = n.toString();
					// ABRO EL PANEL CON LOS DATOS
					int idCasa = (int) table.getValueAt(table.getSelectedRow(), 1);
					String nombre = (String) table.getValueAt(table.getSelectedRow(), 3);
					String tipo = (String) table.getValueAt(table.getSelectedRow(), 2);
					BuscarHabitacionImp buscarHab;
					buscarHab = new BuscarHabitacionImp(idHab, idCasa, nombre, tipo);
					buscarHab.setVisible(true);

				} else {

					JOptionPane.showMessageDialog(null, "Debes seleccionar un elemento de la tabla",
							"Selecciona un elemento", JOptionPane.WARNING_MESSAGE);
				}

			}

		});

		// panel.add(buscaryHabitacionBtn);

		// boton listar componentes
		JButton comp_button = new JButton("Listar Comp");
		// delete_button.setIcon(new
		// ImageIcon(SHMenuImp.class.getResource("/img/papelera.png")));
		comp_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!table.getSelectionModel().isSelectionEmpty()) {
					Object n = table.getValueAt(table.getSelectedRow(), 0);
					int id = (int) n;

					RequestContext rContext = new RequestContext(Eventos.LISTAR_COMPONENTES_HABITACION, id);
					Controller.getInstance().handleRequest(rContext);

				} else {
					JOptionPane.showMessageDialog(null, "Debes seleccionar un elemento de la tabla",
							"Selecciona un elemento", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		// boton listar por tipo
		JButton tipo_button = new JButton("Listar por tipo");
		// delete_button.setIcon(new
		// ImageIcon(SHMenuImp.class.getResource("/img/papelera.png")));
		tipo_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String tipo = JOptionPane.showInputDialog("Introduca el tipo");

				RequestContext rContext = new RequestContext(Eventos.LISTAR_HABITACIONES_POR_TIPO, tipo);
				Controller.getInstance().handleRequest(rContext);

			}
		});

		buttons_actions.add(tipo_button);
		buttons_actions.add(delete_button);
		buttons_actions.add(add_button);
		buttons_actions.add(buscaryHabitacionBtn);
		buttons_actions.add(modify_button);
		buttons_actions.add(comp_button);
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
		ArrayList<THabitacion> array = (ArrayList<THabitacion>) r.getData();
		for (THabitacion th : array) {
			model.addRow(new Object[] { th.getID(), th.getIDCasa(), th.getTipo(), th.getNombre() });
		}
		if (model.getRowCount() == 0)
			JOptionPane.showMessageDialog(null, "No existe ninguna habitaci�n", "Error", JOptionPane.ERROR_MESSAGE);
		else
			frame.setVisible(true);
	}
}
