/**
 * Kniffel-Spiel-Klasse
 * @author jniedbal, rschikor
 *
 */
public class Kniffel extends Gluecksspiel {
	
	// private Klassenvariable, Höchstzahl der Punkte eines Würfels
	private final int SEITENZAHL = 6;
	
	// Würfel fünf Werte von 1-6, ohne auf Duplikate zu achten
	@Override
	public void spielen() {
		for (int i = 0; i < 5; i++) {
			zahlen.add(verhalten.aktion(SEITENZAHL));
		}
	}
}
