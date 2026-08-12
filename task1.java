package pst;

import java.util.Scanner;
import java.util.stream.LongStream;

public class task1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter no of salaries");
		int n = sc.nextInt();
		System.out.println("enetr salaries");
		long[] salaries = new long[n];
		for (int i = 0; i < n; i++) {
			salaries[i] = sc.nextLong();
		}
		LongStream.of(salaries).map(salary -> (long) (salary * 1.10))
				.forEach(updates -> System.out.println(updates + " "));

	}
}
