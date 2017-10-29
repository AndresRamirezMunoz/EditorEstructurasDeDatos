package uniquindio.VO;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import uniquindio.bussines.Constantes;
import uniquindio.bussines.SuperficieDibujo;

/**
 * 
 * @author Gustavo Andres Ramirez Munoz--Ivan Santigo Castaneda
 *
 */
public class NodoGrafico {

	private final int DIFERENCIA = 10;
	private int id;
	private int indice;
	private Point punto;
	private boolean seleccionado;
	private Point puntoLineaInicial;
	private Point puntoLineaFinal;
	private boolean enlace;

	/**
	 * Inicianliza las variables
	 * 
	 * @param id
	 * @param punto
	 */
	public NodoGrafico(int indice,int id, Point punto) {
		
		this.indice=indice;
		this.id = id;
		this.punto = punto;
		seleccionado = false;
		enlace = false;
		

		puntoLineaInicial = new Point(punto.x + Constantes.RADIO_NODO / 2, punto.y + Constantes.RADIO_NODO / 2);
		puntoLineaFinal = new Point(punto.x + Constantes.RADIO_NODO / 2, punto.y + Constantes.RADIO_NODO / 2);

	}



	/**
	 * Ejecuta el metodo que dibuja el nodo
	 * 
	 * @param g
	 * @param indice
	 */
	public void dibujarNodos(Graphics g) {
		SuperficieDibujo.dibujarNodo(id, punto, DIFERENCIA, seleccionado, g);
	

	}


	/**
	 * @return the indice
	 */
	public int getIndice() {
		return indice;
	}

	/**
	 * @param indice the indice to set
	 */
	public void setIndice(int indice) {
		this.indice = indice;
	}

	/**
	 * @return the enlace
	 */
	public boolean isEnlace() {
		return enlace;
	}

	/**
	 * @param enlace
	 *            the enlace to set
	 */
	public void setEnlace(boolean enlace) {
		this.enlace = enlace;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the seleccionado
	 */
	public boolean isSeleccionado() {
		return seleccionado;
	}

	/**
	 * @param seleccionado
	 *            the seleccionado to set
	 */
	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	/**
	 * @return the puntoLineaInicial
	 */
	public Point getPuntoLineaInicial() {
		return puntoLineaInicial;
	}

	/**
	 * @param puntoLineaInicial
	 *            the puntoLineaInicial to set
	 */
	public void setPuntoLineaInicial(Point puntoLineaInicial) {
		this.puntoLineaInicial = puntoLineaInicial;
	}

	/**
	 * @return the puntoLineaFinal
	 */
	public Point getPuntoLineaFinal() {
		return puntoLineaFinal;
	}

	/**
	 * @param puntoLineaFinal
	 *            the puntoLineaFinal to set
	 */
	public void setPuntoLineaFinal(Point puntoLineaFinal) {
		this.puntoLineaFinal = puntoLineaFinal;
	}

	/**
	 * @return the dIFERENCIA
	 */
	public int getDIFERENCIA() {
		return DIFERENCIA;
	}

	/**
	 * Retorna el area de colsion del nodo
	 * 
	 * @return
	 */
	public Rectangle getColision() {
		return new Rectangle(punto.x, punto.y, Constantes.RADIO_NODO, Constantes.RADIO_NODO);
	}

	/**
	 * @return the punto
	 */
	public Point getPunto() {
		return punto;
	}

	/**
	 * @param punto
	 *            the punto to set
	 */
	public void setPunto(Point punto) {
		this.punto = punto;
	}

}
