/**
 * Diese Klasse stellt das unlogische Verhalten dar. 
 * @author jniedbal, rschikor
 *
 */
public class UnlogischesVerhalten extends Verhalten {

	// überschreibt die Superklassen-Methode aktion
	@Override
	public int aktion(int max) {
		int labil = (int) (System.currentTimeMillis() % max) + 1;
		return labil;
	}
}
