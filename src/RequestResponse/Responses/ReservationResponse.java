package RequestResponse.Responses;


import Model.Itinerary;
import RequestResponse.Responses.Response;

public class ReservationResponse implements Response {

 // private DatabaseManager db;
  private Itinerary itinerary;
  private int id;
  private String passenger;
 public ReservationResponse(String passenger, int id //, DatabaseManager db)
 ){
  this.id = id;
  this.passenger = passenger;

 }

  @Override
  public String outputData() {


    return null;
  }
}
