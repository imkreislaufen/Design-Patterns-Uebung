import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
/**
 * Diese Klasse stellt die GUI bereit.
 * @author rschikor, jniedbal
 *
 */
public class Bundesliga extends JFrame {

	// Java-verlangte Variable
	private static final long serialVersionUID = 1L;

	// private Klassenattribute
	private JRadioButton gesamtTabelle, heimTabelle, auswaertsTabelle;
	private JSpinner spielTag;
	private SpinnerNumberModel spmod;
	private JTable tabelle;
	private Tabelle inhalt;

	private Spiel[] spiele;

	private ButtonGroup tabellenArt;

	/**
	 * Constructor
	 */
	public Bundesliga() {
		
		// legt Fenstereigenschaften fest
		super("1. Bundesliga - Tabelle");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		// Hauptpanel und Layout definieren
		JPanel mainPanel = new JPanel();
		setContentPane(mainPanel);
		setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();

		// Radiobuttons zur Tabellenauswahl
		gesamtTabelle = new JRadioButton("Gesamttabelle");
		heimTabelle = new JRadioButton("Heimtabelle");
		auswaertsTabelle = new JRadioButton("Auswährtstabelle");

		// Buttongroup mit den Tabellenbuttons
		tabellenArt = new ButtonGroup();
		tabellenArt.add(gesamtTabelle);
		tabellenArt.add(heimTabelle);
		tabellenArt.add(auswaertsTabelle);

		// Spinner zur Auswahl des Spieltages (Wert zwischen 1 und 34)
		spmod = new SpinnerNumberModel(1, 1, 34, 1);
		spielTag = new JSpinner(spmod);
		spielTag.setToolTipText("Spieltag wählen");

		// scrollbare Tabell mit Reitern für z.B. den Mannschaftsnamen 
		tabelle = new JTable(new DefaultTableModel(new Object[][] {},
				new Object[] { "Position", "Verein", "Spiele", "Punkte", 
						"Torverhältnis" }));
		JScrollPane scroll = new JScrollPane(tabelle);
		scroll.setMinimumSize(new Dimension(400, 400));
		tabelle.setFillsViewportHeight(true);

		// GUI-Elemente platzieren
		cons.gridx = 0;
		cons.gridy = 0;
		add(gesamtTabelle, cons);

		cons.gridx = 1;
		add(heimTabelle);

		cons.gridx = 2;
		add(auswaertsTabelle);

		cons.gridx = 3;
		add(spielTag, cons);

		cons.gridx = 0;
		cons.gridy = 1;
		cons.gridwidth = 4;
		add(scroll, cons);

		// Einlesen der .csv-Datei
		spiele = tabelleEinlesen();

		// reagiert auf eine Änderung des Spinners (Spieltages) 
		spielTag.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				inhalt.tabellenRezept(spmod.getNumber().intValue());
			}
		});

		// erstellt die Gesamttabelle für den ausgewählten Spieltag
		gesamtTabelle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inhalt = new GesamtTabelle(spiele, tabelle);
				inhalt.tabellenRezept(spmod.getNumber().intValue());
			}
		});

		// erstellt die Heimspieltabelle für den ausgewählten Spieltag
		heimTabelle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inhalt = new HeimTabelle(spiele, tabelle);
				inhalt.tabellenRezept(spmod.getNumber().intValue());
			}
		});

		// erstellt die Auswärtsspieltabelle für den ausgewählten Spieltag
		auswaertsTabelle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inhalt = new AuswaertsTabelle(spiele, tabelle);
				inhalt.tabellenRezept(spmod.getNumber().intValue());
			}
		});

		// Direkt beim Programmstart wird die Gesamttabelle ausgewählt
		gesamtTabelle.doClick();
		
		// Anpassen der Größe an den Inhalt und Sichtbarkeit
		pack();
		setVisible(true);
	}

	/**
	 * Liest die Tabellendaten aus der gegebenen .csv-Datei
	 * @return Spiel[] - Array vom Typ Spiel mit Daten der gespielten Partien
	 */
	public Spiel[] tabelleEinlesen() {
		final String SEPERATOR = ";";
		List<Spiel> liste = new LinkedList<Spiel>();
		String zeile[];
		String tmp;
		int spielTag, toreHeim, toreGast;
		String heim, gast;

		// FileChooser, um eine .csv-Datei auszuwählen, falls keine im 
		// aktuellen Verzeichnis gefunden werden konnte
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = 
				new FileNameExtensionFilter("CSV Dateien", "csv");
		fileChooser.setFileFilter(filter);
		fileChooser.setDialogTitle("Datei wählen");
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")
				+ System.getProperty("file.separator")+ "Desktop"));

		// Erstellen einer neuen Datei im aktuellen/Arbeitsverzeichnis
		File file = new File("Bundesliga.csv");
		
		// Falls im aktuellen Verzeichnis keine derartige Datei enthalten ist, 
		// wird der FileChooser angezeigt, welcher nach erfolgloser Auswahl
		// das komplette Programm beendet.
		if(!file.exists()) {
			if (fileChooser.showDialog(this, "Ok") 
					!= JFileChooser.APPROVE_OPTION) {
				System.exit(0);
			}
				
			file = fileChooser.getSelectedFile();
		}
		// zeilenweises Einlesen der ausgewählten Datei mit einem BufferedReader
		try (BufferedReader br = new BufferedReader(
				new FileReader(file))) {
			br.readLine();
			while ((tmp = br.readLine()) != null) {
				zeile = tmp.split(SEPERATOR);
				spielTag = Integer.parseInt(zeile[0]);
				heim = zeile[1];
				gast = zeile[2];
				toreHeim = Integer.parseInt(zeile[3]);
				toreGast = Integer.parseInt(zeile[4]);
				liste.add(new Spiel(spielTag, heim, gast, toreHeim, toreGast));
			}
		// Fehlerwurf bei Problemen mit dem BufferedReader oder einem falschen
		// Pfad (eigentlich abgefangen vom FileChooser)
		} catch (FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage() + "Falscher Pfad");
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
		// wandelt die LinkedList in ein Array um
		return liste.toArray(new Spiel[0]);
	}

	/**
	 * Hauptmethode zum Erstellen einer neuen Bundesliga-Tabelle
	 * @param args - Argumente
	 */
	public static void main(String[] args) {
		new Bundesliga();
	}
}
