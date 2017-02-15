/**
 * Diese Klasse stellt das benutzerdefinierte Verhalten dar.
 * @author rschikor, jniedbal
 *
 */
public class BenutzerVerhalten extends Verhalten {

	// privates Klassenattribut Eingabe
	private Input dialog;

	// überschreibt die Superklassen-Methode aktion
	@Override
	public int aktion(int max) {
		return dialog.run(max);
	}
	
	/**
	 * Constructor
	 */
	public BenutzerVerhalten() {
		dialog = new Input();
	}

}
