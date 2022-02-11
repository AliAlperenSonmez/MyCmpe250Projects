/**
* Compares massage events according to skills of players. If skills are equal, then it checks the arrival times. 
* If they are also equal it chompares ID's.
* 
* @author Ali Alperen Sönmez
* 
*/

import java.util.Comparator;

public class MassageQueueComparator implements Comparator<EnterMassage>{

	@Override
	public int compare(EnterMassage o1, EnterMassage o2) {
	if (o1.getPlayer().getSkill()==o2.getPlayer().getSkill()) {
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
	return o2.getPlayer().getSkill()-o1.getPlayer().getSkill();
	}
}
