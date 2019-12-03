package UI;

import Database.CSVReader;
import Database.DataBaseManager;
import Model.Airport;
import RequestResponse.Requests.AirportInfoRequest;

/**
 * Author Evan Nolan & Rob Maron
 */
public class RequestParser {
    private DataBaseManager dataBaseManager;

    private CSVReader csvReader = new CSVReader();


    public String invalidRequest = "Error, Unknown request type or command";
    private String partialRequest = null;
n
    public RequestParser(){
	dataBaseManager = new DataBaseManager();
    }


  /**
   * And Finally, to request information about a particular airport it is done:
   * Airport information request: airport, airport;
   * ●      airport is the three-letter code for the airport whose information is requested
   * @param input the command and other part;
   * @return the airport info request and sends it off.
   */
    public AirportInfoRequest airportInfoRequest(String input){
	String[] parts = input.split(",");
	switch(parts[0]){
	case "info":
	    break;
	case "reserve":
	    break;
	case "retrieve":
	    break;
	case "delete":
	    break;
	case "airport":
	    break;
	case "default":
	    System.out.println("Invalid request!");
	    break;
	}
     // return new AirportInfoRequest(airport,DataBaseManager);

//    return new AirportInfoRequest(dataBaseManager);
	return null;
    }
}
