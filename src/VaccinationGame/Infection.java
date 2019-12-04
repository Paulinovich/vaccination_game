package VaccinationGame;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Infection extends Content{

	private String name;
	private Vaccine vaccine;
	private int mortalityRate;
	
	// getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Vaccine getVaccine() {
		return vaccine;
	}
	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}
	public int getMortalityRate() {
		return mortalityRate;
	}
	public void setMortalityRate(int mortalityRate) {
		this.mortalityRate = mortalityRate;
	}
	
	// constructors
	public Infection(String name, int mortalityRate) {
		this.name = name;
		this.mortalityRate = mortalityRate;
	}
	public Infection(String name, int mortalityRate, Vaccine vaccine) {
		this.name = name;
		this.mortalityRate = mortalityRate;
		this.vaccine = vaccine;
	}
	
	//decide to die or to drop immune system
		public void costInfection(GameEvent game){	
			List<Vaccine> listVaccinesCopy = Health.getVaccines();		
				if (!Arrays.asList(listVaccinesCopy).contains(this.vaccine)) {
					Random rd = new Random();
					int chance = rd.nextInt(100);
					if (chance > this.mortalityRate) {
						immuneSystemDropping(game);
					}else {
						dying(game);
					}
					
				}else {
					System.out.println("saved by your vaccine!");
			}
		} 
		
		public void dying(GameEvent game) {
			System.out.println("You died :(");
			game.setPlaying(false);
		}
		
		public void immuneSystemDropping(GameEvent game) {
			int imSy = Health.getImmuneSystem();
			if (imSy > 1) {
				Health.setImmuneSystem(imSy - 1);
			}
			else {
				dying(game);
			}
		}
	
}
