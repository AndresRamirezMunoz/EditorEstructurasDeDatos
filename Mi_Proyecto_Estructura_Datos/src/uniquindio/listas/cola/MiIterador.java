package uniquindio.listas.cola;

import java.util.Iterator;

public class MiIterador<T> implements Iterator<T> {

	@SuppressWarnings("rawtypes")
	private Nodo aux;

	public MiIterador(@SuppressWarnings("rawtypes") Cola cola) {
		aux = cola.getPrimero();
	}

	@Override
	public boolean hasNext() {
		return aux != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T next() {
		T dato = (T) aux.getDato();
		aux = aux.getSiguiente();
		return dato;
	}
}