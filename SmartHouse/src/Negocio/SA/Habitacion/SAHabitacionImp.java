package Negocio.SA.Habitacion;

import Integracion.FactoryDAO;
import Integracion.Habitacion.DAOHabitacion;
import Integracion.Transacciones.TransactionManager;
import Integracion.Transacciones.TransactionSmartHouse;
import Negocio.Factoria.FactoriaNeg;

public class SAHabitacionImp implements SAHabitacion{

	@Override
	public THabitacion mostrarIluminacionHabitacion(THabitacion t) {
		
		THabitacion nuevo = null;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		if(trans != null)
		{
			if(t != null)
			{
				DAOHabitacion dao = FactoryDAO.getInstance().createDAOHabitacion();
				nuevo = dao.mostrarIluminacionHabitacin(t);
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
