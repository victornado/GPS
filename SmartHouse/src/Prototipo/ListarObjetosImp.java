package Prototipo;

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

import Controller.Command.Eventos;
import Controller.Controller;
import Negocio.SA.Habitacion.TComponentesEnHabitacion;
import Negocio.SA.Habitacion.THabitacion;


public class ListarObjetosImp extends ListarObjetos {

	JTable table = null;
	JFrame frame = null;
	DefaultTableModel model = null;

	public ListarObjetosImp() {
		super();
		this.setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}

	public void initGUI() {
		frame = new JFrame("SMART HOUSE - OBJETOS");
		// ImageIcon icon = new ImageIcon(SHMenuImp.class.getResource("/img/user.png"));
		// Image image = icon.getImage();
		frame.setSize(300, 450);
		// frame.setIconImage(image);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(SystemColor.LIGHT_GRAY);
		String[] names = { "Id Componente", "Id Habitacion", "Nombre", "Dato" };
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

						RequestContext rContext = new RequestContext(Eventos.ELIMINAR_OBJETO, Integer.parseInt(id));
						Controller.getInstance().handleRequest(rContext);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debes seleccionar un elemento de la tabla",
							"Selecciona un elemento", JOptionPane.WARNING_MESSAGE);
				}

			}

		});
		//boton aniadir
		JButton add_button = new JButton();
		add_button.setIcon(new ImageIcon(SHMenuImp.class.getResource("/img/cama.png")));
		add_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AniadirObjetoImp aniadirOBJ = new AniadirObjetoImp();
				aniadirOBJ.setVisible(true);
			}

		});



		// boton buscar






		buttons_actions.add(delete_button);
		buttons_actions.add(add_button);
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
		ArrayList<TComponentesEnHabitacion> array = (ArrayList<TComponentesEnHabitacion>) r.getData();
		for (TComponentesEnHabitacion tch : array) {
			model.addRow(new Object[] { tch.getIDComponente(), tch.getIDhabitacion(),tch.getNombre(), tch.getDato()});
		}
		frame.setVisible(true);
	}

}
