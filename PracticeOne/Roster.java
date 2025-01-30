import java.util.ArrayList;
import java.util.Collections;

public class Roster {	
	public static void main(String[] args) {
		Student chris = new Student("Chris", "Mangan", "cheese", 50, 3.00f);
		Student matt = new Student("Matt", "Matthies", "sweaty armpit", 1, 999.99f);
		Student jSturt = new Student("Jacob ","Sturt ", "Reese cups ", 53, 7.50f );
		Student nDonadio = new Student("Nick", "Donadio", "chips", 12, 2.89F);
		Student hLe = new Student("Hanna", "Le", "chips", 60, 6.00F);
		
		ArrayList<Student> roster = new ArrayList<>();
		roster.add(chris);
		roster.add(matt);
		roster.add(jSturt);
		roster.add(nDonadio);
		roster.add(hLe);
		
		roster.sort(null); // using null uses the compareTo of the class
		System.out.println("\nSorted");
		for(Student s : roster) {
			System.out.println(s);
		}
		
		Collections.shuffle(roster);
		System.out.println("\nShuffled");
		for(Student s : roster) {
			System.out.println(s);
		}
		
	}

}
