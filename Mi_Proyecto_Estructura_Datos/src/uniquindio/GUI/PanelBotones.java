package uniquindio.GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import uniquindio.GUI.subPaneles.PanelCola;
import uniquindio.GUI.subPaneles.PanelLista;
import uniquindio.GUI.subPaneles.PanelPila;
import uniquindio.bussines.Constantes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JLabel;

/**
 * 
 * @author Gustavo Andres Ramirez Munoz--Ivan Santigo Castaneda
 *
 */
public class PanelBotones extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton botonLista, botonCola;
	private JButton botonPila;
	private JButton botonArbol;
	private JButton botonGrafo;;
	private boolean isVisible;
	private PanelLista panelLista;

	/**
	 * @return the panelLista
	 */
	public PanelLista getPanelLista() {
		return panelLista;
	}

	private PanelCola panelCola;
	private PanelPila panelPila;
	private JFrame ventana;

	private boolean panelActivo;
	private JButton botonAcercaDe;
	private JLabel lblNewLabel;

	/**
	 * Se crea el panel principal
	 * 
	 * @param ventana
	 * @param ventanaPrincipal
	 */
	public PanelBotones(JFrame ventana, Ventana ventanaPrincipal) {

		this.ventana = ventana;
		panelActivo = false;

		panelLista = new PanelLista(ventana, this, ventanaPrincipal);
		panelCola = new PanelCola(ventana, this, ventanaPrincipal);
		panelPila = new PanelPila(ventana, this, ventanaPrincipal);

		panel = new JPanel();
		panel.setBackground(Constantes.COLORPANEL);

		botonLista = new JButton("Lista");
		botonLista.setForeground(Constantes.COLORLETRA);
		botonLista.setBackground(Constantes.COLORBOTON);
		botonLista.setFont(Constantes.FUENTE);
		botonLista.addActionListener(this);
		panel.add(botonLista);

		botonCola = new JButton("Cola");
		botonCola.setForeground(Constantes.COLORLETRA);
		botonCola.setBackground(Constantes.COLORBOTON);
		botonCola.setFont(Constantes.FUENTE);
		botonCola.addActionListener(this);
		panel.add(botonCola);

		botonPila = new JButton("Pila");
		botonPila.setForeground(Constantes.COLORLETRA);
		botonPila.setBackground(Constantes.COLORBOTON);
		botonPila.setFont(Constantes.FUENTE);
		botonPila.addActionListener(this);
		panel.add(botonPila);

		botonArbol = new JButton("Arbol binario");
		botonArbol.setForeground(Constantes.COLORLETRA);
		botonArbol.setBackground(Constantes.COLORBOTON);
		botonArbol.setFont(Constantes.FUENTE);
		botonArbol.addActionListener(this);
		panel.add(botonArbol);

		botonGrafo = new JButton("Grafo");
		botonGrafo.setForeground(Constantes.COLORLETRA);
		botonGrafo.setBackground(Constantes.COLORBOTON);
		botonGrafo.setFont(Constantes.FUENTE);
		botonGrafo.addActionListener(this);
		panel.add(botonGrafo);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		botonAcercaDe = new JButton("!");
		botonAcercaDe.setForeground(Constantes.COLORLETRA);
		botonAcercaDe.setBackground(Constantes.COLORBOTON);
		botonAcercaDe.setFont(Constantes.FUENTE);
		botonAcercaDe.addActionListener(this);

		lblNewLabel = new JLabel("                                                                                  ");
		panel.add(lblNewLabel);
		panel.add(botonAcercaDe);
		isVisible = true;
		panel.setVisible(isVisible);
	}

	/**
	 * Se detectan los eventos de los botones
	 * 
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		setVisible(false);
		panelLista.setVisible(false);
		panelCola.setVisible(false);

		if (e.getSource() == botonLista) {
			panelLista.setVisible(true);
			ventana.getContentPane().add(panelLista.getPanel(), BorderLayout.SOUTH);

		}
		if (e.getSource() == botonCola) {
			panelCola.setVisible(true);
			ventana.getContentPane().add(panelCola.getPanel(), BorderLayout.SOUTH);

		}

		if (e.getSource() == botonPila) {
			panelPila.setVisible(true);
			ventana.getContentPane().add(panelPila.getPanel(), BorderLayout.SOUTH);

		}

		if (e.getSource() == botonArbol) {
			System.out.println("Boton arbol");
			setVisible(true);
		}
		if (e.getSource() == botonGrafo) {
			System.out.println("Boton grafo");
			setVisible(true);
		}
		if (e.getSource() == botonAcercaDe) {
			setVisible(true);
			new AcercaDe(ventana);
		}
	}

	/**
	 * @return the isVisible
	 */
	public boolean isVisible() {
		return isVisible;
	}

	/**
	 * @param isVisible
	 *            the isVisible to set
	 */
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
		panel.setVisible(isVisible);
	}

	/**
	 * 
	 * @return retorna el panel con lo que este contenga
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * @return the panelActivo
	 */
	public boolean isPanelActivo() {
		return panelActivo;
	}

	/**
	 * @param panelActivo
	 *            the panelActivo to set
	 */
	public void setPanelActivo(boolean panelActivo) {
		this.panelActivo = panelActivo;
	}

}
