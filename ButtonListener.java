package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.*;
import view.Frame;

/*Listener für Runde-Beenden Button
 Pop-Up Fenster beim Ende der Runde
 Hinzufügen des Scores es Teilnehmers zum leaderboard
 Zurücksetzen aller Werte für neue Runde
 */
public class ButtonListener implements ActionListener{
	
	//Deklarationen
	private ScoreRechner sr;
	private CSV csv;

	//Bilder für Pop-Ups am Ende jeder Runde
	private ImageIcon icon = new ImageIcon("/Users/karin/Documents/icon.png");
	private ImageIcon icon2 = new ImageIcon("/Users/karin/Documents/icon2.png");
	
	//control mit model verbinden 
	public void setModel(ScoreRechner sr, CSV csv) {
		this.sr = sr;
		this.csv = csv;
	}

	//Implementierung der actionPerformed-Methode des ActionListeners
	@Override
	public void actionPerformed(ActionEvent e) {
		csv.csvBeschreiben(sr.getDurchlauf());
		Frame.setAnfangsText();
		ScoreRechner.setScore();
		Frame.setLeaderboard(csv.csvLesen().toArray(new String[0]));
		Frame.setSpinner();
		Frame.setCheckbox();
		
		//Pop-Up Fenster nach Abschneiden der Teilnehmer
		if(csv.getRanking() <= 50) {
		JOptionPane.showMessageDialog(Frame.getFrame(), "Glückwunsch! Du gehörst zu den Top "+ (int) csv.getRanking() + "% der Teilnehmenden", "Preis",JOptionPane.INFORMATION_MESSAGE,icon);
		}
		else {
			JOptionPane.showMessageDialog(Frame.getFrame(), "", "Ende",JOptionPane.INFORMATION_MESSAGE,icon2);
			
	
	}
	

	}
	
}
