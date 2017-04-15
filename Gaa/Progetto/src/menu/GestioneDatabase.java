package menu;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.apache.log4j.helpers.LogLog;
import entita.Variabili;
import visteDatabase.Concessioni;
import visteDatabase.Dipendenti;
import visteDatabase.Spazi;
import visteDatabase.Strumenti;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Classe che crea un menu per la gestione del database.
 */
@SuppressWarnings("serial")
public class GestioneDatabase extends JFrame {
	


	/**
	 * Costruttore del  menu per la gestione del database.
	 */
	public GestioneDatabase() {
		
		final Variabili variabile = new Variabili();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(variabile.x, variabile.y, variabile.larghezzaPiccola, variabile.altezzaPiccola);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(variabile.margine, variabile.margine, variabile.margine, variabile.margine));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.setBounds(variabile.menuLogOutX, variabile.menuLogOutY, variabile.menuLogOutLarghezza, variabile.menuLogOutAltezza);
		contentPane.add(btnIndietro);
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuPrincipale menu = new MenuPrincipale();
				menu.setVisible(true);
			}
		});
		btnIndietro.setFont(new Font("Tahoma", Font.PLAIN, variabile.dimensioneFont));
		
		JButton btnDipendenti = new JButton("Dipendenti");
		btnDipendenti.setFont(new Font("Tahoma", Font.PLAIN, variabile.dimensioneFont));
		btnDipendenti.setBounds(variabile.menuBottoneX1, variabile.menuBottoneY3, variabile.menuBottoneLarghezza, variabile.menuBottoneAltezza);
		contentPane.add(btnDipendenti);
		
		JButton btnSpazi = new JButton("Spazi");
		btnSpazi.setFont(new Font("Tahoma", Font.PLAIN, variabile.dimensioneFont));
		btnSpazi.setBounds(variabile.menuBottoneX1, variabile.menuBottoneY4, variabile.menuBottoneLarghezza, variabile.menuBottoneAltezza);
		contentPane.add(btnSpazi);
		
		JButton btnStrumenti = new JButton("Strumenti");
		btnStrumenti.setFont(new Font("Tahoma", Font.PLAIN, variabile.dimensioneFont));
		btnStrumenti.setBounds(variabile.menuBottoneX3, variabile.menuBottoneY3, variabile.menuBottoneLarghezza, variabile.menuBottoneAltezza);
		contentPane.add(btnStrumenti);
		
		JButton btnConcessioni = new JButton("Concessioni");
		btnConcessioni.setFont(new Font("Tahoma", Font.PLAIN, variabile.dimensioneFont));
		btnConcessioni.setBounds(variabile.menuBottoneX3, variabile.menuBottoneY4, variabile.menuBottoneLarghezza, variabile.menuBottoneAltezza);
		contentPane.add(btnConcessioni);
		btnConcessioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Concessioni concessioni = null;
				try {
					concessioni = new Concessioni();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					LogLog.error("Your description here", e1);
				}
				concessioni.setVisible(true);
			}
		});
		btnStrumenti.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Strumenti strumenti = null;
				try {
					strumenti = new Strumenti();
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					LogLog.error("Your description here", e);
				}
				strumenti.setVisible(true);

		}
		});
		btnSpazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Spazi spazi = new Spazi();
				spazi.setVisible(true);

			}
		});
				
		
		btnDipendenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Dipendenti dipendenti = new Dipendenti();
				dipendenti.setVisible(true);

			}
		});
	}
}
