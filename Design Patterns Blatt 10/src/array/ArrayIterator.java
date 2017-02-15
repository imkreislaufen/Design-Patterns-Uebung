package array;

import java.awt.Point;
import java.util.Iterator;

/**
 * Implementiert einen einfachen Iterator über ein Point Array
 * 
 * @author rschikor, jniedbal
 *
 */
public class ArrayIterator implements Iterator<Point> {

	private Point[] polygon;
	private int position;

	public ArrayIterator(Point[] p) {
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
		position++;
		return next;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
