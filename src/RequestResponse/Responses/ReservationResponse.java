package RequestResponse.Responses;


import Model.Itinerary;
import RequestResponse.Responses.Response;

/*
 * Author: Rob Maron
 */

public class ReservationResponse implements Response {
    private String outputString;
    
    public ReservationResponse(boolean _success){
	if(_success){
	    this.outputString = "You have successfully created a reservation.";

	} else {
	    this.outputString = "Reservation was not created successfully.";
	}
    }

    @Override
    public String outputData() {
	return outputString;
    }
}
