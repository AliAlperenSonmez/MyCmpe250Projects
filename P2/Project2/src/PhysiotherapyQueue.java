/**
* Physiotherapy queue class. It keeps maxlength of the queue and the queue itself.
* 
* @author Ali Alperen Sönmez
* 
*/

import java.util.PriorityQueue;

public class PhysiotherapyQueue{
	private int maxLength = 0; 
	PriorityQueue<EnterPhysiotherapy> pq = new PriorityQueue<EnterPhysiotherapy>(new TherapyQueueComparator());

	public void updateMax() {
		if (pq.size()>maxLength) {
			maxLength = pq.size();
		}
	}
	public int getMaxLength() {
		return maxLength;
	}
}
