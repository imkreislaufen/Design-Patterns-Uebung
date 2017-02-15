package list;

import java.awt.Point;
import java.util.Iterator;
import java.util.List;

/**
 * Implementiert einen erweiterten Iterator über eine Point Liste, da next() 50
 * Elemente nach vorne geht
 * 
 * @author rschikor, jniedbal
 *
 */
public class ListIterator50 implements Iterator<Point> {

	private List<Point> polygon;
	private int position;

	public ListIterator50(List<Point> p) {
		polygon = p;
		position = 0;
	}

	@Override
	public boolean hasNext() {
		if (position >= polygon.size() || polygon.get(position) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Point next() {
		Point next = polygon.get(position);
		position += 50;
		return next;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();

	}

}