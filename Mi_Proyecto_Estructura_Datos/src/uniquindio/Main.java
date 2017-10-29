package uniquindio;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import uniquindio.GUI.Ventana;

public class Main {
	public static ExecutorService service;

	public static void main(String[] args) {
		service = Executors.newFixedThreadPool(2);
		service.execute(new Ventana());
		// service.execute(new ScreenSplash());
	}

}
