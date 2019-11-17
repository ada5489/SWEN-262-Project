package Database;


import Model.Flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FlightDatabase {

    ArrayList <Flight> flightsDb;

    public FlightDatabase()
    {
        flightsDb = new ArrayList <>();
    }

    public Flight GetData(String flightID) {
        return null;
    }

    public Flight UpdateData(Flight flight) {
        return null;
    }

    public void AddFlight(Flight flight) {
        flightsDb.add(flight);
    }

    public Flight DeleteData(Flight flight) {
        return null;
    }

    public List<List <String>> ToList() {
        List <List<String>> rows = new ArrayList <>();
        for (Flight flight : flightsDb)
        {
            rows.add(flight.toArray());
        }
        return rows;
    }

    public void clear()
    {
        flightsDb = new ArrayList <>();
    }
}
