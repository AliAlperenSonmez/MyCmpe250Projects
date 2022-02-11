import java.util.Comparator;

public class TherapyQueueComparator implements Comparator<EnterPhysiotherapy>{

	@Override
	public int compare(EnterPhysiotherapy o1, EnterPhysiotherapy o2) {
		if (Math.abs(o2.getPlayer().getLastTrainingAmount()-o1.getPlayer().getLastTrainingAmount())<0.0000000001) {
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
		
		else if (o1.getPlayer().getLastTrainingAmount()>o2.getPlayer().getLastTrainingAmount()) {
			return -1;
		}
		
		else {
			return 1;
		}
	}
}
