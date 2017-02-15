package blatt9;

import components.Cabin;
import components.Car;
import components.Paraglider;

/**
 * Dieses Interface legt Methoden fest, um die Preise der einzelnen Buchungs-
 * optionen zu berechnen
 * @author rschikor, jniedbal
 *
 */
public interface Visitor {

	/**
	 * Lässt einen konkreten Visitor den Preis einer Hütte berechnen
	 * @param cabin - Instanz einer konkreten Hütte
	 * @return
	 */
	public float calculateCabinPrize(Cabin cabin);

	/**
	 * Lässt einen konkreten Visitor den Preis einer Gondel berechnen
	 * @param car - Instanz einer konkreten Gondel
	 * @return
	 */
	public float calculateCarPrize(Car car);

	/**
	 * Lässt einen konkreten Visitor den Preis eines Gleitschirms berechnen
	 * @param paraglider - Instanz eines konkreten Gleitschirms
	 * @return
	 */
	public float calculateParagliderPrice(Paraglider paraglider);
}
