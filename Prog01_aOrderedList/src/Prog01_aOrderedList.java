import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Prog01_aOrderedList {
    public static void main(String[] args) {
        // Step 2: Input Car Data
        Scanner inputFileScanner = getInputFile("Enter input filename: ");

        // Step 4: Create an aOrderedList object
        aOrderedList carList = new aOrderedList();

        // Step 7: Operational Script
        while (inputFileScanner.hasNextLine()) {
            String line = inputFileScanner.nextLine();
            String[] parts = line.split(",");
            if (parts[0].equals("A")) {
                // Add operation
                String make = parts[1];
                int year = Integer.parseInt(parts[2]);
                int price = Integer.parseInt(parts[3]);
                Car newCar = new Car(make, year, price);
                carList.add(newCar);
            } else if (parts[0].equals("D")) {
                // Delete operation
                String make = parts[1];
                int year = Integer.parseInt(parts[2]);
                // Implement the delete logic
            }
        }

        // Step 8: Output the content of the array
        PrintWriter outputFile = getOutputFile("Enter output filename: ");
        outputFile.println("Number of cars: " + carList.size());
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            outputFile.println("Make: " + car.getMake());
            outputFile.println("Year: " + car.getYear());
            outputFile.println("Price: $" + car.getPrice());
        }

        outputFile.close();
    }

    // Step 2: Input Car Data
    public static Scanner getInputFile(String userPrompt) {
        Scanner scanner = new Scanner(System.in);
        Scanner inputFileScanner = null;
        while (inputFileScanner == null) {
            try {
                System.out.print(userPrompt);
                String filename = scanner.nextLine();
                inputFileScanner = new Scanner(new File(filename));
            } catch (FileNotFoundException e) {
                System.out.println("File specified does not exist. Would you like to continue? (Y/N)");
                String response = scanner.nextLine().toUpperCase();
                if (!response.equals("Y")) {
                    System.exit(0);
                }
            }
        }
        return inputFileScanner;
    }

    // Step 4: Populating Ordered List
    public static PrintWriter getOutputFile(String userPrompt) {
        PrintWriter outputFile = null;
        Scanner scanner = new Scanner(System.in);
        while (outputFile == null) {
            try {
                System.out.print(userPrompt);
                String filename = scanner.nextLine();
                outputFile = new PrintWriter(filename);
            } catch (FileNotFoundException e) {
                System.out.println("Unable to create or write to the specified output file.");
            }
        }
        return outputFile;
    }
}
