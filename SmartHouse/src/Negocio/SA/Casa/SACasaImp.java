package Negocio.SA.Casa;

import Integracion.FactoryDAO;
import Integracion.Casa.DAOCasa;
import Integracion.Transacciones.TransactionManager;
import Integracion.Transacciones.TransactionSmartHouse;

public class SACasaImp implements SACasa{

	@Override
	public Double MostrarDatosTemperatura(TComponentesGenerales casa) {
		Double temperatura = null;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		try {
			trans.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(trans != null)
		{
			DAOCasa daoC  = FactoryDAO.getInstance().createDAOCasa();
			temperatura = daoC.mostrarTemperatura(casa);
			if(temperatura != null)
				trans.commit();
			else
				trans.rollback();
		}
		return temperatura;
	}

	@Override
	public Double MostrarDatosHumedad(TComponentesGenerales casa) {
		Double humedad = null;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		try {
			trans.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(trans != null)
		{
			DAOCasa daoC  = FactoryDAO.getInstance().createDAOCasa();
			humedad = daoC.mostrarHumedad(casa);
			if(humedad != null)
				trans.commit();
			else
				trans.rollback();
		}
		return humedad;
	}

	@Override
	public Double MostrarDatosIluminacion(TComponentesGenerales casa) {
		Double iluminacion = null;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		try {
			trans.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(trans != null)
		{
			DAOCasa daoC  = FactoryDAO.getInstance().createDAOCasa();
			iluminacion = daoC.mostrarIluminacion(casa);
			if(iluminacion != null)
				trans.commit();
			else
				trans.rollback();
		}
		return iluminacion;
	}

	@Override
	public int modificarTemperaturaCasa(TComponentesGenerales componente) {
		int nuevo = -1;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		
		if(trans != null && componente.getIDComponente() != -1) // -1 si es null
		{
			try 
			{
				trans.init();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			DAOCasa dao = FactoryDAO.getInstance().createDAOCasa();
			nuevo = dao.modificarTemperatura(componente);
			if(nuevo != -1)
				trans.commit();
			else
				trans.rollback();
		}
		
		return nuevo;
	}
	


	@Override
	public int modificarHumedadCasa(TComponentesGenerales componente) {
		int nuevo = -1;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		
		if(trans != null && componente.getIDComponente() != -1) // -1 si es null
		{
			try 
			{
				trans.init();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			DAOCasa dao = FactoryDAO.getInstance().createDAOCasa();
			nuevo = dao.modificarHumedad(componente);
			if(nuevo != -1)
				trans.commit();
			else
				trans.rollback();
		}
		
		return nuevo;
	}
	



	@Override

	
	public int modificarIluminacionCasa(TComponentesGenerales componente) {
		int nuevo = -1;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		
		if(trans != null && componente.getIDComponente() != -1) // -1 si es null
		{
			try 
			{
				trans.init();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			DAOCasa dao = FactoryDAO.getInstance().createDAOCasa();
			nuevo = dao.modificarIluminacion(componente);
			if(nuevo != -1)
				trans.commit();
			else
				trans.rollback();
		}
		
		return nuevo;
	}
	

}


