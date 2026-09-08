package pst;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class task7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of hashtags: ");

		if (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			scanner.nextLine();

			Map<String, Integer> hashtagCount = new LinkedHashMap<>();

			System.out.println("Enter the hashtags (one per line):");
			for (int i = 0; i < n; i++) {
				String hashtag = scanner.nextLine().trim();
				hashtagCount.put(hashtag, hashtagCount.getOrDefault(hashtag, 0) + 1);
			}

			System.out.println("\nHashtag Frequencies:");
			for (Map.Entry<String, Integer> entry : hashtagCount.entrySet()) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		}

		scanner.close();
	}
}