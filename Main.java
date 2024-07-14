package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import controller.*;
import model.*;
import view.*;


public class Main {
	
	//Deklarationen
	private static DammListener dammlistener;
	private static SpinnerListener spinnerlistener;
	private static SpinnerListener2 spinnerlistener2;
	private static ZahlListener zahllistener;
	private static ButtonListener buttonl;
	private static Frame frame;
	private static ScoreRechner scorerechner;
	private static CSV csv;
	private static CheckBoxListener check;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Datei erstellen mit Namen
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM");
	    String currentDate = dateFormat.format(new Date());
	    String filename = "teamprojekt_" + currentDate + ".csv";
	    File f = new File(filename);
	    
	    //Initialisierungen
	    frame = new Frame();
	    dammlistener = new DammListener();
	    spinnerlistener = new SpinnerListener();
	    spinnerlistener2 = new SpinnerListener2();
	    zahllistener = new ZahlListener();
	    scorerechner = new ScoreRechner();
	    buttonl = new ButtonListener();
	    csv = new CSV();
	    check = new CheckBoxListener();
	    
	    //frame mit control verbinden
	    frame.setVisible(true);
		frame.setControl_Klassenstufe(spinnerlistener);
		frame.setControl_Schierigkeitslevel(spinnerlistener2);
		frame.setControl_Damm(dammlistener);
		frame.setControl_Zahl(zahllistener);
		frame.setControl_Button(buttonl);
		frame.setControl_Check(check);
	
		//control mit model verbinden
		dammlistener.setModel(scorerechner);
		spinnerlistener.setModel(scorerechner);
		spinnerlistener2.setModel(scorerechner);
		zahllistener.setModel(scorerechner);
		buttonl.setModel(scorerechner,csv);
		check.setModel(scorerechner);
		
		//Leaderboard setzen
		  if(f.exists()) {
		    	Frame.setLeaderboard(csv.csvLesen().toArray(new String[0]));
		    }
		  
		  //Kopf der CSV-Datei schreiben
		    if(!f.exists()) {
		    try(BufferedWriter schreiber = new BufferedWriter(new FileWriter(filename))){
				StringBuilder sb = new StringBuilder();
				sb.append("Klassenstufe;Durchlauf 1 - Damm;Durchlauf 1 - Würfelzahl;Durchlauf 2 - Damm;Durchlauf 2 - Würfelzahl;Durchlauf 3 - Damm;Durchlauf 3 - Würfelzahl;Schwierigkeitslevel;Score;zweiter Durchlauf");
				schreiber.write(sb.toString());
				schreiber.newLine();
		    } catch(IOException e) {
			}}
		
	}

}
