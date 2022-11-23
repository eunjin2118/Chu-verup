package main;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.*;

class Start extends JFrame {
	// 뒷 배경
	Image backgroundImage = new ImageIcon("src/image/startbackground.png").getImage();
	// 버튼 이미지
	ImageIcon startBtnImage = new ImageIcon("src/image/pepper.png");

	Start() {
		this.setTitle("고기 츄베릅");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyPanel panel = new MyPanel();
		panel.setLayout(null);
		JButton startBtn = new JButton(startBtnImage);
		startBtn.setBounds(890, 630, startBtnImage.getIconWidth(), startBtnImage.getIconHeight());
		startBtn.setBorderPainted(false);
		startBtn.setContentAreaFilled(false);
		startBtn.setFocusPainted(false);
		startBtn.setOpaque(false);
		panel.add(startBtn);

		// add( setBounds(btnLogin, 200, 40, 80, 70) );
		this.add(panel);
		this.setSize(1200, 900);
		this.setVisible(true);
	}


	class MyPanel extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		}
	}
}

public class StartFrame {
	public static void main(String[] args) {
		System.out.println("gd");
		new Start();
	}
}