package entita;

/**
 * Classe che permette di creare l'oggetto collezione
 */
public class Concessione {

	private int id;
	private String matricola;
	private String tipoAssegnazione;
	private String dataAssegnazione;
	private String tipoStrumento;
	private String spazio;
	private String dataRilascio;
	private String note;
	
	/**
	 * Costruttore dell'oggetto collezione.
	 */
	public Concessione(String matricola, String tipoAssegnazione, String dataAssegnazione, String tipoStrumento, String spazio, String dataRilascio, String note){
		
		this.matricola = matricola;
		this.tipoAssegnazione = tipoAssegnazione;
		this.dataAssegnazione = dataAssegnazione;
		this.tipoStrumento = tipoStrumento;
		this.spazio = spazio;
		this.dataRilascio = dataRilascio;
		this.note = note;
	}

	/**
	 * Metodo che ritorna l'id della concessione.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo per settare l'id della concessione.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo che ritorna la matricola della concessione.
	 */
	public String getMatricola() {
		return matricola;
	}

	/**
	 * Metodo per settare la matricola della concessione.
	 */
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	/**
	 * Metodo che ritorna il tipo di assegnazione della concessione.
	 */
	public String getTipoAssegnazione() {
		return tipoAssegnazione;
	}

	/**
	 * Metodo per settare il tipo di assegnazione della concessione.
	 */
	public void setTipoAssegnazione(String tipoAssegnazione) {
		this.tipoAssegnazione = tipoAssegnazione;
	}

	/**
	 * Metodo che ritorna la data di assegnazione della concessione.
	 */
	public String getDataAssegnazione() {
		return dataAssegnazione;
	}

	/**
	 * Metodo per settare la data di assegnazione della concessione.
	 */
	public void setDataAssegnazione(String dataAssegnazione) {
		this.dataAssegnazione = dataAssegnazione;
	}

	/**
	 * Metodo che ritorna il tipo di strumento della concessione.
	 */
	public String getTipoStrumento() {
		return tipoStrumento;
	}

	/**
	 * Metodo per settare il tipo di strumento della concessione.
	 */
	public void setTipoStrumento(String tipoStrumento) {
		this.tipoStrumento = tipoStrumento;
	}

	/**
	 * Metodo che ritorna lo spazio della concessione.
	 */
	public String getSpazio() {
		return spazio;
	}

	/**
	 * Metodo per settare lo spazio della concessione.
	 */
	public void setSpazio(String spazio) {
		this.spazio = spazio;
	}

	/**
	 * Metodo che ritorna la data di rilascio della concessione.
	 */
	public String getDataRilascio() {
		return dataRilascio;
	}

	/**
	 * Metodo per settare la data di rilascio della concessione.
	 */
	public void setDataRilascio(String dataRilascio) {
		this.dataRilascio = dataRilascio;
	}

	/**
	 * Metodo che ritorna le note della concessione.
	 */
	public String getNote() {
		return note;
	}

	/**
	 * Metodo per settare le note della concessione.
	 */
	public void setNote(String note) {
		this.note = note;
	}
}
