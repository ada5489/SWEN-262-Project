package Database;

import Database.AirportDatabase;
import Database.FlightDatabase;
import Model.Itinerary;
import Model.Reservation;
import RequestResponse.GenerateItineraries;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.IO;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.IIOException;


public class DataBaseManager {

  private AirportDatabase adb;
  private FlightDatabase fdb;
  private ReservationDatabase rdb;
  private GenerateItineraries git;
  private ArrayList<Itinerary> itineraries; //this is the list of returned itineraries when prompted
  private static  CSVReader reader;


  public DataBaseManager(){

    try {
      git = reader.readCsv();
    } catch (IOException e){
      System.out.println("failed to load");
    }
    this.rdb = new ReservationDatabase();
    this.adb = new AirportDatabase();
    this.fdb = new FlightDatabase();

  }
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

  public ArrayList generateItineraries(String dept, String arival,int numconnnections){
    itineraries = git.itineraries(dept,arival,numconnnections);
    return itineraries;
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
