package Database;


import Model.Flight;
import Model.FlightInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FlightDatabase {

    HashMap <String, Flight> flightsDb;

    public FlightDatabase()
    {
        flightsDb = new HashMap <>();
    }

    public Flight GetData(String flightID) {
        return flightsDb.get(flightID);
    }

    public void AddFlight(Flight flight) {
        flightsDb.put(flight.getFlightNumber(), flight);
    }

    public List<List <String>> ToList() {
        List <List<String>> rows = new ArrayList <>();
        for (Flight flight : flightsDb.values())
        {
            rows.add(flight.toArray());
        }
        return rows;
    }

    public HashSet<FlightInterface> getFlights(String dept, String arr)
    {
        HashSet<FlightInterface> flights = new HashSet <>();
        for(Flight f : flightsDb.values())
        {
            if(f.getOrigin().equals(dept) && f.getDestination().equals(arr))
            {
                flights.add(f);
            }
        }
        return flights;
    }
    public ArrayList<Flight> getAirportFlights(String AirportCode)
    {
        ArrayList<Flight> flights = new ArrayList <>();
        for(Flight f : flightsDb.values())
        {
            if (f.getOrigin().equals(AirportCode))
            {
                flights.add(f);
            }
        }
        return flights;
    }
}
