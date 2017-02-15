package schrank;
/**
 * Diese abstrakte Klasse stellt den "Schrank" bereit.
 * @author rschikor, jniedbal
 */
public abstract class Schrank {
	
	// private Klassen-Attribute
	private final static String hersteller = "IKEA";
	private int tueren, schubladen;

	/**
	 * Constructor
	 * @param hersteller String Name des Herstellers
	 * @param tueren int Anzahl der Türen
	 * @param schubladen int Anzahl der Schubladen
	 */
	public Schrank(int tueren, int schubladen) {
		this.tueren = tueren;
		this.schubladen = schubladen;
	}

	/**
	 * Festlegen der Schubladenanzahl
	 * @param anzahl Schubladenanzahl in int
	 */
	public void setSchubladen(int anzahl) {
		if (anzahl > 0 && anzahl <= 10) {
			this.schubladen = anzahl;
		}
	}
	
	/**
	 * Herstellername
	 * @return String mit Herstellernamen
	 */
	public String getHersteller() {
		return hersteller;
	}
	
	/**
	 * Türanzahl
	 * @return Anzahl der Türen
	 */
	public int getTueren() {
		return tueren;
	}

	/**
	 * Festlegen der Anzahl der Türen
	 * @param tueren int mit Anzahl der Türen
	 */
	public void setTueren(int tueren) {
		this.tueren = tueren;
	}

	/**
	 * Gibt die Anzahl der Schubladen zurück
	 * @return int mit der Schubladenanzahl
	 */
	public int getSchubladen() {
		return schubladen;
	}
}
