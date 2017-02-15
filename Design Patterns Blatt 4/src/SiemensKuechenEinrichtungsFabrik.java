import herd.Herd;
import herd.HerdSiemensIQ500EH875KU12E;
import kuehlschrank.Kuehlschrank;
import kuehlschrank.KuehlschrankSiemensIQ700KM40FSB20;
import ofen.Ofen;
import ofen.OfenSiemensIQ500HV541ANS0;
import schrank.Schrank;
import schrank.SchrankFoervara;

/**
 * Spezielle Siemens-Einrichtungsfabrik-Klasse.
 * @author jniedbal, rschikor
 */
public class SiemensKuechenEinrichtungsFabrik implements
		KuechenEinrichtungsFabrik {

	/**
	 * Es folgen jeweils der Constructor für Herd, Kühlschrank, Ofen und
	 * Schrank, welche alle die Siemens-bezogenen Unterklassen aufrufen und
	 * die Einrichtungen ausgeben
	 */
	
	@Override
	public Herd erstelleHerd() {
		return new HerdSiemensIQ500EH875KU12E();
	}

	@Override
	public Kuehlschrank erstelleKuehlschrank() {
		return new KuehlschrankSiemensIQ700KM40FSB20();
	}

	@Override
	public Ofen erstelleOfen() {
		return new OfenSiemensIQ500HV541ANS0();
	}

	@Override
	public Schrank erstelleSchrank(int anzahlTueren, int anzahlSchubladen) {
		return new SchrankFoervara(anzahlTueren, anzahlSchubladen);
	}
}
