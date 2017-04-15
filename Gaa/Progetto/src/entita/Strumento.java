package entita;

/**
 * Classe che permette di creare l'oggetto strumento.
 */
public class Strumento {

	private int id;
	private String matricola;
	private String descrizione;
	private String codiceTipoStrumento;
	private String dataAcquisto;
	private String fornitore;
	private String dataFineGaranzia;
	private String dataUltimaManutenzione;
	private String dataProssimaManutenzione;
	private String noteStrumento;
	
	/**
	 * Costruttore dell'oggetto strumento.
	 */
	public Strumento(String matricola, String descrizione, String codiceTipoStrumento, String dataAcquisto, String fornitore, String dataFineGaranzia, String dataUltimaManutenzione, String dataProssimaManutenzione, String noteStrumento)
	{
		this.setMatricola(matricola);
		this.setDescrizione(descrizione);
		this.setCodiceTipoStrumento(codiceTipoStrumento);
		this.setDataAcquisto(dataAcquisto);
		this.setFornitore(fornitore);
		this.setDataFineGaranzia(dataFineGaranzia);
		this.setDataUltimaManutenzione(dataUltimaManutenzione);
		this.setDataProssimaManutenzione(dataProssimaManutenzione);
		this.setNoteStrumento(noteStrumento);
				
	}
	
	public Strumento(String matricola, String descrizione, String codiceTipoStrumento){
		this.setMatricola(matricola);
		this.setDescrizione(descrizione);
		this.setCodiceTipoStrumento(codiceTipoStrumento);
	}

	/**
	 * Metodo che ritorna l'id dello strumento.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo che setta l'id dello strumento.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo che ritorna la matricola dello strumento.
	 */
	public String getMatricola() {
		return matricola;
	}

	/**
	 * Metodo che setta la matricola dello strumento.
	 */
	private void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	/**
	 * Metodo che ritorna la descrizione dello strumento.
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * Metodo che setta la descrizione dello strumento.
	 */
	private void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * Metodo che ritorna il codice del dipo dello strumento.
	 */
	public String getCodiceTipoStrumento() {
		return codiceTipoStrumento;
	}

	/**
	 * Metodo che setta il codice del dipo dello strumento.
	 */
	private void setCodiceTipoStrumento(String codiceTipoStrumento) {
		this.codiceTipoStrumento = codiceTipoStrumento;
	}

	/**
	 * Metodo che ritorna la data di acquisto dello strumento.
	 */
	public String getDataAcquisto() {
		return dataAcquisto;
	}

	/**
	 * Metodo che setta la data di acquisto dello strumento.
	 */
	private void setDataAcquisto(String dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}

	/**
	 * Metodo che ritorna il fornitore dello strumento.
	 */
	public String getFornitore() {
		return fornitore;
	}

	/**
	 * Metodo che setta il fornitore dello strumento.
	 */
	private void setFornitore(String fornitore) {
		this.fornitore = fornitore;
	}

	/**
	 * Metodo che ritorna la data di fine garanzia dello strumento.
	 */
	public String getDataFineGaranzia() {
		return dataFineGaranzia;
	}

	/**
	 * Metodo che setta la data di fine garanzia dello strumento.
	 */
	private void setDataFineGaranzia(String dataFineGaranzia) {
		this.dataFineGaranzia = dataFineGaranzia;
	}

	/**
	 * Metodo che ritorna la data di ultima manutenzione dello strumento.
	 */
	public String getDataUltimaManutenzione() {
		return dataUltimaManutenzione;
	}

	/**
	 * Metodo che setta la data di ultima manutenzione dello strumento.
	 */
	private void setDataUltimaManutenzione(String dataUltimaManutenzione) {
		this.dataUltimaManutenzione = dataUltimaManutenzione;
	}

	/**
	 * Metodo che ritorna la data della prossima manutenzione dello strumento.
	 */
	public String getDataProssimaManutenzione() {
		return dataProssimaManutenzione;
	}

	/**
	 * Metodo che setta la data della prossima manutenzione dello strumento.
	 */
	private void setDataProssimaManutenzione(String dataProssimaManutenzione) {
		this.dataProssimaManutenzione = dataProssimaManutenzione;
	}

	/**
	 * Metodo che ritorna le note dello strumento.
	 */
	public String getNoteStrumento() {
		return noteStrumento;
	}

	/**
	 * Metodo che setta le note dello strumento.
	 */
	private void setNoteStrumento(String noteStrumento) {
		this.noteStrumento = noteStrumento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceTipoStrumento == null) ? 0 : codiceTipoStrumento.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((matricola == null) ? 0 : matricola.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		Strumento other = (Strumento) obj;
		if (matricola == null) {
			if (other.matricola != null)
				return false;
		} else if (!matricola.equals(other.matricola))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Strumento [matricola=" + matricola + ", descrizione=" + descrizione + ", codiceTipoStrumento="
				+ codiceTipoStrumento + "]";
	}
	
}