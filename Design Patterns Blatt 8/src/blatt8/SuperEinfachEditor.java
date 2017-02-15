package blatt8;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import befehle.Befehl;
import befehle.FetteSchriftAn;
import befehle.FetteSchriftAus;
import befehle.SchriftGroesseAendern;
import befehle.UnterstreichenAn;
import befehle.UnterstreichenAus;

/**
 * Benutzeroberfläche für den Super Einfach Editor
 * 
 * @author rschikor, jniedbal
 *
 */
public class SuperEinfachEditor extends JFrame {
	private static final long serialVersionUID = 1L;

	// GUI-Elemente definieren
	private JButton bold, underlined, undo;
	private JTextPane schreiben;
	private JComboBox<Integer> size;

	// Befehle für die Funktionalität definieren
	private Befehl fetteSchriftAn, fetteSchriftAus, unterstreichenAn, unterstreichenAus;
	private SchriftGroesseAendern schriftGroesseAendern;

	// Marker für die Textauswahl
	private int start, end;

	// Benötigt um die Formatierung des Textfeldes zu ändern
	private SimpleAttributeSet sas;

	// Stack von Befehlen für den Rückgängig-Button
	public Stack<Befehl> befehlsStack;

	// Constructor
	@SuppressWarnings("unchecked")
	public SuperEinfachEditor() {
		// Legt Fenstereigenschaften fest
		super("Super Einfach Editor");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		// Hauptpanel, Buttonpanel und Layout definieren
		JPanel mainpanel = new JPanel();
		JPanel buttons = new JPanel();
		setContentPane(mainpanel);
		setLayout(new GridLayout(0, 1));

		// Haupt- und Button Panelgröße festlegen
		buttons.setSize(100, 50);
		setSize(400, 300);

		// GUI-Elemente initailisieren
		bold = new JButton("Fett");
		underlined = new JButton("Unterstreichen");
		undo = new JButton("Rückgängig");
		Integer[] fontSize = { 8, 10, 12, 14, 16, 18 };
		size = new JComboBox<Integer>(fontSize);
		size.setSelectedIndex(2);
		schreiben = new JTextPane();
		schreiben.setSize(10, 10);
		sas = new SimpleAttributeSet();
		StyleConstants.setFontSize(sas, (int) size.getSelectedItem());

		// Befehle
		fetteSchriftAn = new FetteSchriftAn(schreiben);
		fetteSchriftAus = new FetteSchriftAus(schreiben);
		unterstreichenAn = new UnterstreichenAn(schreiben);
		unterstreichenAus = new UnterstreichenAus(schreiben);
		schriftGroesseAendern = new SchriftGroesseAendern(schreiben);

		// GUI-Elemente hinzufügen
		buttons.add(bold);
		buttons.add(underlined);
		buttons.add(undo);
		buttons.add(size);
		add(buttons);
		add(schreiben);

		setVisible(true);

		// Implementierung der Serialiserung
		File save = new File("output.ser");
		// Überprüft ob ein gespeichertes Object existiert..
		if (save.exists()) {
			try {
				FileInputStream fileOut = new FileInputStream("output.ser");
				ObjectInputStream in = new ObjectInputStream(fileOut);
				// Falls ja, versuchen den Stack und das Dokument zu laden
				try {
					befehlsStack = (Stack<Befehl>) in.readObject();
					schreiben.
						setStyledDocument((StyledDocument) in.readObject());
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				in.close();
				fileOut.close();
			} catch (IOException i) {
				i.printStackTrace();
			}
		// Ansonsten erstelle neuen Stack
		} else {
			befehlsStack = new Stack<Befehl>();
		}
		
		// Aktiviert den Rückgängig Button nur, wenn Befehlsstack nicht leer
		undo.setEnabled(!befehlsStack.isEmpty());
		
		// Actionlistener für den Fett Button
		bold.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Marker für die Textauswahl
				start = schreiben.getSelectionStart();
				end = schreiben.getSelectionEnd();
				
				// Speichert, ob der Text fett gemacht werden muss
				boolean makeBold = false;
				StyledDocument sd = schreiben.getStyledDocument();

				// Überprüft, ob der markierte Text bereits fett ist oder nicht
				for (int i = start; !makeBold && i < end; i++) {
					AttributeSet as = sd.getCharacterElement(i).getAttributes();
					makeBold = !StyleConstants.isBold(as);
				}

				// Führt je nach Eigenschaft der Auswahl den richtigen Befehl
				// aus und fügt ihn dem Stack hinzu
				if (makeBold) {
					fetteSchriftAn.ausfuehren();
					befehlsStack.push(fetteSchriftAn);
				} else {
					fetteSchriftAus.ausfuehren();
					befehlsStack.push(fetteSchriftAus);
				}
				// Aktiviert den Rückgängig Button
				undo.setEnabled(true);
			}
		});

		// Actionlistener für den Unterstrichen Button
		underlined.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Marker für die Textauswahl
				start = schreiben.getSelectionStart();
				end = schreiben.getSelectionEnd();
				
				// Speichert ob der Text unterstrichen werden muss
				boolean makeUnderlined = false;
				StyledDocument sd = schreiben.getStyledDocument();

				// Überprüft, ob der markierte Text bereits unterstrichen ist
				// oder nicht
				for (int i = start; !makeUnderlined && i < end; i++) {
					AttributeSet as = sd.getCharacterElement(i).getAttributes();
					makeUnderlined = !StyleConstants.isUnderline(as);
				}

				// Führt je nach Eigenschaft der Auswahl den richtigen Befehl
				// aus und fügt ihn dem Stack hinzu
				if (makeUnderlined) {
					unterstreichenAn.ausfuehren();
					befehlsStack.push(unterstreichenAn);
				} else {
					unterstreichenAus.ausfuehren();
					befehlsStack.push(unterstreichenAus);
				}
				// Aktiviert den Rückgängig Button
				undo.setEnabled(true);
			}
		});

		// Actionlistener für die Schriftgröße
		size.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Holt die gewählte Größe aus der ComboBox
				schriftGroesseAendern.ausfuehren((int) size.getSelectedItem());

				// Führt den Befehl aus und fügt ihn dem Stack hinzu
				befehlsStack.push(schriftGroesseAendern);

				// Aktiviert den Rückgängig Button
				undo.setEnabled(true);
			}
		});

		// Actionlistener für den Rückgängig Button
		undo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Holt sich den zuletzt ausgeführten Befehl vom Stack und
				// führt dessen Rückgängig Methode aus
				befehlsStack.pop().rueckgaengig();

				// Falls der Stack danach leer ist, deaktiviere den Rükgängig
				// Button
				if (befehlsStack.isEmpty()) {
					undo.setEnabled(false);
				} else {
					undo.setEnabled(true);
				}

			}
		});

		// WindowListener, der beim Beenden des Programs den Stack als
		// serialisiertes Objekt abspeichert
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				try {
					// Legt den Dateinamen fest
					FileOutputStream fileOut =
								new FileOutputStream("output.ser");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					
					// Speichert den Stack sowie das Dokument im Textfeld
					out.writeObject(befehlsStack);
					out.writeObject(schreiben.getStyledDocument());
					out.close();
					fileOut.close();
				} catch (IOException i) {
					i.printStackTrace();
				}
				System.exit(0);
			}
		});

	}

	/**
	 * Main Methode, die einen Super Einfach Editor erstellt
	 * @param args - String[]
	 */
	public static void main(String[] args) {
		new SuperEinfachEditor();
	}
}
