package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;


public class CSV {
	
	 //aktuelles Datum abfragen für Dateiname
	 static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM");
	 static String currentDate = dateFormat.format(new Date());
     static String filename = "teamprojekt_" + currentDate + ".csv";
     static double ranking;
     

    //Methode um CSV zu beschreiben
	public void csvBeschreiben(String ergebnis) {
		
		try(BufferedWriter schreiber = new BufferedWriter(new FileWriter(filename,true))){
				
				StringBuilder sb = new StringBuilder();
				String delimiter = ";";
				String[] result = ergebnis.split(delimiter);
				String klassenstufe = result[0];
				String damm_1 = result[1];
				String wuerfel_1 = result[2];
				String damm_2 = result[3];
				String wuerfel_2 = result[4];
				String damm_3 = result[5];
				String wuerfel_3 = result[6];
				String schwierigkeit = result[7];
				String score = result[8];
				String zweiterDurch = result[9];
				
				sb.append(klassenstufe);
				sb.append(";");
				sb.append(damm_1);
				sb.append(";");
				sb.append(wuerfel_1);
				sb.append(";");
				sb.append(damm_2);
				sb.append(";");
				sb.append(wuerfel_2);
				sb.append(";");
				sb.append(damm_3);
				sb.append(";");
				sb.append(wuerfel_3);
				sb.append(";");
				sb.append(schwierigkeit);
				sb.append(";");
				sb.append(score);
				sb.append(";");
				sb.append(zweiterDurch);
				schreiber.write(sb.toString());
				schreiber.newLine();	
			
		} catch(IOException e) {
	

		}}
		
	//Methode, um CSV zu lesen für das Leaderboard
	public List<String> csvLesen() {
		
		//Code für richtige Anordnung auf dem Leaderboard und gezeigter Text
		String zeile;
		String delimiter = ";";
		List<String> leaderboard = new LinkedList<String>();
		TreeMap<Integer, List<String>> auswahl = new TreeMap<>(Collections.reverseOrder());
		int zaehler = 0;
		double zaehlerschlechter = 0;
		int score = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			
			while ((zeile = reader.readLine()) != null) {
				if(zaehler != 0) {
				String[] test = zeile.split(delimiter);
	            score = Integer.parseInt(test[8]);
	            leaderboard = auswahl.get(score);
	            	
	            if(leaderboard == null) {
	      				leaderboard = new LinkedList<String>();
	      		} 
	            leaderboard.add("Spieler Nr. " + zaehler + " mit einem Score von " + score);
	            auswahl.put(score, leaderboard);
				}
	            zaehler++;      	
			}
				
				//Berechnungen für das Ranking des aktuell Teilnehmenden
			for(int i = -8; i < score; i++) {
				List<String> schlechter = auswahl.get(i);
				if(schlechter != null ) {
					for(String anzahl: schlechter) {
						zaehlerschlechter++;
					}
				}
					
				ranking = ((zaehler-zaehlerschlechter-1)/(zaehler-1))*100;} 
				
				
		} catch(IOException e) {
				
		}
			
		//Umformungen der TreeMap, um leaderboard richtig anzeigen zu können
		List<List<String>> auswahl2;
		auswahl2 = new ArrayList<>(auswahl.values());
			
		@SuppressWarnings("unchecked")
		List<String>[] result = auswahl2.toArray(new List[0]);
			
		String[][] twoDimensionalArray = new String[result.length][];
		for (int j = 0; j < result.length; j++) {
		            twoDimensionalArray[j] = result[j].toArray(new String[0]);
		}
		        
		List<String> list = new ArrayList<>();
		for (String[] row : twoDimensionalArray) {
			list.addAll(Arrays.asList(row));
		}
			
		return list;
			 
		}
	
	public double getRanking() {
		return ranking;
	}
	
	
}
		

	