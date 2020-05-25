package Prototipo;

import javax.swing.JFrame;

public abstract class AniadirObjeto extends JFrame implements GUI{

    private static AniadirObjetoImp instance;


    public static AniadirObjeto getInstance() {
        if(instance == null) instance = new AniadirObjetoImp();
        return instance;
    }

}
