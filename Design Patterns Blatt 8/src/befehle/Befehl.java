package befehle;

/**
 * Interface welches die Methoden der Befehle festlegt
 * @author rschikor, jniedbal
 *
 */
public interface Befehl extends java.io.Serializable {

	public void ausfuehren();

	public void rueckgaengig();
}
