package RequestResponse;

import Model.Itinerary;

/**
 * Adds a flight reservation is subject to change name.
 * adds a flight to a persons itinerary
 */
public class ReservationRequest implements Request {

  private String passenger;
  private Itinerary itin;

  public ReservationRequest(){
    //todo
  }


  @Override
  public Response handle() {
    return null;
  }
}