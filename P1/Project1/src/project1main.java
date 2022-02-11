
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Main Class
 * 
 * @author Ali Alperen Sonmez
 * 
 */

public class project1main {
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File(args[0]));
		in.useLocale(Locale.ENGLISH);
		PrintStream out = new PrintStream(new File(args[1]));

		/**
		 * ArrayList of students in the program
		 */
		ArrayList<Student> students = new ArrayList<Student>();
		
		/**
		 * ArrayList of houses in the program
		 */
		ArrayList<House> houses = new ArrayList<House>();
		
		/**
		 * Maximum duration among students. The program will end after all students are graduated.
		 */
		int maxDuration = 0;

		while (in.hasNext()) {
			
			/**
			 * Type of the input (House or Student)
			 */
			String type = in.next();
			
			
			if (type.equals("h")) {
				int ID = in.nextInt();
				int duration = in.nextInt();
				double rating = in.nextDouble();
				House h = new House(ID, duration, rating);
				houses.add(h);
			} else if (type.equals("s")) {
				int ID = in.nextInt();
				String name = in.next();
				int duration = in.nextInt();
				double rating = in.nextDouble();
				
				if (duration > maxDuration) {
					maxDuration = duration;
				}

				Student s = new Student(ID, name, duration, rating);
				students.add(s);
			}
		}
		
		Collections.sort(students);
		Collections.sort(houses);
		
		/**
		 * ID of the last student. In the program, I will decrease the duration of houses 
		 * after last student is processed in the semester.
		 */
		int lastID = students.get(students.size()-1).getID();
		
		for (int i = 0; i < maxDuration; i++) {
			for (Student s : students) {
				int iD = s.getID();
				if ((s.getResident()==true || s.getDuration()<=0) && iD!=lastID) {
					s.decreaseDuration();
					continue;
				}
				for (House h : houses) {
					if (h.getDuration() == 0 && h.getRating() >= s.getRating() && s.getResident()==false
							&& s.getDuration()>0) {
						h.increaseDuration(s.getDuration());
						s.setResident(true);
					}
					if (lastID==iD) {
						h.decreaseDuration();
					}
				}
				s.decreaseDuration();
			}
		}

		for (Student s : students) {
			if (s.getResident()==false)
			out.println(s.getName());
		}
	}

}
