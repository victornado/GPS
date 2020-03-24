package Main;

import java.io.IOException;

public class Prueba {

	public static void main(String[] args) throws IOException {
		String command = "python python/ChromecastScript.py";
		Process p = Runtime.getRuntime().exec(command);
	  }

}
