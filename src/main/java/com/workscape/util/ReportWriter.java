/**
 * 
 */
package com.workscape.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import com.workscape.model.Vehicle;
import com.workscape.parser.VehicleHandler;
import com.workscape.vehicleidentifier.VehicleIdentifier;

/**
 * @author Ashish
 * <pre>This class is used to create CSV file report of VehicleIdentifier Application. </pre>
 */
public class ReportWriter {
	
	private static final String FIRST_REPORT_HEADER = "VEHICLE_ID,VEHICLE_TYPE";
	private static final String SECOND_REPORT_HEADER = "VEHICLE_TYPE,NO_OF_VEHICLES";
	private static final String FILEPATH = VehicleIdentifier.class.getClassLoader().getResource("report.csv").getFile();
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	public static void writeReport(VehicleHandler handler) {
		System.out.println("Writing report in " + FILEPATH + " file");
		FileWriter fileWriter = null;
		if(handler != null && handler.getVehicles().size() != 0) {
			try {
				fileWriter = new FileWriter(FILEPATH);
				// Write the CSV file header
				fileWriter.append(FIRST_REPORT_HEADER.toString());
				// Add a new line separator after the header
				fileWriter.append(NEW_LINE_SEPARATOR);
				
				//Create first report showing list of vehicle with id and its type.
				for (Vehicle vehicle : handler.getVehicles()) {
					fileWriter.append(vehicle.getVehicleId());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(vehicle.getType().getName());
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
				
				//Create second report summary saying how many vehicles of each type
				fileWriter.append(SECOND_REPORT_HEADER.toString());
				fileWriter.append(NEW_LINE_SEPARATOR);
				for (Map.Entry<String, Integer> entry : handler.getSummary().entrySet()) {
					fileWriter.append(entry.getKey());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(entry.getValue()));
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
			} catch (IOException e) {
				System.err.println("Error while generating report for VehicleIdentifier Application exception is " + e);
			} finally {
				if(fileWriter != null) {
					try {
						fileWriter.flush();
						fileWriter.close();
					} catch (IOException e) {
						System.err.println("Error while flushing/closing fileWriter !!!");
					}//End of inner try-catch block.
				}
			}//End of try-catch-finally block.
		} else {
			System.err.println(
					"Unable to generating report for VehicleIdentifier Application as Vehicle list is null or empty.");
		}//End of if-else block.
	}//End of writeReport() Method.
}