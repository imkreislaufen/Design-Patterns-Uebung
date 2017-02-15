package array;

import java.awt.Point;
import java.util.Iterator;

/**
 * Implementiert einen erweiterten Iterator über ein Point Array, da next() 50
 * Elemente nach vorne geht
 * 
 * @author rschikor, jniedbal
 *
 */
public class ArrayIterator50 implements Iterator<Point> {

	private Point[] polygon;
	private int position;

	public ArrayIterator50(Point[] p) {
		polygon = p;
		position = 0;
	}

	@Override
	public boolean hasNext() {
		if (position >= polygon.length || polygon[position] == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Point next() {
		Point next = polygon[position];
		position += 50;
		return next;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
