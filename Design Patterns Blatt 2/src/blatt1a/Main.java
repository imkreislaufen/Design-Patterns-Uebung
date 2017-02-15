package blatt1a;

import javax.swing.SwingUtilities;

/**
 * @author jniedbal, rschikor
 * 
 *         Erzeugt ein Display zur Punktestandsanzeige sowie zwei
 *         Zählsteuerungen, die den Punktestand des Displays verändern können.
 */
public class Main {

	/**
	 * Stellt ein ein-elementiges Display-Array her, sowie zwei Zählsteuerungen,
	 * die daran Veränderungen vornehmen können.
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
					new Zaehlsteuerung(displayList);
					new Zaehlsteuerung(displayList);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
