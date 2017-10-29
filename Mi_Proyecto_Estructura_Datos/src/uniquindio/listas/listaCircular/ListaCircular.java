package uniquindio.listas.listaCircular;
import uniquindio.listas.Nodo;
import uniquindio.listas.listaEnlazada.ListaEnlazada;


/**
 * 
 * @author Gustavo Andres Ramirez Munoz
 *
 */
public class ListaCircular<T> extends ListaEnlazada<T> {

	public boolean add(T dato) {

		Nodo<T> aux = new Nodo<T>(dato);
		if (isEmpty()) {
			primero = aux;
			primero.setSiguiente(ultimo);
			// ultimo.setSiguiente(primero);// importante
		} else {
			ultimo.setSiguiente(aux);
			aux.setSiguiente(primero);// importante
		}
		ultimo = aux;
		cantidad++;
		return true;
	}

	public boolean remove(Object dato) {
		Nodo<T> aux = primero;
		Nodo<T> anterior = ultimo;
		boolean flag = true;
		while (flag) {
			if (aux.equals(ultimo)) {
				flag = false;
			}
			if (aux.getDato().equals(dato)) {
				if (aux.equals(primero)) {
					primero = aux.getSiguiente();
					ultimo.setSiguiente(primero);
					aux = null;

				} else {

					anterior.setSiguiente(aux.getSiguiente());
					if (aux.equals(ultimo)) {
						ultimo = anterior;
					}
					aux = null;

				}
				cantidad--;
				return true;
			}

			anterior = aux;
			aux = aux.getSiguiente();
		}
		return false;
	}

}
