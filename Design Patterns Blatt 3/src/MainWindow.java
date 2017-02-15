import java.awt.Color;
import javax.swing.JFrame;

/**
 * 
 * @author rschikor, jniedbal
 *
 */
public abstract class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Stellt die abstrakte Factory-Methode bereit.
	 * 
	 * @param form String mit "Wert" Kreis, Dreieck, Quadrat
	 * @param color ausgewählte Farbe der zu zeichnenden Figur
	 * @return Figur in der gewünschten Farbe
	 */
	protected abstract Figur doMakeFigur(String form, Color color);
	
	/**
	 * Konstruktor, der dem Konstruktor des JFrames den Fenstertitel übergibt
	 * 
	 * @param name String mit Titel des Fensters
	 */
	public MainWindow(String name) {
		super(name);
	}
}
