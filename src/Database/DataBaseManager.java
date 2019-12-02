package Database;

import Database.AirportDatabase;
import Database.FlightDatabase;
import Model.Itinerary;
import Model.Reservation;
import java.util.ArrayList;
import java.util.List;


public class DataBaseManager {

  private AirportDatabase adb;
  private FlightDatabase fdb;
  private ReservationDatabase rdb;
  private List<Itinerary> itineraries; //this is the list of returned itineraries when prompted


  public DataBaseManager(AirportDatabase abd,FlightDatabase fdb, ReservationDatabase rdb ){
    this.adb = abd;
    this.fdb = fdb;
    this.rdb = rdb;
    itineraries = new ArrayList<>();
  }
  //all purpose methods
  public Itinerary getItinerarywithId(int id){
    return itineraries.get(id-1);
  }
  // the Reservation database methods for the (facade)

  /**
   * makes the reservation checks to make sure
   * @param name
   * @param idInList the location of the itinerary in the returned list
   * @return
   */
  public boolean makeReservation(String name, int idInList){
    if(idInList > itineraries.size()){
      return false;
    }
    return makeReservation(name, getItinerarywithId(idInList));
  }

  /**
   * overload of makeReservation uses the actual itinerary method
   * @param name passenger
   * @param it itinerary
   * @return
   */
  public boolean makeReservation(String name, Itinerary it){
    return rdb.createReservation(name,it);
  }

  /**
   * Facade entry point for deletion of a reservation.
   * @param passenger passenger name
   * @param origin origin name code
   * @param dest destination code
   * @return true if it was a successful deletion, false if it was not found or unsuccessful
   */
  public boolean deleteReservation(String passenger, String origin, String dest){
    return rdb.deleteReservation(passenger,origin,dest);
  }

  /**
   * for the retrieve command
   * @param name the name of the passenger
   * @param origin the origin code airport
   * @param dest the destination is exceptable to pass it EMPTY STRINGS if no optional args were given
   * @return the list of found reservations matching the query
   */
  public List<Reservation> findReservations(String name, String origin, String dest){
    return rdb.findReservation(name,origin,dest);
  }
  //end Reservation database methods for the facade




  public AirportDatabase getAdb()
  {
    return adb;
  }
  public FlightDatabase getFdb()
  {
    return fdb;
  }

  public ReservationDatabase getRdb() {
    return rdb;
  }
}
