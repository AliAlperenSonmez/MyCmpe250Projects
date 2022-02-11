/**
* Compares events according to their time, if times are the same then it checks player ID's.
* 
* @author Ali Alperen Sönmez
* 
*/

import java.util.Comparator;

public class EventComparator implements Comparator<Event>{

	@Override
	public int compare(Event o1, Event o2) {
//		if (o1.getTime()>o2.getTime()) {
//			return 1;
//		}
//		
//		else if (o1.getTime()<o2.getTime()) {
//			return -1;
//		}
//		return 0;
		
		
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
