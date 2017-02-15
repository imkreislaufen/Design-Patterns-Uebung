package components;

/**
 * Hilfsklasse, die eine Kombination aus Preis und Beschreibung einer
 * Buchungsoptionen speichert und es ermöglicht zwei Kombinationen Anhand ihres
 * Preises zu vergleichen
 * @author rschikor, jniedbal
 *
 */
public class Combination implements Comparable<Combination> {
	private String desc;
	private float price;

	/**
	 * Constructor<br>
	 * Erstellt eine Kombination
	 * @param price - Preis einer Buchungsoption
	 * @param desc - Beschreibung einer Buchungsoption
	 */
	public Combination(float price, String desc) {
		this.price = price;
		this.desc = desc;
	}

	/**
	 * Gibt die Beschreibung einer Buchungsoption zurück
	 * @return - String: Beschreibung der Buchungsoption
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Gibt den Preis einer uchungsoption zurück
	 * @return - float: Preis einer Buchungsoption
	 */
	public float getPrice() {
		return price;
	}

	@Override
	public int compareTo(Combination o) {
		return (int) (o.getPrice() - this.getPrice());
	}

	@Override
	public String toString() {
		return desc + "<br>" + String.valueOf(price).split("\\.0")[0] + " €";
	}
}
