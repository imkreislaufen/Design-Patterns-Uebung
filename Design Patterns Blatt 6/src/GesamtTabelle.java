import java.awt.Color;
import java.awt.Component;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * Tabelle-Klassen-erweiternde Gesamttabelle-Klasse
 * @author rschikor, jniedbal
 *
 */
public class GesamtTabelle extends Tabelle {

	/**
	 * Constructor
	 * @param tabellenInhalt - Array des Types Spiel mit Tabelleninhalt
	 * @param tabelle - JTable 
	 */
	public GesamtTabelle(Spiel[] tabellenInhalt, JTable tabelle) {
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
			// wird sie dann hinzugefügt - analog für die Auswärtsmannschaft
			if (!vereinsMap.containsKey(spiele[i].heim)) {
				vereinsMap.put(spiele[i].heim, new Verein(spiele[i].heim));
			}
			if (!vereinsMap.containsKey(spiele[i].gast)) {
				vereinsMap.put(spiele[i].gast, new Verein(spiele[i].gast));
			}
			// berechnet die Statistik der Heim- und Auswärtsmannschaft
			vereinsMap.get(spiele[i].heim).partieGespielt(spiele[i]);
			vereinsMap.get(spiele[i].gast).partieGespielt(spiele[i]);
		}
		// aufsteigende Anordnung der Vereine nach Punktzahl
		vereine = vereinsMap.values().toArray(new Verein[0]);
		Arrays.sort(vereine, new VereinsComparator());
		
		// nach der Sortierung wird die Position zugeordnet
		for (int i = 0; i < vereine.length; i++) {
			vereine[i].position = i + 1;
		}
	}

	// Hook-Methode Färben
	@Override
	public void faerben() {
		tabelle.setDefaultRenderer(Object.class,
				new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			// Java-Swing-Magie
			@Override
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected,
						hasFocus, row, column);
				
				// switch über die Tabellenzeilen:
				// Die ersten 4 Plätze werden blau gefärbt (Champions League)
				switch(row) {
				case 0:	case 1:	case 2:	case 3:
					setBackground(new Color(45, 45, 255));
					setForeground(Color.WHITE);
					break;
				// Plätze 4 und 5 werden grün gefärbt (Europa League)
				case 4: case 5:
					setForeground(Color.BLACK);
					setBackground(new Color(90, 255, 126));
					break;
				// Die letzten 3 Plätze werden rot gefärbt (Abstiegskandidaten)
				case 15: case 16: case 17:
					setBackground(new Color(255, 40, 40));
					break;
				// Standardwert
				default:
					setBackground(defaultBackgroundColor);				
				}
				return this;
			}
		});
	}
}
