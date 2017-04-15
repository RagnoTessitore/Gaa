package visteDatabase;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.log4j.helpers.LogLog;

import entita.Spazio;
import entita.Variabili;
import menu.GestioneDatabase;
import menu.LogIn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Classe che consente la creazione di un menù per la gestione database degli spazi.
 */
@SuppressWarnings("serial")
public class Spazi extends JFrame {

	
	private JTextField textFieldCodSpazio;
	private JTextField textFieldDescrizione;
	private JTextField textFieldMq;
	private JTextField textFieldNFinestre;
	private JTextField textFieldPiano;
	private JTextField textFieldNoteSpazio;
	private JTable table_1;
	private JTextField textFieldCodReparto;
	private JTextField textFieldId;



	/**
	 * Costruttore per del menù per la gestione database degli spazi.
	 */
	public Spazi() {
		
		final Variabili variabile = new Variabili();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 397);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(variabile.margine, variabile.margine, variabile.margine, variabile.margine));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 940, 354);
		contentPane.add(panel);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				String query1 = "INSERT IGNORE INTO reparto(cd_reparto) VALUES(' +textFieldCodReparto.getText()+')";
				
				Connection con = LogIn.getConnection();
				Statement st;
				try {
					st = con.createStatement();
					st.executeUpdate(query1);
					
				} catch (SQLException e) {
					
					LogLog.error("Your description here", e);
				}
				
				String query2 = "INSERT IGNORE INTO spazio(cd_spazio, spazio_descrizione, mq, numero_finestre, cd_reparto, piano, note_spazio)VALUES('"+textFieldCodSpazio.getText()+"','"+textFieldDescrizione.getText()+"',"+"'"+textFieldMq.getText()+"','"+textFieldNFinestre.getText()+"','"+textFieldCodReparto.getText()+"',"+"'"+textFieldPiano.getText()+"',"+"'"+textFieldNoteSpazio.getText()+"')";
				executeSQLQuery(query2, "Aggiunto");
			}
		});
		btnAggiungi.setBounds(10, 30, 89, 23);
		panel.add(btnAggiungi);
		
		JButton btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "UPDATE spazio SET cd_spazio ='"+textFieldCodSpazio.getText()+"', spazio_descrizione ='"+textFieldDescrizione.getText()+"', mq = '"+textFieldMq.getText()+"', numero_finestre = '"+textFieldNFinestre.getText()+"', cd_reparto = '"+textFieldCodReparto.getText()+"', piano = '"+textFieldPiano.getText()+"', note_spazio = '"+textFieldNoteSpazio.getText()+"' WHERE id_spazio ='"+textFieldId.getText()+"'";
				executeSQLQuery(query, "Aggiornato");
			}
		});
		btnAggiorna.setBounds(10, 66, 89, 23);
		panel.add(btnAggiorna);
		
		JButton btnElimina = new JButton("Elimina");
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "DELETE FROM spazio WHERE cd_spazio = '"+textFieldCodSpazio.getText()+"'";
				executeSQLQuery(query, "Eliminato");
			}
		});
		btnElimina.setBounds(10, 100, 89, 23);
		panel.add(btnElimina);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						GestioneDatabase gd= new GestioneDatabase();
						gd.setVisible(true);
					}
		});
		btnIndietro.setBounds(10, 204, 89, 23);
		panel.add(btnIndietro);
	
		panel.setLayout(null);
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(117, 11, 796, 216);
		panel.add(scrollPane);
		
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table_1.getSelectedRow();
				TableModel model = table_1.getModel();
				
				textFieldId.setText(model.getValueAt(i, 0).toString());
				textFieldCodSpazio.setText(model.getValueAt(i, 1).toString());
				textFieldDescrizione.setText(model.getValueAt(i, 2).toString());
				textFieldMq.setText(model.getValueAt(i, 3).toString());
				textFieldNFinestre.setText(model.getValueAt(i, 4).toString());
				textFieldCodReparto.setText(model.getValueAt(i, 5).toString());
				textFieldPiano.setText(model.getValueAt(i, 6).toString());
				textFieldNoteSpazio.setText(model.getValueAt(i, 7).toString());
			}
		});
		table_1.setModel(new DefaultTableModel(
			null,
			new String[] {
				"id", "codice spazio", "descrizione", "mq", "numero finestre", "codice reparto", "piano", "note spazio"	}
		));
		table_1.getColumnModel().getColumn(0).setMinWidth(75);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(1).setMinWidth(100);
		table_1.getColumnModel().getColumn(2).setMinWidth(75);
		table_1.getColumnModel().getColumn(3).setMinWidth(40);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(40);
		table_1.getColumnModel().getColumn(4).setMinWidth(100);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(130);
		table_1.getColumnModel().getColumn(5).setMinWidth(110);
		table_1.getColumnModel().getColumn(6).setMinWidth(75);
		table_1.getColumnModel().getColumn(7).setMinWidth(200);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table_1);
		mostraSpazi();
		
		JLabel lblCodiceSpazio = new JLabel("Codice Spazio");
		lblCodiceSpazio.setBounds(163, 252, 95, 14);
		panel.add(lblCodiceSpazio);
		
		textFieldCodSpazio = new JTextField();
		textFieldCodSpazio.setBounds(268, 249, 89, 20);
		panel.add(textFieldCodSpazio);
		textFieldCodSpazio.setColumns(10);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setBounds(367, 252, 66, 14);
		panel.add(lblDescrizione);
		
		textFieldDescrizione = new JTextField();
		textFieldDescrizione.setBounds(443, 249, 95, 20);
		panel.add(textFieldDescrizione);
		textFieldDescrizione.setColumns(10);
		
		JLabel lblMq = new JLabel("Mq");
		lblMq.setBounds(548, 252, 36, 14);
		panel.add(lblMq);
		
		textFieldMq = new JTextField();
		textFieldMq.setBounds(594, 249, 66, 20);
		panel.add(textFieldMq);
		textFieldMq.setColumns(10);
		
		JLabel lblNumeroFinestre = new JLabel("Numero Finestre");
		lblNumeroFinestre.setBounds(670, 252, 95, 14);
		panel.add(lblNumeroFinestre);
		
		textFieldNFinestre = new JTextField();
		textFieldNFinestre.setBounds(775, 249, 36, 20);
		panel.add(textFieldNFinestre);
		textFieldNFinestre.setColumns(10);
		
		JLabel lblPiano = new JLabel("Piano");
		lblPiano.setBounds(821, 252, 46, 14);
		panel.add(lblPiano);
		
		textFieldPiano = new JTextField();
		textFieldPiano.setBounds(877, 249, 36, 20);
		panel.add(textFieldPiano);
		textFieldPiano.setColumns(10);
		
		JLabel lblNoteSpazio = new JLabel("Note Spazio");
		lblNoteSpazio.setBounds(249, 288, 75, 14);
		panel.add(lblNoteSpazio);
		
		textFieldNoteSpazio = new JTextField();
		textFieldNoteSpazio.setBounds(328, 285, 507, 20);
		panel.add(textFieldNoteSpazio);
		textFieldNoteSpazio.setColumns(10);
		
		JLabel lblCodiceReparto = new JLabel("Codice Reparto");
		lblCodiceReparto.setBounds(19, 288, 89, 14);
		panel.add(lblCodiceReparto);
		
		textFieldCodReparto = new JTextField();
		textFieldCodReparto.setBounds(118, 285, 86, 20);
		panel.add(textFieldCodReparto);
		textFieldCodReparto.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(19, 252, 17, 14);
		panel.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(46, 249, 86, 20);
		panel.add(textFieldId);
		textFieldId.setColumns(10);
		
	}

	/**
	 * Metodo che crea una lista di spazi.
	 */
	public List<Spazio> getListaSpazi(){
		
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
		if(table_1.getModel() instanceof DefaultTableModel){
			model = (DefaultTableModel)table_1.getModel();}
		Object[] riga = new Object[8];

		if(lista != null)
		{
			for(Spazio spazio : lista)
			{
				riga[0] = spazio.getId();
				riga[1] = spazio.getCodiceSpazio();
				riga[2] = spazio.getDescrizione();
				riga[3] = spazio.getMq();
				riga[4] = spazio.getNumFinestre();
				riga[5] = spazio.getCodiceReparto();
				riga[6] = spazio.getPiano();
				riga[7] = spazio.getNoteSpazio();		
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
				mostraSpazi();
				JOptionPane.showMessageDialog(null, "Spazio "+ message + " Correttamente");
			}
			else{
				JOptionPane.showMessageDialog(null, "Spazio non "+ message + " perchè codice spazio deve essere unico");
				
			}
		} catch (Exception e) {
			LogLog.error("Your description here", e);
		}
	}
}
