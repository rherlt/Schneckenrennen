
public class Rennen {

	public Rennen(int schneckenanzahl, String name, int streckenLaenge)
	{
		this.schneckenanzahl = schneckenanzahl;
		this.schnecken = new Rennschnecke[schneckenanzahl];
		this.name = name;
		this.streckenLaenge = streckenLaenge;
	}
		
	//attributes
	private String name;
	private int schneckenanzahl;
	private Rennschnecke[] schnecken;
	private int streckenLaenge;
	
	//Getter- and setter
	public String getName()
	{
		return name;
	}
	
	public void setName(String value)
	{
		name = value;
	}

	/**
	 * @return the schneckenanzahl
	 */
	public int getSchneckenanzahl() {
		return schneckenanzahl;
	}

	/**
	 * @param schneckenanzahl the schneckenanzahl to set
	 */
	public void setSchneckenanzahl(int schneckenanzahl) {
		this.schneckenanzahl = schneckenanzahl;
	}

	/**
	 * @return the schnecken
	 */
	public Rennschnecke[] getSchnecken() {
		return schnecken;
	}

	/**
	 * @param schnecken the schnecken to set
	 */
	public void setSchnecken(Rennschnecke[] schnecken) {
		this.schnecken = schnecken;
	}

	/**
	 * @return the streckenLaenge
	 */
	public int getStreckenLaenge() {
		return streckenLaenge;
	}

	/**
	 * @param streckenLaenge the streckenLaenge to set
	 */
	public void setStreckenLaenge(int streckenLaenge) {
		this.streckenLaenge = streckenLaenge;
	}
	
	public void addRennschnecke(Rennschnecke neueSchnecke)
	{		
		for(int i = 0; i < schnecken.length; i++)
		{
			if(schnecken[i] == null)
			{
				schnecken[i] = neueSchnecke;
				break;
			}
		}
	}
	
	private int teilnehmerAnzahl()
	{
		int aktuelleAnzahl = 0;
		for(int i = 0; i < schnecken.length; i++)
		{
			if(schnecken[i] != null)
				aktuelleAnzahl++;
		}
		
		return aktuelleAnzahl;
	}

	public void removeRennschnecke(String name)
	{
		for(int i = 0; i < schnecken.length; i++)
		{
			if(schnecken[i].getName() == name)
			{
				schnecken[i] = null;
				schneckenanzahl--;
			}
		}
	}
	
	public String toString()
	{
		String namen = "";
		for(int i = 0; i< schnecken.length; i++)
		{
			if(schnecken[i] != null)
			{
				namen += schnecken[i].getName();
				namen += ", ";
			}
		}
		return String.format("Name: %s MaxAnzahl: %d Streckenlänge: %d Schnecken: %s", name, schneckenanzahl, streckenLaenge, namen);
	}

	public Rennschnecke ermittleGewinner()
	{
		Rennschnecke gewinnerSchnecke = null;
		
		for(int i = 0; i < schnecken.length; i++)
		{
			if((schnecken[i] != null) && (schnecken[i].getWeg() >= this.streckenLaenge))
			{
				gewinnerSchnecke = schnecken[i];
				break;
			}
		}		
		return gewinnerSchnecke;
	}
	
	void lasseSchneckenKriechen()
	{
		for (int i = 0; i < schnecken.length; i++) {
			if(schnecken[i] != null)
				schnecken[i].kriechen();			
		}
	}
	
	void durchfuehren()
	{
		Rennschnecke gewinner;
		do{
			gewinner = ermittleGewinner();
			zeichneSchnecken();
			lasseSchneckenKriechen();
			warteKurz();
		}while(gewinner == null);
	}
	
	private void warteKurz() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	void zeichneSchnecken()
	{
		final double maxWeg = 100;
		double faktor =  maxWeg /streckenLaenge;
		
		for(int i=0; i < schnecken.length; i++)
		{
			if (schnecken[i] != null)
			{
				System.out.print(schnecken[i].getName().substring(0, 2)+":");
				
				//zeichne gekrochenen Weg
				int zeichenWeg = (int)Math.round(schnecken[i].getWeg() * faktor);
				for(int j=0; j< zeichenWeg; j++)
				{
					System.out.print(".");
				}
				//zeichne Schnecke
				System.out.print("@_\"");
			}
			System.out.println();
		}	
		
		System.out.println("========== NEUE ZEITEINHEIT ======");
	}
}
