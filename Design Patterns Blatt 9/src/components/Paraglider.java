package components;

import blatt9.Visitor;

/**
 * Diese Klasse beschreibt einen Gleitschirm als Buchungsoption
 * @author rschikor, jniedbal
 *
 */
public class Paraglider {

	// Werte für einen Standard-Gleitschirm
	private static final boolean defaultTandem = true;
	private static final boolean defaultMotorized = false;

	// Gleitschirmeigenschaften
	private final float basicPrize = 60;
	private final boolean isTandem;
	private final boolean isMotorized;

	/**
	 * Default-Constructor<br>
	 * Erstellt einen <b>Tandem-Gleitschirm</b>, <b>ohne</b> Motorisierung
	 */
	public Paraglider() {
		this(defaultTandem, defaultMotorized);
	}

	/**
	 * Constructor<br>
	 * Erstellt je nach Angabe einen <b>Einzel-</b> oder einen <b>Tandem-</b>
	 * Gleitschirm, <b>mit</b> oder <b>ohne</b> Motorisierung
	 * @param tandem - Bei <b>true</b> Tandem-, bei <b>false</b>
	 * Einzel-Gleitschirm
	 * @param motor - Bei <b>true</b> motorisiert, bei <b>false</b> nicht
	 * motorisiert
	 */
	public Paraglider(boolean tandem, boolean motor) {
		isTandem = tandem;
		isMotorized = motor;
	}

	/**
	 * Gibt den Basispreis der Hütte zurück
	 * @return - int: basicPrice
	 */
	public float getBasicPrize() {
		return basicPrize;
	}

	/**
	 * Gibt zurück ob es ein Einzel-Gleitschirm oder ein Tandem-Gleitschirm ist
	 * @return - boolean: <b>true</b> Tandem-Gleitschirm, <b>false</b>
	 * Einzel-Gleitschirm
	 */
	public boolean isTandem() {
		return isTandem;
	}

	/**
	 * Gibt zurück ob der Gleitschirm motorisiert ist, oder nicht
	 * @return - boolean: <b>true</b> motorisiert, <b>false</b> nicht
	 * motorisiert
	 */
	public boolean isMotorized() {
		return isMotorized;
	}

	/**
	 * Erstellt einen String mit einer passenden Beschrebung für einen
	 * Gleitschirm,<br>
	 * welche die <b>Art</b> und <b>Vorhandensein einer
	 * Motorisierung</b> umfasst
	 * @return - String: Beschreibung des Gleitschirmobjekts
	 */
	public String getDescription() {
		String desc = "";
		if (isTandem) {
			desc += "Tandem-Gleitschirm";
		} else {
			desc += "Einzel-Gleitschirm";
		}
		if (isMotorized) {
			desc += " mit Motor";
		}
		return desc;
	}

	/**
	 * Accept-Methode des Visitor Patterns die den Preis des Gleitschirms vom
	 * übergebenen Visitor berechnen lässt
	 * @param v - Visitor
	 * @return - int: Preis der Gondel
	 */
	public float accept(Visitor v) {
		return v.calculateParagliderPrice(this);
	}
}
