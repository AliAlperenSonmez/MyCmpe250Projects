/**
* Abstract class of events.
* 
* @author Ali Alperen Sönmez
* 
*/

public abstract class Event {
	
	private double time;
	private Player p;
	
	public Event(double time, Player p) {
		this.time = time;
		this.p = p;
	}
	
	public Player getPlayer() {
		return this.p;
	}
	
	public double getTime() {
		return this.time;
	}
}
