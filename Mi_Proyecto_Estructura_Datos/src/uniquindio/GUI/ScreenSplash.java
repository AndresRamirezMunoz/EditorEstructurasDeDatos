package uniquindio.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uniquindio.bussines.Constantes;

import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

/*
 * 
 */
public class ScreenSplash implements Runnable {

	/**
	 * 
	 */
	private JFrame ventana;
	private JPanel panel;
	private JProgressBar progressBar;
	private JLabel labelFondo;
	private JLabel labelInfo;
	private String[] datos = "Iniciando modulos de arranque...,Cargando datos graficos...,Cargando valores...,Cargando estructuras de datos...,Cargando el ki!...,Kame Kame Haaaa!...,Abriendo editor...,Iniciando interfaz... "
			.split(",");
	private JLabel labelTitulo;

	/**
	 * Create the frame.
	 */
	public ScreenSplash() {

		ventana = new JFrame("");
		ventana.setIconImage(Toolkit.getDefaultToolkit().getImage(ScreenSplash.class.getResource("/res/icono.png")));
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setBounds(100, 100, 600, 400);
		ventana.setUndecorated(true);
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		ventana.getContentPane().add(panel);

		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);

		// setResizable(false);

		labelFondo = new JLabel("");
		labelFondo.setIcon(new ImageIcon(ScreenSplash.class.getResource("/res/java1.png")));
		labelFondo.setBackground(Color.LIGHT_GRAY);
		labelFondo.setBounds(180, 0, 250, 250);
		panel.add(labelFondo);
		
		labelTitulo = new JLabel("Editor de estructuras de datos.");
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelTitulo.setBounds(150, 261, 300, 28);
		panel.add(labelTitulo);

		progressBar = new JProgressBar();
		progressBar.setMaximum(102);
		progressBar.setForeground(Constantes.COLORBOTON);
		progressBar.setBounds(150, 300, 300, 30);
		panel.add(progressBar);

		labelInfo = new JLabel("");
		labelInfo.setBounds(160, 339, 290, 26);
		panel.add(labelInfo);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

	}

	@Override
	public void run() {

		int n = 0;
		int pos = 0;

		while (true) {
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			progressBar.setValue(n);
			n = progressBar.getValue()+1;
			if (n == 12 || n == 24 || n == 36 || n == 48 || n == 60 || n == 72 || n == 84 || n == 96) {
				if (pos != 7)
					pos++;
			}
			labelInfo.setText(datos[pos]);
			if (n > 100) {
				ventana.dispose();
				new Ventana().run();;
			}

		}

	}
}
