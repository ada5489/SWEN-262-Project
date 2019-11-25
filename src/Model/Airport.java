package Model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Weather{
    private String name;
    private String temperature;
    Weather(String name, String temperature)
    {
        this.name = name;
        this.temperature = temperature;
    }

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

    public Airport(String code, String name, String Delaytime, String ConnectionTime, String wea )
    {
        this.name = name;
        airportcode = code;
        weathers = new ArrayList <>();
        this.Delaytime = Integer.parseInt(Delaytime);
        this.ConnectionTime = Integer.parseInt(ConnectionTime);
        parseWeather(wea);

    }

    public Airport(String code, String name)
    {
        this.name = name;
        airportcode = code;
        weathers = new ArrayList <>();
    }

    public void addWeather(String name, String temp){
        weathers.add(new Weather(name,temp));
    }

    public String getWeather(int count){
	return weathers.get(count % (weathers.size() - 1)).toString();
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
}
