package Negocio.SA.Casa;

import Integracion.FactoryDAO;
import Integracion.Casa.DAOCasa;
import Integracion.Transacciones.TransactionManager;
import Integracion.Transacciones.TransactionSmartHouse;

public class SACasaImp implements SACasa{

	@Override
	public Double MostrarDatosTemperatura(TCasa casa) {
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
	public Double MostrarDatosHumedad(TCasa casa) {
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
	public Double MostrarDatosIluminacion(TCasa casa) {
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
	
	

}


