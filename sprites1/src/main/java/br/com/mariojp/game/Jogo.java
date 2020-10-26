package br.com.mariojp.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Jogo extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private Timer timer;
	private Nave nave;
	private final int DELAY = 10;
	
	private final int B_WIDTH = 800;
	private final int B_HEIGHT = 600;

	public Jogo() {
		initJogo();
	}

	private void initJogo() {
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		setDoubleBuffered(true);
		nave = new Nave();
		timer = new Timer(DELAY, this);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		desenhar(g);
		Toolkit.getDefaultToolkit().sync();
	}

	private void desenhar(Graphics g) {
		g.drawImage(nave.getImage(), nave.getX(), nave.getY(), this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		nave.move();
		repaint();
	}

	private class TAdapter extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			nave.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			nave.keyPressed(e);
		}
	}
}