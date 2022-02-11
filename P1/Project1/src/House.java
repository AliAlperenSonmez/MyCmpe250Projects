

/**
* House is the class of houses. Implements the Comparable interface.
* 
* @author Ali Alperen Sönmez
* 
*/

public class House implements Comparable<House>{
	
	private int ID;
	
	private int duration;
	
	private double rating;
	
	public House(int ID,int duration, double rating) {
		this.ID = ID;
		this.duration = duration;
		this.rating = rating;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public double getRating() {
		return rating;
	}

	
	/**
	 * <p>Overriding the compareTo method of comparable interface
	 * @param House o Other house
	 */
	@Override
	public int compareTo(House o) {
		return this.ID-o.ID;
	}
	
	/**
	 * <p>For increasing the duration of the house if a student settles.
	 * @param Int d duration
	 */
	public void increaseDuration(int d) {
		this.duration+=d;
	}
	
	/**
	 * <p>For decreasing the duration of the house after a semester.
	 */
	public void decreaseDuration() {
		this.duration-=1;
	}
}
