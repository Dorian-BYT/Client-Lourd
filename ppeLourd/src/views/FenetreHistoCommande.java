package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreHistoCommande extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnSearch;
	private JTextField txtSearch;
	private JLabel lblCommande;
	private JButton btnAccueil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreHistoCommande frame = new FenetreHistoCommande();
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
	public FenetreHistoCommande() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(70, 130, 180));
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		panel_1.add(lblNewLabel);
		
		lblCommande = new JLabel("Historique :");
		lblCommande.setForeground(Color.WHITE);
		panel_1.add(lblCommande);
		
		txtSearch = new JTextField();
		txtSearch.setText("Rechercher un login");
		panel_1.add(txtSearch);
		txtSearch.setColumns(10);
		
		btnSearch = new JButton("Rechercher");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnSearch);
		
		btnAccueil = new JButton("Accueil");
		btnAccueil.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(btnAccueil);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
	}

	
	public JTable getTable() {
		return table;
	}

	public JTextField getTxtSearch() {
		return txtSearch;
	}
	public JButton getBtnSearch() {
		return btnSearch;
	}
	public JButton getBtnAccueil() {
		return btnAccueil;
	}
}