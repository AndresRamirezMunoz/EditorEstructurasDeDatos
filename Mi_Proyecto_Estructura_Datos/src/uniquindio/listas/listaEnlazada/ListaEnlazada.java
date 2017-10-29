package uniquindio.listas.listaEnlazada;

import java.util.Collection;
import java.util.Iterator;
import uniquindio.listas.Miiterador;
import uniquindio.listas.Nodo;

/**
 * 
 * @author Gustavo Andres Ramirez Munoz
 *
 */
public class ListaEnlazada<T> implements Collection<T> {

	protected Nodo<T> primero;
	protected Nodo<T> ultimo;
	protected int cantidad;

	public ListaEnlazada() {

		cantidad = 0;

	}

	@Override
	public boolean add(T arg0) {

		Nodo<T> aux = new Nodo<T>(arg0);
		if (isEmpty()) {
			primero = aux;

		} else {
			ultimo.setSiguiente(aux);
		}
		ultimo = aux;
		cantidad++;
		return true;
	}

	/**
	 * Union entre coleeciones.
	 * 
	 * Esta lista queda con todo el contenido de arg0
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(Collection<? extends T> dato) {
		Object[] miArray = new Object[dato.size()];
		miArray = dato.toArray();

		for (int i = 0; i < miArray.length; i++) {
			add((T) miArray[i]);
		}
		dato.clear();

		return true;
	}

	/**
	 * Elimina too
	 */
	@Override
	public void clear() {
		primero = null;
		cantidad = 0;

	}

	/**
	 * Devuelve true si esta colección contiene el elemento especificado.
	 */
	@Override
	public boolean contains(Object dato) {
		Nodo<T> aux = primero;
		boolean bandera = true;

		while (aux != null & bandera) {
			if (aux.equals(ultimo)) {
				bandera = false;
			}
			if (aux.getDato().equals(dato)) {
				// Encontro el dato solicitado
				return true;
			} else {
				aux = aux.getSiguiente();
			}
		}
		// No encontro nada nada luego del pasar por el while
		return false;
	}

	/**
	 * Devuelve true si esta colección contiene todos los elementos de la
	 * colección especificada.
	 */
	@Override
	public boolean containsAll(Collection<?> arg0) {

		Nodo<T> aux = primero;
		Object[] miArray = new Object[arg0.size()];
		miArray = arg0.toArray();
		int valor = cantidad;
		boolean esta = false;
		boolean bandera = true;

		while (aux != null & bandera) {

			if (aux.equals(ultimo)) {
				bandera = false;
			}

			for (int i = 0; i < miArray.length; i++) {
				if (aux.getDato().equals(miArray[i])) {
					if (aux.getDato().equals(miArray[i])) {
						esta = true;
					}
				}
			}
			if (!esta) {
				valor--;
			}
			aux = aux.getSiguiente();
		}
		return cantidad == valor;
	}

	/**
	 * Retorna falso si esta vacion(Cantidad igual a cero)
	 */
	@Override
	public boolean isEmpty() {

		return cantidad == 0;

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Iterator<T> iterator() {

		return new Miiterador(this);
	}

	/**
	 * Elimina de la lista el valor que entra por parametro
	 */
	@Override
	public boolean remove(Object arg0) {

		Nodo<T> aux = primero;
		Nodo<T> anterior = null;

		while (aux != null) {

			if (aux.getDato().equals(arg0)) {

				if (anterior == null) {// Estoy en la primera posicion

					primero = aux.getSiguiente();
					aux = null;

				} else {

					if (aux.getSiguiente() == null) {
						anterior.setSiguiente(null);
						ultimo = anterior;
					} else {// Cuando estoy en el medio
						anterior.setSiguiente(aux.getSiguiente());

					}
				}
				cantidad--;
				return true;

			} else {
				anterior = aux;
				aux = aux.getSiguiente();

			}

		}

		return false;
	}

	/**
	 * 
	 * Elimina todos los elementos de esta colección que también están
	 * contenidos en la colección especificada.(doc java traducido)
	 */

	@Override
	public boolean removeAll(Collection<?> dato) {
		Nodo<T> aux = primero;
		Object[] miArray = new Object[dato.size()];
		miArray = dato.toArray();
		int valor = cantidad;
		boolean bandera = true;

		for (int i = 0; i < miArray.length; i++) {

			while (aux != null && bandera) {

				if (aux.equals(ultimo)) {
					bandera = false;
				}

				if (aux.getDato().equals(miArray[i])) {

					remove(aux.getDato());
					aux = aux.getSiguiente();

				} else {
					aux = aux.getSiguiente();
				}
			}
			aux = primero;
			bandera = true;
		}
		return !(cantidad == valor);
	}

	/**
	 * Conserva sólo los elementos de esta colección que están contenidos en la
	 * colección especificada.
	 */
	@Override
	public boolean retainAll(Collection<?> arg0) {
		Nodo<T> aux = primero;
		Object[] miArray = new Object[arg0.size()];
		miArray = arg0.toArray();
		int valor = cantidad;
		boolean esta = false;
		boolean bandera = true;

		while (aux != null & bandera) {

			if (aux.equals(ultimo)) {
				bandera = false;
			}

			for (int i = 0; i < miArray.length; i++) {
				if (aux.getDato().equals(miArray[i])) {
					if (aux.getDato().equals(miArray[i])) {
						esta = true;
					}
				}
			}
			if (!esta) {
				remove(aux.getDato());
			}
			aux = aux.getSiguiente();
		}
		return !(cantidad == valor);

	}

	@Override
	public int size() {
		return cantidad;
	}

	/**
	 * Covierte la cola en un array o vector
	 */
	@Override
	public Object[] toArray() {

		Object[] miArray = new Object[cantidad];
		int cont = 0;
		Nodo<T> aux = primero;
		boolean bandera = true;

		while (aux != null && bandera) {

			if (aux.equals(ultimo)) {
				bandera = false;
			}

			miArray[cont] = aux.getDato();
			aux = aux.getSiguiente();// Me muevo a la derecha
			cont++;

		}

		return miArray;
	}

	/**
	 * Retorna los elementos de una coleccion que entran como parametro en un
	 * arreglo
	 */
	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] arg0) {

		int cont = 0;
		@SuppressWarnings("unchecked")

		Nodo<T> aux = (Nodo<T>) primero;
		while (aux != null) {
			arg0[cont] = aux.getDato();
			aux = aux.getSiguiente();// Me muevo a la derecha
			cont++;

		}

		return arg0;
	}

	/*
	 * Retorna el conjuto escrito de manera metamatica
	 */
	@Override
	public String toString() {

		String resultado = "[";
		String coma = "";
		Nodo<T> aux = primero;
		boolean bandera = true;

		while (aux != null && bandera) {

			if (aux.equals(ultimo)) {
				bandera = false;
			}

			resultado += coma + aux.getDato();
			coma = ",";
			aux = aux.getSiguiente();

		}
		return resultado + "]";
	}

	/**
	 * trae el dato que se encuntra en el indice pedido
	 * 
	 * @param indice
	 * @return
	 */
	public T get(int indice) {

		if (indice < 0 || indice > cantidad) {
			throw new IndexOutOfBoundsException("idice no encontrado");
		}

		Nodo<T> aux = primero;
		for (int i = 0; i < indice; i++) {
			aux = aux.getSiguiente();
		}

		return aux.getDato();

	}

}
