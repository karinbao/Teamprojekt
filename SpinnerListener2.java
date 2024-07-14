package controller;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.ScoreRechner;

//Spinnerlistener für die Abfrage des Schwierigkeitslevel
public class SpinnerListener2 implements ChangeListener{
	
	//Deklarartion
	private int schwierigkeit;
	private ScoreRechner scorerechner;
	
	//control mit model verbinden
	public void setModel(ScoreRechner scorerechner) {
		this.scorerechner = scorerechner;
	}

	//Implementierung der stateChanged-Methode des ChangeListeners
	@Override
	public void stateChanged(ChangeEvent e) {
		JSpinner spinner = (JSpinner) e.getSource();
		schwierigkeit = (int) spinner.getValue();
		scorerechner.setSchwierigkeit(schwierigkeit);
}

	
}
