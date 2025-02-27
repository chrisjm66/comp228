package apps;

import java.util.ArrayList;
import classes.Student;

public class C228001SP24 {

	public static void main(String[] args) {

		// student object instantiations go here:
		Student aStudent = new Student("Reese", "Witherspoon", "peanutbutter cups", 3, 5.67F);
		Student student2 = new Student("Orlando", "Bloom", "Bloomin' Onions", 12, 10.11F);
		Student mbb      = new Student("Mille Bobby", "Brown", "Eggo waffles", 11, 20.04F);
		// etc.
		Student andrew = new Student("Andrew", "Joukov", "bepsi", 12, 2.25F);
		Student reuven = new Student("Reuven", "Israeli", "Lays-Potato Chips", 6, 6.00F);
		Student dLane  = new Student("Dasaan", "Lane", "pretzel", 12, 2.60F);
		Student myInfo = new Student("Simerjit", "Singh", "Pizza", 9, 2.5f);
		Student student = new Student("Carlos", "Jimenez", "N/A", 48, (float) 2.5);
		Student henry   = new Student("Henry", "Rodriquez", "Dorito Dynamites", 44, 3.25F);
		Student mKeller = new Student("Matthew", "Keller", "chips", 65, 2.00F);
		Student ash = new Student ("Ashley", "Carrasco", "Popcorn", 18, 7.50f);
		Student eGibbs = new Student("Emerson", "Gibbs", "Chips", 10, 2.25F);
		Student vabron = new Student("Vanderbilt", "Boyce III", "Pretzel Rods",12,5.67F);		
		Student Rob = new Student("Robert", "Martinez-Olivera", "Oven baked lays or Quested Frosted Protien Cookies", 13, 2.50F);
		Student max = new Student("Max", "Berezovskyy", "bueno candy", 12, 6.99F);
		Student Michelle = new Student("Michelle", "Mistretta", "Cereal", 7,6F);
		Student aHassan = new Student("Amro", "Hassan", "Skittles", 13, 3.50f);
		Student jakeG = new Student("Jake", "Giacone", "Chocolate", 45, 1.25F);
		
		ArrayList<Student> roster = new ArrayList<Student>();
		
		/*
		roster.add(aStudent);
		roster.add(student2);
		roster.add(mbb);
		// etc.
		*/
		roster.add(andrew);
		roster.add(reuven);
		roster.add(dLane);
		roster.add(myInfo);
		roster.add(student);
		roster.add(henry);
		roster.add(mKeller);
		roster.add(ash);
		roster.add(eGibbs);
		roster.add(vabron);
		roster.add(Rob);
		roster.add(max);
		roster.add(Michelle);
		roster.add(aHassan);
		roster.add(jakeG);
		
		System.out.println("Class roster for COMP-228-001 Data Structures 24SP");
		System.out.println("--------------------------------------------------");
		for (Student s : roster) {
			System.out.println(s);
		}
		
		/**/
		ArrayList<Student> rosterSorted = new ArrayList<Student>();
		rosterSorted = (ArrayList) roster.clone();
		rosterSorted.sort(null);
		
		System.out.println("\nClass roster for COMP-228-001 Data Structures 24SP, sorted by name");
		System.out.println("--------------------------------------------------");
		for (Student s : rosterSorted) {
			System.out.println(s);
		}
		/**/
	}
}

