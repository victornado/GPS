package Prototipo;

public abstract class TemperaturaInterior implements GUI{

	private static TemperaturaInteriorImp instance;

	public static TemperaturaInteriorImp getInstance() {
		if(instance == null) instance = new TemperaturaInteriorImp();
		return instance;
	}
}
