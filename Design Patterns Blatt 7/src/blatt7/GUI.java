package blatt7;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 * Benutzeroberfläche zur Steuerung eines Crazy-Ventilator® vom Typ
 * "Tropic Storm™", welcher im Sommer 2016 die Märkte erobern wird.
 * 
 * @author rschikor, jniedbal
 *
 */
public class GUI extends JFrame {

	// private Klassenattribute
	private static final long serialVersionUID = 1L;
	private JButton gruen, rot, gruenrot;
	private JCheckBox isSchwenk;
	private JLabel zustand;
	private Ventilator v;

	/**
	 * Konstruktor
	 */
	public GUI() {

		// Legt Fenstereigenschaften fest
		super("Crazy-Ventilator® Tropic Storm™");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		// Hauptpanel und Layout definieren
		JPanel mainPanel = new JPanel();
		setContentPane(mainPanel);
		setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();

		// Text für deaktivierte CheckBox auf schwarz setzen
		UIManager.put("CheckBox.disabledText", new Color(0, 0, 0));

		// Buttons und Checkbox für den Schwenkmodus
		gruen = new JButton("Grüner Knopf");
		rot = new JButton("Roter Knopf");
		gruenrot = new JButton("Beide Knöpfe");
		isSchwenk = new JCheckBox("Schwenkmodus");

		// Checkbox auf false setzen und für den Benutzer unveränderbar machen
		isSchwenk.setSelected(false);
		isSchwenk.setEnabled(false);

		// Ventilator erstellen und aktuellen Zustand anzeigen lassen
		v = new Ventilator();
		zustand = new JLabel(v.getZustandsBeschreibung());

		// GUI-Elemente platzieren
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridwidth = 2;
		add(zustand, cons);

		cons.gridx = 2;
		cons.gridwidth = 1;
		add(isSchwenk, cons);

		cons.gridx = 0;
		cons.gridy = 1;
		add(rot, cons);

		cons.gridx = 1;
		add(gruen, cons);

		cons.gridx = 2;
		add(gruenrot, cons);

		setVisible(true);
		pack();

		// ActionListener für die Buttons
		rot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				v.drueckeRotenKnopf();
				zustand.setText(v.getZustandsBeschreibung());
				isSchwenk.setSelected(v.isSchwenk());
			}
		});

		gruen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				v.drueckeGruenenKnopf();
				zustand.setText(v.getZustandsBeschreibung());
				isSchwenk.setSelected(v.isSchwenk());
			}
		});

		gruenrot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				v.dreuckeBeideKnoepfe();
				isSchwenk.setSelected(v.isSchwenk());
			}
		});
	}

	/**
	 * Hauptmethode, die eine neue GUI erstellt
	 * 
	 * @param args
	 *            - Argumente als Stringarray
	 */
	public static void main(String[] args) {
		new GUI();
	}

}
