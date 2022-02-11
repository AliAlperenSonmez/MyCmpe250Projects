import java.util.*;

public class Bag extends Vertice{
	
	private int ID;
	private int amount;
	private String type;
	
	private ArrayList<Carrier> edges = new ArrayList<Carrier>();
	
	public Bag(int ID,String type, int amount) {
		super(ID,1);
		this.type = type;
		this.amount = amount;
	}
	
	public ArrayList<Carrier> getEdges() {
		return edges;
	}
	
	public int getAmount() {
		return amount;
	}
		
	public String getType() {
		return type;
	}
	
	public int getID() {
		return ID;
	}
	
}
