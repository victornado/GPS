package Negocio.SA.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

import Integracion.FactoryDAO;
import Integracion.Casa.DAOCasa;
import Integracion.Transacciones.TransactionManager;
import Integracion.Transacciones.TransactionSmartHouse;
import Integracion.Usuario.DAOUsuario;
import Negocio.SA.Casa.TCasa;

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
						DAOCasa daoc = FactoryDAO.getInstance().createDAOCasa();
						TCasa casa = daoc.mostrarcasa(tUsuario.getIDCasa());
						if(casa != null)id= daoU.darDeAlta(tUsuario);
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

	@Override
	public int eliminarUsuario(int idUsuario) {
		int id = -1;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		try {
			trans.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(trans!=null){
			DAOUsuario daoU  = FactoryDAO.getInstance().createDAOUsuario();
			id = daoU.eliminarUsuario(idUsuario);
			if(id != -1)
				trans.commit();
			else
				trans.rollback();
			trans.commit();
		}
		else 
			trans.rollback();
		return id;
	}

	@Override
	public TUsuario modificarUsuario(TUsuario tUsuario) {
		TUsuario existe = null;
		TUsuario tUsuarioModificado = null;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		try {
			trans.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(trans!=null){
			if(tUsuario != null) {
			DAOUsuario daoU  = FactoryDAO.getInstance().createDAOUsuario();
			tUsuarioModificado = daoU.modificarUsuario(tUsuario);
			if(tUsuarioModificado != null)
				trans.commit();
			else
				trans.rollback(); 
		}
		else 
			trans.rollback();
		}
		return tUsuarioModificado;
	}

	@Override
	public ArrayList<TUsuario> ListarUsuarios() {
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		ArrayList<TUsuario> arrayUsuarios = new ArrayList<TUsuario>();
		try {
			trans.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(trans!=null){
			DAOUsuario daoU  = FactoryDAO.getInstance().createDAOUsuario();
			arrayUsuarios = daoU.ListarUsuarios();
			trans.commit();
		}
		return arrayUsuarios;
	}
}
