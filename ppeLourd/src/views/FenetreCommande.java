package views;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;

public class FenetreCommande extends JFrame {

	private JPanel contentPane;
	private JTextField textPrix;
	private JTable tableauCommander;
	private JScrollPane scrollPane;
	private JButton btnValider;
	private JLabel lblQuantit;
	private JTextField textQuantite;
	private JButton btnAccueil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreCommande frame = new FenetreCommande();
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
	public FenetreCommande() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 404);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblCommander = new JLabel("Commander");
		lblCommander.setForeground(new Color(255, 255, 255));
		lblCommander.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(lblCommander);
		
		btnAccueil = new JButton("Accueil");
		btnAccueil.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(btnAccueil);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(70, 130, 180));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		lblQuantit = new JLabel("Quantité");
		lblQuantit.setForeground(new Color(255, 255, 255));
		lblQuantit.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblQuantit);
		
		textQuantite = new JTextField();
		textQuantite.setName("quantite");
		panel_1.add(textQuantite);
		textQuantite.setColumns(10);
		
		JLabel lblPrix = new JLabel("Prix (€):");
		lblPrix.setForeground(new Color(255, 255, 255));
		lblPrix.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblPrix);
		
		textPrix = new JTextField();
		textPrix.setName("prix");
		panel_1.add(textPrix);
		textPrix.setColumns(10);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnValider.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(btnValider);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tableauCommander = new JTable();
		scrollPane.setViewportView(tableauCommander);
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public JTextField getTextPrix() {
		return textPrix;
	}
	public JButton getBtnValider() {
		return btnValider;
	}
	public JTable getTableauCommander() {
		return tableauCommander;
	}
	public JTextField getTextQuantite() {
		return textQuantite;
	}
	public JButton getBtnAccueil() {
		return btnAccueil;
	}
}
