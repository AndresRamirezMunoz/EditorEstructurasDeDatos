package uniquindio.listas.listaDE;

import uniquindio.listas.Nodo;
import uniquindio.listas.listaEnlazada.ListaEnlazada;

/**
 * 
 * @author Gustavo Andres Ramirez Munoz
 *
 */
public class ListaDoblementeEnlazada<T> extends ListaEnlazada<T> {

	/**
	 * Añade datos a esta lista
	 */
	@Override
	public boolean add(T dato) {
		Nodo<T> aux = new Nodo<T>(dato);

		if (isEmpty()) {
			primero = aux;
			ultimo = aux;
		} else {
			ultimo.setSiguiente(aux);
			aux.setAnterior(ultimo);
			ultimo = aux;
		}
		cantidad++;
		return true;
	}

	/**
	 * Elimina de la lista el dato que entra como parametro si este se encuentra
	 * en la lista
	 */
	@Override
	public boolean remove(Object dato) {
		Nodo<T> aux = primero;
		Nodo<T> anterior = null;

		while (aux != null) {

			if (aux.getDato().equals(dato)) {
				if (anterior == null) {

					primero = primero.getSiguiente();
					//primero.setAnterior(null);
					aux = null;

				} else {
					anterior.setSiguiente(aux.getSiguiente());

					if (aux.getSiguiente() == null) {
						ultimo = anterior;
						aux = null;
					} else {
						aux.getSiguiente().setAnterior(anterior);
						aux = null;
					}
				}
				cantidad--;
				return true;
			}else{
			anterior = aux;
			aux = aux.getSiguiente();
			}
		}

		return true;
	}
}
