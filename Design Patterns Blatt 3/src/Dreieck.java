import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author rschikor, jniedbal
 *
 */
public class Dreieck extends Figur {
	public Dreieck(Color color) {
		super(color);
	}

	// Zeichnet ein Dreieck mit Eckpunkt-Koordinaten (30,90), (60,30), (90,90)
	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(color);
		graphics.drawPolygon(new int[] {30, 60, 90}, new int[] {90, 30, 90}, 3);
	}
}