package com.skilldistillery.foodtruck.entities;

import java.util.Objects;

public class FoodTruck {
	private static int nextTruckId;
	private String truckName;
	private String foodType;
	private int rating;
	private int id;

	// every truck has own personal id
	public FoodTruck() {
		this.id = nextTruckId;
		
	}

	public FoodTruck(String truckName, String foodType, int rating) {
		this.truckName = truckName;
		this.foodType = foodType;
		this.rating = rating;
		this.id = nextTruckId;
		nextTruckId++;

	}

	public static int getNextTruckId() {
		return nextTruckId;
	}

	public static void setNextTruckId(int nextTruckId) {
		FoodTruck.nextTruckId = nextTruckId;
	}

	public String getName() {
		return truckName;
	}

	public void setName(String truckName) {
		this.truckName = truckName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return "Food Truck: Name" + truckName + ", Food Type: " + foodType + ", Rating: " + rating + ", ID: " + id;

	}

	public void displayTruck() {
		String truckData = this.toString();
		System.out.println(truckData);
	}
	
}
