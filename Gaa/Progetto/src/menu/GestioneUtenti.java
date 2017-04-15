package menu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.log4j.helpers.LogLog;
import entita.Utente;
import java.sql.Connection;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;


/**
 * Classe che consente di creare un menù per la gestione degli utenti.
 */
@SuppressWarnings("serial")
public class GestioneUtenti extends JFrame {


	
	private JTable table;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JCheckBox checkBoxDatabase;
	private JCheckBox chckbxUtenti;
	private JTextField textFieldId;


	/**
	 * Costruttore del menù per la gestione degli utente.
	 */
	public GestioneUtenti() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 477);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuPrincipale menu = new MenuPrincipale();
				menu.setVisible(true);
			}
		});
		btnIndietro.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIndietro.setBounds(659, 404, 102, 23);
		contentPane.add(btnIndietro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(364, 21, 326, 342);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				
				textFieldId.setText(model.getValueAt(i, 0).toString());
				textFieldUsername.setText(model.getValueAt(i, 1).toString());
				textFieldPassword.setText(model.getValueAt(i, 2).toString());
				if(model.getValueAt(i, 3) instanceof Boolean){
				setCheckBoxDatabaseSelected((boolean)model.getValueAt(i, 3));}
				if(model.getValueAt(i, 4) instanceof Boolean){
				setChckbxUtentiSelected((boolean)model.getValueAt(i, 4));}
			}
		});
		table.setModel(new DefaultTableModel(
				null,
				new String[] {
					"Id", "Username", "Password", "Aut.Database", "Aut.Utenti"
				}
			));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		scrollPane.setViewportView(table);
		mostraUtenti();
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 65, 63, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 90, 63, 14);
		contentPane.add(lblPassword);
		
		JLabel lblAututenti = new JLabel("Aut.Utenti");
		lblAututenti.setBounds(10, 115, 63, 14);
		contentPane.add(lblAututenti);
		
		JLabel lblAutdatabase = new JLabel("Aut.Database");
		lblAutdatabase.setBounds(10, 140, 86, 14);
		contentPane.add(lblAutdatabase);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(94, 62, 86, 20);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(94, 88, 86, 20);
		contentPane.add(textFieldPassword);
		
		chckbxUtenti = new JCheckBox("");
		chckbxUtenti.setBounds(104, 115, 97, 23);
		contentPane.add(chckbxUtenti);
		
		checkBoxDatabase = new JCheckBox("");
		checkBoxDatabase.setBounds(104, 140, 97, 23);
		contentPane.add(checkBoxDatabase);
		
		JButton btnInserisci = new JButton("Inserisci");
		btnInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int intautData;
				int intautUtenti;
				if(getCheckBoxDatabaseSelected()){
					intautData = 1;}
				else{
					intautData = 0;}
				if(getChckbxUtentiSelected()){
					intautUtenti = 1;}
				else{
					intautUtenti = 0;}
		
				String query = "INSERT INTO utente(cd_utente, password, autorizzazione_database, autorizzazione_utenti)VALUES('"+textFieldUsername.getText()+"','"+textFieldPassword.getText()+"',"+"'"+intautData+"','"+intautUtenti+"')";
				executeSQLQuery(query, "Inserito");
			}
		});
		btnInserisci.setBounds(10, 239, 89, 23);
		contentPane.add(btnInserisci);
		
		JButton btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intautData;
				int intautUtenti;
				if(getCheckBoxDatabaseSelected()){
					intautData = 1;}
				else{
					intautData = 0;}
				if(getChckbxUtentiSelected()){
					intautUtenti = 1;}
				else{
					intautUtenti = 0;
				}
				String query = "UPDATE utente SET cd_utente ='"+textFieldUsername.getText()+"', password ='"+textFieldPassword.getText()+"', autorizzazione_database = '"+intautData+"', autorizzazione_utenti = '"+intautUtenti+"' WHERE id_utente ='"+textFieldId.getText()+"'";
				executeSQLQuery(query, "Aggiornato");
				
			}
		});	
		btnAggiorna.setBounds(127, 239, 89, 23);
		contentPane.add(btnAggiorna);
		
		JButton btnElimina = new JButton("Elimina");
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "DELETE FROM utente WHERE cd_utente = '"+textFieldUsername.getText()+"'";
				executeSQLQuery(query, "Eliminato");
			}
		});
		btnElimina.setBounds(249, 239, 89, 23);
		contentPane.add(btnElimina);
		
		JLabel lblId = new JLabel("Id");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(10, 40, 46, 14);
		contentPane.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(94, 37, 86, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
	}



	/**
	 * Metodo che crea una lista di utenti.
	 */
	public List<Utente> getListaUtenti(){
		
		List<Utente> listaUtenti = new ArrayList<Utente>();
		Connection connection = LogIn.getConnection();
		String query = "SELECT * FROM utente";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Utente utente = null;
			while(rs.next()){
				utente = new Utente(rs.getString("cd_utente"), rs.getBoolean("autorizzazione_database"), rs.getBoolean("autorizzazione_utenti"));
				utente.setPassword(rs.getString("password"));
				utente.setId(rs.getInt("id_utente"));
				listaUtenti.add(utente);
				
			}
		} 
		catch (Exception e) {
			LogLog.error("Your description here", e);
		}
		return listaUtenti;
	}
	
	/**
	 * Metodo che mostra a video gli utenti in lista.
	 */
	private void mostraUtenti(){
		List<Utente> lista = getListaUtenti();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		Object[] riga = new Object[5];

		if(lista != null)
		{
			for (Utente user : lista) {
				riga[0] = user.getId();
				riga[1] = user.getUsername();
				riga[2] = user.getPassword();
				riga[3] = user.isAutorizzazioneDatabase();
				riga[4] = user.isAutorizzazioneUtenti();
				model.addRow(riga);
			}
		}
	}
	
	/**
	 * Metodo che esegue le query degli altri metodi.
	 */
	private void executeSQLQuery(String query, String message){
		Connection con = LogIn.getConnection();
		Statement st = null;
		try {
			st = con.createStatement();
			if(st.executeUpdate(query) == 1){
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				mostraUtenti();
				JOptionPane.showMessageDialog(null, "Utente "+ message + " Correttamente");
			}
			else{
				JOptionPane.showMessageDialog(null, "Utente non "+ message);
				
			}
		} 
		catch (Exception e) {
			LogLog.error("Your description here", e);
		}
	}
	/**
	 * Metodo che ritorna un booleano sull'autorizzazione al database.
	 */
	private boolean getCheckBoxDatabaseSelected() {
		return checkBoxDatabase.isSelected();
	}
	/**
	 * Metodo che setta un booleano sull'autorizzazione al database.
	 */
	private void setCheckBoxDatabaseSelected(boolean selected) {
		checkBoxDatabase.setSelected(selected);
	}
	/**
	 * Metodo che ritorna un booleano sull'autorizzazione agli utenti.
	 */
	private boolean getChckbxUtentiSelected() {
		return chckbxUtenti.isSelected();
	}
	/**
	 * Metodo che setta un booleano sull'autorizzazione agli utenti.
	 */
	private void setChckbxUtentiSelected(boolean selected_1) {
		chckbxUtenti.setSelected(selected_1);
	}
}