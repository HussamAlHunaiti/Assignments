package searchAlgorithms;

import java.util.Scanner;

public class SequentialSearch {
	public static void main(String[] args) {
	    int [] arr = {2, 3, 5, 6, 4, 2, 31, 46, 684, 13, 3, 8, 47, 654, 987, 4, 32, 186, 4 };
	    Scanner input = new Scanner(System.in);
	    int number = input.nextInt();

	    if (sequentialSearch(arr, number)) {
	        System.out.println("Found.");
	    } else {
	        System.out.println("Not Found.");
	    }
	}

	public static boolean sequentialSearch(int [] arr, int number) {
	    for (int i = 0; i < arr.length ; i++)
	        if (arr[i] == number) {
	            System.out.println("The number: " + number + " exist in index: " + i + " in the array.");
	            return true;
	        }
	   return false;
	}
}
