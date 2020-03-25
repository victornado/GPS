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
	
	

}


