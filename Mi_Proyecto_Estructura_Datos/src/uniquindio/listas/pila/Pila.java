package uniquindio.listas.pila;

import java.util.Iterator;

import uniquindio.listas.Nodo;

/**
 * 
 * @author Gustavo Andres Ramirez Munoz
 *
 */
public class Pila<T> implements Iterable<T> {

	Nodo<T> primero;
	private int cant;

	public Pila() {
		cant = 0;
	}

	/**
	 * Agrega al principio de la lista
	 */
	public void push(T dato) {
		Nodo<T> aux = new Nodo<>(dato);

		if (isEmpty()) {
			primero = aux;
		} else {
			aux.setSiguiente(primero);
			primero = aux;
		}
		cant++;

	}

	/**
	 * Retorna y elimina el primer dato de la pila
	 * 
	 * @return dato a retornar
	 */
	public T pop() {
		T dato;
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		} else {
			dato = primero.getDato();
			primero = primero.getSiguiente();
			cant--;
		}
		return dato;
	}

	private boolean isEmpty() {
		return cant == 0;
	}

	/**
	 * Retorna el primer dato de la pila
	 * 
	 * @return dato a retornar
	 */
	public T top() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		} else {
			return primero.getDato();
		}
	}

	/**
	 * Terminar metodo
	 * 
	 * @return
	 */
	@Override
	public Iterator<T> iterator() {
		Nodo<T> aux = primero;
		return new MiiteradorPila<>(aux);
	}

	/**
	 * Retorna el tamano de la pila
	 * 
	 * @return
	 */
	public int size() {
		return cant;
	}

	/**
	 * Elimina los datos de la pila
	 */
	public void clear() {
		primero = null;
		cant = 0;
	}

	/**
	 * Devulve true si la pila contiene el dato que entra por parametro
	 * 
	 * @param dato
	 * @return true o false si el dato esta o no
	 */
	public boolean contains(T dato) {
		Nodo<T> aux = primero;

		while (aux != null) {
			if (aux.getDato() == dato) {
				return true;
			}

			aux = aux.getSiguiente();
		}
		return false;
	}

	/**
	 * Cadena con los elementos de la pila
	 */
	@Override
	public String toString() {
		Nodo<T> aux = primero;
		String cadena = "[";
		String c = "";

		while (aux != null) {
			cadena += c + aux.getDato();
			c = ", ";
			aux = aux.getSiguiente();
		}
		return cadena + "]";
	}

	/**
	 * Devuelve el dato del nodo en la posicion pos
	 * 
	 * @param pos
	 * @return dato del nodo en la posicion indicada
	 */
	public T get(int pos) {
		Nodo<T> aux = primero;
		int i = 0;

		if (pos >= cant || pos < 0) {
			throw new IndexOutOfBoundsException();
		}

		while (aux != null) {
			if (i == pos) {
				return aux.getDato();
			} else {
				i++;
				aux = aux.getSiguiente();
			}
		}
		return null;

	}

}
