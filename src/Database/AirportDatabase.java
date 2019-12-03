package Database;

import Model.Airport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AirportDatabase {

    private HashMap<String,Airport> airportsDb;
    private int timesCalled;

    /**
     * Creates the airport database
     */
    public AirportDatabase()
    {
        airportsDb = new HashMap <>();
	    this.timesCalled = 0;
    }

    /**
     * Sets the connection time for selected airport
     * @param airport selected airport code
     * @param time the connection time
     */
    public void setConnection(String airport, String time) {
        airportsDb.get(airport).setConnectionTime(time);
    }

    /**
     * Sets the delay time for selected airport
     * @param airport selected airport
     * @param time the delay time
     */
    public void setDelay(String airport, String time) {
        airportsDb.get(airport).setDelaytime(time);
    }

    /**
     * Sets the selected airports' weather
     * @param airport the selected airport
     * @param wName the weather name
     * @param temp the temperature
     */
    public void setWeather(String airport, String wName, String temp)
    {
        airportsDb.get(airport).addWeather(wName,temp);
    }

    /**
     * Gets the temperature of the airport at that time
     * @param airport_code the selected airport
     * @return the temperature at that time
     */
    public String getWeather(String airport_code){
	    this.timesCalled++;
	    return airportsDb.get(airport_code).getWeather(timesCalled);
    }

    /**
     * Finds airports that fly to selected airport
     * @param code the selected airport
     * @return list of airports that fly to selected airport
     */
    public ArrayList<String> hasNeighbour(String code)
    {
        ArrayList<String> list = new ArrayList <>();
        for(Airport airport : airportsDb.values())
        {
            if (airport.hasNeighbour(code))
            {
                list.add(airport.getAirportcode());
            }
        }
        return list;
    }

    /**
     * Gets a specific airport based on its code
     * @param airportCode selected airport code
     * @return the airport with that code
     */
    public Airport getAirport(String airportCode)
    {
        return airportsDb.get(airportCode);
    }

    /**
     * Adds neighbours to airports
     * @param code the selected airport
     * @param neighbor neighbour to add to that airport
     */
    public void updateAirport(String code, String neighbor)
    {
        airportsDb.get(code).addNeighbour(neighbor);
    }

    /**
     * Adds airport to the data base
     * @param airport the selected airport
     */
    public void AddData(Airport airport) {
         airportsDb.put(airport.getAirportcode(), airport);
    }

    /**
     * Writes the database to string form
     * @return the database in String
     */
    public List<List<String>> ToString() {
        List <List<String>> rows = new ArrayList <>();
        for (Airport airport : airportsDb.values())
        {
            rows.add(airport.toArray());
        }
        return rows;
    }

}
