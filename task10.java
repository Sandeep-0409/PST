package pst;

import java.util.Scanner;

public class task10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of login attempts: ");

		if (scanner.hasNextInt()) {
			int n = scanner.nextInt();

			System.out.println("Enter username and password for " + n + " attempts:");
			for (int i = 0; i < n; i++) {
				String username = scanner.next();
				String password = scanner.next();

				boolean isValidUsername = username.length() >= 3 && username.length() <= 20;
				boolean isValidPassword = password.length() >= 6 && password.length() <= 20;

				if (isValidUsername && isValidPassword) {
					System.out.println("SUCCESS\n");
				} else {
					System.out.println("FAILURE\n");
				}
			}
		}

		scanner.close();
	}
}