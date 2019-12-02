package Database;

import Model.Flight;
import Model.FlightInterface;
import Model.Itinerary;
import Model.Reservation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ReservationDatabase {
  private List<Reservation> reservations;
  private HashMap<String, List<Reservation>> userReservations; //might just do the list. can add for more efficency
  private String fileName = "data/reservation.txt";


  public ReservationDatabase(){
    readInReservations();
  }



  public void readInReservations(){
    userReservations = new HashMap<>();



    //CSVREADER reading in the list to populate the private data


  }

  /**
   * The method the request response uses to make a new reservation.
   * @param name the name of the person making the reservation
   * @param it the chosen itinerary
   * @return true if it is a unique reservation false if it already exists.
   */
  public boolean createReservation(String name, Itinerary it){
    for (Reservation res :
        reservations) {
       if (res.equals(name, it)) {
          return false;
        }
      }
    Reservation newRes = new Reservation(it, name);
    reservations.add(newRes);
    return true;
  }

  /**
   * makes a resevation from one line of the stored reservations on start up and initialization
   *
   * @param stringLineFromFile the line from the flat storage file
   * @return a reservation
   */
  public Reservation makeReservation(String stringLineFromFile){
    String[] vals = stringLineFromFile.split(",");
    String name = vals[0];
    String[] flights = Arrays.copyOfRange(vals,1,vals.length);
    Itinerary it = new Itinerary(partitionFlightsFromString(flights));
    Reservation reservation = new Reservation(it,name);
    return reservation;
    //Reservation res = new Reservation()
  }

  /**
   * this method takes in a string array of itinerary only not the person
   * Does not connect it to a passenger for a reservation.
   * It gets the itinerary of a single passenger.
   * @param flightPieces the coppy of parsed array in the
   * @return a List of FlightInterFaces to be made into an itinerary
   */
  public static ArrayList<FlightInterface> partitionFlightsFromString(String[] flightPieces){
    int flightValues = 6;
    int numFlights = flightPieces.length /6;
    int minIndex, maxIndex;
    ArrayList itinerary = new ArrayList<FlightInterface>();
    for (int i = 0; i < numFlights; i++) {
      minIndex = i* flightValues;
      maxIndex = minIndex + flightValues;
      String[] flightInfo = Arrays.copyOfRange(flightPieces, minIndex, maxIndex);
      Flight fl = new Flight(flightInfo[0], flightInfo[1],flightInfo[2],flightInfo[3],
          flightInfo[4], flightInfo[5]);
      itinerary.add(fl);
    }
    return itinerary;

  }

  public static void main(String[] args){
    //SFO,LAS,6:50p,8:26p,100,66
    //SFO,LAS,6:50p,8:26p,100,66,LAX,LAS,9:45p,11:02p,113,96
    //100/SFO/LAS/6:50p/8:26p/66
    //101/ATL/MCO/10:18p/11:45p/93
    String[][] flightTest = {
        {"100", "SFO", "LAS", "6:50p", "8:36p", "66"},
        {"100", "SFO", "LAS", "6:50p", "8:36p", "66", "101", "ATL", "MCO", "10:18p", "11:45p","93"}
    };
    for (String[] flightTests :
        flightTest) {
      for (FlightInterface f:
      partitionFlightsFromString(flightTests)) {
        System.out.println(f.toString());

      }

    }
  }




}
