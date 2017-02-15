package blatt1c;

import java.util.Scanner;

import javax.swing.SwingUtilities;

import blatt1a.Display;

/**
 * @author rschikor, jniedbal
 *
 */
public class Main {

	/**
	 * Stellt ein ein-elementiges Display-Array her, sowie zwei Zählsteuerungen,
	 * die daran Veränderungen vornehmen können, entweder für den Zählmodus
	 * "Tischtennis" oder für "Basketball".
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Bitte Steuerungsart wählen:");
		System.out.println("0 - Tischtennis");
		System.out.println("1 - Basketball");
		Scanner sc = new Scanner(System.in);
		final int auswahl = sc.nextInt();
		sc.close();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					// Deklarieren eines Display-Arrays, das ein Display enthält
					Display[] displayList = new Display[1];
					displayList[0] = new Display();

					// Erzeugen zweier Steuerungen, die auf das selbe Display
					// zugreifen
					Zaehlsteuerung.getSteuerung(displayList, auswahl);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
