package controller;


import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.ScoreRechner;

//Spinnerlistener für die Abfrage der Klassenstufe
public class SpinnerListener implements ChangeListener{
	
	//Deklarationen
	private int klassenstufe;
	private ScoreRechner scorerechner;
	
	//control mit model verbinden
	public void setModel(ScoreRechner scorerechner) {
		this.scorerechner = scorerechner;
	}
	
	//Implementierung der stateChanged-Methode des ChangeListeners
	@Override
	public void stateChanged(ChangeEvent e) {
		JSpinner spinner = (JSpinner) e.getSource();
		klassenstufe = (int) spinner.getValue();
		scorerechner.setKlassenstufe(klassenstufe);
}
	
	
}
