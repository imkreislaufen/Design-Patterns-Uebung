package befehle;

import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 * Dieser Befehl entfernt der Formatierung eines ausgewählten Textes das
 * Attribut fett
 * @author rschikor, jniedbal
 *
 */
public class FetteSchriftAus implements Befehl {

	private static final long serialVersionUID = -6053128024542608995L;
	private int start, end;
	private JTextPane schreiben = new JTextPane();

	// Constuctor
	public FetteSchriftAus(JTextPane jtp) {
		schreiben = jtp;
	}

	@Override
	public void ausfuehren() {
		// Marker für die Textauswahl
		start = schreiben.getSelectionStart();
		end = schreiben.getSelectionEnd();

		// Setzt das Attribut fett auf false
		SimpleAttributeSet sas = new SimpleAttributeSet();
		StyleConstants.setBold(sas, false);

		// Setzt die Formatierung innerhalb des Textfeldes für die Auswahl um
		schreiben.getStyledDocument()
			.setCharacterAttributes(start, end - start, sas, false);
	}

	@Override
	public void rueckgaengig() {
		// Macht das genaue Gegenteil von ausführen
		SimpleAttributeSet sas = new SimpleAttributeSet();
		StyleConstants.setBold(sas, true);
		schreiben.getStyledDocument()
			.setCharacterAttributes(start, end - start, sas, false);
	}
}
