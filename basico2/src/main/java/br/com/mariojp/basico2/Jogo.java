package br.com.mariojp.basico2;

import java.awt.*;
import java.awt.geom.*;


import javax.swing.JPanel;

import static java.awt.RenderingHints.*;
public class Jogo extends JPanel {

	private static final long serialVersionUID = 1L;

	public Jogo() {
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		desenhar(g);
	}

	private void desenhar(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);

		rh.put(KEY_RENDERING, VALUE_RENDER_QUALITY);

		g2d.setRenderingHints(rh);

		Dimension size = getSize();
		double w = size.getWidth();
		double h = size.getHeight();

		Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.gray);

		for (double deg = 0; deg < 360; deg += 5) {
			AffineTransform at = AffineTransform.getTranslateInstance(w / 2, h / 2);
			at.rotate(Math.toRadians(deg));
			g2d.draw(at.createTransformedShape(e));
		}
	}

}