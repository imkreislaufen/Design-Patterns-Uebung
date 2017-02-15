package zustände;

import blatt7.Ventilator;

/**
 * Dieser Zustand beschreibt einen Ventilator auf Geschwindigkeitsstufe eins
 * @author rschikor, jniedbal
 *
 */
public class ZustandDrei implements Zustand {
	
	private Ventilator vent;
	
	public ZustandDrei(Ventilator v) {
		vent = v;
	}

	/**
	 * Tut nichts, da der Ventilator bereits die höchste Stufe erreicht hat
	 */
	@Override
	public void drueckeRotenKnopf() {
	}

	/**
	 * Verringert die Geschwindigkeit auf Stufe zwei, indem das Ventilator
	 * Objekt in ZustandZwei wechsel
	 */
	@Override
	public void drueckeGruenenKnopf() {
		vent.setZustand(vent.getZustandZwei());
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
		return "Sufe 3";
	}

}
