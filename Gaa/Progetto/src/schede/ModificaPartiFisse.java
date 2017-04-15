package schede;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.helpers.LogLog;

import menu.GestioneSchede;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * Classe per modificare le parti fisse della scheda.
 */
@SuppressWarnings("serial")
public class ModificaPartiFisse extends JFrame {

	private JPanel contentPane;

	/**
	 * Crea il frame di questa classe.
	 */
	public ModificaPartiFisse() {
		
		String path = "parteFissaIniziale.txt";
		String path2 = "parteFissaFinale.txt";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPaneIniziale = new JTextPane();
		textPaneIniziale.setBounds(50, 46, 414, 96);
		contentPane.add(textPaneIniziale);
		JLabel lblParteFissaIniziale = new JLabel("Parte fissa iniziale");
        lblParteFissaIniziale.setBounds(50, 11, 157, 24);
        contentPane.add(lblParteFissaIniziale);
        
        JTextPane textPaneFinale = new JTextPane();
        textPaneFinale.setText("");
        textPaneFinale.setBounds(50, 196, 414, 96);
        contentPane.add(textPaneFinale);
        
        JLabel lblParteFissaFinale = new JLabel("Parte fissa finale");
        lblParteFissaFinale.setBounds(50, 161, 157, 24);
        contentPane.add(lblParteFissaFinale);
        
        JButton btnSalvaModifche = new JButton("Salva Modifche");
        btnSalvaModifche.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String testo = textPaneIniziale.getText();
        		File file = new File(path);
        		FileWriter fw;
				try {
					fw = new FileWriter(file);
					fw.write(testo);
					fw.flush();
	    	        fw.close();
				} catch (IOException e) {
					LogLog.error("Your description here", e);
				}
    
        	}
        });
        btnSalvaModifche.setBounds(491, 81, 130, 23);
        contentPane.add(btnSalvaModifche);
        
        JButton btnSalvaModifche_1 = new JButton("Salva Modifche");
        btnSalvaModifche_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String testo = textPaneFinale.getText();
        		File file = new File(path2);
        		FileWriter fw;
				try {
					fw = new FileWriter(file);
					fw.write(testo);
					fw.flush();
	    	        fw.close();
				} catch (IOException e1) {
					
					LogLog.error("Your description here", e1);
				}
        	}
        });
        btnSalvaModifche_1.setBounds(491, 243, 130, 23);
        contentPane.add(btnSalvaModifche_1);
        
        JButton btnIndietro = new JButton("Indietro");
        btnIndietro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		GestioneSchede menuSchede = new GestioneSchede();
				menuSchede.setVisible(true);
        	}
        });
        btnIndietro.setBounds(514, 337, 89, 23);
        contentPane.add(btnIndietro);
        
		
		    char[] in = new char[200];
		    int size = 0;
		    try {
		        File file = new File(path);
		        FileReader fr = new FileReader(file);
		        size = fr.read(in);
		        String testo = "";
		        
		        for(int i=0; i<size; i++){
		        	testo = testo + in[i];
		        }
		        textPaneIniziale.setText(testo);
		        fr.close();
		        
		    } catch(IOException e) { 
		    	LogLog.error("Your description here", e);
		    }
		    
		    try {
		        File file = new File(path2);
		        FileReader fr = new FileReader(file);
		        size = fr.read(in);
		        String testo = "";
		        
		        for(int i=0; i<size; i++){
		        	testo = testo + in[i];
		        }
		        textPaneFinale.setText(testo);
		        fr.close();
		        
		    } catch(IOException e) { 
		    	LogLog.error("Your description here", e);
		    }
	}
}
