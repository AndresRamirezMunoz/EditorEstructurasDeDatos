package uniquindio.bussines;


import uniquindio.GUI.VentanaNuevoNodo;
import uniquindio.GUI.subPaneles.PanelListasEDC;

/**
 * 
 * @author Gustavo Andres Ramirez Munoz--Ivan Santigo Castaneda
 *
 */
public class CambioInformacion {

	/**
	 * Edita el panel que entra como parametro para ajustarlo a la estructura a
	 * manejar
	 * 
	 * @param panel
	 */
	public int cambiarPanelListaEnlazada(PanelListasEDC panel) {

		panel.getLabelTipo().setText("Lista enlazada");
		panel.getBoton1().setText("add");
		panel.getBoton2().setText("remove");
		panel.getBoton3().setText("contains");
		panel.getBoton4().setText("get");
		panel.getBoton5().setText("size");

		return 1;

		// new ListaEnlazada<>().

	}

	/**
	 * Edita el panel que entra como parametro para ajustarlo a la estructura a
	 * manejar
	 * 
	 * @param panel
	 */
	public int cambiarPanelListaDoblEnlazada(PanelListasEDC panel) {

		panel.getLabelTipo().setText("Lista doblemente");
		panel.getBoton1().setText("add");
		panel.getBoton2().setText("remove");
		panel.getBoton3().setText("contains");
		panel.getBoton4().setText("get");
		panel.getBoton5().setText("size");

		return 2;
		// new ListaEnlazada<>().

	}

	/**
	 * Edita el panel que entra como parametro para ajustarlo a la estructura a
	 * manejar
	 * 
	 * @param panel
	 */
	public int cambiarPanelListaCircular(PanelListasEDC panel) {

		panel.getLabelTipo().setText("Lista circular");
		panel.getBoton1().setText("add");
		panel.getBoton2().setText("remove");
		panel.getBoton3().setText("contains");
		panel.getBoton4().setText("get");
		panel.getBoton5().setText("size");

		return 3;
		// new ListaEnlazada<>().

	}

	/**
	 * Edita el panel que entra como parametro para ajustarlo a la estructura a
	 * manejar
	 * 
	 * @param panel
	 */
	public int cambiarPanePila(PanelListasEDC panel) {

		panel.getLabelTipo().setText("Lista circular");
		panel.getBoton1().setText("push");
		panel.getBoton2().setText("pop");
		panel.getBoton3().setText("containsAll");
		panel.getBoton4().setText("get");
		panel.getBoton5().setText("size");

		return 3;
		// new ListaEnlazada<>().

	}

	/**
	 * Cambia algunos datos de la VentanaNodo para adecuarla al la opcion add
	 * 
	 * @param ventana
	 */
	public void cambiarInfoVentanaNodoAdd(VentanaNuevoNodo ventana) {

		ventana.getLabelDato().setText("Ingrese el valor del nodo");

		ventana.getBotonAleatorio().setVisible(true);
	}

	/**
	 * Cambia algunos datos de la VentanaNodo para adecuarla al la opcion
	 * contains
	 * 
	 * @param ventana
	 */
	public void cambiarInfoVentanaNodoContains(VentanaNuevoNodo ventana) {

		ventana.getLabelDato().setText("Ingrese valor a buscar");
		ventana.getTextField().setBounds(80, 45, 120, 35);
		ventana.getBotonAleatorio().setVisible(false);
	}
}
