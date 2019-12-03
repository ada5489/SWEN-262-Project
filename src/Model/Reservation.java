package Model;

/**
 * holds info about a passenger and their travel itinerary
 */
public class Reservation {
  private Itinerary itinerary;
  private String passengerName;

  /**
   * Constructor for the Reservation class takes in an itinerary and
   * @param it the itinerary
   * @param passengerName the passenger or users name associated manner
   */
  public Reservation(Itinerary it, String passengerName){
    itinerary = it;
    this.passengerName = passengerName;
  }

  /**
   * getter for the itinerary
   * @return the itinerary associated with the passenger
   */
  public Itinerary getItinerary() {
    return itinerary;
  }

  /**
   * a getter for the passenger name
   * @return the name
   */
  public String getPassengerName() {
    return passengerName;
  }

  /**
   * gets the itinerary's origin
   * @return the airport code for the origin
   */
  public String getOrigin(){
    return itinerary.getOrigin();
  }
  public String getDestination(){
    return  itinerary.getDestination();
  }

  /**
   * returns if the reservation starts ends and is made by the same passenger
   * @param name passenger name
   * @param origen origin airport code
   * @param dest destination airport code
   * @return
   */
  public boolean isSameReservation(String name, String origen, String dest){
    return this.getPassengerName().equals(name)
        && this.getOrigin().equals(origen)
        && this.getDestination().equals(dest);
  }
  /**
   * returns if two reservations are the same
   * @param passengerName the passenger name
   * @param itinerary the itinerary of the associated passenger
   * @return if they share the same flight paths and name.
   */
  public boolean equals(String passengerName, Itinerary itinerary){
    return passengerName.equals(getPassengerName()) && itinerary.equals(getItinerary());
  }
}
