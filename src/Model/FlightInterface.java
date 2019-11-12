package Model;

public interface FlightInterface {

/**
 * calculates the airfare
 */
  int getAirfare();


  /**
   * gets the arrival time(s)
   * @return arrival time
   */
  String getArrivalTime();

  /**
   * gets the departure time
   * @return the departure time
   */
  String getDepartureTime();

  /**
   * gets the origin's 3 letter airport code
   * @return the 3 letter airport code
   */
  String getOrigin();

  /**
   * gets the destination airport code
   * @return the destination air port code 3 letters
   */
  String getDestination();

  /**
   * gets the Flight number(s)
   * @return a string of the flight numbers
   */
  String getFlightNumber();

}
