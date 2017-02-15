package schrank;
/**
 * Diese Klasse stellt den speziellen IKEA-Schrank "Foervara" bereit.
 * @author rschikor, jniedbal
 */
public class SchrankFoervara extends Schrank {
	
	/**
	 * Constructor
	 * @param anzahlTueren int mit Türanzahl
	 * @param anzahlSchubladen int mit Schubladenanzahl
	 */
	public SchrankFoervara(int anzahlTueren, int anzahlSchubladen) {
		super(anzahlTueren, anzahlSchubladen);
	}
}
