package VaccinationGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		System.out.println("empty array is made");
		
		selectInfectionsVaccines(allInfections, infections, possibilities);
		System.out.println("infections are selected and inserted");
		setImmuneSystemBoosters(immuSysBoost, possibilities);
		System.out.println("immuneboosters are set");
				
		Field[][] cloneGameField = new Field[width][width];
		System.out.println("field is cloned");
		// TODO fix bugs in setGameField()
		cloneGameField = setInGameField(infections, possibilities, width, cloneGameField);
		System.out.println("content is set in field");
		setEmptyFields(width, cloneGameField);
		gameField.setField(cloneGameField);
		
		for (int i=0; i<width; i++) {
			for (int j=0; j<width; j++) {
				(gameField.getField())[i][j].savingInfoNeighbors(gameField);
			}
		}
		System.out.println("Content set in Field");
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
			System.out.println(possibilities[0][k]);
			if (selected.getVaccine()!=null) {
				possibilities[1][l] = selected.getVaccine();
				System.out.println(possibilities[1][l]);
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
			System.out.println(possibilities[2][i]);
		}
	}
	// TODO: fix bugs! remember you changed the outputs from void of all (sub)function(s)
	public static Field[][] setInGameField(int infections, Content[][] possibilities, int width, Field[][] field) {
		System.out.println(field);
		for (int i=0; i<3; i++) {
			for (int j=0; j<infections; j++) {
				// hier irgendwo problemen oder in setItem()
				field = setItem(width, field, possibilities[i][j]);
			}
		}
		System.out.println("Field updated" + field);
		Win win = new Win();
		field = setItem(width, field, win);
		System.out.println("field saved with Win "+field);
		return field;
	}


	public static Field[][] setItem(int width, Field[][] field, Content content) {
		Random rd = new Random();
		boolean placed = false;
		while (placed == false) {
			int rdHor = rd.nextInt(width-1);
			int rdVert = rd.nextInt(width-1);
			// set content if field is empty
			if (field[rdHor][rdVert]==null) {
				field[rdHor][rdVert] = new Field(content);
				placed = true;
			System.out.println("object is placed");
			}
		}
		System.out.println(field);
		return field;
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

