package iTrack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class SignInPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField passwordFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInPage frame = new SignInPage();
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
	public SignInPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(209, 100, 511, 384);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel iTrackBanner = new JLabel("iTrack");
		iTrackBanner.setVerticalAlignment(SwingConstants.CENTER);
		iTrackBanner.setHorizontalAlignment(SwingConstants.CENTER);
		iTrackBanner.setFont(new Font("Hardner", Font.PLAIN, 80));
		iTrackBanner.setForeground(new Color(255, 255, 255));
		iTrackBanner.setBounds(194, 36, 246, 66);
		panel.add(iTrackBanner);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldUsername.setBounds(86, 152, 346, 34);
		panel.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setFont(new Font("Poppins", Font.PLAIN, 12));
		passwordFieldPassword.setBounds(86, 237, 346, 34);
		panel.add(passwordFieldPassword);
		
		JLabel lblLogIn = new JLabel("sign in");
		lblLogIn.setBackground(Color.white);
		lblLogIn.setBounds(176, 306, 139, 30);
		lblLogIn.setOpaque(true);
		panel.add(lblLogIn);
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setForeground(Color.black);
		lblLogIn.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblLogIn.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogIn.setForeground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogIn.setForeground(Color.black);
			}
		});
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setBounds(86, 135, 150, 13);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblPassword.setBounds(86, 220, 150, 13);
		panel.add(lblPassword);
	}
}
