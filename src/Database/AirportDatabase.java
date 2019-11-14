package Database;

import Model.Airport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AirportDatabase {
    HashMap<String,Airport> airpotsDb;

    public AirportDatabase()
    {
        airpotsDb = new HashMap <>();
    }

    public Airport GetData(Airport airport) {
        return null;
    }

    public void setConnection(String airportcode, String time) {
        airpotsDb.get(airportcode).setConnectionTime(time);
    }

    public void setDelay(String airportcode, String time) {
        airpotsDb.get(airportcode).setDelaytime(time);
    }

    public void setWeather(String airportcode, String wName, String temp)
    {
        airpotsDb.get(airportcode).addWeather(wName,temp);
    }


    public void AddData(Airport airport) {
         airpotsDb.put(airport.getAirportcode(), airport);
    }

    public Airport DeleteData(Airport airport) {
        return null;
    }

    public List<List<String>> ToString() {
        List <List<String>> rows = new ArrayList <>();
        for (Airport airport : airpotsDb.values())
        {
            rows.add(airport.toArray());
        }

        return rows;
    }
}
