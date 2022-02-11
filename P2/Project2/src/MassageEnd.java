/**
* The class of end of massage events.
* 
* @author Ali Alperen Sönmez
* 
*/

public class MassageEnd extends Event{
	
	Masseur ms;
	private double massageDuration;
	
	public MassageEnd(double time, Player p, Masseur ms, double massageDuration) {
		super(time,p);
		this.ms = ms;
		this.massageDuration = massageDuration;
	}
	
	public Masseur getMasseur(){
		return ms;
	}
	
	public double getMassageDuration() {
		return massageDuration;
	}
	
}
