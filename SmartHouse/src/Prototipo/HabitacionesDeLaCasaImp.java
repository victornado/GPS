package Prototipo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Controller.Command.Eventos;
import Negocio.SA.Habitacion.TComponentesEnHabitacion;
import Negocio.SA.Habitacion.THabitacion;

public class HabitacionesDeLaCasaImp extends HabitacionesDeLaCasa {

	private AniadirDispositivoImp addDisp;
	private BorrarDispositivoImp borrarDisp;
	private boolean ChromeCastActivo;
	private boolean actv;
	public static JTabbedPane tabbedPane;
	public static JPanel panel_1;
	public List<THabitacion> listaHab;
	public List<TComponentesEnHabitacion> lista;
	public List<GUI> listaClases;
	public static JTabbedPane tabbedPane_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setBounds(100, 100, 870, 547);
					JPanel j = new JPanel();
					HabitacionesDeLaCasaImp h = new HabitacionesDeLaCasaImp();
					h.inicializarHabitaciones();
					j.add(tabbedPane);
					frame.add(j);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HabitacionesDeLaCasaImp() {

		super();
		/*
		 * this.addDisp = new AniadirDispositivoImp(); this.borrarDisp = new
		 * BorrarDispositivoImp(); ChromeCastActivo=false; tabbedPane = null; actv =
		 * false;
		 */
		listaClases = new ArrayList<GUI>();
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(330, 29, 500, 453);
		tabbedPane.setBackground(Color.PINK);
		panel_1 = new JPanel();
		// panel_1.setLayout(new);
		initGUI();
	}

	public void initGUI() {

	}

	public void inicializarHabitaciones() {

		Controller.getInstance().handleRequest(new RequestContext(Eventos.MOSTRAR_HABITACIONES, 1));
	}

	@Override
	public void Update(ResponseContext r) {

		if (r.getVista() == Eventos.MODIFICAR_ILUMINACION_HABITACION_KO)
			JOptionPane.showMessageDialog(null, "Fallo");
		else if (r.getVista() == Eventos.MODIFICAR_ILUMINACION_HABITACION_OK) {
			JOptionPane.showMessageDialog(null, "Iluminacion cambiada");
		} 
		if (r.getVista() == Eventos.MODIFICAR_HUMEDAD_OBJETO_KO)
			JOptionPane.showMessageDialog(null, "Fallo");
		else if (r.getVista() == Eventos.MODIFICAR_HUMEDAD_OBJETO_OK) {
			JOptionPane.showMessageDialog(null, "Humedad cambiada");
		}
		if (r.getVista() == Eventos.MODIFICAR_TEMPERATURA_OBJETO_KO)
			JOptionPane.showMessageDialog(null, "Fallo");
		else if (r.getVista() == Eventos.MODIFICAR_TEMPERATURA_OBJETO_OK) {
			JOptionPane.showMessageDialog(null, "Temperatura cambiada");
		}
		else if (r.getVista() == Eventos.ACTIVAR_CHROMCAST_OK) {

			for (int i = 0; i < listaClases.size(); i++) {

				// THabitacion h = (THabitacion) r.getData();
				ArrayList<Integer> li = (ArrayList<Integer>) r.getData();
				DatosHabitacionImp h2 = (DatosHabitacionImp) listaClases.get(i);
				System.out.println(li.get(1));
				if (h2.IdHab == li.get(1)) {
					h2.Update(r);
				}
			}

		} else if (r.getVista() == Eventos.ACTIVAR_CHROMCAST_KO) {

			JOptionPane.showMessageDialog(null, "Algo salio mal al encender el ChromeCast", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else if (r.getVista() == Eventos.MODIFICA_VOLUMEN_CHROMCAST_OK) {

			JOptionPane.showMessageDialog(null, "Se ha cambiado el volument correctamente a " + r.getData());
		} else if (r.getVista() == Eventos.MODIFICA_VOLUMEN_CHROMCAST_KO) {

			JOptionPane.showMessageDialog(null, "El volumen no ha sido modificado", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (r.getVista() == Eventos.MOSTRAR_DATOS_HABITACION_OK) {

			for (int i = 0; i < listaClases.size(); i++) {

				THabitacion h = (THabitacion) r.getData();
				DatosHabitacionImp h2 = (DatosHabitacionImp) listaClases.get(i);

				if (h2.IdHab == h.getID()) {
					h2.Update(r);
				}

			}

		} else if (r.getVista() == Eventos.MOSTRAR_DATOS_HABITACION_KO) {

			for (int i = 0; i < listaClases.size(); i++) {

				THabitacion h = (THabitacion) r.getData();
				DatosHabitacionImp h2 = (DatosHabitacionImp) listaClases.get(i);

				if (h2.IdHab == h.getID()) {
					h2.Update(r);
				}
			}
		} else if (r.getVista() == Eventos.MOSTRAR_HABITACIONES_OK) {

			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(330, 29, 500, 453);
			tabbedPane.setBackground(Color.WHITE);

			listaHab = (List<THabitacion>) r.getData();
			listaClases = new ArrayList<GUI>();

			for (int i = 0; i < listaHab.size(); i++) {

				THabitacion habitacion = (THabitacion) listaHab.get(i);
				DatosHabitacionImp h = new DatosHabitacionImp();
				listaClases.add(h);
				h.inicializarHabitaciones(habitacion.getID());
				tabbedPane.addTab(habitacion.getNombre() + " : " + habitacion.getTipo(), h.panel_1);
			}

		} else if (r.getVista() == Eventos.MOSTRAR_HABITACIONES_KO) {

			tabbedPane.addTab("NINGUNA", null, panel_1, null);
			panel_1.setLayout(null);

			JLabel lblNewLabel = new JLabel("No existen habitaciones");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
			lblNewLabel.setBounds(150, 110, 220, 140);
			panel_1.add(lblNewLabel);
		}
		else if(r.getVista() == Eventos.MOSTRAR_ILUMINACION_OBJETO_KO ||r.getVista() == Eventos.MOSTRAR_HUMEDAD_OBJETO_KO || r.getVista() == Eventos.MOSTRAR_TEMPERATURA_OBJETO_KO) {
			JOptionPane.showMessageDialog(null, "Algo salio mal al mostrar los datos del objeto", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		else if(r.getVista() == Eventos.LISTAR_HABITACIONES_OK) {
			ListarHabitaciones.getInstance().Update(r);
		}
		else if(r.getVista() == Eventos.LISTAR_HABITACIONES_KO) {
			
		}
		else if(r.getVista() == Eventos.LISTAR_COMPONENTES_HABITACION_OK) {
			ListarComponentesHabitacion.getInstance().Update(r);
		}
		else if(r.getVista() == Eventos.LISTAR_COMPONENTES_HABITACION_KO) {
			JOptionPane.showMessageDialog(null, "No existen componentes en la habitación", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		else if(r.getVista() == Eventos.LISTAR_HABITACIONES_POR_TIPO_OK) {
			ListarHabitaciones.getInstance().Update(r);
		}
		else if(r.getVista() == Eventos.LISTAR_HABITACIONES_POR_TIPO_KO) {
			JOptionPane.showMessageDialog(null, "No existe ese tipo", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		else if(r.getVista() == Eventos.MOSTRAR_ILUMINACION_OBJETO_OK ||r.getVista() == Eventos.MOSTRAR_HUMEDAD_OBJETO_OK || r.getVista() == Eventos.MOSTRAR_TEMPERATURA_OBJETO_OK)
		{
			//la respuesta en el conexto viene de forma Pair<int,pair<int,int>> en orden, dato,habitacion,objeto
			Pair<Integer, Pair<Integer, Integer>> data = (Pair<Integer, Pair<Integer, Integer>>) r.getData();
			int ilum = data.getFirst();
			int obj = data.getSecond().getFirst();
			int habit = data.getSecond().getSecond();
			//busco la habiatacion(GUI) que devo actualizar
			for(int i=0;i<this.listaClases.size();i++)
			{
				// THabitacion h = (THabitacion) r.getData();
				DatosHabitacionImp h = (DatosHabitacionImp) listaClases.get(i);

				if (h.IdHab == habit) {
					h.Update(r);
				}
			}
		}
		else if(r.getVista()== Eventos.ANIADIR_HABITACION_OK) {
				AniadirHabitacion.getInstance().Update(r);
		}
		else if(r.getVista()==Eventos.ANIADIR_HABITACION_KO) {
			AniadirHabitacion.getInstance().Update(r);

		}
		else if(r.getVista()== Eventos.ELIMINAR_HABITACION_OK) {
			JOptionPane.showMessageDialog(null, "Habitacion eliminada");
			RequestContext rContext = new RequestContext(Eventos.LISTAR_HABITACIONES, null);
			Controller.getInstance().handleRequest(rContext);
		}
		else if(r.getVista() == Eventos.ELIMINAR_HABITACION_KO) {
			JOptionPane.showMessageDialog(null, "Error al eliminar", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		else if(r.getVista() == Eventos.MODIFICAR_FAVORITO_HABITACION_OK) {
			
		}
		else if (r.getVista() == Eventos.MODIFICAR_FAVORITO_HABITACION_KO) {
			JOptionPane.showMessageDialog(null, "Error al marcar como favorito", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
