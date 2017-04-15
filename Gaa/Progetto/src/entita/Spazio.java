package entita;

/**
 * Classe che permette di creare l'oggetto spazio.
 */
public class Spazio {

	private int id;
	private String codiceSpazio;
	private String descrizione;
	private double mq;
	private int numFinestre;
	private String codiceReparto;
	private int piano;
	private String noteSpazio;
	
	/**
	 * Costruttore dell'oggetto spazio.
	 */
	public Spazio(String codiceSpazio, String descrizione, double mq, int numFinestre, String codiceReparto, int piano, String noteSpazio )
	{
		this.setCodiceSpazio(codiceSpazio);
		this.setDescrizione(descrizione);
		this.setMq(mq);
		this.setNumFinestre(numFinestre);
		this.setCodiceReparto(codiceReparto);
		this.setPiano(piano);
		this.setNoteSpazio(noteSpazio);
	}
	
	public Spazio(String codiceSpazio, String descrizione){
		this.setCodiceSpazio(codiceSpazio);
		this.setDescrizione(descrizione);
	}

	/**
	 * Metodo che ritorna l'id dello spazio.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo che setta l'id dello spazio.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo che ritorna il codice dello spazio.
	 */
	public String getCodiceSpazio() {
		return codiceSpazio;
	}

	/**
	 * Metodo che setta il codice dello spazio.
	 */
	private void setCodiceSpazio(String codiceSpazio) {
		this.codiceSpazio = codiceSpazio;
	}

	/**
	 * Metodo che ritorna la descrizione dello spazio.
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * Metodo che setta la descrizione dello spazio.
	 */
	private void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * Metodo che ritorna i metri quadri dello spazio.
	 */
	public double getMq() {
		return mq;
	}

	/**
	 * Metodo che setta i metri quadri dello spazio.
	 */
	private void setMq(double mq) {
		this.mq = mq;
	}

	/**
	 * Metodo che ritorna il numero di finestre dello spazio.
	 */
	public int getNumFinestre() {
		return numFinestre;
	}

	/**
	 * Metodo che setta il numero di finestre dello spazio.
	 */
	private void setNumFinestre(int numFinestre) {
		this.numFinestre = numFinestre;
	}

	/**
	 * Metodo che ritorna il codice del reparto dello spazio.
	 */
	public String getCodiceReparto() {
		return codiceReparto;
	}

	/**
	 * Metodo che setta il codice del reparto dello spazio.
	 */
	private void setCodiceReparto(String codiceReparto) {
		this.codiceReparto = codiceReparto;
	}

	/**
	 * Metodo che ritorna il piano dello spazio.
	 */
	public int getPiano() {
		return piano;
	}

	/**
	 * Metodo che setta il piano dello spazio.
	 */
	private void setPiano(int piano) {
		this.piano = piano;
	}

	/**
	 * Metodo che ritorna le note dello spazio.
	 */
	public String getNoteSpazio() {
		return noteSpazio;
	}

	/**
	 * Metodo che setta le note dello spazio.
	 */
	private void setNoteSpazio(String noteSpazio) {
		this.noteSpazio = noteSpazio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceSpazio == null) ? 0 : codiceSpazio.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		Spazio other = (Spazio) obj;
		if (codiceSpazio == null) {
			if (other.codiceSpazio != null)
				return false;
		} else if (!codiceSpazio.equals(other.codiceSpazio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Spazio [codiceSpazio=" + codiceSpazio + ", descrizione=" + descrizione + "] ";
	}
	
	
}
