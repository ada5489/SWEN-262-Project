package Database;


import Model.Flight;

import java.util.ArrayList;

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
}
