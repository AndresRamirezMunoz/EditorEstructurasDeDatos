package uniquindio;

import java.util.ArrayList;
import java.util.LinkedList;

import uniquindio.listas.cola.Cola;
import uniquindio.listas.listaCircular.ListaCircular;
import uniquindio.listas.listaDE.ListaDoblementeEnlazada;
import uniquindio.listas.listaEnlazada.ListaEnlazada;
import uniquindio.listas.pila.Pila;

public class Prueba {

	public static void main(String[] args) {

		ArrayList<Integer> arrayList = new ArrayList<>();

		ListaEnlazada<Integer> listaE = new ListaEnlazada<>();
		ListaDoblementeEnlazada<Integer> listaDE = new ListaDoblementeEnlazada<>();
		ListaCircular<Integer> listaC = new ListaCircular<>();
		Pila<Integer> pila = new Pila<>();
		Cola<Integer> cola = new Cola<>();

		
		
		for (int i = 0; i < 5; i++) {
			listaE.add(i);
			listaDE.add(i);
		
			listaC.add(i);
			pila.push(i);
			cola.add(i);
			arrayList.add(i);
		}
		
		System.out.println(listaDE);
		listaDE.remove(0);
		System.out.println(listaDE);

		// for (int i = 0; i < listaE.size(); i++) {
		// arrayList.add(listaE.get(i));
		// listaE.getUltimo();
		// }
		// System.out.println("Lista enlazada" + arrayList);
		// arrayList.clear();
		//
		// for (int i = 0; i < listaDE.size(); i++) {
		// arrayList.add(listaDE.get(i));
		// }
		// System.out.println("Lista doble" + arrayList);
		// arrayList.clear();
		//
		// for (int i = 0; i < listaC.size(); i++) {
		// arrayList.add(listaC.get(i));
		// }
		// System.out.println("Lista circula" + arrayList);
		// arrayList.clear();
		//
		// for (Integer c : invertirPila(pila)) {
		// arrayList.add(c);
		// }
		// System.out.println("Pila" + arrayList);
		// arrayList.clear();
		//
		// for (Integer c : cola) {
		// arrayList.add(c);
		// }
		// System.out.println("Cola" + arrayList);
		// arrayList.clear();

	}

	/**
	 * Inivierte los valores de una pila
	 * 
	 * @param pila
	 * @return
	 */
	public static Pila<Integer> invertirPila(Pila<Integer> pila) {

		Pila<Integer> aux = new Pila<>();
		for (Integer integer : pila) {
			aux.push(integer);
		}
		return aux;

	}

}
