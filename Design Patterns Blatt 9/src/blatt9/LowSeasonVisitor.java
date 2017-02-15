package blatt9;

import components.Cabin;
import components.Car;
import components.Paraglider;

/**
 * Diese Klasse setzt den Visitor für die Nebensaison um und liefert Methoden
 * zur Berechnung der Preise der einzelnen Buchungsoptionen
 * @author rschikor, jniedbal
 *
 */
public class LowSeasonVisitor implements Visitor {

	public float calculateCabinPrize(Cabin cabin) {
		final float pricePerBed = 10;
		final float balconyPrize = 30;
		float price = cabin.getBasicPrize()
				+ cabin.getNumberBeds() * pricePerBed;
		if (cabin.isBalcony()) {
			price += balconyPrize;
		}
		return price;
	}

	public float calculateCarPrize(Car car) {
		final float pricePerSeat = 7;
		final float priceGlassFloor = 20;
		float price = car.getNumberSeats() * pricePerSeat;
		if (car.isGlassFloor()) {
			price += priceGlassFloor;
		}

		return price;
	}

	public float calculateParagliderPrice(Paraglider paraglider) {
		final float tandemPrice = 25;
		final float motorizedPrice = 50;
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
