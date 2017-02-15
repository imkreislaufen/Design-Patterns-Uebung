package blatt1b;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import blatt1a.Display;

/**
 * @author rschikor, jniedbal
 *
 *         Erstellt eine Zaehlsteuerung, welche das Singleton-Pattern
 *         implementiert.
 */
public class Zaehlsteuerung extends JFrame {
	private static Zaehlsteuerung einzigeSteuerung;

	/**
	 * Getter für die Zaehlsteuerung
	 * 
	 * @param listDisp
	 *            Display-Array
	 * @return einzige Zaehlsteuerung
	 */
	public static Zaehlsteuerung getSteuerung(final Display[] listDisp) {
		if (einzigeSteuerung == null) {
			einzigeSteuerung = new Zaehlsteuerung(listDisp);
		}
		return einzigeSteuerung;
	}

	private static final long serialVersionUID = 1L;

	// GUI-Elemente definieren
	JButton punktHeim;
	JButton punktGast;
	JButton loeschen;

	// Punktestände definieren
	private int punktestandHeim;
	private int punktestandGast;

	/**
	 * Zählsteuerung, welche den Punktstand mehrerer Displays steuern kann
	 * 
	 * @param listDisp
	 *            Array von steuerbaren Displays
	 */
	protected Zaehlsteuerung(final Display[] listDisp) {
		// Fenstereigenschaften definieren
		super("Zählsteuerung");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(320, 150);
		setVisible(true);
		setResizable(false);

		// Hauptpanel und Layout definieren
		JPanel mainPanel = new JPanel();
		setContentPane(mainPanel);
		setLayout(new GridLayout(2, 1));

		// GUI-Elemente deklarieren
		punktHeim = new JButton("Punkt für Heim");
		punktHeim.setToolTipText("Punkt für die Heimmannschaft");
		punktGast = new JButton("Punkt für Gast");
		punktGast.setToolTipText("Punkt für die Gastmannschaft");
		loeschen = new JButton("Punkte zurücksetzen");
		loeschen.setToolTipText("Punktestand löschen");

		// Punktestände initialisieren
		punktestandHeim = 0;
		punktestandGast = 0;

		// Initialisiert die angeschlossenen Displays
		for (int i = 0; i < listDisp.length; i++) {
			listDisp[i].setPunkteHeim(0);
			listDisp[i].setPunkteGast(0);
		}

		actions(listDisp);

		// GUI-Elemente zum Hauptpanel hinzufügen
		add(punktHeim);
		add(punktGast);
		add(loeschen);
	}

	/**
	 * Hört auf die Button-Klicks und führt entsprechende Aktionen aus.
	 * 
	 * @param listDisp
	 *            Display-Array
	 */
	public void actions(final Display[] listDisp) {
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
