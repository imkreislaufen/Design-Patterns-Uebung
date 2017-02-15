package herd;
/**
 * Diese Klasse stellt den speziellen Siemens-Herd IQ500EH875KU12E bereit.
 * @author rschikor, jniedbal
 */
public class HerdSiemensIQ500EH875KU12E extends Herd {

	/**
	 * Constructor, Eigenschaften werden gesetzt
	 */
	public HerdSiemensIQ500EH875KU12E() {
		super("Siemens");
		anzahlKochfelder = 4;
		induktion = true;
	}
}
