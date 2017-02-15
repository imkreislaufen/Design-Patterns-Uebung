package zustände;

import blatt7.Ventilator;

/**
 * Dieser Zustand beschreibt einen Ventilator auf Geschwindigkeitsstufe zwei
 * @author rschikor, jniedbal
 *
 */
public class ZustandZwei implements Zustand {
	
	private Ventilator vent;
	
	public ZustandZwei(Ventilator v) {
		vent = v;
	}
	
	/**
	 * Erhöht die Geschwindigkeit auf Stufe drei, indem das Ventilator Objekt
	 * in ZustandDrei wechselt
	 */
	@Override
	public void drueckeRotenKnopf() {
		vent.setZustand(vent.getZustandDrei());	
	}
	
	/**
	 * Verringert die Geschwindigkeit auf Stufe eins, indem das Ventilator
	 * Objekt in ZustandEins wechsel
	 */
	@Override
	public void drueckeGruenenKnopf() {
		vent.setZustand(vent.getZustandEins());
	}

	/**
	 * Da sich der Ventilator in einem geraden Zustand befindet, wird der
	 * Schwenkmodus deaktiviert
	 */
	@Override
	public void drueckeBeideKnoepfe() {
		vent.setSchwenk(false);
	}
	
	@Override
	public String toString() {
		return "Sufe 2";
	}

}
