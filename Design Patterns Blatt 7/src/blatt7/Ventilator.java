package blatt7;

import zustände.*;

/**
 * Stellt einen Ventilator mit 4 Geschwindigkeitsstufen und optionalen 
 * Schwenkmodus dar.
 * Zustand für Geschwindigkeit: 0 (aus), 1, 2 oder 3 (Maximum)
 * Zustand für Schwenkmodus: aus, ein
 * @author rschikor, jniedbal
 *
 */
public class Ventilator {

	// private Klassenattribute
	private ZustandNull zustandNull;
	private ZustandEins zustandEins;
	private ZustandZwei zustandZwei;
	private ZustandDrei zustandDrei;

	private Zustand zustand;
	private boolean isSchwenk;

	/**
	 * Constructor
	 */
	public Ventilator() {
		zustandNull = new ZustandNull(this);
		zustandEins = new ZustandEins(this);
		zustandZwei = new ZustandZwei(this);
		zustandDrei = new ZustandDrei(this);

		zustand = zustandNull;
	}

	/**
	 * Kapselung, um dem Benutzer zu verschleiern, dass für die Ausführung
	 * des Programmes Zustände benutzt werden. (folgende 4)
	 */
	public void drueckeRotenKnopf() {
		zustand.drueckeRotenKnopf();
	}

	public void drueckeGruenenKnopf() {
		zustand.drueckeGruenenKnopf();
	}

	public void dreuckeBeideKnoepfe() {
		zustand.drueckeBeideKnoepfe();
	}

	public String getZustandsBeschreibung() {
		return zustand.toString();
	}
	
	/**
	 * Setzt den Zustand des Ventilators
	 * @param z - Zustand
	 */
	public void setZustand(Zustand z) {
		zustand = z;
	}

	/**
	 * Gibt das jeweilige Zustandsobjekt zurück, das benötigt wird
	 * @return Zustand - entweder 0, 1, 2 oder 3 (folgende 4)
	 */
	public Zustand getZustandNull() {
		return zustandNull;
	}

	public Zustand getZustandEins() {
		return zustandEins;
	}

	public Zustand getZustandZwei() {
		return zustandZwei;
	}

	public Zustand getZustandDrei() {
		return zustandDrei;
	}

	/**
	 * Gibt an, ob der Schwenkmodus aktiv ist
	 * @return boolean
	 */
	public boolean isSchwenk() {
		return isSchwenk;
	}
	
	/**
	 * Beeinflusst den Schwenkmodus-Zustand
	 * @param schwenk - boolean
	 */
	public void setSchwenk(boolean schwenk) {
		isSchwenk = schwenk;
	}

}
