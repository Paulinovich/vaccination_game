package VaccinationGame;
	
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
		Infection[] allInfections = setupInfectionsVaccins();
		System.out.println("array of Infections passed of length "+ allInfections.length +"\nlast member is called "+ allInfections[allInfections.length-1].getName());		
		// ask for size Game Field and generate Game Field
		GameField gameField = setupGameField();
		
		// set contents on random fields on
		Content.contentGenerator(gameField, allInfections);
	
		
	}
	 
	public static Infection[] setupInfectionsVaccins() {
		Infection ebola = new Infection("Ebola", 57);
		Vaccine fluV = new Vaccine("Flu");		
		Infection flu = new Infection("Flu", 16, fluV);
		Vaccine rabiesV = new Vaccine("Rabies");		
		Infection rabies = new Infection("Rabies", 100, rabiesV);
		Vaccine meningococcusV = new Vaccine("Meningococcus");		
		Infection meningococcus = new Infection("Meningococcus", 15, meningococcusV);
		Vaccine pneumoV = new Vaccine("Pneumococcal Pneumonia");		
		Infection pneumo = new Infection("Pneumococcal Pneumonia", 6, pneumoV);
		Vaccine polioV = new Vaccine("Polio");		
		Infection polio = new Infection("Polio", 15, polioV);
		Vaccine tetanusV = new Vaccine("Tetanus");		
		Infection tetanus = new Infection("Tetanus", 27, tetanusV);
		Vaccine choleraV = new Vaccine("Cholera");		
		Infection cholera = new Infection("Cholera", 1, choleraV);
		Vaccine hepatitisBV = new Vaccine("Hepatitis B");		
		Infection hepatitisB = new Infection("Hepatitis B", 0, hepatitisBV);
		Vaccine measelsV = new Vaccine("Measels");		
		Infection measels = new Infection("Measels", 4, measelsV);
		Vaccine tuberculosisV = new Vaccine("Tuberculosis");		
		Infection tuberculosis = new Infection("Tuberculosis", 2, tuberculosisV);
		Vaccine typhoidFeverV = new Vaccine("Typhoid fever");		
		Infection typhoidFever = new Infection("Typhoid fever", 1, typhoidFeverV);
		
		Infection[] allInfections = new Infection[] {
			ebola, flu, rabies, meningococcus, pneumo, polio, tetanus, cholera, hepatitisB, measels, tuberculosis, typhoidFever
		};
		System.out.println("Vaccines and Infections default objects created");
		return allInfections;
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
					+ "Enter the number of your choice and press 'Enter': \t");
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
