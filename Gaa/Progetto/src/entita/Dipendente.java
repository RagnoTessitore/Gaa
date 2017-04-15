package entita;

/**
 * Classe che permette di creare l'oggetto dipendente.
 */
public class Dipendente {

	private int id;
	private String matricola;
	private String nome;
	private String cognome;
	private char sesso;
	private String codFiscale;
	private String telefono;
	private String cellulare;
	private String email;
	private String dataNascita;
	private String locNascita;
	private String provNascita;
	private String nazNascita;
	private String locResidenza;
	private String provResidenza;
	private String nazResidenza;
	private String tipoDocumento;
	private String codDocumento;
	
	/**
	 * Costruttore dell'oggetto dipendente.
	 */
	public Dipendente(String matricola, String nome, String cognome, char sesso, String codFiscale, String telefono, String cellulare, String email, String dataNascita, String locNascita, String provNascita, String nazNascita, String locResidenza, String provResidenza, String nazResidenza, String tipoDocumento, String codDocumento){
		
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.codFiscale = codFiscale;
		this.telefono = telefono;
		this.cellulare = cellulare;
		this.email = email;
		this.dataNascita = dataNascita;
		this.locNascita = locNascita;
		this.provNascita = provNascita;
		this.nazNascita = nazNascita;
		this.locResidenza = locResidenza;
		this.provResidenza = provResidenza;
		this.nazResidenza = nazResidenza;
		this.tipoDocumento = tipoDocumento;
		this.codDocumento = codDocumento;
	}
	
	/**
	 * Secondo costruttore dell'oggetto dipendente.
	 */
	public Dipendente(String matricola, String nome, String cognome){
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}

	/**
	 * Metodo che ritorna la matricola del dipendente.
	 */
	public String getMatricola() {
		return matricola;
	}

	/**
	 * Metodo che ritorna il nome del dipendente.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo che ritorna il cognome del dipendente.
	 */
	public String getCognome() {
		return cognome;
	}

	
	/**
	 * Metodo che ritorna il sesso del dipendente.
	 */
	public char getSesso() {
		return sesso;
	}

	
	/**
	 * Metodo che ritorna il codice fiscale del dipendente.
	 */
	public String getCodFiscale() {
		return codFiscale;
	}

	
	/**
	 * Metodo che ritorna il numero di telefono fisso del dipendente.
	 */
	public String getTelefono() {
		return telefono;
	}

	
	/**
	 * Metodo che ritorna il numero di cellulare del dipendente.
	 */
	public String getCellulare() {
		return cellulare;
	}

	
	/**
	 * Metodo che ritorna l'email del dipendente.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo che ritorna la data di nascita del dipendente.
	 */
	public String getDataNascita() {
		return dataNascita;
	}

	
	/**
	 * Metodo che ritorna la località di nascita del dipendente.
	 */
	public String getLocNascita() {
		return locNascita;
	}

	/**
	 * Metodo che ritorna la provincia di nascita del dipendente.
	 */
	public String getProvNascita() {
		return provNascita;
	}

	/**
	 * Metodo che ritorna la nazione di nascita del dipendente.
	 */
	public String getNazNascita() {
		return nazNascita;
	}

	
	/**
	 * Metodo che ritorna la località di residenza del dipendente.
	 */
	public String getLocResidenza() {
		return locResidenza;
	}

	
	/**
	 * Metodo che ritorna la provincia di residenza del dipendente.
	 */
	public String getProvResidenza() {
		return provResidenza;
	}

	
	/**
	 * Metodo che ritorna la nazione di residenza del dipendente.
	 */
	public String getNazResidenza() {
		return nazResidenza;
	}

	
	/**
	 * Metodo che ritorna il tipo di documento del dipendente.
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	
	/**
	 * Metodo che ritorna il codice del documento del dipendente.
	 */
	public String getCodDocumento() {
		return codDocumento;
	}

	
	/**
	 * Metodo che ritorna l'id del dipendente.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo che setta l'id del dipendente.
	 */
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((matricola == null) ? 0 : matricola.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		Dipendente other = (Dipendente) obj;
		if (matricola == null) {
			if (other.matricola != null)
				return false;
		} else if (!matricola.equals(other.matricola))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dipendente [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	
}
