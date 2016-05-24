package br.com.mariojp.basico3;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Jogo extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image salvador;

	public Jogo() {
		initJogo();
	}

	private void initJogo() {
		carregaImagem();
		int w = salvador.getWidth(this);
		int h = salvador.getHeight(this);
		setPreferredSize(new Dimension(w, h));
	}

	private void carregaImagem() {
        ImageIcon ii = new ImageIcon(getClass().getResource("/imagens/salvador.png"));
        salvador = ii.getImage();        
    }

	@Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
		desenhar(g);
	}

	private void desenhar(Graphics g) {
		g.drawImage(salvador, 0, 0, null);
	}
}