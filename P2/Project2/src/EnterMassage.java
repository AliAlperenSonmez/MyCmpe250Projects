/**
* The class of entering massage events
* 
* @author Ali Alperen Sönmez
* 
*/

public class EnterMassage extends Event{
	
	private double duration;
	public EnterMassage(double time, Player p, double duration) {
		super(time, p);
		this.duration = duration;
		// TODO Auto-generated constructor stub
	}
	public double getDuration() {
		return duration;
	}
	
}
