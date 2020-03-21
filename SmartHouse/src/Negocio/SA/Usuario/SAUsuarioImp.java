package Negocio.SA.Usuario;

import Integracion.FactoryDAO;
import Integracion.Transacciones.TransactionManager;
import Integracion.Transacciones.TransactionSmartHouse;
import Integracion.Usuario.DAOUsuario;

public class SAUsuarioImp implements SAUsuario{

	public TUsuario loguearUsuario(TUsuario t) {
		
		TUsuario nuevo = null;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		try {
			trans.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(trans != null)
		{
			if(t != null)
			{
				DAOUsuario daoU  = FactoryDAO.getInstance().createDAOUsuario();
				nuevo = daoU.buscarUsuario(t);
				if(nuevo != null)
					trans.commit();
				else
					trans.rollback();
			}
			else
				trans.rollback();
		}
		return nuevo;
	}
	
	

}
