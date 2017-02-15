package ofen;
/**
 * Diese Klasse stellt den speziellen Miele-Ofen H6890BP bereit.
 * @author rschikor, jniedbal
 */
public class OfenMieleH6890BP extends Ofen {

	/**
	 * Constructor
	 */
	public OfenMieleH6890BP() {
		super("Miele");

		garRaumgroesse = 90;
		minTemperatur = 30;
		maxTemperatur = 300;
	}
}
