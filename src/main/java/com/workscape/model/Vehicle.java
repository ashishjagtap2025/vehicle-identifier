/**
 * 
 */
package com.workscape.model;

import java.util.ArrayList;
import java.util.Arrays;

import com.workscape.util.Constants;
import com.workscape.util.Utils;

/**
 * @author Ashish
 */
public class Vehicle implements Comparable<Vehicle> {
	private String vehicleId;
	private Frame frame;
	private String powertrain;
	private ArrayList<Wheel> wheels;
	private VehicleType type;
	
	/**
	 * 
	 */
	public Vehicle() {
		this.wheels = new ArrayList<Wheel>();
	}

	public Vehicle(Frame frame, String powertrain, ArrayList<Wheel> arrayList) {
		super();
		this.frame = frame;
		this.powertrain = powertrain;
		this.wheels = arrayList;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	public String getPowertrain() {
		return powertrain;
	}

	public void setPowertrain(String powertrain) {
		this.powertrain = powertrain;
	}
	
	public void addWheel(Wheel wheel) {
		this.wheels.add(wheel);
	}
	
	public Integer getNoOfWheels() {
		return this.wheels.size();
	}

	public VehicleType getType() {
		return type;
	}

	public VehicleType setType() {
		//Vehicle must specify the frame material else show the error message.
		if(frame.getMaterial() != null && !"".equals(frame.getMaterial())) {
			//Following code will check the Vehicle type Hang Glider or not.
			if (this.getNoOfWheels() == 0 && Constants.BERNOULLI_POWERTRAIN.equals(this.powertrain)
					&& Constants.PLASTIC_MATERIAL.equals(this.frame.getMaterial())) {
				type = VehicleType.HANG_GLIDER;
				return type;
			} 
			
			//Following code will check the Vehicle type is Bicycle or Motorcycle
			ArrayList<Wheel> twoWheels = new ArrayList<Wheel>(Arrays.asList(Constants.TWO_WHEELS));
			if (getNoOfWheels() == 2 && Constants.METAL_MATERIAL.equals(frame.getMaterial())
					&& Utils.equalLists(wheels, twoWheels)) {
				if(Constants.HUMAN_POWERTRAIN.equals(powertrain))
					type = VehicleType.BICYCLE;
				else if(Constants.INT_COM_POWERTRAIN.equals(powertrain))
					type = VehicleType.MOTORCYCLE;
				else
					System.err.println("Invalid powertrain detected " + powertrain);
				return type;
			}
			
			//Following code will check the Vehicle type is Big Wheel or not
			ArrayList<Wheel> bigWheels = new ArrayList<Wheel>(Arrays.asList(Constants.BIG_WHEELS));
			if(getNoOfWheels() == 3 && Constants.PLASTIC_MATERIAL.equals(frame.getMaterial()) 
					&& Constants.HUMAN_POWERTRAIN.equals(powertrain) && Utils.equalLists(wheels, bigWheels)) {
				type = VehicleType.BIG_WHEEL;
				return type;
			}
			
			//Following code will check the Vehicle type is Big Wheel or not
			ArrayList<Wheel> carWheels = new ArrayList<Wheel>(Arrays.asList(Constants.CAR_WHEELS));
			if(getNoOfWheels() == 4 && Constants.METAL_MATERIAL.equals(frame.getMaterial()) 
					&& Constants.INT_COM_POWERTRAIN.equals(powertrain) && Utils.equalLists(wheels, carWheels)) {
				type = VehicleType.CAR;
				return type;
			}
			System.err.println("Unable to find Vehicle Type for specification " + toString());
		} else {
			System.err.println("Frame Material should not be null or empty.");
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((frame == null) ? 0 : frame.hashCode());
		result = prime * result + ((powertrain == null) ? 0 : powertrain.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((vehicleId == null) ? 0 : vehicleId.hashCode());
		result = prime * result + ((wheels == null) ? 0 : wheels.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (frame == null) {
			if (other.frame != null)
				return false;
		} else if (!frame.equals(other.frame))
			return false;
		if (powertrain == null) {
			if (other.powertrain != null)
				return false;
		} else if (!powertrain.equals(other.powertrain))
			return false;
		if (type != other.type)
			return false;
		if (vehicleId == null) {
			if (other.vehicleId != null)
				return false;
		} else if (!vehicleId.equals(other.vehicleId))
			return false;
		if (wheels == null) {
			if (other.wheels != null)
				return false;
		} else if (!Utils.equalLists(wheels, other.wheels))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", frame=" + frame + ", powertrain=" + powertrain + ", wheels="
				+ wheels + ", type=" + type + "]";
	}

	public int compareTo(Vehicle other) {
		return vehicleId.compareTo(other.getVehicleId());
	}
}//End of Vehicle Class. 