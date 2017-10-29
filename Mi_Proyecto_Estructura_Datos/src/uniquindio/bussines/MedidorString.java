package uniquindio.bussines;

import java.awt.FontMetrics;
import java.awt.Graphics;
/**
 * 
 * @author Gustavo Andres Ramirez Munoz--Ivan Santigo Castaneda
 *
 */
public class MedidorString {
	/**
	 * calcula el ancho se un string en pixeles
	 * 
	 * @param g
	 *            grafico que dibuja
	 * @param s
	 *            string a medir
	 * @return string medido
	 */
	public static int medirAnchoPixeles(final Graphics g, final String s) {

		FontMetrics fm = g.getFontMetrics();

		return fm.stringWidth(s);
	}

	/**
	 * calcula el alto se un string en pixeles
	 * 
	 * @param g
	 *            grafico que dibuja
	 * @param s
	 *            string a medir
	 * @return string medido
	 */
	public static int medirAltoPixeles(final Graphics g, final String s) {

		FontMetrics fm = g.getFontMetrics();
		return (int) fm.getLineMetrics(s, g).getHeight() + 1;
	}

}
