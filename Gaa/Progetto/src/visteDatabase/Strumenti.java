package visteDatabase;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.log4j.helpers.LogLog;

import entita.Numeri;
import entita.Strumento;
import entita.Variabili;
import menu.GestioneDatabase;
import menu.LogIn;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che consente la creazione di un menù per la gestione database degli strumenti.
 */
@SuppressWarnings("serial")
public class Strumenti extends JFrame {


	
	private JTextField textFieldMatricola;
	private JTextField textFieldDescrizione;
	private JTextField textFieldCodTipoStrumento;
	private JTextField textFieldDataAcquisto;
	private JTextField textFieldFornitore;
	private JTextField textFieldDataFineGaranzia;
	private JTextField textFieldDataUltimaManutenzione;
	private JTextField textFieldDataProssimaManutenzione;
	private JTextField textFieldNoteStrumento;
	private JTextField textFieldId;
	private JTable table_1;
	

	/**
	 * Costruttore per del menù per la gestione database degli strumenti.
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public Strumenti() throws SQLException, IOException {
		final Numeri numero = new Numeri();
		final Variabili variabile = new Variabili();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 454);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(variabile.margine, variabile.margine, variabile.margine, variabile.margine));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(145, 30, 693, 201);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table_1.getSelectedRow();
				TableModel model = table_1.getModel();
				
				textFieldId.setText(model.getValueAt(i, numero.zero).toString());
				textFieldMatricola.setText(model.getValueAt(i, numero.uno).toString());
				textFieldDescrizione.setText(model.getValueAt(i, numero.due).toString());
				textFieldCodTipoStrumento.setText(model.getValueAt(i, numero.tre).toString());
				textFieldDataAcquisto.setText(model.getValueAt(i, numero.quattro).toString());
				textFieldFornitore.setText(model.getValueAt(i, numero.cinque).toString());
				textFieldDataFineGaranzia.setText(model.getValueAt(i, numero.sei).toString());
				textFieldDataUltimaManutenzione.setText(model.getValueAt(i, numero.sette).toString());
				textFieldDataProssimaManutenzione.setText(model.getValueAt(i, numero.otto).toString());
				textFieldNoteStrumento.setText(model.getValueAt(i, numero.nove).toString());
			}
		});
		table_1.setModel(new DefaultTableModel(
			null,
			new String[] {
				"id", "matricola", "descrizione", "codice tipo strumento", "data acquisto", "fornitore", "data fine garanzia", "data ultima manutenzione", "data prossima manutenzione", "note strumento"}
		));
		table_1.getColumnModel().getColumn(numero.zero).setMinWidth(numero.dimensioneColonna10);
		table_1.getColumnModel().getColumn(numero.zero).setPreferredWidth(numero.dimensioneColonna10);
		table_1.getColumnModel().getColumn(numero.uno).setPreferredWidth(numero.dimensioneColonna1);
		table_1.getColumnModel().getColumn(numero.uno).setMinWidth(numero.dimensioneColonna1);
		table_1.getColumnModel().getColumn(numero.due).setMinWidth(numero.dimensioneColonna1);
		table_1.getColumnModel().getColumn(numero.tre).setMinWidth(numero.dimensioneColonna3);
		table_1.getColumnModel().getColumn(numero.tre).setPreferredWidth(numero.dimensioneColonna3);
		table_1.getColumnModel().getColumn(numero.quattro).setMinWidth(numero.dimensioneColonna8);
		table_1.getColumnModel().getColumn(numero.quattro).setPreferredWidth(numero.dimensioneColonna8);
		table_1.getColumnModel().getColumn(numero.cinque).setPreferredWidth(numero.dimensioneColonna8);
		table_1.getColumnModel().getColumn(numero.cinque).setMinWidth(numero.dimensioneColonna8);
		table_1.getColumnModel().getColumn(numero.sei).setMinWidth(numero.dimensioneColonna2);
		table_1.getColumnModel().getColumn(numero.sei).setPreferredWidth(numero.dimensioneColonna2);
		table_1.getColumnModel().getColumn(numero.sette).setMinWidth(numero.dimensioneColonna11);
		table_1.getColumnModel().getColumn(numero.sette).setPreferredWidth(numero.dimensioneColonna11);
		table_1.getColumnModel().getColumn(numero.otto).setMinWidth(numero.dimensioneColonna12);
		table_1.getColumnModel().getColumn(numero.otto).setPreferredWidth(numero.dimensioneColonna12);
		table_1.getColumnModel().getColumn(numero.nove).setMinWidth(numero.dimensioneColonna13);
		table_1.getColumnModel().getColumn(numero.nove).setPreferredWidth(numero.dimensioneColonna13);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table_1);
		mostraStrumenti();
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String query1 = "INSERT IGNORE INTO tipo_strumento(cd_tipo_strumento) VALUES('+textFieldCodTipoStrumento.getText()+')";
				
				Connection con = null;
				con = LogIn.getConnection();
				Statement st;
				
				try {
					st = con.createStatement();
					st.executeUpdate(query1);
				} catch (SQLException e) {
					LogLog.error("Your description here", e);
				}
				
				
				String query2 = "INSERT IGNORE INTO strumento(matricola_strumento, strumento_descrizione, cd_tipo_strumento, data_acquisto, fornitore, data_fine_garanzia, data_ultima_manutenzione, data_prossima_manutenzione, note_strumento)VALUES('"+textFieldMatricola.getText()+"','"+textFieldDescrizione.getText()+"',"+"'"+textFieldCodTipoStrumento.getText()+"','"+textFieldDataAcquisto.getText()+"','"+textFieldFornitore.getText()+"',"+"'"+textFieldDataFineGaranzia.getText()+"',"+"'"+textFieldDataUltimaManutenzione.getText()+"','"+textFieldDataProssimaManutenzione.getText()+"','"+textFieldNoteStrumento.getText()+"')";
				try {
					executeSQLQuery(query2, "Aggiunto");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					LogLog.error("Your description here", e);
				}
				
			}
		});
		btnAggiungi.setBounds(10, 30, 89, 23);
		contentPane.add(btnAggiungi);
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "UPDATE strumento SET matricola_strumento ='"+textFieldMatricola.getText()+"', strumento_descrizione ='"+textFieldDescrizione.getText()+"', cd_tipo_strumento = '"+textFieldCodTipoStrumento.getText()+"', data_acquisto = '"+textFieldDataAcquisto.getText()+"', fornitore = '"+textFieldFornitore.getText()+"', data_fine_garanzia = '"+textFieldDataFineGaranzia.getText()+"', data_ultima_manutenzione = '"+textFieldDataUltimaManutenzione.getText()+"', data_prossima_manutenzione ='"+textFieldDataProssimaManutenzione.getText()+"',note_strumento='"+ textFieldNoteStrumento.getText()+"'WHERE id_strumento ='"+textFieldId.getText()+"'";
				try {
					executeSQLQuery(query, "Aggiornato");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					LogLog.error("Your description here", e1);
				}
			}
		});
		btnModifica.setBounds(10, 72, 89, 23);
		contentPane.add(btnModifica);
		
		JButton btnElimina = new JButton("Elimina");
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "DELETE FROM strumento WHERE matricola_strumento = '"+textFieldMatricola.getText()+"'";
				try {
					executeSQLQuery(query, "Eliminato");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					LogLog.error("Your description here", e1);
				}
			}
		});
		btnElimina.setBounds(10, 117, 89, 23);
		contentPane.add(btnElimina);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.setBounds(10, 208, 89, 23);
		contentPane.add(btnIndietro);
		
		JLabel lblMatricola = new JLabel("Matricola");
		lblMatricola.setBounds(118, 269, 55, 14);
		contentPane.add(lblMatricola);
		
		textFieldMatricola = new JTextField();
		textFieldMatricola.setBounds(177, 266, 98, 20);
		contentPane.add(textFieldMatricola);
		textFieldMatricola.setColumns(numero.dieci);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setBounds(285, 269, 79, 14);
		contentPane.add(lblDescrizione);
		
		textFieldDescrizione = new JTextField();
		textFieldDescrizione.setBounds(358, 266, 98, 20);
		contentPane.add(textFieldDescrizione);
		textFieldDescrizione.setColumns(numero.dieci);
		
		JLabel lblCodiceTipoStrumento = new JLabel("Codice tipo strumento");
		lblCodiceTipoStrumento.setBounds(466, 269, 138, 14);
		contentPane.add(lblCodiceTipoStrumento);
		
		textFieldCodTipoStrumento = new JTextField();
		textFieldCodTipoStrumento.setBounds(594, 266, 86, 20);
		contentPane.add(textFieldCodTipoStrumento);
		textFieldCodTipoStrumento.setColumns(numero.dieci);
		
		JLabel lblDataAcquisto = new JLabel("Data acquisto");
		lblDataAcquisto.setBounds(690, 269, 94, 14);
		contentPane.add(lblDataAcquisto);
		
		textFieldDataAcquisto = new JTextField();
		textFieldDataAcquisto.setBounds(777, 266, 79, 20);
		contentPane.add(textFieldDataAcquisto);
		textFieldDataAcquisto.setColumns(numero.dieci);
		
		JLabel lblFornitore = new JLabel("Fornitore");
		lblFornitore.setBounds(10, 317, 55, 14);
		contentPane.add(lblFornitore);
		
		textFieldFornitore = new JTextField();
		textFieldFornitore.setBounds(75, 314, 98, 20);
		contentPane.add(textFieldFornitore);
		textFieldFornitore.setColumns(numero.dieci);
		
		JLabel lblDataFineGaranzia = new JLabel("Data fine garanzia");
		lblDataFineGaranzia.setBounds(219, 317, 121, 14);
		contentPane.add(lblDataFineGaranzia);
		
		textFieldDataFineGaranzia = new JTextField();
		textFieldDataFineGaranzia.setBounds(341, 314, 105, 20);
		contentPane.add(textFieldDataFineGaranzia);
		textFieldDataFineGaranzia.setColumns(numero.dieci);
		
		JLabel lblDataUltimaDimensione = new JLabel("Data ultima manutenzione");
		lblDataUltimaDimensione.setBounds(504, 317, 160, 14);
		contentPane.add(lblDataUltimaDimensione);
		
		textFieldDataUltimaManutenzione = new JTextField();
		textFieldDataUltimaManutenzione.setBounds(674, 314, 110, 20);
		contentPane.add(textFieldDataUltimaManutenzione);
		textFieldDataUltimaManutenzione.setColumns(numero.dieci);
		
		JLabel lblDataProssimaManutenzione = new JLabel("Data prossima manutenzione");
		lblDataProssimaManutenzione.setBounds(10, 358, 170, 14);
		contentPane.add(lblDataProssimaManutenzione);
		
		textFieldDataProssimaManutenzione = new JTextField();
		textFieldDataProssimaManutenzione.setBounds(189, 355, 98, 20);
		contentPane.add(textFieldDataProssimaManutenzione);
		textFieldDataProssimaManutenzione.setColumns(numero.dieci);
		
		JLabel lblNoteStrumento = new JLabel("Note strumento");
		lblNoteStrumento.setBounds(312, 358, 98, 14);
		contentPane.add(lblNoteStrumento);
		
		textFieldNoteStrumento = new JTextField();
		textFieldNoteStrumento.setBounds(432, 355, 424, 20);
		contentPane.add(textFieldNoteStrumento);
		textFieldNoteStrumento.setColumns(numero.dieci);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 269, 25, 14);
		contentPane.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(45, 266, 63, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(numero.dieci);
		
		btnIndietro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						GestioneDatabase gd= new GestioneDatabase();
						gd.setVisible(true);
					}
		});
				
	}
	
	/**
	 * Metodo che crea una lista di strumenti.
	 * @throws SQLException 
	 * @throws IOException
	 */
	public List<Strumento> getListaStrumenti() throws SQLException, IOException{
		
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
		Object[] riga = new Object[10];
		List<Strumento> lista = getListaStrumenti();

		if(table_1.getModel() instanceof DefaultTableModel)
		{
			model = (DefaultTableModel)table_1.getModel();
		}
		
		if(lista != null)
		{
			for(Strumento strumento : lista)
			{
				riga[0] = strumento.getId();
				riga[1] = strumento.getMatricola();
				riga[2] = strumento.getDescrizione();
				riga[3] = strumento.getCodiceTipoStrumento();
				riga[4] = strumento.getDataAcquisto();
				riga[5] = strumento.getFornitore();
				riga[6] = strumento.getDataFineGaranzia();
				riga[7] = strumento.getDataUltimaManutenzione();
				riga[8] = strumento.getDataProssimaManutenzione();
				riga[9] = strumento.getNoteStrumento();
				model.addRow(riga);
			}
		}
	}
	
	/**
	 * Metodo che esegue le query degli altri metodi.
	 * @throws SQLException 
	 */
	private void executeSQLQuery(String query, String message) throws SQLException{
		Connection con = LogIn.getConnection();
		Statement st = null;
		DefaultTableModel model = null;
		try {
			st = con.createStatement();
			if(st.executeUpdate(query) == 1){
				if(table_1.getModel() instanceof DefaultTableModel){
					model = (DefaultTableModel)table_1.getModel();
					model.setRowCount(0);}
				mostraStrumenti();
				JOptionPane.showMessageDialog(null, "Strumento"+ message + " Correttamente");
			}
			else{
				JOptionPane.showMessageDialog(null, "Spazio non "+ message);
				
			}
		} 
		catch (IOException e) {
			LogLog.error("Your description here", e);
		}
	}
	
}