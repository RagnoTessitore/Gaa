package collezioni;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;
import entita.Dipendente;

/**
 * La classe archivio dipendenti serve per creare una collezione di dipendenti.
 */
public class ArchivioDipendenti {

	/**
	 * Set di dipendenti.
	 */
	public Set<Dipendente> archivioDipendenti;
	
	/**
	 * Costruttore della classe archivio dipendenti.
	 */
	public ArchivioDipendenti(){
		
		archivioDipendenti = new HashSet<Dipendente>();
	}
	
	/**
	 * Metodo per aggiungere un dipdendente alla collezione.
	 */
	public void aggiungiDipendente(Dipendente dipendente){
		
		if(archivioDipendenti.contains(dipendente)){
			JOptionPane.showMessageDialog(null, "Questo dipendente è già presente in scheda");
			
		}
		
		else{
			archivioDipendenti.add(dipendente);
			JOptionPane.showMessageDialog(null, "Dipendente aggiunto Correttamente");
		}
	}
	
	/**
	 * Metodo per rimuovere un dipdendente dalla collezione.
	 */
	public void rimuoviDipendente(Dipendente dipendente){
		
		archivioDipendenti.remove(dipendente);
	}
	
	/**
	 * Metodo per modificare i dati di un dipdendente nella collezione
	 */
	public void modificaDipendente(Dipendente daTogliere, Dipendente daAggiungere){
		
		rimuoviDipendente(daTogliere);
		aggiungiDipendente(daAggiungere);
	}
}
