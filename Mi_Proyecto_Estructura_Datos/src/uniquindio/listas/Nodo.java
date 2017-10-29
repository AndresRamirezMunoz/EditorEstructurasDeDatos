package uniquindio.listas;


public class Nodo<T> {

	private T dato;// tipo de datos
	private Nodo<T> siguiente;// tipo de el encale
	private Nodo<T> anterior;

	public Nodo(T dato) {

		this.dato = dato;
		siguiente = null;

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
	 * @return the siguiente
	 */
	public Nodo<T> getSiguiente() {
		return siguiente;
	}

	/**
	 * @param siguiente the siguiente to set
	 */
	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}

	/**
	 * @return the anterior
	 */
	public Nodo<T> getAnterior() {
		return anterior;
	}

	/**
	 * @param anterior the anterior to set
	 */
	public void setAnterior(Nodo<T> anterior) {
		this.anterior = anterior;
	}
	
	
}
