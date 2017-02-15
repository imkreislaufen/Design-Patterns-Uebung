package blatt9;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import components.Cabin;
import components.Car;
import components.Combination;
import components.Paraglider;

public class TouristAgency extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// GUI-Elemente
	private JRadioButton highSeasonSelection, lowSeasonSelection;
	private ButtonGroup seasonSelection;
	private JCheckBox bookCabin, bookCar, bookParaglider;

	// Ergebnis-Anzeige
	private JList<Combination> bookedComponents;
	private JScrollPane scrollPane;
	private DefaultListModel<Combination> choices;

	// Die verschiedenen Hütten, Gondeln, Gleitschirme im Programm
	private Cabin standardCabin, fourBedsBalcony;
	private Car standardCar, standardGlassFloorCar;
	private Paraglider standardSolo, motorizedTandem;

	// Variablen die für die geforderten Kombinationen notwendig sind
	private float price;
	private String combinationDescription;
	private Combination combination;
	private Cabin[] cabins;
	private Car[] cars;
	private Paraglider[] paras;

	// Visitor für das Pattern
	private Visitor season;

	/**
	 * Constructor<br>
	 * Erstellt eine GUI mit der man zwischen <b>Haupt-</b> und
	 * <b>Nebensaison</b> auswählen, und sich alle möglichen
	 * Buchungskombinationen von mindestens <b>zwei</b> Kategorien anzeigen
	 * lassen kann. Diese werden nach dem Gesamtpreis absteigend in einem
	 * Scrollpane angezeigt, und ermöglicht es dem Benutzer durch Anklicken
	 * einer Buchungskombination weitere Informationen zu erhalten. (rudimentär)
	 */
	public TouristAgency() {
		super("Wander-Reisebüro");

		// Fesntereigenschaften
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		JPanel mainpanel = new JPanel();
		setContentPane(mainpanel);
		setLayout(new GridBagLayout());

		// GUI-Elemente initialisieren
		highSeasonSelection = new JRadioButton("Hauptsaison");
		lowSeasonSelection = new JRadioButton("Nebensaison");
		seasonSelection = new ButtonGroup();
		seasonSelection.add(highSeasonSelection);
		seasonSelection.add(lowSeasonSelection);
		highSeasonSelection.setSelected(true);

		bookCabin = new JCheckBox("Hütte");
		bookCar = new JCheckBox("Gondel");
		bookParaglider = new JCheckBox("Paraglider");

		choices = new DefaultListModel<Combination>();
		bookedComponents = new JList<Combination>(choices);
		scrollPane = new JScrollPane(bookedComponents);

		// GUI-Elemente auf dem Layout platzieren
		GridBagConstraints cons = new GridBagConstraints();

		cons.gridx = 0;
		cons.gridy = 0;
		add(highSeasonSelection, cons);

		cons.gridx = 1;
		add(lowSeasonSelection, cons);

		cons.gridy = 1;
		cons.gridx = 0;
		add(bookCabin, cons);

		cons.gridx = 1;
		add(bookCar, cons);

		cons.gridx = 2;
		add(bookParaglider, cons);

		cons.gridy = 2;
		cons.gridx = 0;
		cons.gridwidth = 3;
		add(scrollPane, cons);

		setVisible(true);
		pack();

		/**
		 *  Anlegen der angebotenen Komponenten und hinzufügen zu Listen,<br>
		 *  um alle möglichen Kombinationen zu berechnen
		 */
		standardCabin = new Cabin();
		fourBedsBalcony = new Cabin(4, true);
		cabins = new Cabin[] { standardCabin, fourBedsBalcony };

		standardCar = new Car();
		standardGlassFloorCar = new Car(true);
		cars = new Car[] { standardCar, standardGlassFloorCar };

		standardSolo = new Paraglider();
		motorizedTandem = new Paraglider(true, true);
		paras = new Paraglider[] { standardSolo, motorizedTandem };

		/**
		 *  Actionlistener, der die Preise aller Kombinationen der ausgewählten
		 *  Komponenten berechnen lässt, und sie preislich absteigend dem
		 *  Scrollpane hinzufügt
		 */	
		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Erstellt bei jeder betätigung eine neue Liste von
				// Kombinationen
				List<Combination> list = new ArrayList<Combination>();

				// Leer das Scrollpane
				choices.clear();
				
				// Speichern der CheckBox-Auswahlen
				boolean cabin = bookCabin.isSelected();
				boolean car = bookCar.isSelected();
				boolean paraglider = bookParaglider.isSelected();

				// Legt den Visitor für die Saisonart fest
				if (highSeasonSelection.isSelected()) {
					season = new HighSeasonVisitor();
				} else {
					season = new LowSeasonVisitor();
				}

				/**
				 *  Erstellt alle möglichen Kombinationen je nach ausgewählter
				 *  Komponenten
				 */
				// Auswahl: Hütte und Gondel
				if (cabin && car && !paraglider) {
					for (Cabin cab : cabins) {
						for (Car ca : cars) {
							
							// Preise mittels accept berechnen
							price = cab.accept(season) + ca.accept(season);

							// Beschreibung für die GUI aus den
							//Einzelbeschreibungen generieren
							combinationDescription = "<html>"
									+ cab.getDescription() + "<br>"
									+ ca.getDescription();
							
							// Aus dem Hütten/Gondel Paar eine Combination
							// erstellen, die comparable ist
							combination = new Combination(price,
									combinationDescription);
							
							// Fügt der Liste die neue Kombination hinzu
							list.add(combination);
						}
					}
				// Auswahl: Hütte und Gleitschirm
				} else if (cabin && !car && paraglider) {
					for (Cabin cab : cabins) {
						for (Paraglider para : paras) {

							price = cab.accept(season) + para.accept(season);

							combinationDescription = "<html>"
									+ cab.getDescription() + "<br>"
									+ para.getDescription();

							combination = new Combination(price,
									combinationDescription);

							list.add(combination);
						}
					}
				// Auswahl: Gondel und Gleitschirm
				} else if (!cabin && car && paraglider) {
					for (Car ca : cars) {
						for (Paraglider para : paras) {

							price = ca.accept(season) + para.accept(season);

							combinationDescription = "<html>"
									+ ca.getDescription() + "<br>"
									+ para.getDescription();

							combination = new Combination(price,
									combinationDescription);

							list.add(combination);
						}
					}
				// Hütte, Gondel und Gleitschirm
				} else if (cabin && car && paraglider) {
					for (Cabin cab : cabins) {
						for (Car ca : cars) {
							for (Paraglider para : paras) {

								price = cab.accept(season) + ca.accept(season)
										+ para.accept(season);

								combinationDescription = "<html>"
										+ cab.getDescription() + "<br>"
										+ ca.getDescription() + "<br>"
										+ para.getDescription();

								combination = new Combination(price,
										combinationDescription);

								list.add(combination);
							}
						}
					}
				}

				// Sortiert die Liste
				// (möglich, da Combination comparable implementiert)
				Collections.sort(list);
				for (Combination c : list) {
					choices.addElement(c);
				}
			}
		};

		// Fügt jedem Auswahl-Element der GUI den ActionListener hinzu
		highSeasonSelection.addActionListener(actionListener);
		lowSeasonSelection.addActionListener(actionListener);
		bookCabin.addActionListener(actionListener);
		bookCar.addActionListener(actionListener);
		bookParaglider.addActionListener(actionListener);

		// ActionListener für die Listenelemente des ScrollPane
		bookedComponents.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				// Abfrage, ob es der Auswahlindex richtig ist
				if (bookedComponents.getSelectedIndex() >= 0) {

					// Öffnet einen Dialog, der die Beschreibung anzeigt
					JOptionPane.showMessageDialog(null,
							choices.getElementAt(
									bookedComponents.getSelectedIndex())
									.getDesc(),
							"Details", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}

	/**
	 * Main-Methode<br>
	 * erstellt ein neues TouristAgency Objekt
	 * @param args
	 */
	public static void main(String[] args) {
		new TouristAgency();
	}
}
