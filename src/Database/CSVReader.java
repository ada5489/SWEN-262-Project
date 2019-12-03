package Database;

import Model.Airport;
import Model.Flight;
import RequestResponse.GenerateItineraries;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CSVReader {
    private static AirportDatabase aDB = new AirportDatabase();
    private static FlightDatabase fDB = new FlightDatabase();
    public CSVReader(){}

    /**
     * Reads the text files
     * @param filename the test file being read
     * @throws IOException
     */
    public static void read_text(String filename) throws IOException {
        String[] line;
        RandomAccessFile file = new RandomAccessFile(filename, "r");
        String l;
        while ((l = file.readLine()) != null) {
            line = l.split(",");
            switch (filename)
            {
                case "data/airportnames.txt":
                    aDB.AddData(new Airport(line[0],line[1]));
                    break;
                case "data/connections.txt":
                    aDB.setConnection(line[0],line[1]);
                    break;
                case "data/DelayTimes.txt":
                    aDB.setDelay(line[0],line[1]);
                    break;
                case "data/flights.txt":
                    fDB.AddFlight(new Flight(line[4],line[0],line[1],line[2],line[3],line[5]));
                    break;
                case "data/weather.txt":
                    String airportcode = line[0];
                    for (int i=1 ; i < line.length; i++)
                    {
                        if (i % 2 != 0 )
                        {
                            aDB.setWeather(airportcode,line[i],line[i+1]);
                        }
                    }
                    break;
            }
        }
    }

    /**
     * Reads csv File
     * @return Itinerary generation
     * @throws IOException
     */
    public static GenerateItineraries readCsv() throws IOException {
        Scanner csvReader = new Scanner(new FileReader("data/AFRS.csv"));
        String l = csvReader.nextLine();
        String[] line = l.split("/");
        switch (line[0])
        {
            case "Airport Code":
                line = csvReader.nextLine().split("/");
                while(line.length != 0)
                {
                    if (!line[0].equals("") && !line[0].equals("Flight Number")) {
                        if (line.length < 5) {
                            aDB.AddData(new Airport(line[0], line[1], line[2], line[3], ""));
                        }
                        else
                        {
                            aDB.AddData(new Airport(line[0], line[1], line[2], line[3], line[4]));
                        }
                    }
                    if(line[0].equals("Flight Number"))
                    {
                        break;
                    }
                    line = csvReader.nextLine().split("/");
                }

            case "Flight Number":
                line = csvReader.nextLine().split("/");
                while(csvReader.hasNext()) {
                    if (line[1] != null && !line[0].isEmpty()) {
                        fDB.AddFlight(new Flight(line[0], line[1], line[2], line[3], line[4], line[5]));
                        aDB.updateAirport(line[1],line[2]);
                    }
                    line = csvReader.nextLine().split("/");
                }
                break;
        }
        return new GenerateItineraries(fDB,aDB);
    }

    /**
     * Writes to csv file
     * @throws IOException
     */
    public static void writeCsv() throws IOException
    {
        FileWriter csvWriter = new FileWriter("data/AFRS.csv");

        csvWriter.write("Airport Code");
        csvWriter.write("/");
        csvWriter.write("Airport Name");
        csvWriter.write("/");
        csvWriter.write("DelayTime");
        csvWriter.write("/");
        csvWriter.write("ConnectionTime");
        csvWriter.write("/");
        csvWriter.write("Weather");
        csvWriter.write("\n");

        for (List <String> rowDt : aDB.ToString())
        {
            csvWriter.write(String.join("/", rowDt));
            csvWriter.write("\n");
        }

        csvWriter.write("\n");
        csvWriter.write("\n");
        csvWriter.write("\n");
        csvWriter.write("Flight Number");
        csvWriter.write("/");
        csvWriter.write("Origin");
        csvWriter.write("/");
        csvWriter.write("Destination");
        csvWriter.write("/");
        csvWriter.write("Departure Time");
        csvWriter.write("/");
        csvWriter.write("Arrival Time");
        csvWriter.write("/");
        csvWriter.write("Airfare");

        csvWriter.write("\n");

        for (List <String> rowDt : fDB.ToList())
        {
            csvWriter.write(String.join("/", rowDt));
            csvWriter.write("\n");
        }

        csvWriter.flush();
        csvWriter.close();

    }

    /**
     * Reads in a list from a given file
     * @param fileName the file name in which to read
     * @return an arraylist of strings to be parsed and sent to the correct database
     */
    public ArrayList<String> readListFromFile(String fileName){
        ArrayList<String> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while(scanner.hasNext()){
                String str = scanner.nextLine();
                if (!str.isEmpty())
                 list.add(str);
            }
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
        return list;
    }

    /**
     * writes a massive string to the specified storage file
     * @param StorageFileName storage file name
     * @param data the data string in its complete form
     */
    public boolean writeStringToFile(String StorageFileName, String data){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(StorageFileName));
            writer.write(data);
            writer.close();
            return true;
        } catch (IOException e){
            return false;
        }
    }
}
