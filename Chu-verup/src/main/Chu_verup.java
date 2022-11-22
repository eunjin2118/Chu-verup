package main;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Chu_verup extends JFrame{
	private Image backgroundImage = new ImageIcon("src/image/mainScreen.png").getImage();
	private Image meet = new ImageIcon("src/image/meet.png").getImage();
	private Image mouse = new ImageIcon("src/image/mouse.png").getImage();
	
	public Chu_verup() {
		setTitle("고기 먹기 게임");
		setVisible(true);
		setSize(1200, 900);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public void paint(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, null);
	}
	
	
	public static void main(String args[]) {
		new Chu_verup();
	}

}
