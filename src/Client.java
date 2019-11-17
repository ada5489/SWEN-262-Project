import Database.CSVReader;

import java.io.IOException;

public class Client {


    public Client() {
    }

    private static void startDatabase() throws IOException {
//        CSVReader.read_text("data/airportnames.txt");
//        CSVReader.read_text("data/connections.txt");
//        CSVReader.read_text("data/DelayTimes.txt");
//        CSVReader.read_text("data/flights.txt");
//        CSVReader.read_text("data/weather.txt");
        CSVReader.readCsv();
        CSVReader.writeCsv();


    }

    public static void main(String[] args) throws IOException {
        startDatabase();
    }
}
