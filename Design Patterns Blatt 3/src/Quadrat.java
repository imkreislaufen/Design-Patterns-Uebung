import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author rschikor, jniedbal
 *
 */
public class Quadrat extends Figur {
	public Quadrat(Color color) {
		super(color);
	}

	// Zeichnet ein Quadrat mit Seitenlänge 60 beginnend ab Punkt (30,30).
	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(color);
		graphics.drawRect(30, 30, 60, 60);
	}
}
