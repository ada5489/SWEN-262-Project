import Database.CSVReader;
import RequestResponse.GenerateItenaries;

import java.io.IOException;
import java.util.Scanner;

public class Client {

    private static GenerateItenaries itenaries;


    private static void startDatabase() throws IOException {
        itenaries = CSVReader.readCsv();
    }

    public static void main(String[] args) throws IOException {
        startDatabase();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Departure Airport and Arrival airport separated by a comma");
        String input = scanner.next();
        System.out.println("The inputs are: " + input);
        String[] l = input.split(",");
        System.out.println(itenaries.itineraries(l[0], l[1]).toString());

    }
}
