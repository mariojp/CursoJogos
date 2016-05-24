package br.com.mariojp.animacao2;

import java.awt.*;
import javax.swing.*;
import java.util.TimerTask;
import java.util.Timer;

public class Jogo extends JPanel  {


	private static final long serialVersionUID = 1L;
	private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;    
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;
    
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
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new Tarefa(), 
                INITIAL_DELAY, PERIOD_INTERVAL);        
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


    private class Tarefa extends TimerTask {

        @Override
        public void run() {
            x += 1;
            y += 1;

            if (y > B_HEIGHT) {
                y = INITIAL_Y;
                x = INITIAL_X;
            }
            
            repaint();
        }
    }
}
