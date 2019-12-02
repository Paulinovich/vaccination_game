package VaccinationGame;
	
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
		
		// initialize all default Contents 
		setupInfectionsVaccins();
		
		// ask for size Game Field and generate Game Field
		
	}
	
	public static void setupInfectionsVaccins() {
		Infection Ebola = new Infection("Ebola", 57);
		Vaccine FluV = new Vaccine("Flu");		
		Infection Flu = new Infection("Flu", 16, FluV);
		Vaccine RabiesV = new Vaccine("Rabies");		
		Infection Rabies = new Infection("Rabies", 100);
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
		
		Vaccine[] arrayVaccine = new Vaccine[] {
				FluV, RabiesV, meningococcusV, pneumoV, polioV, tetanusV, choleraV, hepatitisBV, measelsV, tuberculosisV, typhoidFeverV
		};
		
		Infection[] arrayInfection = new Infection[] {
				Ebola, Flu, Rabies, meningococcus, pneumo, polio, tetanus, cholera, hepatitisB, measels, tuberculosis, typhoidFever
		};
		
	}
}
