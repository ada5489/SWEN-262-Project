package RequestResponse;

import Database.AirportDatabase;
import Database.FlightDatabase;
import Model.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GenerateItineraries {
    private FlightDatabase fDB;
    private AirportDatabase aDB;
    private TimeComparator TimeComparator;

    public GenerateItineraries(FlightDatabase fDB, AirportDatabase aDB)
    {
        this.fDB = fDB;
        this.aDB = aDB;
        TimeComparator = new TimeComparator();
    }

    public ArrayList<Itinerary> itineraries(String deptCode, String arrCode, int Connections)
    {
        ArrayList<Itinerary> itineraries = new ArrayList <>();
        switch (Connections){
            case 0:
                for(FlightInterface f : fDB.getFlights(deptCode,arrCode))
                {
                    itineraries.add(new Itinerary(f));
                }
                return itineraries;
            case 1:
                ArrayList<FlightInterface> flights = new ArrayList <>();
                ArrayList<String> list = connections(deptCode,arrCode);
                if (!list.isEmpty())
                {
                    for (String s : list) {
                        for (FlightInterface f : fDB.getFlights(deptCode, s))
                        {
                            for(FlightInterface f1: fDB.getFlights(s, arrCode))
                            {
                                int num = aDB.getAirport(s).getConnectionTime() + aDB.getAirport(s).getDelaytime();
                                checkTime(f,f1,flights,itineraries,num);
                                flights = new ArrayList <>();
                            }
                        }
                    }
                }
                break;
            case 2:
                ArrayList<FlightInterface> flightss = new ArrayList <>();
                ArrayList<String> airports = aDB.hasNeighbour(arrCode);
                for (String s : aDB.getAirport(deptCode).neighbourList())
                {
                    ArrayList<String> neigh = (ArrayList <String>) aDB.getAirport(s).neighbourList().stream().filter(
                            airports::contains).collect(Collectors.toList());
                    if(!neigh.isEmpty())
                    {
                        for(FlightInterface f : fDB.getFlights(deptCode,s))
                        {
                            for(String s3 : neigh)
                            {
                                for(FlightInterface f1: fDB.getFlights(s, s3))
                                {
                                    int num = aDB.getAirport(s3).getConnectionTime() + aDB.getAirport(s3).getDelaytime();
                                    if(checkTime(f,f1,flightss,num)) {
                                        for (FlightInterface f2 : fDB.getFlights(s3, arrCode)) {
                                            int num1 = aDB.getAirport(arrCode).getConnectionTime() + aDB.getAirport(arrCode).getDelaytime();
                                            if(checkTime(f1, f2, flightss, num1)) {
                                                itineraries.add(new Itinerary(flightss));
                                                ArrayList<FlightInterface> fl = new ArrayList <>();
                                                fl.add(f);
                                                fl.add(f1);
                                                flightss = fl;
                                            }
                                        }
                                    }
                                    if (flightss.size() == 2) {flightss.remove(1);}
                                }
                            }
                            if (flightss.size() == 1) {flightss.remove(0);}
                        }
                    }
                }
            }
        return itineraries;
    }

    private ArrayList<String> connections(String dept, String arr)
    {
        return (ArrayList <String>) aDB.getAirport(dept).neighbourList().stream().filter(
                aDB.getAirport(arr).neighbourList()::contains).collect(Collectors.toList());
    }

    private void checkTime(FlightInterface f, FlightInterface f1, ArrayList<FlightInterface> flights, ArrayList<Itinerary> itineraries, Integer num)
    {
        if(TimeComparator.compare(f.getArrivalTime()  , f1.getDepartureTime(), num) < 0)
        {
            flights.add(f);
            flights.add(f1);
            itineraries.add(new Itinerary(flights));
        }
    }

    private boolean checkTime(FlightInterface f, FlightInterface f1, ArrayList<FlightInterface> flights,Integer num)
    {
        if(TimeComparator.compare(f.getArrivalTime(), f1.getDepartureTime(), num) < 0)
        {
            if(flights.contains(f)) {
                flights.add(f1);
            }
            else
            {
                flights.add(f);
                flights.add(f1);
            }
            return true;
        }
        return false;
    }

}



