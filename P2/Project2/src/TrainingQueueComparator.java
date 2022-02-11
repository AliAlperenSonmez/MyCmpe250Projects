import java.util.Comparator;

public class TrainingQueueComparator implements Comparator<EnterTraining>{

	@Override
	public int compare(EnterTraining o1, EnterTraining o2) {
		if (Math.abs(o1.getTime()-o2.getTime())<0.0000000001) {
			return o1.getPlayer().getID()-o2.getPlayer().getID();
		}
		
		else if (o1.getTime()<o2.getTime()) {
			return -1;
		}
		
		else {
			return 1;
		}
		
		
	}
}
