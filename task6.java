package pst;

import java.util.Scanner;

class InvalidBookingException extends Exception {
	public InvalidBookingException(String message) {
		super(message);
	}
}

class Driver {
	private String name;

	public Driver(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class Rider {
	private String name;

	public Rider(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

abstract class Vehicle {
	public abstract int calculateFare(int distance);
}

class Bike extends Vehicle {
	@Override
	public int calculateFare(int distance) {
		return distance * 5;
	}
}

class Auto extends Vehicle {
	@Override
	public int calculateFare(int distance) {
		return distance * 12;
	}
}

class Cab extends Vehicle {
	@Override
	public int calculateFare(int distance) {
		return distance * 12;
	}
}

class Trip {
	private Rider rider;
	private Driver driver;
	private Vehicle vehicle;
	private int distance;

	public Trip(Rider rider, Driver driver, Vehicle vehicle, int distance) throws InvalidBookingException {
		if (distance <= 0) {
			throw new InvalidBookingException("Error: Invalid Booking (Distance must be > 0)");
		}
		if (vehicle == null) {
			throw new InvalidBookingException("Error: Invalid Booking");
		}
		this.rider = rider;
		this.driver = driver;
		this.vehicle = vehicle;
		this.distance = distance;
	}

	public int getFare() {
		return vehicle.calculateFare(distance);
	}
}

public class task6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of trips: ");

		if (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			System.out.println();

			for (int i = 1; i <= n; i++) {
				System.out.print("Enter vehicle type and distance for Trip " + i + " (e.g., Bike 10): ");
				String vehicleType = scanner.next();
				int distance = scanner.nextInt();

				try {
					Vehicle vehicle = null;
					if (vehicleType.equalsIgnoreCase("Bike")) {
						vehicle = new Bike();
					} else if (vehicleType.equalsIgnoreCase("Auto")) {
						vehicle = new Auto();
					} else if (vehicleType.equalsIgnoreCase("Cab")) {
						vehicle = new Cab();
					} else {
						throw new InvalidBookingException("Error: Invalid Vehicle Type");
					}

					Driver driver = new Driver("John Doe");
					Rider rider = new Rider("Jane Smith");

					Trip trip = new Trip(rider, driver, vehicle, distance);
					System.out.println("Calculated Fare: " + trip.getFare() + "\n");

				} catch (InvalidBookingException e) {
					System.out.println(e.getMessage() + "\n");
				}
			}
		}
		System.out.println("Ride Sharing System Terminated.");
		scanner.close();
	}
}