
public class Player {
	
	// checks if the player is in a queue or an event
	private boolean busy = false;
	
	// keeps the queue entrence time to calculate total time passed in that queue
	private double queueEntrenceTime;
	
	// checks if the player entered the queue before entering the event
	private boolean enteredQueue = false;
	
	private double totalTrainingTime;
	private double totalTherapyTime;
	private double totalMassageTime;
	
	// total waiting times in queues:
	private double totalWaitingTrainingQueue;
	private double totalWaitingTherapyQueue;
	private double totalWaitingMassageQueue;
	
	// number of events for each event:
	private int totalNofTraining;
	private int totalNofTherapy;
	private int totalNofMassage;
	
	// keeps last training amount for sorting the physiotherapy queue
	private double lastTrainingAmount;
	
	private int ID;
	private int skill;
	
	// remaining massage rights of the player
	private int remainingMas = 3;
	
	public Player(int ID, int skill) {
		this.ID = ID;
		this.skill = skill;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getSkill() {
		return skill;
	}
	
	public int getRemainingMas() {
		return remainingMas;
	}
	
	public void useMas() {
		remainingMas-=1;
	}
	
	public void setBusy(boolean busy) {
		this.busy = busy;
	}
	
	public boolean getBusy() {
		return busy;
	}
	
	public double getLastTrainingAmount() {
		return lastTrainingAmount;
	}
	
	public void setLastTrainingAmount(double lastTrainingAmount) {
		this.lastTrainingAmount = lastTrainingAmount;
	}
	
	public double getTotalMassageTime() {
		return totalMassageTime;
	}
	
	public int getTotalNofMassage() {
		return totalNofMassage;
	}
	
	public int getTotalNofTherapy() {
		return totalNofTherapy;
	}
	
	public int getTotalNofTraining() {
		return totalNofTraining;
	}
	
	public double getTotalTherapyTime() {
		return totalTherapyTime;
	}
	
	public double getTotalTrainingTime() {
		return totalTrainingTime;
	}
	
	public double getTotalWaitingMassageQueue() {
		return totalWaitingMassageQueue;
	}
	
	public double getTotalWaitingTherapyQueue() {
		return totalWaitingTherapyQueue;
	}
	
	public double getTotalWaitingTrainingQueue() {
		return totalWaitingTrainingQueue;
	}
	
	public void increasetotalTrainingTime(double d) {
		totalTrainingTime+=d;
	}
	
	public void increasetotalTherapyTime(double d) {
		totalTherapyTime+=d;
	}
	
	public void increasetotalMassageTime(double d) {
		totalMassageTime+=d;
	}
	
	public void increasetotalWaitTraining(double d) {
		totalWaitingTrainingQueue+=d;
	}
	
	public void increasetotalWaitTherapy(double d) {
		totalWaitingTherapyQueue+=d;
	}
	
	public void increasetotalWaitMassage(double d) {
		totalWaitingMassageQueue+=d;
	}
	
	public void increaseNofTraining() {
		totalNofTraining+=1;
	}
	
	public void increaseNofTherapy() {
		totalNofTherapy+=1;
	}
	
	public void increaseNofMassage() {
		totalNofMassage+=1;
	}
	
	public double getQueueEntrenceTime() {
		return queueEntrenceTime;
	}
	
	public void setQueueEntrenceTime(double queueEntrenceTime) {
		this.queueEntrenceTime = queueEntrenceTime;
	}
	
	public boolean getEnteredQueue() {
		return this.enteredQueue;
	}
	
	public void setEnteredQueue(boolean enteredQueue) {
		this.enteredQueue = enteredQueue;
	}
}
