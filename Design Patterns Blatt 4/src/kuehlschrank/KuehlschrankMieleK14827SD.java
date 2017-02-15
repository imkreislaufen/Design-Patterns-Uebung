package kuehlschrank;
/**
 * Diese Klasse stellt den speziellen Miele-Kühlschrank K14827SD bereit.
 * @author rschikor, jniedbal
 */
public class KuehlschrankMieleK14827SD extends Kuehlschrank {
	
	/**
	 * Constructor mit Eigenschaften
	 */
	public KuehlschrankMieleK14827SD() {
		super("Miele");
		hoehe = 1850;
		breite = 600;
		tiefe = 630;
		jaehrlicherEnergieVerbrauch = 133;
	}

	/**
	 * Kühlschrankhöhe
	 * @return Integer mit Abmessung der Höhe
	 */
	public int getHoehe() {
		return hoehe;
	}

	/**
	 * Kühlschrankbreite
	 * @return Integer mit Breite des Kühlschrankes
	 */
	public int getBreite() {
		return breite;
	}

	/**
	 * Kühlschranktiefe
	 * @return Integer mit Tiefe des Kühlschrankes
	 */
	public int getTiefe() {
		return tiefe;
	}

	/**
	 * jährlicher Energieverbrauch
	 * @return Integer mit der Verbrauchsrate
	 */
	public int getJaehrlicherEnergieVerbrauch() {
		return jaehrlicherEnergieVerbrauch;
	}

}
