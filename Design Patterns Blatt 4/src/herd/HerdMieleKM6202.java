package herd;
/**
 * Diese Klasse stellt den speziellen Miele-Herd KM6202 bereit.
 * @author jniedbal, rschikor
 */
public class HerdMieleKM6202 extends Herd {

	/**
	 * Constructor mit Eigenschaften-Setzen
	 */
	public HerdMieleKM6202() {
		super("Miele");
		anzahlKochfelder = 4;
		induktion = false;
	}
}
