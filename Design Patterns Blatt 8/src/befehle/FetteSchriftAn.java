package befehle;

import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 * Dieser Befehl fügt der Formatierung eines ausgewählten Textes das Attribut
 * fett hinzu
 * @author rschikor, jniedbal
 *
 */
public class FetteSchriftAn implements Befehl {

	private static final long serialVersionUID = 4124335712598796641L;
	private int start, end;
	private JTextPane schreiben = new JTextPane();

	// Constructor
	public FetteSchriftAn(JTextPane jtp) {
		schreiben = jtp;	
	}

	@Override
	public void ausfuehren() {
		// Marker für die Textauswahl
		start = schreiben.getSelectionStart();
		end = schreiben.getSelectionEnd();

		// Setzt das Attribut fett auf true
		SimpleAttributeSet sas = new SimpleAttributeSet();
		StyleConstants.setBold(sas, true);
		
		// Setzt die Formatierung innerhalb des Textfeldes für die Auswahl um
		schreiben.getStyledDocument()
			.setCharacterAttributes(start, end - start, sas, false);
	}

	@Override
	public void rueckgaengig() {
		// Macht das genaue Gegenteil von ausführen
		SimpleAttributeSet sas = new SimpleAttributeSet();
		StyleConstants.setBold(sas, false);
		
		schreiben.getStyledDocument()
			.setCharacterAttributes(start, end - start, sas, false);
	}
}
