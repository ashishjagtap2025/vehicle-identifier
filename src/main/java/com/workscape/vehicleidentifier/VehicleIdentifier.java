package com.workscape.vehicleidentifier;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.workscape.parser.VehicleHandler;
import com.workscape.util.ReportWriter;

/**
 * Hello world!
 */
public class VehicleIdentifier {

	private static final String FILEPATH = VehicleIdentifier.class.getClassLoader().getResource("vehicles.xml").getFile();
	
	public static void main(String[] args) {
		VehicleHandler handler = identifyVehicle();
		ReportWriter.writeReport(handler);
	}

	public static VehicleHandler identifyVehicle() {
		VehicleHandler handler = null;
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			handler = new VehicleHandler();
			parser.parse(FILEPATH, handler);
		} catch (ParserConfigurationException e) {
			System.err.println("ParserConfig error");
		} catch (SAXException e) {
			System.err.println("SAXException : xml not well formed");
		} catch (IOException e) {
			System.err.println("IO error");
		}
		return handler;
	}
}// End of VehicleIdentifier Class.