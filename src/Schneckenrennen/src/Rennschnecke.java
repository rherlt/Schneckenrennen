import java.util.Random;

public class Rennschnecke {

	public Rennschnecke(String rasse)
	{
		this.rasse = rasse;
	}
	
	//attributes
	private String name;
	private String rasse;
	private int maximalgeschwindigkeit;
	private int weg;
	
	//getters and setters
	public String getName()
	{
		return name;
	}
	
	public void setName(String value)
	{
		name = value;
	}

	public String getRasse() {
		return rasse;
	}

	public void setRasse(String value) {
		rasse = value;
	}

	public int getMaximalgeschwindigkeit() {
		return maximalgeschwindigkeit;
	}

	public void setMaximalgeschwindigkeit(int maximalgeschwindigkeit) {
		this.maximalgeschwindigkeit = maximalgeschwindigkeit;
	}

	public int getWeg() {
		return weg;
	}

	public void setWeg(int weg) {
		this.weg = weg;
	}
	
	//public methods
	public void kriechen()
	{
		Random rnd = new Random();
		int neuerWeg = rnd.nextInt(maximalgeschwindigkeit);
		weg += neuerWeg;
	}
	
	public String toString()
	{
		String value = String.format("%s %s, %d, %d", name, 
				rasse, maximalgeschwindigkeit, weg);
		return value;
	}
	
}
