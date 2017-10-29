package uniquindio.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import uniquindio.GUI.Ventana;
import uniquindio.bussines.Constantes;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * 
 * @author Gustavo Andres Ramirez Munoz--Ivan Santigo Castaneda
 *
 */
public class VentanaNuevoNodo implements ActionListener {

	private JPanel panelExterno;
	private JPanel panelInterno;
	private JTextField textField;
	private JLabel labelDato;
	private JButton botonAceptar;
	private JButton botonCancelar;
	private JLabel labelInfo;
	private JButton botonAleatorio;

	private String dato;
	private int opcionLista;
	private int opcionBoton;
	private Ventana ventanaPrincipal;

	private JFrame ventanaNodo;

	/**
	 * Create the frame.
	 */
	public VentanaNuevoNodo(Ventana ventanaPrincipal, int opcionlista, int opcionBoton) {

		ventanaNodo = new JFrame("");
		ventanaNodo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaNodo.setBounds(100, 100, 300, 150);
		panelExterno = new JPanel();
		panelExterno.setBorder(new EmptyBorder(10, 10, 10, 10));
		ventanaNodo.setContentPane(panelExterno);
		panelExterno.setLayout(null);
		panelExterno.setBackground(Constantes.COLORBOTON);

		{
			panelInterno = new JPanel();
			panelInterno.setBounds(5, 5, 290, 140);
			panelExterno.add(panelInterno);
			panelInterno.setLayout(null);

			labelDato = new JLabel("");
			labelDato.setBounds(0, 5, 290, 35);
			panelInterno.add(labelDato);
			labelDato.setHorizontalAlignment(SwingConstants.CENTER);
			labelDato.setFont(Constantes.FUENTE);

			textField = new JTextField();
			textField.setBounds(116, 45, 120, 35);
			textField.setFont(Constantes.FUENTE);
			panelInterno.add(textField);
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setColumns(10);

			labelInfo = new JLabel("Ingrese numeros");
			labelInfo.setHorizontalAlignment(SwingConstants.CENTER);
			labelInfo.setForeground(Color.RED);
			labelInfo.setBounds(85, 75, 120, 22);
			labelInfo.setVisible(false);
			panelInterno.add(labelInfo);

			botonAceptar = new JButton("Aceptar");
			botonAceptar.setBounds(15, 100, 120, 33);
			panelInterno.add(botonAceptar);
			botonAceptar.setFont(Constantes.FUENTE);
			botonAceptar.setForeground(Constantes.COLORLETRA);
			botonAceptar.setBackground(Constantes.COLORBOTON);
			botonAceptar.addActionListener(this);

			botonCancelar = new JButton("Cancelar");
			botonCancelar.setBounds(155, 100, 120, 33);
			panelInterno.add(botonCancelar);
			botonCancelar.addActionListener(this);
			botonCancelar.setFont(Constantes.FUENTE);
			botonCancelar.setForeground(Constantes.COLORLETRA);
			botonCancelar.setBackground(Constantes.COLORBOTON);

			botonAleatorio = new JButton("R");
			botonAleatorio.setBounds(49, 45, 45, 35);
			botonAleatorio.addActionListener(this);
			botonAleatorio.setBackground(Constantes.COLORBOTON);
			botonAleatorio.setForeground(Constantes.COLORLETRA);
			panelInterno.add(botonAleatorio);
		}

		ventanaNodo.setLocationRelativeTo(null);
		ventanaNodo.setUndecorated(true);
		ventanaNodo.setVisible(true);
		ventanaNodo.setAlwaysOnTop(true);

		this.ventanaPrincipal = ventanaPrincipal;

		this.opcionLista = opcionlista;
		this.opcionBoton = opcionBoton;
		dato = "";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ventanaPrincipal.setVentanaActiva(true);
		if (e.getSource() == botonAceptar) {
		
			if (opcionBoton == 1) {
				añadir();
			}
			if (opcionBoton == 2) {
				contains();
			}
		}

		if (e.getSource() == botonCancelar) {
			ventanaNodo.dispose();
		}
		if (e.getSource() == botonAleatorio) {
			textField.setText("" + (int) (Math.random() * 100) + 1);
		}

	}

	public boolean isNumeric(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * 
	 */
	public void añadir() {
		dato = textField.getText();

		if (isNumeric(dato)) {
			textField.setText("");
			ventanaNodo.dispose();
			ventanaPrincipal.añadirNodo(Integer.parseInt(dato), opcionLista);

		} else {
			labelInfo.setVisible(true);

		}

	}

	public void contains() {
		dato = textField.getText();

		if (isNumeric(dato)) {
			textField.setText("");
			ventanaNodo.dispose();
			ventanaPrincipal.constains(dato, opcionLista);

		} else {
			labelInfo.setVisible(true);

		}

	}

	/**
	 * @return the textField
	 */
	public JTextField getTextField() {
		return textField;
	}

	/**
	 * @return the labelDato
	 */
	public JLabel getLabelDato() {
		return labelDato;
	}

	/**
	 * @return the botonAceptar
	 */
	public JButton getBotonAceptar() {
		return botonAceptar;
	}

	/**
	 * @return the botonCancelar
	 */
	public JButton getBotonCancelar() {
		return botonCancelar;
	}

	/**
	 * @return the labelInfo
	 */
	public JLabel getLabelInfo() {
		return labelInfo;
	}

	/**
	 * @return the botonAleatorio
	 */
	public JButton getBotonAleatorio() {
		return botonAleatorio;
	}

	/**
	 * @return the dato
	 */
	public String getDato() {
		return dato;
	}

	/**
	 * @return the opcion
	 */
	public int getOpcion() {
		return opcionLista;
	}

	/**
	 * @return the ventanaNodo
	 */
	public JFrame getVentanaNodo() {
		return ventanaNodo;
	}

	/**
	 * @return the ventanaPrincipal
	 */
	public Ventana getVentanaPrincipal() {
		return ventanaPrincipal;
	}

}
