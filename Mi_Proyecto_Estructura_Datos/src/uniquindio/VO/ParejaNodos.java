package uniquindio.VO;

/**
 * 
 * @author Gustavo Andres Ramirez Munoz--Ivan Santigo Castaneda
 *
 */
public class ParejaNodos {

	private NodoGrafico nodo1;
	private NodoGrafico nodo2;

	/**
	 * 
	 * @param nodo1
	 * @param nodo2
	 */
	public ParejaNodos(NodoGrafico nodo1, NodoGrafico nodo2) {
		super();
		this.nodo1 = nodo1;
		this.nodo2 = nodo2;
	}

	/**
	 * @return the nodo1
	 */
	public NodoGrafico getNodo1() {
		return nodo1;
	}

	/**
	 * @param nodo1
	 *            the nodo1 to set
	 */
	public void setNodo1(NodoGrafico nodo1) {
		this.nodo1 = nodo1;
	}

	/**
	 * @return the nodo2
	 */
	public NodoGrafico getNodo2() {
		return nodo2;
	}

	/**
	 * @param nodo2
	 *            the nodo2 to set
	 */
	public void setNodo2(NodoGrafico nodo2) {
		this.nodo2 = nodo2;
	}

	/**
	 * Devulve una cadena con datos para mostrar en la ventana
	 */
	@Override
	public String toString() {

		return "(" + nodo1.getIndice() + "," + nodo2.getIndice() + ") ";
	}

}
