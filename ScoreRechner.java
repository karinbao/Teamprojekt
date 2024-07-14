package model;



public class ScoreRechner {
	
	//Deklarartionen
	private int[] dammErgebnis = new int[3];
	private int[] wasserErgebnis = new int[3];
	private static int zaehler = 0;
	private static int klassenstufe = 6;
	private static int schwierigkeitslevel = 1;
	private static int score = 17;
	private static int zweiterDurch = 0;
	
	//Kostenmatrix
	int[][] matrix = {{-7,-6,-5}, {-6,-5,-4}, {-5,-4,0}, {-4,0,0},
			           {0,0,0},   {0,0,0},    {0,0,0},   {0,0,0},
			           {-4,0,0},  {-5,-4,0},  {-6,-5,-4},{-7,-6,-5}};
	
	public String getDurchlauf(){
		
		//Daten, die in CSV geschrieben werden
		String ergebnisse = klassenstufe + ";" 
		+ (dammErgebnis[0]+1) + ";" + (wasserErgebnis[0]+1) + ";" 
		+ (dammErgebnis[1]+1) + ";" + (wasserErgebnis[1]+1) + ";" 
		+ (dammErgebnis[2]+1) + ";" + (wasserErgebnis[2]+1) + ";" + schwierigkeitslevel
		+ ";" + score + ";" + zweiterDurch;		
		
		return ergebnisse;
	}
	
	//Dammkosten abziehen vom Score
	public void setDammErgebnis(int damm) {
		dammErgebnis[zaehler] = damm;
		score = score - (damm + 1);
	}
	
	//mögliche Überflutungskosten zahlen
	public void setWasserErgebnis(int wasser) {
		wasserErgebnis[zaehler] = wasser;
		score = score + matrix[wasserErgebnis[zaehler]][dammErgebnis[zaehler]];
		
		zaehler++;
	}
	
	//Setter und Getter
	public void setKlassenstufe(int klassenstu) {
		klassenstufe = klassenstu;
	}
	
	public void setDurchlauf () {
		zweiterDurch = 1;
	}
	
	public int getKlassenstufe() {
		return klassenstufe;
	}
	
	public void setSchwierigkeit(int schwierigkeit) {
		schwierigkeitslevel = schwierigkeit;
	}

	public int getSchwierigkeit() {
		return schwierigkeitslevel;
	}
	
	public static int getScore() {
		return score;
	}
	
	public static void setScore() {
		score = 17;
		zaehler = 0;
		zweiterDurch = 0;
		klassenstufe = 6;
		schwierigkeitslevel = 1;
	}
	

}
