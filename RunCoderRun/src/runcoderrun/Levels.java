package runcoderrun;
import java.util.ArrayList;

public class Levels {
	private ArrayList<Level>levels;
	
	public Levels(){
		levels = new ArrayList<Level>(4);
	}

	
	
	public ArrayList<Level> getLevels() {
		return levels;
	}



	public void setLevels(ArrayList<Level> levels) {
		this.levels = levels;
	}



	public void addLevel(Level level){
		levels.add(level);
	}
}
