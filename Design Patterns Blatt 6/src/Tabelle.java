import java.awt.Color;
import java.awt.Component;
import java.util.Comparator;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * abstrakte Klasse "Tabelle" mit umgesetzter Template Method
 * @author rschikor, jniedbal
 *
 */
public abstract class Tabelle {
	
	// geschützte Klassenvariablen
	protected Spiel[] spiele;
	protected Verein[] vereine;
	protected JTable tabelle;
	protected final Color defaultBackgroundColor = new Color(245, 245, 245);

	/**
	 * Constructor
	 * @param tabellenInhalt - Array des Types Spiel mit Tabelleninhalt
	 * @param tabelle - JTable 
	 */
	public Tabelle(Spiel[] tabellenInhalt, JTable tabelle) {
		this.spiele = tabellenInhalt;
		this.tabelle = tabelle;
	}

	/**
	 * Template Method zur Auswertung und Darstellung einer Tabelle
	 * @param spielTag - Integer mit dem Spieltag
	 */
	public void tabellenRezept(int spielTag) {
		inhaltBerechnen(spielTag);
		tabelleDarstellen();
		// Hook-Methode zur farblichen Kennzeichnung besonderer Tabellenzeilen
		faerben();
	}

	/**
	 * unimplementierte/abstrakte Methode zur Berechnung der Tabellenwerte
	 * @param spielTag - Integer mit dem Spieltag
	 */
	public abstract void inhaltBerechnen(int spielTag);

	/**
	 * default Hook-Methode zum Einfärben der Tabellenzeilen
	 */
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

				// färbt die komplette Tabelle in der ausgewählten Farbe
				setBackground(defaultBackgroundColor);

				return this;
			}
		});
	}
	
	/**
	 * Darstellen der Tabelle
	 */
	public void tabelleDarstellen() {
		DefaultTableModel dtm = (DefaultTableModel) tabelle.getModel();
		// für jede neue Tabelle muss der RowCount auf 0 gesetzt werden, um ein
		// Anhängen an bereits bestehende Tabellen zu verhindern
		dtm.setRowCount(0);
		for (int i = 0; i < vereine.length; i++) {
			// füllt die Zeilen mit den Daten der Mannschaften
			dtm.addRow(new Object[] { vereine[i].position, vereine[i].name,
					vereine[i].spiele, vereine[i].punkte,
					"" + vereine[i].tore + ":" + vereine[i].gegenTore });
		}
	}
	
	class VereinsComparator implements Comparator<Verein> {

		// hier findet der Punktevergleich statt
		@Override
		public int compare(Verein arg0, Verein arg1) {
			return Integer.compare(arg1.punkte, arg0.punkte);
		}

	}
}
