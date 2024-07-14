package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import controller.*;

public class Frame extends JFrame{
	
	//Variablendeklaration
	private static final long serialVersionUID = 1L;
	private static Container c;
	private static JPanel abfrage, ergebnis, abfrageKlein, runde1, runde2, runde3;
	private static JPanel generelles, klassenstufe, schwierigkeitslevel, rechteSeite, zweitesMal;
	private static JLabel abfrageTitel, ergebnisTitel;
	private static JLabel aktuellerStand;
	private static JLabel anweisung1, anweisung2, abfrage2;
	private static JList<String> dammListe1, dammListe2, dammListe3, leaderboard;
	private static JList<Integer> round1,round2, round3;
	private static JSpinner spinner1, spinner2;
	private static SpinnerNumberModel model1, model2;
	private static JButton ende;
	private static JCheckBox zweiterDurch;
	
	// Konstruktor der Klasse; erzeugt das Fenster 
	public Frame() {
			
			//Allgemeines
			setTitle("Probabilistische Prognosen - KIT");
			setSize(800, 600);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			Font f = new Font("Times New Roman", Font.PLAIN, 24);
			Font customFont = new Font("Arial", Font.BOLD, 24);
			c = getContentPane();
			c.setLayout(new GridLayout(0,2));
			
			
			//Grobes Layout
			abfrage = new JPanel();
			abfrage.setLayout(new BorderLayout());
			abfrage.setBorder(new EmptyBorder(0, 10, 0, 1));
			abfrageKlein = new JPanel();
			abfrageKlein.setLayout(new GridLayout(3,0));
			runde1 = new JPanel();
			runde1.setLayout(new GridLayout(0,2));
			runde2 = new JPanel();
			runde2.setLayout(new GridLayout(0,2));
			runde3 = new JPanel();
			runde3.setLayout(new GridLayout(0,2));
			ergebnis = new JPanel ();
			ergebnis.setLayout(new BorderLayout());
			ergebnis.setBorder(new EmptyBorder(0, 1, 0, 10));
			c.add(abfrage);
			c.add(ergebnis);
			
			// linkes Panel
			
			//Klassenstufeabfrage
			model1 = new SpinnerNumberModel(6, 0, 12, 1);
	        spinner1 = new JSpinner(model1);
	        
	        //Schwierigkeitslevelabfrage
	        model2 = new SpinnerNumberModel(1, 1, 3, 1);
	        spinner2 = new JSpinner(model2);
			
			//Abfragen
			abfrageTitel = new JLabel("Entscheidung");
			abfrageTitel.setPreferredSize(new Dimension(300, 45));
			abfrageTitel.setFont(f);
			anweisung1 = new JLabel("Klassenstufe: ");
			anweisung1.setFont(f);
			anweisung2 = new JLabel("Schwierigkeitslevel");
			anweisung2.setFont(f);
			aktuellerStand = new JLabel("Du hast noch 17 Münzen zur Verfügung");
			aktuellerStand.setFont(customFont);
			
			klassenstufe = new JPanel();
			klassenstufe.setLayout(new BorderLayout());
			klassenstufe.add(anweisung1, BorderLayout.CENTER);
			klassenstufe.add(spinner1, BorderLayout.EAST);
			
			schwierigkeitslevel = new JPanel();
			schwierigkeitslevel.setLayout(new BorderLayout());
			schwierigkeitslevel.add(anweisung2, BorderLayout.CENTER);
			schwierigkeitslevel.add(spinner2, BorderLayout.EAST);
			
			//abfrage, ob zweiter Durchlauf
			zweitesMal = new JPanel();
			zweitesMal.setLayout(new BorderLayout());
			abfrage2 = new JLabel("zweiter Durchlauf?");
			abfrage2.setFont(f);
			zweiterDurch = new JCheckBox();
			zweitesMal.add(abfrage2, BorderLayout.CENTER);
			zweitesMal.add(zweiterDurch, BorderLayout.EAST);
			
			generelles = new JPanel();
			generelles.setLayout(new GridLayout(4,0));
			generelles.add(aktuellerStand);
			generelles.add(klassenstufe);
			generelles.add(schwierigkeitslevel);
			generelles.add(zweitesMal);
			generelles.setSize(320, 100);
			abfrage.add(abfrageTitel, BorderLayout.NORTH);
			abfrage.add(generelles, BorderLayout.SOUTH);

			
			//Dämme und Würfelzahl 3x
			
			//Listen
			String[] daemme = {"Damm 1", "Damm 2", "Damm 3"};
			Integer[] wuerfel = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
			dammListe1 = new JList<String>(daemme);
			dammListe1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			DefaultListCellRenderer renderer = (DefaultListCellRenderer) dammListe1.getCellRenderer();
	        renderer.setHorizontalAlignment(SwingConstants.CENTER);
			JScrollPane scrollPane1 = new JScrollPane(dammListe1);
			scrollPane1.setPreferredSize(new Dimension(300, 200));
			runde1.add(scrollPane1);
			round1 = new JList<Integer>(wuerfel);
			round1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			DefaultListCellRenderer renderer4 = (DefaultListCellRenderer) round1.getCellRenderer();
	        renderer4.setHorizontalAlignment(SwingConstants.CENTER);
			JScrollPane scrollPane4 = new JScrollPane(round1);
			scrollPane4.setPreferredSize(new Dimension(300, 600));
			runde1.add(scrollPane4);
			
			dammListe2 = new JList<String>(daemme);
			dammListe2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			DefaultListCellRenderer renderer2 = (DefaultListCellRenderer) dammListe2.getCellRenderer();
	        renderer2.setHorizontalAlignment(SwingConstants.CENTER);
			JScrollPane scrollPane2 = new JScrollPane(dammListe2);
			scrollPane2.setPreferredSize(new Dimension(300, 600));
			runde2.add(scrollPane2);
			round2 = new JList<Integer>(wuerfel);
			round2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			DefaultListCellRenderer renderer5 = (DefaultListCellRenderer) round2.getCellRenderer();
	        renderer5.setHorizontalAlignment(SwingConstants.CENTER);
			JScrollPane scrollPane5 = new JScrollPane(round2);
			scrollPane5.setPreferredSize(new Dimension(300, 600));
			runde2.add(scrollPane5);
			
			dammListe3 = new JList<String>(daemme);
			dammListe3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			DefaultListCellRenderer renderer3 = (DefaultListCellRenderer) dammListe3.getCellRenderer();
	        renderer3.setHorizontalAlignment(SwingConstants.CENTER);
			JScrollPane scrollPane3 = new JScrollPane(dammListe3);
			scrollPane3.setPreferredSize(new Dimension(300, 600));
			runde3.add(scrollPane3);
			round3 = new JList<Integer>(wuerfel);
			round3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			DefaultListCellRenderer renderer6 = (DefaultListCellRenderer) round3.getCellRenderer();
	        renderer6.setHorizontalAlignment(SwingConstants.CENTER);
			JScrollPane scrollPane6 = new JScrollPane(round3);
			scrollPane6.setPreferredSize(new Dimension(300, 600));
			runde3.add(scrollPane6);
			
			abfrageKlein.add(runde1);
			abfrageKlein.add(runde2);
			abfrageKlein.add(runde3);
			abfrage.add(abfrageKlein,BorderLayout.CENTER);
			
			
			//rechte Seite
			
			ergebnisTitel = new JLabel("Ergebnis");
			ergebnisTitel.setPreferredSize(new Dimension(150, 45));
			ergebnisTitel.setFont(customFont);
			rechteSeite = new JPanel();
			rechteSeite.setLayout(new GridLayout(0,2));
			rechteSeite.add(ergebnisTitel);
			
			//Button für Runde beenden
			ende = new JButton("Runde beenden");
			ende.setBackground(Color.RED);
			ende.setForeground(Color.WHITE);
			ende.setOpaque(true);
			ende.setBorderPainted(false);
	        ende.setFont(new Font("Arial", Font.BOLD, 20));
			rechteSeite.add(ende);
			ergebnis.add(rechteSeite, BorderLayout.NORTH);
			
			//Leaderboard
			leaderboard = new JList<String>();
			JScrollPane scrollPane7 = new JScrollPane(leaderboard);
			scrollPane7.setPreferredSize(new Dimension(300, 200));
			ergebnis.add(scrollPane7, BorderLayout.CENTER);
			
			//Aesthetisches
			spinner1.setForeground(Color.black);
			spinner2.setForeground(Color.black);
			abfrage.setForeground(Color.black);
			ergebnis.setForeground(Color.black);
			spinner1.setFont(f);
			spinner2.setFont(f);
			abfrage.setFont(f);
			ergebnis.setFont(f);
			
			c.revalidate();
			pack();
			
		}
	

	//set_Control Methoden für MVC-Ansatz
	
	public void setControl_Klassenstufe (SpinnerListener listener) {
		spinner1.addChangeListener(listener);
	}
	
	public void setControl_Schierigkeitslevel (SpinnerListener2 spinnerlistener2) {
		spinner2.addChangeListener(spinnerlistener2);
	}

	public void setControl_Damm (DammListener listener) {
		dammListe1.addMouseListener(listener);
		dammListe2.addMouseListener(listener);
		dammListe3.addMouseListener(listener);
	}
	
	public void setControl_Zahl (ZahlListener listener) {
		round1.addMouseListener(listener);
		round2.addMouseListener(listener);
		round3.addMouseListener(listener);
	}
	
	public void setControl_Button (ButtonListener buttonl) {
		ende.addActionListener(buttonl);
	}
	
	public void setControl_Check (CheckBoxListener listener) {
		zweiterDurch.addActionListener(listener);
	}
	
	public static void setText(int score) {
		aktuellerStand.setText("Du hast noch " + score + " Münzen zur Verfügung");
	}
	
	public static void setAnfangsText() {
		aktuellerStand.setText("Du hast noch 17 Münzen zur Verfügung");
	}
	
	public static void setSpinner() {
		spinner1.setValue(6);
		spinner2.setValue(1);
	}
	
	public static void setCheckbox() {
		zweiterDurch.setSelected(false);
	}
	
	public static void setLeaderboard(String[] array) {
		leaderboard.setListData(array);
        Font font = new Font("Arial", Font.PLAIN, 20); 
        leaderboard.setFont(font);
		}
	
	public static Container getFrame() {
		return c;
	}
}
