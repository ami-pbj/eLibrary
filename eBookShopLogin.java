package eBookShop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class eBookShopLogin extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eBookShopLogin frame = new eBookShopLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public eBookShopLogin() {
		setAlwaysOnTop(true);
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 388);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(18, 68, 153, 237);
		contentPane.add(panel);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBackground(new Color(0, 128, 128));
		lblNewLabel_4.setIcon(new ImageIcon("/Users/purnendubikashjana/Downloads/D71536C8-00E8-4901-ABC0-67BF712701F5.JPEG"));
		panel.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.YELLOW);
		panel_2.setBounds(18, 6, 411, 50);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("e Book Shop");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBackground(Color.BLUE);
		panel_2.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(70, 130, 180));
		panel_1.setForeground(new Color(70, 130, 180));
		panel_1.setBounds(183, 73, 246, 43);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("e Login");
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Apple Chancery", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2 = new JLabel("User");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Apple Color Emoji", Font.BOLD, 14));
		lblNewLabel_2.setBounds(183, 144, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		user = new JTextField();
		user.setBounds(266, 139, 144, 26);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Apple Color Emoji", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(183, 188, 71, 16);
		contentPane.add(lblNewLabel_2_1);
		
		pass = new JPasswordField();
		pass.setBounds(266, 183, 144, 26);
		contentPane.add(pass);
		
		JLabel forgetpass = new JLabel("forget password? click here!");
		forgetpass.setHorizontalAlignment(SwingConstants.CENTER);
		forgetpass.setFont(new Font("Monospaced", Font.PLAIN, 10));
		forgetpass.setBounds(213, 277, 183, 16);
		contentPane.add(forgetpass);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setForeground(new Color(255, 255, 255));
		panel_1_1.setBackground(new Color(70, 130, 180));
		panel_1_1.setBounds(183, 226, 246, 39);
		contentPane.add(panel_1_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//work on login button 
				BookStore obj = new BookStore();
				obj.HomeStore.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(0, 0, 0));
		panel_1_1.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("//“The only thing that you absolutely have to know, is the");
		lblNewLabel_3.setFont(new Font("Monospaced", Font.PLAIN, 11));
		lblNewLabel_3.setForeground(new Color(176, 224, 230));
		lblNewLabel_3.setBackground(new Color(175, 238, 238));
		lblNewLabel_3.setBounds(18, 317, 411, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_2 = new JLabel("location of the library.” – ALBERT EINSTEIN.//");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Monospaced", Font.PLAIN, 11));
		lblNewLabel_3_2.setForeground(new Color(175, 238, 238));
		lblNewLabel_3_2.setBackground(new Color(175, 238, 238));
		lblNewLabel_3_2.setBounds(18, 334, 411, 16);
		contentPane.add(lblNewLabel_3_2);
	}
}
