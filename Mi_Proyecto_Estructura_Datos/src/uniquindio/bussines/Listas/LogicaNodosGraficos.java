package uniquindio.bussines.Listas;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import uniquindio.VO.NodoGrafico;
import uniquindio.VO.ParejaNodos;
import uniquindio.bussines.Constantes;
import uniquindio.listas.listaEnlazada.ListaEnlazada;

/**
 * 
 * @author Gustavo Andres Ramirez Munoz--Ivan Santigo Castaneda
 *
 */
public class LogicaNodosGraficos {

	private final int REC = 5;

	/**
	 * Acomoda los notos que se encuentren encima de otros y los corre hacia un
	 * lado
	 * 
	 * @param lista
	 */
	public void verificarNodosInterceptados(ListaEnlazada<NodoGrafico> lista) {

		for (int i = 0; i < lista.size(); i++) {
			for (int j = 0; j < lista.size(); j++) {

				if (i != j && lista.get(i).getColision().intersects(lista.get(j).getColision())) {
					Point nuevo = new Point(lista.get(j).getPunto().x + Constantes.RADIO_NODO * 2,
							+lista.get(j).getPunto().y);
					lista.get(j).setPunto(nuevo);
				}
				verificarUbicacionNodo(lista.get(i));
			}
		}
	}

	/**
	 * Verifica que el nodo no se vaya dibujar fuera del rango admitido en
	 * pantalla
	 * 
	 * @param nodo
	 */
	public void verificarUbicacionNodo(NodoGrafico nodo) {

		if (nodo.getColision().x + nodo.getColision().width > Constantes.ANCHO_ZONA_DIUJABLE + REC) {
			nodo.setPunto(
					new Point(Constantes.ANCHO_ZONA_DIUJABLE - nodo.getColision().width + REC, nodo.getPunto().y));
		}
		if (nodo.getColision().x < 10) {
			nodo.setPunto(new Point(nodo.getColision().width / 4 + REC, nodo.getPunto().y));
		}
		if (nodo.getColision().y < 10) {
			nodo.setPunto(new Point(nodo.getPunto().x, nodo.getColision().height / 4 + REC));
		}
		if (nodo.getColision().y + nodo.getColision().height + REC > Constantes.ALTO_ZONA_DIUJABLE) {
			nodo.setPunto(
					new Point(nodo.getPunto().x, Constantes.ALTO_ZONA_DIUJABLE + REC - nodo.getColision().height));
		}

	}

	/**
	 * Cambia el color de un nodo seleccionado
	 * 
	 * @param p
	 * @param lista
	 */
	public NodoGrafico verificarInterceptoMouse(Point p, ListaEnlazada<NodoGrafico> lista) {

		Rectangle mouse = new Rectangle(p.x, p.y, REC, REC);

		for (int i = 0; i < lista.size(); i++) {
			if (mouse.intersects(lista.get(i).getColision())) {
				lista.get(i).setSeleccionado(true);
				return lista.get(i);
			}
		}
		return null;
	}

	/**
	 * Identifica que par de nodos han sido seleccionado para hacer un enlace
	 * 
	 * @param lista
	 */
	public boolean identificarEnlaces(ListaEnlazada<NodoGrafico> lista, ArrayList<NodoGrafico> nodos,
			ArrayList<ParejaNodos> parejaNodos, int opcionLista) {

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) == nodos.get(0)) {

				for (int j = 0; j < lista.size(); j++) {
					if (lista.get(j) == nodos.get(1)) {

						verificarEnlaces(lista.get(i), lista.get(j), parejaNodos, opcionLista);

						lista.get(i).setSeleccionado(false);
						lista.get(j).setSeleccionado(false);
						return true;

					}
				}
			}
		}
		return false;

	}

	/**
	 * Verifica si se puede hacer el enlance entre un par de nodos, de ser los
	 * agrega a una lista se secuencia de nodos.
	 * 
	 * @param nodoSalida
	 *            nodo de salida
	 * @param nodoLlegada
	 *            nodo de llegada
	 */
	public void verificarEnlaces(NodoGrafico nodoSalida, NodoGrafico nodoLlegada, ArrayList<ParejaNodos> parejaNodos,
			int opcionLista) {

		if (opcionLista == 1 || opcionLista == 3) {
			verificarEnlazadaCircular(nodoSalida, nodoLlegada, parejaNodos, opcionLista);
		} else {
			verificarDoblemente(nodoSalida, nodoLlegada, parejaNodos);
		}

	}

	/**
	 * Verifica que los enlances cumplan para lista enlazada doblemente enlazada
	 * 
	 * @param nodoSalida
	 * @param nodoLlegada
	 * @param parejaNodos
	 */
	public void verificarDoblemente(NodoGrafico nodoSalida, NodoGrafico nodoLlegada,
			ArrayList<ParejaNodos> parejaNodos) {

		if (nodoLlegada == nodoSalida) {
			return;
		}
		if (parejaNodos.isEmpty()) {
			parejaNodos.add(new ParejaNodos(nodoSalida, nodoLlegada));
			parejaNodos.add(new ParejaNodos(nodoLlegada, nodoSalida));
			return;
		} else {
			for (int i = 0; i < parejaNodos.size(); i++) {
				if (nodoLlegada.getIndice() == parejaNodos.get(i).getNodo1().getIndice()
						|| nodoLlegada.getIndice() == parejaNodos.get(i).getNodo2().getIndice()) {
					return;
				}

			}
			if (nodoSalida.getIndice() == parejaNodos.get(parejaNodos.size() - 1).getNodo1().getIndice()) {
				parejaNodos.add(new ParejaNodos(nodoSalida, nodoLlegada));
				parejaNodos.add(new ParejaNodos(nodoLlegada, nodoSalida));
				return;
			}
			for (int i = 0; i < parejaNodos.size(); i++) {
				if (parejaNodos.get(i).getNodo1().getIndice() == nodoSalida.getIndice()
						&& parejaNodos.get(i + 1).getNodo1().getIndice() != nodoLlegada.getIndice()) {

					parejaNodos.add(i + 2, new ParejaNodos(parejaNodos.get(i + 1).getNodo1(), nodoLlegada));
					parejaNodos.add(i + 2, new ParejaNodos(nodoLlegada, parejaNodos.get(i + 1).getNodo1()));
					
					parejaNodos.get(i).setNodo2(nodoLlegada);
					parejaNodos.get(i + 1).setNodo1(nodoLlegada);
					parejaNodos.get(i + 1).setNodo2(parejaNodos.get(i).getNodo1());

					return;
				}
				i++;
			}

		}

	}

	/**
	 * Verifica que los enlances cumplan para lista enlazada
	 * 
	 * @param nodoSalida
	 * @param nodoLlegada
	 * @param parejaNodos
	 */
	public void verificarEnlazadaCircular(NodoGrafico nodoSalida, NodoGrafico nodoLlegada,
			ArrayList<ParejaNodos> parejaNodos, int opcionLista) {

		if (parejaNodos.isEmpty()) {
			parejaNodos.add(new ParejaNodos(nodoSalida, nodoLlegada));
			return;
		}
		// Permite hacer en ultimo enlance para completar la condicion de lista
		// circular
		if (opcionLista == 3) {
			if (nodoSalida.getIndice() == parejaNodos.get(parejaNodos.size() - 1).getNodo2().getIndice()
					&& nodoLlegada.getIndice() == parejaNodos.get(0).getNodo1().getIndice()) {
				parejaNodos.add(new ParejaNodos(nodoSalida, nodoLlegada));
			}
		}

		// verifica que un nodos no tenga un enlace de regreso al nodo anterior
		for (int i = 0; i < parejaNodos.size(); i++) {
			if (nodoLlegada == parejaNodos.get(i).getNodo1() || nodoLlegada == parejaNodos.get(i).getNodo2()) {
				return;
			}
		}

		// permite cambiar en enlace de un nodo con enlace a un nodo nuevo y sin
		// ningun enlance
		for (int i = 0; i < parejaNodos.size(); i++) {

			if (parejaNodos.get(i).getNodo1().getIndice() == nodoSalida.getIndice()) {
				parejaNodos.add(i, new ParejaNodos(nodoSalida, nodoLlegada));
				parejaNodos.get(i + 1).setNodo1(nodoLlegada);
				return;
			}

		}
		// verifica que el nodo desde el que se crea un nuevo enlance sea el
		// ultimo nodo enlazado
		if (nodoSalida.getIndice() == parejaNodos.get(parejaNodos.size() - 1).getNodo2().getIndice()
				&& nodoLlegada.getIndice() != parejaNodos.get(0).getNodo1().getIndice()) {

			parejaNodos.add(new ParejaNodos(nodoSalida, nodoLlegada));
			return;
		}

	}

}
