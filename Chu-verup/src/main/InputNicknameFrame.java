package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class InputNicknameFrame extends JFrame {
	JButton bt;
	JTextField name;

	public static void main(String[] args) {
		new InputNicknameFrame();

	}

	public InputNicknameFrame() {
		JPanel panel = new JPanel() {
			Image backgroundImage = new ImageIcon("src/image/inputnicknamebackground.png").getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backgroundImage, 0, 0, null);
			}
		};
		setTitle("고기 츄베릅");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.setLayout(null);

		panel.add(new JLabel("  이름 :"));
		name = new JTextField(20);
		System.out.println("inputname" + name.getText());
		name.setBounds(162, 450, 901, 100);

		bt = new JButton(new ImageIcon("src/image/ok.png"));
		bt.setBounds(970, 700, 200, 150);

		bt.setContentAreaFilled(false);
		bt.setFocusPainted(false);
		bt.setOpaque(false);
		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Chu_verup(name.getText());
				setVisible(false);
			}
		});

		add(bt);
		panel.add(name);
		setSize(1200, 900);
		add(panel);

		Dimension frameSize = getSize();

		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2); // 화면 중앙에 띄우기
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);

		bt.addActionListener(new Listener(this));

	}

	class Listener implements ActionListener {
		JFrame frame;

		public Listener(JFrame f) {
			frame = f;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// 버튼을 누르면 이쪽으로 제어가 이동
			System.out.println(arg0.getActionCommand());
			String n = name.getText();
			System.out.println(n);

			// 다이얼로그
			JOptionPane.showMessageDialog(frame, n, "확인을 누르면 게임이 시작됩니다!", JOptionPane.INFORMATION_MESSAGE);
		}

	}
}
