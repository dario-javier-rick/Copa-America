package Recursos;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Fondo extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Fondo() {
		this.setSize(400, 280);
	}

	@Override
	public void paintComponent(Graphics g) {
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource(
				"/Recursos/FondoAzul.jpg"));
		g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width,
				tamanio.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}