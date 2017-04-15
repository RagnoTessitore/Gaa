package schede;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.helpers.LogLog;

import menu.GestioneSchede;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * Classe per eliminare le schede.
 */
@SuppressWarnings("serial")
public class EliminaSchede extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private HashSet<String> lista = new HashSet<String>();

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public EliminaSchede() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"                       Schede"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(278);
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 11, 306, 216);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				GestioneSchede menu = new GestioneSchede();
				menu.setVisible(true);
			}
		});
		btnIndietro.setBounds(301, 258, 89, 23);
		contentPane.add(btnIndietro);
		
		JButton btnElimina = new JButton("Elimina");
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(table.isRowSelected(i)){
					String s = (String)table.getValueAt(i, 0);
					File daEliminare = new File(s);
					daEliminare.delete();
					lista.remove(s);
					String path = "elenco schede.txt";
					File elencoSchede = new File(path);
					elencoSchede.delete();
					File elencoSchedeNuovo = new File(path);
					try {
						FileWriter fw = new FileWriter(elencoSchedeNuovo);
						for(String str : lista){
							fw.write(str + "\r\n");
						}
						fw.close();
					} catch (IOException e1) {
						LogLog.error("Your description here", e1);
					}
					try {
						mostraElenco();
					} catch (IOException e1) {
						LogLog.error("Your description here", e1);
					}
					
				}
			}
		});
		btnElimina.setBounds(157, 258, 89, 23);
		contentPane.add(btnElimina);
		mostraElenco();
	
	}
	
	public void mostraElenco() throws IOException{
		
		
		String path = "elenco schede.txt";
		File elencoSchede = new File(path);	
		FileReader fr = new FileReader(elencoSchede);
		BufferedReader br = new BufferedReader(fr);
		Object[] riga = new Object[1];
		DefaultTableModel model = null;
		String s = "";
		if(table.getModel() instanceof DefaultTableModel)
		{
			model = (DefaultTableModel)table.getModel();
		}
		model.setRowCount(0);
		while(true){
			
			s = br.readLine();
			
			
			if(s==null){
				break;
			}		
			if(s.isEmpty()){
				continue;
			}
			lista.add(s);
			riga[0] = s;
			model.addRow(riga);
			
		}
		br.close();
	}
}
