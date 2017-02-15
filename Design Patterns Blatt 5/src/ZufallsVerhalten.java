/**
 * Diese Klasse stellt das Zufallsverhalten dar.
 * @author jniedbal, rschikor
 *
 */
public class ZufallsVerhalten extends Verhalten {

	// überschreibt die Superklassen-Methode aktion
	@Override
	public int aktion(int max) {
		int ergebnis = (int) (Math.random() * max) + 1;
		return ergebnis;
	}
}
