/**
 * 
 */
package com.workscape.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.workscape.model.Frame;
import com.workscape.model.Vehicle;
import com.workscape.model.VehicleType;
import com.workscape.model.Wheel;
import com.workscape.util.Constants;

/**
 * @author Ashish
 */
public class VehicleHandler extends DefaultHandler {
	private Map<String, Integer> summary;
	private List<Vehicle> vehicles;
	private Vehicle vehicle;
	private Frame frame;
	private Wheel wheel;
	
	private Boolean isId = Boolean.FALSE;
	private Boolean isFrame = Boolean.FALSE;
	private Boolean isMaterial = Boolean.FALSE;
	private Boolean isWheel = Boolean.FALSE;
	private Boolean isPosition = Boolean.FALSE;
	private Boolean isPowertrain = Boolean.FALSE;
	
	public VehicleHandler() {
		super();
		this.vehicles = new ArrayList<Vehicle>();
		this.summary = new HashMap<String, Integer>();
		//adding all the Vehicle types to print summary report.
		for (VehicleType type : VehicleType.values()) {
			summary.put(type.getName(), 0);
		}
	}

	@Override
	public void startElement(String uri, String localName, String elementName, Attributes attributes) throws SAXException {
		if(isPowertrain) {
			vehicle.setPowertrain(elementName);
			isPowertrain = Boolean.FALSE;
		}
		if(Constants.VEHICLE.equals(elementName)) {
			vehicle = new Vehicle();
		} else if("id".equals(elementName)) {
			isId = Boolean.TRUE;
		} else if(Constants.FRAME.equals(elementName)) {
			frame = new Frame();
			isFrame = Boolean.TRUE;
		} else if(Constants.MATERIAL.equals(elementName)) {
			isMaterial = Boolean.TRUE;
		} else if(Constants.WHEEL.equals(elementName)) {
			wheel = new Wheel();
			isWheel = Boolean.TRUE;
		} else if("position".equals(elementName)) {
			isPosition = Boolean.TRUE;
		} else if("powertrain".equals(elementName)) {
			isPowertrain = Boolean.TRUE;
		}
	}//End of startElement() Method.

	@Override
	public void endElement(String uri, String localName, String elementName) throws SAXException {
		// Here we can use switch-case but then it will run only on java 1.7 and
		// above versions thus using if-else.	
		if(Constants.VEHICLE.equals(elementName)) {
			//Set the vehicle type according to its characteristics.
			VehicleType type = vehicle.setType();
			if(type != null) {
				int num = summary.get(type.getName());
				summary.put(type.getName(), num + 1);
			}
			vehicles.add(vehicle);
		}  else if(Constants.FRAME.equals(elementName)) {
			vehicle.setFrame(frame);
			isFrame = Boolean.FALSE;
		} else if(Constants.WHEEL.equals(elementName)) {
			vehicle.addWheel(wheel);
			isWheel = Boolean.FALSE;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String value = new String(ch, start, length);
		if(isId) {
			vehicle.setVehicleId(value);
			isId = Boolean.FALSE;
		} else if(isMaterial) {
			if(isFrame) {
				frame.setMaterial(value);
			} else if(isWheel) {
				wheel.setMaterial(value);
			}
			isMaterial = Boolean.FALSE;
		} else if(isPosition) {
			wheel.setPosition(value);
			isPosition = Boolean.FALSE;
		} 
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public Map<String, Integer> getSummary() {
		return summary;
	}

	public void printReport() {
		System.out.println("--- Vehicle Report ---");
		
		System.out.println("| VEHICLE ID \t| VEHICLE TYPE |");
		for (Vehicle vehicle : vehicles) {
			System.out.println("| " + vehicle.getVehicleId() + " \t| " + vehicle.getType().getName() + "|");
		}
		
		System.out.println("--- Summary Report ---");
		for (Map.Entry<String, Integer> entry : summary.entrySet()) {
			System.out.println(entry.getKey() + " ->  " + entry.getValue() + " Vehicles.");
		}
	}
}