package com.workscape.model;

public enum VehicleType {
	/*BIG_WHEEL("Big Wheel", new Vehicle(Constants.PLASTIC_FRAME, Constants.HUMAN_POWERTRAIN, Constants.BIG_WHEELS_LIST)),
	BICYCLE("Bicycle", new Vehicle(Constants.METAL_FRAME, Constants.HUMAN_POWERTRAIN, Constants.BICYCLE_WHEELS_LIST)),
	MOTORCYCLE("Motorcycle", new Vehicle(Constants.METAL_FRAME, Constants.INT_COM_POWERTRAIN, Constants.MOTORCYCLE_WHEELS_LIST)),
	HANG_GLIDER("Hang Glider", new Vehicle(Constants.PLASTIC_FRAME, Constants.BERNOULLI_POWERTRAIN, new ArrayList<Wheel>())),
	CAR("Car", new Vehicle(Constants.PLASTIC_FRAME, Constants.BERNOULLI_POWERTRAIN, Constants.CAR_WHEELS_LIST));*/
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
