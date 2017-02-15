package zustände;

import blatt7.Ventilator;

/**
 * Dieser Zustand beschreibt einen ausgeschalteten Ventilator
 * @author rschikor, jniedbal
 *
 */
public class ZustandNull implements Zustand {

	private Ventilator vent;
	
	public ZustandNull(Ventilator v) {
		vent = v;
	}
	
	/**
	 * Erhöht die Geschwindigkeit auf Stufe eins, indem das Ventilator Objekt
	 * in ZustandEins wechselt
	 */
	@Override
	public void drueckeRotenKnopf() {
		vent.setZustand(vent.getZustandEins());
	}
	
	/**
	 * Tut nichts, da der Ventilator ausgeschaltet ist
	 */
	@Override
	public void drueckeGruenenKnopf() {
	}
	
	/**
	 * Schwenkmodus im ausgeschalteten Zustand macht wenig Sinn...
	 */
	@Override
	public void drueckeBeideKnoepfe() {
	}
	
	@Override
	public String toString() {
		return "Sufe 0";
	}
	
}
