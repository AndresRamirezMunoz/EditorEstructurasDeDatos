package uniquindio.bussines.Listas;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import uniquindio.GUI.PanelBotones;
import uniquindio.VO.NodoGrafico;
import uniquindio.VO.ParejaNodos;
import uniquindio.bussines.Constantes;
import uniquindio.bussines.SuperficieDibujo;
import uniquindio.listas.listaEnlazada.ListaEnlazada;

/**
 * 
 * @author Gustavo Andres Ramirez Munoz--Ivan Santigo Castaneda
 *
 */
public class logicaGraficaParaListas {

	private final int REC = 10;

	public static void dormir() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Manda los nodos de la arraylist para que se dibujen
	 * 
	 * @param lista
	 * @param dibujar
	 * @param g
	 */
	public void mandarDibujarListasNodosEncontrados(ArrayList<NodoGrafico> lista, Graphics2D dibujar, Graphics g) {

		for (int i = 0; i < lista.size(); i++) {
			SuperficieDibujo.dibujarNodoEncontrado(lista.get(i).getId(), lista.get(i).getPunto(),
					lista.get(i).getDIFERENCIA(), g);

		}
	}

	/**
	 * Manda los nodos de la arraylist para que se dibujen
	 * 
	 * @param lista
	 * @param dibujar
	 * @param g
	 */
	public void mandarDibujarListasNodos(ListaEnlazada<NodoGrafico> lista, Graphics2D dibujar, Graphics g) {

		dibujar.setStroke(new BasicStroke(3f));
		for (int i = 0; i < lista.size(); i++) {
			lista.get(i).dibujarNodos(g);

		}
	}

	/**
	 * Dibuja los enlaces para las parejas de nodos creadas
	 * 
	 * @param lista
	 * @param g
	 */
	public void mandarDibujarEnlancesParejas(ArrayList<ParejaNodos> lista, Graphics g, int opcion) {
		if (opcion == 1 || opcion == 3) {
			dibujarEnlancesEC(lista, g, opcion);
		}
		if (opcion == 2) {

			dibujarElancesD(lista, g);
		}
	}

	/**
	 * Dibuja los enlances, la secuencia de nodos y añade el indice al nodo
	 * enlazado
	 * 
	 * @param lista
	 * @param g
	 */
	private void dibujarElancesD(ArrayList<ParejaNodos> lista, Graphics g) {

		String cadena = "{ ";
		String c = "";

		for (int i = 0; i < lista.size(); i++) {

			if (i < lista.size() / 2) {
				cadena += c + diseñarSecuencia(i, i + 1) + diseñarSecuencia(i + 1, i);
				c = ", ";
			}

			calcularEnlaces(lista.get(i).getNodo2().getPuntoLineaInicial(),
					lista.get(i).getNodo1().getPuntoLineaInicial(),
					new Rectangle(lista.get(i).getNodo2().getColision()), lista.get(i).getNodo1());

			SuperficieDibujo.dibujarEnlaces(lista.get(i).getNodo1().isEnlace(),
					lista.get(i).getNodo1().getPuntoLineaInicial(), lista.get(i).getNodo1().getPuntoLineaFinal(), g);

		}

		int contador = 0;
		for (int i = 0; i < lista.size(); i++) {

			if (i % 2 == 0) {

				SuperficieDibujo.dibujarIndice(i - contador, lista.get(i).getNodo1().getPunto(), g);
			}
			contador++;
			i++;
		}
		if (!lista.isEmpty())
			SuperficieDibujo.dibujarIndice(contador, lista.get(lista.size() - 1).getNodo1().getPunto(), g);

		SuperficieDibujo.dibujarSecuenciaNodos(cadena + " } = " + lista.size(), 20, g);

	}

	/**
	 * Dibuja los enlances, la secuencia de nodos y añade el indice al nodo
	 * enlazado
	 * 
	 * @param lista
	 * @param g
	 * @param opcion
	 */
	private void dibujarEnlancesEC(ArrayList<ParejaNodos> lista, Graphics g, int opcion) {

		String cadena = "{ ";
		String c = "";

		for (int i = 0; i < lista.size(); i++) {

			if (opcion == 3) {
				SuperficieDibujo.dibujarIndice(i + 1, lista.get(i).getNodo2().getPunto(), g);

				if (lista.get(0).getNodo1().getIndice() == lista.get(i).getNodo2().getIndice()) {
					cadena += c + diseñarSecuencia(i, 0);
					c = ",";
				} else {
					cadena += c + diseñarSecuencia(i, i + 1);
					c = ",";
				}

			} else {

				SuperficieDibujo.dibujarIndice(i, lista.get(i).getNodo1().getPunto(), g);
				cadena += c + diseñarSecuencia(i, i + 1);
				c = ",";
			}

			calcularEnlaces(lista.get(i).getNodo2().getPuntoLineaInicial(),
					lista.get(i).getNodo1().getPuntoLineaInicial(),
					new Rectangle(lista.get(i).getNodo2().getColision()), lista.get(i).getNodo1());

			SuperficieDibujo.dibujarEnlaces(lista.get(i).getNodo1().isEnlace(),
					lista.get(i).getNodo1().getPuntoLineaInicial(), lista.get(i).getNodo1().getPuntoLineaFinal(), g);

		}
		if (!lista.isEmpty()) {
			SuperficieDibujo.dibujarIndice(0, lista.get(0).getNodo1().getPunto(), g);

			if (opcion == 1) {
				SuperficieDibujo.dibujarIndice(lista.size(), lista.get(lista.size() - 1).getNodo2().getPunto(), g);
			}
		}

		SuperficieDibujo.dibujarSecuenciaNodos(cadena + " } = " + lista.size(), 20, g);

	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String diseñarSecuencia(int a, int b) {

		return String.format("(%s, %s)", a, b);
	}

	/**
	 * Calcula un punto final para que el enlace se cree y la flecha del enlace
	 * se pueda ver
	 * 
	 * @param punto1
	 * @param punto2
	 * @param punto2Rec
	 * @param n1
	 */
	public void calcularEnlaces(Point punto1, Point punto2, Rectangle punto2Rec, NodoGrafico n1) {

		if (punto2.x < punto1.x && punto2.y < punto1.y) {

			n1.setPuntoLineaFinal(new Point(punto2Rec.x, punto2Rec.y));
			n1.setEnlace(true);
			// System.out.println("1");
			return;

		}
		if (punto2.x > punto1.x && punto2.y > punto1.y) {
			n1.setPuntoLineaFinal(new Point(punto2Rec.x + punto2Rec.width, punto2Rec.y + punto2Rec.height));
			n1.setEnlace(true);
			// System.out.println("2");
			return;
		}
		if (punto2.x < punto1.x && punto2.y > punto1.y) {
			n1.setPuntoLineaFinal(new Point(punto2Rec.x, punto2Rec.y + punto2Rec.height));
			n1.setEnlace(true);
			// System.out.println("3");
			return;
		}
		if (punto2.x > punto1.x) {
			n1.setPuntoLineaFinal(
					new Point(punto2Rec.x + Constantes.RADIO_NODO + 5, punto2Rec.y + punto2Rec.height / 2));
			n1.setEnlace(true);
			// System.out.println("4");
			return;
		}

		if (punto2.y < punto1.y) {
			n1.setPuntoLineaFinal(new Point(punto2Rec.x + punto2Rec.height / 2, punto2Rec.y - 5));
			n1.setEnlace(true);
			// System.out.println("5");
			return;

		}
		if (punto2.y > punto1.y) {
			n1.setPuntoLineaFinal(new Point(punto2Rec.x + punto2Rec.height / 2, punto2Rec.y + punto2Rec.width + 5));
			n1.setEnlace(true);
			// System.out.println("6");
			return;

		} else {

			n1.setPuntoLineaFinal(new Point(punto2Rec.x - 5, punto2Rec.y + Constantes.RADIO_NODO / 2));
			n1.setEnlace(true);
			// System.out.println("6");
			return;

		}
	}

	/////////////////////////////////////////////////////////////////////
	/**
	 * Al dar clic se deja el nodo en posicion X y Y,
	 * 
	 * @param ultimoNodo
	 * @param seleccionado
	 * @param lista
	 * @param nodosSeleccionados
	 * @param verificador
	 * @param panelBotones
	 * @param secuenciaNodos
	 * @param e
	 * @return retorna falso si se creo algun enlace, fasle si de lo contrario
	 */
	public boolean acomodarNodo(int ultimoNodo, boolean seleccionado, ListaEnlazada<NodoGrafico> lista,
			ArrayList<NodoGrafico> nodosSeleccionados, PanelBotones panelBotones, ArrayList<ParejaNodos> parejaNodos,
			MouseEvent e, int opcionLista)

	{
		if (ultimoNodo != -1 && !lista.isEmpty()) {
			lista.get(ultimoNodo)
					.setPunto(new Point(e.getX() - Constantes.RADIO_NODO / 2, e.getY() - Constantes.RADIO_NODO / 2));
			lista.get(ultimoNodo).setPuntoLineaInicial(new Point(e.getX(), e.getY()));

			ultimoNodo = -1;

		}
		return RevisarEnlace(ultimoNodo, seleccionado, lista, nodosSeleccionados, panelBotones, parejaNodos, e,
				opcionLista);
	}

	/**
	 * Despues de dar clic verifica si se dio clic sobre un nodo
	 * 
	 * @param ultimoNodo
	 * @param seleccionado
	 * @param lista
	 * @param nodosSeleccionados
	 * @param verificador
	 * @param panelBotones
	 * @param secuenciaNodos
	 * @param e
	 *            evento del mouse
	 * @return falso despues de crear el enlace, fasle si de lo contrario
	 */
	public boolean RevisarEnlace(int ultimoNodo, boolean seleccionado, ListaEnlazada<NodoGrafico> lista,
			ArrayList<NodoGrafico> nodosSeleccionados, PanelBotones panelBotones, ArrayList<ParejaNodos> parejaNodos,
			MouseEvent e, int opcionLista) {
		if (!seleccionado) {

			NodoGrafico n = new LogicaNodosGraficos().verificarInterceptoMouse(new Point(e.getX(), e.getY()), lista);
			if (n != null) {
				nodosSeleccionados.add(n);
			}

			if (nodosSeleccionados.size() >= 2) {

				new LogicaNodosGraficos().identificarEnlaces(lista, nodosSeleccionados, parejaNodos, opcionLista);
				nodosSeleccionados.clear();

			}
			if (panelBotones.isPanelActivo()) {

				ultimoNodo = lista.size() - 1;
			}
		} else {
			seleccionado = false;
		}
		return seleccionado;
	}

	/**
	 * Re dibuja el nuevo nodo que se halla creado mientras esta en el mouse,
	 * hasta que se clic
	 * 
	 * @param clic
	 * @param opcion
	 * @param lista
	 * @param e
	 */
	public void redibujarNodo(int clic, int opcion, ListaEnlazada<NodoGrafico> lista, MouseEvent e) {

		if (clic != -1) {

			lista.get(clic)
					.setPunto(new Point(e.getX() - Constantes.RADIO_NODO / 2, e.getY() - Constantes.RADIO_NODO / 2));
		}
	}

	/**
	 * Retorna el nodo que se intercepte con el mouse para cambiar su posicion
	 * en la pantall
	 * 
	 * @param opcion
	 * @param lista
	 * @param e
	 */
	public NodoGrafico rehubicarNodo(int opcion, ListaEnlazada<NodoGrafico> lista, Point p) {

		Rectangle mouse = new Rectangle(p.x, p.y, REC, REC);
		for (int i = 0; i < lista.size(); i++) {
			if (mouse.intersects(lista.get(i).getColision())) {
				return lista.get(i);
			}
		}
		return null;
	}

	/**
	 * Elimina el nodo que se encuentre seleccionado
	 * 
	 * @param lista
	 * @param nodoSeleccionado
	 */
	public void eliminarNodo(ListaEnlazada<NodoGrafico> lista, ArrayList<NodoGrafico> nodoSeleccionado,
			ArrayList<ParejaNodos> parejaNodos, int opcionLista) {
		System.out.println("Entro");

		for (int i = 0; i < lista.size(); i++) {
			lista.get(i).setIndice(i);
			if (!nodoSeleccionado.isEmpty() && lista.get(i).getIndice() == nodoSeleccionado.get(0).getIndice()) {
				lista.remove(lista.get(i));
				i--;

				if (!parejaNodos.isEmpty()) {
					if (parejaNodos.size() == 1) {
						parejaNodos.clear();
						return;
					} else {
						if (opcionLista == 1) {
							reEnlazarNodoEnlazada(nodoSeleccionado, parejaNodos);
							nodoSeleccionado.clear();

						}
						if (opcionLista == 2) {
							reEnlazarNodosDoblemente(nodoSeleccionado, parejaNodos);
							nodoSeleccionado.clear();

						}
						if (opcionLista == 3) {
							reEnlazarNodosCircular(nodoSeleccionado, parejaNodos);
							nodoSeleccionado.clear();

						}

					}
				}
			}
		}

	}

	private void reEnlazarNodosCircular(ArrayList<NodoGrafico> nodoSeleccionado, ArrayList<ParejaNodos> parejaNodos) {

		if (nodoSeleccionado.get(0).getIndice() == parejaNodos.get(0).getNodo1().getIndice()) {
			parejaNodos.remove(0);
			parejaNodos.get(parejaNodos.size() - 1).setNodo2(parejaNodos.get(0).getNodo1());
			System.out.println("Entre aqui");
			return;
		}
		if (nodoSeleccionado.get(0).getIndice() == parejaNodos.get(parejaNodos.size() - 1).getNodo1().getIndice()) {
			parejaNodos.remove(parejaNodos.size() - 1);
			parejaNodos.get(parejaNodos.size() - 1).setNodo2(parejaNodos.get(0).getNodo1());
			return;
		} else {
			for (int i = 1; i < parejaNodos.size(); i++) {
				if (nodoSeleccionado.get(0).getIndice() == parejaNodos.get(i).getNodo1().getIndice()) {
					parejaNodos.get(i - 1).setNodo2(parejaNodos.get(i).getNodo2());
					parejaNodos.remove(i);
					return;
				}
			}
		}
	}

	public void reEnlazarNodosDoblemente(ArrayList<NodoGrafico> nodoSeleccionado, ArrayList<ParejaNodos> parejaNodos) {

		if (nodoSeleccionado.get(0).getIndice() == parejaNodos.get(0).getNodo1().getIndice()) {
			parejaNodos.remove(0);
			parejaNodos.remove(0);
			return;
		}
		if (nodoSeleccionado.get(0).getIndice() == parejaNodos.get(parejaNodos.size() - 1).getNodo1().getIndice()) {
			parejaNodos.remove(parejaNodos.size() - 1);
			parejaNodos.remove(parejaNodos.size() - 1);
			return;
		} else {
			for (int i = 0; i < parejaNodos.size(); i++) {

				if (nodoSeleccionado.get(0).getIndice() == parejaNodos.get(i).getNodo1().getIndice()) {
					parejaNodos.get(i - 2).setNodo2(parejaNodos.get(i).getNodo2());

					parejaNodos.get(i - 1).setNodo1(parejaNodos.get(i).getNodo2());

					parejaNodos.remove(i);
					parejaNodos.remove(i);
					return;

				}
				i++;
			}
		}

	}

	/**
	 * Reacomoda los elances cuando se elimina un nodo
	 * 
	 * @param nodoSeleccionado
	 * @param parejaNodos
	 */
	public void reEnlazarNodoEnlazada(ArrayList<NodoGrafico> nodoSeleccionado, ArrayList<ParejaNodos> parejaNodos) {

		if (parejaNodos.get(0).getNodo1().getIndice() == nodoSeleccionado.get(0).getIndice()) {
			parejaNodos.remove(0);
		}
		if (parejaNodos.get(parejaNodos.size() - 1).getNodo2().getIndice() == nodoSeleccionado.get(0).getIndice()) {
			parejaNodos.remove(parejaNodos.size() - 1);
		} else {
			for (int i = 0; i < parejaNodos.size(); i++) {
				if (nodoSeleccionado.get(0).getIndice() == parejaNodos.get(i).getNodo1().getIndice()) {
					parejaNodos.get(i - 1).setNodo2(parejaNodos.get(i).getNodo2());
					parejaNodos.remove(i);
					return;
				}
			}
		}

	}

	/**
	 * Agrega los nodos que coincida con el dato que entra como parametro para
	 * despues dibujar dichos nodos en pantalla con otro color
	 * 
	 * @param dato
	 * @param lista
	 * @param g
	 * @return
	 */
	public ArrayList<NodoGrafico> containsListas(String dato, ListaEnlazada<NodoGrafico> lista, Graphics g) {

		ArrayList<NodoGrafico> nodosContains = new ArrayList<>();

		for (int i = 0; i < lista.size(); i++) {
			if (String.valueOf(lista.get(i).getId()).equals(dato)) {
				nodosContains.add(lista.get(i));
			}
		}
		return nodosContains;
	}

}