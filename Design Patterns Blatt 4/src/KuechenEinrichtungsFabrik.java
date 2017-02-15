import herd.Herd;
import kuehlschrank.Kuehlschrank;
import ofen.Ofen;
import schrank.Schrank;

/**
 * Interface für die Basis-Einrichtungen.
 * @author jniedbal, rschikor
 */
public interface KuechenEinrichtungsFabrik {
	
	// Constructor der einzelnen Küchen-Einrichtungen
	public Herd erstelleHerd();
	public Kuehlschrank erstelleKuehlschrank();
	public Ofen erstelleOfen();
	public Schrank erstelleSchrank(int anzahlTueren, int anzahlSchubladen);
}
