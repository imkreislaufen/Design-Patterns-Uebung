package blatt1c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import blatt1a.Display;

/**
 * @author jniedbal, rschikor
 *
 *         Implementation einer Zaehlsteuerung für Zaehlmodus "Tischtennis"
 */
public class TischtennisZaehler extends Zaehlsteuerung {
	private static final long serialVersionUID = 1L;

	/**
	 * Erzeugt ein Display zur Punktestand-Veraenderung
	 * 
	 * @param listDisp
	 *            Array von Displays
	 */
	public TischtennisZaehler(Display[] listDisp) {
		super(listDisp);
		setTitle("Tischtenniszähler");
		setLocation(330, 0);
	}

	/**
	 * Überschreibt die actions-Methode der Oberklasse um die Tischtennis-
	 * Regeln bei der Punktezaehlung umzusetzen
	 * 
	 * params listDisp Array von Displays
	 */
	@Override
	public void actions(final Display[] listDisp) {
		// Erhöht den Punktestand der Heimmannschaft und ändert deren
		// Punktestand auf allen angeschlossenen Displays
		punktHeim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listDisp.length; i++) {
					listDisp[i].setPunkteHeim(++punktestandHeim);
				}
				if (punktestandHeim >= 11 && punktestandHeim > punktestandGast + 1) {
					punktHeim.setEnabled(false);
					punktGast.setEnabled(false);
				}
			}
		});

		// Erhöht den Punktestand der Gastmannschaft und ändert deren
		// Punktestand auf allen angeschlossenen Displays
		punktGast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listDisp.length; i++) {
					listDisp[i].setPunkteGast(++punktestandGast);
				}
				if (punktestandGast >= 11 && punktestandGast > punktestandHeim + 1) {
					punktHeim.setEnabled(false);
					punktGast.setEnabled(false);
				}
			}
		});

		// Löscht den Punktestand beider Mannschaften und setzt alle
		// Displays zurück
		loeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				punktestandHeim = 0;
				punktestandGast = 0;
				for (int i = 0; i < listDisp.length; i++) {
					listDisp[i].loeschen();
				}
				punktHeim.setEnabled(true);
				punktGast.setEnabled(true);
			}
		});
	}
}
