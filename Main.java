
public class Main {
	public static void main(String[] args) {
		Student chris = new Student("Chris", "Mangan", "cheese", 50, 3.00f);
		
		System.out.println(chris);
		System.out.println("First Name: " + chris.getFirstName());
		System.out.println("Last Name: " + chris.getLastName());
		System.out.println("Favorite Snack: " + chris.getFavSnack());
		System.out.println("Credits: " + chris.getCredits());
		System.out.println("Beverage Cost: " + chris.getCostBeverage());
		System.out.println();
		
		Student testStudent = new Student();
		testStudent.setFirstName("Matthew");
		testStudent.setLastName("Mangan");
		testStudent.setFavSnack("nuts");
		testStudent.setCredits(3);
		testStudent.setCostBeverage(80f);
		System.out.println( );
		
		System.out.println(testStudent);
		
		System.out.println(chris.compareTo(testStudent));
	}
}
