package Negocio.SA.Usuario;

import java.util.ArrayList;

public interface SAUsuario {
	
	public TUsuario loguearUsuario(TUsuario tUsuario);
	
	public int aniadirUsuario(TUsuario tUsuario);
	
	public int eliminarUsuario(int tUsuario);
	
	public TUsuario modificarUsuario(TUsuario tUsuario);
	
	public ArrayList<TUsuario> ListarUsuarios();

}
