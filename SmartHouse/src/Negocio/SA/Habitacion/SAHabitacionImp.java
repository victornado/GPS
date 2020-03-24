package Negocio.SA.Habitacion;

import Integracion.FactoryDAO;
import Integracion.Habitacion.DAOHabitacion;
import Integracion.Transacciones.TransactionManager;
import Integracion.Transacciones.TransactionSmartHouse;
import Negocio.Factoria.FactoriaNeg;

public class SAHabitacionImp implements SAHabitacion{

	@Override
	public THabitacion mostrarIluminacionHabitacion(THabitacion t, TComponentesEnHabitacion componente) {
		
		THabitacion nuevo = null;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		
		if(trans != null)
		{
			try
			{
				trans.init();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(t != null)
			{
				DAOHabitacion dao = FactoryDAO.getInstance().createDAOHabitacion();
				nuevo = dao.mostrarIluminacionHabitacion(t,componente);
				if(nuevo != null)
					trans.commit();
				else
					trans.rollback();
			}
		
		}
		return nuevo;
	}
	/*
	  TODO
	  
	@Override
	public THabitacion modificarIluminacionHabitacion(THabitacion t, TComponenete componente) {
		THabitacion nuevo = null;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		
		if(trans != null && componente.getID() != null)
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
			nuevo = dao.modificarIluminacionHabitacion(t);
			if(nuevo != null)
				trans.commit();
			else
				trans.rollback();
		}
		
		return nuevo;
	}
	
	
	*/
}
