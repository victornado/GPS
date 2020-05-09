package Controller.Command;

public class Eventos {
	
	// HU USUARIO
	public static final int LOGIN_USUARIO =100;
	
	//HU MENSAJES OK Y KO USUARIO
	public static final int LOGIN_USUARIO_OK =101;
	public static final int LOGIN_USUARIO_KO =102;
	

	//Aniadir usuario
	public static final int Aniadir_USUARIO_OK = 103;
	public static final int Aniadir_USUARIO_KO = 104;
	public static final int Aniadir_USUARIO = 105;

	//HU habitacion 
	public static final int MOSTRAR_ILUMINACION_HABITACION= 200; 
	public static final int MOSTRAR_ILUMINACION_HABITACION_OK= 201; 
	public static final int MOSTRAR_ILUMINACION_HABITACION_KO= 202; 
	public static final int MODIFICAR_ILUMINACION_HABITACION= 203; 
	public static final int MODIFICAR_ILUMINACION_HABITACION_OK= 204;
	public static final int MODIFICAR_ILUMINACION_HABITACION_KO= 205; 
	public static final int MOSTRAR_DATOS_HABITACION= 206; 
	public static final int MOSTRAR_DATOS_HABITACION_OK= 207;
	public static final int MOSTRAR_DATOS_HABITACION_KO= 208;



	//HU CASA TEMP
	public static final int MOSTRAR_TEMPERATURA=300;
	public static final int MOSTRAR_TEMPERATURA_OK=301;
	public static final int MOSTRAR_TEMPERATURA_KO=302;
	public static final int MODIFICAR_TEMPERATURA= 303; 
	public static final int MODIFICAR_TEMPERATURA_OK= 304;
	public static final int MODIFICAR_TEMPERATURA_KO= 305; 
	
	//HU CASA HUM
	public static final int MOSTRAR_HUMEDAD=400;
	public static final int MOSTRAR_HUMEDAD_OK=401;
	public static final int MOSTRAR_HUMEDAD_KO=402;
	public static final int MODIFICAR_HUMEDAD= 403; 
	public static final int MODIFICAR_HUMEDAD_OK= 404;
	public static final int MODIFICAR_HUMEDAD_KO= 405; 
	
	//HU CASA HUM
	public static final int MOSTRAR_ILUMINACION = 500;
	public static final int MOSTRAR_ILUMINACION_OK = 501;
	public static final int MOSTRAR_ILUMINACION_KO = 502;
	public static final int MODIFICAR_ILUMINACION= 503; 
	public static final int MODIFICAR_ILUMINACION_OK= 504;
	public static final int MODIFICAR_ILUMINACION_KO= 505; 

	
	//Activa ChromeCast
		public static final int ACTIVAR_CHROMCAST= 600; 
		public static final int ACTIVAR_CHROMCAST_OK= 601; 
		public static final int ACTIVAR_CHROMCAST_KO= 602;
		
		//Modifica volumen ChromeCast
		public static final int MODIFICA_VOLUMEN_CHROMCAST= 700; 
		public static final int MODIFICA_VOLUMEN_CHROMCAST_OK= 701; 
		public static final int MODIFICA_VOLUMEN_CHROMCAST_KO= 702;
}
