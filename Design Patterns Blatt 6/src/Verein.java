public class Verein {
	protected String name;
	protected int tore;
	protected int gegenTore;
	protected int position;
	protected int spiele;
	protected int punkte;

	public Verein(String name) {
		this.name = name;
	}

	public void partieGespielt(Spiel partie) {

		// Verein in Rolle der Heimmannschaft
		if (partie.heim.equals(name)) {
			tore += partie.toreHeim;
			gegenTore += partie.toreGast;
			spiele++;
			if (partie.toreHeim - partie.toreGast > 0) {
				punkte += 3;
			} else if (partie.toreGast == partie.toreHeim) {
				punkte += 1;
			}
		}
		// Verein in Rolle der Gastmannschaft
		else if (partie.gast.equals(name)) {
			tore += partie.toreGast;
			gegenTore += partie.toreHeim;
			spiele++;
			if (partie.toreGast - partie.toreHeim > 0) {
				punkte += 3;
			} else if (partie.toreGast == partie.toreHeim) {
				punkte += 1;
			}
		}
	}
}
