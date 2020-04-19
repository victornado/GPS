
package Prototipo;

public abstract class IluminacionInterior  implements GUI{

	private static IluminacionInteriorImp instance;

	public static IluminacionInterior getInstance() {
		if(instance == null) instance = new IluminacionInteriorImp();
		return instance;
	}
}
