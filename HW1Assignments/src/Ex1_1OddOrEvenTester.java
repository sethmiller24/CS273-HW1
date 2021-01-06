import java.util.Scanner;

public class Ex1_1OddOrEvenTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// prompt user
		System.out.println("Please input a number between 10 and 100:");
		// create Scanner for user inputs
		Scanner sc = new Scanner(System.in);
		// take in number of numbers to check with a scanner
		int count = sc.nextInt();
		//start the count at 1 to count
		int i = 1;
		//close scanner
		sc.close();
		// from ints 1 to i, labels whether odd or even
		while (count >= i) {
			if (i % 2 == 0) {
				// divisible by 2 -> then even
				System.out.println(i + " is even!");
			} else if (i % 2 == 1) {
				// remainder by /2 is 1 -> is odd number
				System.out.println(i + " is odd!");
			} else {
				// Exception to tell if code isn't working
				System.out.println("I dunno how to deal with " + i + " it's not even or odd somehow!");
			}
			// increment i up to count
			i++;
		}

	}

}
