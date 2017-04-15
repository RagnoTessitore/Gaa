package connessioneSicura;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe che permette di gestire una connessione sicura.
 */
@SuppressWarnings("serial")
public class Connesione extends Properties {

	/**
	 * Istanza del file contenente le proprietà della connessione.
	 */
	private File propertiesFile;
	
	/**
	 * Costruttore della classe extendedProperties.
	 */
    public Connesione(File propertiesFile) {
        this.propertiesFile = propertiesFile;
        try {
            FileReader reader = new FileReader(propertiesFile);
			
            try {
                load(reader);
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che setta la stringa della query per la connesione.
     */
    public String getMandatoryProperty(String property) {
        String propertyValue = getProperty(property);
        if (propertyValue == null) {
            throw new RuntimeException(String.format("Properties file (%s) does not contain \"%s\")", propertiesFile.getAbsolutePath(), property));
        }
        return propertyValue;
    }

    /**
     * Metodo che setta la stringa della query per la connesione.
     */
    @Override public String getProperty(String key, String defaultValue) {
        return super.getProperty(key, defaultValue);    //To change body of overridden methods use File | Settings | File Templates.
    }

    /**
     * Metodo che ritorna l'host per la connesione.
     */
	public Object getHostProperty() {
		return getProperty("host");
	}

	/**
	 * Metodo che ritorna l'user per la connesione.
	 */
	public String getUserProperty() {
		return getProperty("user");
	}

	/**
	 * Metodo che ritorna la password per la connesione.
	 */
	public String getPasswordProperty() {
		return getProperty("password");
	}
}
