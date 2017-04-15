package visteDatabase;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.log4j.helpers.LogLog;

import collezioni.ArchivioDipendenti;
import entita.Dipendente;
import entita.Numeri;
import entita.Variabili;
import menu.GestioneDatabase;
import menu.LogIn;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;

/**
 * Classe che consente la creazione di un menù per la gestione database dei dipendenti.
 */
@SuppressWarnings("serial")
public class Dipendenti extends JFrame {

	
	private JTextField textFieldMatricola;
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	private JTextField textFieldSesso;
	private JTextField textFieldCodFiscale;
	private JTextField textFieldTelefono;
	private JTextField textFieldCellulare;
	private JTextField textFieldEmail;
	private JTextField textFieldDataNascita;
	private JTextField textFieldLocNasc;
	private JTextField textFieldProvNasc;
	private JTextField textFieldNazNasc;
	private JTextField textFieldLocRes;
	private JTextField textFieldProvRes;
	private JTextField textFieldNazRes;
	private JTextField textFieldTipoDoc;
	private JTextField textFieldDocumento;
	
	/**
	 * tabella.
	 */
	final JTable table_1 = new JTable();
	private JTextField textFieldId;
	/**
	 * collezione di dipendenti.
	 */
	public ArchivioDipendenti collezione = new ArchivioDipendenti();

	/**
	 * Costruttore per del menù per la gestione database dei dipendenti.
	 */
	public Dipendenti() {
		final Variabili variabile = new Variabili();
		final Numeri numero = new Numeri();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 420);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(variabile.margine, variabile.margine, variabile.margine, variabile.margine));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(117, 11, 802, 216);
		contentPane.add(scrollPane);
		
		table_1.setModel(new DefaultTableModel(
			null,
			new String[] {
				"id", "matricola", "nome", "cognome", "sesso", "cod_fiscale", "telefono", "cellulare", "email", "data nascita", "localit\u00E0 nascita", "provincia nascita", "nazione nascita", "localit\u00E0 residenza", "provincia residenza", "nazione residenza", "tipo documento", "documento"
			}
		));
		table_1.getColumnModel().getColumn(numero.zero).setMinWidth(numero.dimensioneColonna1);
		table_1.getColumnModel().getColumn(numero.uno).setPreferredWidth(numero.dimensioneColonna2);
		table_1.getColumnModel().getColumn(numero.uno).setMinWidth(numero.dimensioneColonna2);
		table_1.getColumnModel().getColumn(numero.due).setMinWidth(numero.dimensioneColonna1);
		table_1.getColumnModel().getColumn(numero.tre).setMinWidth(numero.dimensioneColonna1);
		table_1.getColumnModel().getColumn(numero.quattro).setMinWidth(numero.dimensioneColonna1);
		table_1.getColumnModel().getColumn(numero.cinque).setPreferredWidth(numero.dimensioneColonna3);
		table_1.getColumnModel().getColumn(numero.cinque).setMinWidth(numero.dimensioneColonna3);
		table_1.getColumnModel().getColumn(numero.sei).setMinWidth(numero.dimensioneColonna1);
		table_1.getColumnModel().getColumn(numero.sette).setMinWidth(numero.dimensioneColonna1);
		table_1.getColumnModel().getColumn(numero.otto).setPreferredWidth(numero.dimensioneColonna4);
		table_1.getColumnModel().getColumn(numero.otto).setMinWidth(numero.dimensioneColonna4);
		table_1.getColumnModel().getColumn(numero.nove).setMinWidth(numero.dimensioneColonna1);
		table_1.getColumnModel().getColumn(numero.dieci).setPreferredWidth(numero.dimensioneColonna5);
		table_1.getColumnModel().getColumn(numero.dieci).setMinWidth(numero.dimensioneColonna5);
		table_1.getColumnModel().getColumn(numero.undici).setPreferredWidth(numero.dimensioneColonna6);
		table_1.getColumnModel().getColumn(numero.undici).setMinWidth(numero.dimensioneColonna6);
		table_1.getColumnModel().getColumn(numero.dodici).setPreferredWidth(numero.dimensioneColonna8);
		table_1.getColumnModel().getColumn(numero.tredici).setPreferredWidth(numero.dimensioneColonna7);
		table_1.getColumnModel().getColumn(numero.tredici).setMinWidth(numero.dimensioneColonna7);
		table_1.getColumnModel().getColumn(numero.quattordici).setPreferredWidth(numero.dimensioneColonna4);
		table_1.getColumnModel().getColumn(numero.quattordici).setMinWidth(numero.dimensioneColonna4);
		table_1.getColumnModel().getColumn(numero.quindici).setPreferredWidth(numero.dimensioneColonna9);
		table_1.getColumnModel().getColumn(numero.quindici).setMinWidth(numero.dimensioneColonna9);
		table_1.getColumnModel().getColumn(numero.sedici).setPreferredWidth(numero.dimensioneColonna9);
		table_1.getColumnModel().getColumn(numero.sedici).setMinWidth(numero.dimensioneColonna9);
		table_1.getColumnModel().getColumn(numero.diciasette).setMinWidth(numero.dimensioneColonna1);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table_1.getSelectedRow();
				TableModel model = table_1.getModel();
				textFieldId.setText(model.getValueAt(i, numero.zero).toString());
				textFieldMatricola.setText(model.getValueAt(i, numero.uno).toString());
				textFieldNome.setText(model.getValueAt(i, numero.due).toString());
				textFieldCognome.setText(model.getValueAt(i, numero.tre).toString());
				textFieldSesso.setText(model.getValueAt(i, numero.quattro).toString());
				textFieldCodFiscale.setText(model.getValueAt(i, numero.cinque).toString());
				textFieldTelefono.setText(model.getValueAt(i, numero.sei).toString());
				textFieldCellulare.setText(model.getValueAt(i, numero.sette).toString());
				textFieldEmail.setText(model.getValueAt(i, numero.otto).toString());
				textFieldDataNascita.setText(model.getValueAt(i, numero.nove).toString());
				textFieldLocNasc.setText(model.getValueAt(i, numero.dieci).toString());
				textFieldProvNasc.setText(model.getValueAt(i, numero.undici).toString());
				textFieldNazNasc.setText(model.getValueAt(i, numero.dodici).toString());
				textFieldLocRes.setText(model.getValueAt(i, numero.tredici).toString());
				textFieldProvRes.setText(model.getValueAt(i, numero.quattordici).toString());
				textFieldNazRes.setText(model.getValueAt(i, numero.quindici).toString());
				textFieldTipoDoc.setText(model.getValueAt(i, numero.sedici).toString());
				textFieldDocumento.setText(model.getValueAt(i, numero.diciasette).toString());
				
			}
		});
		scrollPane.setViewportView(table_1);
		mostraDipendenti();
		
		JLabel lblMatricola = new JLabel("Matricola");
		lblMatricola.setBounds(21, 250, 86, 14);
		contentPane.add(lblMatricola);
		
		textFieldMatricola = new JTextField();
		textFieldMatricola.setBounds(117, 247, 86, 20);
		contentPane.add(textFieldMatricola);
		textFieldMatricola.setColumns(numero.dieci);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(225, 250, 46, 14);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(268, 247, 100, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(numero.dieci);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(391, 250, 56, 14);
		contentPane.add(lblCognome);
		
		textFieldCognome = new JTextField();
		textFieldCognome.setBounds(457, 247, 86, 20);
		contentPane.add(textFieldCognome);
		textFieldCognome.setColumns(numero.dieci);
		
		JLabel lblSesso = new JLabel("Sesso");
		lblSesso.setBounds(553, 250, 49, 14);
		contentPane.add(lblSesso);
		
		textFieldSesso = new JTextField();
		textFieldSesso.setBounds(609, 247, 26, 20);
		contentPane.add(textFieldSesso);
		textFieldSesso.setColumns(numero.dieci);
		
		JLabel lblCodicefiscale = new JLabel("CodiceFiscale");
		lblCodicefiscale.setBounds(645, 250, 89, 14);
		contentPane.add(lblCodicefiscale);
		
		textFieldCodFiscale = new JTextField();
		textFieldCodFiscale.setBounds(744, 247, 143, 20);
		contentPane.add(textFieldCodFiscale);
		textFieldCodFiscale.setColumns(numero.dieci);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(21, 281, 86, 14);
		contentPane.add(lblTelefono);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(117, 278, 86, 20);
		contentPane.add(textFieldTelefono);
		textFieldTelefono.setColumns(numero.dieci);
		
		JLabel lblCellulare = new JLabel("Cellulare");
		lblCellulare.setBounds(225, 280, 65, 14);
		contentPane.add(lblCellulare);
		
		textFieldCellulare = new JTextField();
		textFieldCellulare.setBounds(300, 277, 90, 20);
		contentPane.add(textFieldCellulare);
		textFieldCellulare.setColumns(numero.dieci);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(411, 280, 46, 14);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(467, 274, 166, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(numero.dieci);
		
		JLabel lblDataNascita = new JLabel("Data Nascita");
		lblDataNascita.setBounds(645, 275, 107, 14);
		contentPane.add(lblDataNascita);
		
		textFieldDataNascita = new JTextField();
		textFieldDataNascita.setBounds(762, 275, 125, 20);
		contentPane.add(textFieldDataNascita);
		textFieldDataNascita.setColumns(numero.dieci);
		
		JLabel lblLocalitNascita = new JLabel("Localit\u00E0 Nascita");
		lblLocalitNascita.setBounds(21, 306, 108, 14);
		contentPane.add(lblLocalitNascita);
		
		textFieldLocNasc = new JTextField();
		textFieldLocNasc.setBounds(139, 303, 86, 20);
		contentPane.add(textFieldLocNasc);
		textFieldLocNasc.setColumns(numero.dieci);
		
		JLabel lblProvNascita = new JLabel("Prov. Nascita");
		lblProvNascita.setBounds(235, 307, 88, 14);
		contentPane.add(lblProvNascita);
		
		textFieldProvNasc = new JTextField();
		textFieldProvNasc.setBounds(333, 304, 35, 20);
		contentPane.add(textFieldProvNasc);
		textFieldProvNasc.setColumns(numero.dieci);
		
		JLabel lblNazioneNascita = new JLabel("Nazione Nascita");
		lblNazioneNascita.setBounds(378, 307, 110, 14);
		contentPane.add(lblNazioneNascita);
		
		textFieldNazNasc = new JTextField();
		textFieldNazNasc.setBounds(498, 301, 86, 20);
		contentPane.add(textFieldNazNasc);
		textFieldNazNasc.setColumns(numero.dieci);
		
		JLabel lblLocalitResidenza = new JLabel("Localit\u00E0 Residenza");
		lblLocalitResidenza.setBounds(594, 305, 118, 14);
		contentPane.add(lblLocalitResidenza);
		
		textFieldLocRes = new JTextField();
		textFieldLocRes.setBounds(722, 300, 165, 20);
		contentPane.add(textFieldLocRes);
		textFieldLocRes.setColumns(numero.dieci);
		
		JLabel lblProvinciaResidenza = new JLabel("Provincia Residenza");
		lblProvinciaResidenza.setBounds(21, 335, 128, 14);
		contentPane.add(lblProvinciaResidenza);
		
		textFieldProvRes = new JTextField();
		textFieldProvRes.setBounds(159, 332, 56, 20);
		contentPane.add(textFieldProvRes);
		textFieldProvRes.setColumns(numero.dieci);
		
		JLabel lblNazioneResidenza = new JLabel("Nazione Residenza");
		lblNazioneResidenza.setBounds(225, 335, 129, 14);
		contentPane.add(lblNazioneResidenza);
		
		textFieldNazRes = new JTextField();
		textFieldNazRes.setBounds(361, 332, 86, 20);
		contentPane.add(textFieldNazRes);
		textFieldNazRes.setColumns(numero.dieci);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(467, 335, 99, 14);
		contentPane.add(lblTipoDocumento);
		
		textFieldTipoDoc = new JTextField();
		textFieldTipoDoc.setBounds(578, 332, 55, 20);
		contentPane.add(textFieldTipoDoc);
		textFieldTipoDoc.setColumns(numero.dieci);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setBounds(645, 335, 73, 14);
		contentPane.add(lblDocumento);
		
		textFieldDocumento = new JTextField();
		textFieldDocumento.setBounds(732, 331, 155, 20);
		contentPane.add(textFieldDocumento);
		textFieldDocumento.setColumns(numero.dieci);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(21, 189, 46, 14);
		contentPane.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(21, 219, 86, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(numero.dieci);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String[] query = new String[5];
				query[0] = "INSERT IGNORE INTO nazione(cd_nazione) VALUES('" +textFieldNazNasc.getText()+"')";
				query[1] = "INSERT IGNORE INTO nazione(cd_nazione) VALUES('" +textFieldNazRes.getText()+"')";
				query[2] = "INSERT IGNORE INTO provincia(cd_provincia) VALUES('" +textFieldProvNasc.getText()+"')";
				query[3] = "INSERT IGNORE INTO provincia(cd_provincia) VALUES('" +textFieldProvRes.getText()+"')";
				query[4] = "INSERT IGNORE INTO tipo_documento(cd_tipo_documento) VALUES('" +textFieldTipoDoc.getText()+"')";
				for(int i = 0; i<5; i++){
					executeQuery(query[i]);
				}
				
				String queryFinale = " INSERT IGNORE INTO dipendente(matricola_dipendente, nome, cognome, sesso, cod_fiscale, telefono, cellulare, email, data_nascita, cd_localita_nascita, cd_provincia_nascita, cd_nazione_nascita, cd_localita_residenza, cd_provincia_residenza, cd_nazione_residenza, cd_tipo_documento, documento)VALUES('"+textFieldMatricola.getText()+"','"+textFieldNome.getText()+"', '"+textFieldCognome.getText()+"','"+textFieldSesso.getText()+"', '"+textFieldCodFiscale.getText()+"', '"+textFieldTelefono.getText()+"', '"+textFieldCellulare.getText()+"', '"+textFieldEmail.getText()+"', '"+textFieldDataNascita.getText()+"', '"+textFieldLocNasc.getText()+"', '"+textFieldProvNasc.getText()+"', '"+textFieldNazNasc.getText()+"', '"+textFieldLocRes.getText()+"', '"+textFieldProvRes.getText()+"', '"+textFieldNazRes.getText()+"', '"+textFieldTipoDoc.getText()+"', '"+textFieldDocumento.getText()+"') ";
				executeSQLQuery(queryFinale, "Inserito");
			}
		});
		btnAggiungi.setBounds(10, 35, 89, 23);
		contentPane.add(btnAggiungi);
		
		JButton btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "UPDATE dipendente SET matricola_dipendente ='"+textFieldMatricola.getText()+"', nome ='"+textFieldNome.getText()+"', cognome = '"+textFieldCognome.getText()+"', sesso = '"+textFieldSesso.getText()+"', cod_fiscale = '"+textFieldCodFiscale.getText()+"', telefono = '"+textFieldTelefono.getText()+"', cellulare = '"+textFieldCellulare.getText()+"', email = '"+textFieldEmail.getText()+"', data_nascita = '"+textFieldDataNascita.getText()+"', cd_localita_nascita = '"+textFieldLocNasc.getText()+"', cd_provincia_nascita = '"+textFieldProvNasc.getText()+"', cd_nazione_nascita = '"+textFieldNazNasc.getText()+"', cd_localita_residenza = '"+textFieldLocRes.getText()+"', cd_provincia_residenza = '"+textFieldProvRes.getText()+"', cd_nazione_residenza = '"+textFieldNazRes.getText()+"', cd_tipo_documento = '"+textFieldTipoDoc.getText()+"', documento = '"+textFieldDocumento.getText()+"' WHERE id_dipendente ='"+textFieldId.getText()+"'";
				executeSQLQuery(query, "Aggiornato");
			}
		});
		btnAggiorna.setBounds(10, 69, 89, 23);
		contentPane.add(btnAggiorna);
		
		JButton btnElimina = new JButton("Elimina");
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "DELETE FROM dipendente WHERE matricola_dipendente = '"+textFieldMatricola.getText()+"'";
				executeSQLQuery(query, "Eliminato");
			}
		});
		btnElimina.setBounds(10, 103, 89, 23);
		contentPane.add(btnElimina);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						GestioneDatabase gd= new GestioneDatabase();
						gd.setVisible(true);
					}
		});
		btnIndietro.setBounds(10, 145, 89, 23);
		contentPane.add(btnIndietro);	
				
	}
	
		/**
		 * Metodo che crea una lista di dipendenti.
		 */
		public Set<Dipendente> getListaDipendenti(){
			
			Set<Dipendente> listaDipendenti = new HashSet<Dipendente>();
			Connection connection = LogIn.getConnection();
			String query = "SELECT * FROM dipendente";
			Statement st = null;
			ResultSet rs = null;
			try {
				st = connection.createStatement();
				rs = st.executeQuery(query);
				Dipendente dipendente = null;
				while(rs.next()){
					
					dipendente = new Dipendente(rs.getString("matricola_dipendente"), rs.getString("nome"), rs.getString("cognome"), rs.getString("sesso").charAt(0), rs.getString("cod_fiscale"), rs.getString("telefono"), rs.getString("cellulare"), rs.getString("email"), rs.getString("data_nascita"), rs.getString("cd_localita_nascita"), rs.getString("cd_provincia_nascita"), rs.getString("cd_nazione_nascita"), rs.getString("cd_localita_residenza"), rs.getString("cd_provincia_residenza"), rs.getString("cd_nazione_residenza"), rs.getString("cd_tipo_documento"), rs.getString("documento"));
					dipendente.setId(rs.getInt("id_dipendente"));
					listaDipendenti.add(dipendente);
					
				}
			} 
			catch (Exception e) {
				LogLog.error("Your description here", e);
			}
			return listaDipendenti;
		}
		
		/**
		 * Metodo che mostra su schermo tutti i dipendenti presenti in lista.
		 */
		public void mostraDipendenti(){
			Set<Dipendente> set = getListaDipendenti();
			List<Dipendente> lista = new ArrayList<Dipendente>();
			DefaultTableModel model = null;
			lista.addAll(set);
			for(Dipendente dipendente: set){
				collezione.aggiungiDipendente(dipendente);
			}
			if(table_1.getModel() instanceof DefaultTableModel){
				model = (DefaultTableModel)table_1.getModel();
				modelloTabella(model, lista);}
		}
		
		/**
		 * Metodo collegato al precedente per mostrare a video i dipendenti.
		 */
		public void modelloTabella(DefaultTableModel model, List<Dipendente> lista){
			
			Object[] riga = new Object[18];

			if(lista != null)
			{
				for (Dipendente dip : lista) {
					riga[0] = dip.getId();
					riga[1] = dip.getMatricola();
					riga[2] = dip.getNome();
					riga[3] = dip.getCognome();
					riga[4] = dip.getSesso();
					riga[5] = dip.getCodFiscale();
					riga[6] = dip.getTelefono();
					riga[7] = dip.getCellulare();
					riga[8] = dip.getEmail();
					riga[9] = dip.getDataNascita();
					riga[10] = dip.getLocNascita();
					riga[11] = dip.getProvNascita();
					riga[12] = dip.getNazNascita();
					riga[13] = dip.getLocResidenza();
					riga[14] = dip.getProvResidenza();
					riga[15] = dip.getNazResidenza();
					riga[16] = dip.getTipoDocumento();
					riga[17] = dip.getCodDocumento();					
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
			DefaultTableModel model = null;
			try {
				st = con.createStatement();
				if(st.executeUpdate(query) == 1){
					if(table_1.getModel() instanceof DefaultTableModel){
						model = (DefaultTableModel)table_1.getModel();
						model.setRowCount(0);}
					mostraDipendenti();
					JOptionPane.showMessageDialog(null, "Dipendente "+ message + " Correttamente");
				}
				else{
					JOptionPane.showMessageDialog(null, "Dipendente non "+ message);
					
				}
			} catch (Exception e) {
				LogLog.error("Your description here", e);
			}
		}
		
		/**
		 * Metodo che esegue le query degli altri metodi.
		 */
		private void executeQuery(String query){
			Connection con = LogIn.getConnection();
			Statement st = null;
			try {
				st = con.createStatement();
				st.executeUpdate(query);
				
			} catch (SQLException e) {
				
				LogLog.error("Your description here", e);
			}
			
		}
}
