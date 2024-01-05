package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class FenetreProfil extends JFrame {

	private JPanel contentPane;
	private JButton btnAcceuil;
	private JLabel Prenom;
	private JLabel nom;
	private JLabel adresse;
	private JLabel tel;
	private JLabel role;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreProfil frame = new FenetreProfil();
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
	public FenetreProfil() {
		setBackground(new Color(70, 130, 180));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProfilDe = new JLabel("Mon profil");
		lblProfilDe.setFont(new Font("Dialog", Font.BOLD, 16));
		lblProfilDe.setForeground(new Color(255, 255, 255));
		lblProfilDe.setBounds(138, 12, 112, 17);
		contentPane.add(lblProfilDe);
		
		btnAcceuil = new JButton("Acceuil");
		btnAcceuil.setBounds(313, 9, 103, 27);
		contentPane.add(btnAcceuil);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setForeground(new Color(255, 255, 255));
		lblNom.setBounds(12, 47, 46, 17);
		contentPane.add(lblNom);
		
		JLabel lblPrnon = new JLabel("Prénom :");
		lblPrnon.setForeground(Color.WHITE);
		lblPrnon.setBounds(12, 77, 59, 17);
		contentPane.add(lblPrnon);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setForeground(Color.WHITE);
		lblAdresse.setBounds(12, 106, 59, 17);
		contentPane.add(lblAdresse);
		
		JLabel lblNewLabel = new JLabel("Telephone :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 135, 82, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblRole = new JLabel("Role :");
		lblRole.setForeground(Color.WHITE);
		lblRole.setBounds(12, 164, 59, 17);
		contentPane.add(lblRole);
		
		Prenom = new JLabel("");
		Prenom.setForeground(Color.WHITE);
		Prenom.setBounds(72, 77, 148, 17);
		contentPane.add(Prenom);
		
		adresse = new JLabel("");
		adresse.setForeground(Color.WHITE);
		adresse.setBounds(81, 106, 169, 17);
		contentPane.add(adresse);
		
		tel = new JLabel("");
		tel.setForeground(Color.WHITE);
		tel.setBounds(91, 135, 159, 17);
		contentPane.add(tel);
		
		role = new JLabel("");
		role.setForeground(Color.WHITE);
		role.setBounds(51, 164, 59, 17);
		contentPane.add(role);
		
		nom = new JLabel("");
		nom.setForeground(Color.WHITE);
		nom.setBounds(58, 47, 131, 17);
		contentPane.add(nom);
	}


	public JButton getBtnAcceuil() {
		return btnAcceuil;
	}
	public JLabel getPrenom() {
		return Prenom;
	}
	public JLabel getNom() {
		return nom;
	}
	public JLabel getAdresse() {
		return adresse;
	}
	public JLabel getTel() {
		return tel;
	}
	public JLabel getRole() {
		return role;
	}
}
