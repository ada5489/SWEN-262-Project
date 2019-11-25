package RequestResponse;

import Database.AirportDatabase;
import Database.FlightDatabase;
import Model.Flight;
import Model.FlightInterface;
import Model.Itinerary;
import java.util.ArrayList;

public class GenerateItenaries {
    private FlightDatabase fDB;
    private AirportDatabase aDB;

    public GenerateItenaries(FlightDatabase fDB, AirportDatabase aDB)
    {
        this.fDB = fDB;
        this.aDB = aDB;
    }

    public ArrayList<Itinerary> itineraries(String deptCode, String arrCode)
    {
        int num = 0;
        ArrayList<Itinerary> itenaries = new ArrayList <>();
        for(Flight f : fDB.getAirportFlights(deptCode))
        {
            ArrayList<FlightInterface> flights = new ArrayList <>();
            flights.add(f);
            while(num < 2)
            {
                if(f.getDestination().equals(arrCode) && flights.size() == 0)
                {
                    itenaries.add(new Itinerary(flights));
                    break;
                }
                else if (f.getDestination().equals(arrCode) && flights.size() != 0) {
                    flights.add(f);
                    itenaries.add(new Itinerary(flights));
                    break;
                }
                else {
                    for (Flight f1 : fDB.getAirportFlights(f.getDestination())) {
                        f = f1;
                        break;
                    }
                    num ++;
                }
            }
        }
        for (Itinerary i : itenaries)
        {
            if (!i.getDestination().equals(arrCode))
            {
                itenaries.remove(i);
            }
        }
        return itenaries;
    }

    public void generator()
    {

    }
}
