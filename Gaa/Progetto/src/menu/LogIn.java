package menu;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.apache.log4j.helpers.LogLog;
import connessioneSicura.Connesione;
import entita.Numeri;
import entita.Utente;
import entita.Variabili;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;


/**
 * Classe che consente la creazione del menù di login.
 */
@SuppressWarnings("serial")
public class LogIn extends JFrame {
	
	/**
	 * Istanza della classe variabili.
	 */
	final Variabili variabile = new Variabili();
	private JTextField textField_Login;
	private JPasswordField passwordField_Login;
	/**
	 * Istanza della classe Numeri.
	 */
	final Numeri numero = new Numeri();
	
	/**
	 * Elemento grafico che contiene eventuali errori nel login.
	 */
	JLabel errorLabelLogin = new JLabel("");

	/**
	 * Inizializzazione del frame login.
	 */
	static LogIn frame = null;
	
	/**
	 * Creazione di un'istanza della classe extended properties che servirà per la connessione sicura.
	 */
	protected static Connesione prop;
	
	/**
	 * Metodo principale dal quale il programma si avvia.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		File configFile = null;		
		configFile = new File("config.properties");
		prop = new Connesione(configFile);	
		
		
		String parteIniziale = "Questa è la parte fissa iniziale da modificare al primo utilizzo.";
		String parteFinale = "Questa è la parte fissa finale da modificare al primo utilizzo.";
		File parteFissaIniziale = new File("parteFissaIniziale.txt");
		File parteFissaFinale = new File("parteFissaFinale.txt");
		
		if (!parteFissaIniziale.exists()){
			parteFissaIniziale.createNewFile();
			FileWriter fw = new FileWriter(parteFissaIniziale);
			fw.write(parteIniziale);
			fw.flush();
	        fw.close();
		}
		if (!parteFissaFinale.exists()){
			parteFissaFinale.createNewFile();
			FileWriter fw2 = new FileWriter(parteFissaFinale);
			fw2.write(parteFinale);
			fw2.flush();
		    fw2.close();
		}    
		
      
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				frame = new LogIn();
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Metodo che controlla l'accesso al sistema.
	 * @throws IOException 
	 */
	private void accesso() throws IOException
	{	
		Connection connection = null;
		PreparedStatement ps = null;
		try {
						
			connection = getConnection();
			ps = connection.prepareStatement("SELECT cd_utente, password FROM utente WHERE cd_utente = ? AND password = ?");
			ps.setString(numero.uno, textField_Login.getText());
			ps.setString(numero.due, String.valueOf(passwordField_Login.getPassword()));
			ResultSet result = ps.executeQuery();
			if (result.next()){
				errorLabelLogin.setText("Login riuscito!");
				errorLabelLogin.setForeground(Color.GREEN);
				String username = textField_Login.getText();				
				String sql = "SELECT autorizzazione_database, autorizzazione_utenti FROM utente WHERE cd_utente = ?";
				PreparedStatement ps1 = connection.prepareStatement(sql);
				ps1.setString(1, username);
				ResultSet result2 = ps1.executeQuery();
				if(result2.next()){
				boolean aut1 = result2.getBoolean("autorizzazione_database");
				boolean aut2 = result2.getBoolean("autorizzazione_utenti");
										 
				Utente utenteLog = new Utente(username, aut1, aut2);
				MenuPrincipale.utenteSessione = utenteLog;
				dispose();
				MenuPrincipale menu = new MenuPrincipale();
				menu.setVisible(true);
				}
			}
			else{	
				errorLabelLogin.setText("Username o Password errati!");
				errorLabelLogin.setForeground(Color.RED);
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Costruttore del menù di login.
	 */
	public LogIn() {
		
		
		JPanel contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(variabile.x, variabile.y, variabile.larghezzaPiccola, variabile.altezzaPiccola);
		contentPane.setBorder(new EmptyBorder(variabile.margine, variabile.margine, variabile.margine, variabile.margine));
		contentPane.setLayout(new BorderLayout(variabile.hGap, variabile.vGap));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		errorLabelLogin.setBounds(variabile.labelErrorLoginX, variabile.labelErrorLoginY, variabile.labelErrorLoginLarghezza, variabile.labelErrorLoginAltezza);
		panel.add(errorLabelLogin);
				
		errorLabelLogin.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabelLogin.setFont(new Font("Tahoma", Font.PLAIN, variabile.dimensioneFont));
		errorLabelLogin.setForeground(Color.RED);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, variabile.dimensioneFont));
		lblUsername.setBounds(variabile.labelxLogin, variabile.labely1Login, variabile.labelLarghezzaUP, variabile.labelAltezzaUP);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, variabile.dimensioneFont));
		lblPassword.setBounds(variabile.labelxLogin, variabile.labely2Login, variabile.labelLarghezzaUP, variabile.labelAltezzaUP);
		panel.add(lblPassword);
		
		textField_Login = new JTextField();
		textField_Login.setFont(new Font("Tahoma", Font.PLAIN, variabile.dimensioneFont));
		textField_Login.setBounds(variabile.textLoginX, variabile.textLoginY1, variabile.textLoginLarghezza, variabile.textLoginAltezza);
		panel.add(textField_Login);
				
		passwordField_Login = new JPasswordField();
		passwordField_Login.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					try {
						accesso();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				}
			}
				
		});
		passwordField_Login.setEchoChar('*');
		passwordField_Login.setFont(new Font("Tahoma", Font.PLAIN, variabile.dimensioneFont));
		passwordField_Login.setBounds(variabile.textLoginX, variabile.textLoginY2, variabile.textLoginLarghezza, variabile.textLoginAltezza);
		panel.add(passwordField_Login);
		
		JCheckBox chckbxShowPassword = new JCheckBox("Show password");
		
		chckbxShowPassword.setFont(new Font("Tahoma", Font.PLAIN, variabile.dimensioneFont));
		chckbxShowPassword.setBounds(variabile.checkLoginX, variabile.textLoginY2, variabile.checkLoginLarghezza, variabile.textLoginAltezza);
		panel.add(chckbxShowPassword);
				
		JButton loginButton = new JButton("LOGIN");
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, variabile.dimensioneFont));
		
		loginButton.setBounds(variabile.textLoginX, variabile.buttonLoginY, variabile.textLoginLarghezza, variabile.textLoginAltezza);
		panel.add(loginButton);
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					accesso();
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}
			}
		});
		
		
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxShowPassword.isSelected()){
					passwordField_Login.setEchoChar((char)numero.zero);
				}else{
					passwordField_Login.setEchoChar((char)numero.asciAsterisco);
					
				}
			}
		});
		
	}
	
	public static Connection getConnection() {
		Connection con = null;
		try 
		{
			String cnnString = String.format("jdbc:mysql://%1s:3306/gaa?autoReconnect=true&useSSL=false",prop.getHostProperty());			
			con = DriverManager.getConnection(cnnString, prop.getUserProperty(), prop.getPasswordProperty());	
		} 
		catch (Exception e) {
			LogLog.error("Your description here", e);
		}
		return con;
		
	}
}
