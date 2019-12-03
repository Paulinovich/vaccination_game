package VaccinationGame;
	
import java.util.HashMap;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
		// initialize all default Contents and save in hash table 
		HashMap<Infection, Vaccine> infectionsVaccines = setupInfectionsVaccins();
				
		// ask for size Game Field and generate Game Field
		GameField gameField = setupGameField();
		
		
	
		
	}
	
	public static HashMap<Infection, Vaccine> setupInfectionsVaccins() {
		HashMap<Infection, Vaccine> infectionsVaccines = new HashMap<Infection, Vaccine>();
				
		Infection ebola = new Infection("Ebola", 57);
		infectionsVaccines.put(ebola, null);
		Vaccine fluV = new Vaccine("Flu");		
		Infection flu = new Infection("Flu", 16, fluV);
		infectionsVaccines.put(flu, fluV);
		Vaccine rabiesV = new Vaccine("Rabies");		
		Infection rabies = new Infection("Rabies", 100, rabiesV);
		infectionsVaccines.put(rabies, rabiesV);
		Vaccine meningococcusV = new Vaccine("Meningococcus");		
		Infection meningococcus = new Infection("Meningococcus", 15, meningococcusV);
		infectionsVaccines.put(meningococcus, meningococcusV);
		Vaccine pneumoV = new Vaccine("Pneumococcal Pneumonia");		
		Infection pneumo = new Infection("Pneumococcal Pneumonia", 6, pneumoV);
		infectionsVaccines.put(pneumo, pneumoV);
		Vaccine polioV = new Vaccine("Polio");		
		Infection polio = new Infection("Polio", 15, polioV);
		infectionsVaccines.put(polio, polioV);
		Vaccine tetanusV = new Vaccine("Tetanus");		
		Infection tetanus = new Infection("Tetanus", 27, tetanusV);
		infectionsVaccines.put(tetanus, tetanusV);
		Vaccine choleraV = new Vaccine("Cholera");		
		Infection cholera = new Infection("Cholera", 1, choleraV);
		infectionsVaccines.put(cholera, choleraV);
		Vaccine hepatitisBV = new Vaccine("Hepatitis B");		
		Infection hepatitisB = new Infection("Hepatitis B", 0, hepatitisBV);
		infectionsVaccines.put(hepatitisB, hepatitisBV);
		Vaccine measelsV = new Vaccine("Measels");		
		Infection measels = new Infection("Measels", 4, measelsV);
		infectionsVaccines.put(measels, measelsV);
		Vaccine tuberculosisV = new Vaccine("Tuberculosis");		
		Infection tuberculosis = new Infection("Tuberculosis", 2, tuberculosisV);
		infectionsVaccines.put(tuberculosis, tuberculosisV);
		Vaccine typhoidFeverV = new Vaccine("Typhoid fever");		
		Infection typhoidFever = new Infection("Typhoid fever", 1, typhoidFeverV);
		infectionsVaccines.put(typhoidFever, typhoidFeverV);
		
		return infectionsVaccines;
	}
	
	// TODO: replace keyboard input with buttons when user interface is made 
	public static GameField setupGameField() {
		GameField gameField;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("Choose a field size; \n\n"
					+ "1:\t Small\n"
					+ "2:\t Medium\n"
					+ "3:\t Large\n"
					+ "4:\t Extra large\n\n"
					+ "Enter the number of your choise and press 'Enter': \t");
			String input = scan.next();
			
			// can this be done with less repetition? 
			switch(input) {
			case "1":
				gameField = new GameField(4);
				scan.close();
				return gameField;
			case "2":
				gameField = new GameField(6);
				scan.close();
				return gameField;
			case "3":
				gameField = new GameField(8);
				scan.close();
				return gameField;
			case "4":
				gameField = new GameField(10);
				scan.close();
				return gameField;
			default:
				System.out.println("\ninvalid choice\n");
			}
		}
	}
}
