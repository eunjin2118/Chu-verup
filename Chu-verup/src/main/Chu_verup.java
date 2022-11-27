package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class Chu_verup extends JFrame{
	private Image bufferImage;
	private Graphics screenGraphics;
	
	Image backgroundImage = new ImageIcon("src/image/mainScreen.png").getImage();
	private Image mouse = new ImageIcon("src/image/mouse.png").getImage();
	private Image meet = new ImageIcon("src/image/meet.png").getImage();
	
	// 입의 좌표
	private int mouseX = 600;
	private int mouseY = 450;
	// 입과 고기의 충돌 여부 판단을 위한 각 이미지의 크기
	private int mouseWidth = mouse.getWidth(null);
	private int mouseHeight = mouse.getHeight(null);

	// 고기 좌표
	private int meetX = (int)(Math.random()*(901-mouseWidth-250))+250;
	private int meetY = (int)(Math.random()*(651-mouseHeight-190))+190;
	// 입과 고기의 충돌 여부 판단을 위한 각 이미지의 크기
	private int meetWidth = meet.getWidth(null);
	private int meetHeight = meet.getHeight(null);
		
	// 점수
	private int score;
	
	// 키보드의 움직임을 받는 변수
	private boolean up, down, left, right;
	
	private Timer timer;
	private Timer gameOverTimer;
	private int time = 3;
	
	Chu_verup() {
		setTitle("게임 화면");
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				screenDraw(g);
			}
		};
		
		setSize(1200, 900);
		
		add(panel);
		
		Dimension frameSize = getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2); //화면 중앙에 띄우기
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
		
        addKeyListener(new KeyAdapter() {
			// 키를 눌렀을 때 실행 할 메소드
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()){
				case KeyEvent.VK_W:
					up = true;
					break;
				case KeyEvent.VK_S:
					down = true;
					break;
				case KeyEvent.VK_A:
					left = true;
					break;
				case KeyEvent.VK_D:
					right = true;
					break;
				}
			}
				
			// 키를 뗏을 떄 실행할 메소드
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()){
				case KeyEvent.VK_W:
					up = false;
					break;
				case KeyEvent.VK_S:
					down = false;
					break;
				case KeyEvent.VK_A:
					left = false;
					break;
				case KeyEvent.VK_D:
					right = false;
					break;
				}
			}
		});
		
		
		timer = new Timer(10, (e) -> {
			keyProcess();
		});
		
		gameOverTimer = new Timer(1000, (e) -> {
			if(time == 0) {
				new ExplainFrame();
				setVisible(false);
			}
			time--;
		});
		
		gameOverTimer.start();
		timer.start();
	}
	
	// 게임시작할 때 초기화
	public void init() {
		score = 0;
		
		mouseY = (900 - mouseHeight)/2;
		
		//( 창의크기+1)-이미지의 길이
		meetX = (int)(Math.random()*(901-mouseWidth-250))+250;
		meetY = (int)(Math.random()*(651-mouseHeight-190))+190;	// 점수 초기화, 플레이어와 코인 위치 설정
									// 최대값 - 최소값))+최소값
		System.out.println("고기 X좌표 : " + meetX + " 고기 Y좌표 : " + meetY);
	}
	
	// up, down, left, right의 boolean값으로 플레이어를 이동시킬 메소드
	public void keyProcess() {
		if(up && mouseY - 3 > 180) mouseY -=5;
		if(down && mouseY + mouseHeight + 3 < 800) mouseY+=5;
		if(left && mouseX -3 > 220) mouseX -=5;
		if(right && mouseX + mouseWidth + 3 < 1000) mouseX+=5;
		
		crashCheck();
	}
	
	// 플레이어와 코인이 닿았을 때 점수 획득 메소드
	public void crashCheck() {
		if (mouseX + mouseWidth > meetX+ 70 && 
				meetX + meetWidth > mouseX+70 && 
				mouseY + mouseHeight > meetY+70 && 
				meetY + meetHeight > mouseY+70) {
			score+=100;
			
			meetX = (int)(Math.random()*(901-mouseWidth-250))+250;
			meetY = (int)(Math.random()*(651-mouseHeight-190))+190;
			System.out.println("고기 X좌표 : " + meetX + " 고기 Y좌표 : " + meetY);
		}
	}
	

	// 화면 깜빡임을 위한 더블 버퍼링 기법 사용
	public void paint(Graphics g) {
		// 화면 크기의 버퍼 이미지를 생성하고 getGraphics()를 통해 그래픽을 받아옴
		bufferImage = createImage(1200, 900);
		screenGraphics = bufferImage.getGraphics();
		// 다시한번 호출하고 버퍼 이미지를 화면에 그려주기
		screenDraw(screenGraphics);
		g.drawImage(bufferImage, 0,0,null);
	}
	
	
	
	public void screenDraw(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, null);
		g.drawImage(meet, meetX, meetY, null);
		g.drawImage(mouse, mouseX, mouseY, null);
		// 점수
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.drawString("SCORE : " + score, 900, 80);
		g.drawString("TIMER : " + time, 100, 80);
		repaint();
	}
	public static void main(String[] args) {
		new Chu_verup();
	}

}
