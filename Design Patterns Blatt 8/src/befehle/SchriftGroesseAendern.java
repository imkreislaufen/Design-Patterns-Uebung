package befehle;

import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 * Dieser Befehl ändert die Schriftgröße eines ausgeählten Textes
 * 
 * @author rschikor, jniedbal
 *
 */
public class SchriftGroesseAendern implements Befehl {

	private static final long serialVersionUID = 8152279178033217497L;
	private int start, end;
	private int letzteGroesse;
	private JTextPane schreiben = new JTextPane();

	// Constructor
	public SchriftGroesseAendern(JTextPane jtp) {
		schreiben = jtp;
	}

	/**
	 * Setzt eine vom Interface abweichende ausfuehren Methode um,
	 * da dieser Befehl eine Schriftgröße als Parameter benötigt
	 * 
	 * @param size
	 *            - int
	 */
	public void ausfuehren(int size) {
		// // Marker für die Textauswahl
		start = schreiben.getSelectionStart();
		end = schreiben.getSelectionEnd();

		// Speichert aktuelle Schriftgröße um Änderungen rückgängig zu machen
		SimpleAttributeSet sas = new SimpleAttributeSet();
		letzteGroesse = StyleConstants.getFontSize(sas);

		// Setzt die neue Schriftgröße als Attribut
		StyleConstants.setFontSize(sas, size);

		// Setzt die Formatierung innerhalb des Textfeldes für die Auswahl um
		schreiben.getStyledDocument()
			.setCharacterAttributes(start, end - start, sas, false);
	}

	@Override
	public void rueckgaengig() {
		SimpleAttributeSet sas = new SimpleAttributeSet();
		letzteGroesse = StyleConstants.getFontSize(sas);

		// Setzt die Schriftgröße auf den letzten Wert zurück
		StyleConstants.setFontSize(sas, letzteGroesse);
		schreiben.getStyledDocument()
			.setCharacterAttributes(start, end - start, sas, false);
	}

	@Override
	public void ausfuehren() {
	}

}
