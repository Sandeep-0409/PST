package pst;

import java.util.Scanner;

public class task3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter n");
		int n = sc.nextInt();
		long currentmax = sc.nextLong();
		long globalmax = currentmax;
		for (int i = 1; i < n; i++) {
			long currentprofit = sc.nextLong();
			currentmax = Math.max(currentprofit, currentmax + currentprofit);
			globalmax = Math.max(currentmax, globalmax);
		}
		System.out.println(globalmax);
	}

}
