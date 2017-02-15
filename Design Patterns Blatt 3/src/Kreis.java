import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author rschikor, jniedbal
 *
 */
public class Kreis extends Figur {
	public Kreis(Color color) {
		super(color);
	}

	// Zeichnet einen Kreis mit Durchmesser 60 an Punkt (30,30)
	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(color);
		graphics.drawOval(30, 30, 60, 60);
	}
}