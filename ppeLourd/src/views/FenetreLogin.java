package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class FenetreLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField usernameField;
	private JLabel validation;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreLogin frame = new FenetreLogin();
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
	public FenetreLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 411);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dialog", Font.BOLD, 15));
		passwordField.setForeground(new Color(70, 130, 180));
		passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		passwordField.setBounds(161, 163, 286, 34);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Dialog", Font.BOLD, 15));
		usernameField.setForeground(new Color(70, 130, 180));
		usernameField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		usernameField.setBounds(161, 107, 286, 38);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblConnexion = new JLabel("Connexion");
		lblConnexion.setFont(new Font("Dialog", Font.BOLD, 20));
		lblConnexion.setForeground(new Color(255, 255, 255));
		lblConnexion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnexion.setBounds(161, 78, 286, 17);
		contentPane.add(lblConnexion);
		
		validation = new JLabel("");
		validation.setForeground(new Color(255, 0, 0));
		validation.setBounds(161, 195, 286, 17);
		contentPane.add(validation);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(245, 217, 139, 34);
		contentPane.add(btnLogin);
	}
	public JTextField getUsernameField() {
		return usernameField;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JLabel getValidation() {
		return validation;
	}
	public JButton getBtnLogin() {
		return btnLogin;
	}
}
