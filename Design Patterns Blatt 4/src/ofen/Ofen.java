package ofen;
/**
 * Diese abstrakte Klasse stellt den "Ofen" bereit.
 * @author jniedbal, rschikor
 */
public abstract class Ofen {

	// private und geschützte Klassen-Attribute
	private String hersteller;
	protected int garRaumgroesse;
	protected int minTemperatur;
	protected int maxTemperatur;

	/**
	 * Constructor
	 * @param hersteller String mit Herstellernamen
	 */
	public Ofen(String hersteller) {
		this.hersteller = hersteller;
	}

	/**
	 * Herstellername
	 * @return String "Siemens" oder "Miele"
	 */
	public String getHersteller() {
		return hersteller;
	}

	/**
	 * Größe des Garraumes
	 * @return Garraumgröße des Ofens in int
	 */
	public int getGarRaumgroesse() {
		return garRaumgroesse;
	}

	/**
	 * minimale Temperatur (sowas ist gut für langsames Dörren, btw)
	 * @return Temperatur in int
	 */
	public int getMinTemperatur() {
		return minTemperatur;
	}

	/**
	 * maximale Temperatur 
	 * @return Temperatur in int
	 */
	public int getMaxTemperatur() {
		return maxTemperatur;
	}
}
