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

	//private static final String FILEPATH = VehicleIdentifier.class.getClassLoader().getResource("vehicles.xml").getFile();
	
	public static void main(String[] args) {
		String xmlFilePath = null;
		String csvFile = null;
		if(args.length != 0) {
			xmlFilePath = args[0];
			csvFile = args[1];
			VehicleHandler handler = identifyVehicle(xmlFilePath);
			ReportWriter.writeReport(handler, csvFile);
		} else {
			System.err.println("Please specify the path of XML anf report file.");
		}
	}

	public static VehicleHandler identifyVehicle(String filePath) {
		VehicleHandler handler = null;
		if(filePath != null && !"".equals(filePath)) {
			try {
				SAXParserFactory factory = SAXParserFactory.newInstance();
				SAXParser parser = factory.newSAXParser();
				handler = new VehicleHandler();
				parser.parse(filePath, handler);
			} catch (ParserConfigurationException e) {
				System.err.println("ParserConfig error");
			} catch (SAXException e) {
				System.err.println("SAXException : xml not well formed");
			} catch (IOException e) {
				System.err.println("IO error");
			}//End of 
		} 
		return handler;
	}//End of identifyVehicle() Method.
}// End of VehicleIdentifier Class.