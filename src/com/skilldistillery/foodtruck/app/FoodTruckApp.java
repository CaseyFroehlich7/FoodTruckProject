package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		FoodTruckApp fest = new FoodTruckApp();

		String userInput;
		String truckName;
		String foodType;
		int rating = 0;

		FoodTruck[] foodies = new FoodTruck[5];

		System.out.println("        Welcome to the 1st annual Hanover Food Truck Festival");
		System.out.println();
		System.out.println("Help us crown the best food truck by rating the ones that you tried today!");
		System.out.println();

		for (int i = 0; i < foodies.length; i++) {

			System.out.println("Please enter the name of food truck:");
			truckName = sc.next();
			if (truckName.equalsIgnoreCase("quit")) {
				break;
			}
			System.out.println("What type of food did " + truckName + " serve?");
			foodType = sc.next();

			boolean correctRating = true;
			while (correctRating) {
				System.out.println("How many stars does " + truckName + " deserve? (1-5 Stars)");
				rating = sc.nextInt();
				if (rating > 0 && rating < 6) {
					System.out.println("Thank you for rating " + truckName + "!");
					System.out.println();
					correctRating = false;

					foodies[i] = new FoodTruck(truckName, foodType, rating);

				} else {
					System.out.println("Entry Invalid. Please enter a rating between 1-5.");
					System.out.println();
				}

			}

		}

		sc = new Scanner(System.in);
		boolean userMenu = true;

		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("%%%%%%%%%%%%%%%%  MAIN MENU %%%%%%%%%%%%%%%%");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("%%                                        %%");
		System.out.println("%%     1. PRINT FULL FOOD TRUCK LIST      %%");
		System.out.println("%%     2. AVERAGE FOOD TRUCK RATING       %%");
		System.out.println("%%     3. HIGHEST FOOD TRUCK RATING       %%");
		System.out.println("%%     4. EXIT                            %%");
		System.out.println("%%                                        %%");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

		while (userMenu) {

			System.out.println("Please select a menu option.");
			int menuOption = sc.nextInt();

			switch (menuOption) {

			case 1:
				for (int i = 0; i < foodies.length; i++) {
					if (foodies[i] == null) {
						break;
					}
					System.out.println(foodies[i].toString() + "\n");
				}

			case 2:
				double sumRatings = 0.0;
				double avgRatings = 0.0;

				for (int i = 0; i < foodies.length; i++) {
					if (foodies[i] == null) {
						break;
					}
					sumRatings += foodies[i].getRating();
				}

				avgRatings = sumRatings / foodies.length;
				System.out.printf("Average Food Truck Rating: %.1f", avgRatings);
				System.out.println("\n");

			case 3:
				double highestRating = 0.0;

				for (int i = 0; i < foodies.length; i++) {
					if (foodies[i] == null) {
						break;
					} else if (foodies[i].getRating() > highestRating) {
						highestRating = foodies[i].getRating();

						System.out.println("Highest Rated Food Truck: " + foodies[i].toString());
					}
				}
				break;
			case 4:
				System.out.println("Thank you for your participation!");
				userMenu = false;
				break;

			default:
				if (menuOption < 0 || menuOption > 4) {
					System.out.println("Invalid Entry");
				}

			}

		}

	}
}
