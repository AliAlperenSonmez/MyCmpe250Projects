
public class TrainingEnd extends Event{
	
	private TrainingCoach c;
	private double trainingDuration;
	
	public TrainingEnd(double time, Player p, TrainingCoach c, double trainingDuration) {
		super(time, p);
		this.c = c;
		this.trainingDuration = trainingDuration;
	}
	
	public TrainingCoach getTrainingCoach(){
		return c;
	}
	
	public double getTrainingDuration() {
		return trainingDuration;
	}
}
