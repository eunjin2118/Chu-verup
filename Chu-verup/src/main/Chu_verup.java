package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Chu_verup extends JFrame{
	private Image backgroundImage = new ImageIcon("src/image/mainScreen.png").getImage();
	private Image meet = new ImageIcon("src/image/meet.png").getImage();
	private Image mouse = new ImageIcon("src/image/mouse.png").getImage();
	
	// 입 좌표
	private int mouseX, mouseY;
	// 입과 고기의 충돌 여부 판단을 위한 각 이미지의 크기
	private int mouseWidth = meet.getWidth(null);
	private int mouseHeight = meet.getHeight(null);
	
	// 고기 좌표
	private int meetX, meetY;
	// 입과 고기의 충돌 여부 판단을 위한 각 이미지의 크기
	private int meetWidth = meet.getWidth(null);
	private int meetHeight = meet.getHeight(null);
	
	// 점수
	private int score;
	
	// 키보드의 움직임을 받는 변수
	private boolean up, down, left, right;

	public Chu_verup() {
		setTitle("고기 먹기 게임");
		setVisible(true);
		setSize(1200, 900);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
		
	}
	
	// 게임 시작할 때 초기화 하는 메소드
	public void init() {
		score = 0; 
		
		mouseX = (1200 - mouseWidth)/2;
		mouseY = (900 - mouseHeight)/2;
		
		meetX = (int)(Math.random()*(1200-mouseWidth));
		meetY = (int)(Math.random()*(900-mouseHeight));
	}
	
	public void paint(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, null);
		g.drawImage(meet, meetX, meetY, null);
		g.drawImage(mouse, mouseX, mouseX, null);
		// 점수
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.drawString("Score : "+score , 900, 80);
	}
	
	
	public static void main(String args[]) {
		new Chu_verup();
	}

}
