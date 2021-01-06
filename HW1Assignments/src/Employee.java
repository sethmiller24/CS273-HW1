
public class Employee {
	// A counter to increment ID for each new employee
		private static int IDcounter = 1;

		// Attributes that Employees have
		private int ID;
		private String name;
		private String hireDate;
		private String position;
		private String bossName;

		Employee() {
			// Call 3 arg constructor defaulting to these presets
			this("[Employee]", "[Hire Date]", "[Position]");
			System.out.println("In Empty Constructor");
		}

		Employee(String name, String hireDate, String position) {
			System.out.println("In 3 arg constructor");

			// Assign ID and then increment the counter so next employees have different IDs
			this.ID = IDcounter++;
			this.name = name;
			this.hireDate = hireDate;
			this.position = position;

			// Defaults the boss to Customers
			this.bossName = "Customers";
		}

		Employee(String name, String hireDate, String position, Employee boss) {
			// calls 3 arg constructor
			this(name, hireDate, position);

			System.out.println("In 4 arg constructor");

			// change bossName to the name of the boss inputed
			this.bossName = boss.getName();
		}

		// Getters
		public String getName() {
			return name;
		}

		public int getID() {
			return ID;
		}
		
		public String getBoss() {
			return bossName;
		}
		
		public String getHireDate() {
			return hireDate;
		}
		
		//return all the properties of the employee
		public String toString() {
			return "ID: " + this.ID + " | Name: "+ this.name + " | Hire Date: "+ this.hireDate + " | Position: "+ this.position + " | Boss: "+ this.bossName ;
		}
		
		//input: cost: represents severance or retirement packages
		private void unemploy(int cost) {
			//lose boss
			this.bossName = "none";
			//downgrade position to customer
			this.position = "Customer";
			//declare any severance or retirement packages
			System.out.println(this.name + " is no longer an employee, but gets $"+ cost);
		}
		
		//Fancy Versions of unemploy///////////////////////////////////////////////////
		public void fire() {
			//declare firing
			System.out.println(this.name+" has been fired");
			//fire = unemploy + severance 
			this.unemploy(1000);
		}
		
		public void retire() {
			//declare retire
			System.out.println(this.name + " has retired");
			//retire = unemploy + retirement package...?
			this.unemploy(1000);
		}
		
		public void quit() {
			//declare quit
			System.out.println(this.name + " has quit the company");
			//quit = unemploy with no money
			this.unemploy(0);
		}
}
