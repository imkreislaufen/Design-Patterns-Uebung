package kuehlschrank;
/**
 * Diese abstrakte Klasse stellt den "Kühlschrank" bereit.
 * @author rschikor, jniedbal
 */
public abstract class Kuehlschrank {
	
	// private und geschützte Klassen-Attribute
	private String hersteller;
	protected int hoehe, breite, tiefe, jaehrlicherEnergieVerbrauch;
	
	/**
	 * Constructor
	 * @param hersteller String mit Herstellernamen
	 */
	public Kuehlschrank(String hersteller) {
		this.hersteller = hersteller;
	}

	/**
	 * Gibt den Herstellernamen zurück
	 * @return String mit "Siemens" oder "Miele"
	 */
	public String getHersteller() {
		return hersteller;
	}
}
