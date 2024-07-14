package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import model.ScoreRechner;

//CheckBoxListener für die Abfarge, ob es sich um den zweiten Durchlauf handelt
public class CheckBoxListener implements ActionListener{

	//Deklaration
	private ScoreRechner sr;
	
	//control mit model verbinden
	public void setModel(ScoreRechner sr) {
		this.sr = sr;
	}
	
	//Implementierung der actionPerformed-Methode des ActionListeners
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JCheckBox check = (JCheckBox) e.getSource();
		if (check.isSelected()) {
			sr.setDurchlauf();
        } 
	}

}
