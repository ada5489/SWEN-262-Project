package RequestResponse;

import Database.AirportDatabase;
import Database.FlightDatabase;
import Model.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GenerateItenaries {
    private FlightDatabase fDB;
    private AirportDatabase aDB;
    private TimeComparator TimeComparator;

    public GenerateItenaries(FlightDatabase fDB, AirportDatabase aDB)
    {
        this.fDB = fDB;
        this.aDB = aDB;
        TimeComparator = new TimeComparator();
    }

    public ArrayList<Itinerary> itineraries(String deptCode, String arrCode, int Connections)
    {
        ArrayList<Itinerary> itineraries = new ArrayList <>();
        switch (Connections){
            case 0:
                for(FlightInterface f : fDB.getFlights(deptCode,arrCode))
                {

                    itineraries.add(new Itinerary(f));
                }
                return itineraries;
            case 1:
                ArrayList<FlightInterface> flights = new ArrayList <>();
                ArrayList<String> list = (ArrayList <String>) aDB.getAirport(deptCode).neighbourList().stream().filter(
                        aDB.getAirport(arrCode).neighbourList()::contains).collect(Collectors.toList());
                if (!list.isEmpty())
                {
                    for (String s : list) {
                        for (FlightInterface f : fDB.getFlights(deptCode, s))
                        {
                            for(FlightInterface f1: fDB.getFlights(s, arrCode))
                            {
                                if(TimeComparator.compare(f.getArrivalTime(), f1.getDepartureTime()) > 0)
                                {
                                    flights.add(f);
                                    flights.add(f1);
                                    itineraries.add(new Itinerary(flights));
                                    flights = new ArrayList <>();
                                }
                            }
                        }
                    }
                }
        }
        return itineraries;
    }
}
