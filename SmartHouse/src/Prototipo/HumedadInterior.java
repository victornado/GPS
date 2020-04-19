package Prototipo;

public abstract class HumedadInterior implements GUI{

	private static HumedadInteriorImp instance;

	public static HumedadInterior getInstance() {
		if(instance == null) instance = new HumedadInteriorImp();
		return instance;
	}
}
