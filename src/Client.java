import Database.CSVReader;
import Model.Itinerary;
import RequestResponse.GenerateItineraries;

import java.io.IOException;
import java.util.Scanner;

public class Client {

    private static GenerateItineraries itenaries;


    private static void startDatabase() throws IOException {
        itenaries = CSVReader.readCsv();
    }

    public static void main(String[] args) throws IOException {
        startDatabase();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Departure Airport , Arrival airport and Number of connections separated by a comma ");
        String input = scanner.next();
        System.out.println("The inputs are: " + input);
        String[] l = input.split(",");
        int num = Integer.parseInt(l[2]);
        for (Itinerary i : itenaries.itineraries(l[0], l[1], num))
        {
            System.out.println(i.toString());
        }

    }
}
