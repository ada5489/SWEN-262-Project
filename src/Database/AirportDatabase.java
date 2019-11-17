package Database;

import Model.Airport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AirportDatabase {

    HashMap<String,Airport> airportsDb;

    public AirportDatabase()
    {
        airportsDb = new HashMap <>();
    }

    public void setConnection(String airportcode, String time) {
        airportsDb.get(airportcode).setConnectionTime(time);
    }

    public void setDelay(String airportcode, String time) {
        airportsDb.get(airportcode).setDelaytime(time);
    }

    public void setWeather(String airportcode, String wName, String temp)
    {
        airportsDb.get(airportcode).addWeather(wName,temp);
    }

    public void AddData(Airport airport) {
         airportsDb.put(airport.getAirportcode(), airport);
    }

    public List<List<String>> ToString() {
        List <List<String>> rows = new ArrayList <>();
        for (Airport airport : airportsDb.values())
        {
            rows.add(airport.toArray());
        }
        return rows;
    }

    public void clear()
    {
        airportsDb = new HashMap <>();
    }
}
