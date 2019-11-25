package Model;

import java.util.List;

/**
 * A composite of flight interfaces treats many flights like
 * one whole trip.
 *
 */
public class Itinerary implements FlightInterface{

  private List<FlightInterface> flights;

  public Itinerary(List<FlightInterface> flights){
    this.flights = flights;
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
    StringBuilder str = new StringBuilder();
    for (FlightInterface fs :
        flights) {
      str.append(fs.getFlightNumber()).append(",");
    }
    return str.toString();
  }

  /**
   * If the itinerary objects share the same flightnumbers the itinerary's are equal
   * more suited to check to see if reservations or something simmilar is the same
   * @param itinerary itinerary to be checked
   * @return
   */
  public boolean equals(Itinerary itinerary){
    return getFlightNumber().equals(itinerary.getFlightNumber());
  }

  public String toString()
  {
    StringBuilder s = new StringBuilder();
    s.append("Flight Itinerary = FLights: ");
    for (FlightInterface f : flights)
    {
      s.append(f.getFlightNumber()).append(", ");
    }
    return s.toString();
  }


}
