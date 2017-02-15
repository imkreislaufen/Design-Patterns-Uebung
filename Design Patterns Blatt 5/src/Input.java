import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * Stellt einen Dialog dar, mit dem der Benutzer Zahlen manuell eingeben kann
 * @author rschikor, jniedbal
 *
 */
public class Input extends JDialog {

	//private Klassenattribute
	private static final long serialVersionUID = 1L;
	private JSpinner eingabe;
	private JButton ok;
	private SpinnerNumberModel spmod;
	
	/**
	 * Constructor
	 */
	public Input() {
		setLayout(new GridLayout(0,1));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);	
		setModal(true);
		
		spmod = new SpinnerNumberModel(1, 1, 1, 1);
		eingabe = new JSpinner(spmod);
		ok = new JButton("Ok");
		
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);			
			}
		});
		
		// Elemente dem Dialog hinzufügen
		add(eingabe);
		add(ok);
		pack();
	}
	
	/**
	 * Legt den Maximalwert fest und macht den Dialog sichtbar
	 * @param max Maximalwert des Spinners
	 * @return eingegebene Zahl
	 */
	public int run(int max) {
		spmod.setMaximum(max);
		setVisible(true);
		return spmod.getNumber().intValue();
	}
}
