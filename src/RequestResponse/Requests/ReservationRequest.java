package RequestResponse.Requests;

import Model.Itinerary;
import RequestResponse.Requests.Request;
import RequestResponse.Responses.Response;

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
