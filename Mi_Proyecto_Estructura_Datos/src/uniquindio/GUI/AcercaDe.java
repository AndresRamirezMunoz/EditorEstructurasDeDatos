package uniquindio.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import uniquindio.bussines.Constantes;
import javax.swing.SwingConstants;

public class AcercaDe extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String DATOS_1 = "<html> Teclas<br><br>Shift+A---- Agregar<br>Shift+R---- Remover </html>";
	private final String DATOS_2 = "<html> Editor de estrcuturas de datos en los cual se puede ver el funcionamiento de los metodos sencillos de algunas de las estrcutras de datos. Se pueden crear y modificar varios tipos de estructuras de datos mediante el entorno grafico que brinda este programa.<br><br>Creado por:<br><br>Ivan Santiago Catañeda<br>Gustavo Andres Ramirez </html>";

	private JPanel panelInterno1;
	private JPanel panelInterno2;
	private JPanel panelExterno;
	private JPanel panelBoton;
	private JButton botonDesarroladores;
	private JButton botonAceptar;

	/**
	 * Create the dialog.
	 */
	public AcercaDe(JFrame ventana) {
		super(ventana, true);
		setUndecorated(true);

		setBounds(0, 0, 660, 300);
		getContentPane().setLayout(null);

		panelExterno = new JPanel();
		panelExterno.setBounds(0, 0, 660, 300);
		panelExterno.setBackground(Constantes.COLORBOTON);

		getContentPane().add(panelExterno);
		panelExterno.setLayout(null);
		{
			panelInterno1 = new JPanel();
			panelInterno1.setBounds(5, 5, 650, 240);
			panelInterno1.setBorder(new EmptyBorder(5, 5, 5, 5));
			panelInterno1.setLayout(null);
			panelExterno.add(panelInterno1);

			JLabel labelInfo1 = new JLabel(DATOS_1);
			labelInfo1.setHorizontalAlignment(SwingConstants.CENTER);
			labelInfo1.setFont(Constantes.FUENTE);
			labelInfo1.setBounds(29, 27, 557, 183);
			panelInterno1.add(labelInfo1);

		}
		{
			panelInterno2 = new JPanel();
			panelInterno2.setBounds(5, 5, 650, 240);
			panelExterno.add(panelInterno2);
			panelInterno2.setLayout(null);

			JLabel lblNewLabel = new JLabel(DATOS_2);
			lblNewLabel.setBounds(29, 27, 557, 183);
			panelInterno2.add(lblNewLabel);
			panelInterno2.setVisible(false);
		}

		{
			panelBoton = new JPanel();
			panelBoton.setBounds(5, 243, 650, 52);
			panelExterno.add(panelBoton);
			panelBoton.setLayout(null);

			botonAceptar = new JButton("Aceptar");
			botonAceptar.setBounds(227, 10, 130, 30);
			botonAceptar.setForeground(Constantes.COLORLETRA);
			botonAceptar.setBackground(Constantes.COLORBOTON);
			botonAceptar.setFont(Constantes.FUENTE);
			botonAceptar.addActionListener(this);
			panelBoton.add(botonAceptar);

			botonDesarroladores = new JButton("!");
			botonDesarroladores.addActionListener(this);
			botonDesarroladores.setBounds(582, 10, 50, 30);
			botonDesarroladores.setForeground(Constantes.COLORLETRA);
			botonDesarroladores.setBackground(Constantes.COLORBOTON);
			botonDesarroladores.setFont(Constantes.FUENTE);
			panelBoton.add(botonDesarroladores);
		}
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (botonAceptar == arg0.getSource()) {
			dispose();
		}
		if (botonDesarroladores == arg0.getSource()) {
			panelInterno1.setVisible(!panelInterno1.isVisible());
			panelInterno2.setVisible(!panelInterno2.isVisible());
		}

	}
}
