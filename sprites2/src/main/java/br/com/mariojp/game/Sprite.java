package br.com.mariojp.game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Sprite {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected boolean visibilty;

	protected Image image;

	public Sprite(int x, int y) {
		this.x = x;
		this.y = y;
		visibilty = true;
	}

	protected void carregarImagem(String imageName) {
		ImageIcon ii = new ImageIcon(this.getClass().getResource(imageName)); 
		image = ii.getImage();
	}

	protected void getImageDimensions() {
		width = image.getWidth(null);
		height = image.getHeight(null);
	}

	public Image getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isVisible() {
		return visibilty;
	}

	public void setVisible(Boolean visible) {
		this.visibilty = visible;
	}
}
