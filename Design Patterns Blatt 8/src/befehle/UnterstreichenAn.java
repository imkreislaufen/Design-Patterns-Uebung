package befehle;

import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class UnterstreichenAn implements Befehl {

	private static final long serialVersionUID = -5303894178109976693L;
	private int start, end;
	private JTextPane schreiben = new JTextPane();

	// Constructor
	public UnterstreichenAn(JTextPane jtp) {
		schreiben = jtp;
	}

	@Override
	public void ausfuehren() {
		// Marker für die Textauswahl
		start = schreiben.getSelectionStart();
		end = schreiben.getSelectionEnd();

		// Setzt das Attribut unterstrichen auf true
		SimpleAttributeSet sas = new SimpleAttributeSet();
		StyleConstants.setUnderline(sas, true);

		// Setzt die Formatierung innerhalb des Textfeldes für die Auswahl um
		schreiben.getStyledDocument()
			.setCharacterAttributes(start, end - start, sas, false);
	}

	@Override
	public void rueckgaengig() {
		// Macht das genaue Gegenteil von ausführen
		SimpleAttributeSet sas = new SimpleAttributeSet();
		StyleConstants.setUnderline(sas, false);
		schreiben.getStyledDocument()
			.setCharacterAttributes(start, end - start, sas, false);
	}
}
