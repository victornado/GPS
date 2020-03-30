package Negocio.SA.ChromeCast;

import java.io.IOException;

public class SAChromeCastImp implements SAChromeCast {

	@Override
	public boolean activarChromeCast() {
		
		boolean activado = true;
		String command = "python python/ChromecastScript.py";
		try {
			Process p = Runtime.getRuntime().exec(command);
			if(p.exitValue()!=0)activado = false;
		} catch (Exception e) {	
			activado = false;
		}
		
		return activado;
	}
	
	
	@Override
	public boolean modificarVolumenChromeCast(int dato) {
		
		boolean activado = true;
		String command = "python python/SubirVolumen.py";
		try {
			Process p = Runtime.getRuntime().exec(command+dato);
			if(p.exitValue()!=0)activado = false;
		} catch (Exception e) {
			
			activado = false;
		}
		
		return activado;
	}

}
