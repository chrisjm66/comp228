import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String line = "";
        ArrayList<MCBeaches> beaches = new ArrayList<>();
        String userInput = "";

        // Read the CSV file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("MonmouthCountyNJ_Ocean_Beaches.csv"));
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                // b/c area code and phone number stored in 2 values
                String phoneNumber = data[3] + "-" + data[4];

                MCBeaches beach = new MCBeaches( // int zip, long phoneNumber, double dailyFee, boolean hasLifeguard, String parkwaySouthExit, String parkwayNorthExit, double latitude, double longitude, String website
                    data[0], // beachname
                    data[1], // townname
                    Integer.parseInt(data[2]), // zip code
                    phoneNumber, // phone number
                    Double.parseDouble(data[5]), // daily fee
                    Boolean.parseBoolean(data[6]), // lifeguard
                    data[7], // GSP-S exit
                    data[8], // GSP-N exit
                    Double.parseDouble(data[9]), // latitude
                    Double.parseDouble(data[10]), // longitude
                    data[11] // website
                );

                beaches.add(beach);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        // Begin app
        System.out.println("\nWelcome to the Monmouth County beaches app! By Chris Mangan");
        while (!userInput.equalsIgnoreCase("stop")) {
            System.out.println("\nEnter 'original' for original data order, 'sorted' for sorted data order (by latitude), 'random' for random order, or 'stop' to exit.");

            userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("original")) {
                printArrayList(beaches, userInput);
            } else if (userInput.equalsIgnoreCase("sorted")) {
                ArrayList<MCBeaches> copy = (ArrayList<MCBeaches>)beaches.clone();
                copy.sort(null);
                printArrayList(copy, userInput);
            } else if (userInput.equalsIgnoreCase("random")) {
                ArrayList<MCBeaches> copy = (ArrayList<MCBeaches>)beaches.clone();
                Collections.shuffle(copy);
                printArrayList(copy, userInput);
            }
        }

        scanner.close();
    }

    public static void printArrayList(ArrayList<MCBeaches> beaches, String userInput) {
        System.out.printf("\nBeaches in Monmouth County, NJ in %s order:\n", userInput);
        for (int i = 0; i < beaches.size(); i++) {
            System.out.println("\t" + beaches.get(i));
        }
    }
}
