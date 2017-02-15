/**
 * 
 * @author Jessie
 *
 */
public class Bilddatei extends Komponente {

private String path;

public Bilddatei(String name, String path) {
	this.name = name + ".jpg";
	this.path = path;
}

@Override
public void setName(String name) {
	this.name = name + ".jpg";
}

public String getPath() {
	return path;
}

@Override
public void ausgabe() {
	System.out.println(name);
}

@Override
public void aendern(String path) {
	this.path = path;
}

@Override
public void aendern() {
}
}
