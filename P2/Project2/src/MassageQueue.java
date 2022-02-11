/**
* Massage queue class. It keeps maxlength of the queue and the queue itself.
* 
* @author Ali Alperen Sönmez
* 
*/

import java.util.PriorityQueue;

public class MassageQueue{
	
	private int maxLength = 0; 
	
	PriorityQueue<EnterMassage> mq = new PriorityQueue<EnterMassage>(new MassageQueueComparator());
	
	public void updateMax() {
		if (mq.size()>maxLength) {
			maxLength = mq.size();
		}
	}
	public int getMaxLength() {
		return maxLength;
	}
}
