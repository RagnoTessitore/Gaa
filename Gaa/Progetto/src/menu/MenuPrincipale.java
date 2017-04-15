package menu;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import entita.Utente;
import entita.Variabili;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * Classe che consente di creare il menù principale del sistema.
 */
@SuppressWarnings("serial")
public class MenuPrincipale extends JFrame {

	
	/**
	 * Inizializzazzione di un'istanza della classe utente.
	 */
	protected static Utente utenteSessione = null;
	
	
	/**
	 * Costruttore del menù principale.
	 */
	protected MenuPrincipale() {
		
		final Variabili variabile = new Variabili();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(variabile.x, variabile.y, variabile.larghezzaPiccola, variabile.altezzaPiccola);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(variabile.margine, variabile.margine, variabile.margine, variabile.margine));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGestisciDatabase = new JButton("Gestisci Database");
		btnGestisciDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				GestioneDatabase menuDatabase = new GestioneDatabase();
				menuDatabase.setVisible(true);
			}
		});
		btnGestisciDatabase.setFont(new Font("Tahoma", Font.PLAIN, variabile.dimensioneFont));
		btnGestisciDatabase.setBounds(variabile.menuBottoneX1, variabile.menuBottoneY1, variabile.menuBottoneLarghezza, variabile.menuBottoneAltezza);
		contentPane.add(btnGestisciDatabase);
		if(!utenteSessione.isAutorizzazioneDatabase()){
			btnGestisciDatabase.setEnabled(false);}
		
		JButton btnGestisciSchede = new JButton("Gestisci Schede");
		btnGestisciSchede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				GestioneSchede menuSchede = new GestioneSchede();
				menuSchede.setVisible(true);
			}
		});
		btnGestisciSchede.setFont(new Font("Tahoma", Font.PLAIN, variabile.dimensioneFont));
		btnGestisciSchede.setBounds(variabile.menuBottoneX2, variabile.menuBottoneY2, variabile.menuBottoneLarghezza, variabile.menuBottoneAltezza);
		contentPane.add(btnGestisciSchede);
		
		JButton btnGestisciUtenti = new JButton("Gestisci Utenti");
		btnGestisciUtenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				GestioneUtenti menuUtente = new GestioneUtenti();
				menuUtente.setVisible(true);
			}
		});
		btnGestisciUtenti.setFont(new Font("Tahoma", Font.PLAIN, variabile.dimensioneFont));
		btnGestisciUtenti.setBounds(variabile.menuBottoneX3, variabile.menuBottoneY1, variabile.menuBottoneLarghezza, variabile.menuBottoneAltezza);
		contentPane.add(btnGestisciUtenti);
		
		JLabel labelBenvenuto = new JLabel("Ciao " + utenteSessione.getUsername() + ". Scegli cosa fare");
		labelBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		labelBenvenuto.setFont(new Font("Tahoma", Font.PLAIN, variabile.dimensioneFont));
		labelBenvenuto.setBounds(variabile.menuBenvenutoX, variabile.menuBevenutoY, variabile.menuBevenutoLarghezza, variabile.menuBevenutoAltezza);
		contentPane.add(labelBenvenuto);
		
		JButton btnLogOut = new JButton("Logout");
		Image img = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		btnLogOut.setIcon(new ImageIcon(img));
				
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LogIn login = new LogIn();
				login.setVisible(true);
				
			}
			
		});
		btnLogOut.setForeground(Color.RED);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, variabile.dimensioneFont));
		btnLogOut.setBounds(variabile.menuLogOutX, variabile.menuLogOutY, variabile.menuLogOutLarghezza, variabile.menuLogOutAltezza);
		contentPane.add(btnLogOut);
		if(!utenteSessione.isAutorizzazioneUtenti()){
			btnGestisciUtenti.setEnabled(false);}

	}
	
}
