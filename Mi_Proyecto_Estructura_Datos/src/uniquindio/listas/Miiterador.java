package uniquindio.listas;

import java.util.Iterator;

import uniquindio.listas.listaEnlazada.ListaEnlazada;


public class Miiterador<E> implements Iterator<E> {

	private ListaEnlazada<E> miLista;
	private int contador = 0;

	public Miiterador(ListaEnlazada<E> miLista) {
		this.miLista = miLista;
	}

	@Override
	public boolean hasNext() {

		return contador < miLista.size();// Mientras en contador sea menor al
											// tamaño de la lista
	}

	@Override
	public E next() {

		return miLista.get(contador++);
	}

}
