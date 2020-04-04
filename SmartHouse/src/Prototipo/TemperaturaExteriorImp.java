package Prototipo;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class TemperaturaExteriorImp extends TemperaturaExterior{
	

	private String msg;
	private Calendar calendario;
	private int hora;
	private int minutos;
	private int dia;
	private int mes;
	private int anio;
	private JPanel contentPane;
	private String temp;
	private String hum;
	private String pres;

	public TemperaturaExteriorImp() {
	    msg = "";
	    /*calendario = Calendar.getInstance();
	    hora =calendario.get(Calendar.HOUR_OF_DAY);
	    minutos = calendario.get(Calendar.MINUTE);
	    dia = calendario.get(Calendar.DAY_OF_MONTH);
	    mes = calendario.get(Calendar.MONTH)+1;
	    anio = calendario.get(Calendar.YEAR);*/
	    temp = hum = pres = "";
	    
	    getWeather();
	}
	

	public String getWeather() {
		
		String APPID = "509018354b7693fbf75ac5e2972c7788";
		String url = "http://api.openweathermap.org/data/2.5/weather?q=Madrid,es&APPID=" + APPID
				+ "&lang=sp&units=metric";

		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse resp = null;

		try {
			resp = client.execute(get);
			HttpEntity entity = resp.getEntity();

			String json = EntityUtils.toString(entity);
			JSONObject obj = new JSONObject(json);
			temp = obj.getJSONObject("main").get("temp").toString();
			hum = obj.getJSONObject("main").get("humidity").toString();
			pres = obj.getJSONObject("main").get("pressure").toString();
			
			
			msg = "Temperatura: " + temp + "°C" + "    " + "Humedad: " + hum + "%" 
			+ "   " + "Presión: " + pres + "hPa" +"        " +  "[Madrid   " + hora + ":" + minutos + "   " + dia +"/" + mes + "/" + anio + "]";

			
		} catch (IOException ioe) {
			System.err.println("Something went wrong getting the weather: ");
			ioe.printStackTrace();
		} catch (Exception e) {
			System.err.println("Unknown error: ");
			e.printStackTrace();
		}
		// get APPID o 24	
		return msg;
	}
	

	
	public void mostrarTemperatura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 237, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextArea txt = new JTextArea();
		calendario = Calendar.getInstance();
	    hora =calendario.get(Calendar.HOUR_OF_DAY);
	    minutos = calendario.get(Calendar.MINUTE);
	    dia = calendario.get(Calendar.DAY_OF_MONTH);
	    mes = calendario.get(Calendar.MONTH)+1;
	    anio = calendario.get(Calendar.YEAR);
		/*
		txt.setText("Temperatura: " + getTemp() + "°C" + "\n" + "Humedad: " + getHum() + "%" 
				+ "\n" + "Presión: " + getPres()  + "hPa" +"\n" +  "[Madrid   " + hora + ":" + minutos + "   " + dia +"/" + mes + "/" + anio + "]");
		*/
		txt.setText("Temperatura: 14.91°C"+"\n" +"Humedad: 54%"+"\n"+   "Presión: 1016hPa"+"\n"+"[Madrid   "+hora+":"+minutos+"   "+dia+"/"+mes+"/"+anio+"]");
		txt.setEditable(false);
		txt.setBounds(0, 0, 211, 251);
	
		panel.add(txt);
	}
	
	
	private String getTemp() {
		return temp;
	}
	
	private String getHum() {
		return hum;
	}
	
	private String getPres() {
		return pres;
	}


	@Override
	public void Update(ResponseContext r) {
		// TODO Auto-generated method stub
		
	}
}