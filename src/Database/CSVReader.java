package Database;

import Model.Airport;
import Model.Flight;

import java.io.*;
import java.util.List;


public class CSVReader {
    private static AirportDatabase aDB = new AirportDatabase();
    private static FileWriter csvWriter;

    static {
        try {
            csvWriter = new FileWriter("data/AFRS.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  FileReader csvReader = new FileReader("data/AFRS.csv");
    private static FlightDatabase fDB = new FlightDatabase();

    public CSVReader() throws IOException {
    }

    public static void read_text(String filename) throws IOException {
        String[] line;
        RandomAccessFile file = new RandomAccessFile(filename, "r");
        String l;
        while ((l = file.readLine()) != null) {
            line = l.split(",");
            switch (filename)
            {
                case "data/airportnames.txt":
                    aDB.AddData(new Airport(line[1],line[0]));
                    break;
                case "data/connections.txt":
                    aDB.setConnection(line[0],line[1]);
                    break;
                case "data/DelayTimes.txt":
                    aDB.setDelay(line[0],line[1]);
                    break;
                case "data/flights.txt":
                    fDB.AddFlight(new Flight(line[5],line[3],line[2],line[0],line[1],line[4]));
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

    public static void start()
    {

    }

    private void readCsv()
    {

    }

    public static void writeCsv() throws IOException
    {
        csvWriter.append("Airports\n");
        csvWriter.append("Airport Code");
        csvWriter.append("|");
        csvWriter.append("Airport Name");
        csvWriter.append("|");
        csvWriter.append("DelayTime");
        csvWriter.append("|");
        csvWriter.append("ConnectionTime");
        csvWriter.append("|");
        csvWriter.append("Weather");
        csvWriter.append("\n");

        for (List<String> rowData : aDB.ToString())
        {
            csvWriter.append(String.join("|", rowData));
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }

}
