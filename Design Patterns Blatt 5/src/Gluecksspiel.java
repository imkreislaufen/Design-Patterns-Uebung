import java.util.ArrayList;
import java.util.List;

/**
 * Abstrakte Glücksspielklasse, welche die beiden Spiele Kniffel und Lotto
 * ausführt und das ausgewählte Verhalten dazu nutzt.
 * @author rschikor, jniedbal
 *
 */
public abstract class Gluecksspiel {

	// geschützte Klassenvariablen für das Verhalten und die erspielten Zahlen
	protected Verhalten verhalten;
	protected List<Integer> zahlen;

	/**
	 * Constructor
	 */
	public Gluecksspiel() {
		zahlen = new ArrayList<Integer>();
	}

	/**
	 * abstrakte Spiel-Methode
	 */
	public abstract void spielen();

	/**
	 * Wählt Verhalten aus, welches zum Spielen genutzt werden soll
	 * @param v - ausgewähltes Verhalten
	 */
	public void setVerhalten(Verhalten v) {
		this.verhalten = v;
	}

}
