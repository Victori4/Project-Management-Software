package dit092;

public class TeamMember {
	
	private int id;
	private String name;
	private double timeSpent;
	private static final double HOURLY_RATE = 250; //public?
	
	//constructor needed

	public double calculateSalary(double timeSpent) {
		double salary = timeSpent * HOURLY_RATE;
		return salary;
	}

	/**
	 * Validate parameters for the set methods & throw exceptions where neeeded
	 */
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTimeSpent() {
		return timeSpent;
	}
	public void setTimeSpent(double timeSpent) {
		this.timeSpent = timeSpent;
	}
	public static double getHOURLY_RATE() {
		return HOURLY_RATE;
	}
	
	// toString needed
}
