package herd;
/**
 * Diese abstrakte Klasse stellt den "Herd" bereit.
 * @author rschikor, jniedbal
 */
public abstract class Herd {

	// private oder geschützte Attribute der Klasse
	private String hersteller;
	protected int anzahlKochfelder;
	protected boolean induktion;

	/**
	 * Constructor
	 * @param hersteller String mit Herstellernamen (Siemens vs Miele)
	 */
	public Herd(String hersteller) {
		this.hersteller = hersteller;
	}

	/**
	 * Gibt den Herstellernamen zurück
	 * @return String mit "Siemens" oder "Miele"
	 */
	public String getHersteller() {
		return hersteller;
	}

	/**
	 * Gibt die Anzahl der Kochfelder zurück
	 * @return Integer mit der Kochfeldanzahl
	 */
	public int getAnzahlKochfelder() {
		return anzahlKochfelder;
	}

	/**
	 * Gibt an, ob es sich um einen Induktionsherd handelt (oder nicht)
	 * @return true/false, jenachdem, ob es ein Induktionsherd ist
	 */
	public boolean isInduktion() {
		return induktion;
	}
}
