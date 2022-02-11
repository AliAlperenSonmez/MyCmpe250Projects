
public class TrainingCoach implements Comparable<TrainingCoach>{

	private final int ID;
	
	public TrainingCoach(int ID) {
		this.ID = ID;
	}

	public int getID() {
		return ID;
	}

	@Override
	public int compareTo(TrainingCoach o) {
		return this.ID-o.ID;
	}
}
