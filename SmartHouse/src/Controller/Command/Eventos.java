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
	public static final int Eliminar_USUARIO_OK = 106;
	public static final int Eliminar_USUARIO_KO = 107;
	public static final int Eliminar_USUARIO = 108;
	public static final int Modificar_USUARIO_OK = 109;
	public static final int Modificar_USUARIO_KO = 110;
	public static final int Modificar_USUARIO = 111;
	public static final int Listar_USUARIO = 112;
	public static final int Listar_USUARIO_OK = 113;
	public static final int Listar_USUARIO_KO = 114;

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
	public static final int LISTAR_HABITACIONES = 209;
	public static final int LISTAR_HABITACIONES_KO = 210;
	public static final int LISTAR_HABITACIONES_OK = 211;
	public static final int MODIFICAR_HABITACION= 212; 
	public static final int MODIFICAR_HABITACION_OK= 213;
	public static final int MODIFICAR_HABITACION_KO= 214;
	public static final int ELIMINAR_HABITACION= 215; 
	public static final int ELIMINAR_HABITACION_OK= 216;
	public static final int ELIMINAR_HABITACION_KO= 217;
	public static final int LISTAR_COMPONENTES_HABITACION = 218;
	public static final int LISTAR_COMPONENTES_HABITACION_KO = 219;
	public static final int LISTAR_COMPONENTES_HABITACION_OK = 220;


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
