package visteDatabase;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import org.apache.log4j.helpers.LogLog;
import entita.Concessione;
import menu.GestioneDatabase;
import menu.LogIn;


/**
 * Classe che consente la creazione di un menù per la gestione database delle concessioni.
 */
@SuppressWarnings("serial")
public class Concessioni extends JFrame {

	private JTable table;
	private JTextField textFieldMatricola;
	private JTextField textFieldTipoA;
	private JTextField textFieldDataA;
	private JTextField textFieldTipoS;
	private JTextField textFieldSpazio;
	private JTextField textFieldDataR;
	private JTextField textFieldNote;
	private JTextField textFieldId;

	/**
	 * Costruttore per del menù per la gestione database delle concessioni.
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public Concessioni() throws SQLException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 472);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(118, 48, 772, 253);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Matricola", "Tipo Assegnazione", "Data Assegnazione", "Tipo Strumento", "Spazio", "Data Rilascio", "Note"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(160);
		table.getColumnModel().getColumn(3).setPreferredWidth(160);
		table.getColumnModel().getColumn(4).setPreferredWidth(130);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setMinWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				textFieldId.setText(model.getValueAt(i, 0).toString());
				textFieldMatricola.setText(model.getValueAt(i, 1).toString());
				textFieldTipoA.setText(model.getValueAt(i, 2).toString());
				textFieldDataA.setText(model.getValueAt(i, 3).toString());
				textFieldTipoS.setText(model.getValueAt(i, 4).toString());
				textFieldSpazio.setText(model.getValueAt(i, 5).toString());
				textFieldDataR.setText(model.getValueAt(i, 6).toString());
				textFieldNote.setText(model.getValueAt(i, 7).toString());
		
			}
		});
		scrollPane.setViewportView(table);
		mostraConcessioni();
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String query1 = "INSERT IGNORE INTO tipo_strumento(cd_tipo_strumento) VALUES(' +textFieldTipoS.getText()+')";		
				Connection con = null;
				con = LogIn.getConnection();
				Statement st = null;
				try {
					st = con.createStatement();
					st.executeUpdate(query1);
					
				} 
				catch (SQLException e) {
					
					LogLog.error("Your description here", e);
				}
				
				String query = " INSERT IGNORE INTO dipendente_assegnazione(matricola_dipendente, cd_tipo_assegnazione, data_assegnazione, cd_tipo_strumento, cd_spazio, data_rilascio, note_dipendente_assegnazione)VALUES('"+textFieldMatricola.getText()+"','"+textFieldTipoA.getText()+"', '"+textFieldDataA.getText()+"','"+textFieldTipoS.getText()+"', '"+textFieldSpazio.getText()+"', '"+textFieldDataR.getText()+"', '"+textFieldNote.getText()+"') ";
				try {
					executeSQLQuery(query, "Inserito");
				} 
				catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					LogLog.error("Your description here", e);
				}
				
				try {
					con.close();
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					LogLog.error("Your description here", e);
				}
				
				try {
					st.close();
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					LogLog.error("Your description here", e);
				}
			}
		});
		btnAggiungi.setBounds(10, 79, 89, 23);
		contentPane.add(btnAggiungi);
		
		JButton btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "UPDATE dipendente_assegnazione SET matricola_dipendente ='"+textFieldMatricola.getText()+"', cd_tipo_assegnazione ='"+textFieldTipoA.getText()+"', data_assegnazione = '"+textFieldDataA.getText()+"', cd_tipo_strumento = '"+textFieldTipoS.getText()+"', cd_spazio = '"+textFieldSpazio.getText()+"', data_rilascio = '"+textFieldDataR.getText()+"', note_dipendente_assegnazione = '"+textFieldNote.getText()+"' WHERE id_dipendente ='"+textFieldId.getText()+"'";
				try {
					executeSQLQuery(query, "Aggiornato");
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					LogLog.error("Your description here", e1);
				}
			}
		});
		btnAggiorna.setBounds(10, 113, 89, 23);
		contentPane.add(btnAggiorna);
		
		JButton btnElimina = new JButton("Elimina");
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "DELETE FROM dipendente_assegnazione WHERE id_dipendente_assegnazione = '"+textFieldId.getText()+"'";
				try {
					executeSQLQuery(query, "Eliminato");
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					LogLog.error("Your description here", e);
				}
			}
		});
		btnElimina.setBounds(10, 147, 89, 23);
		contentPane.add(btnElimina);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					GestioneDatabase gd= new GestioneDatabase();
					gd.setVisible(true);
				}
		});
		btnIndietro.setBounds(10, 181, 89, 23);
		contentPane.add(btnIndietro);
		
		JLabel lblMatricola = new JLabel("Matricola");
		lblMatricola.setBounds(10, 333, 68, 14);
		contentPane.add(lblMatricola);
		
		textFieldMatricola = new JTextField();
		textFieldMatricola.setBounds(73, 330, 86, 20);
		contentPane.add(textFieldMatricola);
		textFieldMatricola.setColumns(10);
		
		JLabel lblTipoAssegnazione = new JLabel("Tipo Assegnazione");
		lblTipoAssegnazione.setBounds(187, 333, 120, 14);
		contentPane.add(lblTipoAssegnazione);
		
		textFieldTipoA = new JTextField();
		textFieldTipoA.setBounds(317, 330, 86, 20);
		contentPane.add(textFieldTipoA);
		textFieldTipoA.setColumns(10);
		
		JLabel lblDataAssegnazione = new JLabel("Data Assegnazione");
		lblDataAssegnazione.setBounds(425, 333, 120, 14);
		contentPane.add(lblDataAssegnazione);
		
		textFieldDataA = new JTextField();
		textFieldDataA.setBounds(555, 330, 86, 20);
		contentPane.add(textFieldDataA);
		textFieldDataA.setColumns(10);
		
		JLabel lblTipoStrumento = new JLabel("Tipo Strumento");
		lblTipoStrumento.setBounds(661, 333, 111, 14);
		contentPane.add(lblTipoStrumento);
		
		textFieldTipoS = new JTextField();
		textFieldTipoS.setBounds(772, 330, 86, 20);
		contentPane.add(textFieldTipoS);
		textFieldTipoS.setColumns(10);
		
		JLabel lblSpazio = new JLabel("Spazio");
		lblSpazio.setBounds(10, 386, 68, 14);
		contentPane.add(lblSpazio);
		
		textFieldSpazio = new JTextField();
		textFieldSpazio.setBounds(88, 383, 86, 20);
		contentPane.add(textFieldSpazio);
		textFieldSpazio.setColumns(10);
		
		JLabel lblDataRilascio = new JLabel("Data Rilascio");
		lblDataRilascio.setBounds(230, 386, 77, 14);
		contentPane.add(lblDataRilascio);
		
		textFieldDataR = new JTextField();
		textFieldDataR.setBounds(317, 383, 86, 20);
		contentPane.add(textFieldDataR);
		textFieldDataR.setColumns(10);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setBounds(444, 386, 46, 14);
		contentPane.add(lblNote);
		
		textFieldNote = new JTextField();
		textFieldNote.setBounds(500, 383, 358, 20);
		contentPane.add(textFieldNote);
		textFieldNote.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(32, 256, 46, 14);
		contentPane.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(21, 281, 86, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
	
	}
	
	
	/**
	 * Metodo che crea una lista di concessioni.
	 * @throws SQLException
	 * @throws IOException 
	 */
	public List<Concessione> getListaConcessioni() throws SQLException, IOException{
		
		List<Concessione> listaConcessioni = new ArrayList<Concessione>();
		Connection connection = LogIn.getConnection();
		String query = "SELECT * FROM dipendente_assegnazione";
		Statement st = null;
		ResultSet rs = null;
		st = connection.createStatement();
		rs = st.executeQuery(query);
		Concessione concessione = null;
		while(rs.next()){
			
			concessione = new Concessione(rs.getString("matricola_dipendente"), rs.getString("cd_tipo_assegnazione"), rs.getString("data_assegnazione"), rs.getString("cd_tipo_strumento"), rs.getString("cd_spazio"), rs.getString("data_rilascio"), rs.getString("note_dipendente_assegnazione"));
			concessione.setId(rs.getInt("id_dipendente_assegnazione"));
			listaConcessioni.add(concessione);
			
		}
		connection.close();
		st.close();
		rs.close();
		return listaConcessioni;
	}
	
	/**
	 * Metodo che mostra su schermo tutte le concessioni presenti in lista.
	 * @throws SQLException 
	 * @throws IOException 
	 */
	private void mostraConcessioni() throws SQLException, IOException{
		DefaultTableModel model = null;
		List<Concessione> lista = getListaConcessioni();
		if(table.getModel() instanceof DefaultTableModel){
			model = (DefaultTableModel)table.getModel();}
		Object[] riga = new Object[8];
		
		if(lista != null)
		{
			for (Concessione conc : lista) {
				riga[0] = conc.getId();
				riga[1] = conc.getMatricola();
				riga[2] = conc.getTipoAssegnazione();
				riga[3] = conc.getDataAssegnazione();
				riga[4] = conc.getTipoStrumento();
				riga[5] = conc.getSpazio();
				riga[6] = conc.getDataRilascio();
				riga[7] = conc.getNote();
				model.addRow(riga);
			}
		}
	}
	
	/**
	 * Metodo che esegue le query degli altri metodi.
	 * @throws SQLException 
	 * @throws IOException 
	 */
	private void executeSQLQuery(String query, String message) throws SQLException, IOException{
		Connection con = LogIn.getConnection();
		Statement st = null;
		DefaultTableModel model = null;
		try {
			st = con.createStatement();
			if(st.executeUpdate(query) == 1){
				if(table.getModel() instanceof DefaultTableModel){
					model = (DefaultTableModel)table.getModel();
					model.setRowCount(0);}
				mostraConcessioni();
				JOptionPane.showMessageDialog(null, "Concessione "+ message + " Correttamente");
			}
			else{
				JOptionPane.showMessageDialog(null, "Concessione non "+ message);
				
			}
		} catch (IOException e) {
			LogLog.error("Your description here", e);
		}
		
		con.close();
		st.close();
	}
}
