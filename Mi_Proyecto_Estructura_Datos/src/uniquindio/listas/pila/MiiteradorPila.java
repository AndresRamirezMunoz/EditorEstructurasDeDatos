package uniquindio.listas.pila;

import java.util.Iterator;

import uniquindio.listas.Nodo;
 

public class MiiteradorPila<E> implements Iterator<E> {

	private Nodo<E> dato;

	public MiiteradorPila(Nodo<E> dato) {
		this.dato = dato;
	}

	@Override
	public boolean hasNext() {
		return dato != null;// Mientrassea difernete null
	}

	@Override
	public E next() {
		E aux = dato.getDato();
		dato = dato.getSiguiente();
		return aux;
	}

}
