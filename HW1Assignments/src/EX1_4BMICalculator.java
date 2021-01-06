import java.util.Scanner;

public class EX1_4BMICalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// Prompt user for type of measurements
		System.out.println(
				"Would you like to use Imperial Measurements?\nInput 'y' to confirm, or it will otherwise default to Metric:");
		// if "y", useImperial is true eventually calling BMIImperial instead of
		// BMIMetric
		Boolean useImperial = sc.next().equalsIgnoreCase("y");

		// Prompt user and take in weight and height as a double
		System.out.println("Input your weight:");
		double weight = sc.nextDouble();
		System.out.println("Input your height:");
		double height = sc.nextDouble();

		//close the scanner
		sc.close();

		if (useImperial) {
			// when user had chosen to use Imperial
			// Double check measurements
			System.out.println("Using " + weight + " lbs in weight and " + height + " ft in height:");
			// Call Imperial BMI Calculator
			BMIImperial(weight, height);
		} else {
			// Otherwise default to metric BMI Calculator
			// Double check measurements
			System.out.println("Using " + weight + " kg in weight and " + height + " m in height:");
			// default to BMIMetric
			BMIMetric(weight, height);
		}
	}

	// BMI Calculator based on Metric measurements
	// input: weight: weight in metric
	// height: height in metric
	static void BMIMetric(Double weight, Double height) {
		double BMI = weight / (height * height);
		System.out.println(BMI + " is the BMI");
	}

	// BMI Calculator based on Imperial measurements
	// Convert to Metric and call BMIMetric
	// input: weight: weight in Imperial
	// height: height in Imperial
	static void BMIImperial(Double weight, Double height) {
		// convert to Metric and call BMI Metric to calculate it
		BMIMetric(0.453592 * weight, 0.3048 * height);
	}

}
