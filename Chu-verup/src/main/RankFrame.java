package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;


class Rank extends JFrame {
    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;

    Font font = new Font("Arial", Font.BOLD, 40);
   
	ImageIcon homeBtnImage = new ImageIcon("src/image/home.png");
	JButton homeBtn = new JButton(homeBtnImage);
	JTextArea txtResult = new JTextArea();
	
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
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/chu_verup";
            conn = DriverManager.getConnection(url, "root", "mirim");
            String SQL = "SELECT * FROM user order by u_score desc LIMIT 5";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);
            System.out.println("    ");
            
            while (rs.next()) { 
            	
            	String name = rs.getString("u_name"); 
            	int score = rs.getInt("u_score");
            	System.out.println(name + " " + score); 
            	panel.add(txtResult);
				txtResult.setVisible(true);
				txtResult.setBounds(370, 250, 1200, 900);
				txtResult.setOpaque(false);
				Color color = new Color(255, 255, 255);
				txtResult.setForeground(color);
				txtResult.setFont(font);
				
				String str = rs.getString("u_name") + "\t" + rs.getInt("u_score")+"  \n\n";  
				txtResult.append(str); 
				System.out.println(str);
				
            }
            

        }
        catch(ClassNotFoundException e1){
            System.out.println("");
        }
        catch(SQLException e1){
            System.out.println("    : " + e1);
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
            }
            catch( SQLException e1){
                e1.printStackTrace();
            }
        }

        
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
