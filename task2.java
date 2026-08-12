package pst;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class task2 {

		static class sensorread {
			String id;
			double temp;

			sensorread(String id, double temp) {
				this.id = id;
				this.temp = temp;
			}

			String getid() {
				return id;
			}

			double gettemp() {
				return temp;
			}
		}

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter n");
			int n = sc.nextInt();
			List<sensorread> readings = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				System.out.println("id");
				String id = sc.next();
				System.out.println("temp");
				double temp = sc.nextDouble();
				readings.add(new sensorread(id, temp));
			}
			readings.stream().filter(r -> r.gettemp() > 50)
					.collect(Collectors.groupingBy(sensorread::getid, Collectors.averagingDouble(sensorread::gettemp)))
					.entrySet().stream()
					.sorted(Map.Entry.<String, Double>comparingByValue(Comparator.reverseOrder())
							.thenComparing(Map.Entry.comparingByKey()))
					.forEach(entry -> System.out.printf("%s %.1f\n", entry.getKey(), entry.getValue()));
		}


}