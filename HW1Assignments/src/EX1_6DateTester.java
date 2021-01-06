
public class EX1_6DateTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test 3 arg constructor
				Date test1 = new Date(1, 1, 2020); //Jan 1st 2020
				System.out.println(test1.toString());

				//test 2 arg constructor
				Date test2 = new Date(2020, 366); //Dec 31st 2020
				System.out.println(test2.toString());
				
				//test empty ( default to today's date) constructor
				Date today = new Date();
				System.out.println(today.toString());

				// Test Constructor for future
				Date nextWeek = new Date(7);
				System.out.println(nextWeek.toString());
				
				Date nextYear = new Date(365);
				System.out.println(nextYear.toString());
				
				//Test Differences in Dates
				System.out.println(test2.calcDiff(test1) +" days difference between " + test1.toString() +" and "+ test2.toString());
				System.out.println(nextWeek.calcDiff(today)+" days difference between " + nextWeek.toString() +" and "+ today.toString());
				
				// Test with Invalid dayOfYear
				Date invalidTest1 = new Date(2021, 369);
				System.out.println(invalidTest1.toString());
				// Test with invalid dayOfMonth
				Date invalidTest2 = new Date(32, 1, 2021);
				System.out.println(invalidTest1.toString());
				// Test with invalid month
				Date invalidTest3 = new Date(1, 13, 2021);
				System.out.println(invalidTest1.toString());

	}

}
