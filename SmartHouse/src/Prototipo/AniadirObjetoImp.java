package Prototipo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Controller.Command.Eventos;
import Negocio.SA.Habitacion.TComponentesEnHabitacion;
import Negocio.SA.Habitacion.THabitacion;
import Negocio.SA.Usuario.TUsuario;

public class AniadirObjetoImp extends AniadirObjeto {

    private JPanel contentPane;
    private JTextField txtTipo;
    private JTextField txtNombre;
    private JTextField textField;
    private JTextField textField_3;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AniadirHabitacionImp frame = new AniadirHabitacionImp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AniadirObjetoImp() {
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
        label.setIcon(new ImageIcon(ModificarUsuarioImp.class.getResource("/img/cama2.png")));
        label.setBounds(28, 23, 66, 62);
        panel.add(label);

        txtTipo = new JTextField();
        txtTipo.setFont(new Font("Tahoma", Font.ITALIC, 11));
        txtTipo.setText("IDComponente entre 1 y 10");
        txtTipo.setToolTipText("");
        txtTipo.setBounds(141, 65, 138, 20);
        txtTipo.setForeground(Color.DARK_GRAY);
        txtTipo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                if (txtTipo.getText().equals("IDComponente entre 1 y 10")) {
                    txtTipo.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTipo.getText().equals("")) {
                    txtTipo.setText("IDComponente entre 1 y 10");

                }
            }
        });
        panel.add(txtTipo);
        txtTipo.setColumns(10);



        textField = new JTextField();
        textField.setToolTipText("");
        textField.setText("IDHabitacion");
        textField.setForeground(Color.DARK_GRAY);
        textField.setFont(new Font("Tahoma", Font.ITALIC, 11));
        textField.setColumns(10);
        textField.setBounds(141, 96, 138, 20);
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                if (textField.getText().equals("IDHabitacion")) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().equals("")) {
                    textField.setText("IDHabitacion");
                }
            }
        });
        panel.add(textField);

        txtNombre = new JTextField();
        txtNombre.setFont(new Font("Tahoma", Font.ITALIC, 11));
        txtNombre.setText("Nombre");
        txtNombre.setToolTipText("");
        txtNombre.setBounds(141, 125, 138, 20);
        txtNombre.setForeground(Color.DARK_GRAY);
        txtNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                if (txtNombre.getText().equals("Nombre")) {
                    txtNombre.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtNombre.getText().equals("")) {
                    txtNombre.setText("Nombre");
                }
            }
        });
        panel.add(txtNombre);
        txtNombre.setColumns(10);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(335, 228, 89, 23);

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    int IdCasaparse = Integer.parseInt(textField.getText());
                    TComponentesEnHabitacion thab = new TComponentesEnHabitacion(Integer.parseInt(txtTipo.getText()),IdCasaparse,txtNombre.getText(),0);
                    RequestContext rContext = new RequestContext(Eventos.ANIADIR_OBJETO, thab);
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

        if (r.getVista()== Eventos.ANIADIR_OBJETO_OK) {

            JOptionPane.showMessageDialog(null, "Objeto a�adido");
            RequestContext rContext = new RequestContext(Eventos.LISTAR_HABITACIONES, null);
            Controller.getInstance().handleRequest(rContext);

        }
        else {
            JOptionPane.showMessageDialog(null, "Error al A�adir Objeto", "Error",
                    JOptionPane.ERROR_MESSAGE);


        }

    }
}
