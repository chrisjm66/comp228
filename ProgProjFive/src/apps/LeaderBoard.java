package apps;


import adts.BinarySearchTree;


public class LeaderBoard {
  
	public static void main(String[] args) {
		
		BinarySearchTree<Golfer> golfers = new BinarySearchTree<Golfer>();
		
		golfers.add(new Golfer("Hideki", 74));
		golfers.add(new Golfer("Cheyenne", 73));
		golfers.add(new Golfer("Matt", 77));
		golfers.add(new Golfer("Bel�n", 76));
		golfers.add(new Golfer("Brooks", 75));
		golfers.add(new Golfer("Natalie", 68));
		golfers.add(new Golfer("Xander", 71));
		golfers.add(new Golfer("Lexi", 79));
		golfers.add(new Golfer("Rory", 70));

		displayLeaderboard(golfers);
		
	}
	
	public static void displayLeaderboard(BinarySearchTree<Golfer> golfers) {
		int totalScore = 0;
		int medianIndex = golfers.size() / 2;
		int median = 0;
		int index = 0;
		golfers.setTraversalType("in");

		System.out.println("Golfers: \n");
		for (Golfer golfer : golfers) {
			System.out.println(golfer);
			totalScore += golfer.getScore();
			//System.out.printf("Name: %s, Score: %d\n", golfer.getName(), golfer.getScore());
			
			if (index == medianIndex) {
				median = golfer.getScore();
			}
			index++;
		}
		
		double averageScore = totalScore / golfers.size();
		System.out.printf("\nAverage score: %f", averageScore);
		System.out.printf("\nMedian score: %d", median);
	}
}