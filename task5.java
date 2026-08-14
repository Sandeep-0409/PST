package pst;

import java.util.Scanner;

class bankacc {
	private int balance;

	public bankacc() {
		balance = 0;
	}

	public void deposit(int amount) {
		balance += amount;
	}

	public void withdraw(int amount) {
		balance -= amount;
	}

	public int getbalance() {
		return balance;
	}
}
public class task5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter no of operation");
		int n = sc.nextInt();
		bankacc acc = new bankacc();
		for (int i = 0; i < n; i++) {
			String op = sc.next();
			int amount = sc.nextInt();

			if (op.equalsIgnoreCase("Deposit")) {
				acc.deposit(amount);
			} else if (op.equalsIgnoreCase("Withdraw")) {
				acc.withdraw(amount);
			}
		}
		System.out.println("balance=" + acc.getbalance());
		sc.close();
	}
}