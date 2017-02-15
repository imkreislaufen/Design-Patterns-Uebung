package components;

import blatt9.Visitor;

/**
 * Diese Klasse beschreibt eine Gondel als Buchungsoption
 * @author rschikor, jniedbal
 *
 */
public class Car {
	
	// Werte für eine Standard-Gondel
	private static final int standardSeats = 4;
	private static final boolean standardFloor = false;
	
	// Gondeleigenschaften
	private final float basicPrize = 20;
	private final int numberSeats;
	private final boolean glassFloor;

	/**
	 * Default-Constructor<br>
	 * Erstellt eine Hütte mit <b>vier</b> Sitzplätzen, <b>ohne</b> Glassboden
	 */
	public Car() {
		this(standardSeats, standardFloor);
	}

	/**
	 * Constructor<br>
	 * Erstellt eine Gondel mit <b>vier</b> Sitzplätzen und je nach Angabe
	 * mit oder ohne Balkon
	 * @param floor - Bei <b>true</b> mit Glassboden, bei <b>false</b> ohne
	 */
	public Car(boolean floor) {
		this(standardSeats, floor);
	}

	/**
	 * Constructor<br>
	 * Erstellt eine Gondel mit der angegebenen Anzahl Sitzplätzen und je nach
	 * Angabe mit oder ohne Glassboden
	 * @param seats - Anzahl der Sitzplätze
	 * @param floor - Bei <b>true</b> mit Glassboden, bei <b>false</b> ohne
	 * Glassboden
	 */
	public Car(int seats, boolean floor) {
		numberSeats = seats;
		glassFloor = floor;
	}

	/**
	 * Gibt den Basispreis der Hütte zurück
	 * @return - int: basicPrice
	 */
	public float getBasicPrice() {
		return basicPrize;
	}

	/**
	 * Gibt die Anzahl an Sitzplätzen zurück
	 * @return - int: numberSeats
	 */
	public int getNumberSeats() {
		return numberSeats;
	}

	/**
	 * Gibt zurück ob die Gondel einen Glassboden hat
	 * @return - boolean: <b>true</b> mit Glassboden, <b>false</b> ohne
	 * Glassboden
	 */
	public boolean isGlassFloor() {
		return glassFloor;
	}

	/**
	 * Erstellt einen String mit einer passenden Beschrebung für eine Gondel,
	 * <br>
	 * welche die <b>Anzahl</b> der Sitzplätze und das <b>Vorhandensein eines
	 * Glassbodens</b> umfasst
	 * @return - String: Beschreibung des Gondelobjekts
	 */
	public String getDescription() {
		String desc = "Gondel mit " + numberSeats + " Sitzen";
		if (glassFloor) {
			desc += " und Glasboden";
		}
		return desc;
	}

	/**
	 * Accept-Methode des Visitor Patterns die den Preis der Gondel vom
	 * übergebenen Visitor berechnen lässt
	 * @param v - Visitor
	 * @return - int: Preis der Gondel
	 */
	public float accept(Visitor v) {
		return v.calculateCarPrize(this);
	}
}
