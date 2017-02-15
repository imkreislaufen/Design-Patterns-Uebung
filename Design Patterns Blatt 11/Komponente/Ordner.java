/**
 * 
 * @author Jessie
 *
 */
public class Ordner extends Komponente {

public Ordner(String name) {
	this.name = name;
}

@Override
public void ausgabe() {
	System.out.println(name);
}

@Override
public void aendern() {
}

@Override
public void hinzufuegen(Komponente komponente) {
}

@Override
public void loeschen(Komponente komponente) {
}

@Override
public Komponente kinder(int index) {
	return null;
}
}
