import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author rschikor, jniedball
 *
 */
public class MyCanvas extends Canvas {
	private static final long serialVersionUID = 1L;
	
	// Liste, die speichert, welche Figuren gezeichnet werden sollen
	private List<Figur> zuZeichnendeFiguren;
	
	// Konstruktor
	public MyCanvas() {
		zuZeichnendeFiguren = new ArrayList<Figur>();
	}
	 
	/**
	 * Methode, welche automatisch aufgerufen wird und die Formen durch ihre
	 * eigenen zeichnen lässt
	 */
	public void paint(Graphics graphics) {
		for (Figur i : zuZeichnendeFiguren) {
			i.draw(graphics);
		}
	}
	
	/**
	 * Fügt eine Figur z.B. nach einer Buttonbetätigung der Liste hinzu und
	 * veranlasst erneutes Zeichnen des Canvas
	 * 
	 * @param figur Figur die zur ArrayList hinzugefügt wird
	 */
	public void add(Figur figur) {
		zuZeichnendeFiguren.add(figur);
		repaint();
	}
	
	/**
	 * Leert die Liste der Figuren z.B. nach einer Buttonbetätigung und
	 * veranlasst ein erneutes Zeichnen des Canvas
	 */
	public void clear() {
		zuZeichnendeFiguren.clear();
		repaint();
	}
}
