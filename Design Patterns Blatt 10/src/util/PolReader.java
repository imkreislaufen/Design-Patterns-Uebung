package util;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

/**
 * Hilfsklasse, welche Koordinatendaten aus einer Datei einliest, und jeweils in
 * einer Array-Liste von Punkt-Arrays und einer HashMap von von Punkt-Listen
 * speichert.
 * 
 * @author rschikor, jniedbal
 *
 */
public class PolReader {

	// Datenstrukturen für die eingelesenen Werte
	protected List<Point[]> pointList;
	protected Map<Integer, List<Point>> pointMap;

	/**
	 * Constructor<br>
	 * Nutzt einenen BufferedReader, um zeilenweise die Punkt-Koordinaten eines
	 * Polygons einzulesen
	 * 
	 * @param f
	 */
	public PolReader(File f) {

		// Datenstrukturen initialisieren
		pointList = new ArrayList<Point[]>();
		pointMap = new HashMap<Integer, List<Point>>();

		// String-Array, um Teilstrings der x- und y-Koordinate einer Zeile zu
		// speichern
		String[] line;
		Point[] tmp;

		// Speichert die in der Datei angegebene Gesamtanzahl an Polygonen
		// sowie die Anzahl der Punkte pro Polygon
		int polygonCount, pointCount;

		// BufferedReader zum einlesen der Daten
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {

			polygonCount = Integer.parseInt(br.readLine());

			// Liest polygonCount-viele Punkt-Arrays für ein Polygon ein
			for (int i = 0; i < polygonCount; i++) {
				pointCount = Integer.parseInt(br.readLine());
				tmp = new Point[pointCount];

				// Liest pointCount-viele Punkte pro Polygon ein
				for (int j = 0; j < pointCount; j++) {

					// Trennt x- und y-Koordinate am Leerzeichen
					line = br.readLine().split(" ");

					// Erstellt einen neuen Point
					tmp[j] = new Point(Integer.parseInt(line[0]),
							Integer.parseInt(line[1]));
				}
				// Hinzufügen des neuen Polygons zu den Datenstrukturen...

				// ...als Array-List von Punkten zur HashMap
				pointMap.put(i, Arrays.asList(tmp));

				// ... als Array von Punkten zur ArrayList
				pointList.add(tmp);
			}

			// Abfangen der möglichen Exceptions
		} catch (FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
			JOptionPane.showMessageDialog(null, e.getLocalizedMessage(),
					"Fehler", JOptionPane.PLAIN_MESSAGE);
			System.exit(0);

		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
			JOptionPane.showMessageDialog(null, e.getLocalizedMessage(),
					"Fehler", JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
	}
}
