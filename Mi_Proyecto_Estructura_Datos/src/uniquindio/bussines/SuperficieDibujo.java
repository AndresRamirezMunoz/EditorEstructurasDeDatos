package uniquindio.bussines;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 * @author Gustavo Andres Ramirez Munoz--Ivan Santigo Castaneda
 *
 */
public class SuperficieDibujo {

	private static final Font FUENTE_NODOS = new Font("Arial", Font.PLAIN, 18);
	private static final Font FUENTE_CADENA = new Font("Arial", Font.PLAIN, 10);
	private static final Font FUENTE_CADENA2 = new Font("Arial", Font.PLAIN, 13);

	/**
	 * Dibuja el nodo
	 * 
	 * @param id
	 * @param punto
	 * @param diferencia
	 * @param g
	 */
	public static void dibujarNodoEncontrado(int id, Point punto, int diferencia, Graphics g) {
		g.setFont(FUENTE_NODOS);
		String cadena = id + "";

		g.setColor(Color.red);
		g.fillOval(punto.x - (diferencia / 2), punto.y - (diferencia / 2), Constantes.RADIO_NODO + diferencia,
				Constantes.RADIO_NODO + diferencia);

		g.setColor(Color.gray);
		g.fillOval(punto.x, punto.y, Constantes.RADIO_NODO, Constantes.RADIO_NODO);

		g.setColor(Color.black);
		g.drawString(cadena, (punto.x + (Constantes.RADIO_NODO / 2)) - (MedidorString.medirAnchoPixeles(g, cadena) / 2),
				punto.y + (Constantes.RADIO_NODO / 2) + (MedidorString.medirAltoPixeles(g, cadena) / 2));

	}

	/**
	 * Dibuja el nodo
	 * 
	 * @param id
	 * @param punto
	 * @param diferencia
	 * @param g
	 */
	public static void dibujarNodo(int id, Point punto, int diferencia, Boolean seleccion, Graphics g) {

		g.setFont(FUENTE_NODOS);
		String cadena = id + "";

		g.setColor(Color.black);
		g.fillOval(punto.x - (diferencia / 2), punto.y - (diferencia / 2), Constantes.RADIO_NODO + diferencia,
				Constantes.RADIO_NODO + diferencia);

		if (seleccion) {
			g.setColor(Color.blue);
		} else {
			g.setColor(Color.gray);
		}

		g.fillOval(punto.x, punto.y, Constantes.RADIO_NODO, Constantes.RADIO_NODO);

		g.setColor(Color.black);

		g.drawString(cadena, (punto.x + (Constantes.RADIO_NODO / 2)) - (MedidorString.medirAnchoPixeles(g, cadena) / 2),
				punto.y + (Constantes.RADIO_NODO / 2) + (MedidorString.medirAltoPixeles(g, cadena) / 2));

	}

	/**
	 * Dibuja en secuencia de nodos los par de nodos que esten conectados
	 * 
	 * @param cadena
	 * @param x
	 * @param g
	 */
	public static void dibujarSecuenciaNodos(String cadena, int x, Graphics g) {

		g.setColor(Color.black);
		g.setFont(FUENTE_CADENA2);
		g.drawString(cadena, Constantes.ANCHO_ZONA_DIUJABLE / 2 -   MedidorString.medirAnchoPixeles(g, cadena) / 2,
				Constantes.ALTO_ZONA_DIUJABLE - 10);
	}

	/**
	 * Dibuja los enlances entre los nodos
	 * 
	 * @param pI
	 * @param pF
	 * @param g
	 */
	public static void dibujarEnlaces(boolean n, Point pI, Point pF, Graphics g) {

		if (n) {

			// drawArrow(pI.x, pI.y, pF.x, pF.y, g);

			double ang = 0.0, angSep = 0.0;
			double tx, ty;
			int dist = 0;
			Point punto1 = null, punto2 = null;

			// defino dos puntos extremos
			punto1 = pI;
			punto2 = pF;

			// tamaño de la punta de la flecha
			dist = 15;

			/*
			 * (la coordenadas de la ventana es al revez) calculo de la
			 * variacion de "x" y "y" para hallar el angulo
			 **/

			ty = -(punto1.y - punto2.y) * 1.0;
			tx = (punto1.x - punto2.x) * 1.0;
			// angulo
			ang = Math.atan(ty / tx);

			if (tx < 0) {// si tx es negativo aumentar 180 grados
				ang += Math.PI;
			}

			// puntos de control para la punta
			// p1 y p2 son los puntos de salida

			Point p1 = new Point(), p2 = new Point(), punto = punto2;

			// angulo de separacion
			angSep = 25.0;

			p1.x = (int) (punto.x + dist * Math.cos(ang - Math.toRadians(angSep)));
			p1.y = (int) (punto.y - dist * Math.sin(ang - Math.toRadians(angSep)));
			p2.x = (int) (punto.x + dist * Math.cos(ang + Math.toRadians(angSep)));
			p2.y = (int) (punto.y - dist * Math.sin(ang + Math.toRadians(angSep)));

			// dale color a la linea
			g.setColor(Color.BLUE);

			// dibuja la linea de extremo a extremo
			g.drawLine(punto1.x, punto1.y, punto.x, punto.y);
			// dibujar la punta
			g.drawLine(p1.x, p1.y, punto.x, punto.y);
			g.drawLine(p2.x, p2.y, punto.x, punto.y);

		}

	}

	/**
	 * Dibuja el indice en donde se encutra el nodo
	 * 
	 * @param indice
	 * @param punto
	 * @param g
	 */
	public static void dibujarIndice(int indice, Point punto, Graphics g) {

		g.setFont(FUENTE_CADENA);
		g.setColor(Color.red);
		String cadena = indice + "";
		g.drawString(cadena, punto.x + (Constantes.RADIO_NODO / 2) - (MedidorString.medirAnchoPixeles(g, cadena) / 2),
				punto.y + 3 + (Constantes.RADIO_NODO) + (MedidorString.medirAnchoPixeles(g, cadena) * 2));
	}

}
