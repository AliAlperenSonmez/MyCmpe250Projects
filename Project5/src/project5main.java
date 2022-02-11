import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class project5main {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Taking input
		Locale.setDefault(new Locale("en", "US"));
		Scanner in = new Scanner(new File(args[0]));
		PrintStream out = new PrintStream(new File(args[1]));
		
		
		String types = in.nextLine().replaceAll("\\s","");
		
		int nofProducts = types.length();
		
		int[] machineA = new int[nofProducts];
		int[] machineB = new int[nofProducts];
		int[] profits = new int[nofProducts];
		int[] arrivalTimes = new int[nofProducts];
		int[] maxProfits = new int[nofProducts];
		ArrayList<Product> products = new ArrayList<Product>();
		
		for (int i=0; i<nofProducts; i++) {
			machineA[i] = in.nextInt();
		}
		
		for (int i=0; i<nofProducts; i++) {
			machineB[i] = in.nextInt();
		}
		
		for (int i=0; i<nofProducts; i++) {
			profits[i] = in.nextInt();
		}
		
		for (int i=0; i<nofProducts; i++) {
			arrivalTimes[i] = in.nextInt();
		}
		
		for (int i=0; i<nofProducts; i++) {
			if (types.charAt(i)=='s') {
				products.add(new Product(arrivalTimes[i],arrivalTimes[i]+machineA[i],profits[i]));
			}
			
			else if (types.charAt(i)=='l') {
				products.add(new Product(arrivalTimes[i],arrivalTimes[i]+machineB[i],profits[i]));
			}
		}
		
		Collections.sort(products);
		
		int maxP;
		int currentP = 0;
		for (int i=1; i<nofProducts;i++) {
			
			maxP=products.get(i-1).getMaxProfit();
			Product current = products.get(i);
			currentP = current.getProfit();
			

			
			for (int j=i-1; j>=0; j--) {
				if (products.get(j).getEnd()<=current.getStart()) {
					currentP+=products.get(j).getMaxProfit();
					break;
				}
			}
			
			if (currentP>maxP) {
				current.setMaxProfit(currentP);
			}
			else {
				current.setMaxProfit(maxP);
			}
		}
		
		out.println(currentP);
	}
}
