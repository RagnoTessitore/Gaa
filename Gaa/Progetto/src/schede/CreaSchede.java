package schede;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.log4j.helpers.LogLog;
import collezioni.ArchivioDipendenti;
import collezioni.ArchivioSpazi;
import collezioni.ArchivioStrumenti;
import entita.Dipendente;
import entita.Numeri;
import entita.Spazio;
import entita.Strumento;
import entita.Variabili;
import menu.GestioneSchede;
import menu.LogIn;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;


/**
 * Classe per creare una scheda.
 */
@SuppressWarnings("serial")
public class CreaSchede extends JFrame {

	private JPanel contentPane;
	final JTable table = new JTable();
	String fileName = "elenco schede.txt";
	final JScrollPane scrollPane = new JScrollPane();
	JButton btnAggiungiDipendente = new JButton("Aggiungi");
	JButton btnAggiungiSpazio = new JButton("Aggiungi");
	JButton btnAggiungiStrumento = new JButton("Aggiungi");
	final Numeri numero = new Numeri();
	final Variabili variabile = new Variabili();
	Date data = new Date();
	ArchivioDipendenti dipendentiScheda = new ArchivioDipendenti();
	ArchivioStrumenti strumentiScheda = new ArchivioStrumenti();
	ArchivioSpazi spaziScheda = new ArchivioSpazi();
	String path = "parteFissaIniziale.txt";
	String path2 = "parteFissaFinale.txt";
	String testoIniziale = "";
	String testoFinale = "";
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public CreaSchede() throws IOException {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(numero.dimensioneColonna6, numero.dimensioneColonna6, 627, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(variabile.margine, variabile.margine, variabile.margine, variabile.margine));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(150, numero.undici, 451, 218);
		contentPane.add(scrollPane);		
		JButton btnDipendenti = new JButton("Dipendenti");
		btnDipendenti.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				creaTabellaDipendenti();				
			}
		});
		btnDipendenti.setBounds(numero.dieci, 42, numero.dimensioneColonna6, numero.ventitre);
		contentPane.add(btnDipendenti);
		
		JButton btnStrumenti = new JButton("Strumenti");
		btnStrumenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creaTabellaStrumenti();
			}

		});
		btnStrumenti.setBounds(numero.dieci, 105, numero.dimensioneColonna6, numero.ventitre);
		contentPane.add(btnStrumenti);
		
		JButton btnSpazi = new JButton("Spazi");
		btnSpazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creaTabellaSpazi();				
			}
		});
		btnSpazi.setBounds(numero.dieci, 163, numero.dimensioneColonna6, numero.ventitre);
		contentPane.add(btnSpazi);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GestioneSchede menu = new GestioneSchede();
				menu.setVisible(true);
			}
		});
		btnIndietro.setBounds(522, 305, 89, numero.ventitre);
		contentPane.add(btnIndietro);
		
		JButton btnNewButton = new JButton("Crea Scheda");
		
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				      
				leggiFile();
				
				String titolo = "Scheda del " + data.getDate()+"-" + (data.getMonth()+numero.uno)+"-" + (data.getYear()+1900) + " " + data.getHours() + " e " + data.getMinutes()+ ".txt";
				File scheda = new File(titolo);
				try {
					scheda.createNewFile();
				} catch (IOException e1) {
					LogLog.error("Your description here", e1);
				}
				
				scriviScheda(titolo);	
								
			}
		});
		btnNewButton.setBounds(numero.dieci, 286, 132, numero.ventitre);
		contentPane.add(btnNewButton);
		
		
		btnAggiungiDipendente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(table.isRowSelected(i)){
					TableModel model = table.getModel();
					Dipendente dipendente = new Dipendente(model.getValueAt(i, numero.uno).toString(), model.getValueAt(i, numero.due).toString(), model.getValueAt(i, numero.tre).toString() );
					dipendentiScheda.aggiungiDipendente(dipendente);
				}
			}
		});
		btnAggiungiDipendente.setBounds(variabile.btnSchedeLarghezza, variabile.btnSchedeAltezza, variabile.btnSchedeX, variabile.btnSchedeY);
		
		btnAggiungiStrumento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(table.isRowSelected(i)){
					TableModel model = table.getModel();
					Strumento strumento = new Strumento(model.getValueAt(i, numero.uno).toString(), model.getValueAt(i, numero.due).toString(), model.getValueAt(i, numero.tre ).toString() );
					strumentiScheda.aggiungiStrumento(strumento);
					
				}
			}
		});
		btnAggiungiStrumento.setBounds(variabile.btnSchedeLarghezza, variabile.btnSchedeAltezza, variabile.btnSchedeX, variabile.btnSchedeY);
		
		btnAggiungiSpazio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(table.isRowSelected(i)){
					TableModel model = table.getModel();
					Spazio spazio = new Spazio(model.getValueAt(i, numero.uno).toString(), model.getValueAt(i, numero.due).toString());
					spaziScheda.aggiungiSpazio(spazio);
					
				}
			}
		});
		btnAggiungiSpazio.setBounds(variabile.btnSchedeLarghezza, variabile.btnSchedeAltezza, variabile.btnSchedeX, variabile.btnSchedeY);
		
	}
	
	
	private void leggiFile(){
		 char[] in = new char[200];
		    int size = numero.zero;
		    try {
		        File file = new File(path);
		        FileReader fr = new FileReader(file);
		        size = fr.read(in);
		      	        
		        for(int i=0; i<size; i++){
		        	testoIniziale = testoIniziale + in[i];
		        }
		        
		        fr.close();
		        
		    } catch(IOException e1) { 
		    	LogLog.error("Your description here", e1);
		    }
		    
		    try {
		        File file = new File(path2);
		        FileReader fr = new FileReader(file);
		        size = fr.read(in);
		        
		        for(int i=0; i<size; i++){
		        	testoFinale = testoFinale + in[i];
		        }
		        
		        fr.close();
		        
		    } catch(IOException e1) { 
		    	LogLog.error("Your description here", e1);
		    }
	}
	
	/**
	 * Metodo che scrive su file la scheda.
	 */
	@SuppressWarnings("deprecation")
	private void scriviScheda(String titolo){
		try {
			FileWriter fw = new FileWriter(titolo);
			
			fw.write(data.getDate()+"/" + (data.getMonth()+1)+"/" + (data.getYear()+1900)+ "\r\n");
			fw.write(testoIniziale + "\r\n");
			fw.write("Elenco dipendenti: \r\n");
			for(Dipendente dip: dipendentiScheda.archivioDipendenti){
				fw.write(dip.toString());
				fw.write("\r\n");
			}
			fw.write("Elenco spazi: \r\n");
			for(Spazio spa: spaziScheda.archivioSpazi){
				fw.write(spa.toString());
				fw.write("\r\n");
			}
			fw.write("Elenco strumenti: \r\n");
			for(Strumento str: strumentiScheda.archivioStrumenti){
				fw.write(str.toString());
				fw.write("\r\n");
			}
			fw.write(testoFinale + "\r\n");
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			LogLog.error("Your description here", e1);
		}
		
		
		try {
			FileWriter fw = new FileWriter(fileName,true);
			fw.write(titolo);
			fw.write("\r\n");
			fw.close();
		} catch (IOException e1) {
			LogLog.error("Your description here", e1);
		}
	}
	
	/**
	 * Metodo che crea una tabella di dipendenti.
	 */
	private void creaTabellaDipendenti(){
		table.setModel(new DefaultTableModel(
				null,
				new String[] {
					"id", "matricola", "nome", "cognome"}
			));
			table.getColumnModel().getColumn(numero.zero).setMinWidth(numero.dimensioneColonna1);
			table.getColumnModel().getColumn(numero.uno).setPreferredWidth(numero.dimensioneColonna2);
			table.getColumnModel().getColumn(numero.uno).setMinWidth(numero.dimensioneColonna2);
			table.getColumnModel().getColumn(numero.due).setMinWidth(numero.dimensioneColonna1);
			table.getColumnModel().getColumn(numero.tre).setMinWidth(numero.dimensioneColonna1);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			scrollPane.setViewportView(table);
			mostraDipendenti();
			if(btnAggiungiStrumento.isEnabled()){
				contentPane.remove(btnAggiungiStrumento);
			}
			if(btnAggiungiSpazio.isEnabled()){
				contentPane.remove(btnAggiungiSpazio);
			}
			contentPane.add(btnAggiungiDipendente);
	}
	
	
	/**
	 * Metodo che crea una tabella di strumenti.
	 */
	private void creaTabellaStrumenti(){
		table.setModel(new DefaultTableModel(
				null,
				new String[] {
					"id", "matricola", "descrizione", "codice tipo strumento"}
			));
			table.getColumnModel().getColumn(numero.zero).setMinWidth(numero.dimensioneColonna10);
			table.getColumnModel().getColumn(numero.zero).setPreferredWidth(numero.dimensioneColonna10);
			table.getColumnModel().getColumn(numero.uno).setPreferredWidth(numero.dimensioneColonna1);
			table.getColumnModel().getColumn(numero.uno).setMinWidth(numero.dimensioneColonna1);
			table.getColumnModel().getColumn(numero.due).setMinWidth(numero.dimensioneColonna1);
			table.getColumnModel().getColumn(numero.tre).setMinWidth(numero.dimensioneColonna3);
			table.getColumnModel().getColumn(numero.tre).setPreferredWidth(numero.dimensioneColonna3);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			scrollPane.setViewportView(table);
		
			try {
				mostraStrumenti();
			} catch (SQLException | IOException e) {
				LogLog.error("Your description here", e);
			}

			if(btnAggiungiDipendente.isEnabled()){
				contentPane.remove(btnAggiungiDipendente);
			}
			if(btnAggiungiSpazio.isEnabled()){
				contentPane.remove(btnAggiungiSpazio);
			}
			
			contentPane.add(btnAggiungiStrumento);
	}
	
	
	/**
	 * Metodo che mostra su schermo tutti i dipendenti presenti in lista.
	 */
	private Set<Dipendente> getListaDipendenti(){
		
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
	private void mostraDipendenti(){
		Set<Dipendente> set = getListaDipendenti();
		List<Dipendente> lista = new ArrayList<Dipendente>();
		DefaultTableModel model = null;
		lista.addAll(set);
	
		if(table.getModel() instanceof DefaultTableModel){
			model = (DefaultTableModel)table.getModel();
			modelloTabella(model, lista);}
	}
	
	/**
	 * Metodo collegato al precedente per mostrare a video i dipendenti.
	 */
	private void modelloTabella(DefaultTableModel model, List<Dipendente> lista){
		
		Object[] riga = new Object[numero.quattro];

		if(lista != null)
		{
			for (Dipendente dip : lista) {
				riga[numero.zero] = dip.getId();
				riga[numero.uno] = dip.getMatricola();
				riga[numero.due] = dip.getNome();
				riga[numero.tre] = dip.getCognome();			
				model.addRow(riga);
			}
		}
	}
	
	/**
	 * Metodo che crea la tabella degli spazi.
	 */
	private void creaTabellaSpazi(){
		table.setModel(new DefaultTableModel(
				null,
				new String[] {
					"id", "codice spazio", "descrizione"}
			));
		table.getColumnModel().getColumn(numero.zero).setMinWidth(numero.dimensioneColonna1);
		table.getColumnModel().getColumn(numero.uno).setPreferredWidth(numero.dimensioneColonna6);
		table.getColumnModel().getColumn(numero.uno).setMinWidth(numero.dimensioneColonna6);
		table.getColumnModel().getColumn(numero.due).setMinWidth(numero.dimensioneColonna1);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.addMouseListener(null);
		scrollPane.setViewportView(table);
		mostraSpazi();
	
		if(btnAggiungiStrumento.isEnabled()){
			contentPane.remove(btnAggiungiStrumento);
		}
		if(btnAggiungiDipendente.isEnabled()){
			contentPane.remove(btnAggiungiDipendente);
		}
		contentPane.add(btnAggiungiSpazio);
	}
	
	/**
	 * Metodo che crea una lista di strumenti.
	 * @throws SQLException 
	 * @throws IOException
	 */
	private List<Strumento> getListaStrumenti() throws SQLException, IOException{
		
		List<Strumento> listaStrumenti = new ArrayList<Strumento>();
		Connection connection = LogIn.getConnection();
		String query = "SELECT * FROM strumento";
		Statement st = null;
		ResultSet rs = null;
		st = connection.createStatement();
		rs = st.executeQuery(query);
		Strumento strumento = null;
		while(rs.next()){
			strumento = new Strumento(rs.getString("matricola_strumento"), rs.getString("strumento_descrizione"), rs.getString("cd_tipo_strumento"), rs.getString("data_acquisto"), rs.getString("fornitore"), rs.getString("data_fine_garanzia"), rs.getString("data_ultima_manutenzione"), rs.getString("data_prossima_manutenzione"), rs.getString("note_strumento"));
			strumento.setId(rs.getInt("id_strumento"));
			listaStrumenti.add(strumento);
			
		}
		return listaStrumenti;
	}

	/**
	 * Metodo che mostra su schermo tutte gli strumenti presenti in lista.
	 * @throws SQLException 
	 * @throws IOException 
	 */

	private void mostraStrumenti() throws SQLException, IOException{
		DefaultTableModel model = null;
		Object[] riga = new Object[4];
		List<Strumento> lista = getListaStrumenti();

		if(table.getModel() instanceof DefaultTableModel)
		{
			model = (DefaultTableModel)table.getModel();
		}
		
		if(lista != null)
		{
			for(Strumento strumento : lista)
			{
				riga[0] = strumento.getId();
				riga[1] = strumento.getMatricola();
				riga[2] = strumento.getDescrizione();
				riga[3] = strumento.getCodiceTipoStrumento();
				model.addRow(riga);
			}
		}
	}
	
	/**
	 * Metodo che crea una lista di spazi.
	 */
	private List<Spazio> getListaSpazi(){
		
		List<Spazio> listaSpazi = new ArrayList<Spazio>();
		Connection connection = LogIn.getConnection();
		String query = "SELECT * FROM spazio";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Spazio spazio = null;
			while(rs.next()){
				spazio = new Spazio(rs.getString("cd_spazio"), rs.getString("spazio_descrizione"), rs.getInt("mq"), rs.getInt("numero_finestre"), rs.getString("cd_reparto"), rs.getInt("piano"), rs.getString("note_spazio"));
				spazio.setId(rs.getInt("id_spazio"));
				listaSpazi.add(spazio);
				
			}
		} catch (Exception e) {
			LogLog.error("Your description here", e);
		}
		return listaSpazi;
	}
	
	/**
	 * Metodo che mostra su schermo tutti gli spazi presenti in lista.
	 */
	private void mostraSpazi(){
		DefaultTableModel model = null;
		List<Spazio> lista = getListaSpazi();
		if(table.getModel() instanceof DefaultTableModel){
			model = (DefaultTableModel)table.getModel();}
		Object[] riga = new Object[8];

		if(lista != null)
		{
			for(Spazio spazio : lista)
			{
				riga[numero.zero] = spazio.getId();
				riga[numero.uno] = spazio.getCodiceSpazio();
				riga[numero.due] = spazio.getDescrizione();
				riga[numero.tre] = spazio.getMq();
				riga[numero.quattro] = spazio.getNumFinestre();
				riga[numero.cinque] = spazio.getCodiceReparto();
				riga[numero.sei] = spazio.getPiano();
				riga[numero.sette] = spazio.getNoteSpazio();		
				model.addRow(riga);
			}
		}
	}
}


