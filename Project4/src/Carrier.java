

public abstract class Carrier extends Vertice{
	
	private int ID;
	private int capacity;
	private char type;
	
	public Carrier(int ID,int capacity, char type) {
		super(ID,2);
		this.capacity = capacity;
		this.type = type;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public char getType() {
		return type;
	}
	
	public void useCapacity(int amount) {
		capacity -= amount;
	}
	
	public int getID() {
		return ID;
	}
	
}
