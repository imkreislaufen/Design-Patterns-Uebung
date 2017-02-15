import herd.Herd;
import herd.HerdMieleKM6202;
import kuehlschrank.Kuehlschrank;
import kuehlschrank.KuehlschrankMieleK14827SD;
import ofen.Ofen;
import ofen.OfenMieleH6890BP;
import schrank.Schrank;
import schrank.SchrankFoervara;

/**
 * Spezielle Miehle-Einrichtungsfabrik-Klasse.
 * @author rschikor, jniedbal
 */
public class MieleKuechenEinrichtungsFabrik implements
		KuechenEinrichtungsFabrik {

	/**
	 * Es folgen jeweils der Constructor für Herd, Kühlschrank, Ofen und
	 * Schrank, welche alle die Miele-bezogenen Unterklassen aufrufen und
	 * die Einrichtungen ausgeben
	 */
	
	@Override
	public Herd erstelleHerd() {
		return new HerdMieleKM6202();
	}

	@Override
	public Kuehlschrank erstelleKuehlschrank() {
		return new KuehlschrankMieleK14827SD();
	}

	@Override
	public Ofen erstelleOfen() {
		return new OfenMieleH6890BP();
	}

	@Override
	public Schrank erstelleSchrank(int anzahlTueren, int anzahlSchubladen) {
		return new SchrankFoervara(anzahlTueren, anzahlSchubladen);
	}
}
