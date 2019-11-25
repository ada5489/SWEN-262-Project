package Database;

import Model.Airport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AirportDatabase {

    HashMap<String,Airport> airportsDb;
    private int timesCalled;

    public AirportDatabase()
    {
        airportsDb = new HashMap <>();
	this.timesCalled = 0;
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

    public String getWeather(String airport_code){
	this.timesCalled++;
	return airportsDb.get(airport_code).getWeather(timesCalled);
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

}
