package com.workscape.model;

public enum VehicleType {
	BIG_WHEEL("Big Wheel"),
	BICYCLE("Bicycle"),
	MOTORCYCLE("Motorcycle"),
	HANG_GLIDER("Hang Glider"),
	CAR("Car");
	private String name;
	private Vehicle vehicle;
	private VehicleType(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
