package VaccinationGame;

import java.util.Random;

public class Content {
	/**
	 * Options: Infection, Vaccine, ImmuneSystemBoost or Win
	 * */
	
	public static void contentGenerator(GameField gameField, Infection[] allInfections) {
		int infections = gameField.getAmountInfections();
		int immuSysBoost = gameField.getAmountImmuneSystemBooster();
		int width = gameField.getWidth();
		
		// Array to save all content possibilities for Infections([0][:]), Vaccines([1][:]) and Booster([2][:]) 
		Content[][] possibilities = new Content[3][infections];
		
		selectInfectionsVaccines(allInfections, infections, possibilities);
		setImmuneSystemBoosters(immuSysBoost, possibilities);
				
		Field[][] cloneGameField = new Field[width][width];
		setInGameField(infections, possibilities, width, cloneGameField);
		setEmptyFields(width, cloneGameField);
		gameField.setField(cloneGameField);
		
		for (int i=0; i<width; i++) {
			for (int j=0; j<width; j++) {
				(gameField.getField())[i][j].savingInfoNeighbors(gameField);
			}
		}
	}


	// Selecting and saving infections and their vaccines.
	public static void selectInfectionsVaccines(Infection[] allInfections, int infections, Content[][] possibilities) {
		int k=0;	// index possibilities array infections
		int l=0; 	// index possibilities array vaccines
		Random rd = new Random();

		for (int i=0; i<infections;i++) {
			int selectionIndex = rd.nextInt(allInfections.length -1);
			Infection selected = allInfections[selectionIndex];
			possibilities[0][k] = selected;
			if (selected.getVaccine()!=null) {
				possibilities[1][l] = selected.getVaccine();
				l++;
			}
			k++;
		}
	}
	
	// Constructing and saving ImmuneSystemBoosters
	public static void setImmuneSystemBoosters(int immuSysBoost, Content[][] possibilities) {
		for (int i=0; i<immuSysBoost; i++) {
			ImmuneSystemBoost im = new ImmuneSystemBoost();
			possibilities[2][i] = im;
		}
	}

	public static void setInGameField(int infections, Content[][] possibilities, int width, Field[][] field) {
		for (int i=0; i<3; i++) {
			for (int j=0; j<infections; j++) {
				// hier irgendwo problemen oder in setItem()
				setItem(width, field, possibilities[i][j]);
			}
		}
		Win win = new Win();
		setItem(width, field, win);
	}


	public static void setItem(int width, Field[][] field, Content content) {
		Random rd = new Random();
		boolean placed = false;
		while (placed == false) {
			int rdHor = rd.nextInt(width);
			int rdVert = rd.nextInt(width);
			// set content if field is empty
			if (field[rdHor][rdVert]==null) {
				field[rdHor][rdVert] = new Field(content);
				placed = true;
			}
		}
	}

	public static void setEmptyFields(int width, Field[][] cloneGameField) {
		for (int i=0; i<3; i++) {
			for (int j=0; j<width; j++) {
				if(cloneGameField[i][j]==null) {
					cloneGameField[i][j] = new Field();
				}
			}
		}
	}
}

