package com.btssio.graphique;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.btssio.convertisseurs.ConvertisseurTVA;

public class JFconvertisseurTVA extends JFrame {

	private JPanel contentPane;
	private JTextField textHT;
	private JTextField textTTC;
	private JTextField textTVA;
	private ConvertisseurTVA convertisseur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				// essai de démarage
				try {
					// création d'une frame
					JFconvertisseurTVA frame = new JFconvertisseurTVA();
					// visibilité de la frame
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public void init() {
		// on prends tous les composants
		for (Component comp : contentPane.getComponents()) {
			// si c'est un champ textuel
			if (comp instanceof JTextField)
				// on set la valeur à null pour qu'ils soient vide
				((JTextField) comp).setText(null);
		}

		JOptionPane.showMessageDialog(textTVA, "Vous devez initialiser le taux de TVA ");
		textTVA.requestFocus();

	}

	public void changementTauxTva() {
		try {
			// on prend le taux de TVA
			double tva = Double.parseDouble(textTVA.getText());
			// on l'arrondit à 0.0

			if (tva > 1 || tva < 0)
				textTVA.setText("0");
			else
				textTVA.setText(String.format("%.2f", tva));

			// On initialise via le constructeur un nouveau convertisseur
			convertisseur = new ConvertisseurTVA(tva);
			// on met le focus sur le textHT
			textHT.requestFocus();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(textTVA, "Vous devez saisir un nombre");
			textTVA.setText("");
		}
	}

	public void calculTTC() {

		try {
			// on prends la valeur sur le champ de text
			double HT = Double.parseDouble(textHT.getText());
			// on converti en TTC la valeur saisi
			double montant = convertisseur.convertirEnTTC(HT);
			// on met au format 0.0 le montant en TTC
			textTTC.setText(String.format("%.2f", montant));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(textTVA, "Vous devez saisir un nombre");
			textTVA.setText("");
		}

	}

	public void calculHT() {
		try {
			// on prends la valeur sur le champ de text
			double TTC = Double.parseDouble(textTTC.getText());
			// on converti en TTC la valeur saisi
			double montant = convertisseur.convertirEnHT(TTC);
			// on met au format 0.0 le montant en TTC
			textHT.setText(String.format("%.2f", montant));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(textTVA, "Vous devez saisir un nombre");
			textTVA.setText("");
		}
	}

	private void nettoyage(MouseEvent e) {
		// on prends la source sur laquelle on a cliqué grâce aux information de
		// l'évèntement clique en paramètres
		JTextField jt = (JTextField) e.getSource();
		jt.setText(null);
	}

	/**
	 * Create the frame.
	 */
	public JFconvertisseurTVA() {
		setTitle("Fenêtre pour calculer la tva");
		// set l'action quand on clique sur la croix
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// position et taille de la fenetre
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		// ajout de bordure à la fenetre
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Init");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init();
			}
		});
		btnNewButton.setBounds(66, 173, 98, 29);
		contentPane.add(btnNewButton);

		textHT = new JTextField();
		textHT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nettoyage(e);
			}
		});
		textHT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculTTC();
			}
		});
		textHT.setBounds(117, 88, 86, 20);
		contentPane.add(textHT);
		textHT.setColumns(10);

		textTTC = new JTextField();
		textTTC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nettoyage(e);
			}
		});
		textTTC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculHT();
			}
		});
		textTTC.setBounds(117, 121, 86, 20);
		contentPane.add(textTTC);
		textTTC.setColumns(10);

		textTVA = new JTextField();
		textTVA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nettoyage(e);
			}
		});
		textTVA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changementTauxTva();
			}
		});
		textTVA.setBounds(117, 55, 86, 20);
		contentPane.add(textTVA);
		textTVA.setColumns(10);

		JLabel lblNewLabel = new JLabel("Taux de TVA");
		lblNewLabel.setBounds(36, 55, 71, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Montant HT");
		lblNewLabel_1.setBounds(36, 88, 71, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Montant TTC");
		lblNewLabel_2.setBounds(36, 121, 71, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(
				new ImageIcon(JFconvertisseurTVA.class.getResource("/com/btssio/tva-taxe-valeur-ajoutee.png")));
		lblNewLabel_3.setBounds(213, 50, 200, 96);
		contentPane.add(lblNewLabel_3);
	}
}
