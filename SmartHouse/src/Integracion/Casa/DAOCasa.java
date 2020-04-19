package Integracion.Casa;

import Negocio.SA.Casa.TComponentesGenerales;

public interface DAOCasa {	
	public abstract Double mostrarTemperatura(TComponentesGenerales casa);

	public abstract Double mostrarHumedad(TComponentesGenerales casa);

	public abstract Double mostrarIluminacion(TComponentesGenerales casa);

	public abstract int modificarTemperatura(TComponentesGenerales componente);
	
	public abstract int modificarHumedad(TComponentesGenerales componente);
	
	public abstract int modificarIluminacion(TComponentesGenerales componente);
}
