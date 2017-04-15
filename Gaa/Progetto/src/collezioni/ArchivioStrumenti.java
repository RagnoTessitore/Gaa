package collezioni;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import entita.Strumento;

/**
 * La classe archivio strumenti serve per creare una collezione di strumenti.
 */
public class ArchivioStrumenti {

	/**
	 * Set di strumenti.
	 */
	public Set<Strumento> archivioStrumenti;
	
	/**
	 * Costruttore della classe archivio strumenti.
	 */
	public ArchivioStrumenti(){
		
		archivioStrumenti = new HashSet<Strumento>();
	}
	
	/**
	 * Metodo per aggiungere uno strumento alla collezione.
	 */
	public void aggiungiStrumento(Strumento strumento){
		
		if(!archivioStrumenti.contains(strumento)){
			archivioStrumenti.add(strumento);
			JOptionPane.showMessageDialog(null, "Strumento aggiunto Correttamente");
		}
		
		else{
			JOptionPane.showMessageDialog(null, "Questo strumento è già presente in scheda");
		}
	}
	
	/**
	 * Metodo per rimuovere uno strumento dalla collezione.
	 */
	public void rimuoviStrumento(Strumento strumento){
		
		archivioStrumenti.remove(strumento);
	}
	
	/**
	 *  Metodo per modificare i dati di uno strumento nella collezione.
	 */
	public void modificaStrumento(Strumento daTogliere, Strumento daAggiungere){
		
		rimuoviStrumento(daTogliere);
		aggiungiStrumento(daAggiungere);
	}
}
