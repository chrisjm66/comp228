package searching;

import java.util.Random;
import sorting.Sorts;
public class Searches {
	static int[] baseArray = new int[1000];
	static int swaps = 0;
	static int comparisons = 0;
	
	public static void main (String[] args) {
		generateBaseArray();
		
		long startTime = 0;
		long totalSeqTime = 0;
		int matches = 0;
		int matchSum = 0;
		
		// Sequential Search unsorted
		for (int i = 1000; i <= 9999; i++) {
			startTime = System.nanoTime();
			int result = sequentialSearch(baseArray, i);
			totalSeqTime += System.nanoTime() - startTime;
			
			if (result != -1) {
				matches++;
				matchSum += i;
			}
		}
		
		System.out.println("Sequential Search, unsorted array:");
		System.out.println(totalSeqTime + " nanoseconds // " + nsToS(totalSeqTime) + " seconds");
		System.out.println(matches + " matches");
		System.out.println(matchSum + " sum");
		
		//  Copy & Sort array
		totalSeqTime = 0;
		matches = 0;
		matchSum = 0;
		
		int[] copy = copyArray(baseArray);
		startTime = System.nanoTime();
		selectionSort(copy);
		totalSeqTime += System.nanoTime() - startTime;
		
		System.out.println("\nArray sorting:");
		System.out.println(totalSeqTime + " nanoseconds // " + nsToS(totalSeqTime) + " seconds");
		System.out.println(swaps + " swaps");
		System.out.println(comparisons + " comparisons");
		
		// Sequential Search unsorted
		for (int i = 1000; i <= 9999; i++) {
			startTime = System.nanoTime();
			int result = sequentialSearch(copy, i);
			totalSeqTime += System.nanoTime() - startTime;
			
			if (result != -1) {
				matches++;
				matchSum += i;
			}
		}
		
		System.out.println("\nSequential Search, sorted array:");
		System.out.println(totalSeqTime + " nanoseconds // " + nsToS(totalSeqTime) + " seconds");
		System.out.println(matches + " matches");
		System.out.println(matchSum + " sum");
		
		// Binary non recursive Search
		startTime = 0;
		totalSeqTime = 0;
		matches = 0;
		matchSum = 0;
		
		for (int i = 1000; i <= 9999; i++) {
			startTime = System.nanoTime();
			int result = binarySearch(copy, i);
			totalSeqTime += System.nanoTime() - startTime;
			
			if (result != -1) {
				matches++;
				matchSum += i;
			}
		}
		
		System.out.println("\nBinary (nonrecursive) Search:");
		System.out.println(totalSeqTime + " nanoseconds // " + nsToS(totalSeqTime) + " seconds");
		System.out.println(matches + " matches");
		System.out.println(matchSum + " sum");
		
		// Binary recursive Search
		startTime = 0;
		totalSeqTime = 0;
		matches = 0;
		matchSum = 0;

		selectionSort(copy);
		for (int i = 1000; i <= 9999; i++) {
			startTime = System.nanoTime();
			int result = binaryRecursive(copy, 0, copy.length - 1, i);
			totalSeqTime += System.nanoTime() - startTime;
			if (result != -1) {
				matches++;
				matchSum += i;
			}
		}
		
		System.out.println("\nBinary (recursive) Search:");
		System.out.println(totalSeqTime + " nanoseconds // " + nsToS(totalSeqTime) + " seconds");
		System.out.println(matches + " matches");
		System.out.println(matchSum + " sum");
	}
	
	public static int binaryRecursive(int[] array, int bottom, int top, int target) {
		// this is basically just the inside of the while loop from the first one.
		// we do most of the work on the outside of the function which makes the code much simpler
		int middle = bottom + (top - bottom) / 2;
		
		if (top >= bottom) {
			if (array[middle] == target) {
				return middle;
			}
			
			if (array[middle] > target) {
				return binaryRecursive(array, bottom, middle - 1, target);
			} else {
				return binaryRecursive(array, middle + 1, top, target);
			}
		}
		
		return -1;
	}


	public static int sequentialSearch(int[] array, int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target)
				return i;
		}
		
		return -1;
	}
	
	public static int binarySearch(int[] array, int target) {
		int bottom = 0;
		int top = array.length - 1;
		
		while (bottom <= top ) {
			int middle = bottom + (top - bottom) / 2;
			
			if (array[middle] == target) {
				return middle;
			}
			
			if (array[middle] < target) {
				bottom = middle + 1;
			} else {
				top = middle - 1;
			}
		}
		
		return -1;
	}
	
	public static int[] copyArray(int[] array) {
		int[] copy = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}
		
		return copy;
	}
	
	public static void generateBaseArray() {
		Random rand = new Random();
		
		for (int i = 0; i < 1000; i++) {
			int n = 1000 + rand.nextInt(9000);
			
			int j;
			for (j = 0; j < i; j++) {
				if (n == baseArray[j]) {
					break;
				}
			}
			
			if (j == i) {
				baseArray[i] = n;
			} else {
				i--;
			}
		}
	}
	
	public static double nsToS(long time) {
		return (double)time / Math.pow(10, 9);
	}
	
	// these methods from Sorts.java
	public static void selectionSort(int[] array) {
	  for (int i = 0; i < array.length; i++) {
		  int smallest = i;
		  for (int j = i + 1; j < array.length; j++) {
			  comparisons++;
			  if (array[j] < array[smallest]) {
				  smallest = j;
			  }
		  }
		  swap(array, smallest, i);
	  }
  }
	  
	 static public void swap(int[] array, int index1, int index2) {
	    int temp = array[index1];
	    array[index1] = array[index2];
	    array[index2] = temp;
	    swaps++;
	 }
}
