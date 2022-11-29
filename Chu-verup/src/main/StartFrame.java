package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

class Start extends JFrame {

	// 버튼 이미지
	ImageIcon startBtnImage = new ImageIcon("src/image/pepper.png");
	ImageIcon explainBtnImage = new ImageIcon("src/image/lettuce.png");
	JButton startBtn = new JButton(startBtnImage);
	JButton explainBtn = new JButton(explainBtnImage);

	Start() {

		// 뒷 배경
		JPanel panel = new JPanel() {

			Image backgroundImage = new ImageIcon("src/image/startbackground.png").getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backgroundImage, 0, 0, null);
			}
		};
		setTitle("고기 츄베릅");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.setLayout(null);
		startBtn.setBounds(890, 630, startBtnImage.getIconWidth(), startBtnImage.getIconHeight());
		startBtn.setBorderPainted(false);
		startBtn.setContentAreaFilled(false);
		startBtn.setFocusPainted(false);
		startBtn.setOpaque(false);
		explainBtn.setBounds(0, 630, explainBtnImage.getIconWidth(), explainBtnImage.getIconHeight());
		explainBtn.setBorderPainted(false);
		explainBtn.setContentAreaFilled(false);
		explainBtn.setFocusPainted(false);
		explainBtn.setOpaque(false);
		panel.add(explainBtn);
		panel.add(startBtn);
		setSize(1200, 900);
		add(panel);

		Dimension frameSize = getSize();

		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2); // 화면 중앙에 띄우기
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);

		startBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ExplainFrame();
				setVisible(false);

			}
		});

		explainBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ExplainFrame();
				setVisible(false);

			}
		});

	}

}

public class StartFrame {
	public static void main(String[] args) {
		playMusic();
		new Start();

	}

	private static void playMusic() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;

		bgm = new File("audio/backgroundMusic.wav");
		Clip clip;

		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
		} catch (Exception e) {
			System.out.println("err" + e);
		}
	}
}
