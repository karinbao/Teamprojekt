package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JList;
import model.ScoreRechner;
import view.Frame;

//Dammlistener für die Abfrage der jeweils ausgeählten Dämme pro Runde
public class DammListener implements MouseListener{
	
	//Deklarartionen
	private int dammname;
	private ScoreRechner scorerechner;
	
	//model mit control verbinden
	public void setModel(ScoreRechner scorerechner) {
		this.scorerechner = scorerechner;
	}

	
	//gibt den ausgewählten Damm wieder
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		JList<String> jlist = (JList<String>) e.getSource();
		if (e.getClickCount() >= 1) {
             int index = jlist.locationToIndex(e.getPoint());
             jlist.clearSelection();
             
             if(index == -1 ) {
    			return;
    		} else {
    			dammname = index;
    		}
         	
    		scorerechner.setDammErgebnis(dammname);
    		Frame.setText(ScoreRechner.getScore());
    	}
		
		}
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}