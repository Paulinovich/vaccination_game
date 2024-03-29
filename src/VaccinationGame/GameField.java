package VaccinationGame;

public class GameField {
	
    private int width;
    private Field[][] field; 
    private int amountInfections;       
    private int amountImmuneSystemBooster;

    // getters and setters
    public int getWidth(){
        return width;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public Field[][] getField(){
        return field;
    }
    public void setField(Field[][] field){
        this.field = field;
    }
    public int getAmountInfections(){
        return amountInfections;
    }
    public void setAmountInfections(int amountInfections){
        this.amountInfections = amountInfections;
    }
    public int getAmountImmuneSystemBooster(){
        return amountImmuneSystemBooster;
    }
    public void setAmountImmuneSystemBooster(int amountImmuneSystemBooster){
        this.amountImmuneSystemBooster = amountImmuneSystemBooster;
    }

    // Constructor
    public GameField(int width){
        this.width = width;
        this.field= new Field[width][width];
        setAmounts(width);
        System.out.println("Gamefield is made with width "+ this.width);
    }
    
    public void setAmounts(int width){
        int size = (int) Math.pow(width, 2);
        setAmountInfections((int) Math.round(size*0.2));	// 20% of field, vaccins automatically as well
        setAmountImmuneSystemBooster((int) Math.round(size*0.1));	// 10%
    }
}
