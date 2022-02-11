
public class TherapyEnd extends Event{
	
	private Physiotherapist pt;
	private double therapyDuration;
	
	public TherapyEnd(double time, Player p, Physiotherapist pt, double therapyDuration) {
		super(time, p);
		this.pt = pt;
		this.therapyDuration = therapyDuration;
	}
	
	public Physiotherapist getPhysiotherapist(){
		return pt;
	}
	
	public double getTherapyDuration() {
		return therapyDuration;
	}
	
}
