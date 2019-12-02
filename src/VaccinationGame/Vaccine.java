package VaccinationGame;

public class Vaccine extends Content{
	private String name;

	// getter and setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// constructor
	public Vaccine(String name) {
		this.name = name;
	}
	
}
