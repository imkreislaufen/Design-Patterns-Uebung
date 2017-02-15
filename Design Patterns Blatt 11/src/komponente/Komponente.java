package komponente;

/**
 * 
 * @author Jessie
 *
 */
public abstract class Komponente {

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void ausgabe();

	public abstract void aendern();

	public void hinzufuegen(Komponente komponente) {
	};

	public void loeschen(Komponente komponente) {
	};

	public Komponente kinder(int index) {
		return null;
	}

	public void aendern(String text) {
	}
}
