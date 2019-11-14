package Model;

public class Itenary implements FlightInterface {
    /**
     * calculates the airfare
     */
    @Override
    public int getAirfare() {
        return 0;
    }

    /**
     * gets the arrival time(s)
     *
     * @return arrival time
     */
    @Override
    public String getArrivalTime() {
        return null;
    }

    /**
     * gets the departure time
     *
     * @return the departure time
     */
    @Override
    public String getDepartureTime() {
        return null;
    }

    /**
     * gets the origin's 3 letter airport code
     *
     * @return the 3 letter airport code
     */
    @Override
    public String getOrigin() {
        return null;
    }

    /**
     * gets the destination airport code
     *
     * @return the destination air port code 3 letters
     */
    @Override
    public String getDestination() {
        return null;
    }

    /**
     * gets the Flight number(s)
     *
     * @return a string of the flight numbers
     */
    @Override
    public String getFlightNumber() {
        return null;
    }
}
