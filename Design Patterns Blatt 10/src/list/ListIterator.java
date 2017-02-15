package list;

import java.awt.Point;
import java.util.Iterator;
import java.util.List;

/**
 * Implementiert einen einfachen Iterator über eine Point Liste
 * 
 * @author rschikor, jniedbal
 *
 */
public class ListIterator implements Iterator<Point> {

	private List<Point> polygon;
	private int position;

	public ListIterator(List<Point> p) {
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
		position++;
		return next;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();

	}

}
