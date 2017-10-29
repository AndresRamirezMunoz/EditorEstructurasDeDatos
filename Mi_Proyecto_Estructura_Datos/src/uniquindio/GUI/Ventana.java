package uniquindio.GUI;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JFrame;
import uniquindio.VO.NodoGrafico;
import uniquindio.VO.ParejaNodos;
import uniquindio.bussines.Constantes;
import uniquindio.bussines.Teclado;
import uniquindio.bussines.Listas.LogicaNodosGraficos;
import uniquindio.bussines.Listas.logicaGraficaParaListas;
import uniquindio.listas.listaCircular.ListaCircular;
import uniquindio.listas.listaDE.ListaDoblementeEnlazada;
import uniquindio.listas.listaEnlazada.ListaEnlazada;
import java.awt.Toolkit;

/**
 * 
 * @author Gustavo Andres Ramirez Munoz--Ivan Santigo Castaneda
 *
 */
public class Ventana extends Canvas implements Runnable, MouseListener, MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Font fuente = new Font("Arial", Font.PLAIN, 10);

	private BufferStrategy estrategia;
	private Graphics2D dibujar;
	private JFrame ventana;
	private Graphics g;
	private PanelBotones panelBotones;
	private boolean seleccionado;
	private NodoGrafico nodoMover;
	private int ultimoNodo;
	private Point mouseCoordenadas;
	private int opcion;
	private boolean ventanaActiva;
	private Teclado teclado;

	// Estructuras de datos
	private ListaEnlazada<NodoGrafico> listaEnlazada;
	private ListaDoblementeEnlazada<NodoGrafico> listaDoblemente;
	private ListaCircular<NodoGrafico> listaCircular;
	// Contiene la secuencia de nodos enlanzados
	private ArrayList<ParejaNodos> parejaNodos;
	private long referenciaContadorContains;
	//
	private ArrayList<NodoGrafico> nodosSeleccionados;
	private ArrayList<NodoGrafico> nodosEncontrado;

	/**
	 * Se inicializan los componente de la ventana
	 */
	public Ventana() {

		ventana = new JFrame("Editor E.D.");
		ventana.setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("/res/icono.png")));
		ventana.setResizable(false);
		ventana.getContentPane().add(this, BorderLayout.CENTER);
		ventana.setPreferredSize(new Dimension(Constantes.ANCHO, Constantes.ALTO));
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();

		{
			panelBotones = new PanelBotones(ventana, this);
			ventana.getContentPane().add(panelBotones.getPanel(), BorderLayout.SOUTH);
		}
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		this.addMouseListener(this);// Detecta los eventos del mouse en la
									// ventana
		this.addMouseMotionListener(this);
		teclado = new Teclado(this, opcion);
		addKeyListener(teclado);

		seleccionado = false;
		ultimoNodo = 0;
		mouseCoordenadas = new Point(0, 0);
		opcion = 0;
		nodosEncontrado = new ArrayList<>();
		listaEnlazada = new ListaEnlazada<>();
		listaDoblemente = new ListaDoblementeEnlazada<>();
		listaCircular = new ListaCircular<>();
		parejaNodos = new ArrayList<>();
		nodosSeleccionados = new ArrayList<>();
		ventanaActiva = false;
		
	}

	/**
	 * @return the ventanaActiva
	 */
	public boolean isVentanaActiva() {
		return ventanaActiva;
	}

	/**
	 * @param ventanaActiva
	 *            the ventanaActiva to set
	 */
	public void setVentanaActiva(boolean ventanaActiva) {
		this.ventanaActiva = ventanaActiva;
	}

	/**
	 * Limpia todas las listas
	 */
	public void limpiar() {

		nodosSeleccionados.clear();

		listaEnlazada.clear();
		listaDoblemente.clear();
		listaCircular.clear();
		opcion = 0;
		parejaNodos.clear();

	}

	/**
	 * Dibuja toda la parte grafica
	 */
	public void dibujar() {

		estrategia = getBufferStrategy();
		if (estrategia == null) {

			createBufferStrategy(3);
			return;
		}

		g = estrategia.getDrawGraphics();
		dibujar = (Graphics2D) g;
		update(g);
		g.setFont(fuente);
		g.setColor(Color.black);
		g.drawRoundRect(10, 10, Constantes.ANCHO_ZONA_DIUJABLE, Constantes.ALTO_ZONA_DIUJABLE, 10, 10);

		{

			dibujar.setStroke(new BasicStroke(4f));
			g.setColor(Color.black);

			new logicaGraficaParaListas().mandarDibujarEnlancesParejas(parejaNodos, g, opcion);

			switch (opcion) {
			case 1:
				new logicaGraficaParaListas().mandarDibujarListasNodos(listaEnlazada, dibujar, g);
				break;
			case 2:
				new logicaGraficaParaListas().mandarDibujarListasNodos(listaDoblemente, dibujar, g);
				break;
			case 3:
				new logicaGraficaParaListas().mandarDibujarListasNodos(listaCircular, dibujar, g);
				break;

			}
			if (!parejaNodos.isEmpty()) {
				new logicaGraficaParaListas().mandarDibujarListasNodosEncontrados(nodosEncontrado, dibujar, g);
			}

		}
		g.dispose();
		dibujar.dispose();
		estrategia.show();

	}

	@Override
	public void run() {

		final int MILI_SEGUNDOS = 1000000000;
		long referenciaContador1 = System.nanoTime();

		while (true) {

			actualizar();
			if (System.nanoTime() - referenciaContadorContains > MILI_SEGUNDOS) {
				nodosEncontrado.clear();
			}

			if (System.nanoTime() - referenciaContador1 > MILI_SEGUNDOS * 2) {
				System.out.println("Cantidad de nodos: " + listaEnlazada.size());
				System.out.println("Nodos seleccionado: " + nodosSeleccionados.size());
				System.out.println("Opcion de listas: " + opcion);
				System.out.println("Pareja nodos: " + parejaNodos.size());
				System.out.println("Encontrado " + nodosEncontrado.size());
				System.out.println("");
				referenciaContador1 = System.nanoTime();

			}

		}

	}

	public void actualizar() {
		dibujar();
		verificaciones();
		
		teclado.actualizar(panelBotones);
		

	}

	/**
	 * Ejecuta las verificacion de intercepto entre los nodos
	 * 
	 */
	public void verificaciones() {

		switch (opcion) {
		case 1:

			new LogicaNodosGraficos().verificarNodosInterceptados(listaEnlazada);
			break;
		case 2:

			new LogicaNodosGraficos().verificarNodosInterceptados(listaDoblemente);
			break;
		case 3:

			new LogicaNodosGraficos().verificarNodosInterceptados(listaCircular);
			break;
		}

	}

	/**
	 * Añade un nodo a la estructura de datos que se este manejando
	 * 
	 * @param dato
	 * 
	 */
	public void añadirNodo(int dato, int opcion) {

		this.opcion = opcion;
		if (panelBotones.isPanelActivo()) {

			panelBotones.setPanelActivo(false);

			seleccionado = true;
			switch (opcion) {

			case 1:
				listaEnlazada.add(new NodoGrafico(listaEnlazada.size(), dato, mouseCoordenadas));
				ultimoNodo = listaEnlazada.size() - 1;

				break;

			case 2:
				listaDoblemente.add(new NodoGrafico(listaDoblemente.size(), dato, mouseCoordenadas));
				ultimoNodo = listaDoblemente.size() - 1;

				break;

			case 3:
				listaCircular.add(new NodoGrafico(listaCircular.size(), dato, mouseCoordenadas));
				ultimoNodo = listaCircular.size() - 1;

				break;
			}

		}

	}

	/**
	 * Elimina el nodo seleccionado de la estructura sobre la que se trabaja
	 */
	public void eliminarNodo() {

		switch (opcion) {
		case 1:
			if (parejaNodos.size() == listaEnlazada.size() - 1 || parejaNodos.size() == listaEnlazada.size()) {
				new logicaGraficaParaListas().eliminarNodo(listaEnlazada, nodosSeleccionados, parejaNodos, opcion);
			}

			break;

		case 2:
			if (parejaNodos.size() / 2 == listaDoblemente.size() - 1) {
				new logicaGraficaParaListas().eliminarNodo(listaDoblemente, nodosSeleccionados, parejaNodos, opcion);
			}

			break;
		case 3:
			if (parejaNodos.size() == listaCircular.size()) {
				new logicaGraficaParaListas().eliminarNodo(listaCircular, nodosSeleccionados, parejaNodos, opcion);
			}

			break;
		}
	}



	/**
	 * Verifica que la estrucutra que se esta menejando contiene el dato que
	 * entra por parametroF
	 * 
	 * @param dato
	 * @return
	 */
	public void constains(String dato, int opcion) {

		this.opcion = opcion;
		referenciaContadorContains = System.nanoTime();

		switch (opcion) {
		case 1:
			if (parejaNodos.size() == listaEnlazada.size() - 1) {
				nodosEncontrado = new logicaGraficaParaListas().containsListas(dato, listaEnlazada, g);
			}
			break;
		case 2:
			if (parejaNodos.size() / 2 == listaDoblemente.size() - 1) {
				nodosEncontrado = new logicaGraficaParaListas().containsListas(dato, listaDoblemente, g);
			}
			break;
		case 3:
			if (parejaNodos.size() == listaCircular.size()) {
				nodosEncontrado = new logicaGraficaParaListas().containsListas(dato, listaCircular, g);
			}
			break;
		}

	}

	////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Detecta los clics del mouse
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

		if (ventanaActiva) {

			ListaEnlazada<NodoGrafico> lista = new ListaEnlazada<>();

			switch (opcion) {
			case 1:

				lista = listaEnlazada;
				break;

			case 2:

				lista = listaDoblemente;

				break;
			case 3:

				lista = listaCircular;
				break;
			}

			seleccionado = new logicaGraficaParaListas().acomodarNodo(ultimoNodo, seleccionado, lista,
					nodosSeleccionados, panelBotones, parejaNodos, e, opcion);
			ultimoNodo = -1;
		}
	}

	/**
	 * Detecta el movimiento del mouse
	 */
	@Override
	public void mouseMoved(MouseEvent e) {

		mouseCoordenadas = new Point(e.getX() - Constantes.RADIO_NODO / 2, e.getY() - Constantes.RADIO_NODO / 2);

		if (ventanaActiva) {
			ListaEnlazada<NodoGrafico> lista = new ListaEnlazada<>();

			switch (opcion) {
			case 1:

				lista = listaEnlazada;
				new logicaGraficaParaListas().redibujarNodo(ultimoNodo, opcion, lista, e);

				break;

			case 2:

				lista = listaDoblemente;
				new logicaGraficaParaListas().redibujarNodo(ultimoNodo, opcion, lista, e);

				break;
			case 3:

				lista = listaCircular;
				new logicaGraficaParaListas().redibujarNodo(ultimoNodo, opcion, lista, e);

				break;
			}

		}
	}

	/**
	 * Detecta el movimiento de arrastrar al dar clic
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		if (ventanaActiva) {
			if (nodoMover != null) {

				nodoMover.setPunto(
						new Point(e.getX() - Constantes.RADIO_NODO / 2, e.getY() - Constantes.RADIO_NODO / 2));

				nodoMover.setPuntoLineaInicial(new Point(nodoMover.getPunto().x + Constantes.RADIO_NODO / 2,
						nodoMover.getPunto().y + Constantes.RADIO_NODO / 2));
			}
		}
	}

	/**
	 * Detecta cuano se presiona el clic
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if (ventanaActiva) {
			ListaEnlazada<NodoGrafico> lista = new ListaEnlazada<>();

			switch (opcion) {
			case 1:
				lista = listaEnlazada;
				break;

			case 2:
				lista = listaDoblemente;
				break;
			case 3:
				lista = listaCircular;
				break;
			}

			nodoMover = new logicaGraficaParaListas().rehubicarNodo(opcion, lista, new Point(e.getX(), e.getY()));

		}
	}

	/**
	 * Detecta cuando se suelta el clic
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		nodoMover = null;

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * @return the mouseCoordenadas
	 */
	public Point getMouseCoordenadas() {
		return mouseCoordenadas;
	}

}
