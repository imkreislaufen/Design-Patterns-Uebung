import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JTable;

/**
 * Heimtabelle-Klasse, die die Tabelle-Klasse erweitert
 * @author rschikor, jniedbal
 *
 */
public class HeimTabelle extends Tabelle {

	/**
	 * Constructor
	 * @param tabellenInhalt - Array des Types Spiel mit Tabelleninhalt
	 * @param tabelle - JTable 
	 */
	public HeimTabelle(Spiel[] tabellenInhalt, JTable tabelle) {
		super(tabellenInhalt, tabelle);
	}

	// Überschreiben der Superklassenmethode zur Tabellenberechnung
	@Override
	public void inhaltBerechnen(int spielTag) {
		// HashMap zur vereinfachten Mannschaftssuche:
		// Key besteht aus Mannschaftsname und Value (aka Verein-Objekt)
		HashMap<String, Verein> vereinsMap = new HashMap<String, Verein>();
		// beginnend beim ersten Spieltag, bis zum ausgewählten Spieltag, aber
		// maximal bis zur Anzahl aller gespielen Partien
		for (int i = 0; i < spiele.length
				&& spiele[i].spielTag <= spielTag; i++) {
			
			// falls die Heimmannschaft nicht in der HashMap enthalten ist, 
			// wird sie dann hinzugefügt
			if(!vereinsMap.containsKey(spiele[i].heim)) {
				vereinsMap.put(spiele[i].heim, new Verein(spiele[i].heim));
			}
			// Berechnung der Spielestatistik für die Heimmannschaften
			vereinsMap.get(spiele[i].heim).partieGespielt(spiele[i]);
		}
		// aufsteigende Anordnung der Vereine nach Punktzahl
		vereine = vereinsMap.values().toArray(new Verein[0]);
		Arrays.sort(vereine, new VereinsComparator());
		
		// nach der Sortierung wird die Position zugeordnet
		for(int i = 0; i < vereine.length; i++) {
			vereine[i].position = i+1;
		}
	}
}
