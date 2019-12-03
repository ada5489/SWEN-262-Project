package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * A composite of flight interfaces treats many flights like
 * one whole trip.
 *
 */
public class Itinerary implements FlightInterface{

  private List<FlightInterface> flights;
  private int connections;

  public Itinerary(List<FlightInterface> flights){
    this.flights = flights;
    connections = flights.size();
  }
  /**
   * calculates the total airfare
   */
  public int getAirfare(){
    int totalAirFare = 0;
    for (FlightInterface fs: flights
    ) {
        totalAirFare+= fs.getAirfare();
    }
    return totalAirFare;
  }


  /**
   * gets the arrival time of the last flight in the itinerary
   * @return arrival time of the last flight and as the iterary as a whole
   */
  public String getArrivalTime(){
    return flights.get(flights.size()-1).getArrivalTime();
  }

  /**
   * gets the departure time of the first flight
   * @return the departure time of the trip as a whole
   * @precondition: there is a flight in the itinerary.
   */
  public String getDepartureTime(){
    return flights.get(0).getDepartureTime();
  }

  /**
   * gets the origin's 3 letter airport code
   * @return the 3 letter airport code of the first airport visited
   */
  public String getOrigin(){
    return flights.get(0).getOrigin();
  }

  /**
   * gets the destination airport code
   * @return the destination air port code 3 letters
   */
  public String getDestination(){
    return flights.get(flights.size()-1).getDestination();
  }

  /**
   * gets the Flight number(s)
   * @return a string of the flight numbers
   */
  public String getFlightNumber(){
    String str = "";
    for (FlightInterface fs :
        flights) {
      str += fs.getFlightNumber() + ",";
    }
    return str;
  }

  /**
   * If the itinerary objects share the same flightnumbers the itinerary's are equal
   * more suited to check to see if reservations or something simmilar is the same
   * @param itinerary itinerary to be checked
   * @return if the itineraries start and end at the same spot
   */
  public boolean equals(Itinerary itinerary){
    return getOrigin().equals(itinerary.getOrigin()) &&
            getDestination().equals(itinerary.getDestination());
  }

  /**
   * returns the properly formatted return string for file storage
   * @return
   */
  public String toCSV(){
    String str = "";
    for (int i = 0; i < flights.size(); i++) {
      FlightInterface flight = flights.get(i);
      if (i != flights.size()-1)
      str += flight.toCSV()+",";
      else str += flight.toCSV();

    }
    return str;
  }

  /**
   * returns the correct displaying version of an itinerary with all the correct information
   * in an easy and understandable package.
   * @return
   */
  public String toString(){
    String str = "";
    str += "Flight Numbers: "  + getFlightNumber() + " Leaving from " + getOrigin() +
          " At time:" + getDepartureTime() + " Arriving finally at airport: " + getDestination()
            + " at Time:" + getArrivalTime() + " Costing a total of " + getAirfare() +"$";

    return str;

  }
//  public static void main(String[] args){
//    FlightInterface guy = new Flight("287", "JFK", "PIT", "12","11", "164");
//    FlightInterface guy2 = new Flight("288", "PIT", "JFK", "12:01a","11:02p", "164");
//    List flights = new ArrayList();
//    flights.add(guy);
//    flights.add(guy2);
//    Itinerary it = new Itinerary(flights);
//    System.out.println(it);
//
//  }


}
