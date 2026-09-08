package pst;

import java.util.Scanner;

public class task9 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter arithmetic expression: ");

		if (scanner.hasNextDouble()) {
			double num1 = scanner.nextDouble();
			String operator = scanner.next();
			double num2 = scanner.nextDouble();

			try {
				double result = 0;
				boolean validOperation = true;

				switch (operator) {
				case "+":
					result = num1 + num2;
					break;
				case "/":
					if (num2 == 0) {
						throw new ArithmeticException("Division by zero");
					}
					result = num1 / num2;
					break;
				default:
					validOperation = false;
				}

				if (validOperation) {
					System.out.println("\nTest Passed");
				} else {
					System.out.println("\nTest Failed: Unsupported operation");
				}

			} catch (ArithmeticException e) {
				System.out.println("\nTest Failed: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("\nTest Failed");
			}
		}

		scanner.close();
	}
}