package components;

import blatt9.Visitor;

/**
 * Diese Klasse beschreibt eine Hütte als Buchungsoption
 * @author rschikor, jniedbal
 *
 */
public class Cabin {

	// Werte für eine Standard-Hütte
	private static final int standardBeds = 2;
	private static final boolean standardBalcony = false;

	// Hütteneigenschaften
	private final float basicPrize = 70;
	private final int numberBeds;
	private final boolean hasBalcony;

	/**
	 * Default-Constructor<br>
	 * Erstellt eine Hütte mit <b>zwei</b> Betten, <b>ohne</b> Balkon
	 */
	public Cabin() {
		this(standardBeds, standardBalcony);
	}

	/**
	 * Constructor<br>
	 * Erstellt eine Hütte mit der angegebenen Anzahl Betten und je nach Angabe
	 * mit oder ohne Balkon
	 * @param beds - Anzahl der Betten
	 * @param balcony - Bei <b>true</b> mit Balkon, bei <b>false</b> ohne
	 */
	public Cabin(int beds, boolean hasBalcony) {
		this.numberBeds = beds;
		this.hasBalcony = hasBalcony;
	}

	/**
	 * Gibt den Basispreis der Hütte zurück
	 * @return - int: basicPrice
	 */
	public float getBasicPrize() {
		return basicPrize;
	}

	/**
	 * Gibt die Anzahl an Betten zurück
	 * @return - int: numberBeds
	 */
	public int getNumberBeds() {
		return numberBeds;
	}

	/**
	 * Gibt zurück ob die Hütte einen Balkon hat
	 * @return - boolean: <b>true</b> mit Balkon, <b>false</b> ohne Balkon
	 */
	public boolean isBalcony() {
		return hasBalcony;
	}

	/**
	 * Erstellt einen String mit einer passenden Beschrebung für eine Hütte,<br>
	 * die <b>Anzahl</b> der Betten und <b>Vorhandensein eines Balkons</b>
	 * umfasst
	 * @return - String: Beschreibung des Hüttenobjekts
	 */
	public String getDescription() {
		String desc = "Hütte mit " + numberBeds + " Betten";
		if (hasBalcony) {
			desc += " und Balkon";
		}
		return desc;
	}

	/**
	 * Accept-Methode des Visitor Patterns die den Preis der Hütte vom
	 * übergebenen Visitor berechnen lässt
	 * @param v - Visitor
	 * @return - int: Preis der Hütte
	 */
	public float accept(Visitor v) {
		return v.calculateCabinPrize(this);
	}
}
