package VaccinationGame;

public class Field {

	private boolean visited;
	private Content content;
	private String[] neighbors;
	
	// getters and setters 
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public Content getContent() {
		return content;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	public String[] getNeighbors() {
		return neighbors;
	}
	public void setNeighbors(String[] neighbors) {
		this.neighbors = neighbors;
	}
	
	// Constructors
	
	public Field() {
		this.visited = false;
		this.content = null;
	}
	
	public Field(Content content) {
		this.visited = false;
		this.content = content;
	}
	
	
	public void savingInfoNeighbors(GameField gameField) {
		Field[][] field = gameField.getField();
		int size = field.length;
				
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				// nothing on the left
				if (i==0) {
					// and nothing up
					if (j==0) {
						int[][] where = {{i+1, j}, null, {i, j+1}, null};
						gameField.getField()[i][j].setNeighbors(look(field, where));
					}
					// and nothing down
					else if (j==size-1) {
						int[][] where = {{i+1, j}, null , null, {i, j-1}};
						gameField.getField()[i][j].setNeighbors(look(field, where));
					}
					else {
						int[][] where = {{i+1, j}, null, {i, j+1}, {i, j-1}};
						gameField.getField()[i][j].setNeighbors(look(field, where));
					}
				}
				// nothing on the right
				else if (i == size-1) {
					// and nothing up
					if (j==0) {
						int[][] where = {null, {i-1, j}, {i, j+1}, null};
						gameField.getField()[i][j].setNeighbors(look(field, where));
					}
					// and nothing down
					else if (j == size-1) {
						int[][] where = {null, {i-1, j}, null, {i, j-1}};
						gameField.getField()[i][j].setNeighbors(look(field, where));
					}
					else {
						int[][] where = {null, {i-1, j}, {i, j+1}, {i, j-1}};
						gameField.getField()[i][j].setNeighbors(look(field, where));
					} 
				}
				else {
					// nothing up
					if (j==0) {
						int[][] where = {{i+1, j}, {i-1, j}, {i, j+1}, null};
						// Sometimes nullPointerError here
						gameField.getField()[i][j].setNeighbors(look(field, where)); 
					}
					// nothing down
					else if (j == size-1) {
						int[][] where = {{i+1, j}, {i-1, j}, null, {i, j-1}};
						// Sometimes nullPointerError here
						gameField.getField()[i][j].setNeighbors(look(field, where));
					}
					else {
						// look everywhere
						int[][] where = {{i+1, j}, {i-1, j}, {i, j+1}, {i, j-1}};
						// Sometimes nullPointerError here
						gameField.getField()[i][j].setNeighbors(look(field, where)); 
					}
				}
			}
		}
	}
	
	// TODO debug nullpointer error
	public String[] look(Field[][] field, int[][] where) {
		String[] neighbors = new String[2];
		int infections = 0;
		int preventions = 0;
		for (int i=0; i<4; i++) {
			if (where[i] != null){
				int indexHor = where[i][0];
				int indexVert = where[i][1];
				Content content = field[indexHor][indexVert].getContent();
				if (content instanceof Infection){
					infections ++;
				}
				else if (content instanceof Vaccine) {
					preventions ++;
				}
				else if (content instanceof ImmuneSystemBoost) {
					preventions ++;
				}
			}
		}
		neighbors[0] = "Infections: " + infections;
		neighbors[1] = "Preventions: "+ preventions;
		return neighbors;
	}
	
}
