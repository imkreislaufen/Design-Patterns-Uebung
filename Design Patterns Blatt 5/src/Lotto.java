/**
 * Lotto-Spiel-Klasse
 * @author jniedbal, rschikor
 *
 */
public class Lotto extends Gluecksspiel {
	
	// private Klassenvariable, größte vorkommende Zahl im Spiel
	private final int MAXLOTTOKUGEL = 49;
	
	// Zieht sechs Kugeln von 1-49, wobei auf Duplikate geachtet wird
	@Override
	public void spielen() {
		while (zahlen.size() < 6) {
			int zahl = verhalten.aktion(MAXLOTTOKUGEL);
			if (!zahlen.contains(zahl)) {
				zahlen.add(zahl);
			}
		}
	}
}
