package RequestResponse.Requests;

import Model.Airport;
import RequestResponse.Responses.AirportInfoResponse;

public class AirportInfoRequest implements Request {

  public AirportInfoResponse handle(){

    return new AirportInfoResponse();
  }

}
