package main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

class Rank extends JFrame {
	ImageIcon homeBtnImage = new ImageIcon("src/image/home.png");
	JButton homeBtn = new JButton(homeBtnImage);
	
	Rank() {
		// 뒷 배경
		JPanel panel = new JPanel() {
			Image backgroundImage = new ImageIcon("src/image/rankbackground.png").getImage();
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backgroundImage, 0, 0, null);
			}
		};
		setTitle("고기 츄베릅");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setLayout(null);
		homeBtn.setBounds(850, 680, 350, 215);
		homeBtn.setBorderPainted(false);
		homeBtn.setContentAreaFilled(false);
		homeBtn.setFocusPainted(false);
		homeBtn.setOpaque(false);

		panel.add(homeBtn);
		setSize(1200, 900);
		add(panel);
		
		Dimension frameSize = getSize();
		 
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2); //화면 중앙에 띄우기
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
        homeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Start();
				setVisible(false);
				
			}
		});
        

	}
}

public class RankFrame {

	public static void main(String[] args) {
		new Rank();

	}
}
