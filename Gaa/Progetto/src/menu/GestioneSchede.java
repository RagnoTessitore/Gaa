package menu;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.helpers.LogLog;

import schede.CreaSchede;
import schede.EliminaSchede;
import schede.ModificaPartiFisse;
import schede.StampaSchede;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Classe che crea un menù che permette la gestione delle schede anagrafiche.
 */
@SuppressWarnings("serial")
public class GestioneSchede extends JFrame {

	/**
     * Pannello che contiene gli elementi grafici. 
     */
	protected JPanel contentPane;


	/**
	 * Costruttore del menù per la gestione delle schede.
	 */
	public GestioneSchede() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.setBounds(300, 220, 100, 20);
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuPrincipale menu = new MenuPrincipale();
				menu.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		btnIndietro.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnIndietro);
		
		JButton btnModificaPartiFisse = new JButton("Modifica Parti fisse");
		btnModificaPartiFisse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ModificaPartiFisse partiFisse = new ModificaPartiFisse();
				partiFisse.setVisible(true);
			}
		});
		btnModificaPartiFisse.setBounds(31, 31, 161, 34);
		contentPane.add(btnModificaPartiFisse);
		
		JButton btnCreaScheda = new JButton("Crea Scheda");
		btnCreaScheda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CreaSchede crea = null;
				try {
					crea = new CreaSchede();
				} catch (IOException e1) {
					LogLog.error("Your description here", e1);
				}
				crea.setVisible(true);
			}
		});
		btnCreaScheda.setBounds(241, 31, 159, 34);
		contentPane.add(btnCreaScheda);
		
		JButton btnStampaScheda = new JButton("Stampa Scheda");
		btnStampaScheda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StampaSchede menu;
				try {
					menu = new StampaSchede();
					menu.setVisible(true);
				} catch (IOException e1) {
					LogLog.error("Your description here", e1);
				}
				
			}
		});
		btnStampaScheda.setBounds(241, 114, 159, 34);
		contentPane.add(btnStampaScheda);
		
		JButton btnEliminaScheda = new JButton("Elimina Scheda");
		btnEliminaScheda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				try {
					EliminaSchede menu = new EliminaSchede();
					menu.setVisible(true);
				} catch (IOException e) {
					LogLog.error("Your description here", e);
				}
				
			}
		});
		btnEliminaScheda.setBounds(31, 114, 161, 34);
		contentPane.add(btnEliminaScheda);
	}
}
