import java.util.Scanner;

public class EX1_2AreaOrCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create constant variable for Pi
		final Double PI = 3.14;

		// Create a scanner
		Scanner sc = new Scanner(System.in);

		// Prompt User for Radius
		System.out.println("Input a radius for a circle:");

		// take in radius
		double rad = sc.nextDouble();

		//close scanner
		sc.close();

		// Calculate Area
		double area = PI * rad * rad;

		// Show area, both ways
		System.out.println("The area is " + (rad * rad) + "*Pi or " + area + "\n");
	}

}
