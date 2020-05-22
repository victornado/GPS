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

import Negocio.SA.Habitacion.TComponentesEnHabitacion;


public class ListarComponentesHabitacionImp extends ListarComponentesHabitacion {

	JTable table = null;
	JFrame frame = null;
	DefaultTableModel model = null;

	public ListarComponentesHabitacionImp() {
		super();
		this.setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}

	public void initGUI() {
		frame = new JFrame("SMART HOUSE - HABITACIONES");
		// ImageIcon icon = new ImageIcon(SHMenuImp.class.getResource("/img/user.png"));
		// Image image = icon.getImage();
		frame.setSize(300, 450);
		// frame.setIconImage(image);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(SystemColor.LIGHT_GRAY);
		String[] names = { "Id", "Id Casa", "Nombre", "Dato" };
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
