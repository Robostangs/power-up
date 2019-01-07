package frc.robot;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 
 * @author Anurag Kompalli
 * 
 *         <summary> Method for saving, retrieving and updating config values
 *         without having to re-deploy code every time. Reads and Parses a JSON
 *         File and maps its keys and values to the configValues HashMap
 *         </summary>
 * 
 * 
 *         TODO: Add Error Handling
 */
public class JSONConstants {

	// configValues is the map in which the keys and values will be stored
	private static HashMap<String, Object> configValues = new HashMap<String, Object>();

	// defines the file path and name of the config file
	private static final String FILE_PATH = "config/config.json";

	/**
	 * <summary> Tester Class: Tests whether one is able to read and update the
	 * values within the configValues map </summary>
	 */
	public static void test() {
		// Start the call timer
		double firstPopulate = System.nanoTime();

		// Run the function
		int status = JSONConstants.populateMap();

		// End the call timer
		double firstPopulateEND = System.nanoTime();

		// end minus start time is the duration the call took
		System.out.println("First Population Call Took: " + ((firstPopulateEND - firstPopulate) / 1000000) + " ms");

		// Start the second call timer
		double secondPopulate = System.nanoTime();

		// Run the function
		int status2 = JSONConstants.populateMap();

		// End the call timer
		double secondPopulateEND = System.nanoTime();

		// What did we see?
		System.out.println("Second Population Call Took: " + ((secondPopulateEND - secondPopulate) / 1000000) + " ms");
		System.out.println("First populateMap() returned: " + status);
		System.out.println("Second populateMap() returned: " + status2);
	}

	/**
	 * <summary> The <code>populateMap()</code> method takes a JSON file and reads
	 * the keys and values.
	 * 
	 * Uses these keys and values to populate the configValues HashMap with the
	 * relevant values needed for the match </summary>
	 */
	public static int populateMap() {

		// Defines a JSON parser
		JSONParser parser = new JSONParser(
			
		);

		try {
			// Open and Assign the file to a JSON Object
			Object fileObj = parser.parse(new FileReader(FILE_PATH));
			JSONObject configJSONObj = (JSONObject) fileObj;

			// Get the key set for the JSON Object
			Set<String> entries = configJSONObj.keySet();

			// Make sure there isn't any leftover values in the map before we write
			System.out.println("====== CLEARING HASHMAP ======");
			configValues.clear();

			// Foreach loop to put each key and value in the HashMap
			for (String entry : entries) {
				configValues.put(entry, configJSONObj.get(entry));
			}

			// Make sure we tell the user what keys we have added (will also show up on
			// SmartDashboard)
			for (String key : configValues.keySet()) {
				System.out.println("Added KEY: [" + key + "] and VALUE: [" + configValues.get(key) + "] "
						+ "Value is of TYPE: " + configValues.get(key).getClass());
			}

		} catch (FileNotFoundException notFoundEx) {

			// System did not find the file in the specified path
			// Check if you defined the file correctly (spelling and path)
			System.err.println("The file " + FILE_PATH + " was not found at the specified path");
			notFoundEx.printStackTrace();

			// return FAIL
			return -1;
		} catch (IOException ioe) {

			// System was not able to perform I/O Operations
			// Check if the file is marked as read only or is protected in any way
			// (encrypted)
			System.err.println("An IOException Occured");
			ioe.printStackTrace();

			// return FAIL
			return -1;
		} catch (ParseException pe) {

			// JSON Simple was not able to parse the JSON
			// Make sure the file extension is actually .json and json.simple jar is not
			// corrupted
			System.err.println("JSON Simple was not able to parse the file: " + FILE_PATH);
			pe.printStackTrace();

			// return FAIL
			return -1;
		}

		// return SUCCESS
		return 0;
	}

	/*
	 * The get() method allows easy access to the configValues HashMap without
	 * providing direct access and does a bunch of checks before delivering the
	 * value
	 * 
	 * @return Object
	 */
	public static Object get(String key) {
		// Making sure there's something there to search for
		if (configValues.size() > 0) {

			// get the value from the configValues HashMap
			Object value = configValues.get(key);

			// making sure object is there
			if (value != null) {

				// Safely Converts a Long to an Integer
				// if (value instanceof Long) {
				// 	return ((Long) value).intValue();
				// }

				// return the value as a generic Object (user can cast as necessary)
				return value;
			}

			// if not, return -1 (fail)
			return -1;
		}

		// In case size is 0, we return FAIL
		return -1;
	}
}
