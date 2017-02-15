import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author rschikor, jniedbal
 *
 */
public abstract class Figur {
	
	protected final Color color;

	/**
	 * Dieser Konstruktor setzt die Farbe für die Figur.
	 * 
	 * @param color Farbe der geometrischen Figur
	 */
	public Figur(Color color) {
		this.color = color;
	}
	
	/**
	 * Zeichnet die Figur
	 * 
	 * @param graphics Graphics.
	 */
	public abstract void draw(Graphics graphics);
}