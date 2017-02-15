import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Hauptklasse des Programmes
 * @author rschikor, jniedbal
 *
 */
public class Main extends JFrame {

	// private Klassenattribute
	private static final long serialVersionUID = 1L;
	private JRadioButton lotto, kniffel, zfVerhalten, bnVerhalten, ulVerhalten;
	private ButtonGroup spiel, verhalten;
	private JButton aktion;
	private JLabel ergebnis, anzeige;
	private Gluecksspiel neuesSpiel;

	/**
	 * Constructor
	 */
	public Main() {
		// Fenstereigenschaften definieren
		super("Hi");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250, 200);
		setResizable(false);

		// Hauptpanel und Layout definieren
		JPanel mainPanel = new JPanel();
		setContentPane(mainPanel);
		setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();

		cons.fill = GridBagConstraints.HORIZONTAL;
		
		// GUI-Elemente definieren
		lotto = new JRadioButton("Lotto");
		kniffel = new JRadioButton("Kniffel");
		spiel = new ButtonGroup();
		spiel.add(lotto);
		spiel.add(kniffel);
		lotto.setSelected(true);
		zfVerhalten = new JRadioButton("Zufällig");
		bnVerhalten = new JRadioButton("Eingabe");
		ulVerhalten = new JRadioButton("Unlogisch");
		verhalten = new ButtonGroup();
		verhalten.add(zfVerhalten);
		verhalten.add(bnVerhalten);
		verhalten.add(ulVerhalten);
		zfVerhalten.setSelected(true);
		aktion = new JButton("Aktion");
		ergebnis = new JLabel("Ergebnis");
		anzeige = new JLabel(" ");
		
		// ActionListener für den Button "aktion"
		aktion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Verhalten v = erstelleVerhalten();
				if (lotto.isSelected()) {
					neuesSpiel = new Lotto();
				} else {
					neuesSpiel = new Kniffel();
				}
				// Startet ein neues Spiel mit dem gewählten Verhalten
				neuesSpiel.setVerhalten(v);
				neuesSpiel.spielen();
				
				// Speichert das Ergebnis des Spiels und zeigt es an
				String zahlen = neuesSpiel.zahlen.toString();
				zahlen = zahlen.substring(1, zahlen.length() - 1);
				anzeige.setText(zahlen);
			}
		});
		
		// Positionierung der GUI-Elemente
		cons.gridy = 0;
		cons.gridx = 0;
		add(lotto, cons);
		cons.gridx = 1;
		add(kniffel, cons);

		cons.gridy = 1;
		cons.gridx = 0;
		add(zfVerhalten, cons);
		cons.gridx = 1;
		add(bnVerhalten, cons);
		cons.gridx = 2;
		add(ulVerhalten, cons);

		cons.gridy = 2;
		cons.gridx = 0;
		add(aktion, cons);

		cons.gridy = 3;
		cons.gridx = 0;
		add(ergebnis, cons);

		cons.gridy = 4;
		cons.gridx = 0;
		cons.gridwidth = 2;
		add(anzeige, cons);
		setVisible(true);
	}

	/**
	 * Erstellt ein Verhalten, je nachdem welcher RadioButton ausgewählt ist
	 * @return Verhalten - konkretes Verhalten
	 */
	private Verhalten erstelleVerhalten() {
		if (zfVerhalten.isSelected()) {
			return new ZufallsVerhalten();
		} else if (bnVerhalten.isSelected()) {
			return new BenutzerVerhalten();
		} else {
			return new UnlogischesVerhalten();
		}
	}

	/**
	 * Hauptmethode
	 * @param args - Argumente
	 */
	public static void main(String[] args) {
		new Main();
	}
}
