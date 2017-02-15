package befehle;

import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class UnterstreichenAus implements Befehl {

	private static final long serialVersionUID = 5937766167139104320L;
	private int start, end;
	private JTextPane schreiben = new JTextPane();

	// Constructor
	public UnterstreichenAus(JTextPane jtp) {
		schreiben = jtp;
	}

	@Override
	public void ausfuehren() {
		// Marker für die Textauswahl
		start = schreiben.getSelectionStart();
		end = schreiben.getSelectionEnd();

		// Setzt das Attribut unterstrichen auf false
		SimpleAttributeSet sas = new SimpleAttributeSet();
		StyleConstants.setUnderline(sas, false);

		// Setzt die Formatierung innerhalb des Textfeldes für die Auswahl um
		schreiben.getStyledDocument()
			.setCharacterAttributes(start, end - start, sas, false);
	}

	@Override
	public void rueckgaengig() {
		// Macht das genaue Gegenteil von ausführen
		SimpleAttributeSet sas = new SimpleAttributeSet();
		StyleConstants.setUnderline(sas, true);
		schreiben.getStyledDocument()
			.setCharacterAttributes(start, end - start, sas, false);
	}
}
