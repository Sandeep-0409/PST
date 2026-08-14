package pst;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class task4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the DNA Text (T):");
		String text = sc.next();
		System.out.println("Enter the DNA Pattern (P):");
		String pattern = sc.next();
		List<Integer> indices = searchBoyerMoore(text, pattern);
		System.out.println("\nPattern found at starting indices:");
		if (indices.isEmpty()) {
			System.out.println("No matches found.");
		} else {
			for (int i = 0; i < indices.size(); i++) {
				System.out.print(indices.get(i) + (i == indices.size() - 1 ? "" : " "));
			}
			System.out.println();
		}

		sc.close();
	}

	private static List<Integer> searchBoyerMoore(String text, String pattern) {
		List<Integer> result = new ArrayList<>();
		int n = text.length();
		int m = pattern.length();
		if (m == 0 || n == 0 || m > n) {
			return result;
		}
		int[] badChar = new int[256];
		for (int i = 0; i < 256; i++) {
			badChar[i] = -1;
		}
		for (int i = 0; i < m; i++) {
			badChar[pattern.charAt(i)] = i;
		}
		int s = 0;
		while (s <= (n - m)) {
			int j = m - 1;

			while (j >= 0 && pattern.charAt(j) == text.charAt(s + j)) {
				j--;
			}
			if (j < 0) {
				result.add(s);
				s += (s + m < n) ? m - badChar[text.charAt(s + m)] : 1;
			} else {
				s += Math.max(1, j - badChar[text.charAt(s + j)]);
			}
		}
		return result;
	}
}