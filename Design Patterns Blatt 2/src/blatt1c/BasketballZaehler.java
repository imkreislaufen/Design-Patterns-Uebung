package blatt1c;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import blatt1a.Display;

/**
 * @author jniedbal, rschikor
 * 
 *         Implementiert die Zaehlsteuerung für den Zaehlmodus "Basketball".
 */
public class BasketballZaehler extends Zaehlsteuerung {
	private static final long serialVersionUID = 1L;

	/**
	 * Erzeugt ein Display, welches es ermöglicht, den Punktestand der
	 * Mannschaften eines Basketballspieles zu verändern.
	 * 
	 * @param listDisp
	 *            Array von Displays
	 */
	public BasketballZaehler(final Display[] listDisp) {
		super(listDisp);
		setTitle("Basketballzähler");

		// Hinzufügen weiterer Buttons für das Aufzaehlen von 2 oder 3 Punkten
		JButton punktHeim;
		JButton punktGast;
		JButton loeschen;
		JButton zweiPunkteHeim;
		JButton zweiPunkteGast;
		JButton dreiPunkteHeim;
		JButton dreiPunkteGast;

		// Fenstereigenschaften definieren
		setLocation(330, 0);
		setSize(320, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		JPanel mainPanel = new JPanel();
		setContentPane(mainPanel);
		setLayout(new GridLayout(4, 3));

		// Benennung der Buttons zum Aufzaehlen von 2 oder 3 Punkten
		punktHeim = new JButton("Punkt für Heim");
		punktHeim.setToolTipText("Punkt für die Heimmannschaft");
		punktGast = new JButton("Punkt für Gast");
		punktGast.setToolTipText("Punkt für die Gastmannschaft");
		loeschen = new JButton("Punkte zurücksetzen");
		loeschen.setToolTipText("Punktestand löschen");
		zweiPunkteHeim = new JButton("2 Punkte für Heim");
		zweiPunkteHeim.setToolTipText("2 Punkte für die Heimmannschaft");
		zweiPunkteGast = new JButton("2 Punkte für Gast");
		zweiPunkteGast.setToolTipText("2 Punkte für die Gastmannschaft");
		dreiPunkteHeim = new JButton("3 Punkte für Heim");
		dreiPunkteHeim.setToolTipText("3 Punkte für die Heimmannschaft");
		dreiPunkteGast = new JButton("3 Punkte für Gast");
		dreiPunkteGast.setToolTipText("3 Punkte für die Gastmannschaft");

		// Hinzufügen der Buttons zum Main-Panel
		add(punktHeim);
		add(punktGast);
		add(zweiPunkteHeim);
		add(zweiPunkteGast);
		add(dreiPunkteHeim);
		add(dreiPunkteGast);
		add(loeschen);

		// Erhöht den Punktestand der Heimmannschaft und ändert deren
		// Punktestand auf allen angeschlossenen Displays
		punktHeim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listDisp.length; i++) {
					listDisp[i].setPunkteHeim(++punktestandHeim);
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
			}
		});

		// Erhöht den Punktestand der Heimmannschaft und ändert deren
		// Punktestand auf allen angeschlossenen Displays
		zweiPunkteHeim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listDisp.length; i++) {
					listDisp[i].setPunkteHeim(punktestandHeim += 2);
				}
			}
		});

		// Erhöht den Punktestand der Gastmannschaft und ändert deren
		// Punktestand auf allen angeschlossenen Displays
		zweiPunkteGast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listDisp.length; i++) {
					listDisp[i].setPunkteGast(punktestandGast += 2);
				}
			}
		});// Erhöht den Punktestand der Heimmannschaft und ändert deren
			// Punktestand auf allen angeschlossenen Displays
		dreiPunkteHeim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listDisp.length; i++) {
					listDisp[i].setPunkteHeim(punktestandHeim += 3);
				}
			}
		});

		// Erhöht den Punktestand der Gastmannschaft und ändert deren
		// Punktestand auf allen angeschlossenen Displays
		dreiPunkteGast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listDisp.length; i++) {
					listDisp[i].setPunkteGast(punktestandGast += 3);
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
			}
		});

	}
}
