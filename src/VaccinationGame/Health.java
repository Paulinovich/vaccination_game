package VaccinationGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Health {
	private static int immuneSystem;
	private static List<Vaccine> vaccines;
	
	// getters and setters
	public static int getImmuneSystem() {
		return immuneSystem;
	}
	public static void setImmuneSystem(int imSy) {
		immuneSystem = imSy;
	}
	public static List<Vaccine> getVaccines() {
		return vaccines;
	}
	public void setVaccines(List<Vaccine> vaccines) {
		this.vaccines = vaccines;
	}
	
	// Constructor
	public Health() {
		this.immuneSystem=3;
		this.vaccines = new ArrayList<>();
	}
	
	
	
	public void appendVaccines(List<Vaccine> vaccines, Vaccine vaccineName) {
		if (!Arrays.asList(vaccines).contains(vaccineName)) {
			vaccines.add(vaccineName);
		}
	}
}
