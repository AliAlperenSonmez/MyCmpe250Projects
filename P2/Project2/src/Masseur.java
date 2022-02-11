
public class Masseur implements Comparable<Masseur>{

	private final int ID;
	
	public Masseur(int ID) {
		this.ID = ID;
	}
	
	public int getID() {
		return ID;
	}

	@Override
	public int compareTo(Masseur o) {
		return this.ID-o.ID;
	}
}
