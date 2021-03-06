package Negocio.SA.Habitacion;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Integracion.FactoryDAO;
import Integracion.Casa.DAOCasa;
import Integracion.Habitacion.DAOHabitacion;
import Integracion.Transacciones.TransactionManager;
import Integracion.Transacciones.TransactionSmartHouse;
import Integracion.Usuario.DAOUsuario;
import Negocio.SA.Casa.TCasa;
import Negocio.SA.Usuario.TUsuario;

public class SAHabitacionImp implements SAHabitacion {

	@Override
	public TComponentesEnHabitacion mostrarIluminacionHabitacion(TComponentesEnHabitacion componente) {

		TComponentesEnHabitacion nuevo = null;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();

		if (trans != null) {
			try {
				trans.init();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (componente != null) {
				DAOHabitacion dao = FactoryDAO.getInstance().createDAOHabitacion();
				nuevo = dao.mostrarIluminacionHabitacion(componente);
				if (nuevo != null)
					trans.commit();
				else
					trans.rollback();
			}

		}
		return nuevo;
	}

	@Override
	public int modificarIluminacionHabitacion(TComponentesEnHabitacion componente) {
		int nuevo = -1;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();

		if (trans != null && componente.getIDComponente() != -1) // -1 si es null
		{
			try {
				trans.init();
			} catch (Exception e) {
				e.printStackTrace();
			}

			DAOHabitacion dao = FactoryDAO.getInstance().createDAOHabitacion();
			nuevo = dao.modificarIluminacionHabitacion(componente);
			if (nuevo != -1)
				trans.commit();
			else
				trans.rollback();
		}

		return nuevo;
	}

	@Override
	public String mostrarTipoHabitacion(THabitacion habitacion) {
		String tipo = null;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();

		if (trans != null && habitacion.getID() != -1) // -1 si es null
		{
			try {
				trans.init();
			} catch (Exception e) {
				e.printStackTrace();
			}

			DAOHabitacion dao = FactoryDAO.getInstance().createDAOHabitacion();
			tipo = dao.mostrarTipoHabitacion(habitacion.getID());
			if (tipo != null)
				trans.commit();
			else
				trans.rollback();
		}

		return tipo;
	}

	@Override
	public THabitacion mostrarHabitacion(int id) {
		THabitacion t = null;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		try {
			trans.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (trans != null) {
			t = FactoryDAO.getInstance().createDAOHabitacion().mostrarHabitacion(id);
			if (t != null) { // ha encontrado la habitacion
				List<TComponentesEnHabitacion> lista;
				lista = FactoryDAO.getInstance().createDAOHabitacion().getComponents(id);
				if (lista != null) {//por si acaso rompe al meter null
					t.setComponentes(lista);
				}
				trans.commit();
			} else {
				trans.rollback();
			}
		}
		return t;
	}

	public int mostrarHumedadObjeto(int idObjeto, int idHabitacion)
	{
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		try {
			trans.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(trans != null) {
			List<TComponentesEnHabitacion> lista;
			lista = FactoryDAO.getInstance().createDAOHabitacion().getComponents(idHabitacion);
			if(lista!= null && lista.size()>0) {
				TComponentesEnHabitacion objeto = null;
				for(TComponentesEnHabitacion aux : lista){
					if(aux.getIDComponente()==idObjeto)
						objeto= aux;
				}
				if(objeto != null){
						trans.commit();
						return  objeto.getDato();
				}
			}
			else
				trans.rollback();
		}
		return -1;
	}

	public int mostrarTemperaturaObjeto(int idObjeto, int idHabitacion)
	{
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		try {
			trans.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(trans != null) {
			List<TComponentesEnHabitacion> lista;
//			System.out.println(idHabitacion);
			lista = FactoryDAO.getInstance().createDAOHabitacion().getComponents(idHabitacion);
			if(lista!= null && lista.size()>0) {
				TComponentesEnHabitacion objeto = null;
				for(TComponentesEnHabitacion aux : lista){
					if(aux.getIDComponente()==idObjeto)
						objeto= aux;
				}
				if(objeto != null){
						trans.commit();
						return  objeto.getDato();
				}
			}
			else
				trans.rollback();
		}
		return -1;
	}
	public int mostrarIluminacionObjeto(int idObjeto, int idHabitacion)
	{
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		try {
			trans.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(trans != null) {
			List<TComponentesEnHabitacion> lista;
			lista = FactoryDAO.getInstance().createDAOHabitacion().getComponents(idHabitacion);
			if(lista!= null && lista.size()>0) {
				TComponentesEnHabitacion objeto = null;
				for(TComponentesEnHabitacion aux : lista){
					if(aux.getIDComponente()==idObjeto)
						objeto= aux;
				}
				if(objeto != null){
						trans.commit();
						return  objeto.getDato();
				}
			}
			else
				trans.rollback();
		}
		return -1;
	}

	@Override
	public ArrayList<THabitacion> ListarHabitaciones() {
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		ArrayList<THabitacion> arrayHabitaciones = new ArrayList<THabitacion>();
		try {
			trans.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(trans!=null){
			DAOHabitacion daoHab  = FactoryDAO.getInstance().createDAOHabitacion();
			arrayHabitaciones = daoHab.ListarHabitaciones();
			trans.commit();
		}
		return arrayHabitaciones;
	}
	
	@Override
	public List<TComponentesEnHabitacion> ListarComponentesHabitaciones(Integer idHabitacion) {
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		List<TComponentesEnHabitacion> arrayComponentesHabitacion = new ArrayList<TComponentesEnHabitacion>();
		try {
			trans.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(trans!=null){
			DAOHabitacion daoHab  = FactoryDAO.getInstance().createDAOHabitacion();
			arrayComponentesHabitacion = daoHab.getComponents(idHabitacion);
			trans.commit();
		}
		return arrayComponentesHabitacion;
	}

	@Override
	public THabitacion modificarHabitacion(THabitacion tHabitacion) {
		THabitacion existe = null;
		THabitacion tHabitacionModificada = null;
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		try {
			trans.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(trans!=null){
			if(tHabitacion != null) {
			DAOHabitacion daoH  = FactoryDAO.getInstance().createDAOHabitacion();
			tHabitacionModificada = daoH.modificarHabitacion(tHabitacion);
			if(tHabitacionModificada != null)
				trans.commit();
			else
				trans.rollback(); 
		}
		else 
			trans.rollback();
		}
		return tHabitacionModificada;
	}

	@Override
	public ArrayList<THabitacion> ListarHabitacionesPorTipo(String tipo) {
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		ArrayList<THabitacion> arrayHabitaciones = new ArrayList<THabitacion>();
		try {
			trans.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(trans!=null){
			DAOHabitacion daoHab  = FactoryDAO.getInstance().createDAOHabitacion();
			arrayHabitaciones = daoHab.ListarHabitacionesPorTipo(tipo);
			trans.commit();
		}
		return arrayHabitaciones;
	}

	@Override
	public int aniadirhab(THabitacion thab) {
		
		THabitacion existe=null;
		int id =-1;
		
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		try {
			trans.init();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(trans!=null)
		{
			if(thab != null) {
				DAOHabitacion daoh  = FactoryDAO.getInstance().createDAOHabitacion();
				existe = daoh.mostrarHabitacion(thab.getID());
				if(existe != null)
					trans.rollback();
				else
				{
					DAOCasa daoc = FactoryDAO.getInstance().createDAOCasa();
					TCasa casa = daoc.mostrarcasa(thab.getIDCasa());
					if(casa != null)id= daoh.darDeAlta(thab);
					trans.commit();
				}
			}
			else 
				trans.rollback();
		}

		return id;
	}

	@Override
	public int eliminarhab(int id1) {
		int id =-1;
		THabitacion existe=null;

		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		try {
			trans.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
			DAOHabitacion daoh  = FactoryDAO.getInstance().createDAOHabitacion();
			id=daoh.eliminarhab(id1);
			if(id != -1)trans.commit();
			else
				trans.rollback();
			

		return id;
	}
	
	@Override
	public  int aniadirComponente(TComponentesEnHabitacion componente) {
		int id =-1;
		
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		try {
			trans.init();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(trans!=null)
		{
			if(componente != null) {
				DAOHabitacion daoh  = FactoryDAO.getInstance().createDAOHabitacion();
				if(daoh != null)id= daoh.aniadirComponente(componente);
				trans.commit();
			}
			else 
				trans.rollback();
		}
	
		return id;
	}
	
	@Override
	public int eliminarComponente(String nombre) {
		int id2 =-1;

		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		try {
			trans.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
			DAOHabitacion daoh  = FactoryDAO.getInstance().createDAOHabitacion();
			id2=daoh.eliminarComponente(nombre);
			if(id2 != -1)trans.commit();
			else
				trans.rollback();
			

		return 1;
	}
	
	

	@Override
	public ArrayList<TComponentesEnHabitacion> ListarObjetos() {
		TransactionSmartHouse trans = (TransactionSmartHouse) TransactionManager.getInstance().newTransaction();
		ArrayList<TComponentesEnHabitacion> arrayObjetos = new ArrayList<TComponentesEnHabitacion>();
		try {
			trans.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(trans!=null){
			DAOHabitacion daoHab  = FactoryDAO.getInstance().createDAOHabitacion();
			arrayObjetos = daoHab.ListarObjetos();
			trans.commit();
		}
		return arrayObjetos;
	}
	
}
