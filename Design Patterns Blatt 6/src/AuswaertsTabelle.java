import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JTable;

/**
 * Tabelle-Klassen-erweiternde Auswärtstabelle
 * @author rschikor, jniedbal
 *
 */
public class AuswaertsTabelle extends Tabelle {

	/**
	 * Constructor
	 * @param tabellenInhalt - Array des Types Spiel mit Tabelleninhalt
	 * @param tabelle - JTable 
	 */
	public AuswaertsTabelle(Spiel[] tabellenInhalt, JTable tabelle) {
		super(tabellenInhalt, tabelle);
		}

	// Überschreiben der Superklassenmethode zur Tabellenberechnung
	@Override
	public void inhaltBerechnen(int spielTag) {
		HashMap<String, Verein> vereinsMap = new HashMap<String, Verein>();
		for (int i = 0; i < spiele.length
				&& spiele[i].spielTag <= spielTag; i++) {
			
			if(!vereinsMap.containsKey(spiele[i].gast)) {
				vereinsMap.put(spiele[i].gast, new Verein(spiele[i].gast));
			}
			vereinsMap.get(spiele[i].gast).partieGespielt(spiele[i]);
		}
		vereine = vereinsMap.values().toArray(new Verein[0]);
		Arrays.sort(vereine, new VereinsComparator());
		
		for(int i = 0; i < vereine.length; i++) {
			vereine[i].position = i+1;
		}
	}
}
