package Prototipo;

public abstract class TemperaturaInterior implements GUI{

	private static TemperaturaInteriorImp instance;

	public static TemperaturaInterior getInstance() {
		if(instance == null) instance = new TemperaturaInteriorImp();
		return instance;
	}
}
