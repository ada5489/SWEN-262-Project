package Database;


import Model.Flight;

import java.util.ArrayList;
import java.util.HashMap;
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
}
