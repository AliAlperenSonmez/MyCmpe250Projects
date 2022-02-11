

/**
* House is the class of students. Implements the Comparable interface.
* 
* @author Ali Alperen Sönmez
* 
*/

public class Student implements Comparable<Student>{
	
	private int ID;
	
	private String name;
	
	private int duration;
	
	private double rating;
	
	private boolean resident = false;
	
	public Student(int ID, String name, int duration, double rating) {
		this.ID = ID;
		this.name = name;
		this.duration = duration;
		this.rating = rating;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public double getRating() {
		return rating;
	}
	
	public boolean getResident() {
		return resident;
	}
	
	public void setResident(boolean resident) {
		this.resident = resident;
	}
	
	/**
	 * <p>For decreasing the duration of the student after a semester.
	 */
	public void decreaseDuration() {
		this.duration-=1;
	}
	
	
	/**
	 * <p>Overriding the compareTo method of comparable interface
	 * @param Student o Other student
	 */
	@Override
	public int compareTo(Student o) {
		return this.ID-o.ID;
	}
	
}
