package main;

import java.awt.Dimension;
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

public class ExplainFrame extends JFrame{
	ImageIcon startBtnImage = new ImageIcon("src/image/pepper.png");
	JButton startBtn = new JButton(startBtnImage);
	
	public ExplainFrame() {
		
		JPanel panel = new JPanel() {
			Image backgroundImage = new ImageIcon("src/image/explainbackground.png").getImage();
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
		
		panel.add(startBtn);
		setSize(1200, 900);
		add(panel);
		
		Dimension frameSize = getSize();
		 
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2); //화면 중앙에 띄우기
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
        startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Chu_verup();
				setVisible(false);
				
			}
		});
	}

	public static void main(String[] args) {
		new ExplainFrame();

	}

}
