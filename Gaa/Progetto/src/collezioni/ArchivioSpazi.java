package collezioni;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import entita.Spazio;

/**
 * La classe archivio spazi serve per creare una collezione di spazi.
 */
public class ArchivioSpazi {

	/**
	 * Set di spazi.
	 */
	public Set<Spazio> archivioSpazi;
	
	/**
	 * Costruttore della classe archivio spazi.
 	*/	
	public ArchivioSpazi(){
		
		archivioSpazi = new HashSet<Spazio>();
	}
	
	/**
	 * Metodo per aggiungere uno spazio alla collezione.
	 */
	public void aggiungiSpazio(Spazio spazio){
		
		if(!archivioSpazi.contains(spazio)){
			archivioSpazi.add(spazio);
			JOptionPane.showMessageDialog(null, "Spazio aggiunto Correttamente");
		}
		
		else{
			JOptionPane.showMessageDialog(null, "Questo spazio è già presente in scheda");
		}
	}
	
	/**
	 * Metodo per rimuovere uno spazio dalla collezione.
	 */
	public void rimuoviSpazio(Spazio strumento){
		
		archivioSpazi.remove(strumento);
	}
	
	/**
	 *  Metodo per modificare i dati di uno spazio nella collezione.
	 */
	public void modificaStrumento(Spazio daTogliere, Spazio daAggiungere){
		
		rimuoviSpazio(daTogliere);
		aggiungiSpazio(daAggiungere);
	}
}
