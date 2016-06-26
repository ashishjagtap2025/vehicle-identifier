package com.workscape.vehicleidentifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.workscape.model.Frame;
import com.workscape.model.Vehicle;
import com.workscape.model.Wheel;
import com.workscape.parser.VehicleHandler;
import com.workscape.util.Constants;
import com.workscape.util.Utils;
import junit.framework.Assert;

/**
 * Unit test for simple App.
 */
public class VehicleIdentifierTest {
	
	private static final String FILEPATH = VehicleIdentifier.class.getClassLoader().getResource("vehicles.xml").getFile();
	private List<Vehicle> expectedVehicles;

	@Before
	public void setup() {
		Frame plasticFrame = new Frame(Constants.PLASTIC_MATERIAL);
		Frame metalFrame = new Frame(Constants.METAL_MATERIAL);
		
		expectedVehicles = new ArrayList<Vehicle>();
		ArrayList<Wheel> bigWheels = new ArrayList<Wheel>(Arrays.asList(Constants.BIG_WHEELS));
		Vehicle bigWheelVehicle = new Vehicle(plasticFrame, Constants.HUMAN_POWERTRAIN, bigWheels);
		bigWheelVehicle.setVehicleId("vehicle 1");
		bigWheelVehicle.setType();
		expectedVehicles.add(bigWheelVehicle);
		
		ArrayList<Wheel> twoWheels = new ArrayList<Wheel>(Arrays.asList(Constants.TWO_WHEELS));
		Vehicle bicycle = new Vehicle(metalFrame, Constants.HUMAN_POWERTRAIN, twoWheels);
		bicycle.setVehicleId("vehicle 2");
		bicycle.setType();
		expectedVehicles.add(bicycle);
		
		Vehicle motorcycle = new Vehicle(metalFrame, Constants.INT_COM_POWERTRAIN, twoWheels);
		motorcycle.setVehicleId("vehicle 3");
		motorcycle.setType();
		expectedVehicles.add(motorcycle);
		
		Vehicle hangGlider = new Vehicle(plasticFrame, Constants.BERNOULLI_POWERTRAIN, new ArrayList<Wheel>());
		hangGlider.setVehicleId("vehicle 4");
		hangGlider.setType();
		expectedVehicles.add(hangGlider);
		
		ArrayList<Wheel> carWheels = new ArrayList<Wheel>(Arrays.asList(Constants.CAR_WHEELS));
		Vehicle car = new Vehicle(metalFrame, Constants.INT_COM_POWERTRAIN, carWheels);
		car.setVehicleId("vehicle 5");
		car.setType();
		expectedVehicles.add(car);
	}

	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void testApp() {
		VehicleHandler vehicleHandler = VehicleIdentifier.identifyVehicle(FILEPATH);
		Boolean result = Utils.equalLists(expectedVehicles, vehicleHandler.getVehicles());
		Assert.assertEquals("Test failed please check the XML file", Boolean.TRUE, result);
	}
}
