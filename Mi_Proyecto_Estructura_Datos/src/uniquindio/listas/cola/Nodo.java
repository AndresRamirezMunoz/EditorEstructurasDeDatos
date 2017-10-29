package uniquindio.listas.cola;

public class Nodo<T> {

	private T dato;//tipo de datos
	private Nodo<T> siguiente;//tipo de el encale
	
	public Nodo(T dato) {
		
		this.dato=dato;
		siguiente=null;
		
	}

	/**
	 * @return the dato
	 */
	public T getDato() {
		return dato;
	}

	/**
	 * @param dato the dato to set
	 */
	public void setDato(T dato) {
		this.dato = dato;
	}

	/**
	 * @return the enlace
	 */
	public Nodo<T> getSiguiente() {
		return siguiente;
	}

	/**
	 * @param enlace the enlace to set
	 */
	public void setSiguiente(Nodo<T> enlace) {
		this.siguiente = enlace;
	}

	
	
}
