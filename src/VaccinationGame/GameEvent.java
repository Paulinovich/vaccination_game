package VaccinationGame;

public class GameEvent {
	boolean playing;
	
	// getters and setters
	public boolean isPlaying() {
		return playing;
	}
	public void setPlaying(boolean playing) {
		this.playing = playing;
	}
	
	public GameEvent() {
		this.playing = true; 
	}
}
