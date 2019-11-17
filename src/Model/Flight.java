package Model;

import java.util.Arrays;
import java.util.List;

public class Flight implements FlightInterface {
  private int airfare;
  private String arrivalTime;
  private String departureTime;
  private String origin;
  private String destination;
  private String flightNumber;

  /**
   * Creates the flight representation
   * @param airfare the amount it costs to board the flight
   * @param arrivalTime The flights arrival time
   * @param departureTime the flight's departure time
   * @param origin the flights originating airport code
   * @param destination the destination airport code
   * @param flightNumber the unique key that recognizes it as a flight
   */
  public Flight (String flightNumber, String origin, String destination, String departureTime, String arrivalTime, String airfare){
  this.airfare = Integer.parseInt(airfare);
  this.arrivalTime = arrivalTime;
  this.departureTime = departureTime;
  this.origin = origin;
  this.destination = destination;
  this.flightNumber = flightNumber;
  }

  /**
   * calculates the airfare
   */
  public int getAirfare(){
    return airfare;
  }


  /**
   * gets the arrival time(s)
   * @return arrival time
   */
  public String getArrivalTime(){
    return arrivalTime;
  }

  /**
   * gets the departure time
   * @return the departure time
   */
  public String getDepartureTime(){
    return departureTime;
  }

  /**
   * gets the origin's 3 letter airport code
   * @return the 3 letter airport code
   */
  public String getOrigin(){
    return origin;
  }

  /**
   * gets the destination airport code
   * @return the destination air port code 3 letters
   */
  public String getDestination(){
    return destination;
  }

  /**
   * gets the Flight number(s)
   * @return a string of the flight numbers
   */
  public String getFlightNumber(){
    return flightNumber;
  }

  public List<String> toArray()
  {
    String[] strs = {flightNumber, origin, destination, departureTime, arrivalTime, String.valueOf(airfare)};
    return Arrays.asList(strs);
  }


}
