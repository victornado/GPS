package Negocio.SA.Usuario;

import java.sql.SQLException;

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

	@Override
	public int aniadirUsuario(TUsuario tUsuario) {
		int id = -1;
		TUsuario existe = null;

		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		try {
			trans.init();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(trans!=null)
		{
			if(tUsuario != null) {
				DAOUsuario daoU  = FactoryDAO.getInstance().createDAOUsuario();
				existe = daoU.buscarUsuario(tUsuario);
				if(existe != null)
					trans.rollback();
				else
				{
					try {
						id = daoU.darDeAlta(tUsuario);
					} catch (SQLException e) {
						trans.rollback();
						e.printStackTrace();
					}
					trans.commit();
				}
			}
			else 
				trans.rollback();
		}

		return id;
	}
	
	

}
