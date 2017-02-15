package kuehlschrank;
/**
 * Diese Klasse stellt den speziellen Siemens-Kühlschrank IQ700KM40FSB20 bereit.
 * @author jniedbal, rschikor
 */
public class KuehlschrankSiemensIQ700KM40FSB20 extends Kuehlschrank {

	/**
	 * Constructor
	 */
	public KuehlschrankSiemensIQ700KM40FSB20() {
		super("Siemens");
		
		hoehe = 1911;
		breite = 752;
		tiefe = 715;
		jaehrlicherEnergieVerbrauch = 379;
	}

	/**
	 * Kühlschrankhöhe
	 * @return Höhe des Kühlschrankes in int
	 */
	public int getHoehe() {
		return hoehe;
	}

	/**
	 * Kühlschrankbreite
	 * @return Breite des Kühlschrankes in int
	 */
	public int getBreite() {
		return breite;
	}

	/**
	 * Kühlschranktiefe
	 * @return Tiefe des Kühlschrankes in int
	 */
	public int getTiefe() {
		return tiefe;
	}

	/**
	 * jährlicher Energieverbrauch
	 * @return Verbrauch der Energie in int
	 */
	public int getJaehrlicherEnergieVerbrauch() {
		return jaehrlicherEnergieVerbrauch;
	}
}
