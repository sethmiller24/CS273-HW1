import java.util.Scanner;

public class EX1_3StrToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create a scanner
		Scanner sc = new Scanner(System.in);

		// where the input int will be stored
		String number = "";

		// determines whether number is an Int
		Boolean hasInt = false;

		// Keeps iterating until user inputs an integer
		while (!hasInt) {
			// Prompt User for Integer
			System.out.println("Please put in an Integer:");
			if (sc.hasNextInt()) {// when the next segment is an Integer
				// save input as a string by adding to end
				number = "" + sc.nextInt();
				// change Boolean to end While loop
				hasInt = true;
				// System.out.println(number + " is the inputed integer with a length of "
				// +number.length());
			} else if (sc.hasNext()) { // When the user inputs something outside an Int
				// take in all of user input
				number = sc.nextLine();
				// Prompt user to try to only use digits
				System.out.println("sorry... \"" + number + "\" can't be considered an Integer...\nPlease use digits");
			}
		}

		//close the scanner
		sc.close();

		// preset the in version of the input
		int intFromStr = 0;
		for (int i = 0; i < number.length(); i++) {
			// multiply by 10 so each digit can be in the right position
			intFromStr *= 10;

			// Add each digit to next available spot
			// -48 accounts for difference between int and char
			// i.e. '2' becomes 50
			intFromStr += (number.charAt(i)) - 48;
		}

		// double check work
		System.out.printf("This integer %d has been converted into an int!", intFromStr);

	}

}
