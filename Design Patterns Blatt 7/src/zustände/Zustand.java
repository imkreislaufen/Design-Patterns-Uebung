package zustände;

/**
 * Interface welches die Methoden der Zustände festlegt
 * @author rschikor, jniedbal
 *
 */
public interface Zustand {
	public void drueckeRotenKnopf();
	public void drueckeGruenenKnopf();
	public void drueckeBeideKnoepfe();
	public String toString();
}
