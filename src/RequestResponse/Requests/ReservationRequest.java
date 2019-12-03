package RequestResponse.Requests;

import Model.Itinerary;
import RequestResponse.Requests.Request;
import RequestResponse.Responses.ReservationResponse;
import RequestResponse.Responses.Response;
import Database.DataBaseManager;

/**
 * Author: Rob Maron
 * Adds a flight reservation is subject to change name.
 * adds a flight to a persons itinerary
 */
public class ReservationRequest implements Request {

    private String passenger;
    private Itinerary itin;
    
    private DataBaseManager db;

    public ReservationRequest(DataBaseManager db_, int itinID, String passenger_){
	this.db = db_;
	this.passenger = passenger_;
	
	this.itin = db.getItinerarywithId(itinID);
    }

  @Override
  public Response handle() {
      boolean success = this.db.makeReservation(this.passenger, this.itin);
      ReservationResponse _response = new ReservationResponse(success);

      return _response;
  }
}
