package blatt9;

import components.Cabin;
import components.Car;
import components.Paraglider;

/**
 * Diese Klasse setzt den Visitor für die Hochsaison um und liefert Methoden
 * zur Berechnung der Preise der einzelnen Buchungsoptionen
 * @author rschikor, jniedbal
 *
 */
public class HighSeasonVisitor implements Visitor {
	
	public float calculateCabinPrize(Cabin cabin) {
		final float pricePerBed = 20.7f;
		final float balconyPrize = 40;
		float price = cabin.getBasicPrize()
				+ cabin.getNumberBeds() * pricePerBed;
		if (cabin.isBalcony()) {
			price += balconyPrize;
		}
		return price;
	}

	public float calculateCarPrize(Car car) {
		final float pricePerSeat = 10;
		final float priceGlassFloor = 25;
		float price = car.getNumberSeats() * pricePerSeat;
		if (car.isGlassFloor()) {
			price += priceGlassFloor;
		}

		return price;
	}

	public float calculateParagliderPrice(Paraglider paraglider) {
		final float tandemPrice = 30;
		final float motorizedPrice = 60;
		float price = paraglider.getBasicPrize();
		if (paraglider.isTandem()) {
			price += tandemPrice;
		}
		if (paraglider.isMotorized()) {
			price += motorizedPrice;
		}
		return price;
	}
}
