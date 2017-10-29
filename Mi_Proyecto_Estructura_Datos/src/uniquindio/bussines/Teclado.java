package uniquindio.bussines;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import uniquindio.GUI.PanelBotones;
import uniquindio.GUI.Ventana;

public class Teclado implements KeyListener {

	private Ventana ventanaPrincipal;
	private PanelBotones panelBotones;
	private boolean pulsado = false;

	public Teclado(Ventana ventanaPrincipal, int opcionLista) {
		this.ventanaPrincipal = ventanaPrincipal;

	}

	public void keyTyped(KeyEvent e) {

	}

	/**
	 * Metodo vacio solo para porder detectar eventos del teclado
	 */
	public void actualizar(PanelBotones panelBotones) {

		this.panelBotones = panelBotones;
	}

	/**
	 * 
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {

			pulsado = true;
		}
	}

	/**
	 * 
	 */
	public void keyReleased(KeyEvent e) {

		if (pulsado && e.getKeyCode() == KeyEvent.VK_A) {

			panelBotones.setPanelActivo(true);
			ventanaPrincipal.setVentanaActiva(true);
			ventanaPrincipal.añadirNodo((int) (Math.random() * 999) + 1, panelBotones.getPanelLista().getOpcion());
			pulsado = false;
		}

		if (pulsado && e.getKeyCode() == KeyEvent.VK_R) {

			ventanaPrincipal.setVentanaActiva(true);
			ventanaPrincipal.eliminarNodo();
			pulsado = false;
		}
	
	}

	/**
	 * 
	 */

}
