package Negocio.SA.Habitacion;

import Integracion.FactoryDAO;
import Integracion.Habitacion.DAOHabitacion;
import Integracion.Transacciones.TransactionManager;
import Integracion.Transacciones.TransactionSmartHouse;
import Negocio.Factoria.FactoriaNeg;

public class SAHabitacionImp implements SAHabitacion{

	@Override
	public TComponentesEnHabitacion mostrarIluminacionHabitacion( TComponentesEnHabitacion componente) {
		
		TComponentesEnHabitacion nuevo = null;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		
		if(trans != null)
		{
			try
			{
				trans.init();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(componente != null)
			{
				DAOHabitacion dao = FactoryDAO.getInstance().createDAOHabitacion();
				nuevo = dao.mostrarIluminacionHabitacion(componente);
				if(nuevo != null)
					trans.commit();
				else
					trans.rollback();
			}
		
		}
		return nuevo;
	}
	
	  
	  
	@Override
	public TComponentesEnHabitacion modificarIluminacionHabitacion(TComponentesEnHabitacion componente) {
		TComponentesEnHabitacion nuevo = null;
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
			
			DAOHabitacion dao = FactoryDAO.getInstance().createDAOHabitacion();
			nuevo = dao.modificarIluminacionHabitacion(componente);
			if(nuevo != null)
				trans.commit();
			else
				trans.rollback();
		}
		
		return nuevo;
	}
	
	
	
}
