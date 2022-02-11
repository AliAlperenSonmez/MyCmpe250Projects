import java.util.*;

public class Dfs {
	

	public boolean search(Vertice source, Vertice sink) {
		
		
		ArrayList<Vertice> vertices = new ArrayList<Vertice>();
		boolean found = false;
		PriorityQueue<Vertice> path = new PriorityQueue<Vertice>();
		path.add(source);
		
		while (!path.isEmpty()) {
			
			Vertice v = path.poll();
			v.visited = true;
			
			
			for (Map.Entry<Vertice,Integer> m: v.getNeighbours().entrySet()) {
				
				if (m.getValue()==0) {
					continue;
				}
				
				Vertice peek = m.getKey();
				
				
				if (peek.getID()==-1) {
					found = true;
					peek.parent=v;
					peek.visited=true;
					vertices.add(peek);
					break;
				}
				
				if (!peek.visited) {
					path.add(peek);
					peek.parent=v;
					peek.visited = true;
					vertices.add(peek);
				}
				
			}
			
			if (found) {
				break;
			}
		}
		
		for (Vertice v: vertices) {
			v.visited = false;
		}
		
		if (found) {
			return true;
		}
		
		return false;
	}
}
