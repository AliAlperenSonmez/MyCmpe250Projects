/**
* The class of entering training events
* 
* @author Ali Alperen Sönmez
* 
*/

public class EnterTraining extends Event{
	
	private double duration;
	
	public EnterTraining(double time, Player p, double duration) {
		super(time, p);
		this.duration = duration;
	}
	
	public double getDuration() {
		return duration;
	}

}
