package Database;


import Model.Flight;
import Model.FlightInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FlightDatabase {

    HashMap <String, Flight> flightsDb;

    /**
     * Creates a new Flight Database
     */
    public FlightDatabase()
    {
        flightsDb = new HashMap <>();
    }

    /**
     * Gets specific flight based of its ID
     * @param flightID the flight ID
     * @return the flight
     */
    public Flight GetData(String flightID) {
        return flightsDb.get(flightID);
    }

    /**
     * Adds a flight to the database
     * @param flight the flight being added
     */
    public void AddFlight(Flight flight) {
        flightsDb.put(flight.getFlightNumber(), flight);
    }

    /**
     * Converts the Database to a list of flights as arrays
     * @return the database as a list of flights as arrays
     */
    public List<List <String>> ToList() {
        List <List<String>> rows = new ArrayList <>();
        for (Flight flight : flightsDb.values())
        {
            rows.add(flight.toArray());
        }
        return rows;
    }

    /**
     * Gets all flights with said departure and arrival airport
     * @param dept the departure airport code
     * @param arr the arrival airport code
     * @return list fo all flights that match the query
     */
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
}
