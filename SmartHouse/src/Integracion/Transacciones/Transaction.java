package Integracion.Transacciones;

public interface Transaction {
	
	void init() throws Exception;
	
	void commit();
	
	void rollback();
	
	Object getResource();
}
