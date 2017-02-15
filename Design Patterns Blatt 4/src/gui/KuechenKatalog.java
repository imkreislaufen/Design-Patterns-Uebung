package gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import herd.Herd;
import herd.HerdMieleKM6202;
import herd.HerdSiemensIQ500EH875KU12E;
import kuehlschrank.Kuehlschrank;
import kuehlschrank.KuehlschrankMieleK14827SD;
import kuehlschrank.KuehlschrankSiemensIQ700KM40FSB20;
import ofen.Ofen;
import ofen.OfenMieleH6890BP;
import ofen.OfenSiemensIQ500HV541ANS0;
import schrank.Schrank;
import schrank.SchrankFoervara;

/**
 * Diese Klasse stellt die GUI bereit, mit der man
 * sich seine Traumküche zusammenstellen kann.
 * @author jniedbal, rschikor
 */
public class KuechenKatalog extends JFrame {

	// ein Muss, sonst meckert der Compiler
	private static final long serialVersionUID = 1L;
	
	JRadioButton siemens;
	JRadioButton miele;
	JButton schrank;
	JButton kuehler;
	JButton ofen;
	JButton herd;
	JButton wegDamit;
	JRadioButton tuerSchrank;
	JRadioButton ladenSchrank;
	JTextField anzahlLaden;
	DefaultListModel<String> auswahl;

	public KuechenKatalog() {

		// Angabe der Fenster-Eigenschaften
		super("Küchenkatalog");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(320, 150);
		setVisible(true);
		setResizable(false);

		// Layout-Eigenschaften
		JPanel feld = new JPanel();
		setContentPane(feld);
		setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();

		cons.fill = GridBagConstraints.HORIZONTAL;

		// Buttons zur Bestätigung der Auswahl von Ofen, Herd,
		// Schrank und Kühlschrank sowie ein Button zum Löschen
		schrank = new JButton("Schrank wählen");
		schrank.setToolTipText("Schrankauswahl bestätigen");
		kuehler = new JButton("Kühlschrank wählen");
		kuehler.setToolTipText("Kühlschrankauswahl bestätigen");
		ofen = new JButton("Ofen wählen");
		ofen.setToolTipText("Ofenauswahl bestätigen");
		herd = new JButton("Herd wählen");
		herd.setToolTipText("Herdauswahl bestätigen");
		wegDamit = new JButton("Auswahl löschen");
		wegDamit.setToolTipText("Löschen der kompletten Auswahl");

		// RadioButtons für die entweder-oder-Auswahl beim Gerätehersteller
		// und für den Typ des Schrankes (mit Türen vs mit Schubladen), sowie
		// Einstellen einer Vorauswahl
		siemens = new JRadioButton("Siemens-Geräte");
		miele = new JRadioButton("Miele-Geräte");
		siemens.setSelected(true);

		tuerSchrank = new JRadioButton("Schrank mit Türen");
		ladenSchrank = new JRadioButton("Schrank mit Schubladen");
		ladenSchrank.setSelected(true);

		// scrollbares Textfeld zur Anzeige der Auswahl
		anzahlLaden = new JTextField();
		auswahl = new DefaultListModel<String>();
		JList<String> liste = new JList<String>(auswahl);
		JScrollPane scrollPane = new JScrollPane(liste);

		ButtonGroup geraete = new ButtonGroup();
		ButtonGroup schraenke = new ButtonGroup();

		// Einbetten der jeweiligen Buttons in die ButtonGroup
		geraete.add(siemens);
		geraete.add(miele);

		schraenke.add(tuerSchrank);
		schraenke.add(ladenSchrank);

		// Hinzufügen der Buttons zum Panel
		// (etwas lang, aber schöner ging´s nicht)
		cons.gridx = 0;
		cons.gridy = 0;
		feld.add(schrank, cons);

		cons.gridx = 1;
		feld.add(kuehler, cons);

		cons.gridx = 2;
		feld.add(ofen, cons);

		cons.gridx = 3;
		feld.add(herd, cons);

		cons.gridx = 0;
		cons.gridy = 1;
		feld.add(ladenSchrank, cons);

		cons.gridx = 1;
		feld.add(tuerSchrank, cons);

		cons.gridx = 2;
		feld.add(siemens, cons);

		cons.gridx = 3;
		feld.add(miele, cons);

		cons.gridx = 0;
		cons.gridy = 2;
		feld.add(anzahlLaden, cons);

		cons.gridx = 3;
		feld.add(wegDamit, cons);

		cons.gridx = 0;
		cons.gridy = 3;
		cons.gridwidth = 4;
		feld.add(scrollPane, cons);

		// automatisches Anpassen der Felder
		pack();

		// Beim Betätigen des Schrank-Wahl-Knopfes wird überprüft, welcher Typ
		// ausgewählt ist, gegebenenfalls wie viele Schubladen der Schrank
		// haben wird und dann ein entsprechender Eintrag in das Auswahl-Feld
		// geschrieben. Wir beschränken die Anzahl der Schubladen auf max 10.
		schrank.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tuerSchrank.isSelected()) {
					Schrank frank = new SchrankFoervara(4, 0);
					auswahl.addElement("Schrank Foervara mit "
							+ frank.getTueren()
							+ " Türen");
				} else if (!anzahlLaden.getText().equals("")) {
					try {
						Schrank francine = new SchrankFoervara(0, 0);
						int schubladen = Integer.parseInt(anzahlLaden.getText());
						if (schubladen > 0 && schubladen <= 10) {
							francine.setSchubladen(schubladen);
							auswahl.addElement("Schrank Foervara mit "
									+ francine.getSchubladen()
									+ " Schubladen");
						} else {
							anzahlLaden.setText("ungültige Eingabe");
						}
					} catch (NumberFormatException ex) {
						return;
					}
				} else {
					anzahlLaden.setText("ungültige Eingabe");
				}
			}
		});

		// Beim Betätigen des Knopfes der Kühlschrank-Auswahl wird überprüft,
		// welche Marke ausgewählt wurde, um einen entsprechenden Eintrag zur
		// Auswahl-Liste hinzuzufügen
		kuehler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (siemens.isSelected()) {
					Kuehlschrank cool = new KuehlschrankSiemensIQ700KM40FSB20();
					auswahl.addElement("Kühlschrank der Marke "
							+ cool.getHersteller());
				} else {
					Kuehlschrank cooler = new KuehlschrankMieleK14827SD();
					auswahl.addElement("Kühlschrank der Marke "
							+ cooler.getHersteller());
				}
			}
		});

		// Nach dem Betätigen des Herd-Auswahl-Knopfes und der Überprüfung, ob
		// es ein Siemens- oder Miele-Herd sein soll, wird die Auswahl in das
		// Textfeld geschrieben
		herd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (siemens.isSelected()) {
					Herd hestia = new HerdSiemensIQ500EH875KU12E();
					auswahl.addElement("Herd der Marke "
							+ hestia.getHersteller());
				} else {
					Herd vesta = new HerdMieleKM6202();
					auswahl.addElement("Herd der Marke "
							+ vesta.getHersteller());
				}
			}
		});

		// Bei Betätigen des Ofen-Auswahl-Knopfes wird überprüft, welche Marke
		// ausgewählt wurde, um den entsprechenden Herd in die Auswahl-Liste zu
		// schreiben
		ofen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (siemens.isSelected()) {
					Ofen prometheus = new OfenSiemensIQ500HV541ANS0();
					auswahl.addElement("Ofen der Marke "
							+ prometheus.getHersteller());
				} else {
					Ofen vulcanus = new OfenMieleH6890BP();
					auswahl.addElement("Ofen der Marke "
							+ vulcanus.getHersteller());
				}
			}
		});

		// Löscht die Auswahl (entfernt alle Einträge des Textfeldes)
		wegDamit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				auswahl.clear();
			}
		});
	}
}
