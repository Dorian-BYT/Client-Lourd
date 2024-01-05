package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class FenetreAccueil extends JFrame {

	private JPanel contentPane;
	private JButton btnProfil;
	private JButton btnMedicaments;
	private JButton btnStocks;
	private JButton btnExpirations;
	private JButton btnCommander;
	private JButton btnDeconnexion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAccueil frame = new FenetreAccueil();
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
	public FenetreAccueil() {
		setForeground(new Color(70, 130, 180));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setForeground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccueil = new JLabel("Accueil");
		lblAccueil.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAccueil.setForeground(new Color(255, 255, 255));
		lblAccueil.setBounds(177, 27, 92, 17);
		contentPane.add(lblAccueil);
		
		btnCommander = new JButton("Historique");
		btnCommander.setBounds(250, 161, 128, 27);
		contentPane.add(btnCommander);
		
		btnMedicaments = new JButton("Medicaments");
		btnMedicaments.setBounds(57, 100, 139, 27);
		contentPane.add(btnMedicaments);
		
		btnProfil = new JButton("Profil");
		btnProfil.setBounds(362, 12, 66, 27);
		contentPane.add(btnProfil);
		
		btnStocks = new JButton("Stocks");
		btnStocks.setBounds(250, 100, 128, 27);
		contentPane.add(btnStocks);
		
		btnExpirations = new JButton("Expirations");
		btnExpirations.setBounds(57, 161, 139, 27);
		contentPane.add(btnExpirations);
		
		btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.setBounds(300, 227, 128, 27);
		contentPane.add(btnDeconnexion);
	}
	public JButton getBtnProfil() {
		return btnProfil;
	}
	public JButton getBtnMedicaments() {
		return btnMedicaments;
	}
	public JButton getBtnStocks() {
		return btnStocks;
	}
	public JButton getBtnExpirations() {
		return btnExpirations;
	}
	public JButton getBtnCommander() {
		return btnCommander;
	}
	public JButton getBtnDeconnexion() {
		return btnDeconnexion;
	}
}
