package entita;

/**
 * Classe che permette di creare l'oggetto utente.
 */
public class Utente {
	
	private int id;
	private String username;
	private	String password;
	private boolean autorizzazione_database = false;
	private boolean autorizzazione_utenti = false;
	
	/**
	 * Costruttore dell'oggetto utente.
	 */
	public Utente(String username, boolean aut1, boolean aut2){
		
		this.username = username;
		this.autorizzazione_database = aut1;
		this.autorizzazione_utenti = aut2;
	}

	/**
	 * Metodo che ritorna l'username dell'utente.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Metodo che setta l'username dell'utente.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Metodo che ritorna un booleano riguardo l'autorizzazione al database dell'utente.
	 */
	public boolean isAutorizzazioneDatabase() {
		return autorizzazione_database;
	}

	/**
	 * Metodo che setta un booleano riguardo l'autorizzazione al database dell'utente.
	 */
	public void setAutorizzazioneDatabase(boolean autorizzazione_database) {
		this.autorizzazione_database = autorizzazione_database;
	}

	/**
	 * Metodo che ritorna un booleano riguardo l'autorizzazione alla modifica degli utenti dell'utente.
	 */
	public boolean isAutorizzazioneUtenti() {
		return autorizzazione_utenti;
	}

	/**
	 * Metodo che setta un booleano riguardo l'autorizzazione alla modifica degli utenti dell'utente.
	 */
	public void setAutorizzazioneUtenti(boolean autorizzazione_utenti) {
		this.autorizzazione_utenti = autorizzazione_utenti;
	}

	/**
	 * Metodo che ritorna la password dell'utente.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Metodo che setta la password dell'utente.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Metodo che ritorna l'id dell'utente.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo che setta l'id dell'utente.
	 */
	public void setId(int id) {
		this.id = id;
	}
}



