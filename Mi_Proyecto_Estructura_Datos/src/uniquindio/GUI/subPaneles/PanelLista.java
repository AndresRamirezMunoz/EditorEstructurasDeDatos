package uniquindio.GUI.subPaneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import uniquindio.GUI.PanelBotones;
import uniquindio.GUI.Ventana;
import uniquindio.bussines.CambioInformacion;
import uniquindio.bussines.Constantes;

import javax.swing.JLabel;

/**
 * 
 * @author Gustavo Andres Ramirez Munoz--Ivan Santigo Castaneda
 *
 */
public class PanelLista extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton botonListaEnlazada, botonListaDoble;
	private JButton botonListaCircular;
	private boolean isVisible;
	private JLabel labelTipo;
	private JLabel labelEspacio;
	private JButton botonRegresar;
	private JFrame ventana;
	private PanelBotones panelBotones;

	private PanelListasEDC panelListaEDC;
	private int opcion;

	public PanelLista(JFrame ventana, PanelBotones panelBotones, Ventana ventanaPrincipal) {

		this.ventana = ventana;
		this.panelBotones = panelBotones;

		panelListaEDC = new PanelListasEDC(ventana, this, ventanaPrincipal);

		panel = new JPanel();
		panel.setBackground(new Color(153, 153, 153));
		panel.setBackground(Constantes.COLORPANEL);

		labelTipo = new JLabel("Listas    ");
		labelTipo.setFont(Constantes.FUENTE);
		panel.add(labelTipo);

		botonListaEnlazada = new JButton("Lista enlazada");
		botonListaEnlazada.setFont(Constantes.FUENTE);
		botonListaEnlazada.setForeground(Constantes.COLORLETRA);
		botonListaEnlazada.setBackground(Constantes.COLORBOTON);
		botonListaEnlazada.addActionListener(this);
		panel.add(botonListaEnlazada);

		botonListaDoble = new JButton("lista doblemente enlazada");
		botonListaDoble.setFont(Constantes.FUENTE);
		botonListaDoble.setForeground(Constantes.COLORLETRA);
		botonListaDoble.setBackground(Constantes.COLORBOTON);
		botonListaDoble.addActionListener(this);
		panel.add(botonListaDoble);

		botonListaCircular = new JButton("Lista circular");
		botonListaCircular.setFont(Constantes.FUENTE);
		botonListaCircular.setForeground(Constantes.COLORLETRA);
		botonListaCircular.setBackground(Constantes.COLORBOTON);
		botonListaCircular.addActionListener(this);
		panel.add(botonListaCircular);

		labelEspacio = new JLabel("                                        ");
		panel.add(labelEspacio);

		botonRegresar = new JButton("Regresar");
		botonRegresar.setFont(Constantes.FUENTE);
		botonRegresar.setForeground(Constantes.COLORLETRA);
		botonRegresar.setBackground(Constantes.COLORBOTON);
		botonRegresar.addActionListener(this);
		panel.add(botonRegresar);

		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		isVisible = false;
		panel.setVisible(isVisible);
		{

			opcion = 0;
		}

	}

	

	/**
	 * Se detectan los eventos de los botones
	 * 
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		setVisible(false);
		
		if (e.getSource() == botonListaEnlazada) {
			System.out.println("Boton botonListaEnlazada");
			panelListaEDC.setVisible(true);
			ventana.getContentPane().add(panelListaEDC.getPanel(), BorderLayout.SOUTH);
			opcion = new CambioInformacion().cambiarPanelListaEnlazada(panelListaEDC);
			panelListaEDC.setOpcion(opcion);

		}
		if (e.getSource() == botonListaDoble) {
			System.out.println("Boton botonListaDoble");
			panelListaEDC.setVisible(true);
			ventana.getContentPane().add(panelListaEDC.getPanel(), BorderLayout.SOUTH);
			opcion=new CambioInformacion().cambiarPanelListaDoblEnlazada(panelListaEDC);
			panelListaEDC.setOpcion(opcion);
		}

		if (e.getSource() == botonListaCircular) {
			System.out.println("Boton botonListaCircular");
			panelListaEDC.setVisible(true);
			ventana.getContentPane().add(panelListaEDC.getPanel(), BorderLayout.SOUTH);
			opcion=new CambioInformacion().cambiarPanelListaCircular(panelListaEDC);
			panelListaEDC.setOpcion(opcion);

		}
		if (e.getSource() == botonRegresar) {
			setVisible(false);
			panelBotones.setVisible(true);
			ventana.getContentPane().add(panelBotones.getPanel(), BorderLayout.SOUTH);
			panelBotones.setPanelActivo(false);
			opcion=0;

		}
	}

	
	
	/**
	 * @return the panelListaEDC
	 */
	public PanelListasEDC getPanelListaEDC() {
		return panelListaEDC;
	}
	/**
	 * @return the opcion
	 */
	public int getOpcion() {
		return opcion;
	}

	/**
	 * Invia un boolean al panel para indicar que puede dibujar el nodo
	 * 
	 * @param b
	 */
	public void setPanelActivo(boolean b) {
		panelBotones.setPanelActivo(true);

	}

	/**
	 * @return the botonListaEnlazada
	 */
	public JButton getBotonListaEnlazada() {
		return botonListaEnlazada;
	}

	/**
	 * @param botonListaEnlazada
	 *            the botonListaEnlazada to set
	 */
	public void setBotonListaEnlazada(JButton botonListaEnlazada) {
		this.botonListaEnlazada = botonListaEnlazada;
	}

	/**
	 * @return the botonListaDoble
	 */
	public JButton getBotonListaDoble() {
		return botonListaDoble;
	}

	/**
	 * @param botonListaDoble
	 *            the botonListaDoble to set
	 */
	public void setBotonListaDoble(JButton botonListaDoble) {
		this.botonListaDoble = botonListaDoble;
	}

	/**
	 * @return the botonListaCircular
	 */
	public JButton getBotonListaCircular() {
		return botonListaCircular;
	}

	/**
	 * @param botonListaCircular
	 *            the botonListaCircular to set
	 */
	public void setBotonListaCircular(JButton botonListaCircular) {
		this.botonListaCircular = botonListaCircular;
	}

	/**
	 * @return the labelTipo
	 */
	public JLabel getLabelTipo() {
		return labelTipo;
	}

	/**
	 * @param labelTipo
	 *            the labelTipo to set
	 */
	public void setLabelTipo(JLabel labelTipo) {
		this.labelTipo = labelTipo;
	}

	/**
	 * @return the labelEspacio
	 */
	public JLabel getLabelEspacio() {
		return labelEspacio;
	}

	/**
	 * @param labelEspacio
	 *            the labelEspacio to set
	 */
	public void setLabelEspacio(JLabel labelEspacio) {
		this.labelEspacio = labelEspacio;
	}

	/**
	 * @return the botonRegresar
	 */
	public JButton getBotonRegresar() {
		return botonRegresar;
	}

	/**
	 * @param botonRegresar
	 *            the botonRegresar to set
	 */
	public void setBotonRegresar(JButton botonRegresar) {
		this.botonRegresar = botonRegresar;
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
}