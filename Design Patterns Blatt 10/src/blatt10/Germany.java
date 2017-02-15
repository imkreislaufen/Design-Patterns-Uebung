package blatt10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import util.MapPanel;

/**
 * Diese Klasse ermöglicht es die gesamte Funktionalität mittels grafischer
 * Benutzeroberfläche zu testen
 * 
 * @author rschikor, jniedbal
 *
 */
public class Germany extends JFrame {

	private static final long serialVersionUID = 1L;

	// GUI-Elemente deklarieren
	private JRadioButton listMode, arrayMode, accurate, inaccurate;
	private ButtonGroup datastructure, resolution;
	private JCheckBox colored;

	// MapPanel für die eigentliche Karte
	private MapPanel map;

	/**
	 * Constructor<br>
	 * Erstellt die GUI und fügt den RadioButtons ihre FUnktionalität hinzu
	 */
	public Germany() {

		// Fenstereigenschaften festlegen
		super("Deutschlandkarte");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		// Hauptpanel und Layout festlegen
		JPanel mainPanel = new JPanel();
		setContentPane(mainPanel);
		setLayout(new GridBagLayout());

		// Karte initialisieren und Eigenschaften festlegen
		map = new MapPanel();
		map.setBackground(Color.white);
		map.setPreferredSize(new Dimension(690, 930));

		// GUI-Elemente initialisieren
		listMode = new JRadioButton("List-Iterator");
		arrayMode = new JRadioButton("Array-Iterator");
		accurate = new JRadioButton("Hohe Genauigkeit");
		inaccurate = new JRadioButton("Niedrige Genauigkeit");
		colored = new JCheckBox("SCHLAND !!");

		datastructure = new ButtonGroup();
		resolution = new ButtonGroup();

		datastructure.add(listMode);
		datastructure.add(arrayMode);
		resolution.add(accurate);
		resolution.add(inaccurate);

		// GUI-Elemente platzieren
		GridBagConstraints cons = new GridBagConstraints();

		cons.gridx = 0;
		cons.gridy = 0;
		cons.weightx = 1;
		cons.weighty = 0;
		add(listMode, cons);
		cons.gridx = 1;
		add(arrayMode, cons);
		cons.gridx = 2;
		add(accurate, cons);
		cons.gridx = 3;
		add(inaccurate, cons);
		cons.gridx = 0;
		cons.gridy = 1;
		cons.gridwidth = 4;
		add(colored, cons);
		cons.gridy = 2;
		cons.weighty = 1;
		add(map, cons);

		pack();
		setVisible(true);

		/**
		 * 
		 * ActionListener für die GUI-Elemente
		 * 
		 */
		accurate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				map.setAccurate(true);
				map.repaint();

			}
		});

		inaccurate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				map.setAccurate(false);
				map.repaint();

			}
		});

		listMode.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				map.setList(true);
				map.repaint();

			}
		});

		arrayMode.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				map.setList(false);
				map.repaint();

			}
		});

		colored.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				map.setColored(colored.isSelected());
				map.repaint();

			}
		});

		listMode.doClick();
		accurate.doClick();
	}

	/**
	 * Main-Methode, welche ein Germany-Objekt erstellt
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Germany();
	}
}
