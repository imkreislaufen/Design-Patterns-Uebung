package blatt1b;

import javax.swing.SwingUtilities;

import blatt1a.Display;

/**
 * @author rschikor
 *
 *         Erzeugt ein Display zur Punktestandsanzeige sowie maximal eine
 *         Zählsteuerung, die den Punktestand des Displays verändern kann.
 */
public class Main {

	/**
	 * Stellt ein ein-elementiges Display-Array her und eine Zählsteuerung, die
	 * am erzeugten Display Veränderungen vornehmen kann.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					// Deklarieren eines Display-Arrays, das ein Display enthält
					Display[] displayList = new Display[1];
					displayList[0] = new Display();

					// Erzeugen zweier Steuerungen, die auf das selbe Display
					// zugreifen
					Zaehlsteuerung.getSteuerung(displayList);
					Zaehlsteuerung.getSteuerung(displayList);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
