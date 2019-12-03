package Model;
import java.util.*;

class Weather{
    private String name;
    private String temperature;

    /**
     * Creates a new Weather
     * @param name weather name
     * @param temperature temperature
     */
    Weather(String name, String temperature)
    {
        this.name = name;
        this.temperature = temperature;
    }

    /**
     * Writes weather in string form
     * @return weather in string form
     */
    public String toString()
    {
        return name + "," + temperature;
    }
}

public class Airport {
    private String name;
    private ArrayList<Weather> weathers;
    private int Delaytime;
    private int ConnectionTime;
    private String airportcode;
    private HashSet <String> neighbours;

    /**
     * Creates a new Airport
     * @param code the airport code
     * @param name the airport code
     * @param Delaytime the airport delay time
     * @param ConnectionTime the airport connection time
     * @param wea the airport weathers
     */
    public Airport(String code, String name, String Delaytime, String ConnectionTime, String wea )
    {
        this.name = name;
        airportcode = code;
        weathers = new ArrayList <>();
        this.Delaytime = Integer.parseInt(Delaytime);
        this.ConnectionTime = Integer.parseInt(ConnectionTime);
        neighbours = new HashSet <>();
        parseWeather(wea);

    }

    /**
     * Creates a new Airport
     * * @param code the airport code
     * @param name the airport code
     */
    public Airport(String code, String name)
    {
        this.name = name;
        airportcode = code;
        weathers = new ArrayList <>();
    }

    /**
     * Adds weathers to the airport weather
     * @param name the weather name
     * @param temp the temperature
     */
    public void addWeather(String name, String temp){
        weathers.add(new Weather(name,temp));
    }

    /**
     * Gets the airport weather at that time
     * @param count count to get weather
     * @return the current weather
     */
    public String getWeather(int count){
	return weathers.get(count % (weathers.size() - 1)).toString();
    }

    /**
     * Sets airport delay time
     * @param delaytime the delay time
     */
    public void setDelaytime(String delaytime) {
        Delaytime = Integer.parseInt(delaytime);
    }

    /**
     * Gets the airport delay time
     * @return the delay time
     */
    public Integer getDelaytime() {
        return Delaytime;
    }

    /**
     * Sets the airport connection tome
     * @param connectionTime the connection time
     */
    public void setConnectionTime(String connectionTime) {
        ConnectionTime = Integer.parseInt(connectionTime);
    }

    /**
     * gets the airport code
     * @return the airport code
     */
    public String getAirportcode() {
        return airportcode;
    }

    /**
     * Converts the weather string to weathers to add to airport
     * @param WS the weathers in string
     */
    private void parseWeather(String WS)
    {
        for (String s: WS.split("&")
             ) {
            String[] weath = s.split(",");
            if (weath.length == 2)
            {
            weathers.add(new Weather(weath[0],weath[1]));
                }
        }
    }

    /**
     * Adds neighbour to the airport. Neighbour is another airport that airport flies to
     * @param code the neighbour airport
     */
    public void addNeighbour(String code)
    {
        neighbours.add(code);
    }

    /**
     * Checks if the airport is a neighbour of this airport
     * @param airportcode the airport being checked
     * @return yes if a neighbour
     *         no if its not
     */
    public boolean hasNeighbour(String airportcode)
    {
        return neighbours.contains(airportcode);
    }

    /**
     * @return the airports neighbour list
     */
    public HashSet<String> neighbourList()
    {
        return neighbours;
    }

    /**
     * Converts the airport to array
      * @return List of strings representing the airport object
     */
    public List<String> toArray()
    {
        ArrayList<String> list = new ArrayList <>();
        for(Weather w : weathers )
        {
            list.add(w.toString());
        }
         String[] strs = {airportcode, name, String.valueOf(Delaytime), String.valueOf(ConnectionTime), String.join("&", list)};
        return Arrays.asList(strs);
    }

    /**
     * Gets the airport connection time
     * @return the airport connection time
     */
    public int getConnectionTime() {
        return ConnectionTime;
    }
}
