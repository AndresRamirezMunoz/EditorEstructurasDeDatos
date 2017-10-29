package uniquindio.listas.cola;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;


public class Cola<T> implements Queue<T>, Iterable<T> {

	private Nodo<T> primero;
	private Nodo<T> ultimo;
	private int cantidad;

	/**
	 * Agrega datos a la cola
	 */
	@Override
	public boolean add(T dato) {

		Nodo<T> n = new Nodo<>(dato);
		if (isEmpty()) {
			primero = n;

		} else {
			ultimo.setSiguiente(n);
		}
		ultimo = n;
		cantidad++;

		return true;
	}

	/**
	 * Trae el primer elemento de la cola y lo elimina de esta
	 */
	@Override
	public T poll() {

		if (isEmpty()) {
			return null;
		} else {
			T aux = primero.getDato();
			primero = primero.getSiguiente();
			cantidad--;
			return aux;

		}

	}

	/**
	 * Retorna verdadero si el dato que entra por parametro esta en la cola
	 */
	public boolean contains(Object dato) {
		Nodo<T> aux = primero;
		if (!isEmpty()) {
			T auxiliar = aux.getDato();
			if (dato.equals(auxiliar)) {
				return true;
			} else {
				aux = primero.getSiguiente();
				while (aux != null) {
					if (aux.getDato().equals(dato)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * Retorna los datos de la cola en una cadena
	 */
	public String toString() {
		Nodo<T> aux = primero;
		String cadena = "[";
		String coma = "";

		if (!isEmpty()) {
			while (aux != null) {
				cadena += coma + aux.getDato();
				coma = ",";
				aux = aux.getSiguiente();
			}
		}
		return cadena + "]";
	}

	@Override
	public boolean isEmpty() {
		return cantidad == 0;
	}

	/**
	 * Retorna la cantidad de elementos
	 */
	@Override
	public int size() {
		return cantidad;
	}

	/**
	 * Trae el primer elemento de la cola
	 */
	@Override
	public T peek() {

		if (isEmpty()) {
			return null;
		} else {
			T aux = primero.getDato();
			// primero = primero.getSiguiente();
			// cantidad--;
			return aux;

		}

	}

	/**
	 * itera sobre la cola
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Iterator<T> iterator() {
		return new MiIterador(this);
	}

	/**
	 * @return the primero
	 */
	public Nodo<T> getPrimero() {
		return primero;
	}

	// _________________________________________________________________
	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		
		return false;
	}

	@Override
	public void clear() {
	

	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		return false;
		
	}

	@Override
	public boolean remove(Object arg0) {
		
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return false;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] arg0) {
		return null;
	}

	@Override
	public T element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean offer(T arg0) {
		return false;
	}

	@Override
	public T remove() {
		return null;
	}

}
