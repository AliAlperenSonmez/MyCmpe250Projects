
public class Physiotherapist implements Comparable<Physiotherapist>{

	private final int ID;
	private final double servingTime;
	
	public Physiotherapist(double servingTime, int ID) {
		this.servingTime = servingTime;
		this.ID = ID;
	}
	
	public double getServingTime() {
		return servingTime;
	}
	
	public int getID() {
		return ID;
	}

	@Override
	public int compareTo(Physiotherapist o) {
		return this.ID-o.ID;
	}
}
