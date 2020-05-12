package Negocio.SA.Casa;

public interface SACasa {

	public abstract Double MostrarDatosTemperatura(TComponentesGenerales casa);

	public abstract Double MostrarDatosHumedad(TComponentesGenerales casa);

	public abstract Double MostrarDatosIluminacion(TComponentesGenerales casa);
	
	public abstract int modificarTemperaturaCasa(TComponentesGenerales componente);
	
	public abstract int modificarHumedadCasa(TComponentesGenerales componente);
	
	public abstract int modificarIluminacionCasa(TComponentesGenerales componente);

}
