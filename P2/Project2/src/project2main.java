import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

/**
 * Main Class
 * 
 * 
 * @author Ali Alperen Sonmez
 * 
 */

public class project2main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Locale.setDefault(new Locale("en", "US"));
		Scanner in = new Scanner(new File(args[0]));
		PrintStream out = new PrintStream(new File(args[1]));
		
		
		/**
		 * Current time in the program
		 */
		double globalTime = 0;
		
		/**
		 * Time of the event that is being processed
		 */
		double eventTime;
		
		/**
		 * Sum of all training durations
		 */
		double totalTrainingTime = 0;
		
		/**
		 * Sum of all physiotherapy durations
		 */
		double totalPtherapyTime = 0;
		
		/**
		 * Sum of all massage durations
		 */
		double totalMassageTime = 0;
		
		/**
		 * Sum of waiting times in training queue
		 */
		double totalWaitingTq = 0;
		
		/**
		 * Sum of waiting times in physiotherapy queue
		 */
		double totalWaitingPq = 0;
		
		/**
		 * Sum of waiting times in massage queue
		 */
		double totalWaitingMq = 0;
		
		/**
		 * Number of training events
		 */
		double nofTrainings = 0;
		
		/**
		 * Number of physiotherapy events
		 */
		double nofPtherapies = 0;
		
		/**
		 * Number of massage events
		 */
		double nofMassages = 0;
		
		/**
		 * Average waiting time in training queue
		 */
		double averageWaitingTimeTQ;
		
		/**
		 * Average waiting time in physiotherapy queue
		 */
		double averageWaitingTimePQ;
		
		/**
		 * Average waiting time in massage queue
		 */
		double averageWaitingTimeMQ;
		
		/**
		 * Average training time
		 */
		double averageTrainingTime = 0;
		
		/**
		 * Average physiotherapy time
		 */
		double averageTherapyTime = 0;
		
		/**
		 * Average massage time
		 */
		double averageMassageTime = 0;
		
		/**
		 * Number of invalid attempts
		 */
		int invalids = 0;
		
		/**
		 * Number of canceled attempts
		 */
		int canceled = 0;
		
		/**
		 * Training queue
		 */
		TrainingQueue trainingQueue = new TrainingQueue();
		
		/**
		 * Physiotherapy queue
		 */
		PhysiotherapyQueue physiotherapyQueue = new PhysiotherapyQueue();
		
		/**
		 * Massage queue
		 */
		MassageQueue massageQueue = new MassageQueue();
		
		/**
		 * Events queue. It keeps all events in the program sorted by their time.
		 */
		PriorityQueue<Event> events = new PriorityQueue<Event>(new EventComparator());
		
		/**
		 * Queue of training coaches sorted by their ID.
		 */
		PriorityQueue<TrainingCoach> tcoaches = new PriorityQueue<TrainingCoach>();
		
		/**
		 * Queue of physiotherapists sorted by their ID.
		 */
		PriorityQueue<Physiotherapist> ptherapists = new PriorityQueue<Physiotherapist>();
		
		/**
		 * Queue of masseurs sorted by their ID.
		 */
		PriorityQueue<Masseur> masseurs = new PriorityQueue<Masseur>();
		

		
		//Reading the input
		int nofPlayers = in.nextInt();
		
		Player[] players = new Player[nofPlayers];
		
		for (int i = 0; i<nofPlayers; i++) {
			int ID = in.nextInt();
			int skill = in.nextInt();
			players[i] = new Player(ID,skill);
		}
		
		int nofEvents = in.nextInt();
		
		for (int i = 0; i<nofEvents; i++) {
			String action = in.next();
			if (action.equals("t")) {
				int pID = in.nextInt();
				double enterTime = in.nextDouble();
				double duration = in.nextDouble();
				EnterTraining t = new EnterTraining(enterTime,players[pID],duration);
				events.add(t);
			}
			
			else if (action.equals("m")) {
				int pID = in.nextInt();
				double enterTime = in.nextDouble();
				double duration = in.nextDouble();
				EnterMassage m = new EnterMassage(enterTime,players[pID],duration);
				events.add(m);
			}
		}
		
		int nofPterapists = in.nextInt();
		for(int i = 0; i<nofPterapists; i++) {
			double servingTime = in.nextDouble();
			ptherapists.add(new Physiotherapist(servingTime, i));
		}
		
		int nofTcoaches = in.nextInt();
		for(int i = 0; i<nofTcoaches; i++) {
			tcoaches.add(new TrainingCoach(i));
		}
		
		int nofMasseurs = in.nextInt();
		for (int i = 0; i<nofMasseurs; i++) {
			masseurs.add(new Masseur(i));
		}
		
		
		
		//Main algorithm. It basically polls an event from events queue which is sorted by time, and processes the event.
		while (events.isEmpty()==false) {
			
			Event e = events.poll();
			
			eventTime = e.getTime();
			
			globalTime = eventTime;
			
			
			if (e instanceof EnterTraining) {
				
				EnterTraining t = (EnterTraining) e;
				
				Player player = t.getPlayer();
				
				if (player.getBusy()==false) {
					
					player.setBusy(true);
					
					if(tcoaches.isEmpty()==false) {
						
						TrainingCoach c = tcoaches.poll();
						
						events.add(new TrainingEnd(globalTime+t.getDuration(), player, c, t.getDuration()));
						
						player.setEnteredQueue(false);
						
					}
					
					else {
						
						trainingQueue.tq.add(t);
						
						player.setEnteredQueue(true);
						
						player.setQueueEntrenceTime(globalTime);
						
						trainingQueue.updateMax();
						
					}
				}
				
				else {canceled++;continue;}
				
			}
			
			else if (e instanceof EnterPhysiotherapy) {
				
				EnterPhysiotherapy p = (EnterPhysiotherapy) e;
				
				Player player = p.getPlayer();
				
				if (player.getBusy()==false) {
					
					player.setBusy(true);
					
					if (ptherapists.isEmpty()==false) {
						
						Physiotherapist pt = ptherapists.poll();
						
						events.add(new TherapyEnd(globalTime+pt.getServingTime(),player,pt,pt.getServingTime()));
						
						player.setEnteredQueue(false);
						
					}
					
					else {
						
						physiotherapyQueue.pq.add(p);
						
						player.setQueueEntrenceTime(globalTime);
						
						player.setEnteredQueue(true);
						
						physiotherapyQueue.updateMax();
						
					}
				}
				
				else {canceled++;continue;}
				
			}
			
			else if (e instanceof EnterMassage) {
				
				EnterMassage m = (EnterMassage) e;
				
				Player player = m.getPlayer();
				
				
				if(player.getRemainingMas()<=0) {
					
					invalids++;
					
					continue;
					
				}
				
				if (player.getBusy()==true) {
					
					canceled++;
					
					continue;
					
				}
				
				else {
					
					nofMassages++;
					
					player.useMas();
					
					player.setBusy(true);
					
					if (masseurs.isEmpty()==false) {
						
						Masseur ms = masseurs.poll();
						
						events.add(new MassageEnd(globalTime+m.getDuration(),m.getPlayer(),ms,m.getDuration()));
						
						player.setEnteredQueue(false);
						
					}
					
					else {
						
						massageQueue.mq.add(m);
						
						m.getPlayer().setQueueEntrenceTime(globalTime);
						
						massageQueue.updateMax();
						
						player.setEnteredQueue(true);
						
					}	
				}
			}
			
			else if (e instanceof TrainingEnd) {
				
				TrainingEnd te = (TrainingEnd) e;
				
				Player player = te.getPlayer();
				
				tcoaches.add(te.getTrainingCoach());
				
				double duration = te.getTrainingDuration();
				
				player.setBusy(false);
				
				player.increasetotalTrainingTime(duration);
				
				if (player.getEnteredQueue()) {player.increasetotalWaitTraining(globalTime-duration-player.getQueueEntrenceTime());}

				player.setLastTrainingAmount(te.getTrainingDuration());
				
				events.add(new EnterPhysiotherapy(globalTime, te.getPlayer()));
				
				if (trainingQueue.tq.isEmpty()==false) {
					
					EnterTraining nextTraining = trainingQueue.tq.poll();
					
					events.add(new TrainingEnd(globalTime+nextTraining.getDuration(),
							nextTraining.getPlayer(),tcoaches.poll(),nextTraining.getDuration()));
					
				}
				
				nofTrainings++;
				
			}
			
			else if (e instanceof TherapyEnd) {
				
				TherapyEnd thend = (TherapyEnd) e;
				
				Player player = thend.getPlayer();
				
				double duration = thend.getTherapyDuration();
				
				ptherapists.add(thend.getPhysiotherapist());
				
				player.setBusy(false);
				
				player.increasetotalTherapyTime(duration);
				
				if (player.getEnteredQueue()) {player.increasetotalWaitTherapy(globalTime-duration-player.getQueueEntrenceTime());}
				
				if (physiotherapyQueue.pq.isEmpty()==false) {
					EnterPhysiotherapy nextTherapy = physiotherapyQueue.pq.poll();
					
					Physiotherapist ptst = ptherapists.poll();
					
					events.add(new TherapyEnd(globalTime+ptst.getServingTime(), nextTherapy.getPlayer(), ptst, ptst.getServingTime()));
					
				}
				
				nofPtherapies++;
			
			}
			
			else if (e instanceof MassageEnd) {
				
				MassageEnd mend = (MassageEnd) e;
				
				Player player = mend.getPlayer();
				
				double duration = mend.getMassageDuration();
				
				player.increasetotalMassageTime(duration);
				
				if (player.getEnteredQueue()) {player.increasetotalWaitMassage(globalTime-duration-player.getQueueEntrenceTime());}
				
				masseurs.add(mend.getMasseur());
				
				player.setBusy(false);
				
				if (massageQueue.mq.isEmpty()==false) {
					
					EnterMassage nextMassage = massageQueue.mq.poll();
					
					events.add(new MassageEnd(globalTime+nextMassage.getDuration(),
							
							nextMassage.getPlayer(), masseurs.poll(), nextMassage.getDuration()));
					
				}
			}
		}
		
		
		// Largest waiting time in physiotherapy
		double mostTimePQ = 0;
		
		// Least waiting time in massage queue
		double leastTimeMQ = -1;
		
		// ID of the player that waited most in physiotherapy queue
		int mostTimePQID = 0;
		
		// ID of the player that waited least 
		int leastTimeMQID = -1;
		
		for (Player p: players) {
			
			if (p.getTotalWaitingTherapyQueue()>mostTimePQ) {
				mostTimePQ = p.getTotalWaitingTherapyQueue();
				mostTimePQID = p.getID();
			}
			
			if ((p.getTotalWaitingMassageQueue()<leastTimeMQ || leastTimeMQ==-1) 
					&& p.getRemainingMas()==0) {
				leastTimeMQ = p.getTotalWaitingMassageQueue();
				leastTimeMQID = p.getID();
			}
			
			totalWaitingTq+=p.getTotalWaitingTrainingQueue();
			totalWaitingPq+=p.getTotalWaitingTherapyQueue();
			totalWaitingMq+=p.getTotalWaitingMassageQueue();
			
			totalTrainingTime+=p.getTotalTrainingTime();
			totalPtherapyTime+=p.getTotalTherapyTime();
			totalMassageTime+=p.getTotalMassageTime();
		}
		
		if (nofTrainings>0) {
			averageWaitingTimeTQ=totalWaitingTq/nofTrainings;
			averageTrainingTime = totalTrainingTime/nofTrainings;
		}else {
			averageWaitingTimeTQ = 0;
			averageTrainingTime = 0;
		}
		
		if(nofPtherapies>0) {
			averageWaitingTimePQ = totalWaitingPq/nofPtherapies;
			averageTherapyTime = totalPtherapyTime/nofPtherapies;
		}else {
			averageWaitingTimePQ = 0;
			averageTherapyTime = 0;
		}
		
		if(nofMassages>0) {
			averageWaitingTimeMQ =totalWaitingMq/nofMassages;
			averageMassageTime = totalMassageTime/nofMassages;
		}else {
			averageWaitingTimeMQ = 0;
			averageMassageTime = 0;
		}
		
		
		
		// Writing the output to file
		out.println(trainingQueue.getMaxLength());
		out.println(physiotherapyQueue.getMaxLength());
		out.println(massageQueue.getMaxLength());
		out.println(String.format("%.3f",averageWaitingTimeTQ));
		out.println(String.format("%.3f",averageWaitingTimePQ));
		out.println(String.format("%.3f",averageWaitingTimeMQ));
		out.println(String.format("%.3f",averageTrainingTime));
		out.println(String.format("%.3f",averageTherapyTime));
		out.println(String.format("%.3f",averageMassageTime));
		out.println(String.format("%.3f",(totalTrainingTime+totalPtherapyTime+totalWaitingTq+totalWaitingPq)/nofTrainings));
		out.println(mostTimePQID+" "+String.format("%.3f",mostTimePQ));
		
		if (leastTimeMQID==-1) {
			out.println(-1+" "+-1);
		}
		else {out.println(leastTimeMQID+" "+String.format("%.3f",leastTimeMQ));}

		out.println(invalids);
		out.println(canceled);
		out.println(String.format("%.3f",globalTime));
	}
}