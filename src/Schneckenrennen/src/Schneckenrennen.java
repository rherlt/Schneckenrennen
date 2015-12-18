
public class Schneckenrennen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rennschnecke speedy = new Rennschnecke("Nacktschnecke");
		speedy.setName("speedy gonzales");
		speedy.setMaximalgeschwindigkeit(80);
		
		Rennschnecke ronny = new Rennschnecke("Weinbergschnecke");
		ronny.setName("ronny gonzales");
		ronny.setMaximalgeschwindigkeit(90);
		
		Rennen aussnailianOpen = new Rennen(4, "Aussnailian Open", 200);
		
		aussnailianOpen.addRennschnecke(speedy);
		aussnailianOpen.addRennschnecke(ronny);
		
		System.out.println("Rennen: "+aussnailianOpen.toString());
		aussnailianOpen.durchfuehren();
		
		Rennschnecke gewinner = aussnailianOpen.ermittleGewinner();
		System.out.println("Gewinner: "+gewinner.toString());
	}

}