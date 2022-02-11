import java.util.PriorityQueue;

public class TrainingQueue{
	private int maxLength = 0; 
	PriorityQueue<EnterTraining> tq = new PriorityQueue<EnterTraining>(new TrainingQueueComparator());

	public void updateMax() {
		if (tq.size()>maxLength) {
			maxLength = tq.size();
		}
	}
	public int getMaxLength() {
		return maxLength;
	}
}
