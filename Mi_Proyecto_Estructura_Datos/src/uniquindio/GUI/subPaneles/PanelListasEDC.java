package uniquindio.GUI.subPaneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import uniquindio.GUI.Ventana;
import uniquindio.GUI.VentanaNuevoNodo;
import uniquindio.bussines.CambioInformacion;
import uniquindio.bussines.Constantes;

/**
 * 
 * @author Gustavo Andres Ramirez Munoz--Ivan Santigo Castaneda
 *
 */
public class PanelListasEDC extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton boton1, boton2, boton3, boton4, boton5, botonRegresar;
	private boolean isVisible;
	private JLabel labeliLista, labelEspacio;
	private JFrame ventana;
	private PanelLista panelLista;
	private Ventana ventanaPrincipal;

	private int opcion;

	public PanelListasEDC(JFrame ventana, PanelLista panelLista, Ventana ventanaPrincipal) {
		{
			this.ventana = ventana;
			this.panelLista = panelLista;
			this.ventanaPrincipal = ventanaPrincipal;

			panel = new JPanel();
			panel.setBackground(new Color(153, 153, 153));
			panel.setBackground(Constantes.COLORPANEL);

			labeliLista = new JLabel("");
			labeliLista.setFont(Constantes.FUENTE);
			panel.add(labeliLista);

			boton1 = new JButton("");
			boton1.setFont(Constantes.FUENTE);
			boton1.setForeground(Constantes.COLORLETRA);
			boton1.setBackground(Constantes.COLORBOTON);
			boton1.addActionListener(this);
			panel.add(boton1);

			boton2 = new JButton("");
			boton2.setFont(Constantes.FUENTE);
			boton2.setForeground(Constantes.COLORLETRA);
			boton2.setBackground(Constantes.COLORBOTON);
			boton2.addActionListener(this);
			panel.add(boton2);

			boton3 = new JButton("");
			boton3.setFont(Constantes.FUENTE);
			boton3.setForeground(Constantes.COLORLETRA);
			boton3.setBackground(Constantes.COLORBOTON);
			boton3.addActionListener(this);
			panel.add(boton3);

			boton4 = new JButton("");
			boton4.setFont(Constantes.FUENTE);
			boton4.setForeground(Constantes.COLORLETRA);
			boton4.setBackground(Constantes.COLORBOTON);
			boton4.addActionListener(this);
			panel.add(boton4);

			boton5 = new JButton("");
			boton5.setFont(Constantes.FUENTE);
			boton5.setForeground(Constantes.COLORLETRA);
			boton5.setBackground(Constantes.COLORBOTON);
			boton5.addActionListener(this);
			panel.add(boton5);

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
		}
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
		
		ventanaPrincipal.setVentanaActiva(false);
		if (e.getSource() == boton1) {

			new CambioInformacion().cambiarInfoVentanaNodoAdd(new VentanaNuevoNodo(ventanaPrincipal, opcion, 1));
			panelLista.setPanelActivo(true);

		}
		if (e.getSource() == boton2) {

			ventanaPrincipal.setVentanaActiva(true);
			ventanaPrincipal.eliminarNodo();
		}

		if (e.getSource() == boton3) {

			new CambioInformacion().cambiarInfoVentanaNodoContains(new VentanaNuevoNodo(ventanaPrincipal, opcion, 2));

		}
		if (e.getSource() == boton4) {

		}
		if (e.getSource() == boton5) {

		}
		if (e.getSource() == botonRegresar) {
			setVisible(false);
			panelLista.setVisible(true);
			ventana.getContentPane().add(panelLista.getPanel(), BorderLayout.SOUTH);
			ventanaPrincipal.limpiar();
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
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
	 * @return the opcion
	 */
	public int getOpcion() {
		return opcion;
	}

	/**
	 * @param opcion
	 *            the opcion to set
	 */
	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}

	/**
	 * @return the botonAdd
	 */
	public JButton getBoton1() {
		return boton1;
	}

	/**
	 * @return the botonPoll
	 */
	public JButton getBoton2() {
		return boton2;
	}

	/**
	 * @return the botonContains
	 */
	public JButton getBoton3() {
		return boton3;
	}

	/**
	 * @return the botonPeek
	 */
	public JButton getBoton4() {
		return boton4;
	}

	/**
	 * @return the botonSize
	 */
	public JButton getBoton5() {
		return boton5;
	}

	/**
	 * @return the labelCola
	 */
	public JLabel getLabelTipo() {
		return labeliLista;
	}

	/**
	 * @return the labelEspacio
	 */
	public JLabel getLabelEspacio() {
		return labelEspacio;
	}

	/**
	 * @return the botonRegresar
	 */
	public JButton getBotonRegresar() {
		return botonRegresar;
	}

}
