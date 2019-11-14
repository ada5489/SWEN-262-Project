package Model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Weather{
    private String name;
    private String temperature;
    public Weather(String name, String temperature)
    {
        this.name = name;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public String getTemperature() {
        return temperature;
    }
}
public class Airport {
    private String name;
    private ArrayList<Weather> weathers;
    private int Delaytime;
    private int ConnectionTime;
    private String airportcode;

    public Airport(String name, String code)
    {
        this.name = name;
        airportcode = code;
        weathers = new ArrayList <>();
    }

    public String getName() {
        return name;
    }

    public void addWeather(String name, String temp){
        weathers.add(new Weather(name,temp));
    }

    public void setDelaytime(String delaytime) {
        Delaytime = Integer.parseInt(delaytime);
    }

    public void setConnectionTime(String connectionTime) {
        ConnectionTime = Integer.parseInt(connectionTime);
    }

    public String getAirportcode() {
        return airportcode;
    }

    public int getDelaytime() {
        return Delaytime;
    }

    public int getConnectionTime() {
        return ConnectionTime;
    }

    public ArrayList<Weather> getWeathers()
    {
        return weathers;
    }

    public List<String> toArray()
    {
        String weather_strs = "";
        for(Weather w : weathers )
        {
            weather_strs += String.join(",","[" + w.getName()+ "," + w.getTemperature() + "]");
        }
         String[] strs = {airportcode, name, String.valueOf(Delaytime), String.valueOf(ConnectionTime), weather_strs};
         List <String> list = Arrays.asList(strs);
         return list;
    }
}
