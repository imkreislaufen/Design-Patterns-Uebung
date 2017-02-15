package ofen;
/**
 * Diese Klasse stellt den speziellen Siemens-Ofen IQ500HV541ANS0 bereit.
 * @author rschikor, jniedbal
 */
public class OfenSiemensIQ500HV541ANS0 extends Ofen {
		
	/**
	 * Constructor
	 */
	public OfenSiemensIQ500HV541ANS0() {
		super("Siemens");
		
		garRaumgroesse = 77;
		minTemperatur = 50;
		maxTemperatur = 250;
	}
}
