import java.time.LocalDate;

public class Date {
	private int dayOfMonth;
	private int dayOfYear;
	private int month;
	private int year;
	private Boolean isLeapYear;
	private boolean isInvalid;

	// Empty Constructor that Default to today's date
	Date() {
		// LocalDate.now() produces the format Year-Month-Day "XXXX-XX-XX"
		String todaysDate = LocalDate.now().toString();

		// Separate each segment into appropriate string
		String yearStr = todaysDate.substring(0, 4);
		String monthStr = todaysDate.substring(5, 7);
		String dayStr = todaysDate.substring(8, 10);

		// Cast each respective string back into an int
		this.year = Integer.parseInt(yearStr);
		this.month = Integer.parseInt(monthStr);
		this.dayOfMonth = Integer.parseInt(dayStr);

		// determine if it is a leap year (year divisible by 4)
		this.isLeapYear = (this.year % 4 == 0);

		// assuming LocalDate should not mess up
		this.isInvalid = false;

		// Calculate DayOfYear
		this.calcDayOfYear();
	}
	
	//3 arg constructor
	//input: dayOfMonth - int between 1 and 28,29,30 and 31 depending on month and leap year
	//			 month - number between 1 and 12 to match the month
	//			 year - year
	Date(int dayOfMonth, int month, int year) {
		//set the inputed data
		this.dayOfMonth = dayOfMonth;
		this.month = month;
		this.year = year;

		// Years divisible by 4 are leap years
		this.isLeapYear = (year % 4 == 0);

		this.isInvalid = this.invalidDate(dayOfMonth, month, year);

		if (!this.isInvalid) {
			this.calcDayOfYear();
		}
	}

	//2 arg constructor
	//input: year - the year
	//			 dayOfYear - number hopefully between 1-365 (or 366 if leap year)
	Date(int year, int dayOfYear) {
		//set the inputed data
		this.year = year;
		this.dayOfYear = dayOfYear;
		
		// Years divisible by 4 are leap years
		this.isLeapYear = (year % 4 == 0);
		
		
		this.isInvalid = this.invalidDate(year, dayOfYear);
		if (!this.isInvalid) {
			this.calcMonth(this.dayOfYear);
		}
	}

	// Constructor to make a day modDays in the future from today's date
	Date(int modDays) {
		//call empty (today's date) constructor
		this();
		
		//increment the number of days
		this.dayOfYear += modDays;
		
		//account for if dayOfYear goes over number of days in according year
		fixWrapAround();
		
		//make sure the rest of the data aligns with dayOfYear and Year
		this.isLeapYear = (this.year%4==0);
		this.calcMonth(this.dayOfYear);		
	}
	
	//Helper Function for add days if it goes over appropriate 365 or 366 days a year
	//Post: Wrap additional days to end of year to beginning of next year
	//			increases year by decreasing dayOfYear by 365 or 366
	private void fixWrapAround() {
		//while the dayOfYear is too big for the given year, move forward a year by trading for 365 or 366 days
		while((this.dayOfYear >366)||(!this.isLeapYear && this.dayOfYear>365)){
			if (this.isLeapYear) 
				//decrement extra day on leap year
				this.dayOfYear--;
			//decrement 365 days in a year
			this.dayOfYear-=365;
			//increment 1 year to trade for 365 or 366 days
			this.year++;
			//modify isLeapYear when needed
			this.isLeapYear = (this.year%4==0);
		}
	}

	// Helper method to set Month and dayOfMonth based on DayOfYear and year
	private void calcMonth(int dayOfYear) {
		// Help determine how many days in Feb should be considered
		int febDays = 28;
		if (this.isLeapYear) {
			febDays++;
		}

		// A downward counter starting at dayOfYear to find month
		int dayOfMonthCount = dayOfYear;

		// i represents months
		// go from jan to dec
		for (int i = 1; i <= 12 && dayOfMonthCount > 0; i++) {
			if (i == 4 || i == 6 || i == 9 || i == 11) {
				// Months with 30 days
				if (dayOfMonthCount <= 30) {
					// i is the month
					this.month = i;
					// remainder of count is dayOfMonth
					this.dayOfMonth = dayOfMonthCount;
					// set to 0 to exit the loop
					dayOfMonthCount = 0;
				} else {
					// i is not the month
					// progress to the next month by decrementing this month's days from the counter
					dayOfMonthCount -= 30;
				}
			} else if (i == 2) {
				// February
				if (dayOfMonthCount <= febDays) {
					// i is the month
					this.month = i;
					// remainder of count is dayOfMonth
					this.dayOfMonth = dayOfMonthCount;
					// set to 0 to exit the loop
					dayOfMonthCount = 0;
				} else {
					// February is not the month
					// progress to the next month by decrementing this month's days from the counter
					dayOfMonthCount -= febDays;
				}
			} else {
				// months with 31 days
				if (dayOfMonthCount <= 31) {
					// i is the month
					this.month = i;
					// remainder of count is dayOfMonth
					this.dayOfMonth = dayOfMonthCount;
					// set to 0 to exit the loop
					dayOfMonthCount = 0;
				} else {
					// i is not the month
					// progress to the next month by decrementing this month's days from the counter
					dayOfMonthCount -= 31;
				}
			}
		}
	}

	// Helper method to set dayOfYear based on Month,DayOfMonth and Year
	private void calcDayOfYear() {
		int febDays = 28;
		if (this.isLeapYear) {
			// when the year is a leap year, 29 days otherwise 28
			febDays++;
		}

		// sum of days that will end up = to this.dayOfyear
		int dayOfYearCount = 0;

		// sum all days in months before specified month
		// i represents each month
		for (int i = 1; i < this.month; i++) {
			if (i == 4 || i == 6 || i == 9 || i == 11) {
				// add Months with 30 days
				dayOfYearCount += 30;
			} else if (i == 2) {
				// add February's num of days
				dayOfYearCount += febDays;
			} else {
				// add months with 31 days
				dayOfYearCount += 31;
			}
		}
		// add the remaining days of the month to sum
		this.dayOfYear = this.dayOfMonth + dayOfYearCount;
	}

	// Helper function to check whether the dayOfYear is Feasible
	private boolean invalidDate(int year, int dayOfYear) {
		// check if leap year has day over 366
		if (this.isLeapYear && dayOfYear > 366)
			return true;
		// check if regular year has day over 366
		else if (dayOfYear > 365 || dayOfYear <= 0)
			return true;
		else
			return false;
	}

	// Helper function to check whether dayOfMonth and month are feasible
	private boolean invalidDate(int dayOfMonth, int month, int year) {
		// make sure month is between 1 and 12
		if (month > 12 || month <= 0)
			return true;
		// Months with 30 days
		else if (month == 4 || month == 6 || month == 9 || month == 11) {
			// make sure 30 day months have <= 30 days
			if (dayOfMonth > 30)
				return true;
		} else if (month == 2) {
			// February
			if (this.isLeapYear && dayOfMonth > 29)
				return true;
			else if (dayOfMonth > 28)
				return true;

		} else {
			// months with 31 days
			// make sure 31 day months have <= 31 days
			if (dayOfMonth > 31)
				return true;
		}
		// Pass all the if statements -> valid Date
		return false;
	}

	// return "month/day/year"
	public String toString() {
		if (this.isInvalid)
			// when the date doesn't exist
			return "INVALID DATE";
		else {
			// return month/day/year
			return this.month + "/" + this.dayOfMonth + "/" + this.year + " (Day " +this.dayOfYear +" of "+ this.year+")";
		}
	}

	//Getters
	
	public int getDayOfYear() {
		return this.dayOfYear;
	}

	public int getYear() {
		return this.year;
	}

	public int calcDiff(Date other) {
		int sum = 0;
		//a copy of other.getYear() to modify
		int otherYear = other.getYear();
		
		//until both years are the same year, move otherYear closer to this.year
		while (otherYear != this.year) {
			//count the days in the years being passed
			sum += 365;
			//otherYear is after this.year
			if (otherYear > this.year) {
				//account for extra days in leap years
				if (this.year%4==0) {
					sum++;
				}
				//move otherYear closer to this.year
				otherYear--;
			} else {
				//account for leap year
				if (otherYear%4==0) {
					sum++;
				}
				//move otherYear closer to this.year
				otherYear++;
			}

		}
		//add the difference between the days in the year
		sum += (this.getDayOfYear() - other.getDayOfYear());
		
		//return the absolute value for my sanity
		return Math.abs(sum);
	}
	
}
