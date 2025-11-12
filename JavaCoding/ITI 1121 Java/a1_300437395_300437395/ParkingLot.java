import java.io.File;
import java.util.Scanner;

/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 */
public class ParkingLot {
	/**
	 * The delimiter that separates values
	 */
	private static final String SEPARATOR = ",";

	/**
	 * The delimiter that separates the parking lot design section from the parked
	 * car data section
	 */
	private static final String SECTIONER = "###";

	/**
	 * Instance variable for storing the number of rows in a parking lot
	 */
	private int numRows = 0;

	/**
	 * Instance variable for storing the number of spaces per row in a parking lot
	 */
	private int numSpotsPerRow = 0;

	/**
	 * Instance variable (two-dimensional array) for storing the lot design
	 */
	private CarType[][] lotDesign;

	/**
	 * Instance variable (two-dimensional array) for storing occupancy information
	 * for the spots in the lot
	 */
	private Car[][] occupancy;

	/**
	 * Constructs a parking lot by loading a file
	 * 
	 * @param strFilename is the name of the file
	 */
	public ParkingLot(String strFilename) throws Exception {

		if (strFilename == null) {
			System.out.println("File name cannot be null.");
			return;
		}

		// determine numRows and numSpotsPerRow; you can do so by
		// writing your own code or alternatively completing the 
		// private calculateLotDimensions(...) that I have provided
		calculateLotDimensions(strFilename);

		// instantiate the lotDesign and occupancy variables!
		// WRITE YOUR CODE HERE!
		this.lotDesign = new CarType[numRows][numSpotsPerRow];
		this.occupancy = new Car[numRows][numSpotsPerRow];

		// populate lotDesign and occupancy; you can do so by
		// writing your own code or alternatively completing the 
		// private populateFromFile(...) that I have provided
		populateFromFile(strFilename);
	}

	/**
	 * Parks a car (c) at a give location (i, j) within the parking lot.
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @param c is the car to be parked
	 */
	public void park(int i, int j, Car c) {
		// WRITE YOUR CODE HERE!
		boolean isParked = canParkAt(i,j,c); 
		if(isParked == true){this.occupancy[i][j] = c;}
	}

	/**
	 * Removes the car parked at a given location (i, j) in the parking lot
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return the car removed; the method returns null when either i or j are out
	 *         of range, or when there is no car parked at (i, j)
	 */
	public Car remove(int i, int j) {
		// WRITE YOUR CODE HERE!
		
		if(i > numRows){return null;}
		else if (j > numSpotsPerRow){return null;}
		else if (occupancy[i][j] == null){ return null;}
		else{
			Car gone = occupancy[i][j];
			occupancy[i][j] = null;
			return gone;
		}
	}

	/**
	 * Checks whether a car (which has a certain type) is allowed to park at
	 * location (i, j)
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return true if car c can park at (i, j) and false otherwise
	 */
	public boolean canParkAt(int i, int j, Car c) {
		// WRITE YOUR CODE HERE!
		boolean canPark = false;
		CarType na = CarType.NA;
		if(i > numRows){return false;}
		else if (j > numSpotsPerRow){return false;}
		else if (lotDesign[i][j] == na){return false;}
		else if (occupancy[i][j] != null) {return false;}
		
		CarType parkSpace = lotDesign[i][j];
		CarType parkCar = c.getType();
		
		CarType large = CarType.LARGE;
		CarType regular = CarType.REGULAR;
		CarType small = CarType.SMALL;
		CarType elec = CarType.ELECTRIC;
		
		
		if(parkCar == large){
			if(parkSpace == large){canPark = true;} 
		}
		else if(parkCar == regular){
			if((parkSpace == large) || (parkSpace == regular)){canPark = true;}
		}
		else if(parkCar == small){
			if((parkSpace == large) || (parkSpace == regular) || (parkSpace == small)){canPark = true;}
		}
		else if(parkCar == elec){
			if(parkSpace != na){canPark = true;}
		}
		
		
		return canPark; // REMOVE THIS STATEMENT AFTER IMPLEMENTING THIS METHOD

	}

	/**
	 * @return the total capacity of the parking lot excluding spots that cannot be
	 *         used for parking (i.e., excluding spots that point to CarType.NA)
	 */
	public int getTotalCapacity() {
		// WRITE YOUR CODE HERE!
		int capacity = 0;
		CarType carCan;
		CarType na = CarType.NA;
		
		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < numSpotsPerRow; j++){
				carCan = lotDesign[i][j];
				
				if(carCan != na){
					capacity ++;
				}
			}
		}
		return capacity; 

	}

	/**
	 * @return the total occupancy of the parking lot (i.e., the total number of
	 *         cars parked in the lot)
	 */
	public int getTotalOccupancy() {
		// WRITE YOUR CODE HERE!
		int occTotal = 0;
		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < numSpotsPerRow; j++){
				
				if(occupancy[i][j] != null){
						occTotal ++;
				}
			}
		}
		
		return occTotal; 		
	}

	private void calculateLotDimensions(String strFilename) throws Exception {

		Scanner scanner = new Scanner(new File(strFilename));
		
		
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			
			// WRITE YOUR CODE HERE!
			
			
			if(str.equals(SECTIONER)){

				break;
			}
			str = str.replaceAll("\\s","");
			str = str.replaceAll(",","");
			
			if(numRows <= 0){
				this.numRows = (str.length()-1);
			}
			this.numSpotsPerRow+= 1;
			
		}		
		
		scanner.close();
	}

	private void populateFromFile(String strFilename) throws Exception {

		Scanner scanner = new Scanner(new File(strFilename));

		// YOU MAY NEED TO DEFINE SOME LOCAL VARIABLES HERE!
		boolean firstPart = true;
		boolean secondPart = false;
		int rowNum1, rowPlace, occPlace1, occPlace2;
		char occData1, occData2, charCar,charFp;
		String strCar,strFp; 
		CarType occType, placeHolder;  
		rowNum1 = 0;
		rowPlace = 0;
		occPlace1 = 0;
		occPlace2 = 0;
		

		// while loop for reading the lot design
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			// WRITE YOUR CODE HERE!
			str = str.replaceAll("\\s","");
			str = str.replaceAll(",","");
						
			if((firstPart == true) && (str.length() > 0)){
				for(int i = 0; i < numSpotsPerRow; i++){
					charFp = str.charAt(i);
					strFp = "" + charFp;
					placeHolder = Util.getCarTypeByLabel(strFp);
					this.lotDesign[rowNum1][i] = placeHolder;
						
				}
			}		
			if(rowNum1 != numRows){
				rowNum1 = rowNum1 + 1;
			}
			else{
				firstPart = false;
			}
			
			
			
		}
		scanner.close();
		
		Scanner scanner1 = new Scanner(new File(strFilename));

		// while loop for reading occupancy data
		String plate = "";
		int rowNum2 = 0;
		while (scanner1.hasNext()) {
			String str = scanner1.nextLine();
			// WRITE YOUR CODE HERE!
			str = str.replaceAll("\\s","");
			str = str.replaceAll(",","");
			
			rowNum2 = rowNum2 + 1;
			if(rowNum2 > numRows+3){
				secondPart = true;
			}
			
			if(secondPart == true){
				occData1 = str.charAt(0);
				occData2 = str.charAt(1);
				charCar = str.charAt(2);
				strCar = "" + charCar; 
				
				occType = Util.getCarTypeByLabel(strCar);
				
				occPlace1 = Character.getNumericValue(occData1);
				occPlace2 = Character.getNumericValue(occData2);
				plate = "";
				for(int j = 3; j<str.length(); j++){
					plate = "" + plate + str.charAt(j);					
				}
				
				Car vehicle = new Car(occType,plate);
				this.occupancy[occPlace1][occPlace2] = vehicle; 
			}
			
		}

		scanner1.close();
	}

	/**
	 * Produce string representation of the parking lot
	 * 
	 * @return String containing the parking lot information
	 */
	public String toString() {
		// NOTE: The implementation of this method is complete. You do NOT need to
		// change it for the assignment.
		StringBuffer buffer = new StringBuffer();
		buffer.append("==== Lot Design ====").append(System.lineSeparator());

		for (int i = 0; i < lotDesign.length; i++) {
			for (int j = 0; j < lotDesign[0].length; j++) {
				buffer.append((lotDesign[i][j] != null) ? Util.getLabelByCarType(lotDesign[i][j])
						: Util.getLabelByCarType(CarType.NA));
				if (j < numSpotsPerRow - 1) {
					buffer.append(", ");
				}
			}
			buffer.append(System.lineSeparator());
		}

		buffer.append(System.lineSeparator()).append("==== Parking Occupancy ====").append(System.lineSeparator());

		for (int i = 0; i < occupancy.length; i++) {
			for (int j = 0; j < occupancy[0].length; j++) {
				buffer.append(
						"(" + i + ", " + j + "): " + ((occupancy[i][j] != null) ? occupancy[i][j] : "Unoccupied"));
				buffer.append(System.lineSeparator());
			}

		}
		return buffer.toString();
	}

	/**
	 * <b>main</b> of the application. The method first reads from the standard
	 * input the name of the file to process. Next, it creates an instance of
	 * ParkingLot. Finally, it prints to the standard output information about the
	 * instance of the ParkingLot just created.
	 * 
	 * @param args command lines parameters (not used in the body of the method)
	 * @throws Exception
	 */

	public static void main(String args[]) throws Exception {

		StudentInfo.display();

		System.out.print("Please enter the name of the file to process: ");

		Scanner scanner = new Scanner(System.in);

		String strFilename = scanner.nextLine();

		ParkingLot lot = new ParkingLot(strFilename);

		System.out.println("Total number of parkable spots (capacity): " + lot.getTotalCapacity());

		System.out.println("Number of cars currently parked in the lot: " + lot.getTotalOccupancy());

		System.out.print(lot);

	}
}