
public class EX1_5EmployeeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] Safeway = new Employee[5];
		// Boss, so uses 3 arg constructor (without boss)
		Safeway[0] = new Employee("Mr. Bossman", "March 17th 1991", "Manager");
		// Otherwise, use 4 arg constructor for normal employees
		Safeway[1] = new Employee("Ryan Lank", "December 25th 2002", "Professional Bagger", Safeway[0]);
		Safeway[2] = new Employee("Michael Pin Pin", "December 26th 2002", "Ryan Lank's Understudy", Safeway[1]);
		Safeway[3] = new Employee("Definitely not a Fred Meyer Corporate Spy", "August 27th 2018", "Forklift Driver",
				Safeway[0]);
		Safeway[4] = new Employee("Santa Clause", "December 1st 2020", "Salvation Army Donation Bell Ringer",
				Safeway[0]);

		// Run through array
		for (Employee emp : Safeway) {
			// print out all the details of each employee
			System.out.println(emp.toString());
			if (emp.getID() <= 2) {
				// 1st 2 employees retire
				emp.retire();
			} else if (emp.getName().contains("Spy")) {
				// have spies get fired
				emp.fire();
			} else {
				// all others quit
				emp.quit();
			}
		}
	}
}
