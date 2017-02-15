package zustände;

import blatt7.Ventilator;

/**
 * Dieser Zustand beschreibt einen Ventilator auf Geschwindigkeitsstufe eins
 * @author rschikor, jniedbal
 *
 */
public class ZustandEins implements Zustand {
	private Ventilator vent;
	
	public ZustandEins(Ventilator v) {
		vent = v;
	}
	
	/**
	 * Erhöht die Geschwindigkeit auf Stufe zwei, indem das Ventilator Objekt
	 * in ZustandZwei wechselt
	 */
	@Override
	public void drueckeRotenKnopf() {
		vent.setZustand(vent.getZustandZwei());
	}
	
	/**
	 * Verringert die Geschwindigkeit auf Stufe null, indem das Ventilator
	 * Objekt in ZustandNull wechsel
	 */
	@Override
	public void drueckeGruenenKnopf() {
		vent.setSchwenk(false);
		vent.setZustand(vent.getZustandNull());
	}
	
	/**
	 * Da sich der Ventilator in einem ungeraden Zustand befindet, wird der
	 * Schwenkmodus aktiviert
	 */
	@Override
	public void drueckeBeideKnoepfe() {
		vent.setSchwenk(true);
	}
	
	@Override
	public String toString() {
		return "Sufe 1";
	}

}
