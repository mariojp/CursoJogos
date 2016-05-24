package br.com.mariojp.animacao1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Jogo extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final int B_WIDTH = 350;
	private final int B_HEIGHT = 350;
	private final int INITIAL_X = -40;
	private final int INITIAL_Y = -40;
	private final int DELAY = 25;

	private Image estrela;
	private Timer timer;
	private int x, y;

	public Jogo() {
		initJogo();
	}

	private void carregaImagem() {
		ImageIcon ii = new ImageIcon(getClass().getResource("/imagens/estrela.png"));
		estrela = ii.getImage();
	}

	private void initJogo() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		setDoubleBuffered(true);
		carregaImagem();
		x = INITIAL_X;
		y = INITIAL_Y;
		timer = new Timer(DELAY, this);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		desenhar(g);
	}

	private void desenhar(Graphics g) {
		g.drawImage(estrela, x, y, this);
		Toolkit.getDefaultToolkit().sync();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		x += 1;
		y += 1;
		if (y > B_HEIGHT) {
			y = INITIAL_Y;
			x = INITIAL_X;
		}
		repaint();
	}
}