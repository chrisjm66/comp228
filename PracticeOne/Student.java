
public class Student implements Comparable<Student> {
	private String firstName;
	private String lastName;
	private String favSnack;
	private int credits;
	private float costBeverage;

	public Student() {
		
	}
	
	public Student(String firstName, String lastName, String favSnack, int credits, float costBeverage) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.favSnack = favSnack;
		this.credits = credits;
		this.costBeverage = costBeverage;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFavSnack() {
		return favSnack;
	}

	public void setFavSnack(String favSnack) {
		this.favSnack = favSnack;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public float getCostBeverage() {
		return costBeverage;
	}

	public void setCostBeverage(float costBeverage) {
		this.costBeverage = costBeverage;
	}
	
	public String toString() {
		return String.format("Name: %s %s \nFavorite Food: %s \nCredits: %2d \nBev Cost: %.2f\n", firstName, lastName, favSnack, credits, costBeverage);
	}
	
	@Override
	// Compares last name.
	public int compareTo(Student other) {
		/* DONT DO THIS!! THIS IS A WASTE OF TIME.
		/* DONT DO THIS!! THIS IS A WASTE OF TIME.
		/* DONT DO THIS!! THIS IS A WASTE OF TIME.
		/* DONT DO THIS!! THIS IS A WASTE OF TIME.
		// get uppercase name so ascii conversion is easier
		String otherLastName = other.getLastName().toUpperCase();
		String thisLastName = this.lastName.toUpperCase();
		
		for(int i = 0; i < thisLastName.length(); i++) {
			// if thisLastName higher in alphabet
			if (thisLastName.charAt(i) > otherLastName.charAt(i)) {
				return 1;
				// if thisLastName lower in alphabet
			} else if (thisLastName.charAt(i) < otherLastName.charAt(i)) {
				return -1;
			}
		}
		// if names equal
		return 0;
		*/
		
		// this does the same thing and is easier to read
		return this.lastName.compareTo(other.getLastName());
	}
}
