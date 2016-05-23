package br.com.mariojp.basico1;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;

	public Principal() {
		initUI();
	}

	private void initUI() {

		add(new Jogo());

		setSize(250, 200);

		setTitle("Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Principal ex = new Principal();
				ex.setVisible(true);
			}
		});
	}

}
