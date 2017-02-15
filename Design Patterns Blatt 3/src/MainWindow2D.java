import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * 
 * @author rschikor, jniedbal
 * 
 */
public class MainWindow2D extends MainWindow {
	private static final long serialVersionUID = 1L;

	MyCanvas canvas;
	JButton dreieck, quadrat, kreis, reset;
	JRadioButton blau, rot;

	// Umsetzung der Factory Method
	@Override
	protected Figur doMakeFigur(String form, Color color) {
		switch (form) {
		case "Dreieck":
			return new Dreieck(color);
		case "Quadrat":
			return new Quadrat(color);
		case "Kreis":
			return new Kreis(color);
		default:
			return null;
		}
	}

	// Constructor für das 2D Mainwindow
	public MainWindow2D() {
		// Fenstereigenschaften definieren
		super("Geometrische Objekte");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 250);
		setVisible(true);
		setResizable(false);

		// GUI-Elemente definieren
		canvas = new MyCanvas();
		canvas.setSize(200, 200);
		dreieck = new JButton("Dreieck");
		quadrat = new JButton("Quadrat");
		kreis = new JButton("Kreis");
		reset = new JButton("Reset");
		blau = new JRadioButton("Blau");
		rot = new JRadioButton("Rot");
		ButtonGroup farbAuswahl = new ButtonGroup();
		farbAuswahl.add(blau);
		farbAuswahl.add(rot);
		blau.setSelected(true);

		// Hauptpanel und Layout definieren
		JPanel mainPanel = new JPanel();
		setContentPane(mainPanel);
		setLayout(new GridBagLayout());
		
		// Konfigurationsvariable für das gridBagLayout
		GridBagConstraints con = new GridBagConstraints();

		// Elemente zum MainPanel hinzufügen und positionieren
		// Buttongröße normieren
		con.fill = GridBagConstraints.HORIZONTAL;
		// Position des Canvas festlegen
		con.gridx = 0;
		con.gridy = 0;
		con.gridheight = 5;
		add(canvas, con);
		
		// Position der Buttons anhand von Koordinaten auf der GUI platzieren
		con.gridwidth = 2;
		con.gridheight = 1;
		con.gridx = 1;
		add(dreieck, con);
		
		con.gridy = 1;
		add(quadrat, con);

		con.gridy = 2;
		add(kreis, con);
		
		con.gridy = 3;
		add(reset, con);
		
		// Platziere beide RadioButtons nebeneinander unter den Form-Buttons
		con.gridwidth = 1;
		con.gridy = 4;
		add(rot, con);
		con.gridx = 2;
		add(blau, con);

		// Zeichnet ein Dreieck bei der Betätigung des Buttons
		dreieck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.add(doMakeFigur("Dreieck", getColor()));
			}
		});

		// Zeichnet ein Quadrat bei der Betätigung des Buttons
		quadrat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.add(doMakeFigur("Quadrat", getColor()));
			}
		});

		// Zeichnet einen Kreis bei der betätigung des Buttons
		kreis.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.add(doMakeFigur("Kreis", getColor()));
			}
		});

		// Setzt die Zeichenfläche bei Betätigung des Buttons zurück
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.clear();
			}
		});

	}

	// Hilfsmethode um die ausgewählte Farbe zu bekommen
	private Color getColor() {
		if (blau.isSelected()) {
			return Color.blue;
		} else {
			return Color.red;
		}
	}

}
