package util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import array.ArrayIterator;
import array.ArrayIterator50;
import list.ListIterator;
import list.ListIterator50;

/**
 * Diese Klasse erweitert JPanel so, dass aus einer eingelesenen Datei eine
 * Deutschlandkarte aus deren enthaltenen Koordinaten der Bundesländer-Polygone
 * gezeichnet werden kann
 * 
 * @author rschikor, jniedbal
 *
 */
public class MapPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private PolReader pr = new PolReader(new File("Deutschland.pol"));
	private boolean isList, isAccurate, isColored;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Point> iterator;

		/**
		 * Prüft, ob eine Liste von Point-Arrays die zugrundeliegende
		 * Datenstruktur sein soll...
		 */
		if (isList) {
			for (Point[] pts : pr.pointList) {

				// Prüft ob jede Koordinate oder nur jede 50-ste verwendet wird
				if (isAccurate) {
					iterator = new ArrayIterator(pts);
				} else {
					iterator = new ArrayIterator50(pts);
				}
				createPolygon(iterator, g);
			}
			/**
			 * ... oder eine Map von Point-Listen
			 */
		} else {
			for (List<Point> pts : pr.pointMap.values()) {

				// Prüft ob jede Koordinate oder nur jede 50-ste verwendet wird
				if (isAccurate) {
					iterator = new ListIterator(pts);
				} else {
					iterator = new ListIterator50(pts);
				}
				createPolygon(iterator, g);
			}
		}
	}

	/**
	 * Überschreiben der PaintComponent-Methode um das EM-Spezial umsetzen zu
	 * können
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Färbt die Map in drei gleichgroßen Teilen in den Farben der
		// deutschen Nationalflagge
		if (isColored) {
			int height = getHeight(), width = getWidth();
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, width, height / 3);
			g.setColor(new Color(221, 0, 0));
			g.fillRect(0, height / 3, width, height / 3);
			g.setColor(new Color(255, 206, 0));
			g.fillRect(0, 2 * height / 3, width, height / 3);
		}
	}

	/**
	 * Hilfsmethode, welche ein Polygon mit Hilfe eines spezifischen Iterators
	 * erstellt und zeichnet
	 * 
	 * @param iterator
	 *            - Ausgewählter Iterator
	 * @param g
	 *            - Übergebene Grafik
	 */
	private void createPolygon(Iterator<Point> iterator, Graphics g) {
		Polygon poly = new Polygon();

		while (iterator.hasNext()) {
			Point p = iterator.next();
			poly.addPoint(p.x, p.y);
		}
		if (!isColored) {
			g.setColor(Color.BLACK);
		} else {
			g.setColor(Color.CYAN);
		}
		g.drawPolygon(poly);
	}

	/**
	 * Setter für isList
	 * 
	 * @param isList
	 */
	public void setList(boolean isList) {
		this.isList = isList;
	}

	/**
	 * Setter für isAccurate
	 * 
	 * @param isAccurate
	 */
	public void setAccurate(boolean isAccurate) {
		this.isAccurate = isAccurate;
	}

	/**
	 * Setter für isColored
	 * 
	 * @param isColored
	 */
	public void setColored(boolean isColored) {
		this.isColored = isColored;
	}

}
