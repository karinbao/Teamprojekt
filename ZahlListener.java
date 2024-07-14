package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JList;
import model.ScoreRechner;
import view.Frame;

//Zahllistener für die Abfrage der jeweils gewürfelten Zahl (analog zum Dammlistener)
public class ZahlListener implements MouseListener{
		
	//Deklarartionen
	private int wuerfelzahl;
	private ScoreRechner scorerechner;

	public void setModel(ScoreRechner scorerechner) {
			this.scorerechner = scorerechner;
	}

	//gibt die gewürfelte Zahl wieder
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
	    			wuerfelzahl = index;
	    		}
	         	
	        scorerechner.setWasserErgebnis(wuerfelzahl);
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

