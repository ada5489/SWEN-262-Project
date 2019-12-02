package Database;

import Database.AirportDatabase;
import Database.FlightDatabase;
import Model.Itinerary;
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
   * the delegated
   * @param name
   * @param it
   * @return
   */
  public boolean makeReservation(String name, Itinerary it){
    return rdb.createReservation(name,it);
  }









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
