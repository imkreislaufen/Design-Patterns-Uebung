package blatt1c;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * @author rschikor, jniedbal
 * 
 *         Grafische Anzeige des Punktestandes der Mannschaften
 */
public class Display extends JFrame {
	private static final long serialVersionUID = 1L;

	/**
	 * Ändert den Punktestand der Heimmannschaft auf dem Display.
	 * 
	 * @param p
	 *            neuer Punktestand der Heimmannschaft
	 */
	public void setPunkteHeim(int p) {
		heimPunkte.setText("" + p);
	}

	/**
	 * Ändert den Punktestand der Gastmannschaft auf dem Display.
	 * 
	 * @param p
	 *            neuer Punktestand der Gastmannschaft
	 */
	public void setPunkteGast(int p) {
		gastPunkte.setText("" + p);
	}

	/**
	 * Löscht den Punktestand beider Mannschaften auf dem Display.
	 */
	public void loeschen() {
		heimPunkte.setText("" + 0);
		gastPunkte.setText("" + 0);
	}

	// GUI-Elemente definieren
	JLabel heim;
	JLabel gast;
	JLabel heimPunkte;
	JLabel gastPunkte;

	/**
	 * Display, welches den Punktestand zweier Mannschaften anzeigt
	 */
	public Display() {
		// Fenstereigenschaften definieren
		super("Display");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(320, 150);
		setVisible(true);
		setResizable(false);

		// Hauptpanel und Layout definieren
		JPanel mainPanel = new JPanel();
		setContentPane(mainPanel);
		setLayout(new GridLayout(2, 2));

		// GUI-Elemente deklarieren
		heim = new JLabel("Heim", JLabel.CENTER);
		gast = new JLabel("Gast", JLabel.CENTER);
		heimPunkte = new JLabel("0", JLabel.CENTER);
		gastPunkte = new JLabel("0", JLabel.CENTER);

		// Eigenschaften der Punkteanzeigen definieren
		Border border = BorderFactory.createLineBorder(Color.black, 2);
		heimPunkte.setOpaque(true);
		heimPunkte.setBackground(Color.white);
		heimPunkte.setBorder(border);
		gastPunkte.setOpaque(true);
		gastPunkte.setBackground(Color.white);
		gastPunkte.setBorder(border);

		// GUI-Elemente zum Hauptpanel hinzufügen
		add(heim);
		add(gast);
		add(heimPunkte);
		add(gastPunkte);
	}
}