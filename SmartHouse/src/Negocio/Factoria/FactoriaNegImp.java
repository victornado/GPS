package Negocio.Factoria;

import Negocio.SA.Casa.SACasa;
import Negocio.SA.Casa.SACasaImp;
import Negocio.SA.ChromeCast.SAChromeCast;
import Negocio.SA.ChromeCast.SAChromeCastImp;
import Negocio.SA.Habitacion.*;
import Negocio.SA.Usuario.*;

public class FactoriaNegImp extends FactoriaNeg{
	
	public SAUsuario createSAUsuario() {
		return new SAUsuarioImp();
	}

	@Override
	public SAHabitacion createSAHabitacion() {
		return new SAHabitacionImp();
	}

	@Override
	public SACasa createSACasa() {
		return new SACasaImp();
	}
	
	public SAChromeCast createSAChromeCast() {
		return new SAChromeCastImp();
	}


}
