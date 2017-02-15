package komponente;

/**
 * 
 * @author Jessie
 *
 */
public class Textdatei extends Komponente {

	private String text;

	public Textdatei(String name, String text) {
		this.name = name + ".txt";
		this.text = text;
	}

	@Override
	public void setName(String name) {
		this.name = name + ".txt";
	}

	public String getText() {
		return text;
	}

	@Override
	public void ausgabe() {
		System.out.println(name + ":");
		System.out.println(text);
	}

	@Override
	public void aendern(String text) {
		this.text = text;
	}

	@Override
	public void aendern() {
	}
}
